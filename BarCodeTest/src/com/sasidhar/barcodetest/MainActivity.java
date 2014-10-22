package com.sasidhar.barcodetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	Button bt;
	TextView tv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bt = (Button)findViewById(R.id.start_reading);
        tv = (TextView)findViewById(R.id.resultView);
        
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(intent, 0);
			}
		});
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
           if (resultCode == RESULT_OK) {
               
              String contents = intent.getStringExtra("SCAN_RESULT");
              String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
           
              // Handle successful scan
              tv.setText("Result : "+contents);
              
              Toast.makeText(getApplicationContext(), "Result : "+contents+" Format : "+format, Toast.LENGTH_LONG).show();
                                        
           } else if (resultCode == RESULT_CANCELED) {
              // Handle cancel
              Log.i("App","Scan unsuccessful");
              Toast.makeText(getApplicationContext(), "Scan Unsuccessful", Toast.LENGTH_LONG).show();
           }
      }
   }
}
