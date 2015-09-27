package com.versatilemobitech.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	public static final int DATABASE_VERSION = 2;

	// Database Name
	public static final String DATABASE_NAME = "Servey";

	// questionsData table name
//	Date & Time	Vehicle Type	Vehicle Reg No.	Origin	Destination	Commodity Type	Trip Length	Trip Time	Trip Frequency	Return Trip on same day	Monthly pass	Weight in tons	Willngness to Pay Toll (Y/N)

	public static final String TABLE_servey_Data = "SERVEY_DATA";
	
	public static final String TABLE_Building_Data = "SERVEY_DATA";
	
	public static final String TABLE_Owner_Data = "SERVEY_DATA";
	
	public static final String dataProvidedBy="Data_Provided_By";
	public static final String relationshipOfOwner="Relationship_with_owner";
	public static final String mobileNo="Data_Providers_Mobile_No";
	public static final String EmailID="Data_Providers_mail_Id";
	public static final String NameOfDataProvider="Data_Provider_Name";
	public static final String OwnerUIDNumber="Owner_UID_Number_Minimun_12_digits";
	public static final String BasicPhoneNo="Data_Providers_Basic_Phone_No";
	
	
	public static final String ID="S_NO";
	
	
	public static final String AddressforCommunication="Owner_Address_for_Communication";
	public static final String PermanentAddress_Address="Owner_Permanent_Address";
	public static final String MobileNo_Address="Owner_Mobile_No";
	public static final String EmailID_Address="Owner_mail_Id";
	public static final String PermanentAddress="Owner_Permanent_Address";
	public static final String BasicPhoneNo_Address="Owner_Basic_Phone_No";
	public static final String ownerId="Owner_Id_(like_1_w,_2_w,_3_w_so_on)";
	public static final String ownerUId="Owner_UID_Number(Minimun_12_digits)";
	
	
	/**
	_*_Details_Of_Property/Building
	_*/

	public static final String Plot_Flat_ShopNo="Plot/Flat/Shop_No";
	public static final String Zone="Zone";
	public static final String Ward="ward";
	public static final String Colony_Name="Colony_Name";
	public static final String City="City";
	public static final String State="State";
	public static final String Name_No_OfBuilding_pre="Name/No._of_building(pre)";
	public static final String Name_No_OfBuilding_post="Name/No._of_building(post)";
	public static final String DetailsOfOwnership="Details_of_ownership";
	public static final String WhetherConstructionOnPlot="Whether_construction_on_plot_(yes/No)";
	public static final String NameOfLane_Road="Name_of_Lane/Road";
	
	public static final String District="District";
	
	public static final String IncaseofMultistoreyBuilding="Incase_of_multistorey_building,_name_of_Building";
	public static final String Length="If_construction_on_plot_is_yes_length_in_sqft";
	public static final String Width="if_construction_on_plot_yes_width_in_sqft";
	public static final String TypOfConstruction="Type_of_construction";

	public static final String No_Of_Floors="No._of_Floors";
	//_Area_
	public static final String TotalPlotArea="Total_Plot_Area_in_Sqft";
	public static final String PlinthArea="Plinth_Area_in_Sqft";
	public static final String VacantArea="Vacant_Area_in_sqft";
	public static final String TotalConstructionArea="Total_Construction_Area_in_sqft";

	//_Yard
	public static final String TotalPlotYard="Total_Plot_Area_in_yard";
	public static final String PlinthYard="Plinth_Area_in_yard";
	public static final String VacantYard="Vacant_Area_in_yard";
	
	
	
	/**
	_*_Use_Of_Property(Please_tick_if_applicable)
	_*/

	public static final String PrivateHospitalClinic="public static final_Hospital/Clinic_(Write_1_if_applicable_else_0)";
	public static final String Residentialcum_commercial="Residential_cum_commercial_(Write_1_if_applicable_else_0)";
	public static final String BeautyParlour="Beauty_Parlour_(Write_1_if_applicable_else_0)";
	public static final String PrivateOffice="public static final_Office(Write_1_if_applicable_else_0)";
	public static final String MarriageGardenHall="Marriage_Garden/_Hall_(Write_1_if_applicable_else_0)";
	public static final String HotelRestaurant="Hotel/_Restaurent_(Write_1_if_applicable_else_0)";
	public static final String SemiGovtInstitute="Semi_Govt._Institute_(Write_1_if_applicable_else_0)";
	public static final String CentralGovPropertyOffice="Central_Govt._Propertey_Office_(Write_1_if_applicable_else_0)";
	public static final String School="School_(Write_1_if_applicable_else_0)";
	public static final String ProfessionalCollege="Professional_College_(Write_1_if_applicable_else_0)";
	public static final String CompletelyReligiousProperty="Completely_Religious_Property_(Write_1_if_applicable_else_0)";
	public static final String SituatedInRicoArea="Situateed_in_RICO_Area_(Write_1_if_applicable_else_0)";
	public static final String ExempteUnderclause107Act2009="Excempted_under_clause_107_of_RM_Act_2009_(Write_1_if_applicable_else_0)";
