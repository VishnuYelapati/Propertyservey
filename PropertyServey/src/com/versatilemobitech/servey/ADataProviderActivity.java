package com.versatilemobitech.servey;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.ContentValues;
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

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.adapter.DatabaseHandler;
import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.bean.SpinnerItemBean;

public class ADataProviderActivity extends BaserActinbBar{

	private Button btn_save;
	public static ArrayList<SpinnerItemBean> arr_itemBean=new ArrayList<SpinnerItemBean>();
	
	public static ArrayList<ProperyBean> arr_PB=new ArrayList<ProperyBean>();
	
	String outFilePath;

	private EditText mRelationshipOfOwner=null;
	private EditText MobileNo=null;
	private EditText EmailID=null;
	private EditText NameOfDataProvider=null;
	private EditText OwnerUIDNumber=null;
	private EditText BasicPhoneNo=null;
	private String dataProvider="";
	String toDay_DATE="";
	Spinner mSpn_dataProvider;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dataproviderdetails);
		btn_save=(Button)findViewById(R.id.btn_save);
		 mSpn_dataProvider=(Spinner)findViewById(R.id.spn_Dataprovder);
		
		ProperyBean pb=ProperyBean.getInstance();
		

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

				dataProvider=((SpinnerItemBean)parent.getItemAtPosition(position)).getStrItem();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});


		for(int i=0;i<getResources().getStringArray(R.array.str_arr_profession).length;i++){

			SpinnerItemBean sib=new SpinnerItemBean();
			sib.setStrItem(getResources().getStringArray(R.array.str_arr_profession)[i]);
			arr_itemBean.add(sib);
		}
		Resources res = getResources(); 
		CustomAdapter adapter = new CustomAdapter(ADataProviderActivity.this, R.layout.spinner_rows, arr_itemBean,res);


		mSpn_dataProvider.setAdapter(adapter);
		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				
				ProperyBean pb_model=new ProperyBean();
				
			/*	private EditText mRelationshipOfOwner=null;
				private EditText MobileNo=null;
				private EditText EmailID=null;
				private EditText NameOfDataProvider=null;
				private EditText OwnerUIDNumber=null;
				private EditText BasicPhoneNo=null;*/
				/*+ dataProvidedBy 	+ " TEXT," 
				+ relationshipOfOwner 	+ " TEXT,"
				+ EmailID 	+ " TEXT," 
				+ mobileNo 	+ " TEXT," 
				+ NameOfDataProvider	+ " TEXT," 
				+ OwnerUIDNumber 	+ " TEXT," 
				+ BasicPhoneNo 		+ " TEXT,"
				+ CREATED_DATE + " DATE"
			*/
			/*DatabaseHandler dbhandler=new DatabaseHandler(getApplicationContext());
			ContentValues cv=new ContentValues();
			cv.put(dbhandler.dataProvidedBy, NameOfDataProvider.getText().toString());
			cv.put(dbhandler.relationshipOfOwner, mRelationshipOfOwner.getText().toString());
			cv.put(dbhandler.mobileNo, MobileNo.getText().toString());
			cv.put(dbhandler.EmailID, EmailID.getText().toString());
			cv.put(dbhandler.OwnerUIDNumber, OwnerUIDNumber.getText().toString());
			cv.put(dbhandler.BasicPhoneNo, BasicPhoneNo.getText().toString());
		//	cv.put(dbhandler.CREATED_DATE, toDay_DATE);
			dbhandler.insert(dbhandler.TABLE_servey_Data, cv);*/
			
				ProperyBean pbean=ProperyBean.getInstance();
				pbean.setDataProvidedBy(NameOfDataProvider.getText().toString());
				pbean.setRelationshipOfOwner(mRelationshipOfOwner.getText().toString());
				pbean.setMobileNo(MobileNo.getText().toString());
				pbean.setEmailID(EmailID.getText().toString());
				pbean.setOwnerUIDNumber(OwnerUIDNumber.getText().toString());
				pbean.setBasicPhoneNo(BasicPhoneNo.getText().toString());
				

				arr_PB.add(pbean);
			
				if(!dataProvider.equals("") && mRelationshipOfOwner.getText().toString().length()>0 && MobileNo.getText().toString().length()>0 &&   NameOfDataProvider.getText().toString().length()>0 && OwnerUIDNumber.getText().toString().length()>0 &&  BasicPhoneNo.getText().toString().length()>0)
				{
					
					//Here we need to same all data in Bean class
					
					
					Intent i=new Intent(getApplicationContext(),BtaxPayerDetailsActivity.class);
					startActivity(i);
				}
				else{

					if(mRelationshipOfOwner.getText().toString().length()<=0)
						mRelationshipOfOwner.setError("Invalid value");

					if(MobileNo.getText().toString().length()<=0)
						MobileNo.setError("Invalid value");

					if( NameOfDataProvider.getText().toString().length()<=0 )
						NameOfDataProvider.setError("Invalid value");
					if(OwnerUIDNumber.getText().toString().length()<=0)
						OwnerUIDNumber.setError("Invalid value");
					if(  BasicPhoneNo.getText().toString().length()<=0)
						BasicPhoneNo.setError("Invalid value");
				}
			
			
			
			}
		});



	}
	
	
	



	

}
