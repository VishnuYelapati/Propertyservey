package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DTaxPayerPropertyDetails extends BaserActinbBar{
	Button btn_Next,btn_Prev;
	
	EditText PlotORFlatNo=null;
	String Zone="";
	EditText ColonyName=null;
	EditText City=null;
	EditText state=null;
	EditText NameOfBuildin_Post=null;
	String DetailsOfOwnership="";
	EditText WhetherConstructionOnPlot_lenth=null;
	EditText WhetherConstructionOnPlot_width=null;
	String TypeOfConstruction=null;
	EditText NameOfLaneOrRoad=null;
	String Ward ="";
	EditText Landmark=null;
	EditText District=null;
	EditText NameOfBuilding_Pre=null;
	EditText MultistoreyBuildigNameofBuilding=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayerpropertydetails);
		
		
		  PlotORFlatNo=(EditText)findViewById(R.id.et_flatno);
		  ColonyName=(EditText)findViewById(R.id.et_colonyname);
		  City=(EditText)findViewById(R.id.et_city);
		  state=(EditText)findViewById(R.id.et_state);
		  NameOfBuildin_Post=(EditText)findViewById(R.id.et_buildingdesc);
		  //DetailsOfOwnership=(EditText)findViewById(R.id.et_);
		  WhetherConstructionOnPlot_lenth=(EditText)findViewById(R.id.et_lengthfeets);
		  WhetherConstructionOnPlot_width=(EditText)findViewById(R.id.et_widthfeets);
		  //TypeOfConstruction=null;
		  NameOfLaneOrRoad=(EditText)findViewById(R.id.et_laneroad);
		  //Ward =(EditText)findViewById(R.id.et_w);
		  Landmark=(EditText)findViewById(R.id.et_landmark);
		  District=(EditText)findViewById(R.id.et_district);
		  NameOfBuilding_Pre=(EditText)findViewById(R.id.et_prebuildingname);
		  MultistoreyBuildigNameofBuilding=(EditText)findViewById(R.id.et_postbuildingname);
		  btn_Next=(Button)findViewById(R.id.btn_next);
		  btn_Prev=(Button)findViewById(R.id.btn_prev);
		  btn_Next.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i=new Intent(getApplicationContext(),ETaxPayerMeasurementDetails.class);
					startActivity(i);
				}
			});
		
		  btn_Prev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});
		  
		  Spinner ward_spinner=(Spinner)findViewById(R.id.spn_wardno);
		
		  ward_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Ward=parent.getItemAtPosition(position).toString();
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
			});
		  Spinner type_of_construction_spinner=(Spinner)findViewById(R.id.spn_constype);
		  type_of_construction_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				TypeOfConstruction=parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		  Spinner zone_spinner=(Spinner)findViewById(R.id.spn_zone);
		  Spinner details_of_owner_spinner=(Spinner)findViewById(R.id.spn_ownershipsdetails);
		  details_of_owner_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				DetailsOfOwnership=parent.getItemAtPosition(position).toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
			zone_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Zone=parent.getItemAtPosition(position).toString();
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
			});
	btn_Next=(Button)findViewById(R.id.btn_next);
	
		
		btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				Intent i=new Intent(getApplicationContext(),ETaxPayerMeasurementDetails.class);
				startActivity(i);
			}
		});
		
	}

}
