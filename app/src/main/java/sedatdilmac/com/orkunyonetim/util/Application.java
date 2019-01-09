package sedatdilmac.com.orkunyonetim.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onesignal.OneSignal;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by SD
 * on 25.07.2018.
 */

public class Application extends android.app.Application {

    private static Application mInstance;
    private RequestQueue mRequestQueue;
    private SharedPreferences mPreferences;

    public static synchronized Application get() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseAnalytics.getInstance(this);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        mInstance = this;
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRequestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public SharedPreferences getPreferences() {
        return mPreferences;
    }

    public SharedPreferences.Editor getPreferencesEditor() {
        return mPreferences.edit();
    }

}
