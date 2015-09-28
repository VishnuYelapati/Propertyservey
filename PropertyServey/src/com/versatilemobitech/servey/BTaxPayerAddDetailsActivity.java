package com.versatilemobitech.servey;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.bean.NameBean;
import com.versatilemobitech.bean.ProperyBean;

public class BTaxPayerAddDetailsActivity  extends BaserActinbBar{
	
	EditText et_name,et_fathername,et_age;
	Spinner spn_profession;
	Button btn_addview,btn_Next,btn_Prev;
	LinearLayout ll_container;
	ArrayList<NameBean> beanList=new ArrayList<NameBean>();
	
	//String[] strArr_dp={"<- Service ->","Business","HouseWife","Other"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayeradddetails);
		ll_container=(LinearLayout)findViewById(R.id.container);
		et_name=(EditText)findViewById(R.id.et_name);
		et_fathername=(EditText)findViewById(R.id.et_fatherhusbandname);
		et_age=(EditText)findViewById(R.id.et_age);
		spn_profession=(Spinner)findViewById(R.id.spn_proffesion);
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_Prev=(Button)findViewById(R.id.btn_prev);
		Resources res = getResources(); 
		CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.spinner_rows, ADataProviderActivity.arr_itemBean,res);
		
    
		
	spn_profession.setAdapter(adapter);
		
	btn_Next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			NameBean nameBean=null;
			for (int i = 0; i < ll_container.getChildCount(); i++) {
				//Values
				
				nameBean=new NameBean();
				View addView=ll_container.getChildAt(i);
				
				
				TextView etxtName = (TextView)addView.findViewById(R.id.etxt_name);
			    TextView etxtfatherName = (TextView)addView.findViewById(R.id.etxt_fatherhusbandname);
			    TextView etxtAge = (TextView)addView.findViewById(R.id.etxt_age);
			    TextView etxtProffesion = (TextView)addView.findViewById(R.id.etxt_proffesion);
				
			    System.out.println("TEST Values :"+etxtName.getText().toString());
			    
			    nameBean.setName(etxtName.getText().toString());
			    nameBean.setAge(etxtAge.getText().toString());
			    nameBean.setNameOfFatherorHusband(etxtfatherName.getText().toString());
			    nameBean.setProfession(etxtProffesion.getText().toString());
			    
			    beanList.add(nameBean);
			}
			
			ProperyBean.getInstance().setNameList(beanList);
			/*Intent i=new Intent(getApplicationContext(),GTaxPayerUsePropertyDetails.class);
			startActivity(i);*/
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
					    final View addView = layoutInflater.inflate(R.layout.taxpayerdetails_addrow, null);
					    TextView etxtName = (TextView)addView.findViewById(R.id.etxt_name);
					    TextView etxtfatherName = (TextView)addView.findViewById(R.id.etxt_fatherhusbandname);
					    TextView etxtAge = (TextView)addView.findViewById(R.id.etxt_age);
					    TextView etxtProffesion = (TextView)addView.findViewById(R.id.etxt_proffesion);
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
