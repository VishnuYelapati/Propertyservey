package com.versatilemobitech.servey;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.versatilemobitech.bean.NameBean;
import com.versatilemobitech.bean.ProperyBean;

public class BTaxPayerAddDetailsActivity  extends BaserActinbBar{

	EditText et_name,et_fathername,et_age;
	 String profissinal="";
	Button btn_addview,btn_Next,btn_Prev;
	LinearLayout ll_container;
	public static ArrayList<NameBean> beanList=new ArrayList<NameBean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayeradddetails);
		ll_container=(LinearLayout)findViewById(R.id.container);
		et_name=(EditText)findViewById(R.id.et_name);
		et_fathername=(EditText)findViewById(R.id.et_fathername);
		et_age=(EditText)findViewById(R.id.et_age);
		Spinner spn_profession=(Spinner)findViewById(R.id.sp_profession);
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_Prev=(Button)findViewById(R.id.btn_prev);
 

		btn_Next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				ArrayList<NameBean> tempNames=new ArrayList<NameBean>();
				
				
				if(et_age.getText().toString().length()>0 && et_name.getText().toString().length()>0 && et_fathername.getText().toString().length()>0 &&  profissinal.length()>0)
				{
				NameBean firstBean=new NameBean();
				
				firstBean.setAge(et_age.getText().toString());
				firstBean.setName(et_name.getText().toString());
				firstBean.setNameOfFatherorHusband(et_fathername.getText().toString());
				firstBean.setProfession(profissinal);
				
				tempNames.add(firstBean);
				//beanList.add(firstBean);
				
				boolean isValid=true;
					NameBean nameBean=null;
					for (int i = 0; i < ll_container.getChildCount(); i++) {
						//Values

						nameBean=new NameBean();
						View addView=ll_container.getChildAt(i);


						TextView etxtName = (TextView)addView.findViewById(R.id.etxt_name);
						TextView etxtfatherName = (TextView)addView.findViewById(R.id.etxt_fatherhusbandname);
						TextView etxtAge = (TextView)addView.findViewById(R.id.etxt_age);
						Spinner etxtProffesion = (Spinner)addView.findViewById(R.id.sp_profession);

						
						if(etxtName.getText().toString().length()>0 && etxtfatherName.getText().toString().length()>0 && etxtAge.getText().toString().length()>0 && etxtProffesion.getSelectedItem().toString().length()>0  )

						{
						nameBean.setName(etxtName.getText().toString());
						nameBean.setAge(etxtAge.getText().toString());
						nameBean.setNameOfFatherorHusband(etxtfatherName.getText().toString());
						nameBean.setProfession(etxtProffesion.getSelectedItem().toString());
						
						//beanList.add(nameBean);
						tempNames.add(nameBean);
						}
						else{
							
							isValid=false;
							if(etxtName.getText().toString().length()<=0)
								etxtName.setError("Invalide");
							
							tempNames.clear();
						}
					}

					if(isValid)
					{
						beanList.addAll(tempNames);
					ProperyBean.getInstance().setNameList(beanList);
					Intent i=new Intent(getApplicationContext(),CTaxPayerAddressDetails.class);
					startActivity(i);
				}
					else{
						Toast.makeText(getApplicationContext(), "Please provide required values", Toast.LENGTH_LONG).show();
					}
				
				}
				else{
					Toast.makeText(getApplicationContext(), "Please provide required values", Toast.LENGTH_LONG).show();
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

		
		spn_profession.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				profissinal=arg0.getItemAtPosition(arg2).toString();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});


		btn_addview=(Button)findViewById(R.id.btn_addview);
		btn_addview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				LayoutInflater layoutInflater =
						(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View addView = layoutInflater.inflate(R.layout.taxpayerdetails_addrow, null);
				 
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
