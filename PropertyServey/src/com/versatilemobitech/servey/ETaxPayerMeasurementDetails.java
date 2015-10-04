package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.versatilemobitech.bean.ProperyBean;

public class ETaxPayerMeasurementDetails extends BaserActinbBar{
	
	
	Button btn_Next,btn_prev;
	
	private EditText TotalPlotArea=null;
	private EditText PlinthArea=null;
	private EditText VacantArea=null;
	private EditText TotalConstructionArea=null;

	// Yard
	private EditText TotalPlotYard=null;
	private EditText PlinthYard=null;
	private EditText VacantYard=null;
	private EditText TotalConstructionYard=null;
	ProperyBean pbean;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.measurementplotdetails);
		pbean=ProperyBean.getInstance();
		btn_Next=(Button)findViewById(R.id.btn_next);
		btn_prev=(Button)findViewById(R.id.btn_prev);
		
		TotalPlotArea=(EditText)findViewById(R.id.et_plotareainsqft);
		TotalPlotYard=(EditText)findViewById(R.id.et_plotareainyardsss);
		
		PlinthArea=(EditText)findViewById(R.id.et_plintareainsqft);
		PlinthYard=(EditText)findViewById(R.id.et_plintareainyards);
		
		
		TotalConstructionArea=(EditText)findViewById(R.id.et_constructareainsqft);
		TotalConstructionYard=(EditText)findViewById(R.id.et_constructareainyards);
		
		VacantArea=(EditText)findViewById(R.id.et_vacantareainsqft);
		VacantYard=(EditText)findViewById(R.id.et_vacantareainyards);
		
		TotalPlotArea.setText(pbean.getTotalPlotArea().toString());
		PlinthArea.setText(pbean.getPlinthArea().toString());
		TotalConstructionArea.setText(pbean.getTotalConstructionArea().toString());
		TotalConstructionYard.setText(pbean.getTotalConstructionYard().toString());
		TotalPlotYard.setText(pbean.getTotalPlotYard().toString());
		VacantYard.setText(pbean.getVacantYard().toString());
		
	      btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(!TotalPlotArea.getText().toString().equals("")& !PlinthArea.getText().toString().equals("")&!PlinthYard.getText().toString().equals("")&!VacantArea.getText().toString().equals("")&!TotalConstructionArea.getText().toString().equals("")& !TotalPlotArea.getText().toString().equals("")& !TotalPlotYard.getText().toString().equals("")&!VacantYard.getText().toString().equals("")){
					pbean.setTotalPlotArea(TotalPlotArea.getText().toString());
					pbean.setPlinthArea(PlinthArea.getText().toString());
					pbean.setPlinthYard(PlinthYard.getText().toString());
					pbean.setVacantArea(VacantArea.getText().toString());
					pbean.setTotalConstructionArea(TotalConstructionArea.getText().toString());
					pbean.setTotalConstructionYard(TotalConstructionYard.getText().toString());
					pbean.setTotalPlotYard(TotalPlotYard.getText().toString());
					pbean.setVacantYard(VacantYard.getText().toString());
					Intent i=new Intent(getApplicationContext(),FLandBuildingDetailsActivity.class);
					startActivity(i);
				}else{
					Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_LONG).show();
				}
				
			}
		});
	
	btn_prev.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			pbean.setTotalPlotArea(TotalPlotArea.getText().toString());
			pbean.setPlinthArea(PlinthArea.getText().toString());
			pbean.setPlinthYard(PlinthYard.getText().toString());
			pbean.setVacantArea(VacantArea.getText().toString());
			pbean.setTotalConstructionArea(TotalConstructionArea.getText().toString());
			pbean.setTotalConstructionYard(TotalConstructionYard.getText().toString());
			pbean.setTotalPlotYard(TotalPlotYard.getText().toString());
			pbean.setVacantYard(VacantYard.getText().toString());
		
			onBackPressed();
		}
	});
	
	
	TotalPlotArea.addTextChangedListener(watchTotalPlotArea);
	PlinthArea.addTextChangedListener(watchTotalPlintArea);
	TotalConstructionArea.addTextChangedListener(watchTotalConstructionArea);
	VacantArea.addTextChangedListener(watchTotalVacantArea);
	
	
	
	}
	
	
	 TextWatcher watchTotalPlotArea = new TextWatcher(){
		 
		    @Override
		    public void afterTextChanged(Editable arg0) {
		        // TODO Auto-generated method stub
		 
		    }
		 
		    @Override
		    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
		            int arg3) {
		        // TODO Auto-generated method stub
		 
		    }
		 
		    @Override
		    public void onTextChanged(CharSequence s, int a, int b, int c) {
		        // TODO Auto-generated method stub
		    	
		    	
		    	if(s.length()>0){
			    	try {
			    		
						float sft=0;
						sft=Float.parseFloat(s.toString());
	 					TotalPlotYard.setText(""+sft/9);
						//TotalPlotArea.setText(""+sft*9);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}else{
		    		TotalPlotYard.setText("");
		    		//TotalPlotArea.setText("");
		    	}
		       
		    }};
		    
		    
		    
		    
		    TextWatcher watchTotalPlotYard = new TextWatcher(){
				 
			    @Override
			    public void afterTextChanged(Editable arg0) {
			        // TODO Auto-generated method stub
			 
			    }
			 
			    @Override
			    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			            int arg3) {
			        // TODO Auto-generated method stub
			 
			    }
			 
			    @Override
			    public void onTextChanged(CharSequence s, int a, int b, int c) {
			        // TODO Auto-generated method stub
			    	
			    	
			    	if(s.length()>0){
				    	try {
				    		
							float sft=0;
							sft=Float.parseFloat(s.toString());
		 					TotalPlotArea.setText(""+sft*9);
							//TotalPlotArea.setText(""+sft*9);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}else{
			    		TotalPlotArea.setText("");
			    		//TotalPlotArea.setText("");
			    	}
			       
			    }};
			    
		    
		    
		    
		    
		    TextWatcher watchTotalPlintArea = new TextWatcher(){
				 
			    @Override
			    public void afterTextChanged(Editable arg0) {
			        // TODO Auto-generated method stub
			 
			    }
			 
			    @Override
			    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
			            int arg3) {
			        // TODO Auto-generated method stub
			 
			    }
			 
			    @Override
			    public void onTextChanged(CharSequence s, int a, int b, int c) {
			        // TODO Auto-generated method stub
			    	if(s.length()>0){
			    	try {
						float sft=0;
						sft=Float.parseFloat(s.toString());
 
						PlinthYard.setText(""+sft/9);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	}else{
			    		PlinthYard.setText("");
			    	}
			       
			    }};
			    
			    TextWatcher watchTotalConstructionArea = new TextWatcher(){
					 
				    @Override
				    public void afterTextChanged(Editable arg0) {
				        // TODO Auto-generated method stub
				 
				    }
				 
				    @Override
				    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				            int arg3) {
				        // TODO Auto-generated method stub
				 
				    }
				 
				    @Override
				    public void onTextChanged(CharSequence s, int a, int b, int c) {
				        // TODO Auto-generated method stub
				    	if(s.length()>0){
				    	try {
				    		
				    	
							float sft=0;
							sft=Float.parseFloat(s.toString());
 
							TotalConstructionYard.setText(""+sft/9);
							
				    		
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    	}else{
				    		TotalConstructionYard.setText("");
				    	}
				       
				    }};
				    
				    TextWatcher watchTotalVacantArea = new TextWatcher(){
						 
					    @Override
					    public void afterTextChanged(Editable arg0) {
					        // TODO Auto-generated method stub
					 
					    }
					 
					    @Override
					    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					            int arg3) {
					        // TODO Auto-generated method stub
					 
					    }
					 
					    @Override
					    public void onTextChanged(CharSequence s, int a, int b, int c) {
					        // TODO Auto-generated method stub
					    	if(s.length()>0){
						    	
					    	try {
								float sft=0;
								sft=Float.parseFloat(s.toString());
 
								VacantYard.setText(""+sft/9);
							} catch (NumberFormatException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					    }else{
				    		TotalConstructionYard.setText("");
				    	}
				       
					    	
					    }};

}
