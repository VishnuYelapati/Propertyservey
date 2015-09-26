package com.versatilemobitech.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.versatilemobitech.bean.SpinnerItemBean;
import com.versatilemobitech.servey.R;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class CustomAdapter extends ArrayAdapter<String>{
	
	private Context activity;
    private ArrayList data;
    public Resources res;
    SpinnerItemBean tempValues=null;
    LayoutInflater inflater;
    Context c;
	
    /*************  CustomAdapter Constructor *****************/
	public CustomAdapter(
			Context activitySpinner, 
			              int textViewResourceId,   
			              ArrayList objects,
			              Resources resLocal
			             ) 
	 {
        super(activitySpinner, textViewResourceId, objects);
        
        /********** Take passed values **********/
        activity = activitySpinner;
        data     = objects;
        res      = resLocal;
   
        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  }

    @Override
    public View getDropDownView(int position, View convertView,ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

    	/********** Inflate spinner_rows.xml file for each row ( Defined below ) ************/
        View row = inflater.inflate(R.layout.spinner_rows, parent, false);
        
        /***** Get each Model object from Arraylist ********/
        tempValues = null;
        tempValues = (SpinnerItemBean) data.get(position);
        
        TextView label        = (TextView)row.findViewById(R.id.company);
     //   TextView sub          = (TextView)row.findViewById(R.id.sub);
      //  ImageView companyLogo = (ImageView)row.findViewById(R.id.image);
        
        if(position==0){
        	
        	// Default selected Spinner item 
        	label.setText("Select");
        //	sub.setText("");
        }
        else
        {
            // Set values for spinner each row 
            label.setText(tempValues.getStrItem());
        //    sub.setText(tempValues.getUrl());
         //   companyLogo.setImageResource(res.getIdentifier("com.tgs.servey:drawable/"+tempValues.getImage(),null,null));
            
        }   

        return row;
      }
 }