package io.saeid.libgdx.androidleak;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @author Saeed Masoumi (s-masoumi@live.com)
 */
public class LeakApplication extends Application {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        LeakApplication application = (LeakApplication) context.getApplicationContext();
        return application.refWatcher;
    }

}
