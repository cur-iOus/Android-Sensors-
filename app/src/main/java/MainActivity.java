package com.mycompany.myapp;

import android.app.*;
import android.content.*;
import android.hardware.*;
import android.os.*;
import android.view.inputmethod.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity 
{
	TextView textView, sensorCount;
	ScrollView scrollView;
	SensorManager sensorManager;
	List<Sensor> deviceSensors;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		sensorCount = (TextView) findViewById(R.id.totalSensorsID);
		textView = (TextView) findViewById(R.id.textViewID);
		scrollView = (ScrollView) findViewById(R.id.scrollViewID);
		sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		deviceSensors= sensorManager.getSensorList(Sensor.TYPE_ALL);
		
		//textView.setText(deviceSensors.toString()+";);)\n\n");
		printSensors();
		
    }

	private void printSensors()
	{
		int i = 0;
		for(Sensor sensor : deviceSensors)
		{
			String name = sensor.getName().toString();
			textView.setText(textView.getText()+"\n"+""+ ++i +". Sensor Name: \""+name+"\""+"\nType: "+sensor.getType()+"\nVendor: "+sensor.getVendor()+"\nVersion: "+sensor.getVersion()+"\nPower: "+sensor.getPower()+"\n");

		}
		
		if(i>0){
			sensorCount.setText("This device has total "+i+" sensors");
		}
		else{
			sensorCount.setText("No Sensor Detected");
		}
		
	}
}
