package com.versatilemobitech.servey;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.versatilemobitech.adapter.DatabaseHandler;

public class MainActivity extends BaserActinbBar{

	Button btn_startservey,btn_reset_master,btn_export;


	EditText et_UserName=null;
	EditText et_Password=null;
	TextView txt_noserveys;
	GPSTracker gpsTracker;
	DatabaseHandler db;
	String outFilePath;
	final String prf_name="user_pref";
	private Context _mainContext;
	String toDay_DATE="";
	private boolean isCanExportReport=false;
	
	String csvFile="";
	//String xlsFIle="";
	
	
	public static final int SIGNATURE_ACTIVITY = 1;
	 int existingRow=0;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		buildValidate();
		
		SharedPreferences preferences=getSharedPreferences("TAB_DATA",MODE_PRIVATE);
	      existingRow=  preferences.getInt("ROW_ID", 0);

		_mainContext=this;
		btn_startservey=(Button) findViewById(R.id.btn_startservey);
		btn_reset_master=(Button)findViewById(R.id.btn_reset_master);
		btn_export=(Button)findViewById(R.id.btn_export);
		txt_noserveys=(TextView)findViewById(R.id.txt_noserveys);
		
		txt_noserveys.setText("No of Survey's :"+existingRow);
		db=new DatabaseHandler(getApplicationContext());
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setTitle("Home");


		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		toDay_DATE= sdf.format(new Date());

		TextView dateView=(TextView)findViewById(R.id.date_info);
		dateView.setText("Date:"+toDay_DATE);

		 

