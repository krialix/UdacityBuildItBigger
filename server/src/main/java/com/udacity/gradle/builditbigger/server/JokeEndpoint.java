package com.udacity.gradle.builditbigger.server;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

@Api(
  name = "jokeApi",
  version = "v1",
  namespace =
      @ApiNamespace(
        ownerDomain = "server.builditbigger.gradle.udacity.com",
        ownerName = "server.builditbigger.gradle.udacity.com",
        packagePath = ""
      )
)
public class JokeEndpoint {

  private final JokeGenerator generator = JokeGenerator.create();

  @ApiMethod(name = "sayHi")
  public MyBean sayHi(@Named("name") String name) {
    MyBean response = new MyBean();
    response.setData("Hi, " + name);

    return response;
  }

  @ApiMethod(name = "getJoke")
  public JokeBean getRandomJoke() {
    return new JokeBean(generator.getRandomJoke());
  }
}
