

package com.dating.uber;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;

import com.dating.uber.core.Constants;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

/**
 * uber dating application
 */
public class BootstrapApplication extends Application {

    private static BootstrapApplication instance;

    /**
     * Create main application
     */
    public BootstrapApplication() {
    }

    /**
     * Create main application
     *
     * @param context
     */
    public BootstrapApplication(final Context context) {
        this();
        attachBaseContext(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        // Perform injection
        Injector.init(getRootModule(), this);
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, Constants.PARSE_APP_ID, "WXEgM4pUJGU6xhhpO9FUwrIYVFHl0eqD1BjY2Rf6");
        ParseFacebookUtils.initialize(getString(R.string.facebook_app_id));
        currentUser = ParseUser.getCurrentUser();

    }

    private Object getRootModule() {
        return new RootModule();
    }


    /**
     * Create main application
     *
     * @param instrumentation
     */
    public BootstrapApplication(final Instrumentation instrumentation) {
        this();
        attachBaseContext(instrumentation.getTargetContext());
    }

    public static BootstrapApplication getInstance() {
        return instance;
    }
}
