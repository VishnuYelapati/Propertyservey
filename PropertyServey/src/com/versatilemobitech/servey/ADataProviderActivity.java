package com.versatilemobitech.servey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.bean.SpinnerItemBean;
import com.versatilemobitech.util.Utils;

public class ADataProviderActivity extends BaserActinbBar{

	private Button btn_save;



	String outFilePath;

	private EditText mRelationshipOfOwner=null;
	private EditText MobileNo=null;
	private EditText EmailID=null;
	private EditText NameOfDataProvider=null;
	private EditText OwnerUIDNumber=null;
	private EditText BasicPhoneNo=null;
	private String dataProvider="0";
	String toDay_DATE="";
	Spinner mSpn_dataProvider;
	Utils utls;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dataproviderdetails);
		utls=new Utils();
		btn_save=(Button)findViewById(R.id.btn_save);
		mSpn_dataProvider=(Spinner)findViewById(R.id.spn_Dataprovder);

		mRelationshipOfOwner=(EditText)findViewById(R.id.et_relationowner);
		MobileNo=(EditText)findViewById(R.id.et_mobileno);
		EmailID=(EditText)findViewById(R.id.et_emaild);
		NameOfDataProvider=(EditText)findViewById(R.id.et_provider_name);
		OwnerUIDNumber=(EditText)findViewById(R.id.et_uidno);
		BasicPhoneNo=(EditText)findViewById(R.id.et_basicphone);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		toDay_DATE= sdf.format(new Date());
		mSpn_dataProvider.setOnItemSelectedListener(new OnItemSelectedListener() {



			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				dataProvider=""+position; 

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

				dataProvider="";

			}
		});

		ArrayList<SpinnerItemBean> arr_itemBean=new ArrayList<SpinnerItemBean>();


		for(int i=0;i<getResources().getStringArray(R.array.str_data_provide_by).length;i++){

			SpinnerItemBean sib=new SpinnerItemBean();
			sib.setStrItem(getResources().getStringArray(R.array.str_data_provide_by)[i]);
			arr_itemBean.add(sib);
		}
		Resources res = getResources(); 
		CustomAdapter adapter = new CustomAdapter(ADataProviderActivity.this, R.layout.spinner_rows, arr_itemBean,res);


		mSpn_dataProvider.setAdapter(adapter); 
		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if((!dataProvider.equals("")) &&!dataProvider.equals("0") &&  NameOfDataProvider.getText().toString().trim().length()>2 && mRelationshipOfOwner.getText().toString().trim().length()>2 )
				{
					ProperyBean pbean=ProperyBean.getInstance();
					pbean.setDataProvidedBy(dataProvider);
					pbean.setNameOfDataProvider(NameOfDataProvider.getText().toString());
					pbean.setRelationshipOfOwner(mRelationshipOfOwner.getText().toString());

					boolean mobile1=(MobileNo.getText().toString().length()>0)?(Utils.actualLength(MobileNo.getText().toString())==10):true;
					boolean mobile2=(BasicPhoneNo.getText().toString().length()>0)?(Utils.actualLength(BasicPhoneNo.getText().toString())==10):true;
					boolean uid=(OwnerUIDNumber.getText().toString().length()>0)?(Utils.actualLength(OwnerUIDNumber.getText().toString())==12):true;

					boolean emailValid= (EmailID.getText().toString().length()>0)?(Utils.isValidMail(EmailID.getText().toString())):true;
					if(!mobile1)
					{
						MobileNo.setError("Invalid");
					}
					if(!mobile2)
						BasicPhoneNo.setError("Invalid");

					if(!uid)
						OwnerUIDNumber.setError("Invalid");
					
					
					if(!emailValid)
						EmailID.setError("Invalid");
				 


					pbean.setMobileNo(MobileNo.getText().toString());
					pbean.setOwnerUIDNumber(OwnerUIDNumber.getText().toString());
					pbean.setBasicPhoneNo(BasicPhoneNo.getText().toString());

					pbean.setEmailID(EmailID.getText().toString());//EmailID.getText().toString()


					if(mobile1&&mobile2&&uid&&emailValid)
					{
						Intent i=new Intent(getApplicationContext(),BTaxPayerAddDetailsActivity.class);
						startActivity(i);
					}
					else{
						Toast.makeText(getApplicationContext(), "Please provide valid data!", Toast.LENGTH_LONG).show();
					}
				}
				else{

					if(mRelationshipOfOwner.getText().toString().length()<=0)
						mRelationshipOfOwner.setError("Invalid value");


					if( NameOfDataProvider.getText().toString().length()<=0 )
						NameOfDataProvider.setError("Invalid value");
					 if(dataProvider.equals("0"))
						Toast.makeText(getApplicationContext(), "Please select the data Provider", Toast.LENGTH_LONG).show();
					 
					 if(mRelationshipOfOwner.getText().toString().length()<=2)
						 mRelationshipOfOwner.setError("Invalid value");
					 
					 if(NameOfDataProvider.getText().toString().trim().length()<=2)
						 NameOfDataProvider.setError("Invalid value");
				}


			}
		});



	}

	
	



}
