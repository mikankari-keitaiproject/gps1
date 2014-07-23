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
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			
			// provider�ɂ�network,passive,gps������炵��
			Log.d("test", "provider: " + provider + ", status: " + status);
			
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			
			Log.d("test", provider + " enabled.");
			
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			
			Log.d("test", provider + " disabled.");

		}
		
		@Override
		public void onLocationChanged(Location location) {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			
			Log.d("test", "���x: " + location.getAccuracy());
			Log.d("test", "�W��: " + location.getAltitude());
			Log.d("test", "�ܓx: " + location.getLatitude());
			Log.d("test", "�o�x: " + location.getLongitude());

			TextView textview1 = (TextView)findViewById(R.id.textview1);
			textview1.setText("�ܓx\n" + location.getLatitude());
			TextView textview2 = (TextView)findViewById(R.id.textview2);
			textview2.setText("�o�x\n" + location.getLongitude());
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStart();
		
		TextView textview1 = (TextView)findViewById(R.id.textview1);
		textview1.setText("�ܓx\n" + "���ʒ�...");
		TextView textview2 = (TextView)findViewById(R.id.textview2);
		textview2.setText("�o�x\n" + "���ʒ�...");

		// GPS���炩Wifi���炩
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, mLocationListener);
//		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, mLocationListener);
		
//		Log.d("test", "" + mLocationManager.getAllProviders().get(0));
//		Log.d("test", "" + mLocationManager.getLastKnownLocation("gps"));
	}

	@Override
	protected void onStop() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStop();
		
		mLocationManager.removeUpdates(mLocationListener);
	}
	

}
