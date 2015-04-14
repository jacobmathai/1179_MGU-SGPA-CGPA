package com.ebin.bino.vjcetbtech;

import mg.sgpa.cgpa.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		

        setContentView(R.layout.activity_spalsh);
        
        
        
        Thread timer = new Thread(){
    		
    		public void run(){
    			
    			
    			try{
    				sleep(3000);
    				
    			}catch (InterruptedException e){
    				e.printStackTrace();
    			}
    			
    			 finally{
    				Intent openmainactivity = new Intent("com.ebin.bino.vjcetbtech.SlideAnimationThenCallLayout");
    			   startActivity(openmainactivity);	
    			}
    			
    		} 
    			
    	
    		
    	}; timer.start(); //thread starts
    	

    }


@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	this.finish();
}
    
}
