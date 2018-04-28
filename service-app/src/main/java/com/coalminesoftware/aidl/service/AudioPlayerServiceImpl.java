package com.coalminesoftware.aidl.service;

import android.os.IBinder;
import android.os.RemoteException;

public class AudioPlayerServiceImpl extends IAudioPlayerService.Stub implements IAudioPlayerService {
	@Override
	public String getTrackTitle(int trackNumber) throws RemoteException {
		return "Your Favorite Song";
	}

	@Override
	public IBinder asBinder() {
		return this;
	}
}
