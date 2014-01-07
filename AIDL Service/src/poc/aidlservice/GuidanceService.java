package poc.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GuidanceService extends Service {
	private GuidanceServiceImpl serviceImplementation = new GuidanceServiceImpl(); 

	@Override
	public IBinder onBind(Intent intent) {
		return serviceImplementation;
	}
}


