package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.util.Utils;

public class CTaxPayerAddressDetails extends BaserActinbBar{
	private Button btn_Next,btn_prev;
	
	private EditText AddressforCommunication=null;
	private EditText MobileNo=null;
	private EditText EmailID=null;
	private EditText PermanentAddress=null;
	private EditText BasicPhoneNo=null;
	ProperyBean pbean;
	Utils utls;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayeraddressdetails);
		 pbean=ProperyBean.getInstance();
		 utls=new Utils();
		
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_prev=(Button)findViewById(R.id.btn_prev);
		
		 AddressforCommunication=(EditText)findViewById(R.id.et_presentadd);
		  MobileNo=(EditText)findViewById(R.id.et_mobileno);
		  EmailID=(EditText)findViewById(R.id.et_email);
		 PermanentAddress=(EditText)findViewById(R.id.et_permadd);
		  BasicPhoneNo=(EditText)findViewById(R.id.et_basicphone);
		  
		  AddressforCommunication.setText(pbean.getAddressforCommunication().toString());
		  MobileNo.setText(pbean.getMobileNo_Address().toString());
		  PermanentAddress.setText(pbean.getPermanentAddress().toString());
		  BasicPhoneNo.setText(pbean.getBasicPhoneNo_Address().toString());
		  EmailID.setText(pbean.getEmailID_Address().toString());
		btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
		
				 
				if(AddressforCommunication.getText().toString().length()>0  &&  PermanentAddress.getText().toString().length()>0 )
				{
					pbean.setAddressforCommunication(AddressforCommunication.getText().toString());
					pbean.setMobileNo_Address(MobileNo.getText().toString());
					pbean.setPermanentAddress(PermanentAddress.getText().toString());
					pbean.setBasicPhoneNo_Address(BasicPhoneNo.getText().toString());
					pbean.setEmailID_Address(EmailID.getText().toString()); //added
					
					Intent i=new Intent(getApplicationContext(),DTaxPayerPropertyDetails.class);
					startActivity(i);
				}
				else{
					Toast.makeText(getApplicationContext(), "Please provide required fields.",Toast.LENGTH_LONG).show();
					
				}
			}
		});
		
		btn_prev.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				pbean.setAddressforCommunication(AddressforCommunication.getText().toString());
				pbean.setMobileNo_Address(MobileNo.getText().toString());
				pbean.setPermanentAddress(PermanentAddress.getText().toString());
				pbean.setBasicPhoneNo_Address(BasicPhoneNo.getText().toString());
				pbean.setEmailID_Address(EmailID.getText().toString()); //added
				
				onBackPressed();
			}
		});
	}

}
