package builditbigger.gradle.udacity.com.and_jokes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

  private static final String KEY_JOKE = "JOKE";

  public static void start(Context context, String joke) {
      Intent starter = new Intent(context, JokeDisplayActivity.class);
      starter.putExtra(KEY_JOKE, joke);
      context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke_display);

    String joke = getIntent().getStringExtra(KEY_JOKE);

    TextView tvJoke = findViewById(R.id.tv_joke);
    tvJoke.setText(joke);
  }
}
