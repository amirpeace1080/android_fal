package ir.sharifimohammad.hafez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DB_NAME = "data.db";
    public static String DB_PATH;
    public static Context dbContext;

    SQLiteOpenHelper sqLiteOpenHelper;

    public MyDatabase(Context context) {
        super(context, DB_NAME, null, 1);
        this.dbContext = context;
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
    }

    public void createDataBase() {
        try {
            File dbDir = new File(DB_PATH);
            if (!dbDir.exists()) {
                dbDir.mkdir();
            }

            File dataBase = new File(dbDir, DB_NAME);
            if (!dataBase.exists()) {
                InputStream inputStream = dbContext.getAssets().open(DB_NAME);
                OutputStream outputStream = new FileOutputStream(DB_PATH + DB_NAME);
                byte[] bytes = new byte[1024 * 4];

                while (inputStream.read(bytes) != -1) {
                    outputStream.write(bytes);
                }
                outputStream.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
