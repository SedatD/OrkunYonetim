package sedatdilmac.com.orkunyonetim.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import sedatdilmac.com.orkunyonetim.R;
import sedatdilmac.com.orkunyonetim.util.Utils;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView_sp_logo = findViewById(R.id.imageView_sp_logo);
        Utils.setAnimation(imageView_sp_logo, 1750);

        Thread mSplashThread;
        mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(2250);
                    }
                } catch (InterruptedException ex) {
                    Log.wtf(TAG, "catche düştü");
                } finally {
                    finish();
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
            }
        };

        mSplashThread.start();

    }

}