//	public static final String DharmashalaOfCommunitySociety=false;
	public static final String CinemahallMultiplex="Cinema_Hall/Multiplex_(Write_1_if_applicable_else_0)";
	public static final String GeneralDegreeCollege="General_Degree_college_(Write_1_if_applicable_else_0)";
	public static final String CoachingInstitute="Coaching_Institute(Write_1_if_applicable_else_0)";
	public static final String OutOfRicoIndustries="Out_of_RICO_industries_(Write_1_if_applicable_else_0)";


	public static final String StateGovtPropertyOffice="State_Govt._Property_office";
	public static final String ReligiousPlace="Religious_Place";
	public static final String Residential="Residential";
	public static final String Others="Others(_write_1_or_0_here)";//Other_valu_only_when_accept_click_okay


	//Yes_are_no
	public static final String SewerConnection="Sewer_Connection_(Write_1_if_applicable_else_0)";
	public static final String LightConnection="Light_Connection_(Write_1_if_applicable_else_0)";
	public static final String Boring="Boring_(Write_1_if_applicable_else_0)";
	public static final String Parking="Parking_(Write_1_if_applicable_else_0)";
	public static final String AdvertisementHoarding="Advertisement_Hoarding_(Write_1_if_applicable_else_0)";
	public static final String StreetLight="Street_Light_(Write_1_if_applicable_else_0)";
	public static final String PrivateToilet="public static final_Toilet_(Write_1_if_applicable_else_0)";
	public static final String MobileTower="Mobile_Tower_(Write_1_if_applicable_else_0)";
	public static final String OpenToilet="Open_Toilet_(Write_1_if_applicable_else_0)";
	public static final String WhetherpayUdTax="Whether_pay_UD_Tax_(Write_1_if_applicable_else_0)";
	public static final String WhetherpayLeaseTax="Whether_pay_Lease__Tax_(Write_1_if_applicable_else_0)";
	public static final String SewerLine="Sewer_Line_(Write_1_if_applicable_else_0)";
	public static final String SepticTank="Septic_Tank_(Write_1_if_applicable_else_0)";
	public static final String PipedWaterConnection="Piped_Water_Connection_(Write_1_if_applicable_else_0)";
	public static final String FireFightingSystem="Fire_Fighting_System(Write_1_if_applicable_else_0)";

	public static final String WhetherpayUdTax_ACNo="If_paid_UD_Tax_Account_No.";
	public static final String WhetherpayLeaseTax_ACNo="If_paid_Lease_Tax_Account_No.";
	public static final String PleaseWriteSizefBoardSqft="";


	/**
	_*_Survey_Details
	_*/

	public static final String NameOfSurveyor="Name_of_the_Surveyor";
	public static final String SurveyorAddress="Surveyor_Address";
	public static final String IdCodeOfSurveyor="ID_code_of_the_surveyor";
	public static final String Date_Surveyor="Date";
	public static final String NameOfAttestingAuthority="Name_of_the_Attesting_Authority";
	public static final String DesignationOfAttestingAuthority="Designation_of_the_Attesting_Authority";
	public static final String Date_Attesting="Date";

	
	public static final String photoofProperty_MAGEPATH="propertyimagepath";
	public static final String photoofSiteplan_IMAGEPATH="siteplanimagepath";
	public static final String signature_IMAGEPATH="signatureimagepath";
	public static final String CREATED_DATE="CREATED_DATE";
	
	//Building_table_data
	
	public static final String building_id="Building_Id_(like_1_b,_2_b,_3_b_so_on)";
	public static final String Land_Use="Land_Use";
	public static final String Floor_No="Floor_No";
	public static final String Total_Area_sft="Total_Area_in_sqft";
	public static final String Total_Area_Yard="Total_Area_in_Yard";
	//Owner_table_data
	
		public static final String Owner_id="Building_Id_(like_1_b,_2_b,_3_b_so_on)";
		public static final String owner_name="Owner_Name";
		public static final String father_name="Name_of_Father_/_Husband";
		public static final String age="Age";
		public static final String profession="Profession";
	


	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	
