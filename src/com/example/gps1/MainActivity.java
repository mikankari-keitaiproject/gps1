package com.example.gps1;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private LocationManager mLocationManager;
	private LocationListener mLocationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO 自動生成されたメソッド・スタブ
			
			// providerにはnetwork,passive,gpsがあるらしい
			Log.d("test", "provider: " + provider + ", status: " + status);
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO 自動生成されたメソッド・スタブ
			
			Log.d("test", provider + " enabled.");
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO 自動生成されたメソッド・スタブ
			
			Log.d("test", provider + " disabled.");

		}
		
		@Override
		public void onLocationChanged(Location location) {
			// TODO 自動生成されたメソッド・スタブ
			
			Log.d("test", "精度: " + location.getAccuracy());
			Log.d("test", "標高: " + location.getAltitude());
			Log.d("test", "緯度: " + location.getLatitude());
			Log.d("test", "経度: " + location.getLongitude());

			TextView textview1 = (TextView)findViewById(R.id.textview1);
			textview1.setText("緯度\n" + location.getLatitude());
			TextView textview2 = (TextView)findViewById(R.id.textview2);
			textview2.setText("経度\n" + location.getLongitude());
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				

	}

	@Override
	protected void onStart() {
		// TODO 自動生成されたメソッド・スタブ
		super.onStart();
		
		TextView textview1 = (TextView)findViewById(R.id.textview1);
		textview1.setText("緯度\n" + "測位中...");
		TextView textview2 = (TextView)findViewById(R.id.textview2);
		textview2.setText("経度\n" + "測位中...");

		// GPSからかWifiからか
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
//		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, mLocationListener);
		
//		Log.d("test", "" + mLocationManager.getAllProviders().get(0));
//		Log.d("test", "" + mLocationManager.getLastKnownLocation("gps"));
	}

	@Override
	protected void onStop() {
		// TODO 自動生成されたメソッド・スタブ
		super.onStop();
		
		mLocationManager.removeUpdates(mLocationListener);
	}
	

}
