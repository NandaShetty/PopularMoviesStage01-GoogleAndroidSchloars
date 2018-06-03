package stageonepopmovies.udacity.com.popularmoviesstageone;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

public class MovieApplication extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

    }

    public static Context getAppContext() {
        return MovieApplication.context;
    }


}
