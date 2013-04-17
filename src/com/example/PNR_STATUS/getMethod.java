package com.example.PNR_STATUS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

public class getMethod {
public String getdatafrominternet() throws Exception, IOException,ClientProtocolException{
		BufferedReader in = null;
		String data = null;  // data retrieve will be return here!
		try{
			/*HttpClient client = new DefaultHttpClient();   // set http client
			URI website = new URI("http://paintformad.github.com");  // Universal Resource Identifier asks us for data to be retreive frm which website! 
			HttpGet request = new HttpGet(); // HttpGet Method is called to fetch data from website
			request.setURI(website); // request send
			HttpResponse response = client.execute(request); // its executes the request..
			System.out.print(response.getStatusLine().getStatusCode());
			InputStream a= response.getEntity().getContent();

			in = new BufferedReader(new InputStreamReader(a));   // taking input string in variable in*/
			
			 DefaultHttpClient httpClient = new DefaultHttpClient();
	            HttpPost httpPost = new HttpPost("http://paintformad.github.com");
	            HttpResponse httpResponse = httpClient.execute(httpPost);
	            HttpEntity httpEntity = httpResponse.getEntity();
	            data = EntityUtils.toString(httpEntity);
	            Log.d("response code", httpResponse.getStatusLine()
                        .getStatusCode() + ""); 
			StringBuffer sb = new StringBuffer("");
			String l = "";
			String nl = System.getProperty("line.separator");
			while((l = in.readLine()) != null) // runs till all data is fetched frm website!!
			{
				sb.append(l + nl);
			}
			in.close();
			data = sb.toString();
			return data;
		}
		 catch (Exception e)
		    {
		        Log.e("log_tag", "Error in http connection", e);
		    }
		finally{
			if(in != null){
				try{
					in.close();
					return data;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else
				System.out.print("No data is fetched!!!");
		}
		return data;
     }
@SuppressLint("NewApi")
InputStream downloadUrl(String url) {
	HttpURLConnection con = null;
	URL url1;
	InputStream is=null;
	try {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		url1 = new URL(url);
		con = (HttpURLConnection) url1.openConnection();
		con.setReadTimeout(10000 /* milliseconds */);
		con.setConnectTimeout(15000 /* milliseconds */);
		con.setRequestMethod("GET");
		con.setDoInput(true);
		con.addRequestProperty("Referer", "http://blog.dahanne.net");
		// Start the query
		con.connect();
		is = con.getInputStream();
	}catch (IOException e) {
                    //handle the exception !
		e.printStackTrace();
	}
	return is;

}
}
