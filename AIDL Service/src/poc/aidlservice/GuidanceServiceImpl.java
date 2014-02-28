package poc.aidlservice;

import android.os.IBinder;
import android.os.RemoteException;

public class GuidanceServiceImpl extends IGuidanceService.Stub implements IGuidanceService {
	@Override
	public IBinder asBinder() {
		return this;
	}

	@Override
	public void resetGuidance() throws RemoteException {
		System.out.println("Guidance reset");
	}

	@Override
	public boolean markB(boolean completeSwath) throws RemoteException {
		System.out.println("Marking B");

		return false;
	}
}
