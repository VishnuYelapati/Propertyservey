package com.versatilemobitech.servey;

import com.versatilemobitech.adapter.DatabaseHandler;
import com.versatilemobitech.bean.ProperyBean;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HServeyorDetails extends BaserActinbBar{
	
	
	EditText et_sName;
	EditText et_saddress;
	EditText et_sId;
	EditText et_sDate;
	
	EditText et_aaName;
	EditText et_aaDesig;
	EditText et_aaDate;
	Button btn_submit;
	DatabaseHandler dbHandler;
	ProperyBean pbean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.serveyerdetails);
		dbHandler=new DatabaseHandler(getApplicationContext());
		
		et_sName=(EditText)findViewById(R.id.et_servyerName);
		et_saddress=(EditText)findViewById(R.id.et_serveyoradd);
		et_sId=(EditText)findViewById(R.id.et_serveyorId);
		et_sDate=(EditText)findViewById(R.id.et_state);
		 pbean=ProperyBean.getInstance();
		
		System.out.println("result:"+ProperyBean.getInstance().getDataProvidedBy());
		
		et_aaName=(EditText)findViewById(R.id.et_attastauthName);
		et_aaDesig=(EditText)findViewById(R.id.et_attastauthdisig);
		et_aaDate=(EditText)findViewById(R.id.et_attastauthdate);
		
		btn_submit=(Button)findViewById(R.id.btn_submit);
		
		btn_submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				ProperyBean pbean=ProperyBean.getInstance();
				
			Intent i=new Intent(getApplicationContext(),MyServey.class);
			startActivity(i);
			}
		});
		
		
	}
}
