package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class GTaxPayerUsePropertyDetails extends BaserActinbBar{


	private CheckBox  PrivateHospitalClinic=null;
	private CheckBox  Residentialcum_commercial=null;
	private CheckBox  BeautyParlour=null;
	private CheckBox  PrivateOffice=null;
	private CheckBox  MarriageGardenHall=null;
	private CheckBox  HotelRestaurant=null;
	private CheckBox SemiGovtInstitute=null;
	private CheckBox CentralGovPropertyOffice=null;
	private CheckBox School=null;
	private CheckBox ProfessionalCollege=null;
	private CheckBox CompletelyReligiousProperty=null;
	private CheckBox SituatedInRicoArea=null;
	private CheckBox ExempteUnderclause107Act2009=null;
	private CheckBox DharmashalaOfCommunitySociety=null;
	private CheckBox CinemahallMultiplex=null;
	private CheckBox GeneralDegreeCollege=null;
	private CheckBox CoachingInstitute=null;
	private CheckBox OutOfRicoIndustries=null;


	private String StateGovtPropertyOffice="";
	private String ReligiousPlace="";
	private String Residential="";
	//private String  Others=""; //Other valu only when accept click okay

	private EditText otherEdit=null;

	private EditText et_udtaxaccunt=null;
	private EditText et_payleasetaxaccountno=null;
	Button btn_next,btn_prev;




	private RadioGroup SewerConnection=null;
	private RadioGroup  LightConnection=null;
	private RadioGroup  Boring=null;
	private RadioGroup  Parking=null;
	private RadioGroup  AdvertisementHoarding=null;
	private RadioGroup  StreetLight=null;
	private RadioGroup  PrivateToilet=null;
	private RadioGroup 	 MobileTower=null;
	private RadioGroup 	 OpenToilet=null;
	private RadioGroup 	 WhetherpayUdTax=null;
	private RadioGroup 	 WhetherpayLeaseTax=null;
	private RadioGroup 	 SewerLine=null;
	private RadioGroup  SepticTank=null;
	private RadioGroup 	 PipedWaterConnection=null;
	private RadioGroup 	 FireFightingSystem=null;
	private EditText et_advhoarding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.usepropertydetails);

		/*****
		 * Please write size of Board if more than 7x1 Sq.ft MIssing
		 * 
		 */

		PrivateHospitalClinic=(CheckBox)findViewById(R.id.chk_priHospital);
		Residentialcum_commercial=(CheckBox)findViewById(R.id.chk_resi_cum_commercial);
		BeautyParlour=(CheckBox)findViewById(R.id.chk_beautypaurler);
		PrivateOffice=(CheckBox)findViewById(R.id.chk_priHospital);
		MarriageGardenHall=(CheckBox)findViewById(R.id.chk_marriagehall);
		HotelRestaurant=(CheckBox)findViewById(R.id.chk_restaurent);
		SemiGovtInstitute=(CheckBox)findViewById(R.id.chk_semigov);
		CentralGovPropertyOffice=(CheckBox)findViewById(R.id.chk_govtprtyoffice);
		School=(CheckBox)findViewById(R.id.chk_school);
		ProfessionalCollege=(CheckBox)findViewById(R.id.chk_proffcollege);
		CompletelyReligiousProperty=(CheckBox)findViewById(R.id.chk_religiousproperty);
		SituatedInRicoArea=(CheckBox)findViewById(R.id.chk_rechoarea);
		ExempteUnderclause107Act2009=(CheckBox)findViewById(R.id.chk_underclause);
		DharmashalaOfCommunitySociety=(CheckBox)findViewById(R.id.chk_commsocty);
		CinemahallMultiplex=(CheckBox)findViewById(R.id.chk_cinimahall);
		GeneralDegreeCollege=(CheckBox)findViewById(R.id.chk_gendegreecollege);
		CoachingInstitute=(CheckBox)findViewById(R.id.chk_coaching_inst);
		OutOfRicoIndustries=(CheckBox)findViewById(R.id.chk_ricoindustreesoutof);
		otherEdit=(EditText)findViewById(R.id.et_others);
		btn_next=(Button)findViewById(R.id.btn_next);
		btn_prev=(Button)findViewById(R.id.btn_prev);




		//Radio buttons
		SewerConnection=(RadioGroup)findViewById(R.id.myRadioGroup);
		LightConnection=(RadioGroup)findViewById(R.id.rg_lightconn);
		Boring=(RadioGroup)findViewById(R.id.rg_boring);
		Parking=(RadioGroup)findViewById(R.id.rg_parking);
		AdvertisementHoarding=(RadioGroup)findViewById(R.id.rg_advhoarding);
		StreetLight=(RadioGroup)findViewById(R.id.rg_streetlight);
		PrivateToilet=(RadioGroup)findViewById(R.id.rg_pvttoilet);
		MobileTower=(RadioGroup)findViewById(R.id.rg_mobtower);
		OpenToilet=(RadioGroup)findViewById(R.id.rg_opentoilet);
		WhetherpayUdTax=(RadioGroup)findViewById(R.id.rg_payudtax);
		WhetherpayLeaseTax=(RadioGroup)findViewById(R.id.rg_payleasetax);
		SewerLine=(RadioGroup)findViewById(R.id.rg_sewerline);
		SepticTank=(RadioGroup)findViewById(R.id.rg_septictank);
		PipedWaterConnection=(RadioGroup)findViewById(R.id.rg_pipedwater);
		FireFightingSystem=(RadioGroup)findViewById(R.id.rg_firefittingsystem);


		et_udtaxaccunt=(EditText)findViewById(R.id.et_udtaxaccunt);
		et_payleasetaxaccountno=(EditText)findViewById(R.id.et_payleasetaxaccountno);
		et_advhoarding=(EditText)findViewById(R.id.et_advhoarding);

		Spinner stateGovt_spinner=(Spinner)findViewById(R.id.spn_govmentproperty);
		Spinner religious_spinner=(Spinner)findViewById(R.id.spn_religiousplace);
		Spinner residential_spinner=(Spinner)findViewById(R.id.spn_residential);
		
		
		
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i=new Intent(getApplicationContext(),HServeyorDetails.class);
				startActivity(i);
				
			}
		});
		btn_prev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
				
			}
		});
		
		

		stateGovt_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				StateGovtPropertyOffice=parent.getItemAtPosition(position).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		religious_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				ReligiousPlace=parent.getItemAtPosition(position).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});


		residential_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				Residential=parent.getItemAtPosition(position).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});



	}
	

}
