package com.versatilemobitech.servey;

import java.io.InputStream;
import java.util.HashMap;

import org.json.JSONArray;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.versatilemobitech.bean.ProperyBean;
import com.versatilemobitech.bean.User;

public class LoginActivity extends BaserActinbBar {

	Button btn_Login=null;


	EditText et_UserName=null;
	EditText et_Password=null;
	String strUsername="", str_pref_UserName="";
	String strPassword="", str_pref_Password;
	SharedPreferences mypref=null;

	Activity _activity=null;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_activity=this;
		setContentView(R.layout.activity_login);
		et_UserName=(EditText) findViewById(R.id.et_username);
		et_Password=(EditText) findViewById(R.id.et_pwd);
		btn_Login=(Button) findViewById(R.id.btn_login);
		mypref=getSharedPreferences("Credentials", 0);
		str_pref_UserName=mypref.getString("UserName", "");
		str_pref_Password=mypref.getString("Password", "");	
		/*if(str_pref_UserName.equals(""))
			btn_Login.setText("Register");
		else
			btn_Login.setText("Login");
		 */ 

		btn_Login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				strUsername=et_UserName.getText().toString().trim();
				strPassword=et_Password.getText().toString().trim();


				if(strUsername.length()!=0 && strPassword.length()!=0){
					 
						//
						MyBgTask bgTask=new MyBgTask();
						bgTask.execute(strUsername,strPassword);
					 

				}else{
					if(strUsername.length()==0)
					{
						et_UserName.setError("Invalid");
					}
					if(strPassword.length()==0)
					{
						et_Password.setError("Invalid");
					}
					Toast.makeText(LoginActivity.this, "Please enter Username and Password", Toast.LENGTH_LONG).show();

				}
			}

		});


	}
	
	class MyBgTask extends AsyncTask<String, Void, Boolean>
	{
		ProgressDialog dialog;
		
		boolean isUserValid=false;
		boolean isPassValid=false;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog=new ProgressDialog(_activity);
			dialog.setTitle("Please wait...");
			dialog.show();
		}

		@Override
		protected Boolean doInBackground(String... params) {
			 
			try{
			InputStream is = _activity.getAssets().open("users_list.json");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			String bufferString = new String(buffer);
			
			JSONArray jsonArray = new JSONArray(bufferString);
			//parse an Object from a random index in the JSONArray  Sr No 
			ProperyBean.getInstance().setUserName(params[0]);
			 
			 HashMap<String, User> userList=new HashMap<String, User>();
			 User user=null;
			 for (int i = 0; i < jsonArray.length(); i++) {
				 
				 user=new User();
				 user.setPassword(jsonArray.getJSONObject(i).getString("Password "));
				 user.setUserName(jsonArray.getJSONObject(i).getString("User Name "));
				 user.setUserID(jsonArray.getJSONObject(i).getString("Sr No "));
				 userList.put(jsonArray.getJSONObject(i).getString("User Name "), user);
			}
			 
			 if(userList.containsKey(params[0]))
			 {
				 isUserValid=true;
				 if(userList.get(params[0])!=null)
				 {
					 if(((User)userList.get(params[0])).getPassword().equals(params[1]))
					 {
						 System.out.println("TEST :: UID"+((User)userList.get(params[0])).getUserID());
						 ProperyBean.getInstance().setUserID(((User)userList.get(params[0])).getUserID());
						 isPassValid=true;
					 }
						 
				 }
			 }
			 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return isPassValid;
		}
		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(result)
			{

				
				
				finish();
				Intent mapIntent=new Intent(LoginActivity.this, MainActivity.class);

				startActivity(mapIntent);
			}
			else{
				if(!isPassValid)
					et_Password.setError("Invalid");
				
				if(!isUserValid)
					et_UserName.setError("Invalid");
				Toast.makeText(getApplicationContext(), "Invalid credentials.", Toast.LENGTH_LONG).show();
			}
			
			dialog.dismiss();
		}
		
	}

}
