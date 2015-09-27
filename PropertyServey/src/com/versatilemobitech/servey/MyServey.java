package com.versatilemobitech.servey;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.versatilemobitech.adapter.CustomAdapter;
import com.versatilemobitech.adapter.DatabaseHandler;
import com.versatilemobitech.bean.SpinnerModel;
import com.versatilemobitech.db.PlacesDatabaseHandler;

public class MyServey extends BaserActinbBar {
	String[] goodsTypeArray ;
	String[] passengerTypeArray ;

	String[] passengervehTypeArray ;
	String[] goodsvehTypeArray ;

	String photoPath="";
	Button btn_save;
	String str_adress="";
	AutoCompleteTextView et_origin,et_destination;
	EditText et_times,et_tons,et_occupancy;
	double latitude;
	double longitude;
	String toDay_DATE;
	String[] language;
	String[] goods_commodity;
	String[] passenger_commodity;
	String[] tripfrq;
	public  ArrayList<SpinnerModel> CustomListViewValuesArr = new ArrayList<SpinnerModel>();
	TextView output = null,tv_occupation,tv_commoditytype,tv_wtons,txt_occupancy,tv_date;
	CustomAdapter adapter;
	MyServey activity = null;
	RadioGroup rg_vehtype,rg_roundTrip,rg_monthlypass,rg_willpaytoll;
	Spinner  spinner_vehType,spn_tripfreq,spn_commodity;
	EditText et_UserName=null;
	EditText et_Password=null;
	GPSTracker gpsTracker;

	//private TextView batinfo=null;
	DatabaseHandler db_Handler;


	private static final int ACTION_TAKE_PHOTO_B = 1;
	//private static final int ACTION_TAKE_PHOTO_S = 2;
	//private static final int ACTION_TAKE_VIDEO = 3;

	RadioGroup rg_goods_Passengers;

	private ImageView mImageView;
	//	private Bitmap mImageBitmap;

	 

	private String mCurrentPhotoPath;
	//private final String USER_PREF_FILE_NAME="user_time";

	private static final String JPEG_FILE_PREFIX = "IMG_";
	private static final String JPEG_FILE_SUFFIX = ".jpg";

	private AlbumStorageDirFactory mAlbumStorageDirFactory = null;

	final PlacesDatabaseHandler dbObj = new PlacesDatabaseHandler(this);


	/* Photo album for this application */
	private String getAlbumName() {


		String time=getCurrentTimeStamp();
		String prefixDate=time.split(":")[0];

		int minuts=Integer.parseInt(time.split(":")[1]);

		String minutFrame="";
		if(minuts<=30)
		{
			minutFrame="0-29";
		}
		else{
			minutFrame="30-59";
		}


		return prefixDate;
	}


	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");//dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}


	private File getAlbumDir() {
		File storageDir = null;

		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

			storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());

