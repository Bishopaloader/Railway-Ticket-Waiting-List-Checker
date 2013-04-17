package com.example.PNR_STATUS;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	
	String classes[] = {"Check PNR Status","Train Schedule","Train Rules","View Codes","Train Type Information","International Tourist"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_expandable_list_item_1, classes));		// for making list    
		// <data type>(class name,how menu will look,array name)
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		System.out.print("here");
		super.onListItemClick(l, v, position, id);
		//String cheese = classes[position];
		try{
		//Class ourClass = Class.forName("com.example.checkyoutpnrstatus." + classes[position]);
		//Toast.makeText(getApplicationContext(), cheese, Toast.LENGTH_LONG);
			if(classes[position] == "Check PNR Status"){
		Intent ourIntent = new Intent(Menu.this,MainActivity.class );
		startActivity(ourIntent);}
			if(classes[position] == "Train Schedule"){
		Intent ourIntent = new Intent(Menu.this,TrainSchedule.class );
		startActivity(ourIntent);}
			if(classes[position] == "Train Rules"){
				Intent ourIntent = new Intent(Menu.this,TrainRules.class );
				startActivity(ourIntent);}
			if(classes[position] == "View Codes"){
				Intent ourIntent = new Intent(Menu.this,ViewCodes.class );
				startActivity(ourIntent);}
			if(classes[position] == "Train Type Information"){
				Intent ourIntent = new Intent(Menu.this,TrainTypeInformation.class );
				startActivity(ourIntent);}
			if(classes[position] == "International Tourist"){
				Intent ourIntent = new Intent(Menu.this,InternationalTourist.class );
				startActivity(ourIntent);}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
