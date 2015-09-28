package com.versatilemobitech.servey;

import com.versatilemobitech.adapter.DatabaseHandler;
import com.versatilemobitech.bean.ProperyBean;

import android.content.ContentValues;
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
				
				
				
				ContentValues cv_Values=new ContentValues();
				cv_Values.put(dbHandler.AddressforCommunication,pbean.getAddressforCommunication());
				//cv_Values.put(dbHandler.AdvertisementHoarding,pbean.get);
			//	cv_Values.put(dbHandler.age,pbean.get);
				cv_Values.put(dbHandler.BasicPhoneNo,pbean.getBasicPhoneNo());
				cv_Values.put(dbHandler.BasicPhoneNo_Address,pbean.getBasicPhoneNo_Address());
				cv_Values.put(dbHandler.BeautyParlour,pbean.getBeautyParlour());
				cv_Values.put(dbHandler.Boring,pbean.getBoring());
				cv_Values.put(dbHandler.building_id,pbean.getBuildingId());
				cv_Values.put(dbHandler.CentralGovPropertyOffice,pbean.getCentralGovPropertyOffice());
				cv_Values.put(dbHandler.CinemahallMultiplex,pbean.getCinemahallMultiplex());
				cv_Values.put(dbHandler.City,pbean.getCity());
				cv_Values.put(dbHandler.Colony_Name,pbean.getColony_Name());
				cv_Values.put(dbHandler.CompletelyReligiousProperty,pbean.getCompletelyReligiousProperty());
				cv_Values.put(dbHandler.dataProvidedBy,pbean.getDataProvidedBy());
				cv_Values.put(dbHandler.Date_Attesting,pbean.getDate_Attesting());
				cv_Values.put(dbHandler.Date_Surveyor,pbean.getDate_Surveyor());
				cv_Values.put(dbHandler.DesignationOfAttestingAuthority,pbean.getDesignationOfAttestingAuthority());
				cv_Values.put(dbHandler.DetailsOfOwnership,pbean.getDetailsOfOwnership());
				cv_Values.put(dbHandler.District,pbean.getDistrict());
				cv_Values.put(dbHandler.EmailID,pbean.getEmailID());
				cv_Values.put(dbHandler.EmailID_Address,pbean.getEmailID_Address());
				cv_Values.put(dbHandler.ExempteUnderclause107Act2009,pbean.getExempteUnderclause107Act2009());
				
				/**
				 * Need loop for Names
				 * 
				 */
				
				/*// Idname 1_w need to sqlil surevaytabel count 
				for (int i = 0; i < ProperyBean.getInstance().getNameList().size(); i++) {
					//These values need to store in Name list table 
					1_W
					
				}*/
				//cv_Values.put(dbHandler.father_name,pbean.get);
				cv_Values.put(dbHandler.FireFightingSystem,pbean.getFireFightingSystem());
				//cv_Values.put(dbHandler.Floor_No,pbean.get);
				cv_Values.put(dbHandler.HotelRestaurant,pbean.getHotelRestaurant());
				cv_Values.put(dbHandler.IdCodeOfSurveyor,pbean.getIdCodeOfSurveyor());
				//cv_Values.put(dbHandler.Land_Use,pbean.getl);
				cv_Values.put(dbHandler.Length,pbean.getLength());
				cv_Values.put(dbHandler.LightConnection,pbean.getLightConnection());
				cv_Values.put(dbHandler.mobileNo,pbean.getMobileNo());
				cv_Values.put(dbHandler.MarriageGardenHall,pbean.getMarriageGardenHall());
				cv_Values.put(dbHandler.MobileNo_Address,pbean.getMobileNo_Address());
				cv_Values.put(dbHandler.MobileTower,pbean.getMobileTower());
				cv_Values.put(dbHandler.Name_No_OfBuilding_post,pbean.getName_No_OfBuilding());
				cv_Values.put(dbHandler.Name_No_OfBuilding_pre,pbean.getName_No_OfBuilding_pre());
				cv_Values.put(dbHandler.NameOfAttestingAuthority,pbean.getNameOfAttestingAuthority());
				cv_Values.put(dbHandler.NameOfDataProvider,pbean.getNameOfDataProvider());
				cv_Values.put(dbHandler.NameOfLane_Road,pbean.getNameOfLane_Road());
				cv_Values.put(dbHandler.NameOfSurveyor,pbean.getNameOfSurveyor());
				cv_Values.put(dbHandler.No_Of_Floors,pbean.getNo_Of_Floors());
				cv_Values.put(dbHandler.OpenToilet,pbean.getOpenToilet());
			//	cv_Values.put(dbHandler.ownerId,pbean.geto);
				cv_Values.put(dbHandler.OwnerUIDNumber,pbean.getOwnerUIDNumber());
				//cv_Values.put(dbHandler.OwnerUIDNumber,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Others,pbean.getOthers());
				cv_Values.put(dbHandler.OutOfRicoIndustries,pbean.getOutOfRicoIndustries());
			//	cv_Values.put(dbHandler.owner_name,pbean.getO);
				cv_Values.put(dbHandler.OutOfRicoIndustries,pbean.getAddressforCommunication());
		//		cv_Values.put(dbHandler.profession,pbean.getpr);
				cv_Values.put(dbHandler.Parking,pbean.getParking());
				cv_Values.put(dbHandler.PermanentAddress,pbean.getPermanentAddress());
				//cv_Values.put(dbHandler.PermanentAddress_Address,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PipedWaterConnection,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PleaseWriteSizefBoardSqft,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PlinthArea,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PlinthYard,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Plot_Flat_ShopNo,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PrivateHospitalClinic,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PrivateOffice,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PrivateOffice,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PrivateToilet,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PrivateOffice,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.ProfessionalCollege,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.relationshipOfOwner,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.ReligiousPlace,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Residential,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Residentialcum_commercial,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.School,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.SemiGovtInstitute,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.SepticTank,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.SewerConnection,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.SewerLine,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.SituatedInRicoArea,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.State,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.StateGovtPropertyOffice,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.StreetLight,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.SurveyorAddress,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Total_Area_sft,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Total_Area_Yard,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.TotalConstructionArea,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.TotalPlotArea,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.TotalPlotYard,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.TypOfConstruction,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.VacantArea,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.VacantYard,pbean.getAddressforCommunication());
				dbHandler.insert("SERVEY_DATA", cv_Values);
				
				
				
			}
		});
		
		
	}
}
