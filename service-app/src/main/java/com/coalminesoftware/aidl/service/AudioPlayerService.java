package com.coalminesoftware.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AudioPlayerService extends Service {
	private AudioPlayerServiceImpl serviceImplementation = new AudioPlayerServiceImpl();

	@Override
	public IBinder onBind(Intent intent) {
		return serviceImplementation;
	}
}
