package com.udacity.gradle.builditbigger.data;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.server.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.util.Constants;

public final class JokeApiProvider {

  private static JokeApi jokeApi;

  public static JokeApi getJokeApi() {
    if (jokeApi == null) {
      JokeApi.Builder builder =
          new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
              .setRootUrl(Constants.ROOT_URL)
              .setGoogleClientRequestInitializer(
                  abstractGoogleClientRequest ->
                      abstractGoogleClientRequest.setDisableGZipContent(true));
      jokeApi = builder.build();
    }
    return jokeApi;
  }
}
