package com.udacity.gradle.builditbigger.util;

public final class Constants {

  private static final String LOCAL_HOST_IP_ADDRESS = "10.0.2.2";
  private static final String PORT = "8080";
  public static final String ROOT_URL =
      "http://" + LOCAL_HOST_IP_ADDRESS + ":" + PORT + "/_ah/api/";

  private Constants() {}
}
