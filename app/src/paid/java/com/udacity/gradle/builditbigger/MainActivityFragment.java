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

import com.udacity.gradle.builditbigger.data.JokeAsyncTask;

import builditbigger.gradle.udacity.com.and_jokes.JokeDisplayActivity;

public class MainActivityFragment extends Fragment {

  private ProgressDialog dialog;

  public MainActivityFragment() {}

  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_main, container, false);
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
