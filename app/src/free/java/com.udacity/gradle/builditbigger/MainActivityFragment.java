package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.data.JokeAsyncTask;

import builditbigger.gradle.udacity.com.and_jokes.JokeDisplayActivity;

public class MainActivityFragment extends Fragment {

  private ProgressDialog dialog;

  public MainActivityFragment() {}

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_main, container, false);

    AdView mAdView = root.findViewById(R.id.adView);
    // Create an ad request. Check logcat output for the hashed device ID to
    // get test ads on a physical device. e.g.
    // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
    AdRequest adRequest =
        new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
    mAdView.loadAd(adRequest);
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    Button btnTellJoke = view.findViewById(R.id.btn_tell_joke);

    btnTellJoke.setOnClickListener(
        v -> {
          dialog = new ProgressDialog(getContext());
          dialog.setIndeterminate(false);
          dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
          dialog.setCancelable(true);
          dialog.show();

          new JokeAsyncTask(
                  output -> {
                    dialog.dismiss();

                    JokeDisplayActivity.start(getContext(), output);
                  })
              .execute();
        });
  }
}
