package com.versatilemobitech.servey;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings.Secure;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.versatilemobitech.adapter.DatabaseHandler;
import com.versatilemobitech.bean.ProperyBean;

public class MyServey extends BaserActinbBar {
	String photoPath="";
	Button btn_save;
	String str_adress="";

	double latitude;
	double longitude;
	String toDay_DATE;

	Activity activity = null;

	//GPSTracker gpsTracker;

	//private TextView batinfo=null;
	DatabaseHandler db_Handler;


	private static final int ACTION_TAKE_PHOTO_A = 1;
	private static final int ACTION_TAKE_PHOTO_B = 2;
	 
	private DatabaseHandler dbHandler;

	private String mCurrentPhotoPath;
	private String mCurrentPhotoPath2;
	 

	private static final String JPEG_FILE_PREFIX = "IMG_";
	private static final String JPEG_FILE_SUFFIX = ".jpg";

	private AlbumStorageDirFactory mAlbumStorageDirFactory = null;



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

		String path= getResources().getString(R.string.external_dir) + "/";

		return path;
		//return prefixDate;
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

	private void setPic(ImageView img, String imageName) {

		/* There isn't enough memory to open up more than a couple camera photos */
		/* So pre-scale the target bitmap into which the file is decoded */

		/* Get the size of the ImageView */
		int targetW = img.getWidth();
		int targetH = img.getHeight();

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

		
		
		File exportDir = new File(Environment.getExternalStorageDirectory(), "/"+getResources().getString(R.string.external_dir));        
		if (!exportDir.exists()) 
		{
			exportDir.mkdirs();
		}  
		
		
		
		String android_id = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID); 
		SharedPreferences preferences=getSharedPreferences("TAB_DATA",MODE_PRIVATE);
		int existingRow=  preferences.getInt("ROW_ID", 0);

		
      File f=new File(Environment.getExternalStorageDirectory(), "/"+getResources().getString(R.string.external_dir)+"/"+"RJ_JPR"+"_"+ProperyBean.getInstance().getZone()+"_"+ProperyBean.getInstance().getWard()+"_"+android_id.substring(0, 3)+"_"+(existingRow+1)+"_"+imageName);

      //System.out.println("TEST path of image"+f.getAbsolutePath());
		//create a file to write bitmap data
		 
