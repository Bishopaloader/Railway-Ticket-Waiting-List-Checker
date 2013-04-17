package com.example.PNR_STATUS;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.checkyourpnrstatus.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.SearchView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class httpdatatransfer extends Activity{
    
	TextView httpstuff;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = 
				new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpdatatransfer);
		//httpstuff = (TextView) findViewById(R.id.tvhttp);
 		//getMethod test = new getMethod();
		String returned;
		//String data;
		try{
			//returned = test.getdatafrominternet();
			Thread thread = new Thread()
			{
			    @Override
			    public void run() {
			        try {
			        	StringBuffer sb = new StringBuffer("");
			        	HttpURLConnection con = null;
			        	URL url1;
			        	InputStream is;
			        	String url="http://paintformad.github.com";
			            //Your code goes here
			        	url1 = new URL(url);
			    		con = (HttpURLConnection) url1.openConnection();
			    		con.setReadTimeout(10000 /* milliseconds */);
			    		con.setConnectTimeout(15000 /* milliseconds */);
			    		con.setRequestMethod("GET");
			    		con.setDoInput(true);
			    		// Start the query
			    		con.connect();
			    		is = con.getInputStream();
			    		BufferedReader in=new BufferedReader(new InputStreamReader(is));
			    		String l = "";
						String nl = System.getProperty("line.separator");
						while((l = in.readLine()) != null) // runs till all data is fetched frm website!!
						{
							sb.append(l + nl);
						}
						in.close();
						final String data = sb.toString();
						//final String data= "sdgeg gerhrhtrht tjtjtyjdyjyjytj tjtyjytjytj	yiuy	iuyiu	yui	uyuo	iyiuyo	yiuoyiuoyuyuyu	ioyiuyiuyu		yiuuyui	yiuy	iu	y";
						runOnUiThread(new Runnable() { //as thread can only access local variable so take a stuff out to global variable only this finction is there in Android 
						     public void run() {
						    	
						    	 //String data1 = data.substring(1,6);
						    	 httpstuff.setText(data);
						    	
						//stuff that updates ui
						    	 
						    	 
						    	

						    }
						});
			        }                               
			         catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			};

			thread.start(); 
			
			//InputStream a = test.downloadUrl("http://synapse.daiict.ac.in/cg/index.php");
			//returned = new BufferedReader(new InputStreamReader(a)).readLine();
			//httpstuff.setText(returned);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
