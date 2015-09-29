package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.versatilemobitech.adapter.DatabaseHandler;
import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.util.CaptureSignature;

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
	
	public static final int SIGNATURE_ACTIVITY = 1;
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

				
				if(et_sName.getText().toString().length()>0 && et_saddress.getText().toString().length()>0 && et_sId.getText().toString().length()>0 && et_aaDate.getText().toString().length()>0
						&& et_aaName.getText().toString().length()>0 && et_aaDate.getText().toString().length()>0)
				{
                     ProperyBean bean=ProperyBean.getInstance();
                     bean.setNameOfSurveyor(et_sName.getText().toString());
                     bean.setSurveyorAddress(et_saddress.getText().toString());
                     bean.setIdCodeOfSurveyor(et_sId.getText().toString());
                     bean.setDate_Surveyor(et_aaDate.getText().toString());
                     bean.setNameOfAttestingAuthority(et_aaName.getText().toString());
                     bean.setDesignationOfAttestingAuthority(et_aaDesig.getText().toString());
                     bean.setDate_Attesting(et_aaDate.getText().toString());
				Intent intent = new Intent(HServeyorDetails.this, CaptureSignature.class); 
                startActivityForResult(intent,SIGNATURE_ACTIVITY);
				}
				else{
					if(et_sName.getText().toString().length()==0)
						et_sName.setError("Invalide");
					Toast.makeText(getApplicationContext(), "Please provide required fields", Toast.LENGTH_LONG).show();
				}
			
			}
		});
		
		
	}
	

	 protected void onActivityResult(int requestCode, int resultCode, Intent data)
	    {
	        switch(requestCode) {
	        case SIGNATURE_ACTIVITY: 
	            if (resultCode == RESULT_OK) {
	 
	                Bundle bundle = data.getExtras();
	                String status  = bundle.getString("status");
	                String path=bundle.getString("path");
	                if(status.equalsIgnoreCase("done")){
	                    Toast toast = Toast.makeText(this, "Signature captured.", Toast.LENGTH_SHORT);
	                    toast.setGravity(Gravity.TOP, 105, 50);
	                    toast.show();
	                    
	                    ProperyBean.getInstance().setSignatureImgPath(path);
	                    
	                    finish();
	                	
	                   
	                    
	        			Intent i=new Intent(getApplicationContext(),MyServey.class);
	        			startActivity(i);
	                }
	            }
	            break;
	        }
	 
	    }  
}
