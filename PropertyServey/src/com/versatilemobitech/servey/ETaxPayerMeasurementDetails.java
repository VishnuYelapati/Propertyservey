package com.versatilemobitech.servey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
		
		
		//Loading previous data  we can enable it later
		/*TotalPlotArea.setText(pbean.getTotalPlotArea().toString());
		TotalPlotYard.setText(pbean.getTotalPlotYard().toString());
		PlinthArea.setText(pbean.getPlinthArea().toString());
		PlinthYard.setText(pbean.getPlinthYard().toString());
		TotalConstructionArea.setText(pbean.getTotalConstructionArea().toString());
		TotalConstructionYard.setText(pbean.getTotalConstructionYard().toString());
		TotalPlotYard.setText(pbean.getTotalPlotYard().toString());
		VacantYard.setText(pbean.getVacantYard().toString());*/
		
	      btn_Next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//if(!TotalPlotArea.getText().toString().equals("")& !PlinthArea.getText().toString().equals("")&!PlinthYard.getText().toString().equals("")&!VacantArea.getText().toString().equals("")&!TotalConstructionArea.getText().toString().equals("")& !TotalPlotArea.getText().toString().equals("")& !TotalPlotYard.getText().toString().equals("")&!VacantYard.getText().toString().equals("")){
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
				/*}else{
					Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_LONG).show();
				}*/
				
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
	
	
	/*TotalPlotArea.addTextChangedListener(watchTotalPlotArea);
	   PlinthArea.addTextChangedListener(watchTotalPlintArea);
	TotalConstructionArea.addTextChangedListener(watchTotalConstructionArea);
	VacantArea.addTextChangedListener(watchTotalVacantArea);*/
	
	
	
	//Second
	/*
	TotalPlotYard.addTextChangedListener(TotalPlotYardList);
	PlinthYard.addTextChangedListener(PlinthYardList);
	TotalConstructionYard.addTextChangedListener(TotalConstructionYardList);
	VacantYard.addTextChangedListener(VacantYardList);*/
	
	
	
	TotalPlotYard.setOnFocusChangeListener(onFoucutList);
	PlinthYard.setOnFocusChangeListener(onFoucutList);
	TotalConstructionYard.setOnFocusChangeListener(onFoucutList);
	VacantYard.setOnFocusChangeListener(onFoucutList);
	
	TotalPlotArea.setOnFocusChangeListener(onFoucutList);
	PlinthArea.setOnFocusChangeListener(onFoucutList);
	TotalConstructionArea.setOnFocusChangeListener(onFoucutList);
	VacantArea.setOnFocusChangeListener(onFoucutList);
	}
	
	
	
	
	///////////////////////////////////////////////////////////////
	
	OnFocusChangeListener onFoucutList=new OnFocusChangeListener()
	{

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			
			
			try{
		 
			switch (v.getId()) {
			
		
			 
			
			
			case R.id.et_plotareainsqft:
				 
				
				//TotalPlotYard TotalPlotArea.addTextChangedListener(watchTotalPlotArea);
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(TotalPlotArea.getText().toString().length()>0)
					{
						TotalPlotYard.setText(""+Float.parseFloat(TotalPlotArea.getText().toString())/9);
					}
					else{
						TotalPlotYard.setText("");
					}
					
				}
				break;

			case R.id.et_plotareainyardsss:
				
				System.out.println("TEST et_plotareainyardsss"+hasFocus);
				if(hasFocus)
				{
					
				}
				else{
					
					if(TotalPlotYard.getText().toString().length()>0)
					{
						TotalPlotArea.setText(""+Float.parseFloat(TotalPlotYard.getText().toString())*9);
					}
					else{
						TotalPlotArea.setText("");
					}
				}
				break;
				
				

			case R.id.et_plintareainsqft:
				
				//PlinthYard  PlinthArea
				
				
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(PlinthArea.getText().toString().length()>0)
					{
						PlinthYard.setText(""+Float.parseFloat(PlinthArea.getText().toString())/9);
					}
					else{
						PlinthYard.setText("");
					}
					
				}
				
				break;

			case R.id.et_plintareainyards:
				

//PlinthYard  PlinthArea
				
				
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(PlinthYard.getText().toString().length()>0)
					{
						PlinthArea.setText(""+Float.parseFloat(PlinthYard.getText().toString())*9);
					}
					else{
						PlinthArea.setText("");
					}
					
				}
				
				
				break;
				
				 

			case R.id.et_constructareainsqft:
				
				//TotalConstructionYard TotalConstructionArea
				 
				

				
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(TotalConstructionArea.getText().toString().length()>0)
					{
						TotalConstructionYard.setText(""+Float.parseFloat(TotalConstructionArea.getText().toString())/9);
					}
					else{
						TotalConstructionYard.setText("");
					}
					
				}
				
				break;

			case R.id.et_constructareainyards:
				


				
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(TotalConstructionYard.getText().toString().length()>0)
					{
						TotalConstructionArea.setText(""+Float.parseFloat(TotalConstructionYard.getText().toString())*9);
					}
					else{
						TotalConstructionArea.setText("");
					}
					
				}
				
				
				break;
				

			case R.id.et_vacantareainsqft:
				
				
				//VacantArea  VacantYard
				
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(VacantArea.getText().toString().length()>0)
					{
						VacantYard.setText(""+Float.parseFloat(VacantArea.getText().toString())/9);
					}
					else{
						VacantYard.setText("");
					}
					
				}
				break;

			case R.id.et_vacantareainyards:
				
 				
				if(hasFocus)
				{
					
				}
				else{
				 	
					if(VacantYard.getText().toString().length()>0)
					{
						VacantArea.setText(""+Float.parseFloat(VacantYard.getText().toString())*9);
					}
					else{
						VacantArea.setText("");
					}
				}
				break;
				
			default:
				break;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "Invalid data", Toast.LENGTH_LONG).show();
			}
		}
		
	};
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	/*
	TextWatcher VacantYardList  = new TextWatcher(){
		 
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
					VacantYard.setText(""+sft*9);
					//TotalPlotArea.setText(""+sft*9);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else{
	    		VacantYard.setText("");
	    		//TotalPlotArea.setText("");
	    	}
	       
	    }};
	
	
	TextWatcher TotalConstructionYardList = new TextWatcher(){
		 
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
					TotalConstructionArea.setText(""+sft*9);
					//TotalPlotArea.setText(""+sft*9);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}else{
	    		TotalConstructionArea.setText("");
	    		//TotalPlotArea.setText("");
	    	}
	       
	    }};
	
	 TextWatcher PlinthYardList = new TextWatcher(){
		 
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
	
		    
		    
		    TextWatcher TotalPlotYardList = new TextWatcher(){
				 
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
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	}else{
			    		TotalPlotArea.setText("");
			    	}
			       
			    }};
			    
	
		    
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	//Main validation
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
*/
}
