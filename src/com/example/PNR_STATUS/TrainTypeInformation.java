package com.example.PNR_STATUS;
import com.example.checkyourpnrstatus.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class TrainTypeInformation extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.traintypeinformation);
		
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}