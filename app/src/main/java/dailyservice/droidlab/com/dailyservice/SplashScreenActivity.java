package dailyservice.droidlab.com.dailyservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;


public class SplashScreenActivity extends Activity {

	private final Handler mHandler = new Handler();

	private static final int duration = 500;

	private final Runnable mPendingLauncherRunnable = new Runnable() {
		@Override
		public void run() {

			final Intent intent = new Intent(SplashScreenActivity.this,
					MainActivity.class);
			startActivity(intent);

			finish();
		}
	};

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// AdManager.setTestDevices( new String[] {AdManager.TEST_EMULATOR} );
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.splash_screen);

		mHandler.postDelayed(mPendingLauncherRunnable, duration);

	}


}