/*	

	//Yes are no
	private String 	 OpenToilet="Open Toilet (Write 1 if applicable else 0)";
	private String 	 WhetherpayUdTax="Whether pay UD Tax (Write 1 if applicable else 0)";
	private String 	 WhetherpayLeaseTax="Whether pay Lease  Tax (Write 1 if applicable else 0)";
	private String 	 SewerLine="Sewer Line (Write 1 if applicable else 0)";
	private String  SepticTank="Septic Tank (Write 1 if applicable else 0)";
	private String 	 PipedWaterConnection="Piped Water Connection (Write 1 if applicable else 0)";
	private String 	 FireFightingSystem="Fire Fighting System(Write 1 if applicable else 0)";

	private String  WhetherpayUdTax_ACNo="If paid UD Tax Account No.";
	private String  WhetherpayLeaseTax_ACNo="If paid Lease Tax Account No.";
	private  String  PleaseWriteSizefBoardSqft="";



	private  String NameOfSurveyor="Name of the Surveyor";
	private  String  SurveyorAddress="Surveyor Address";
	private  String  IdCodeOfSurveyor="ID code of the surveyor";
	private  String  Date_Surveyor="Date";
	private  String  NameOfAttestingAuthority="Name of the Attesting Authority";
	private  String  DesignationOfAttestingAuthority="Designation of the Attesting Authority";
	private  String  Date_Attesting ="Date";
*/
	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_OFFLINE_DATA_TABLE = "CREATE TABLE "
				+ TABLE_servey_Data 
				+ " (" 
				+ ID 		+ " INTEGER PRIMARY KEY,"
				+ dataProvidedBy 	+ " TEXT," 
				+ relationshipOfOwner 	+ " TEXT,"
				+ EmailID 	+ " TEXT," 
				+ mobileNo 	+ " TEXT," 
				+ NameOfDataProvider	+ " TEXT," 
				+ OwnerUIDNumber 	+ " TEXT," 
				+ BasicPhoneNo 		+ " TEXT,"
				+ AddressforCommunication 		+ " TEXT,"
				+ PermanentAddress_Address 		+ " TEXT,"
				+ MobileNo_Address 		+ " TEXT,"
				+ EmailID_Address 		+ " TEXT,"
				+ PermanentAddress 		+ " TEXT,"
				+ BasicPhoneNo_Address 		+ " TEXT,"
				+ ownerId 		+ " TEXT,"
				+ ownerUId 		+ " TEXT,"
				+ Plot_Flat_ShopNo 		+ " TEXT,"
				+ Zone 		+ " TEXT,"
				+ Ward 		+ " TEXT,"
				+ Colony_Name 		+ " TEXT,"
				+ City 		+ " TEXT,"
				+ State 		+ " TEXT,"
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
				+ School 		+ " TEXT,"
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
				+ SewerConnection 		+ " TEXT,"
				+ LightConnection 		+ " TEXT,"
				+ Boring 		+ " TEXT,"
				+ Parking 		+ " TEXT,"
				+ AdvertisementHoarding 		+ " TEXT,"
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
				+ NameOfAttestingAuthority 		+ " TEXT,"
				+ DesignationOfAttestingAuthority 		+ " TEXT,"
				+ CREATED_DATE + " DATE"
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
				+ ownerId 	+ " TEXT," 
				+ owner_name 	+ " TEXT," 
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
