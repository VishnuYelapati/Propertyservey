package com.versatilemobitech.servey;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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

	MyServey activity = null;

	GPSTracker gpsTracker;

	//private TextView batinfo=null;
	DatabaseHandler db_Handler;


	private static final int ACTION_TAKE_PHOTO_A = 1;
	private static final int ACTION_TAKE_PHOTO_B = 2;
	//private static final int ACTION_TAKE_PHOTO_S = 2;
	//private static final int ACTION_TAKE_VIDEO = 3;

	//private ImageView mImageView;
	//	private Bitmap mImageBitmap;
	DatabaseHandler dbHandler;


	private String mCurrentPhotoPath;
	//private final String USER_PREF_FILE_NAME="user_time";

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

	private void setPic(ImageView img) {

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
				mCurrentPhotoPath = f.getAbsolutePath();
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
				System.out.println("");
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



	private void handleBigCameraPhoto(ImageView img) {

		if (mCurrentPhotoPath != null) {
			setPic(img);
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
				// TODO Auto-generated method stub
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");
				toDay_DATE= sdf.format(new Date());

				ProperyBean pbean=ProperyBean.getInstance();



				ContentValues cv_Values=new ContentValues();
				//cv_Values.put(dbHandler.AddressforCommunication,pbean.getAddressforCommunication());
				//cv_Values.put(dbHandler.AdvertisementHoarding,pbean.get);
				
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
				//cv_Values.put(dbHandler.OwnerUIDNumber,pbean.getOwnerUIDNumber());
				//cv_Values.put(dbHandler.OwnerUIDNumber,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Others,pbean.getOthers());
				cv_Values.put(dbHandler.OutOfRicoIndustries,pbean.getOutOfRicoIndustries());
				//	cv_Values.put(dbHandler.owner_name,pbean.getO);
				//		cv_Values.put(dbHandler.profession,pbean.getpr);
				cv_Values.put(dbHandler.Parking,pbean.getParking());
				cv_Values.put(dbHandler.PermanentAddress,pbean.getPermanentAddress());
				//cv_Values.put(dbHandler.PermanentAddress_Address,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.PipedWaterConnection,pbean.getPipedWaterConnection());
				//cv_Values.put(dbHandler.PleaseWriteSizefBoardSqft,pbean.getAddressforCommunication());
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
			/*	cv_Values.put(dbHandler.Total_Area_sft,pbean.getAddressforCommunication());
				cv_Values.put(dbHandler.Total_Area_Yard,pbean.gett);*/
				//cv_Values.put(dbHandler.TotalConstructionArea,pbean.getAddressforCommunication()); //
				cv_Values.put(dbHandler.TotalPlotArea,pbean.getTotalPlotArea());
				cv_Values.put(dbHandler.TotalPlotYard,pbean.getTotalPlotYard());
				cv_Values.put(dbHandler.TypOfConstruction,pbean.getTypOfConstruction());
				cv_Values.put(dbHandler.VacantArea,pbean.getVacantArea());
				cv_Values.put(dbHandler.VacantYard,pbean.getVacantYard());
				cv_Values.put(dbHandler.FormID,"RJ/JPR/ZONE1/WARD1/Tablet1/Seq1");
				long insterResult=dbHandler.insert(dbHandler.TABLE_servey_Data, cv_Values);

				System.out.println("Test insert ::::"+insterResult);
			
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);
				finish();
//09-29 06:16:50.280: E/SQLiteLog(3712): (1) table SERVEY_DATA has no column named Building_Id_like_1_b_2_b_3_b_so_on


			}  
		});



		gpsTracker = new GPSTracker(MyServey.this);
		// check if GPS enabled		
		if(gpsTracker.canGetLocation()){
			latitude = gpsTracker.getLatitude();
			longitude = gpsTracker.getLongitude();
		}else{
			gpsTracker.showSettingsAlert();
			Toast.makeText(MyServey.this, "Please turn on GPS", Toast.LENGTH_LONG).show();
		} 
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
				 
				
				handleBigCameraPhoto((ImageView) findViewById(R.id.catute_image));
			}
			break;
			
		} // ACTION_TAKE_PHOTO_B

		case ACTION_TAKE_PHOTO_A:
			handleBigCameraPhoto((ImageView) findViewById(R.id.catute_image2));
			break;
		}// switch
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
