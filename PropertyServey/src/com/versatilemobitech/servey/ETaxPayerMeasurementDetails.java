package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ETaxPayerMeasurementDetails extends BaserActinbBar{
	
	
	Button btn_Next,btn_prev;
	
	private EditText TotalPlotArea=null;
	private EditText PlinthArea=null;
	private EditText VacantArea=null;
	private EditText TotalConstructionArea=null;

	// Yard
	private EditText TotalPlotYard=null;
	private EditText PlinthYard=null;
	private EditText VacantYard=null;
	private EditText TotalConstructionYard=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.measurementplotdetails);
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_prev=(Button)findViewById(R.id.btn_prev);
		TotalPlotArea=(EditText)findViewById(R.id.et_plotareainsqft);
		PlinthArea=(EditText)findViewById(R.id.et_plintareainsqft);
		PlinthYard=(EditText)findViewById(R.id.et_plintareainyards);
		VacantArea=(EditText)findViewById(R.id.et_vacantareainsqft);
		TotalConstructionArea=(EditText)findViewById(R.id.et_constructareainsqft);
		TotalConstructionYard=(EditText)findViewById(R.id.et_constructareainyards);
		TotalPlotYard=(EditText)findViewById(R.id.et_constructareainyards);
		VacantYard=(EditText)findViewById(R.id.et_vacantareainyards);
		
	btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),FLandBuildingDetailsActivity.class);
				startActivity(i);
			}
		});
	
	btn_prev.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			onBackPressed();
		}
	});
	}

}
