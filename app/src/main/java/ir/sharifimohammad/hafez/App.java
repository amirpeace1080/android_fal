package ir.sharifimohammad.hafez;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

public class App extends Application {
    public Context context;
    public static Typeface typeface;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        typeface = Typeface.createFromAsset(context.getAssets(), "vazir.ttf");
    }


}
