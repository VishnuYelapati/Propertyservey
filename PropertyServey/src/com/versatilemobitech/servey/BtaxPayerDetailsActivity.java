package com.versatilemobitech.servey;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

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
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.bean.NameBean;
import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.bean.SpinnerItemBean;

public class BtaxPayerDetailsActivity  extends BaserActinbBar{
	
	EditText et_name,et_fathername,et_age;
	Spinner spn_profession;
	Button btn_addview,btn_Next,btn_Prev;
	LinearLayout ll_container;
	View addView ;
	//String[] strArr_dp={"<- Service ->","Business","HouseWife","Other"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayer_addrow);
		ll_container=(LinearLayout)findViewById(R.id.container);
		et_name=(EditText)findViewById(R.id.et_name);
		et_fathername=(EditText)findViewById(R.id.et_fatherhusbandname);
		et_age=(EditText)findViewById(R.id.et_age);
		spn_profession=(Spinner)findViewById(R.id.spn_proffesion);
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_Prev=(Button)findViewById(R.id.btn_prev);
		Resources res = getResources(); 
		
		 ArrayList<SpinnerItemBean> arr_itemBean=new ArrayList<SpinnerItemBean>();

		
		 for(int i=0;i<getResources().getStringArray(R.array.str_arr_profession).length;i++){

				SpinnerItemBean sib=new SpinnerItemBean();
				sib.setStrItem(getResources().getStringArray(R.array.str_arr_profession)[i]);
				arr_itemBean.add(sib);
			}
		 
		CustomAdapter adapter = new CustomAdapter(getApplicationContext(), R.layout.spinner_rows,arr_itemBean,res);
		
     
//	spn_profession.setAdapter(adapter);
		
	btn_Next.setOnClickListener(new OnClickListener() {
		     
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			NameBean bean=null;
			ArrayList<NameBean> beanArray=new ArrayList<NameBean>();
			for (int i = 0; i <ll_container.getChildCount(); i++) {
				bean=new NameBean();
				 View chiled = ll_container.getChildAt(i);
				    TextView etxtName = (TextView)chiled.findViewById(R.id.etxt_name);
				    TextView etxtfatherName = (TextView)chiled.findViewById(R.id.etxt_fatherhusbandname);
				    TextView etxtAge = (TextView)chiled.findViewById(R.id.etxt_age);
				    TextView etxtProffesion = (TextView)chiled.findViewById(R.id.etxt_proffesion);
				    
				    bean.setAge(etxtAge.getText().toString());
				    bean.setProfession(etxtProffesion.getText().toString());
				    bean.setName(etxtName.getText().toString());
				    bean.setNameOfFatherorHusband(etxtfatherName.getText().toString());
				    beanArray.add(bean);
			}
			ProperyBean.getInstance().setNameList(beanArray);
			Intent i=new Intent(getApplicationContext(),CTaxPayerAddressDetails.class);
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
					      addView = layoutInflater.inflate(R.layout.taxpayerdetails, null);
					  /*  TextView etxtName = (TextView)addView.findViewById(R.id.etxt_name);
					    TextView etxtfatherName = (TextView)addView.findViewById(R.id.etxt_fatherhusbandname);
					    TextView etxtAge = (TextView)addView.findViewById(R.id.etxt_age);
					    TextView etxtProffesion = (TextView)addView.findViewById(R.id.etxt_proffesion);*/
					    Button buttonRemove = (Button)addView.findViewById(R.id.btn_removeview);
					    buttonRemove.setTag(addView);
					    buttonRemove.setOnClickListener(new OnClickListener(){
					     @Override
					     public void onClick(View v) {
					      ((LinearLayout)addView.getParent()).removeView((View)v.getTag());
					     }});
					    LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
					    ll_container.addView(addView,params);
					    System.out.println("TEST Adeedddddddddd");
					   }});
		
	}
}
