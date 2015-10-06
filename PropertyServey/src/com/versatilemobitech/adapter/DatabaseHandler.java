package com.versatilemobitech.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	public static final int DATABASE_VERSION = 3;
	
	
//09-29 06:16:50.280: E/SQLiteLog(3712): (1) table SERVEY_DATA has no column named Building_Id_like_1_b_2_b_3_b_so_on

	// Database Name
	public static final String DATABASE_NAME = "Servey";

	// questionsData table name
//	Date & Time	Vehicle Type	Vehicle Reg No.	Origin	Destination	Commodity Type	Trip Length	Trip Time	Trip Frequency	Return Trip on same day	Monthly pass	Weight in tons	Willngness to Pay Toll (Y/N)

	public static final String TABLE_servey_Data = "SERVEY_DATA";
	
	public static final String TABLE_Building_Data = "SERVEY_Building_Details";
	
	public static final String TABLE_Owner_Data = "SERVEY_Owner_Details";
	
	public static final String dataProvidedBy="Data_Provided_By";
	public static final String relationshipOfOwner="Relationship_with_owner";
	public static final String mobileNo="Data_Providers_Mobile_No";
	public static final String EmailID="Data_Providers_mail_Id";
	public static final String NameOfDataProvider="Data_Provider_Name";
	public static final String OwnerUIDNumber="Owner_UID_Number";
	public static final String BasicPhoneNo="Data_Providers_Basic_Phone_No";
	public static final String FormID="FormID";
	public static final String OwnerFatherName="OwnerFatherName";
	
	
	public static final String ID="S_NO";
	
	
	public static final String AddressforCommunication="Owner_Address_for_Communication";
	//public static final String PermanentAddress_Address="Owner_Permanent_Address";
	public static final String MobileNo_Address="Owner_Mobile_No";
	public static final String EmailID_Address="Owner_mail_Id";
	public static final String PermanentAddress="Owner_Permanent_Address";
	public static final String BasicPhoneNo_Address="Owner_Basic_Phone_No";
	 
 
	
	
	/**
	_*_Details_Of_Property/Building
	_*/

	public static final String Plot_Flat_ShopNo="Plot_Flat_Shop_No";
	public static final String Zone="Zone";
	 public static final String Ward="ward";
	public static final String Colony_Name="Colony_Name";
	public static final String City="City";
	public static final String State="State";
	public static final String Landmark="landmark";
	public static final String Name_No_OfBuilding_pre="Name_No_of_building_pre";
	public static final String Name_No_OfBuilding_post="Name_No_of_building_post";
	public static final String DetailsOfOwnership="Details_of_ownership";
	public static final String WhetherConstructionOnPlot="Whether_construction_on_plot_yes_No";
	public static final String NameOfLane_Road="Name_of_Lane_Road";
	
	public static final String District="District";
	
	public static final String IncaseofMultistoreyBuilding="Incase_of_multistorey_building_name_of_Building";
	public static final String Length="If_construction_on_plot_is_yes_length_in_sqft";
	public static final String Width="if_construction_on_plot_yes_width_in_sqft";
	public static final String TypOfConstruction="Type_of_construction";

	public static final String No_Of_Floors="No_of_Floors";
	//_Area_
	public static final String TotalPlotArea="Total_Plot_Area_in_Sqft";
	public static final String PlinthArea="Plinth_Area_in_Sqft";
	public static final String VacantArea="Vacant_Area_in_sqft";
	 public static final String TotalConstructionArea="Total_Construction_Area_in_sqft";

	//_Yard
	public static final String TotalPlotYard="Total_Plot_Area_in_yard";
	public static final String PlinthYard="Plinth_Area_in_yard";
	public static final String VacantYard="Vacant_Area_in_yard";
	public static final String TotalConstructionYard="Total_Construction_Area_in_yard";
	
	
	
	/**
	_*_Use_Of_Property(Please_tick_if_applicable)
	_*/

	public static final String PrivateHospitalClinic="Hospital_Clinic_Write_1_if_applicable_else_0";
	public static final String Residentialcum_commercial="Residential_cum_commercial_Write_1_if_applicable_else_0";
	public static final String BeautyParlour="Beauty_Parlour_Write_1_if_applicable_else_0";
	public static final String PrivateOffice="Office_Write_1_if_applicable_else_0";
	public static final String MarriageGardenHall="Marriage_Garden_Hall_Write_1_if_applicable_else_0";
	public static final String HotelRestaurant="Hotel_Restaurent_Write_1_if_applicable_else_0";
	public static final String SemiGovtInstitute="Semi_Govt_Institute_Write_1_if_applicable_else_0";
	public static final String CentralGovPropertyOffice="Central_Govt_Propertey_Office_Write_1_if_applicable_else_0";
	public static final String School="School_Write_1_if_applicable_else_0";
	public static final String ProfessionalCollege="Professional_College_Write_1_if_applicable_else_0";
	public static final String CompletelyReligiousProperty="Completely_Religious_Property_Write_1_if_applicable_else_0";
	public static final String SituatedInRicoArea="Situateed_in_RICO_Area_Write_1_if_applicable_else_0";
	public static final String ExempteUnderclause107Act2009="Excempted_under_clause_107_of_RM_Act_2009_Write_1_if_applicable_else_0";
