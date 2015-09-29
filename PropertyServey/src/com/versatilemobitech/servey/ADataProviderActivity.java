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

				dataProvider="";

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

					//Here we need to same all data in Bean class


					ProperyBean pbean=ProperyBean.getInstance();
					pbean.setDataProvidedBy(dataProvider);
					pbean.setNameOfDataProvider(NameOfDataProvider.getText().toString());
					pbean.setRelationshipOfOwner(mRelationshipOfOwner.getText().toString());
					pbean.setMobileNo(MobileNo.getText().toString());
					pbean.setEmailID(EmailID.getText().toString());
					pbean.setOwnerUIDNumber(OwnerUIDNumber.getText().toString());
					pbean.setBasicPhoneNo(BasicPhoneNo.getText().toString());
//09-29 05:37:52.364: E/SQLiteDatabase(18597): Error inserting Total_Plot_Area_in_yard=ckgog Others_write_1_or_0_here= Mobile_Tower_Write_1_if_applicable_else_0=null Surveyor_Address=ckgog Hotel_Restaurent_Write_1_if_applicable_else_0=null Out_of_RICO_industries_Write_1_if_applicable_else_0=ckgog Data_Providers_Basic_Phone_No=5656 Street_Light_Write_1_if_applicable_else_0=ckgog Date= Boring_Write_1_if_applicable_else_0=null Name_No_of_building_post= Owner_Permanent_Address=ifig Open_Toilet_Write_1_if_applicable_else_0=null Name_of_Lane_Road= Designation_of_the_Attesting_Authority= Vacant_Area_in_yard=ckgog School_Write_1_if_applicable_else_0=ckgog Plinth_Area_in_yard=ckgog Owner_Basic_Phone_No= Owner_Mobile_No= Type_of_construction=ckgog FormID=RJ/JPR/ZONE1/WARD1/Tablet1/Seq1 Vacant_Area_in_sqft=ckgog Completely_Religious_Property_Write_1_if_applicable_else_0=null Light_Connection_Write_1_if_applicable_else_0=null Septic_Tank_Write_1_if_applicable_else_0=ckgog City=Jaipur Name_No_of_building_pre= Name_of_the_Surveyor= Central_Govt_Propertey_Office_Write_1_if_applicable_else_0=null Parking_Write_1_if_applicable_else_0=null Beauty_Parlour_Write_1_if_applicable_else_0=null Residential_cum_commercial_Write_1_if_applicable_else_0=ckgog Owner_UID_Number_Minimun_12_digits=vjfgi Owner_Address_for_Communication=ckgog Total_Area_in_sqft=ckgog Plot_Flat_Shop_No=ckgog District=Jaipur Professional_College_Write_1_if_applicable_else_0=ckgog Piped_Water_Connection_Write_1_if_applicable_else_0=ckgog Hospital_Clinic_Write_1_if_applicable_else_0=ckgog Data_Providers_Mobile_No=5.5-6 Excempted_under_clause_107_of_RM_Act_2009_Write_1_if_applicable_else_0=null Residential=ckgog Relationship_with_owner=ckgog Sewer_Connection_Write_1_if_applicable_else_0=ckgog Details_of_ownership= Semi_Govt_Institute_Write_1_if_applicable_else_0=ckgog Religious_Place=ckgog Building_Id_like_1_b_2_b_3_b_so_on=null Total_Area_in_Yard=ckgog Colony_Name= Toilet_Write_1_if_applicable_else_0=ckgog Name_of_the_Attesting_Authority= Situateed_in_RICO_Area_Write_1_if_applicable_else_0=ckgog Office_Write_1_if_applicable_else_0=ckgog ID_code_of_the_surveyor= =ckgog Data_Provider_Name=jfuf Total_Plot_Area_in_Sqft=ckgog Plinth_Area_in_Sqft=ckgog Marriage_Garden_Hall_Write_1_if_applicable_else_0=null Data_Provided_By=Service State=ckgog If_construction_on_plot_is_yes_length_in_sqft= No_of_Floors= Owner_mail_Id=cjcj Data_Providers_mail_Id=fufjf Fire_Fighting_SystemWrite_1_if_applicable_else_0=null State_Govt_Property_office=ckgog Cinema_Hall_Multiplex_Write_1_if_applicable_else_0=null Sewer_Line_Write_1_if_applicable_else_0=ckgog
//09-29 05:37:52.364: E/SQLiteDatabase(18597): android.database.sqlite.SQLiteException: near ",": syntax error (code 1): , while compiling: INSERT INTO SERVEY_DATA(Total_Plot_Area_in_yard,Others_write_1_or_0_here,Mobile_Tower_Write_1_if_applicable_else_0,Surveyor_Address,Hotel_Restaurent_Write_1_if_applicable_else_0,Out_of_RICO_industries_Write_1_if_applicable_else_0,Data_Providers_Basic_Phone_No,Street_Light_Write_1_if_applicable_else_0,Date,Boring_Write_1_if_applicable_else_0,Name_No_of_building_post,Owner_Permanent_Address,Open_Toilet_Write_1_if_applicable_else_0,Name_of_Lane_Road,Designation_of_the_Attesting_Authority,Vacant_Area_in_yard,School_Write_1_if_applicable_else_0,Plinth_Area_in_yard,Owner_Basic_Phone_No,Owner_Mobile_No,Type_of_construction,FormID,Vacant_Area_in_sqft,Completely_Religious_Property_Write_1_if_applicable_else_0,Light_Connection_Write_1_if_applicable_else_0,Septic_Tank_Write_1_if_applicable_else_0,City,Name_No_of_building_pre,Name_of_the_Surveyor,Central_Govt_Propertey_Office_Write_1_if_applicable_else_0,Parking_Write_1_if_applicable_else_0,Beauty_Parlour_Write_1_if_applicable_else_0,Residential_cum_commercial_Write_1_if_applicable_else_0,Owner_UID_Number_Minimun_12_digits,Owner_Address_for_Communication,Total_Area_in_sqft,Plot_Flat_Shop_No,District,Professional_College_Write_1_if_applicable_else_0,Piped_Water_Connection_Write_1_if_applicable_else_0,Hospital_Clinic_Write_1_if_applicable_else_0,Data_Providers_Mobile_No,Excempted_under_clause_107_of_RM_Act_2009_Write_1_if_applicable_


					Intent i=new Intent(getApplicationContext(),BTaxPayerAddDetailsActivity.class);
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
