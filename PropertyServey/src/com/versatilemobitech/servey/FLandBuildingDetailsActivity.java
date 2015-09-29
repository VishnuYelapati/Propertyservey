package com.versatilemobitech.servey;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.versatilemobitech.bean.BuildingDetails;
import com.versatilemobitech.bean.ProperyBean;

public class FLandBuildingDetailsActivity  extends BaserActinbBar{

	EditText et_name,et_fathername,et_age;
	Spinner spn_profession;
	Button btn_addview,btn_Next,btn_Prev;
	LinearLayout ll_container;
	//String[] strArr_dp={"<- Service ->","Business","HouseWife","Other"};
	
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.landbuildingdetails);
		ll_container=(LinearLayout)findViewById(R.id.container);
		et_name=(EditText)findViewById(R.id.et_name);
		et_fathername=(EditText)findViewById(R.id.et_fatherhusbandname);
		et_age=(EditText)findViewById(R.id.et_age);
		spn_profession=(Spinner)findViewById(R.id.spn_proffesion);
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_Prev=(Button)findViewById(R.id.btn_prev);
		/*Resources res = getResources(); 
		CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.spinner_rows, ADataProviderActivity.arr_itemBean,res);
		 */

		//	spn_profession.setAdapter(adapter);

		btn_Next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {


				if(ll_container!=null)
				{
					ArrayList<BuildingDetails> arr_bld=new ArrayList<BuildingDetails>();
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
						buildingDetails.setLandUse( landUse.getSelectedItem().toString());
						buildingDetails.setDetailsoffloor(floordetails.getSelectedItem().toString());
						
						arr_bld.add(buildingDetails);
					}
					
					ProperyBean.getInstance().setBulidList(arr_bld);
					
				}
				Intent i=new Intent(getApplicationContext(),GTaxPayerUsePropertyDetails.class);
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



		btn_addview=(Button)findViewById(R.id.btn_addview);
		btn_addview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LayoutInflater layoutInflater = 
						(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View addView = layoutInflater.inflate(R.layout.landbuilding_addrow, null);

				//    etxtName.setText(et_name.getText().toString());
				//   etxtfatherName.setText(et_fathername.getText().toString());
				//   etxtAge.setText(et_age.getText().toString());
				//  etxtProffesion.setText(spn_profession.getSelectedItem().toString());
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
