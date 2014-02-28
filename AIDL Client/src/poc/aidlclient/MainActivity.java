package poc.aidlclient;

import poc.aidlservice.IGuidanceService;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.TextView;

public class MainActivity extends Activity {
	private IGuidanceService guidanceService = null;
	private TextView label;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		label = (TextView)findViewById(R.id.label);
		label.setText("test");

		connectToService();
	}

	private void connectToService() {
		ServiceConnection connection = new ServiceConnection() {
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				guidanceService = IGuidanceService.Stub.asInterface(service);

				try {
					guidanceService.resetGuidance();
					label.setText("Reset guidance: "+guidanceService.markB(true));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onServiceDisconnected(ComponentName name) {
				guidanceService = null;
			}
		};

		// The return value of bindSearch() only returns whether or not binding was successfully
		// initiated, based on things like whether you have the necessary permissions.  Binding is
		// not complete until the onServiceConnected() method above is called.
		// 
		// Binding is asynchronous.  However, the call to onServiceConnected() does NOT get called
		// on another thread - the process that calls it gets queued up to run on the same thread
		// that called bindService().  Because of that, you cannot block the thread that called
		// bindService() until onServiceConnected() is called.
		// 
		// From a best practices standpoint, blocking the thread is ill advised, so not being able
		// to do it may not seem like a bad thing.  However, I see it as a pretty considerable
		// shortcoming because there ARE cases where it's necessary to take action using a service
		// before continuing.  Not all services are for trivial media player apps, where you can
		// just disable the controls until binding happens. :)
		boolean connected = bindService(new Intent("poc.GUIDANCE"), connection, Context.BIND_AUTO_CREATE);

		System.out.println("Connection process initiated: "+connected);
	}
}


