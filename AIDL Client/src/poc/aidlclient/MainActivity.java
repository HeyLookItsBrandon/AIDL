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

		boolean connected = bindService(new Intent("poc.GUIDANCE"), connection, Context.BIND_AUTO_CREATE);
		System.out.println("Connection process initiated: "+connected);
	}
}


