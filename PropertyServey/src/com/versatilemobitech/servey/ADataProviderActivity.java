package com.versatilemobitech.servey;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.bean.SpinnerItemBean;

public class ADataProviderActivity extends BaserActinbBar{
	
	Button btn_save;
	Spinner spn_dataProvider;
	String[] strArr_dp={"<- Service ->","Business","HouseWife","Other"};
	public static ArrayList<SpinnerItemBean> arr_itemBean=new ArrayList<SpinnerItemBean>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dataproviderdetails);
		btn_save=(Button)findViewById(R.id.btn_save);
		spn_dataProvider=(Spinner)findViewById(R.id.spn_Dataprovder);
		
	  
         
		for(int i=0;i<getResources().getStringArray(R.array.str_arr_profession).length;i++){
			
			SpinnerItemBean sib=new SpinnerItemBean();
			sib.setStrItem(getResources().getStringArray(R.array.str_arr_profession)[i]);
			arr_itemBean.add(sib);
		}
		Resources res = getResources(); 
		CustomAdapter adapter = new CustomAdapter(ADataProviderActivity.this, R.layout.spinner_rows, arr_itemBean,res);
		
     
        spn_dataProvider.setAdapter(adapter);
		
		btn_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),BtaxPayerDetailsActivity.class);
				startActivity(i);
			}
		});
		
		
		
	}

}
