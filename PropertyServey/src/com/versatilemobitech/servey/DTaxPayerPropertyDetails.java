package com.versatilemobitech.servey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DTaxPayerPropertyDetails extends Activity{
	Button btn_Next;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayerpropertydetails);
		
	btn_Next=(Button)findViewById(R.id.btn_next);
		
		btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),ETaxPayerMeasurementDetails.class);
				startActivity(i);
			}
		});
		
	}

}
