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
				cv_Values.put(dbHandler.AdvertisementHoarding,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.age,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.BasicPhoneNo,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.BasicPhoneNo,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.BasicPhoneNo_Address,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.BeautyParlour,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Boring,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.building_id,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.CentralGovPropertyOffice,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.CinemahallMultiplex,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.City,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Colony_Name,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.CompletelyReligiousProperty,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.dataProvidedBy,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Date_Attesting,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Date_Surveyor,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.DesignationOfAttestingAuthority,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.DetailsOfOwnership,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.District,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.EmailID,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.EmailID_Address,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.ExempteUnderclause107Act2009,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.father_name,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.FireFightingSystem,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Floor_No,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.HotelRestaurant,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.IdCodeOfSurveyor,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Land_Use,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Length,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.LightConnection,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.mobileNo,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.MarriageGardenHall,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.MobileNo_Address,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.MobileTower,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Name_No_OfBuilding_post,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Name_No_OfBuilding_pre,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.NameOfAttestingAuthority,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.NameOfDataProvider,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.NameOfLane_Road,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.NameOfSurveyor,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.No_Of_Floors,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.OpenToilet,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.ownerId,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.ownerUId,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.OwnerUIDNumber,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Others,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.OutOfRicoIndustries,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.owner_name,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.OutOfRicoIndustries,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.profession,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Parking,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PermanentAddress,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PermanentAddress_Address,pbean.getAddressforCommunication());
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