//	public static final String DharmashalaOfCommunitySociety=false;
	public static final String CinemahallMultiplex="Cinema_Hall_Multiplex_Write_1_if_applicable_else_0";
	public static final String GeneralDegreeCollege="General_Degree_college";
	public static final String CoachingInstitute="Coaching_Institute_Write_1_if_applicable_else_0";
	public static final String OutOfRicoIndustries="Out_of_RICO_industries_Write_1_if_applicable_else_0";


	public static final String StateGovtPropertyOffice="State_Govt_Property_office";
	public static final String ReligiousPlace="Religious_Place";
	public static final String Residential="Residential";
	public static final String Others="Others_write_1_or_0_here";//Other_valu_only_when_accept_click_okay


	//Yes_are_no
	public static final String SewerConnection="Sewer_Connection_Write_1_if_applicable_else_0";
	public static final String LightConnection="Light_Connection_Write_1_if_applicable_else_0";
	public static final String Boring="Boring_Write_1_if_applicable_else_0";
	public static final String Parking="Parking_Write_1_if_applicable_else_0";
	public static final String AdvertisementHoarding="Advertisement_Hoarding_Write_1_if_applicable_else_0";
	public static final String StreetLight="Street_Light_Write_1_if_applicable_else_0";
	public static final String PrivateToilet="Toilet_Write_1_if_applicable_else_0";
	public static final String MobileTower="Mobile_Tower_Write_1_if_applicable_else_0";
	public static final String OpenToilet="Open_Toilet_Write_1_if_applicable_else_0";
	public static final String WhetherpayUdTax="Whether_pay_UD_Tax_Write_1_if_applicable_else_0";
	public static final String WhetherpayLeaseTax="Whether_pay_Lease_Tax_write_1_if_applicable_else_0";
	public static final String SewerLine="Sewer_Line_Write_1_if_applicable_else_0";
	public static final String SepticTank="Septic_Tank_Write_1_if_applicable_else_0";
	public static final String PipedWaterConnection="Piped_Water_Connection_Write_1_if_applicable_else_0";
	public static final String FireFightingSystem="Fire_Fighting_SystemWrite_1_if_applicable_else_0";

	public static final String WhetherpayUdTax_ACNo="If_paid_UD_Tax_Account_No";
	 public static final String WhetherpayLeaseTax_ACNo="If_paid_Lease_Tax_Account_No";
	public static final String PleaseWriteSizefBoardSqft="SizefBoardSqft";


	/**
	_*_Survey_Details
	_*/

	public static final String NameOfSurveyor="Name_of_the_Surveyor";
	public static final String SurveyorAddress="Surveyor_Address";
	public static final String IdCodeOfSurveyor="ID_code_of_the_surveyor";
	public static final String Date_Surveyor="Date";
	public static final String NameOfAttestingAuthority="Name_of_the_Attesting_Authority";
	public static final String DesignationOfAttestingAuthority="Designation_of_the_Attesting_Authority";
	 public static final String Date_Attesting="Date_attesting";

	
	/*public static final String photoofProperty_MAGEPATH="propertyimagepath";
	public static final String photoofSiteplan_IMAGEPATH="siteplanimagepath";
	public static final String signature_IMAGEPATH="signatureimagepath";*/
	public static final String CREATED_DATE="CREATED_DATE";
	
	//Building_table_data
	
	public static final String building_id="Building_Id";
	public static final String Land_Use="Land_Use";
	public static final String Floor_No="Floor_No";
	public static final String Total_Area_sft="Total_Area_in_sqft";
	public static final String Total_Area_Yard="Total_Area_in_Yard";
	//Owner_table_data
	
		public static final String Owner_id="Owner_Id";
		public static final String owner_name="Owner_Name";
		public static final String father_name="Name_of_Father_Husband";
		public static final String age="Age";
		public static final String profession="Profession";
	
		public static final String propertyIMG="property_img";
		public static final String siteImage="site_image";
		public static final String signatureIMG="singnature_img";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	

	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_OFFLINE_DATA_TABLE = "CREATE TABLE "
				+ TABLE_servey_Data 
				+ " (" 
				+ ID 		+ " INTEGER PRIMARY KEY,"
				+ FormID 		+ " TEXT,"
				+ dataProvidedBy 	+ " TEXT," 
				+ relationshipOfOwner 	+ " TEXT,"
				+ EmailID 	+ " TEXT," 
				+ mobileNo 	+ " TEXT," 
				+ NameOfDataProvider	+ " TEXT," 
				+ OwnerUIDNumber 	+ " TEXT," 
				+ BasicPhoneNo 		+ " TEXT,"
				+ AddressforCommunication 		+ " TEXT,"
				+ MobileNo_Address 		+ " TEXT,"
				+ EmailID_Address 		+ " TEXT,"
				+ PermanentAddress 		+ " TEXT,"
				+ BasicPhoneNo_Address 		+ " TEXT,"
		
				+ Plot_Flat_ShopNo 		+ " TEXT,"
				+ Zone 		+ " TEXT,"
				+ Ward 		+ " TEXT,"
				+ Colony_Name 		+ " TEXT,"
				+ City 		+ " TEXT,"
				+ State 		+ " TEXT,"
				+ Landmark	+ " TEXT,"
				+ Name_No_OfBuilding_pre 		+ " TEXT,"
				+ Name_No_OfBuilding_post 		+ " TEXT,"
				+ DetailsOfOwnership 		+ " TEXT,"
				+ WhetherConstructionOnPlot 		+ " TEXT,"
				+ NameOfLane_Road 		+ " TEXT,"
				+ District 		+ " TEXT,"
				+ IncaseofMultistoreyBuilding 		+ " TEXT,"
				+ Length 		+ " TEXT,"
				+ Width 		+ " TEXT,"
				+ TypOfConstruction 		+ " TEXT,"
				+ No_Of_Floors 		+ " TEXT,"
				+ TotalPlotArea 		+ " TEXT,"
				+ PlinthArea 		+ " TEXT,"
				+ VacantArea 		+ " TEXT,"
				+ TotalConstructionArea 		+ " TEXT,"
				+ TotalConstructionYard + " TEXT,"
			+ TotalPlotYard 		+ " TEXT,"
				+ PlinthYard 		+ " TEXT,"
				+ VacantYard 		+ " TEXT,"
				+ PrivateHospitalClinic 		+ " TEXT,"
				+ Residentialcum_commercial 		+ " TEXT,"
				+ BeautyParlour 		+ " TEXT,"
				+ PrivateOffice 		+ " TEXT,"
				+ MarriageGardenHall 		+ " TEXT,"
				+ HotelRestaurant 		+ " TEXT,"
				+ SemiGovtInstitute 		+ " TEXT,"
				+ CentralGovPropertyOffice 		+ " TEXT,"
				+ School+ " TEXT,"
				+ ProfessionalCollege 		+ " TEXT,"
				+ CompletelyReligiousProperty 		+ " TEXT,"
				+ SituatedInRicoArea 		+ " TEXT,"
				+ ExempteUnderclause107Act2009 		+ " TEXT,"
				+ CinemahallMultiplex 		+ " TEXT,"
				+ GeneralDegreeCollege 		+ " TEXT,"
				+ CoachingInstitute 		+ " TEXT,"
				+ OutOfRicoIndustries 		+ " TEXT,"
				+ StateGovtPropertyOffice 		+ " TEXT,"
				+ ReligiousPlace 		+ " TEXT,"
				+ Residential 		+ " TEXT,"
				+ Others 		+ " TEXT,"
				+ building_id 	+ " TEXT," 
				+ Owner_id 	+ " TEXT," 
				+ SewerConnection 		+ " TEXT,"
				+ LightConnection 		+ " TEXT,"
				+ Boring 		+ " TEXT,"
				+ Parking 		+ " TEXT,"
				+ AdvertisementHoarding 		+ " TEXT,"
				+ PleaseWriteSizefBoardSqft 	+ " TEXT,"
				+ StreetLight 		+ " TEXT,"
				+ PrivateToilet 		+ " TEXT,"
				+ MobileTower 		+ " TEXT,"
				+ OpenToilet 		+ " TEXT,"
				+ WhetherpayUdTax 		+ " TEXT,"
				+ WhetherpayLeaseTax 		+ " TEXT,"
				+ SewerLine 		+ " TEXT,"
				+ SepticTank 		+ " TEXT,"
				+ PipedWaterConnection 		+ " TEXT,"
				+ FireFightingSystem 		+ " TEXT,"
				+ WhetherpayUdTax_ACNo 		+ " TEXT,"
				+ WhetherpayLeaseTax_ACNo 		+ " TEXT,"
				+ NameOfSurveyor 		+ " TEXT,"
				+ SurveyorAddress 		+ " TEXT,"
				+ IdCodeOfSurveyor 		+ " TEXT,"
				+ Date_Surveyor 		+ " TEXT,"
				+ Date_Attesting         + " TEXT,"
				+ NameOfAttestingAuthority 		+ " TEXT,"
				+ DesignationOfAttestingAuthority 		+ " TEXT,"
				+ propertyIMG 		+ " TEXT,"
				+ siteImage 		+ " TEXT,"
				+ signatureIMG 		+ " TEXT,"
				+ CREATED_DATE + " TEXT"
				+ ")";
		
		
		
		
		String CREATE_OFFLINE_BUILDING_DATA_TABLE = "CREATE TABLE "
				+ TABLE_Building_Data 
				+ " (" 
				+ ID 		+ " INTEGER PRIMARY KEY,"
				+ building_id 	+ " TEXT," 
				+ Land_Use 	+ " TEXT," 
				+ Floor_No 	+ " TEXT," 
				+ Total_Area_sft 	+ " TEXT," 
				+ Total_Area_Yard 	+ " TEXT" 
			
				+ ")";
		
		String CREATE_OFFLINE_OWNER_DATA_TABLE = "CREATE TABLE "
				+ TABLE_Owner_Data 
				+ " (" 
				+ ID 		+ " INTEGER PRIMARY KEY,"
				+ Owner_id 	+ " TEXT," 
				+ owner_name 	+ " TEXT," 
				+ OwnerFatherName + " TEXT,"
				+ age 	+ " TEXT," 
				+ profession 	+ " TEXT" 
			
				+ ")";
		

		db.execSQL(CREATE_OFFLINE_DATA_TABLE);
		db.execSQL(CREATE_OFFLINE_BUILDING_DATA_TABLE);
		db.execSQL(CREATE_OFFLINE_OWNER_DATA_TABLE);
	}
	
	

	

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_servey_Data);

		// Create tables again
		onCreate(db);
	}

	
	public long insert(String tableName,ContentValues values) {
		SQLiteDatabase db = this.getWritableDatabase();

		
		long seq=db.insert(tableName, null, values);
		db.close(); 
		return seq;
	}

	
	
	public Cursor RetriveData(String table) 
	{
		try
		{
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor curRetriveData = db.rawQuery(table,null);//"Select * from "+TABLE_Player+"where "+where, null);
			if(curRetriveData!=null)
				curRetriveData.moveToFirst();
			return curRetriveData;
		}
		catch (Exception e) 
		{  
			e.printStackTrace();
			return null;
		}
	}

}
