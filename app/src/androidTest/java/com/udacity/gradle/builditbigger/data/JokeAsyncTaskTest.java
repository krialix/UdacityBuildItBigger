package com.udacity.gradle.builditbigger.data;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskTest {

  @Test
  public void testJokeFetched() throws Exception {
    assertTrue(true);

    CountDownLatch countDownLatch = new CountDownLatch(1);

    new JokeAsyncTask(
            output -> {
              assertNotNull(output);
              countDownLatch.countDown();
            })
        .execute();
    countDownLatch.await();
  }
}
