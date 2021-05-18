package ir.sharifimohammad.hafez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FalActivity extends AppCompatActivity {

    TextView falTextView, tafsirTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fal);

        falTextView = findViewById(R.id.falTextView);
        tafsirTextView = findViewById(R.id.tafsirTextView);

        falTextView.setTypeface(App.typeface);
        tafsirTextView.setTypeface(App.typeface);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FalActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}