		btn_startservey.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),ADataProviderActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		
 
		btn_export.setOnClickListener(new View.OnClickListener() {
			//SQLiteDatabase sqldb = db.getReadableDatabase();
			//Cursor cursor = null;

			@Override
			public void onClick(View v) {  //main code begins here
			
				
				if(existingRow!=0){
					 mainForm();
					  OwnerdetailsForm();
					  buildingdetailsForm();
				}else{
					Toast.makeText(getApplicationContext(), "Servey Records not found",Toast.LENGTH_LONG).show();
				}
				 
				
			}
			
 
			
		});
		
		btn_reset_master.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				//Need to reset master data.
				
				
			}
		});

	}

	private void buildValidate() {
		 
		
try{
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    		Date todayDate=new Date();
        	//Date date1 = sdf.parse("2009-12-31");
        	Date date2 = sdf.parse("2015-10-09");

        	//System.out.println(sdf.format(date1));
        	System.out.println(sdf.format(date2));
        	
        	
        	//System.out.println("TEST :" +todayDate.compareTo(date1));
        	
        	if(todayDate.compareTo(date2)>0)
        	{
        		System.out.println("TEST Expire:" +todayDate.compareTo(date2));
        		Toast.makeText(getApplicationContext(), "Expired", Toast.LENGTH_LONG).show();
        		finish();
        	}
        	else{
        		System.out.println("TEST Valid:" +todayDate.compareTo(date2));
        	}
        	
        	 
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
		
	}

	public void OwnerdetailsForm(){
		SQLiteDatabase sqldb = db.getReadableDatabase();
		Cursor cursor = null;
		try {
			 //My Database class
			csvFile="/OwnerDetails.csv";
			 
			cursor = sqldb.rawQuery("select * from SERVEY_Owner_Details",null);//WHERE CREATED_DATE >='"+toDay_DATE+"_00:00:00'", null);
			int rowcount = 0;
			int colcount = 0;
			File sdCardDir = Environment.getExternalStorageDirectory();
			String filename = csvFile;
			// the name of the file to export with
			File saveFile = new File(sdCardDir, filename);
			FileWriter fw = new FileWriter(saveFile);

			BufferedWriter bw = new BufferedWriter(fw);
			rowcount = cursor.getCount();
			colcount = cursor.getColumnCount();
			if (rowcount > 0) {
				cursor.moveToFirst();

				for (int i = 0; i < colcount; i++) {
					if (i != colcount - 1) {

						bw.write(""+cursor.getColumnName(i) + ",");
						
					} else {

						bw.write(""+cursor.getColumnName(i));
						

					}
				}
				bw.newLine();

				for (int i = 0; i < rowcount; i++) {
					cursor.moveToPosition(i);

					for (int j = 0; j < colcount; j++) {
						if (j != colcount - 1){
							bw.write(""+cursor.getString(j) + ",");
						
						}else{
							bw.write(""+cursor.getString(j));
							
						}
					}
					bw.newLine();
				}
				bw.flush();
				//   infotext.setText("Exported Successfully.");

				new CSVToExcelConverter1().execute();
			}
			if(!cursor.isClosed())
				cursor.close();
		} catch (Exception ex) {
			
			System.out.println("exception:"+ex.getMessage());
			if (sqldb.isOpen()) {
				sqldb.close();
				if(cursor!=null )
				{
					if(!cursor.isClosed())
						cursor.close();
				}
				//     infotext.setText(ex.getMessage().toString());
			}

		} finally {

		}
		
	}

	public void buildingdetailsForm(){
		SQLiteDatabase sqldb = db.getReadableDatabase();
		Cursor cursor = null;
		try {
			
			File exportDir = new File(Environment.getExternalStorageDirectory(), "/serveyforms");        
			if (!exportDir.exists()) 
			{
				exportDir.mkdirs();
			}  
			 //My Database class
			csvFile="/BuildingDetails.csv";
		 
			cursor = sqldb.rawQuery("select * from SERVEY_Building_Details",null);//WHERE CREATED_DATE >='"+toDay_DATE+"_00:00:00'", null);
			int rowcount = 0;
			int colcount = 0;
			File sdCardDir = Environment.getExternalStorageDirectory();
			String filename = csvFile;
			// the name of the file to export with
			File saveFile = new File(sdCardDir, filename);
			FileWriter fw = new FileWriter(saveFile);

			BufferedWriter bw = new BufferedWriter(fw);
			rowcount = cursor.getCount();
			colcount = cursor.getColumnCount();
			if (rowcount > 0) {
				cursor.moveToFirst();

				for (int i = 0; i < colcount; i++) {
					if (i != colcount - 1) {

						bw.write(""+cursor.getColumnName(i) + ",");
						System.out.println("names22:"+cursor.getString(i));
					} else {

						bw.write(""+cursor.getColumnName(i));
						System.out.println("names22:"+cursor.getString(i));

					}
				}
				bw.newLine();

				for (int i = 0; i < rowcount; i++) {
					cursor.moveToPosition(i);

					for (int j = 0; j < colcount; j++) {
						if (j != colcount - 1){
							bw.write(""+cursor.getString(j) + ",");
						System.out.println("names:"+cursor.getString(j));
						}else{
							bw.write(""+cursor.getString(j));
							System.out.println("names1:"+cursor.getString(j));
						}
					}
					bw.newLine();
				}
				bw.flush();
				//   infotext.setText("Exported Successfully.");

				new CSVToExcelConverter2().execute();
			}
			if(!cursor.isClosed())
				cursor.close();
		} catch (Exception ex) {
			
			System.out.println("exception:"+ex.getMessage());
			if (sqldb.isOpen()) {
				sqldb.close();
				if(cursor!=null )
				{
					if(!cursor.isClosed())
						cursor.close();
				}
				//     infotext.setText(ex.getMessage().toString());
			}

		} finally {

		}
		
		
	}
	
	
	

	
	public void mainForm(){
		SQLiteDatabase sqldb = db.getReadableDatabase();
		Cursor cursor = null;
		try {
			 //My Database class
			csvFile="/MainSurveyForm.csv";
		 
			cursor = sqldb.rawQuery("select * from SERVEY_DATA",null);//WHERE CREATED_DATE >='"+toDay_DATE+"_00:00:00'", null);
			int rowcount = 0;
			int colcount = 0;
			File sdCardDir = Environment.getExternalStorageDirectory();
			String filename = csvFile;//"MainSurveyForm.csv";
			// the name of the file to export with
			File saveFile = new File(sdCardDir, filename);
			
			if(!saveFile.exists())
			saveFile.createNewFile();
			
			FileWriter fw = new FileWriter(saveFile);

			BufferedWriter bw = new BufferedWriter(fw);
			rowcount = cursor.getCount();
			colcount = cursor.getColumnCount();
			if (rowcount > 0) {
				cursor.moveToFirst();

				for (int i = 0; i < colcount; i++) {
					if (i != colcount - 1) {

						bw.write(""+cursor.getColumnName(i) + ",");
						System.out.println("names22:"+cursor.getString(i));
					} else {

						bw.write(""+cursor.getColumnName(i));
						System.out.println("names22:"+cursor.getString(i));

					}
				}
				bw.newLine();

				for (int i = 0; i < rowcount; i++) {
					cursor.moveToPosition(i);

					for (int j = 0; j < colcount; j++) {
						if (j != colcount - 1){
							bw.write(""+cursor.getString(j) + ",");
						System.out.println("names:"+cursor.getString(j));
						}else{
							bw.write(""+cursor.getString(j));
							System.out.println("names1:"+cursor.getString(j));
						}
					}
					bw.newLine();
				}
				bw.flush();
				//   infotext.setText("Exported Successfully.");

				new CSVToExcelConverterMainData().execute();
			}
			if(!cursor.isClosed())
				cursor.close();
		} catch (Exception ex) {
			
			System.out.println("exception:"+ex.getMessage());
			if (sqldb.isOpen()) {
				sqldb.close();
				if(cursor!=null )
				{
					if(!cursor.isClosed())
						cursor.close();
				}
				 
			}

		} finally {

		}
		
		
	}


	public class CSVToExcelConverterMainData extends AsyncTask<String, Void, Boolean> {


		private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);

		@Override
		protected void onPreExecute()
		{
			dialog.setCanceledOnTouchOutside(false);
			this.dialog.setMessage("Exporting to excel...");
		this.dialog.show();}

		@Override
		protected Boolean doInBackground(String... params) {
			ArrayList arList=null;
			ArrayList al=null;
 


			File exportDir = new File(Environment.getExternalStorageDirectory(), "/serveyforms");        
			if (!exportDir.exists()) 
			{
				exportDir.mkdirs();
			}  

			//System.out.println("TEST main dir"+exportDir.getAbsolutePath());
			
			 
			String inFilePath = Environment.getExternalStorageDirectory().toString()+"/MainSurveyForm.csv";
			outFilePath =     Environment.getExternalStorageDirectory().toString()+"/serveyforms/MainSurveyForm"+toDay_DATE+".xls";
			String thisLine;
			int count=0;

			try {

			 
				FileInputStream fis = new FileInputStream(inFilePath);
				DataInputStream myInput = new DataInputStream(fis);
				int i=0;
				arList = new ArrayList();
				while ((thisLine = myInput.readLine()) != null)
				{
					al = new ArrayList();
					String strar[] = thisLine.split(",");
					for(int j=0;j<strar.length;j++)
					{
						al.add(strar[j]);
					}
					arList.add(al);

					i++;
				}} catch (Exception e) {
					e.printStackTrace();
				}

			try
			{
				HSSFWorkbook hwb = new HSSFWorkbook();
				HSSFSheet sheet = hwb.createSheet(getString(R.string.app_name)+toDay_DATE);
				for(int k=0;k<arList.size();k++)
				{
					ArrayList ardata = (ArrayList)arList.get(k);
					HSSFRow row = sheet.createRow((short) 0+k);
					for(int p=0;p<ardata.size();p++)
					{
						HSSFCell cell = row.createCell((short) p);
						String data = ardata.get(p).toString();
						if(data.startsWith("=")){
							cell.setCellType(cell.CELL_TYPE_STRING);
							data=data.replaceAll("\"", "");
							data=data.replaceAll("=", "");
							cell.setCellValue(data);
						}else if(data.startsWith("\"")){
							data=data.replaceAll("\"", "");
							cell.setCellType(cell.CELL_TYPE_STRING);
							cell.setCellValue(data);
						}else{
							data=data.replaceAll("\"", "");
							cell.setCellType(cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(data);
						}

					}

				}
				FileOutputStream fileOut = new FileOutputStream(outFilePath);
				hwb.write(fileOut);
				fileOut.close();
				System.out.println("Your excel file has been generated");
			} catch ( Exception ex ) {
				ex.printStackTrace();
			} //main method ends
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success)

		{

			if (this.dialog.isShowing())

			{
				
				
				//OwnerdetailsForm();

				this.dialog.dismiss();

			}

			if (success)

			{

				Toast.makeText(MainActivity.this, "File exported successfully :"+outFilePath, Toast.LENGTH_LONG).show();
				
				// showCutomDialog();

			}

			else

			{

				Toast.makeText(MainActivity.this, "File export failed", Toast.LENGTH_SHORT).show();

			}

		}



	}
	
	public class CSVToExcelConverter2 extends AsyncTask<String, Void, Boolean> {


		private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);

		@Override
		protected void onPreExecute()
		{
			dialog.setCanceledOnTouchOutside(false);
			this.dialog.setMessage("Exporting to excel-2...");
		this.dialog.show();}

		@Override
		protected Boolean doInBackground(String... params) {
			ArrayList arList=null;
			ArrayList al=null;

			//File dbFile= new File(getDatabasePath("database_name").toString());
			//File dbFile=getDatabasePath(DatabaseHandler.DATABASE_NAME);
			//String yes= dbFile.getAbsolutePath();



			File exportDir = new File(Environment.getExternalStorageDirectory(), "/serveyforms");        
			if (!exportDir.exists()) 
			{
				exportDir.mkdirs();
			}  

			//  tv_date.setText(ft.format(dNow)+"-"+Integer.toString(level)+"%");
			String inFilePath = Environment.getExternalStorageDirectory().toString()+"/BuildingDetails.csv";
			outFilePath = Environment.getExternalStorageDirectory().toString()+"/serveyforms/BuildingDetails"+"_"+toDay_DATE+".xls";
			String thisLine;
			int count=0;

			try {

				FileInputStream fis = new FileInputStream(inFilePath);
				DataInputStream myInput = new DataInputStream(fis);
				int i=0;
				arList = new ArrayList();
				while ((thisLine = myInput.readLine()) != null)
				{
					al = new ArrayList();
					String strar[] = thisLine.split(",");
					for(int j=0;j<strar.length;j++)
					{
						al.add(strar[j]);
					}
					arList.add(al);

					i++;
				}} catch (Exception e) {
					e.printStackTrace();
				}

			try
			{
				HSSFWorkbook hwb = new HSSFWorkbook();
				HSSFSheet sheet = hwb.createSheet("OD Survey "+toDay_DATE);
				for(int k=0;k<arList.size();k++)
				{
					ArrayList ardata = (ArrayList)arList.get(k);
					HSSFRow row = sheet.createRow((short) 0+k);
					for(int p=0;p<ardata.size();p++)
					{
						HSSFCell cell = row.createCell((short) p);
						String data = ardata.get(p).toString();
						if(data.startsWith("=")){
							cell.setCellType(cell.CELL_TYPE_STRING);
							data=data.replaceAll("\"", "");
							data=data.replaceAll("=", "");
							cell.setCellValue(data);
						}else if(data.startsWith("\"")){
							data=data.replaceAll("\"", "");
							cell.setCellType(cell.CELL_TYPE_STRING);
							cell.setCellValue(data);
						}else{
							data=data.replaceAll("\"", "");
							cell.setCellType(cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(data);
						}

					}

				}
				FileOutputStream fileOut = new FileOutputStream(outFilePath);
				hwb.write(fileOut);
				fileOut.close();
				System.out.println("Your excel file has been generated");
			} catch ( Exception ex ) {
				ex.printStackTrace();
			} //main method ends
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success)

		{

			if (this.dialog.isShowing())

			{

				this.dialog.dismiss();

			}

			if (success)

			{

				Toast.makeText(MainActivity.this, "File exported successfully :"+outFilePath, Toast.LENGTH_LONG).show();
				
				 showCutomDialog();

			}

			else

			{

				Toast.makeText(MainActivity.this, "File export failed", Toast.LENGTH_SHORT).show();

			}

		}



	}
	
	public class CSVToExcelConverter1 extends AsyncTask<String, Void, Boolean> {


		private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);

		@Override
		protected void onPreExecute()
		{
			dialog.setCanceledOnTouchOutside(false);
			this.dialog.setMessage("Exporting to excel-1...");
		this.dialog.show();
		}

		@Override
		protected Boolean doInBackground(String... params) {
			ArrayList arList=null;
			ArrayList al=null;

			//File dbFile= new File(getDatabasePath("database_name").toString());
			//File dbFile=getDatabasePath(DatabaseHandler.DATABASE_NAME);
			//String yes= dbFile.getAbsolutePath();



			File exportDir = new File(Environment.getExternalStorageDirectory(), "/serveyforms");        
			if (!exportDir.exists()) 
			{
				exportDir.mkdirs();
			}  

			//  tv_date.setText(ft.format(dNow)+"-"+Integer.toString(level)+"%");
			String inFilePath = Environment.getExternalStorageDirectory().toString()+"/OwnerDetails.csv";
			outFilePath = Environment.getExternalStorageDirectory().toString()+"/serveyforms/OwnerDetails"+"_"+toDay_DATE+".xls";
			String thisLine;
			int count=0;

			try {

				FileInputStream fis = new FileInputStream(inFilePath);
				DataInputStream myInput = new DataInputStream(fis);
				int i=0;
				arList = new ArrayList();
				while ((thisLine = myInput.readLine()) != null)
				{
					al = new ArrayList();
					String strar[] = thisLine.split(",");
					for(int j=0;j<strar.length;j++)
					{
						al.add(strar[j]);
					}
					arList.add(al);

					i++;
				}} catch (Exception e) {
					e.printStackTrace();
				}

			try
			{
				HSSFWorkbook hwb = new HSSFWorkbook();
				HSSFSheet sheet = hwb.createSheet(getString(R.string.app_name)+toDay_DATE);
				for(int k=0;k<arList.size();k++)
				{
					ArrayList ardata = (ArrayList)arList.get(k);
					HSSFRow row = sheet.createRow((short) 0+k);
					for(int p=0;p<ardata.size();p++)
					{
						HSSFCell cell = row.createCell((short) p);
						String data = ardata.get(p).toString();
						if(data.startsWith("=")){
							cell.setCellType(cell.CELL_TYPE_STRING);
							data=data.replaceAll("\"", "");
							data=data.replaceAll("=", "");
							cell.setCellValue(data);
						}else if(data.startsWith("\"")){
							data=data.replaceAll("\"", "");
							cell.setCellType(cell.CELL_TYPE_STRING);
							cell.setCellValue(data);
						}else{
							data=data.replaceAll("\"", "");
							cell.setCellType(cell.CELL_TYPE_NUMERIC);
							cell.setCellValue(data);
						}

					}

				}
				FileOutputStream fileOut = new FileOutputStream(outFilePath);
				hwb.write(fileOut);
				fileOut.close();
				System.out.println("Your excel file has been generated");
			} catch ( Exception ex ) {
				ex.printStackTrace();
			} //main method ends
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success)

		{

			if (this.dialog.isShowing())

			{
			//	buildingdetailsForm();
				this.dialog.dismiss();

			}

			if (success)

			{

				Toast.makeText(MainActivity.this, "File exported successfully :"+outFilePath, Toast.LENGTH_LONG).show();
				
				 //showCutomDialog();

			}

			else

			{

				Toast.makeText(MainActivity.this, "File export failed", Toast.LENGTH_SHORT).show();

			}

		}



	}

	private void showCutomDialog() {
		 
		/*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				MainActivity.this);

		// set title
		alertDialogBuilder.setTitle(getString(R.string.app_name));
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);

		// set dialog message
		alertDialogBuilder
		.setMessage("Do you want to send report?")
		.setCancelable(false)
		.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {

  
				//sendEmail();
				 
				 
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
		alertDialog.show();*/
		
	}
	
	private void sendEmail() {
		 
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"rajesh.mca008@gmail.com"});
		intent.putExtra(Intent.EXTRA_SUBJECT, "OD Survey as on :"+toDay_DATE);
		intent.putExtra(Intent.EXTRA_TEXT, "OD Survey Report as on :"+toDay_DATE +"<br/> Sent from Android "+android.os.Build.MODEL);
		File root = Environment.getExternalStorageDirectory();
		File file = new File(outFilePath);
		if (!file.exists() || !file.canRead()) {
		    Toast.makeText(this, "Attachment Error", Toast.LENGTH_SHORT).show();
		    finish();
		    return;
		}
		Uri uri = Uri.parse("file://" + file);
		intent.putExtra(Intent.EXTRA_STREAM, uri);
		startActivity(Intent.createChooser(intent, "Send email..."));
		
	}
	
	
	 protected void onActivityResult(int requestCode, int resultCode, Intent data)
	    {
	        switch(requestCode) {
	        case SIGNATURE_ACTIVITY: 
	            if (resultCode == RESULT_OK) {
	 
	                Bundle bundle = data.getExtras();
	                String status  = bundle.getString("status");
	                if(status.equalsIgnoreCase("done")){
	                    Toast toast = Toast.makeText(this, "Signature capture successful!", Toast.LENGTH_SHORT);
	                    toast.setGravity(Gravity.TOP, 105, 50);
	                    toast.show();
	                }
	            }
	            break;
	        }
	 
	    }  

}
