package com.example.PNR_STATUS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.PNR_STATUS.MainActivity.PostDta;
import com.example.checkyourpnrstatus.R;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class PnrWebsite extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pnrwebsite);
		WebView ourwebsite = (WebView) findViewById(R.id.wvpnrwebsite);
		//ourwebsite.loadUrl("http://www.indianrail.gov.in/pnr_Enq.html");
	/*FileInputStream fis;
	      int length;
	      try {
			fis = openFileInput( PostDta.index );
		
	       byte[] buffer = new byte[1024];
	      
	      while ((length = fis.read(buffer)) != -1) {
	          fileContent.append(new String(buffer));
	      }} 
		catch (FileNotFoundException e1) {
	  		// TODO Auto-generated catch block
	  		e1.printStackTrace();
	  	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
*/
		ourwebsite.loadUrl("file:///data/data/com.example.checkyourpnrstatus/files/index1.html");
	}
}
