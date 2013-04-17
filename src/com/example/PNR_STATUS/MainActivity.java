package com.example.PNR_STATUS;

import java.io.FileOutputStream;
import java.io.IOException;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.checkyourpnrstatus.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Button clickhere;
	TextView tview;
	EditText etext;
	String a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	 clickhere = (Button) findViewById(R.id.click);
		tview = (TextView) findViewById(R.id.view);
		etext = (EditText) findViewById(R.id.text);
		
		
		clickhere.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				a=etext.getText().toString();
				System.out.println(a);
				 new PostDta().execute();
				 
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class PostDta extends AsyncTask<String, String, String>{
		
		private static final String index = "index1.html";
		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			if (etext.getText().length()>0)
		    {
		        // Create a new HttpClient and Post Header
		        DefaultHttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost("http://www.indianrail.gov.in/cgi_bin/inet_pnrstat_cgi.cgi");
		         


		        try {
		            // Add your data
		            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		            nameValuePairs.add(new BasicNameValuePair("lccp_pnrno1",etext.getText().toString()));
		            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		            // Execute HTTP Post Request
		            HttpResponse httpResponse = httpclient.execute(httppost);
		            HttpEntity httpEntity = httpResponse.getEntity();
		            String data = EntityUtils.toString(httpEntity);
		            Log.d("response code", httpResponse.getStatusLine()
	                        .getStatusCode() + "");
		            Log.e("is error", data);
		            
					FileOutputStream fos = openFileOutput(index, Context.MODE_PRIVATE);
					fos.write(data.getBytes());
					fos.close();
		            //setContentView(R.layout.httpdatatransfer);
		            //WebView ourwebsite = (WebView) findViewById(R.id.wvpnrwebsite);
		            //String yourhtmlpage = data;
		            //ourwebsite.loadData(yourhtmlpage, "text/html", null);
		            //ourwebsite.loadUrl("file:///D:/Project/paintformad.github.com/index.html");
		            Intent i = new Intent(MainActivity.this,com.example.PNR_STATUS.PnrWebsite.class); //intent is to start the other activity
		            startActivity(i);
		            //ourwebsite.loadDataWithBaseURL("notreal/", data, "text/htm", "utf-8",null);
					//WebView ourwebsite = (WebView) findViewById(R.id.wvpnrwebsite);
					//ourwebsite.loadUrl("http://www.indianrail.gov.in/pnr_Enq.html");
					//ourwebsite.loadUrl("file:///android_asset/index1.html");
		        } catch (Exception e) {
		            // TODO Auto-generated catch block
		        	
		        	Log.e("err", "asdasd ");
		        }
		    }
		    else
		    {
		        // display message if text fields are empty
		    	runOnUiThread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Toast.makeText(getBaseContext(),"Please enter the PNR Number!!",Toast.LENGTH_SHORT).show();
					}
		    	});
		        
		    }
			return null;
		}
		
	}

}