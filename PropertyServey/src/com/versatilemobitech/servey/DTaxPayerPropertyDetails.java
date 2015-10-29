package com.versatilemobitech.servey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.bean.SpinnerItemBean;

public class DTaxPayerPropertyDetails extends BaserActinbBar{
	Button btn_Next,btn_Prev;

	//EditText PlotORFlatNo=null;
	String Zone="";
	EditText ColonyName=null;
	Spinner city_spinner=null;
	String city=""; 
	EditText state=null;
	EditText NameOfBuildin_Post=null;
	String DetailsOfOwnership="";
	EditText WhetherConstructionOnPlot_lenth=null;
	EditText WhetherConstructionOnPlot_width=null;
	String TypeOfConstruction=null;
	EditText NameOfLaneOrRoad=null;
	String Ward ="";
	EditText Landmark=null;
	EditText District=null;
	EditText NameOfBuilding_Pre=null;
	EditText MultistoreyBuildigNameofBuilding=null;
	EditText flatno;
	CheckBox chk_Constrution;
	//EditText et_lengthfeets,et_widthFeets;

	LinearLayout ll_chk_constructionplot;
	ProperyBean pbean;

	private String Zone_id="";
	private String city_id=""; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taxpayerpropertydetails);
		pbean=ProperyBean.getInstance();

		//Data mapping....
		final LinkedHashMap<String, String> jaipurWardMap=new LinkedHashMap<String, String>();


		jaipurWardMap.put("Select", "Select");
		/*jaipurWardMap.put("Vidyanagar", "1,2,3,4,5,6,7,8,9,10,15,16,17,66,67,68,69");
		jaipurWardMap.put("Civil line","11,12,13,14,18,19,20,21,22,41,42,43,63");
		jaipurWardMap.put("Mansarovar","23,24,25,26,27,28,29,40");
		jaipurWardMap.put("Sanganer","30,31,32,33,34,36,37");
		jaipurWardMap.put("Moti Doongari","35,38,39,44,45,46,47,48,50,51");
		jaipurWardMap.put("Hawamahal Zone (East)","49,52,53,54,55,56,57,58,59,72,73");
		jaipurWardMap.put("Hawamahal Zone (West)","60,61,62,64,65,70,71");
		jaipurWardMap.put("Amer","	74,75,76,77");*/

		jaipurWardMap.put("Vidyadhar Nagar", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,23,24,25,79,80,81,82");

		jaipurWardMap.put("Civil line","15,16,17,18,19,20,21,22,26,27,28,30,56,57,58,76");
		jaipurWardMap.put("Mansarovar","29,31,32,33,34,40,41,42,43,44,55");
		jaipurWardMap.put("Sanganer","35,36,37,38,39,45,44,45,46,47,48,49,50,52");
		jaipurWardMap.put("Moti Dungri","51,53,54,59,60,61,62,64,65");
		jaipurWardMap.put("Hawamahal Zone (East)","63,66,67,68,69,70,71,72,73,85,86");
		jaipurWardMap.put("Hawamahal Zone (West)","74,75,77,78,83,84");
		jaipurWardMap.put("Amer","87,88,89,90,91");


		//Second ward
		LinkedHashMap<String, String> bharapurWardMap=new LinkedHashMap<String, String>();
		bharapurWardMap.put("Select", "Select");
		bharapurWardMap.put("Heerra Das", "1,2,3,4,5,6,7,8,9");
		bharapurWardMap.put("Arogya Dham", "10,11,12,13,15,16");
		bharapurWardMap.put("Ketan Gate", "18,19,20,21,22");
		bharapurWardMap.put("Ghoda Ghat", "17,26,27,28,29,30");
		bharapurWardMap.put("Fire Station", "23,24,36,37,38,39,40,41,42");
		bharapurWardMap.put("Binarayan Gate", "14,25,35,31,32,33,34");
		bharapurWardMap.put("Railway Station", "43,44,45,46,47,48,49,50");

		// Kota VIGYAN NAGAR ZONE
		LinkedHashMap<String, String> kotaWardMap=new LinkedHashMap<String, String>();
		kotaWardMap.put("Select", "Select");
		kotaWardMap.put("VIGYAN NAGAR ZONE", "8,9,10,11,17,18,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,61");
		kotaWardMap.put("RAMPURA", "1,2,3,4,23,41,42,43,44,45,46,48,49,50,51,52,53,54,55,56,57,58,59,60,62,63,64,65");
		kotaWardMap.put("HEAD OFFICE", "5,6,7,12,13,14,15,16,19,20,21,22,24,47");
		/*
		 * 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60
		 */
		LinkedHashMap<String, String> udaipurWardMapp=new LinkedHashMap<String, String>();;
		udaipurWardMapp.put("Select", "Select");
		udaipurWardMapp.put("Udaipur", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55");

		LinkedHashMap<String, String> jodhpurWardMap=new LinkedHashMap<String, String>();;
		jodhpurWardMap.put("Select", "Select");
		jodhpurWardMap.put("Jodhpur", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65");


		LinkedHashMap<String, String> ajmerWardMap=new LinkedHashMap<String, String>();
		ajmerWardMap.put("Select", "Select");
		ajmerWardMap.put("Ajmer", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60");
 
		
		LinkedHashMap<String, String> bikanerWardMap=new LinkedHashMap<String, String>();
		bikanerWardMap.put("Select", "Select");
		bikanerWardMap.put("Bikaner", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60");
 
		LinkedHashMap<String, String> sikarWardMap=new LinkedHashMap<String, String>();
		sikarWardMap.put("Select", "Select");
		sikarWardMap.put("Sikar", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50");
 
		LinkedHashMap<String, String> makranaWardMap=new LinkedHashMap<String, String>();
		makranaWardMap.put("Select", "Select");
		makranaWardMap.put("Makrana", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40");
		
 
		LinkedHashMap<String, String> nagaurWardMap=new LinkedHashMap<String, String>();
		nagaurWardMap.put("Select", "Select");
		nagaurWardMap.put("Nagaur", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
		
		LinkedHashMap<String, String> alwarWardMap=new LinkedHashMap<String, String>();
		alwarWardMap.put("Select", "Select");
		alwarWardMap.put("Alwar", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50");
	
 
		LinkedHashMap<String, String> banswaraWardMap=new LinkedHashMap<String, String>();
		banswaraWardMap.put("Select", "Select");
		banswaraWardMap.put("Banswara", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
		
		LinkedHashMap<String, String> baranWardMap=new LinkedHashMap<String, String>();
		baranWardMap.put("Select", "Select");
		baranWardMap.put("baran", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> barmerWardMap=new LinkedHashMap<String, String>();
		barmerWardMap.put("Select", "Select");
		barmerWardMap.put("Barmer", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40");
	
		LinkedHashMap<String, String> bhilwaraWardMap=new LinkedHashMap<String, String>();
		bhilwaraWardMap.put("Select", "Select");
		bhilwaraWardMap.put("Bhilwara", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55");
	
		LinkedHashMap<String, String> bundiWardMap=new LinkedHashMap<String, String>();
		bundiWardMap.put("Select", "Select");
		bundiWardMap.put("Bundi", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> chittorgarWardMap=new LinkedHashMap<String, String>();
		chittorgarWardMap.put("Select", "Select");
		chittorgarWardMap.put("Chiittorgarh", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> churuWardMap=new LinkedHashMap<String, String>();
		churuWardMap.put("Select", "Select");
		churuWardMap.put("Churu", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> dausaWardMap=new LinkedHashMap<String, String>();
		dausaWardMap.put("Select", "Select");
		dausaWardMap.put("Dausa", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40");
	
		
		LinkedHashMap<String, String> dholpurWardMap=new LinkedHashMap<String, String>();
		dholpurWardMap.put("Select", "Select");
		dholpurWardMap.put("Dholpur", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> dungarpurWardMap=new LinkedHashMap<String, String>();
		dungarpurWardMap.put("Select", "Select");
		dungarpurWardMap.put("Dungarpur", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30");
		

		LinkedHashMap<String, String> hanumanWardMap=new LinkedHashMap<String, String>();
		hanumanWardMap.put("Select", "Select");
		hanumanWardMap.put("Hanuman Garh", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> jaislalmerWardMap=new LinkedHashMap<String, String>();
		jaislalmerWardMap.put("Select", "Select");
		jaislalmerWardMap.put("Jaislalmer", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35");
	 
		LinkedHashMap<String, String> jalorWardMap=new LinkedHashMap<String, String>();
		jalorWardMap.put("Select", "Select");
		jalorWardMap.put("Jalor", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30");
		
		LinkedHashMap<String, String> jhalawarWardMap=new LinkedHashMap<String, String>();
		jhalawarWardMap.put("Select", "Select");
		jhalawarWardMap.put("Jhalawar", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35");
	 
		LinkedHashMap<String, String> jhnujhunuWardMap=new LinkedHashMap<String, String>();
		jhnujhunuWardMap.put("Select", "Select");
		jhnujhunuWardMap.put("Jhunjhunu", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
	
		LinkedHashMap<String, String> karauliWardMap=new LinkedHashMap<String, String>();
		karauliWardMap.put("Select", "Select");
		karauliWardMap.put("Karauli", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40");
	
		LinkedHashMap<String, String> paliWardMap=new LinkedHashMap<String, String>();
		paliWardMap.put("Select", "Select");
		paliWardMap.put("Pali", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50");
		
		
		LinkedHashMap<String, String> pratapgarhWardMap=new LinkedHashMap<String, String>();
		pratapgarhWardMap.put("Select", "Select");
		pratapgarhWardMap.put("Pratapgarh", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30");
		
		
		LinkedHashMap<String, String> rajsamandWardMap=new LinkedHashMap<String, String>();
		rajsamandWardMap.put("Select", "Select");
		rajsamandWardMap.put("Rajsamand", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30");
		
		
		LinkedHashMap<String, String> sawaiWardMap=new LinkedHashMap<String, String>();
		sawaiWardMap.put("Select", "Select");
		sawaiWardMap.put("Sawai Madhopur", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
		
		LinkedHashMap<String, String> sirohiWardMap=new LinkedHashMap<String, String>();
		sirohiWardMap.put("Select", "Select");
		sirohiWardMap.put("Sirohi", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25");
		
		LinkedHashMap<String, String> sriGangaWardMap=new LinkedHashMap<String, String>();
		sriGangaWardMap.put("Select", "Select");
		sriGangaWardMap.put("Sri Gangaganagar", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50");
		
		LinkedHashMap<String, String> tonkWardMap=new LinkedHashMap<String, String>();
		tonkWardMap.put("Select", "Select");
		tonkWardMap.put("Tonk", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45");
		 
	
		
		//Zone list
		final LinkedHashMap<String, LinkedHashMap<String, String>> cityMap=new LinkedHashMap<String, LinkedHashMap<String, String>>();
		cityMap.put("Select", null);
		cityMap.put("Jaipur", jaipurWardMap);
		cityMap.put("Bharatpur", bharapurWardMap);
		cityMap.put("Kota", kotaWardMap);
		cityMap.put("Udaipur", udaipurWardMapp);
		cityMap.put("Jodhpur", jodhpurWardMap);
		cityMap.put("Ajmer", ajmerWardMap);
		cityMap.put("Bikaner", bikanerWardMap);
		cityMap.put("Sikar", sikarWardMap);
		cityMap.put("Makrana", makranaWardMap);
		cityMap.put("Nagaur", nagaurWardMap);
		cityMap.put("Alwar", alwarWardMap);
		cityMap.put("Banswara", banswaraWardMap);
		cityMap.put("baran", baranWardMap);
		cityMap.put("Barmer", barmerWardMap);
		cityMap.put("Bhilwara", bhilwaraWardMap);
		cityMap.put("Bundi", bundiWardMap);
		cityMap.put("Chiittorgarh", chittorgarWardMap);
		cityMap.put("Churu", churuWardMap);
		cityMap.put("Dausa", dausaWardMap);
		cityMap.put("Dholpur", dholpurWardMap);
		cityMap.put("Dungarpur", dungarpurWardMap);
		
		
		cityMap.put("Hanuman Garh", hanumanWardMap);
		cityMap.put("Jaislalmer", jaislalmerWardMap);
		cityMap.put("Jalor", jalorWardMap);
		cityMap.put("Jhalawar", jhalawarWardMap);
		cityMap.put("Jhunjhunu", jhnujhunuWardMap);
		cityMap.put("Karauli", karauliWardMap);
		cityMap.put("Pali", paliWardMap);
		cityMap.put("Pratapgarh", pratapgarhWardMap);
		cityMap.put("Rajsamand", rajsamandWardMap);
		cityMap.put("Sawai Madhopur", sawaiWardMap);
		cityMap.put("Sirohi", sirohiWardMap);
		cityMap.put("Sri Gangaganagar", sriGangaWardMap);
		cityMap.put("Tonk", tonkWardMap);


		ll_chk_constructionplot=(LinearLayout)findViewById(R.id.ll_constructonplot);
		//et_lengthfeets=(EditText)findViewById(R.id.et_lengthfeets);
		//et_widthFeets=(EditText)findViewById(R.id.et_widthfeets);
		chk_Constrution=(CheckBox)findViewById(R.id.chk_constructiononplot);
		flatno=(EditText)findViewById(R.id.et_flatno);
		ColonyName=(EditText)findViewById(R.id.et_colonyname);
		city_spinner=(Spinner)findViewById(R.id.et_city);
		final Spinner zone_spinner=(Spinner)findViewById(R.id.spn_zone);
		final Spinner ward_spinner=(Spinner)findViewById(R.id.spn_wardno);
		state=(EditText)findViewById(R.id.et_state);
		NameOfBuildin_Post=(EditText)findViewById(R.id.et_buildingdesc);
		//DetailsOfOwnership=(EditText)findViewById(R.id.et_);
		WhetherConstructionOnPlot_lenth=(EditText)findViewById(R.id.et_lengthfeets);
		WhetherConstructionOnPlot_width=(EditText)findViewById(R.id.et_widthfeets);
		//TypeOfConstruction=null;
		NameOfLaneOrRoad=(EditText)findViewById(R.id.et_laneroad);
		//Ward =(EditText)findViewById(R.id.et_w);
		Landmark=(EditText)findViewById(R.id.et_landmark);
		District=(EditText)findViewById(R.id.et_district);
		NameOfBuilding_Pre=(EditText)findViewById(R.id.et_prebuildingname);
		MultistoreyBuildigNameofBuilding=(EditText)findViewById(R.id.et_postbuildingname);
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_Prev=(Button)findViewById(R.id.btn_prev);

		/*NameOfLaneOrRoad.setText(pbean.getNameOfLane_Road().toString());
		et_lengthfeets.setText(pbean.getLength().toString());
		et_widthFeets.setText(pbean.getWidth().toString());
		flatno.setText(pbean.getNameOfLane_Road().toString());
		ColonyName.setText(pbean.getColony_Name().toString());
		City.setText(pbean.getCity().toString());
		state.setText(pbean.getState().toString());
		NameOfBuildin_Post.setText(pbean.getName_No_OfBuilding().toString());
		Landmark.setText(pbean.getLandmark().toString());
		District.setText(pbean.getDistrict().toString());
		NameOfBuilding_Pre.setText(pbean.getName_No_OfBuilding_pre().toString());
		MultistoreyBuildigNameofBuilding.setText(pbean.getMarriageGardenHall().toString());*/

		chk_Constrution.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub

				if(arg1){
					WhetherConstructionOnPlot_lenth.setEnabled(true);
					WhetherConstructionOnPlot_width.setEnabled(true);
					WhetherConstructionOnPlot_lenth.setBackgroundResource(R.drawable.textfiled);
					WhetherConstructionOnPlot_width.setBackgroundResource(R.drawable.textfiled);
				}else{

					WhetherConstructionOnPlot_lenth.setText("");
					WhetherConstructionOnPlot_width.setText("");
					WhetherConstructionOnPlot_lenth.setEnabled(false);
					WhetherConstructionOnPlot_width.setEnabled(false);
					WhetherConstructionOnPlot_lenth.setBackgroundResource(R.drawable.textfiled_dis);
					WhetherConstructionOnPlot_width.setBackgroundResource(R.drawable.textfiled_dis);
				}
			}
		});

		btn_Next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if(!flatno.getText().toString().equals("") && !NameOfLaneOrRoad.getText().toString().equals("")&& !ColonyName.getText().toString().equals("") && (!Zone_id.equals("")) && (!state.getText().toString().equals("")) && (!city.equals("")) &&(!District.getText().toString().trim().equals(""))){

					//	pbean.setPlot_Flat_ShopNo(PlotORFlatNo.getText().toString());
					pbean.setColony_Name(ColonyName.getText().toString());
					pbean.setCity(city_id);
					pbean.setState(state.getText().toString());
					//	pbean.setName_No_OfBuilding(NameOfBuildin_Post.getText().toString());
					pbean.setLength(WhetherConstructionOnPlot_lenth.getText().toString());
					pbean.setWidth(WhetherConstructionOnPlot_width.getText().toString());
					pbean.setNameOfLane_Road(NameOfLaneOrRoad.getText().toString());
					pbean.setLandmark(Landmark.getText().toString());;
					pbean.setDistrict(District.getText().toString());
					pbean.setName_No_OfBuilding_pre(NameOfBuilding_Pre.getText().toString());
					pbean.setName_No_OfBuilding(NameOfBuildin_Post.getText().toString());
					
					
					if(chk_Constrution.isChecked()==true)
						pbean.setWhetherConstructionOnPlot("1");
					else
						pbean.setWhetherConstructionOnPlot("0");

					pbean.setDetailsOfOwnership(DetailsOfOwnership);
					pbean.setZone(Zone_id);
					pbean.setWard(Ward);
					pbean.setTypOfConstruction(TypeOfConstruction);


					Intent i=new Intent(getApplicationContext(),ETaxPayerMeasurementDetails.class);
					startActivity(i);
				}else{
					Toast.makeText(getApplicationContext(), "Please enter required fields", Toast.LENGTH_LONG).show();
				}


			}
		});

		btn_Prev.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				ProperyBean pbean=ProperyBean.getInstance();
				//	pbean.setPlot_Flat_ShopNo(PlotORFlatNo.getText().toString());
				pbean.setNameOfLane_Road(NameOfLaneOrRoad.getText().toString());
				pbean.setColony_Name(ColonyName.getText().toString());
				pbean.setCity(city_id);
				pbean.setState(state.getText().toString());
				//	pbean.setName_No_OfBuilding(NameOfBuildin_Post.getText().toString());
				pbean.setLength(WhetherConstructionOnPlot_lenth.getText().toString());
				pbean.setWidth(WhetherConstructionOnPlot_width.getText().toString());
				pbean.setNameOfLane_Road(NameOfLaneOrRoad.getText().toString());
				pbean.setLandmark(Landmark.getText().toString());;
				pbean.setDistrict(District.getText().toString());
				pbean.setName_No_OfBuilding_pre(NameOfBuilding_Pre.getText().toString());
				pbean.setName_No_OfBuilding(NameOfBuildin_Post.getText().toString());

				if(chk_Constrution.isChecked()==true)
					pbean.setWhetherConstructionOnPlot("1");
				else
					pbean.setWhetherConstructionOnPlot("0");
				
				pbean.setDetailsOfOwnership(DetailsOfOwnership);
				pbean.setZone(Zone);
				pbean.setWard(Ward);
				pbean.setTypOfConstruction(TypeOfConstruction);

				onBackPressed();
			}
		});



		//adding data


		ArrayList<SpinnerItemBean> arr_cityMap=new ArrayList<SpinnerItemBean>();

		Set<String> Citykeys = cityMap.keySet();
		for(String key: Citykeys){ 
			//System.out.println(key);
			SpinnerItemBean sib=new SpinnerItemBean();
			sib.setStrItem(key);
			arr_cityMap.add(sib);
		} 

		CustomAdapter city_adapter = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, arr_cityMap,getResources());
		city_spinner.setAdapter(city_adapter);



		city_spinner.post(new Runnable() {
			@Override
			public void run() {


				city_spinner.setSelection(0);

			}
		});



		city_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View arg1,
					int arg2, long arg3) {
				if(arg2!=0)
				{
					 
					if((SpinnerItemBean)parent.getItemAtPosition(arg2)!=null)
					{
						city=((SpinnerItemBean)parent.getItemAtPosition(arg2)).getStrItem();
						city_id=""+arg2;

						LinkedHashMap<String, String> newmap =(LinkedHashMap<String, String>) cityMap.get(city);

						if(newmap!=null)
						{
							zone_spinner.setTag(newmap);
							ArrayList<SpinnerItemBean> cityArraylist=new ArrayList<SpinnerItemBean>();


							Set<String> keys = newmap.keySet();
							for(String key: keys){ 
								//System.out.println(key);
								SpinnerItemBean sib=new SpinnerItemBean();
								sib.setStrItem(key);
								cityArraylist.add(sib);
							} 

							CustomAdapter adapter = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, cityArraylist,getResources());
							zone_spinner.setAdapter(adapter);
						}
						else{
							//city="";
							zone_spinner.setTag(null);
							ArrayList<SpinnerItemBean> cityArraylist=new ArrayList<SpinnerItemBean>();
							CustomAdapter adapter = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, cityArraylist,getResources());
							zone_spinner.setAdapter(adapter);


							ArrayList<SpinnerItemBean> ward_itmeanBean=new ArrayList<SpinnerItemBean>(); 
							CustomAdapter adapter2 = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, ward_itmeanBean,getResources());
							ward_spinner.setAdapter(adapter2);
						}
					}

				}
				else{
					city="";
					city_id="";
					zone_spinner.setTag(null);
					ArrayList<SpinnerItemBean> cityArraylist=new ArrayList<SpinnerItemBean>();
					CustomAdapter adapter = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, cityArraylist,getResources());
					zone_spinner.setAdapter(adapter);


					ArrayList<SpinnerItemBean> ward_itmeanBean=new ArrayList<SpinnerItemBean>(); 
					CustomAdapter adapter2 = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, ward_itmeanBean,getResources());
					ward_spinner.setAdapter(adapter2);
				}

 

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});



		ward_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				if((SpinnerItemBean)parent.getItemAtPosition(position)!=null)
					Ward=((SpinnerItemBean)parent.getItemAtPosition(position)).getStrItem();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
		Spinner type_of_construction_spinner=(Spinner)findViewById(R.id.spn_constype);
		type_of_construction_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				TypeOfConstruction=""+position;//parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});



		Spinner details_of_owner_spinner=(Spinner)findViewById(R.id.spn_ownershipsdetails);



		details_of_owner_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				DetailsOfOwnership=""+position;//parent.getItemAtPosition(position).toString();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
		zone_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {



			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Zone=((SpinnerItemBean)parent.getItemAtPosition(position)).getStrItem();
				Zone_id=""+position;

				if(position==0)
					Zone_id="";



				if(zone_spinner.getTag()!=null)
				{
					ArrayList<SpinnerItemBean> ward_itmeanBean=new ArrayList<SpinnerItemBean>(); 
					String vaues=(String)((LinkedHashMap<String, String>)zone_spinner.getTag()).get(Zone);

					if(vaues!=null)
					{
						String valuesArray[]=	vaues.split(",");

						for(int i=0;i<valuesArray.length;i++){ 

							SpinnerItemBean sib=new SpinnerItemBean();
							sib.setStrItem(valuesArray[i]);

							ward_itmeanBean.add(sib);
						} 

						CustomAdapter adapter = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, ward_itmeanBean,getResources());
						ward_spinner.setAdapter(adapter);
					}
				}
				else{
					ArrayList<SpinnerItemBean> ward_itmeanBean=new ArrayList<SpinnerItemBean>(); 
					CustomAdapter adapter = new CustomAdapter(DTaxPayerPropertyDetails.this, R.layout.spinner_rows, ward_itmeanBean,getResources());
					ward_spinner.setAdapter(adapter);
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

	}

}
