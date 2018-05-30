package com.udacity.gradle.builditbigger.data;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String> {

  private static final String TAG = "JokeAsyncTask";

  private final OnJokeReadyListener onJokeReadyListener;

  public JokeAsyncTask(OnJokeReadyListener onJokeReadyListener) {
    this.onJokeReadyListener = onJokeReadyListener;
  }

  @Override
  protected final String doInBackground(Void... params) {
    try {
      return JokeApiProvider.getJokeApi().getJoke().execute().getJoke();
    } catch (IOException e) {
      Log.e(TAG, "doInBackground: ", e);
      return null;
    }
  }

  @Override
  protected void onPostExecute(String result) {
    onJokeReadyListener.onJokeReady(result);
  }

  public interface OnJokeReadyListener {
    void onJokeReady(String output);
  }
}
