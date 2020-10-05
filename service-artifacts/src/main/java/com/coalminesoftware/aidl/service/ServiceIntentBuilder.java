package com.coalminesoftware.aidl.service;

import android.content.Intent;

public class ServiceIntentBuilder {
	public static Intent buildAudioPlayerBindIntent() {
		// The acton is from the Service's intent-filter declaration in the manifest
		return new Intent("com.coalminesoftware.aidl.service.AudioPlayerService.BIND")
				.setPackage("com.coalminesoftware.aidl.service");
	}
}
