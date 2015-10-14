package com.versatilemobitech.servey;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

import com.versatilemobitech.bean.ProperyBean;

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

	//private EditText et_udtaxaccunt=null;
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


		//et_udtaxaccunt=(EditText)findViewById(R.id.et_udtaxaccunt);
		et_payleasetaxaccountno=(EditText)findViewById(R.id.et_payleasetaxaccountno);
		et_advhoarding=(EditText)findViewById(R.id.et_advhoarding);

		Spinner stateGovt_spinner=(Spinner)findViewById(R.id.spn_govmentproperty);
		Spinner religious_spinner=(Spinner)findViewById(R.id.spn_religiousplace);
		Spinner residential_spinner=(Spinner)findViewById(R.id.spn_residential);
		
		//rb_others
		CheckBox rb_other=(CheckBox)findViewById(R.id.cb_others);
		
		rb_other.setOnClickListener(first_radio_listener);
		//et_advhoarding.setEnabled(false);
	
		otherEdit.setEnabled(false);
	
		AdvertisementHoarding.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				
				if(arg1==R.id.rb_adv_yes){
					et_advhoarding.setEnabled(true);
					et_advhoarding.setBackgroundResource(R.drawable.textfiled);
					
					//et_advhoarding.setBackgroundColor(Color.TRANSPARENT);
				}else if(arg1==R.id.rb_adv_no)
				{
					et_advhoarding.setText("");
					et_advhoarding.setEnabled(false);
					 et_advhoarding.setBackgroundResource(R.drawable.et_corner_shape_desabled);
				}
				
			}
		});
		
		WhetherpayLeaseTax.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				
				if(arg1==R.id.rb_paylease_yes){
					et_payleasetaxaccountno.setBackgroundResource(R.drawable.textfiled);
					et_payleasetaxaccountno.setEnabled(true);
				}else if(arg1==R.id.rb_paylease_no)
				{
					et_payleasetaxaccountno.setEnabled(false);
					et_payleasetaxaccountno.setBackgroundResource(R.drawable.et_corner_shape_desabled);
				}
				
			}
		});
		
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				ProperyBean  bean=ProperyBean.getInstance();
				bean.setPrivateHospitalClinic((PrivateHospitalClinic.isChecked()==true)?"1":"0");
				
				bean.setResidentialcum_commercial((Residentialcum_commercial.isChecked()==true)?"1":"0");
				
				bean.setBeautyParlour((BeautyParlour.isChecked()==true)?"1":"0");
				bean.setPrivateOffice((PrivateOffice.isChecked()==true)?"1":"0");
				bean.setMarriageGardenHall((MarriageGardenHall.isChecked()==true)?"1":"0");
				bean.setHotelRestaurant((HotelRestaurant.isChecked()==true)?"1":"0");
				bean.setSemiGovtInstitute((SemiGovtInstitute.isChecked()==true)?"1":"0");
				bean.setCentralGovPropertyOffice((CentralGovPropertyOffice.isChecked()==true)?"1":"0");
				bean.setSchool((School.isChecked()==true)?"1":"0");
				bean.setProfessionalCollege((ProfessionalCollege.isChecked()==true)?"1":"0");
				bean.setCompletelyReligiousProperty((CompletelyReligiousProperty.isChecked()==true)?"1":"0");
				bean.setSituatedInRicoArea((SituatedInRicoArea.isChecked()==true)?"1":"0");
				bean.setExempteUnderclause107Act2009((ExempteUnderclause107Act2009.isChecked()==true)?"1":"0");
				bean.setDharmashalaOfCommunitySociety((DharmashalaOfCommunitySociety.isChecked()==true)?"1":"0");
				bean.setCinemahallMultiplex((CinemahallMultiplex.isChecked()==true)?"1":"0");
				bean.setGeneralDegreeCollege((GeneralDegreeCollege.isChecked()==true)?"1":"0");
				bean.setCoachingInstitute((CoachingInstitute.isChecked()==true)?"1":"0");
				bean.setOutOfRicoIndustries((OutOfRicoIndustries.isChecked()==true)?"1":"0");
				
				
				bean.setStateGovtPropertyOffice(StateGovtPropertyOffice);
				bean.setReligiousPlace(ReligiousPlace);
				bean.setResidential(Residential);
				bean.setOthers(otherEdit.getText().toString());
				
				
				
				bean.setSewerConnection(getCheckValue(SewerConnection));
				bean.setLightConnection(getCheckValue(LightConnection));
				bean.setBoring(getCheckValue(Boring));
				bean.setParking(getCheckValue(Parking));
				bean.setAdvertisementHoarding(getCheckValue(AdvertisementHoarding));
				bean.setStreetLight(getCheckValue(StreetLight));
				bean.setPrivateToilet(getCheckValue(PrivateToilet));
				bean.setMobileTower(getCheckValue(MobileTower));
				bean.setOpenToilet(getCheckValue(OpenToilet));
				bean.setWhetherpayUdTax(getCheckValue(WhetherpayUdTax));
				 
				bean.setWhetherpayLeaseTax(getCheckValue(WhetherpayLeaseTax));
				bean.setSewerLine(getCheckValue(SewerLine));
				bean.setSepticTank(getCheckValue(SepticTank));
				bean.setPipedWaterConnection(getCheckValue(PipedWaterConnection));
				bean.setFireFightingSystem(getCheckValue(FireFightingSystem));

				//bean.setWhetherpayUdTax_ACNo(et_udtaxaccunt.getText().toString());
				bean.setWhetherpayLeaseTax_ACNo(et_payleasetaxaccountno.getText().toString());
				bean.setPleaseWriteSizefBoardSqft(et_advhoarding.getText().toString());
				//bean.setd
				
				
				
				
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

				StateGovtPropertyOffice=""+position;//parent.getItemAtPosition(position).toString();

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

				ReligiousPlace=""+position;//parent.getItemAtPosition(position).toString();

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

				Residential=""+position;//parent.getItemAtPosition(position).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});



	}
	
	
	OnClickListener first_radio_listener = new OnClickListener (){
		 public void onClick(View v) {
		    
			 
			 
			if (((CheckBox)v).isChecked())
			 {
				otherEdit.setEnabled(true);
			 }
			else{
				
				otherEdit.setText("");
				otherEdit.setEnabled(false);
			}
		 }
		};
	
	private String getCheckValue(RadioGroup rg1)
	{
		String selection="0";
		if(rg1.getCheckedRadioButtonId()!=-1){
		    int id= rg1.getCheckedRadioButtonId();
		    View radioButton = rg1.findViewById(id);
		    int radioId = rg1.indexOfChild(radioButton);
		    RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
		    selection = (String) btn.getText();
		    
		    selection=  selection.equalsIgnoreCase("No")?"0":"1";
		}
		return selection;
	}

}
