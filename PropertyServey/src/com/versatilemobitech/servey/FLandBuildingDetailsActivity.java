package com.versatilemobitech.servey;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.versatilemobitech.bean.BuildingDetails;
import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.bean.SpinnerItemBean;

public class FLandBuildingDetailsActivity  extends BaserActinbBar{

	EditText et_areaSqft,et_areyards;
	Spinner spn_landinuse,spn_floordetails;
	Button btn_addview,btn_Next,btn_Prev;
	LinearLayout ll_container;
	String strSpnFloor;
	String strSpnLand;
	//String[] strArr_dp={"<- Service ->","Business","HouseWife","Other"};
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landbuildingdetails);
	
		ll_container=(LinearLayout)findViewById(R.id.container);
		et_areaSqft=(EditText)findViewById(R.id.et_totalareasft);
		et_areyards=(EditText)findViewById(R.id.et_totalareainyards);
		spn_floordetails=(Spinner)findViewById(R.id.spn_detailsfloor);
		spn_landinuse=(Spinner)findViewById(R.id.spn_landuse);
		
		
		
		et_areaSqft.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(arg1)
				{
					
				}
				else{
					if(et_areaSqft.getText().toString().length()>0)
					{
						et_areyards.setText(""+(Float.parseFloat(et_areaSqft.getText().toString())/9));
					}
				}
			}
		});
		
		
		et_areyards.setOnFocusChangeListener(new OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if(hasFocus)
				{
					
				}
				else{
					if(et_areyards.getText().toString().length()>0)
					{
						et_areaSqft.setText(""+(Float.parseFloat(et_areyards.getText().toString())*9));
					}
				}
				
			}
		});
	
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_Prev=(Button)findViewById(R.id.btn_prev);
		
		 
		btn_Next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if(et_areaSqft.getText().toString().length()>0 && et_areyards.getText().toString().length()>0 && !spn_floordetails.getSelectedItem().toString().equalsIgnoreCase("Select") && !spn_landinuse.getSelectedItem().toString().equalsIgnoreCase("Select")){

				ArrayList<BuildingDetails> arr_bld=new ArrayList<BuildingDetails>();
					BuildingDetails initBean=null;
					
					initBean=new BuildingDetails();
					
					
					initBean.setTotalAreaInSqFt(et_areaSqft.getText().toString());

					initBean.setTotalAreaInYard(et_areyards.getText().toString());
					//initBean.setLandUse( spn_landinuse.getSelectedItem().toString());
					initBean.setLandUse( ""+spn_landinuse.getSelectedItemPosition());
					//initBean.setDetailsoffloor(spn_floordetails.getSelectedItem().toString());
					initBean.setDetailsoffloor(""+spn_floordetails.getSelectedItemPosition());
					arr_bld.add(initBean);
					
				if(ll_container!=null)
				{
					BuildingDetails buildingDetails=null;
					for (int i = 0; i <ll_container.getChildCount(); i++) {

						buildingDetails=new BuildingDetails();
						View addView=ll_container.getChildAt(i);
					
						EditText totalAraeSFT = (EditText)addView.findViewById(R.id.et_totalareasft);
						EditText totalAraeYard = (EditText)addView.findViewById(R.id.et_totalareainyards);
						Spinner landUse = (Spinner)addView.findViewById(R.id.spn_landuse);

						Spinner floordetails = (Spinner)addView.findViewById(R.id.spn_detailsfloor);
		
						buildingDetails.setTotalAreaInSqFt(totalAraeSFT.getText().toString());

						buildingDetails.setTotalAreaInYard(totalAraeYard.getText().toString());
						buildingDetails.setLandUse(""+ landUse.getSelectedItemPosition());
						buildingDetails.setDetailsoffloor(""+floordetails.getSelectedItemPosition());
						
						arr_bld.add(buildingDetails);
					}
					
					ProperyBean.getInstance().setBulidList(arr_bld);
					
				}
				Intent i=new Intent(getApplicationContext(),GTaxPayerUsePropertyDetails.class);
				startActivity(i);
			}else{
				
				Toast.makeText(getApplicationContext(), "Please enter All Fields", Toast.LENGTH_LONG).show();
			}
				
			}
		});
		btn_Prev.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});



		btn_addview=(Button)findViewById(R.id.btn_addview);
		btn_addview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LayoutInflater layoutInflater = 
						(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View addView = layoutInflater.inflate(R.layout.landbuilding_addrow, null);

				final EditText totalAraeSFT = (EditText)addView.findViewById(R.id.et_totalareasft);
				final EditText totalAraeYard = (EditText)addView.findViewById(R.id.et_totalareainyards);
				
				
				totalAraeSFT.setOnFocusChangeListener(new OnFocusChangeListener() {
					
					@Override
					public void onFocusChange(View arg0, boolean arg1) {
						// TODO Auto-generated method stub
						if(arg1)
						{
							
						}
						else{
							if(totalAraeSFT.getText().toString().length()>0)
							{
								totalAraeYard.setText(""+(Float.parseFloat(totalAraeSFT.getText().toString())/9));
							}
						}
					}
				});
				
				
				totalAraeYard.setOnFocusChangeListener(new OnFocusChangeListener() {
					
					@Override
					public void onFocusChange(View v, boolean hasFocus) {

						if(hasFocus)
						{
							
						}
						else{
							if(totalAraeYard.getText().toString().length()>0)
							{
								totalAraeSFT.setText(""+(Float.parseFloat(totalAraeYard.getText().toString())*9));
							}
						}
						
					}
				});
				
				
				
				
				Button buttonRemove = (Button)addView.findViewById(R.id.btn_removeview);
				buttonRemove.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View v) {
						((LinearLayout)addView.getParent()).removeView(addView);
					}});

				ll_container.addView(addView);
			}});

	}

}
