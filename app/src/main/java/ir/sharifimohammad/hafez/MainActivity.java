package ir.sharifimohammad.hafez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mainButton;
    TextView mainTextView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = findViewById(R.id.mainButton);
        mainTextView = findViewById(R.id.mainTextView);
        progressBar = findViewById(R.id.progressBar);

        mainButton.setTypeface(App.typeface);
        mainTextView.setTypeface(App.typeface);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainTextView.setVisibility(View.INVISIBLE);
                mainButton.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(MainActivity.this, FalActivity.class);
                        startActivity(intent);

                    }
                }, 3000);
            }
        });
    }
}