package com.versatilemobitech.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ProperyBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//New Survey Application Form Bean

	/**
	 * Data Provided By
	 */
	private String  dataProvidedBy="";
	private String relationshipOfOwner="";
	private String mobileNo="";
	private String EmailID="";
	private String NameOfDataProvider="";
	private String OwnerUIDNumber="";
	private String BasicPhoneNo="";

	/**
	 * Taxpayer/Occupier/Owner's Detail
	 */
	ArrayList<NameBean> nameList=new ArrayList<NameBean>();

	/**
	 * Address for communication
	 */

	private String AddressforCommunication="";
	private String PermanentAddress_Address="";
	private String MobileNo_Address="";
	private String EmailID_Address="";
	private String PermanentAddress="";
	private String BasicPhoneNo_Address="";

	/**
	 * Details Of Property/Building
	 */

	private String Plot_Flat_ShopNo="";
	private String Zone="";
	private String Colony_Name="";
	private String City="Jaipur";
	private String State="Rajasthan";
	private String Name_No_OfBuilding="";
	private String DetailsOfOwnership="";
	private String WhetherConstructionOnPlot="";
	private String NameOfLane_Road="";
	private String Ward="";
	private String District="Jaipur";
	private String Name_No_OfBuilding_pre="";
	private String IncaseofMultistoreyBuilding="";
	private String Length="";
	private String Width="";
	private String TypOfConstruction="";

	private String No_Of_Floors="";
	// Area 
	private String TotalPlotArea="";
	private String PlinthArea="";
	private String VacantArea="";
	private String TotalConstructionArea="";

	// Yard
	private String TotalPlotYard="";
	private String PlinthYard="";
	private String VacantYard="";
	private String TotalConstructionYard="";

	/*
	 * Use Of Land/Building & Details Of Floor Areas
	 */

	ArrayList<BuildingDetails> bulidList=new ArrayList<BuildingDetails>();

	/**
	 * Use Of Property(Please tick if applicable)
	 */

	private boolean PrivateHospitalClinic=false;
	private boolean  Residentialcum_commercial=false;
	private boolean  BeautyParlour=false;
	private boolean  PrivateOffice=false;
	private boolean  MarriageGardenHall=false;
	private boolean  HotelRestaurant=false;
	private boolean SemiGovtInstitute=false;
	private boolean CentralGovPropertyOffice=false;
	private boolean School=false;
	private boolean ProfessionalCollege=false;
	private boolean CompletelyReligiousProperty=false;
	private boolean SituatedInRicoArea=false;
	private boolean ExempteUnderclause107Act2009=false;
	private boolean DharmashalaOfCommunitySociety=false;
	private boolean CinemahallMultiplex=false;
	private boolean GeneralDegreeCollege=false;
	private boolean CoachingInstitute=false;
	private boolean OutOfRicoIndustries=false;


	private String StateGovtPropertyOffice="";
	private String ReligiousPlace="";
	private String Residential="";
	private String  Others=""; //Other valu only when accept click okay


	//Yes are no
	private boolean SewerConnection=false;
	private boolean  LightConnection=false;
	private boolean  Boring=false;
	private boolean  Parking=false;
	private boolean  AdvertisementHoarding=false;
	private boolean  StreetLight=false;
	private boolean  PrivateToilet=false;
	private boolean 	 MobileTower=false;
	private boolean 	 OpenToilet=false;
	private boolean 	 WhetherpayUdTax=false;
	private boolean 	 WhetherpayLeaseTax=false;
	private boolean 	 SewerLine=false;
	private boolean  SepticTank=false;
	private boolean 	 PipedWaterConnection=false;
	private boolean 	 FireFightingSystem=false;

	private String  WhetherpayUdTax_ACNo="";
	private String  WhetherpayLeaseTax_ACNo="";
	private  String  PleaseWriteSizefBoardSqft="";


	/**
	 * Survey Details
	 */

	private  String NameOfSurveyor="";
	private  String  SurveyorAddress="";
	private  String  IdCodeOfSurveyor="";
	private  String  Date_Surveyor="";
	private  String  NameOfAttestingAuthority="";
	private  String  DesignationOfAttestingAuthority="";
	private  String  Date_Attesting ="";

	static ProperyBean mProperyBean=null;
	//Instance
	static public ProperyBean getInstance() {

		if(mProperyBean==null)
			mProperyBean=new ProperyBean();
		return mProperyBean;
	}


	public String getDataProvidedBy() {
		return dataProvidedBy;
	}
	public void setDataProvidedBy(String dataProvidedBy) {
		this.dataProvidedBy = dataProvidedBy;
	}
	public String getRelationshipOfOwner() {
		return relationshipOfOwner;
	}
	public void setRelationshipOfOwner(String relationshipOfOwner) {
		this.relationshipOfOwner = relationshipOfOwner;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public String getNameOfDataProvider() {
		return NameOfDataProvider;
	}
	public void setNameOfDataProvider(String nameOfDataProvider) {
		NameOfDataProvider = nameOfDataProvider;
	}
	public String getOwnerUIDNumber() {
		return OwnerUIDNumber;
	}
	public void setOwnerUIDNumber(String ownerUIDNumber) {
		OwnerUIDNumber = ownerUIDNumber;
	}
	public String getBasicPhoneNo() {
		return BasicPhoneNo;
	}
	public void setBasicPhoneNo(String basicPhoneNo) {
		BasicPhoneNo = basicPhoneNo;
	}
	public ArrayList<NameBean> getNameList() {
		return nameList;
	}
	public void setNameList(ArrayList<NameBean> nameList) {
		this.nameList = nameList;
	}
	public String getAddressforCommunication() {
		return AddressforCommunication;
	}
	public void setAddressforCommunication(String addressforCommunication) {
		AddressforCommunication = addressforCommunication;
	}
	public String getPermanentAddress_Address() {
		return PermanentAddress_Address;
	}
	public void setPermanentAddress_Address(String permanentAddress_Address) {
		PermanentAddress_Address = permanentAddress_Address;
	}
	public String getMobileNo_Address() {
		return MobileNo_Address;
	}
	public void setMobileNo_Address(String mobileNo_Address) {
		MobileNo_Address = mobileNo_Address;
	}
	public String getEmailID_Address() {
		return EmailID_Address;
	}
	public void setEmailID_Address(String emailID_Address) {
		EmailID_Address = emailID_Address;
	}
	public String getPermanentAddress() {
		return PermanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		PermanentAddress = permanentAddress;
	}
	public String getBasicPhoneNo_Address() {
		return BasicPhoneNo_Address;
	}
	public void setBasicPhoneNo_Address(String basicPhoneNo_Address) {
		BasicPhoneNo_Address = basicPhoneNo_Address;
	}
	public String getPlot_Flat_ShopNo() {
		return Plot_Flat_ShopNo;
	}
	public void setPlot_Flat_ShopNo(String plot_Flat_ShopNo) {
		Plot_Flat_ShopNo = plot_Flat_ShopNo;
	}
	public String getZone() {
		return Zone;
	}
	public void setZone(String zone) {
		Zone = zone;
	}
	public String getColony_Name() {
		return Colony_Name;
	}
	public void setColony_Name(String colony_Name) {
		Colony_Name = colony_Name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getName_No_OfBuilding() {
		return Name_No_OfBuilding;
	}
	public void setName_No_OfBuilding(String name_No_OfBuilding) {
		Name_No_OfBuilding = name_No_OfBuilding;
	}
	public String getDetailsOfOwnership() {
		return DetailsOfOwnership;
	}
	public void setDetailsOfOwnership(String detailsOfOwnership) {
		DetailsOfOwnership = detailsOfOwnership;
	}
	public String getWhetherConstructionOnPlot() {
		return WhetherConstructionOnPlot;
	}
	public void setWhetherConstructionOnPlot(String whetherConstructionOnPlot) {
		WhetherConstructionOnPlot = whetherConstructionOnPlot;
	}
	public String getNameOfLane_Road() {
		return NameOfLane_Road;
	}
	public void setNameOfLane_Road(String nameOfLane_Road) {
		NameOfLane_Road = nameOfLane_Road;
	}
	public String getWard() {
		return Ward;
	}
	public void setWard(String ward) {
		Ward = ward;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getName_No_OfBuilding_pre() {
		return Name_No_OfBuilding_pre;
	}
	public void setName_No_OfBuilding_pre(String name_No_OfBuilding_pre) {
		Name_No_OfBuilding_pre = name_No_OfBuilding_pre;
	}
	public String getIncaseofMultistoreyBuilding() {
		return IncaseofMultistoreyBuilding;
	}
	public void setIncaseofMultistoreyBuilding(String incaseofMultistoreyBuilding) {
		IncaseofMultistoreyBuilding = incaseofMultistoreyBuilding;
	}
	public String getLength() {
		return Length;
	}
	public void setLength(String length) {
		Length = length;
	}
	public String getWidth() {
		return Width;
	}
	public void setWidth(String width) {
		Width = width;
	}
	public String getTypOfConstruction() {
		return TypOfConstruction;
	}
	public void setTypOfConstruction(String typOfConstruction) {
		TypOfConstruction = typOfConstruction;
	}
	public String getNo_Of_Floors() {
		return No_Of_Floors;
	}
	public void setNo_Of_Floors(String no_Of_Floors) {
		No_Of_Floors = no_Of_Floors;
	}
	public String getTotalPlotArea() {
		return TotalPlotArea;
	}
	public void setTotalPlotArea(String totalPlotArea) {
		TotalPlotArea = totalPlotArea;
	}
	public String getPlinthArea() {
		return PlinthArea;
	}
	public void setPlinthArea(String plinthArea) {
		PlinthArea = plinthArea;
	}
	public String getVacantArea() {
		return VacantArea;
	}
	public void setVacantArea(String vacantArea) {
		VacantArea = vacantArea;
	}
	public String getTotalConstructionArea() {
		return TotalConstructionArea;
	}
	public void setTotalConstructionArea(String totalConstructionArea) {
		TotalConstructionArea = totalConstructionArea;
	}
	public String getTotalPlotYard() {
		return TotalPlotYard;
	}
	public void setTotalPlotYard(String totalPlotYard) {
		TotalPlotYard = totalPlotYard;
	}
	public String getPlinthYard() {
		return PlinthYard;
	}
	public void setPlinthYard(String plinthYard) {
		PlinthYard = plinthYard;
	}
	public String getVacantYard() {
		return VacantYard;
	}
	public void setVacantYard(String vacantYard) {
		VacantYard = vacantYard;
	}
	public String getTotalConstructionYard() {
		return TotalConstructionYard;
	}
	public void setTotalConstructionYard(String totalConstructionYard) {
		TotalConstructionYard = totalConstructionYard;
	}
	public ArrayList<BuildingDetails> getBulidList() {
		return bulidList;
	}
	public void setBulidList(ArrayList<BuildingDetails> bulidList) {
		this.bulidList = bulidList;
	}
	public boolean isPrivateHospitalClinic() {
		return PrivateHospitalClinic;
	}
	public void setPrivateHospitalClinic(boolean privateHospitalClinic) {
		PrivateHospitalClinic = privateHospitalClinic;
	}
	public boolean isResidentialcum_commercial() {
		return Residentialcum_commercial;
	}
	public void setResidentialcum_commercial(boolean residentialcum_commercial) {
		Residentialcum_commercial = residentialcum_commercial;
	}
	public boolean isBeautyParlour() {
		return BeautyParlour;
	}
	public void setBeautyParlour(boolean beautyParlour) {
		BeautyParlour = beautyParlour;
	}
	public boolean isPrivateOffice() {
		return PrivateOffice;
	}
	public void setPrivateOffice(boolean privateOffice) {
		PrivateOffice = privateOffice;
	}
	public boolean isMarriageGardenHall() {
		return MarriageGardenHall;
	}
	public void setMarriageGardenHall(boolean marriageGardenHall) {
		MarriageGardenHall = marriageGardenHall;
	}
	public boolean isHotelRestaurant() {
		return HotelRestaurant;
	}
	public void setHotelRestaurant(boolean hotelRestaurant) {
		HotelRestaurant = hotelRestaurant;
	}
	public boolean isSemiGovtInstitute() {
		return SemiGovtInstitute;
	}
	public void setSemiGovtInstitute(boolean semiGovtInstitute) {
		SemiGovtInstitute = semiGovtInstitute;
	}
	public boolean isCentralGovPropertyOffice() {
		return CentralGovPropertyOffice;
	}
	public void setCentralGovPropertyOffice(boolean centralGovPropertyOffice) {
		CentralGovPropertyOffice = centralGovPropertyOffice;
	}
	public boolean isSchool() {
		return School;
	}
	public void setSchool(boolean school) {
		School = school;
	}
	public boolean isProfessionalCollege() {
		return ProfessionalCollege;
	}
	public void setProfessionalCollege(boolean professionalCollege) {
		ProfessionalCollege = professionalCollege;
	}
	public boolean isCompletelyReligiousProperty() {
		return CompletelyReligiousProperty;
	}
	public void setCompletelyReligiousProperty(boolean completelyReligiousProperty) {
		CompletelyReligiousProperty = completelyReligiousProperty;
	}
	public boolean isSituatedInRicoArea() {
		return SituatedInRicoArea;
	}
	public void setSituatedInRicoArea(boolean situatedInRicoArea) {
		SituatedInRicoArea = situatedInRicoArea;
	}
	public boolean isExempteUnderclause107Act2009() {
		return ExempteUnderclause107Act2009;
	}
	public void setExempteUnderclause107Act2009(boolean exempteUnderclause107Act2009) {
		ExempteUnderclause107Act2009 = exempteUnderclause107Act2009;
	}
	public boolean isDharmashalaOfCommunitySociety() {
		return DharmashalaOfCommunitySociety;
	}
	public void setDharmashalaOfCommunitySociety(
			boolean dharmashalaOfCommunitySociety) {
		DharmashalaOfCommunitySociety = dharmashalaOfCommunitySociety;
	}
	public boolean isCinemahallMultiplex() {
		return CinemahallMultiplex;
	}
	public void setCinemahallMultiplex(boolean cinemahallMultiplex) {
		CinemahallMultiplex = cinemahallMultiplex;
	}
	public boolean isGeneralDegreeCollege() {
		return GeneralDegreeCollege;
	}
	public void setGeneralDegreeCollege(boolean generalDegreeCollege) {
		GeneralDegreeCollege = generalDegreeCollege;
	}
	public boolean isCoachingInstitute() {
		return CoachingInstitute;
	}
	public void setCoachingInstitute(boolean coachingInstitute) {
		CoachingInstitute = coachingInstitute;
	}
	public boolean isOutOfRicoIndustries() {
		return OutOfRicoIndustries;
	}
	public void setOutOfRicoIndustries(boolean outOfRicoIndustries) {
		OutOfRicoIndustries = outOfRicoIndustries;
	}
	public String getStateGovtPropertyOffice() {
		return StateGovtPropertyOffice;
	}
	public void setStateGovtPropertyOffice(String stateGovtPropertyOffice) {
		StateGovtPropertyOffice = stateGovtPropertyOffice;
	}
	public String getReligiousPlace() {
		return ReligiousPlace;
	}
	public void setReligiousPlace(String religiousPlace) {
		ReligiousPlace = religiousPlace;
	}
	public String getResidential() {
		return Residential;
	}
	public void setResidential(String residential) {
		Residential = residential;
	}
	public String getOthers() {
		return Others;
	}
	public void setOthers(String others) {
		Others = others;
	}
	public boolean isSewerConnection() {
		return SewerConnection;
	}
	public void setSewerConnection(boolean sewerConnection) {
		SewerConnection = sewerConnection;
	}
	public boolean isLightConnection() {
		return LightConnection;
	}
	public void setLightConnection(boolean lightConnection) {
		LightConnection = lightConnection;
	}
	public boolean isBoring() {
		return Boring;
	}
	public void setBoring(boolean boring) {
		Boring = boring;
	}
	public boolean isParking() {
		return Parking;
	}
	public void setParking(boolean parking) {
		Parking = parking;
	}
	public boolean isAdvertisementHoarding() {
		return AdvertisementHoarding;
	}
	public void setAdvertisementHoarding(boolean advertisementHoarding) {
		AdvertisementHoarding = advertisementHoarding;
	}
	public boolean isStreetLight() {
		return StreetLight;
	}
	public void setStreetLight(boolean streetLight) {
		StreetLight = streetLight;
	}
	public boolean isPrivateToilet() {
		return PrivateToilet;
	}
	public void setPrivateToilet(boolean privateToilet) {
		PrivateToilet = privateToilet;
	}
	public boolean isMobileTower() {
		return MobileTower;
	}
	public void setMobileTower(boolean mobileTower) {
		MobileTower = mobileTower;
	}
	public boolean isOpenToilet() {
		return OpenToilet;
	}
	public void setOpenToilet(boolean openToilet) {
		OpenToilet = openToilet;
	}
	public boolean isWhetherpayUdTax() {
		return WhetherpayUdTax;
	}
	public void setWhetherpayUdTax(boolean whetherpayUdTax) {
		WhetherpayUdTax = whetherpayUdTax;
	}
	public boolean isWhetherpayLeaseTax() {
		return WhetherpayLeaseTax;
	}
	public void setWhetherpayLeaseTax(boolean whetherpayLeaseTax) {
		WhetherpayLeaseTax = whetherpayLeaseTax;
	}
	public boolean isSewerLine() {
		return SewerLine;
	}
	public void setSewerLine(boolean sewerLine) {
		SewerLine = sewerLine;
	}
	public boolean isSepticTank() {
		return SepticTank;
	}
	public void setSepticTank(boolean septicTank) {
		SepticTank = septicTank;
	}
	public boolean isPipedWaterConnection() {
		return PipedWaterConnection;
	}
	public void setPipedWaterConnection(boolean pipedWaterConnection) {
		PipedWaterConnection = pipedWaterConnection;
	}
	public boolean isFireFightingSystem() {
		return FireFightingSystem;
	}
	public void setFireFightingSystem(boolean fireFightingSystem) {
		FireFightingSystem = fireFightingSystem;
	}
	public String getWhetherpayUdTax_ACNo() {
		return WhetherpayUdTax_ACNo;
	}
	public void setWhetherpayUdTax_ACNo(String whetherpayUdTax_ACNo) {
		WhetherpayUdTax_ACNo = whetherpayUdTax_ACNo;
	}
	public String getWhetherpayLeaseTax_ACNo() {
		return WhetherpayLeaseTax_ACNo;
	}
	public void setWhetherpayLeaseTax_ACNo(String whetherpayLeaseTax_ACNo) {
		WhetherpayLeaseTax_ACNo = whetherpayLeaseTax_ACNo;
	}
	public String getPleaseWriteSizefBoardSqft() {
		return PleaseWriteSizefBoardSqft;
	}
	public void setPleaseWriteSizefBoardSqft(String pleaseWriteSizefBoardSqft) {
		PleaseWriteSizefBoardSqft = pleaseWriteSizefBoardSqft;
	}
	public String getNameOfSurveyor() {
		return NameOfSurveyor;
	}
	public void setNameOfSurveyor(String nameOfSurveyor) {
		NameOfSurveyor = nameOfSurveyor;
	}
	public String getSurveyorAddress() {
		return SurveyorAddress;
	}
	public void setSurveyorAddress(String surveyorAddress) {
		SurveyorAddress = surveyorAddress;
	}
	public String getIdCodeOfSurveyor() {
		return IdCodeOfSurveyor;
	}
	public void setIdCodeOfSurveyor(String idCodeOfSurveyor) {
		IdCodeOfSurveyor = idCodeOfSurveyor;
	}
	public String getDate_Surveyor() {
		return Date_Surveyor;
	}
	public void setDate_Surveyor(String date_Surveyor) {
		Date_Surveyor = date_Surveyor;
	}
	public String getNameOfAttestingAuthority() {
		return NameOfAttestingAuthority;
	}
	public void setNameOfAttestingAuthority(String nameOfAttestingAuthority) {
		NameOfAttestingAuthority = nameOfAttestingAuthority;
	}
	public String getDesignationOfAttestingAuthority() {
		return DesignationOfAttestingAuthority;
	}
	public void setDesignationOfAttestingAuthority(
			String designationOfAttestingAuthority) {
		DesignationOfAttestingAuthority = designationOfAttestingAuthority;
	}
	public String getDate_Attesting() {
		return Date_Attesting;
	}
	public void setDate_Attesting(String date_Attesting) {
		Date_Attesting = date_Attesting;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
