package com.udacity.gradle.builditbigger.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class JokeGenerator {

  private final List<String> jokes;
  private final Random random;

  public static JokeGenerator create() {
    return new JokeGenerator();
  }

  private JokeGenerator() {
    jokes = new ArrayList<>();
    jokes.add("A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"");
    jokes.add("Q: How many prolog programmers does it take to change a lightbulb? A: Yes.");
    jokes.add("Why do Java developers wear glasses? Because they can't C#");
    random = new Random();
  }

  public String getRandomJoke() {
    return jokes.get(random.nextInt(jokes.size()));
  }
}
