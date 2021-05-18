package ir.sharifimohammad.hafez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

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

        MyDatabase myDatabase = new MyDatabase(FalActivity.this);
        myDatabase.createDataBase();

        Random random = new Random();
        int randomNumber = random.nextInt((400 - 1) + 1 + 1 );

        SQLiteDatabase db = myDatabase.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM ashar WHERE ID =" + randomNumber, null);
        if (cursor.moveToNext()){
            falTextView.setText(cursor.getString(cursor.getColumnIndex("sher")));
            tafsirTextView.setText(cursor.getString(cursor.getColumnIndex("mani")));
        }
        cursor.close();
        db.close();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FalActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}