package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.versatilemobitech.bean.ProperyBean;

public class CTaxPayerAddressDetails extends BaserActinbBar{
	private Button btn_Next;
	
	private EditText AddressforCommunication=null;
	private EditText MobileNo=null;
	private EditText EmailID=null;
	private EditText PermanentAddress=null;
	private EditText BasicPhoneNo=null;
	ProperyBean pbean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayeraddressdetails);
		 pbean=ProperyBean.getInstance();
		
		btn_Next=(Button)findViewById(R.id.btn_next);
		
		
		 AddressforCommunication=(EditText)findViewById(R.id.et_presentadd);
		  MobileNo=(EditText)findViewById(R.id.et_mobileno);
		  EmailID=(EditText)findViewById(R.id.et_email);
		 PermanentAddress=(EditText)findViewById(R.id.et_permadd);
		  BasicPhoneNo=(EditText)findViewById(R.id.et_basicphone);
		
		btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
		
				 
				if(AddressforCommunication.getText().toString().length()>0 && MobileNo.getText().toString().length()>0 &&  PermanentAddress.getText().toString().length()>0 && BasicPhoneNo.getText().toString().length()>0 )
				{
					pbean.setAddressforCommunication(AddressforCommunication.getText().toString());
					pbean.setMobileNo(MobileNo.getText().toString());
					pbean.setPermanentAddress(PermanentAddress.getText().toString());
					pbean.setBasicPhoneNo(BasicPhoneNo.getText().toString());
					pbean.setEmailID_Address(EmailID.getText().toString()); //added
					
					Intent i=new Intent(getApplicationContext(),DTaxPayerPropertyDetails.class);
					startActivity(i);
				}
				else{
					Toast.makeText(getApplicationContext(), "Please provide required fields.",Toast.LENGTH_LONG).show();
					
				}
			}
		});
	}

}