			if (storageDir != null) {
				if (! storageDir.mkdirs()) {
					if (! storageDir.exists()){
						Log.d("CameraSample", "failed to create directory");
						return null;
					}
				}
			}

		} else {
			Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
		}

		return storageDir;
	}

	private File createImageFile() throws IOException {
		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
		File albumF = getAlbumDir();
		File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
		return imageF;
	}

	private File setUpPhotoFile() throws IOException {

		File f = createImageFile();
		mCurrentPhotoPath = f.getAbsolutePath();

		return f;
	}

	private void setPic() {

		/* There isn't enough memory to open up more than a couple camera photos */
		/* So pre-scale the target bitmap into which the file is decoded */

		/* Get the size of the ImageView */
		int targetW = mImageView.getWidth();
		int targetH = mImageView.getHeight();

		/* Get the size of the image */
		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		bmOptions.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
		int photoW = bmOptions.outWidth;
		int photoH = bmOptions.outHeight;

		/* Figure out which way needs to be reduced less */
		int scaleFactor = 1;
		if ((targetW > 0) || (targetH > 0)) {
			scaleFactor = Math.min(photoW/targetW, photoH/targetH);	
		}

		/* Set bitmap options to scale the image decode target */
		bmOptions.inJustDecodeBounds = false;
		bmOptions.inSampleSize = scaleFactor;
		bmOptions.inPurgeable = true;

		/* Decode the JPEG file into a Bitmap */
		Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

		System.out.println("CURRENT PATH PHOTO"+mCurrentPhotoPath);
		photoPath=mCurrentPhotoPath;
		/* Associate the Bitmap to the ImageView */										
		mImageView.setVisibility(View.VISIBLE);
		mImageView.setImageBitmap(bitmap);
		//mVideoUri = null;
	}

	 

	private void dispatchTakePictureIntent(int actionCode) {

		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		switch(actionCode) {
		case ACTION_TAKE_PHOTO_B:
			File f = null;

			try {
				f = setUpPhotoFile();
				mCurrentPhotoPath = f.getAbsolutePath();
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
				System.out.println("");
			} catch (IOException e) {
				e.printStackTrace();
				//	f = null;
				//	mCurrentPhotoPath = null;
			}
			break;

		default:
			break;			
		} // switch

		startActivityForResult(takePictureIntent, actionCode);
	}



	private void handleBigCameraPhoto() {

		if (mCurrentPhotoPath != null) {
			setPic();
			//galleryAddPic();
			mCurrentPhotoPath = null;
		}

	}


	Button.OnClickListener mTakePicOnClickListener = 
			new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			dispatchTakePictureIntent(ACTION_TAKE_PHOTO_B);
		}
	};

	Geocoder geocoder;
	private EditText trip_length=null;
	private LinearLayout trip_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_servey);

		
		
		 //setupActionBar();
		
		db_Handler=new DatabaseHandler(getApplicationContext());

		txt_occupancy=(TextView)findViewById(R.id.txt_occupancy);
		et_origin=(AutoCompleteTextView)findViewById(R.id.et_origin);
		et_destination=(AutoCompleteTextView)findViewById(R.id.et_destination);
		et_times=(EditText)findViewById(R.id.et_times);
		tv_wtons=(TextView)findViewById(R.id.tv_wtons);
		et_tons=(EditText)findViewById(R.id.et_wtons);
		//	et_tripLength=(EditText)findViewById(R.id.et_triplength);
		//tv_occupation=(TextView)findViewById(R.id.txt_occupancy);
		et_occupancy=(EditText)findViewById(R.id.et_occupancy);
		tv_commoditytype=(TextView)findViewById(R.id.tv_commoditytype);
		btn_save=(Button) findViewById(R.id.btn_save);
		spinner_vehType = (Spinner)findViewById(R.id.spn_vehtype);
		spn_commodity=(Spinner)findViewById(R.id.spn_commodity);
		spn_tripfreq=(Spinner)findViewById(R.id.spn_tripfrq);
		goodsTypeArray = getResources().getStringArray(R.array.gooodstype);
		passengerTypeArray= getResources().getStringArray(R.array.passengertype);
		tripfrq=getResources().getStringArray(R.array.tripFreq);
		goodsvehTypeArray = getResources().getStringArray(R.array.goodsvehArr);
		goods_commodity=getResources().getStringArray(R.array.goods_commodity);
		passenger_commodity=getResources().getStringArray(R.array.pass_commodity);
		language=getResources().getStringArray(R.array.regno_Arr);
		passengervehTypeArray = getResources().getStringArray(R.array.passengerVehArr);
		rg_vehtype=(RadioGroup)findViewById(R.id.myRadioGroup);
		tv_date=(TextView)findViewById(R.id.tv_dateview);
		trip_length=(EditText)findViewById(R.id.et_trip_lenght);
		
		trip_layout=(LinearLayout)findViewById(R.id.trip_laout);

		Date dNow = new Date( );
		SimpleDateFormat ft = 
				new SimpleDateFormat ("dd-MM-yyyy hh:mm");
		 
		// System.out.println("Current Date: " + ft.format(dNow));
		//tv_date.setText(ft.format(dNow));
		//batinfo.setText(ft.format(dNow));

		rg_roundTrip=(RadioGroup)findViewById(R.id.rg_roundtrip);
		rg_monthlypass=(RadioGroup)findViewById(R.id.rg_mpass);
		rg_willpaytoll=(RadioGroup)findViewById(R.id.rg_wptoll);
		rg_goods_Passengers=(RadioGroup)findViewById(R.id.myRadioGroup);
		txt_occupancy.setVisibility(View.GONE);
		et_occupancy.setVisibility(View.GONE);
		registerReceiver(mbcr,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

		activity  = this;
		geocoder = new Geocoder(this, Locale.ENGLISH);
		//  gpsTracker = new GPSTracker(MyServey.this);
		ArrayAdapter<String> acadapter = new ArrayAdapter<String>  
		(this,android.R.layout.select_dialog_item,language);  
		//Getting the instance of AutoCompleteTextView  
		AutoCompleteTextView actv= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);  
		actv.setThreshold(1);//will start working from first character  
		actv.setAdapter(acadapter);//setting the adapter data into the AutoCompleteTextView  
		actv.setTextColor(Color.WHITE);  
		setGoodsListData();

		Resources res = getResources(); 
	//	adapter = new CustomAdapter(activity, R.layout.spinner_rows, CustomListViewValuesArr,res);
		spinner_vehType.setAdapter(adapter);

		ArrayAdapter<String> adapter_tripfreq = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line, tripfrq);

		ArrayAdapter<String> adapter_commodity = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line, goods_commodity);

		spn_commodity.setAdapter(adapter_commodity);
		spn_tripfreq.setAdapter(adapter_tripfreq);

		rg_vehtype.setOnCheckedChangeListener(new OnCheckedChangeListener() {



			@Override

			public void onCheckedChanged(RadioGroup group, int checkedId) {

				// find which radio button is selected

				if(checkedId == R.id.goods) {
					CustomListViewValuesArr.clear();
					setGoodsListData();
					Resources res = getResources(); 
				//	adapter = new CustomAdapter(activity, R.layout.spinner_rows, CustomListViewValuesArr,res);
					spinner_vehType.setAdapter(adapter);

				} else if(checkedId == R.id.passengers) {
					CustomListViewValuesArr.clear();
					setPassengerListData();
					Resources res = getResources(); 
					//adapter = new CustomAdapter(activity, R.layout.spinner_rows, CustomListViewValuesArr,res);
					spinner_vehType.setAdapter(adapter);


				}




			}

		});



		mImageView = (ImageView) findViewById(R.id.catute_image);
		//mVideoView = (VideoView) findViewById(R.id.videoView1);
		//mImageBitmap = null;
		//	mVideoUri = null;

		TextView picBtn = (TextView) findViewById(R.id.btn_camera);
		setBtnListenerOrDisable( 
				picBtn, 
				mTakePicOnClickListener,
				MediaStore.ACTION_IMAGE_CAPTURE
				);



		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
			mAlbumStorageDirFactory = new FroyoAlbumDirFactory();
		} else {
			mAlbumStorageDirFactory = new BaseAlbumDirFactory();
		}

		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				String vehregno =CustomListViewValuesArr.get(spinner_vehType.getSelectedItemPosition()).getCompanyName().toString();
				String veh_comd = spn_commodity.getSelectedItem().toString();
				String veh_frq = spn_tripfreq.getSelectedItem().toString();
				System.out.println("veh reg no"+vehregno);

				int selected_vehType=rg_goods_Passengers.getCheckedRadioButtonId();
				int selected_roundtrip = rg_roundTrip.getCheckedRadioButtonId();
				int selected_monthlypass = rg_monthlypass.getCheckedRadioButtonId();
				int selected_paytoll = rg_willpaytoll.getCheckedRadioButtonId();

				RadioButton rb_sel_roundtrip = (RadioButton) findViewById(selected_roundtrip);
				RadioButton rb_sel_monthlypass = (RadioButton) findViewById(selected_monthlypass);
				RadioButton rb_sel_paytoll = (RadioButton) findViewById(selected_paytoll);
				RadioButton rb_sel_goods = (RadioButton) findViewById(selected_vehType);


				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
				toDay_DATE= sdf.format(new Date());

				if(rb_sel_goods.getText().toString().equalsIgnoreCase("\tGoods")){
					if(vehregno.length()!=0 && et_origin.getText().toString().length()!=0 && et_destination.getText().toString().length()!=0
							&& veh_comd.length()!=0 && et_times.length()!=0 && veh_frq.length()!=0 
							&& et_tons.getText().toString().length()!=0 &&trip_length.getText().toString().length()!=0){

						ContentValues cv_values=new ContentValues();
				/*		cv_values.put(DatabaseHandler.VEH_REG_NO,vehregno);
						cv_values.put(DatabaseHandler.ORIGIN,et_origin.getText().toString());
						cv_values.put(DatabaseHandler.DESTINATION,et_destination.getText().toString());
						cv_values.put(DatabaseHandler.COMMODITY,veh_comd);
						cv_values.put(DatabaseHandler.OCCUPANCY,"-NA-");
						cv_values.put(DatabaseHandler.TRIP_TIME,et_times.getText().toString());
						cv_values.put(DatabaseHandler.TRIP_FREQ,veh_frq);
						cv_values.put(DatabaseHandler.TRIP_LENGTH,trip_length.getText().toString());
						cv_values.put(DatabaseHandler.RETURN_TRIP,rb_sel_roundtrip.getText().toString());
						cv_values.put(DatabaseHandler.MONTHLY_PASS,rb_sel_monthlypass.getText().toString());
						cv_values.put(DatabaseHandler.WEIGHT_IN_TONS,et_tons.getText().toString());
						cv_values.put(DatabaseHandler.PAY_TOLL,rb_sel_paytoll.getText().toString());
						cv_values.put(DatabaseHandler.LATITUDE_LONGITUDE,"http://maps.google.com/?q="+latitude+","+longitude); 
						*///cv_values.put(DatabaseHandler.LONGITUDE,longitude);
					//	cv_values.put(DatabaseHandler.IMAGEPATH,photoPath);
						cv_values.put(DatabaseHandler.CREATED_DATE,toDay_DATE);
						db_Handler.insert(DatabaseHandler.TABLE_servey_Data, cv_values);

						//   finish();
						Intent i=new Intent(getApplicationContext(), MainActivity.class);
						startActivity(i);
						finish();

						Toast.makeText(getApplicationContext(), "Goods Data saved Successfully", Toast.LENGTH_LONG).show();

					}else{
						Toast.makeText(getApplicationContext(), "Please enter all fields!", Toast.LENGTH_LONG).show();
					}
				}else if(rb_sel_goods.getText().toString().equalsIgnoreCase("\tPassenger")){
					if(vehregno.length()!=0 && et_origin.getText().toString().length()!=0 && et_destination.getText().toString().length()!=0
							&& veh_comd.length()!=0 && et_times.length()!=0 && veh_frq.length()!=0 && et_occupancy.getText().toString().length()!=0
							){

						ContentValues cv_values=new ContentValues();
					/*	cv_values.put(DatabaseHandler.VEH_REG_NO,vehregno);
						cv_values.put(DatabaseHandler.ORIGIN,et_origin.getText().toString());
						cv_values.put(DatabaseHandler.DESTINATION,et_destination.getText().toString());
						cv_values.put(DatabaseHandler.OCCUPANCY,et_occupancy.getText().toString());
						cv_values.put(DatabaseHandler.COMMODITY,veh_comd);
						cv_values.put(DatabaseHandler.TRIP_TIME,et_times.getText().toString());
						cv_values.put(DatabaseHandler.TRIP_FREQ,veh_frq);
						cv_values.put(DatabaseHandler.RETURN_TRIP,rb_sel_roundtrip.getText().toString());
						cv_values.put(DatabaseHandler.MONTHLY_PASS,rb_sel_monthlypass.getText().toString());
						cv_values.put(DatabaseHandler.WEIGHT_IN_TONS,"-NA-");
						cv_values.put(DatabaseHandler.PAY_TOLL,rb_sel_paytoll.getText().toString());
						cv_values.put(DatabaseHandler.LATITUDE_LONGITUDE,"http://maps.google.com/?q="+latitude+","+longitude);
						//   cv_values.put(DatabaseHandler.LONGITUDE,longitude);
						cv_values.put(DatabaseHandler.TRIP_LENGTH,"-NA-");*/
					//	cv_values.put(DatabaseHandler.IMAGEPATH,mCurrentPhotoPath);
						cv_values.put(DatabaseHandler.CREATED_DATE,toDay_DATE);
						db_Handler.insert(DatabaseHandler.TABLE_servey_Data, cv_values);

						//   finish();
						Intent i=new Intent(getApplicationContext(), MainActivity.class);
						startActivity(i);
						finish();
						Toast.makeText(getApplicationContext(), "Passengers Data saved Successfully", Toast.LENGTH_LONG).show();

					}else{
						Toast.makeText(getApplicationContext(), "Please enter all fields!", Toast.LENGTH_LONG).show();
					}
				}


			}  
		});



		 /*final ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle(getString(R.string.app_name)+"\t"+ft.format(dNow));
		 actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.iconbg)); */
		
	


		gpsTracker = new GPSTracker(MyServey.this);
		// check if GPS enabled		
		if(gpsTracker.canGetLocation()){
			latitude = gpsTracker.getLatitude();
			longitude = gpsTracker.getLongitude();
		}else{
			gpsTracker.showSettingsAlert();
			Toast.makeText(MyServey.this, "Please turn on GPS", Toast.LENGTH_LONG).show();
		} 




		et_origin.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {

				try{
					ArrayList<String> list=dbObj.getDetails((new StringBuilder("SELECT town,district,state FROM india_master WHERE town LIKE '")).append(s.toString()).append("%' LIMIT 10").toString());

					ArrayAdapter<String> acadapter = new ArrayAdapter<String>  
					(MyServey.this,android.R.layout.select_dialog_item,list); 
					et_origin.setThreshold(0);
					et_origin.setAdapter(acadapter);
				}catch(Exception e)
				{
					e.printStackTrace();
				}

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}


		});

		et_destination.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				try{
					ArrayList<String> list=dbObj.getDetails((new StringBuilder("SELECT town,district,state FROM india_master WHERE town LIKE '")).append(s.toString()).append("%' LIMIT 10").toString());

					ArrayAdapter<String> acadapter = new ArrayAdapter<String>  
					(MyServey.this,android.R.layout.select_dialog_item,list); 
					et_destination.setThreshold(0);
					et_destination.setAdapter(acadapter);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});


	}
	
	
 /*	private void setupActionBar() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setIcon(R.drawable.ic_launcher);
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.action_bar_title, null);

       // TextView titleTV = (TextView) v.findViewById(R.id.title);
        
        //batinfo=(TextView) v.findViewById(R.id.batt_info);
        ab.setCustomView(v);
       // ab.seth

          //  ab.setHomeAsUpEnabled(true);
    } */

	public static boolean isIntentAvailable(Context context, String action) {
		final PackageManager packageManager = context.getPackageManager();
		final Intent intent = new Intent(action);
		List<ResolveInfo> list =
				packageManager.queryIntentActivities(intent,
						PackageManager.MATCH_DEFAULT_ONLY);
		return list.size() > 0;
	}

	private void setBtnListenerOrDisable( 
			TextView btn, 
			TextView.OnClickListener onClickListener,
			String intentName
			) {
		if (isIntentAvailable(this, intentName)) {
			btn.setOnClickListener(onClickListener);        	
		} else {
			btn.setText( 
					getText(R.string.cannot).toString() + " " + btn.getText());
			btn.setClickable(false);
		}
	}

	public void startSurvey()

	{
		Intent mapIntent=new Intent(getApplicationContext(), MyServey.class);

		startActivity(mapIntent);
	}
	public void setGoodsListData()
	{

		tv_commoditytype.setText("Commodity Type");

		ArrayAdapter<String> adapter_commodity = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line, goods_commodity);

		spn_commodity.setAdapter(adapter_commodity);
		tv_wtons.setVisibility(View.VISIBLE);
		et_tons.setVisibility(View.VISIBLE);
		trip_layout.setVisibility(View.VISIBLE);

		txt_occupancy.setVisibility(View.GONE);
		et_occupancy.setVisibility(View.GONE);
		for (int i =0; i < goodsTypeArray.length; i++) {

			final SpinnerModel sched = new SpinnerModel();


			sched.setCompanyName(goodsTypeArray[i]);

			sched.setImage(goodsvehTypeArray[i]);
			CustomListViewValuesArr.add(sched);
		}




	}
	public void setPassengerListData()
	{
		ArrayAdapter<String> adapter_commodity = new ArrayAdapter<String>(this,  android.R.layout.simple_dropdown_item_1line, passenger_commodity);
		tv_wtons.setVisibility(View.GONE);
		et_tons.setVisibility(View.GONE);
		trip_layout.setVisibility(View.GONE);
		spn_commodity.setAdapter(adapter_commodity);
		tv_commoditytype.setText("Purpose");

		txt_occupancy.setVisibility(View.VISIBLE);
		et_occupancy.setVisibility(View.VISIBLE);
		for (int i = 0; i <passengerTypeArray.length; i++) {

			final SpinnerModel sched = new SpinnerModel();

			sched.setCompanyName(passengerTypeArray[i]);
			sched.setImage(passengervehTypeArray[i]);

			CustomListViewValuesArr.add(sched);
		}

	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case ACTION_TAKE_PHOTO_B: {
			if (resultCode == RESULT_OK) {
				handleBigCameraPhoto();
			}
			break;
		} // ACTION_TAKE_PHOTO_B

		} // switch
	}

 
	 

	private BroadcastReceiver mbcr=new BroadcastReceiver()
	{
		public void onReceive(Context c, Intent i)
		{
			tv_date.setText("");
			//batinfo.setText("");
			int level=i.getIntExtra("level", 0);

			//Date dNow = new Date( );
			/*SimpleDateFormat ft = 
					new SimpleDateFormat ("dd-MM-yyyy hh:mm");*/
			tv_date.setText( "Battery remaining:"+Integer.toString(level)+"%");
			 
		}
	};

	
	@Override
	public void onBackPressed() {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				MyServey.this);

		// set title
		alertDialogBuilder.setTitle(getString(R.string.app_name));
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);

		// set dialog message
		alertDialogBuilder
		.setMessage("Do you want to Exit")
		.setCancelable(false)
		.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// if this button is clicked, close
				// current activity
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i); 
				MyServey.this.finish();
			}
		})
		.setNegativeButton("No",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// if this button is clicked, just close
				// the dialog box and do nothing
				dialog.cancel();
			}
		});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();


	}


}
