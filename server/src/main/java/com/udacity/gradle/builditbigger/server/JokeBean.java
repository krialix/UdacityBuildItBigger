package com.udacity.gradle.builditbigger.server;

class JokeBean {

  private final String joke;

  JokeBean(String joke) {
    this.joke = joke;
  }

  public String getJoke() {
    return joke;
  }
}