      if(imageName.equalsIgnoreCase("property_img.png"))
      {
    	  ProperyBean.getInstance().setPhotoOfPropertyImgPath(f.getAbsolutePath());
      }
      else{
    	  ProperyBean.getInstance().setPhotoOfSitePlanImgPath(f.getAbsolutePath());
      }
		try {
			f.createNewFile();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bitmap.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
			byte[] bitmapdata = bos.toByteArray();

			//write the bytes in file
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bitmapdata);
			fos.flush();
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Convert bitmap to byte array
		 
		
		
		 
		System.out.println("CURRENT PATH PHOTO"+mCurrentPhotoPath);
		photoPath=mCurrentPhotoPath;
		/* Associate the Bitmap to the ImageView */										
		img.setVisibility(View.VISIBLE);
		img.setImageBitmap(bitmap);
		//mVideoUri = null;
	}


	
 

	private void dispatchTakePictureIntent(int actionCode) {

		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		switch(actionCode) {
		case ACTION_TAKE_PHOTO_B:
			File f = null;

			try {
				f = setUpPhotoFile();
				mCurrentPhotoPath2= f.getAbsolutePath();
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
				System.out.println("TEST img"+mCurrentPhotoPath2);
			} catch (IOException e) {
				e.printStackTrace();
				//	f = null;
				//	mCurrentPhotoPath = null;
			}
			break;


		case ACTION_TAKE_PHOTO_A:
			File f2 = null;

			try {
				f2 = setUpPhotoFile();
				mCurrentPhotoPath = f2.getAbsolutePath();
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f2));
				 
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



	private void handleBigCameraPhoto(ImageView img, String imageName) {

		if (mCurrentPhotoPath != null) {
			setPic(img,imageName);
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


	Button.OnClickListener mTakePicTwoOnClickListener = 
			new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			dispatchTakePictureIntent(ACTION_TAKE_PHOTO_A);
		}
	};

	Geocoder geocoder;
	private EditText trip_length=null;
	private LinearLayout trip_layout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_servey);

		dbHandler=new DatabaseHandler(getApplicationContext());

		//setupActionBar();



		//	et_tripLength=(EditText)findViewById(R.id.et_triplength);
		//tv_occupation=(TextView)findViewById(R.id.txt_occupancy);
		btn_save=(Button) findViewById(R.id.btn_save);

		Date dNow = new Date( );
		SimpleDateFormat ft = 
				new SimpleDateFormat ("dd-MM-yyyy hh:mm");
		activity  = this;
		geocoder = new Geocoder(this, Locale.ENGLISH);


		TextView picBtn = (TextView) findViewById(R.id.btn_camera);
		setBtnListenerOrDisable( 
				picBtn, 
				mTakePicOnClickListener,
				MediaStore.ACTION_IMAGE_CAPTURE
				);


		TextView picBtn2 = (TextView) findViewById(R.id.btn_camera1);

		setBtnListenerOrDisable( 
				picBtn2, 
				mTakePicTwoOnClickListener,
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

				MyDBTask dbTask=new MyDBTask();
				dbTask.execute();
			}  
		});



		/*	gpsTracker = new GPSTracker(MyServey.this);
		// check if GPS enabled		
		if(gpsTracker.canGetLocation()){
			latitude = gpsTracker.getLatitude();
			longitude = gpsTracker.getLongitude();
		}else{
			gpsTracker.showSettingsAlert();
			Toast.makeText(MyServey.this, "Please turn on GPS", Toast.LENGTH_LONG).show();
		} */
	}
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
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case ACTION_TAKE_PHOTO_B: {
			if (resultCode == RESULT_OK) {


				handleBigCameraPhoto((ImageView) findViewById(R.id.catute_image),"property_img.png");
			}
			break;

		} // ACTION_TAKE_PHOTO_B

		case ACTION_TAKE_PHOTO_A:
			handleBigCameraPhoto((ImageView) findViewById(R.id.catute_image2),"sitePlan_img.png");
			break;
		}// switch
	}


	class MyDBTask extends AsyncTask<Void, Void, Boolean>
	{
		ProgressDialog progrssDialog=null;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			progrssDialog=new ProgressDialog(activity);
			progrssDialog.setMessage("Saving...");
			progrssDialog.show();
		}

		@Override
		protected Boolean doInBackground(Void... params) {






			boolean isSucess=false;

			SQLiteDatabase sqldb = dbHandler.getReadableDatabase(); //My Database class
			Cursor cursor = null;
			// TODO Auto-generated method stub
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
			toDay_DATE= sdf.format(new Date());

			ProperyBean pbean=ProperyBean.getInstance();

			cursor = sqldb.rawQuery("select * from SERVEY_Owner_Details",null);//WHERE CREATED_DATE >='"+toDay_DATE+"_00:00:00'", null);


			int rowcount=cursor.getCount();
			ContentValues cv_Values=new ContentValues();
			//cv_Values.put(dbHandler.AddressforCommunication,pbean.getAddressforCommunication());
			//cv_Values.put(dbHandler.AdvertisementHoarding,pbean.get);

			cv_Values.put(dbHandler.BasicPhoneNo,pbean.getBasicPhoneNo());
			cv_Values.put(dbHandler.BasicPhoneNo_Address,pbean.getBasicPhoneNo_Address());
			cv_Values.put(dbHandler.BeautyParlour,pbean.getBeautyParlour());
			cv_Values.put(dbHandler.Boring,pbean.getBoring());
			cv_Values.put(dbHandler.building_id,""+rowcount+"_b");//pbean.getBuildingId());
			cv_Values.put(dbHandler.Owner_id, ""+rowcount+"_W");
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
			 cv_Values.put(dbHandler.AddressforCommunication,pbean.getAddressforCommunication());
			 cv_Values.put(dbHandler.Zone,pbean.getZone());
			 cv_Values.put(dbHandler.Ward,pbean.getWard());
			cv_Values.put(dbHandler.Others,pbean.getOthers());
			cv_Values.put(dbHandler.OutOfRicoIndustries,pbean.getOutOfRicoIndustries());
			//	cv_Values.put(dbHandler.owner_name,pbean.getO);
			//		cv_Values.put(dbHandler.profession,pbean.getpr);
			cv_Values.put(dbHandler.Parking,pbean.getParking());
			cv_Values.put(dbHandler.PermanentAddress,pbean.getPermanentAddress());
			//cv_Values.put(dbHandler.PermanentAddress_Address,pbean.getAddressforCommunication());
			cv_Values.put(dbHandler.PipedWaterConnection,pbean.getPipedWaterConnection());
			 cv_Values.put(dbHandler.WhetherConstructionOnPlot,pbean.getWhetherConstructionOnPlot());
			 cv_Values.put(dbHandler.IncaseofMultistoreyBuilding,pbean.getIncaseofMultistoreyBuilding());
			 cv_Values.put(dbHandler.TotalConstructionArea,pbean.getTotalConstructionArea());
			 
			 
			 cv_Values.put(dbHandler.Width,pbean.getWidth());
			 cv_Values.put(dbHandler.GeneralDegreeCollege,pbean.getGeneralDegreeCollege());
			 cv_Values.put(dbHandler.CoachingInstitute,pbean.getCoachingInstitute());
			 cv_Values.put(dbHandler.AdvertisementHoarding,pbean.getAdvertisementHoarding());
			 cv_Values.put(dbHandler.WhetherpayUdTax,pbean.getWhetherpayUdTax());
			 cv_Values.put(dbHandler.WhetherpayLeaseTax,pbean.getWhetherpayLeaseTax());
			 cv_Values.put(dbHandler.WhetherpayUdTax_ACNo,pbean.getWhetherpayUdTax_ACNo());
			 cv_Values.put(dbHandler.WhetherpayLeaseTax_ACNo,pbean.getWhetherpayLeaseTax_ACNo());
			 
			 
			cv_Values.put(dbHandler.PlinthArea,pbean.getPlinthArea());
			cv_Values.put(dbHandler.PlinthYard,pbean.getPlinthYard());
			cv_Values.put(dbHandler.Plot_Flat_ShopNo,pbean.getPlot_Flat_ShopNo());
			cv_Values.put(dbHandler.PrivateHospitalClinic,pbean.getPrivateHospitalClinic());
			cv_Values.put(dbHandler.PrivateOffice,pbean.getPrivateOffice());
			cv_Values.put(dbHandler.PrivateToilet,pbean.getPrivateToilet());
			cv_Values.put(dbHandler.ProfessionalCollege,pbean.getProfessionalCollege());
			cv_Values.put(dbHandler.relationshipOfOwner,pbean.getRelationshipOfOwner());
			cv_Values.put(dbHandler.ReligiousPlace,pbean.getReligiousPlace());
			cv_Values.put(dbHandler.Residential,pbean.getResidential());
			cv_Values.put(dbHandler.Residentialcum_commercial,pbean.getResidentialcum_commercial());
			cv_Values.put(dbHandler.School,pbean.getSchool());
			cv_Values.put(dbHandler.SemiGovtInstitute,pbean.getSemiGovtInstitute());
			cv_Values.put(dbHandler.SepticTank,pbean.getSepticTank());
			cv_Values.put(dbHandler.SewerConnection,pbean.getSewerConnection());
			cv_Values.put(dbHandler.SewerLine,pbean.getSewerLine());
			cv_Values.put(dbHandler.SituatedInRicoArea,pbean.getSituatedInRicoArea());
			cv_Values.put(dbHandler.State,pbean.getState());
			cv_Values.put(dbHandler.StateGovtPropertyOffice,pbean.getStateGovtPropertyOffice());
			cv_Values.put(dbHandler.StreetLight,pbean.getStreetLight());
			cv_Values.put(dbHandler.SurveyorAddress,pbean.getSurveyorAddress());
			cv_Values.put(dbHandler.TotalPlotArea,pbean.getTotalPlotArea());
			cv_Values.put(dbHandler.TotalPlotYard,pbean.getTotalPlotYard());
			cv_Values.put(dbHandler.TypOfConstruction,pbean.getTypOfConstruction());
			cv_Values.put(dbHandler.VacantArea,pbean.getVacantArea());
			cv_Values.put(dbHandler.VacantYard,pbean.getVacantYard());   
			cv_Values.put(dbHandler.CREATED_DATE,toDay_DATE);   
			//“RJ/JPR/(ZONE)/(WARD)/Tablet No./Sequence No.”

			/**
			 * Image insert
			 */
			cv_Values.put(dbHandler.signatureIMG,pbean.getSignatureImgPath().replace(""+Environment.getExternalStorageDirectory().toString(), ""));  
			cv_Values.put(dbHandler.propertyIMG,pbean.getPhotoOfPropertyImgPath().replace(""+Environment.getExternalStorageDirectory().toString(), ""));  
			cv_Values.put(dbHandler.siteImage,pbean.getPhotoOfSitePlanImgPath().replace(""+Environment.getExternalStorageDirectory().toString(), ""));
			
			
			String android_id = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID); 
			SharedPreferences preferences=getSharedPreferences("TAB_DATA",MODE_PRIVATE);
			int existingRow=  preferences.getInt("ROW_ID", 0);

			cv_Values.put(dbHandler.FormID,"RJ/JPR"+"/"+pbean.getZone()+"/"+pbean.getWard()+"/"+android_id.substring(0, 3)+"/"+(existingRow+1));//RJ/JPR/ZONE1/WARD1/Tablet1/Seq1");
			long insterResult=dbHandler.insert(dbHandler.TABLE_servey_Data, cv_Values);

			System.out.println("Test insert ::::"+insterResult);

			if(insterResult>=0)
				isSucess=true;
			else
				return false;
			 
			for (int i = 0; i <ProperyBean.getInstance().getBulidList().size(); i++) {

				ContentValues cvbld=new ContentValues();
				cvbld.put(dbHandler.building_id, ""+rowcount+"_B");
				cvbld.put(dbHandler.Total_Area_sft, ProperyBean.getInstance().getBulidList().get(i).getTotalAreaInSqFt());
				cvbld.put(dbHandler.Total_Area_Yard, ProperyBean.getInstance().getBulidList().get(i).getTotalAreaInYard());
				cvbld.put(dbHandler.Floor_No, ProperyBean.getInstance().getBulidList().get(i).getDetailsoffloor());
				cvbld.put(dbHandler.Land_Use, ProperyBean.getInstance().getBulidList().get(i).getLandUse());


				long buildResult=dbHandler.insert(dbHandler.TABLE_Building_Data, cvbld);

				if(buildResult>=0)
					isSucess=true;
				else
					return false;
			}

			for (int i = 0; i < ProperyBean.getInstance().getNameList().size(); i++) {

				ContentValues cvowner=new ContentValues();
				cvowner.put(dbHandler.Owner_id, ""+rowcount+"_W");
				cvowner.put(dbHandler.age, ProperyBean.getInstance().getNameList().get(i).getAge());
				cvowner.put(dbHandler.owner_name, ProperyBean.getInstance().getNameList().get(i).getName());
				cvowner.put(dbHandler.OwnerFatherName,ProperyBean.getInstance().getNameList().get(i).getNameOfFatherorHusband());
				cvowner.put(dbHandler.profession,ProperyBean.getInstance().getNameList().get(i).getProfession());


				long ownerResult=dbHandler.insert(dbHandler.TABLE_Owner_Data, cvowner);

				if(ownerResult>=0)
					isSucess=true;
				else
					return false;
			}

 

			return isSucess;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progrssDialog.dismiss();


			if(result)
			{
				SharedPreferences preferences=getSharedPreferences("TAB_DATA",MODE_PRIVATE);
				int existingRow=  preferences.getInt("ROW_ID", 1);

				SharedPreferences.Editor edit=preferences.edit();
				edit.putInt("ROW_ID", (existingRow+1));
				edit.commit();

				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);
				finish();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "Save faild, Please try again!", Toast.LENGTH_LONG).show();
			}

		}
	}

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
