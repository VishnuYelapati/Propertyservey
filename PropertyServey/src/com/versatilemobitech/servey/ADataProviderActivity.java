package com.versatilemobitech.servey;

import java.util.ArrayList;

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
import com.versatilemobitech.bean.SpinnerItemBean;

public class ADataProviderActivity extends BaserActinbBar{

	private Button btn_save;
	public static ArrayList<SpinnerItemBean> arr_itemBean=new ArrayList<SpinnerItemBean>();

	private EditText mRelationshipOfOwner=null;
	private EditText MobileNo=null;
	private EditText EmailID=null;
	private EditText NameOfDataProvider=null;
	private EditText OwnerUIDNumber=null;
	private EditText BasicPhoneNo=null;
	private String dataProvider="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dataproviderdetails);
		btn_save=(Button)findViewById(R.id.btn_save);
		Spinner mSpn_dataProvider=(Spinner)findViewById(R.id.spn_Dataprovder);

		mRelationshipOfOwner=(EditText)findViewById(R.id.et_relationowner);
		MobileNo=(EditText)findViewById(R.id.et_mobileno);
		EmailID=(EditText)findViewById(R.id.et_emaild);
		NameOfDataProvider=(EditText)findViewById(R.id.et_provider_name);
		OwnerUIDNumber=(EditText)findViewById(R.id.et_uidno);
		BasicPhoneNo=(EditText)findViewById(R.id.et_basicphone);

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

				if(!dataProvider.equals("") && mRelationshipOfOwner.getText().toString().length()>0 && MobileNo.getText().toString().length()>0 &&   NameOfDataProvider.getText().toString().length()>0 && OwnerUIDNumber.getText().toString().length()>0 &&  BasicPhoneNo.getText().toString().length()>0)
				{
					Intent i=new Intent(getApplicationContext(),BtaxPayerDetailsActivity.class);
					startActivity(i);
				}
				else{

					if(mRelationshipOfOwner.getText().toString().length()<=0)
						mRelationshipOfOwner.setError("Invalid value");

					if(MobileNo.getText().toString().length()>0)
						MobileNo.setError("Invalid value");

					if( NameOfDataProvider.getText().toString().length()>0 )
						NameOfDataProvider.setError("Invalid value");
					if(OwnerUIDNumber.getText().toString().length()>0 &&  BasicPhoneNo.getText().toString().length()>0)
						OwnerUIDNumber.setError("Invalid value");
				}
			}
		});



	}

}
