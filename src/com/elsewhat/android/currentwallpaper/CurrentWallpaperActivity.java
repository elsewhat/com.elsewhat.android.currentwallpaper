package com.elsewhat.android.currentwallpaper;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class CurrentWallpaperActivity extends Activity {
	int REQUEST_WALLPAPER_CODE;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuChangeWallpaper:
			actionChangeWallpaper();
			return true;
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	private void actionChangeWallpaper() {
		Intent intent = new Intent();
		intent.setAction(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
		startActivityForResult(intent, REQUEST_WALLPAPER_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		if (resultCode == REQUEST_WALLPAPER_CODE) {
			// do something?
		}
	}

}