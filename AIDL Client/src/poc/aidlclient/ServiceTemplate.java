package poc.aidlclient;

import android.content.ServiceConnection;
import android.os.IInterface;

public abstract class ServiceTemplate <ServiceInterface extends IInterface> {
	private ServiceConnection connection;

	public void doInTemplate(ServiceInterface service) {
		// If you have a service, use it to call Callback.useService().
		// Otherwise, connect and call Callback.useService() in onConnect().
	}

	public interface Callback<ServiceInterface> {
		void useService(ServiceInterface service);
	}
}


