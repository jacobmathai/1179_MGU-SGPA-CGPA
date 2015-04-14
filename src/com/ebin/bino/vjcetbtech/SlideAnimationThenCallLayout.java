
package com.ebin.bino.vjcetbtech;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import mg.sgpa.cgpa.Sgpa_act_s4;
import mg.sgpa.cgpa.Sgpa_act_s5;
import mg.sgpa.cgpa.Slsect_main_gridview_bg;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter.LengthFilter;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ebin.bino.vjcetbtech.Adapter_saerch_result;
import mg.sgpa.cgpa.R;


public class SlideAnimationThenCallLayout extends Activity implements AnimationListener {
	  String SPINNER_branch,SPINNER_sem,SPINNER_sgpa;      
	  View menu;
    View app;
    boolean menuOut = false;
    AnimParams animParams = new AnimParams();
    ListView front_menu_list;
    ArrayAdapter<Item> are ;
    List<Item> menu_items = new ArrayList<Item>(); 
    TextView textView_tv_action_bar;
Spinner 	spinnerBranch,spinnerSemester,spinnerSgpa;
    
    RelativeLayout Relativelayout_child_settings,Relativelayout_child_sgpa,Relativelayout_child_about;
    
    
    /////////////// calendar variable starts here///////////////////////////////
    
	 GregorianCalendar month, itemmonth;// calendar instances.
     CalendarAdapter adapter1;// adapter instance
	 Handler handler;// for grabbing some event values for showing the dot	// marker.
	ArrayList<String> items; // container to store calendar items which	// needs showing the event marker
	ArrayList<String> event;
	LinearLayout rLayout;
	ArrayList<String> date;
	ArrayList<String> desc;
   
    /////////////// calendar variable ends here///////////////////////////////
	
	
	////////////// set v
	
    SharedPreferences setting ;           //retrieve saved value;
	 String  bg_colour_main, text_colour;
	 ImageView image_main_background, text_colour_imv;
	 
	 //set var
   
 FrameLayout framelayout_inflator;
 View view_frame_inflate_child_settings,view_frame_inflate_child_sgpa,view_frame_inflate_child_about;
 
 
    class ClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            System.out.println("onClick " + new Date());
            SlideAnimationThenCallLayout me = SlideAnimationThenCallLayout.this;
            Context context = me;
            Animation anim;

            int w = app.getMeasuredWidth();
            int h = app.getMeasuredHeight();
            int left = (int) (app.getMeasuredWidth() * 0.6);

            if (!menuOut) {
                // anim = AnimationUtils.loadAnimation(context, R.anim.push_right_out_80);
                anim = new TranslateAnimation(0, left, 0, 0);
                menu.setVisibility(View.VISIBLE);
                animParams.init(left, 0, left + w, h);
            } else {
                // anim = AnimationUtils.loadAnimation(context, R.anim.push_left_in_80);
                anim = new TranslateAnimation(0, -left, 0, 0);
                animParams.init(0, 0, w, h);
            }

            anim.setDuration(500);
            anim.setAnimationListener(me);
            //Tell the animation to stay as it ended (we are going to set the app.layout first than remove this property)
            anim.setFillAfter(true);


            // Only use fillEnabled and fillAfter if we don't call layout ourselves.
            // We need to do the layout ourselves and not use fillEnabled and fillAfter because when the anim is finished
            // although the View appears to have moved, it is actually just a drawing effect and the View hasn't moved.
            // Therefore clicking on the screen where the button appears does not work, but clicking where the View *was* does
            // work.
            // anim.setFillEnabled(true);
            // anim.setFillAfter(true);

            app.startAnimation(anim);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
     
    	
    	
    	super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.slide_animation_then_call_layout);
        
        textView_tv_action_bar = (TextView) findViewById(R.id.textView_tv_action_bar);
        
       //create differ view for the frameLayout 
       
        view_frame_inflate_child_settings = getLayoutInflater().inflate(R.layout.activity_activity_fileexp_settings, null);
        view_frame_inflate_child_sgpa = getLayoutInflater().inflate(R.layout.inflate_layout_cgpa_sgpa, null);
        view_frame_inflate_child_about = getLayoutInflater().inflate(R.layout.activity_about_activity, null);
        
        //change themes
        
        Relativelayout_child_settings = (RelativeLayout) view_frame_inflate_child_settings.findViewById(R.id.relateive_settings);
        Relativelayout_child_about = (RelativeLayout) view_frame_inflate_child_about.findViewById(R.id.relative_layout_about);
        Relativelayout_child_sgpa = (RelativeLayout) view_frame_inflate_child_sgpa.findViewById(R.id.Relativelayout_child_sgpa);
        
        setting = getSharedPreferences("settings", 0);     
     		 final SharedPreferences.Editor editor = setting.edit(); 

        framelayout_inflator = (FrameLayout)findViewById(R.id.frame_Layout_Inflate_me);      

	   	 
	   	 
        
     
        
        ///////////////settings  starts here///////////////////////////////
     

	image_main_background = (ImageView) view_frame_inflate_child_settings.findViewById(R.id.set_bag_colour_imageButton1);
	text_colour_imv = (ImageView) view_frame_inflate_child_settings.findViewById(R.id.ImageView_text_colour);
	LinearLayout set_main_bacground = (LinearLayout) view_frame_inflate_child_settings.findViewById(R.id.set_linearlayout_background_main_clour);
	LinearLayout set_text_colour   = (LinearLayout) view_frame_inflate_child_settings.findViewById(R.id.set_linearlayout_text_colour);		
	
	
	
	
	//SharedPreferences setting = getSharedPreferences("grid_s", 0);



	 bg_colour_main = setting.getString("bg_colour_main", "g_def");        
	 text_colour = setting.getString("set_text_colour", "g_def");
	 
//    
//    
//    
//	RelativeLayout r_gradient = (RelativeLayout) findViewById(R.id.relateve_settings);
// Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
//int nn = obb.get_main_linear_layout_bg(bg_colour_main);
//r_gradient.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work



String uri11 = "drawable/" + bg_colour_main;
int imageResource11 = getApplicationContext().getResources().getIdentifier(uri11, null,getApplicationContext().getPackageName());
Drawable image11 = getApplicationContext().getResources().getDrawable(imageResource11);
image_main_background.setImageDrawable(image11);	 

 
	 

String uri12 = "drawable/" + text_colour;
int imageResource12 = getApplicationContext().getResources().getIdentifier(uri12, null,getApplicationContext().getPackageName());
Drawable image12 = getApplicationContext().getResources().getDrawable(imageResource12);
text_colour_imv.setImageDrawable(image12);	
	 





set_text_colour.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	AlertDialog.Builder ad_m = new AlertDialog.Builder(SlideAnimationThenCallLayout.this,AlertDialog.THEME_HOLO_DARK);
   //ad.setTitle("ttt");
 // ad_m.setTitle("Select Option");
	final CharSequence[] items = {"Default","Black","White"};
 
	
	ad_m.setItems(items, new DialogInterface.OnClickListener() {
       public void onClick(DialogInterface dialog, int which) {
                  // TODO Auto-generated method stub
      
		   switch(which){
	       	case 0 :    
               	editor.putString("set_text_colour", "g_def");   /// Saved for next restart
                editor.commit();
           	String uri = "drawable/" +"g_def";
       	int imageResource = getApplicationContext().getResources().getIdentifier(uri, null,getApplicationContext().getPackageName());
       	Drawable image = getApplicationContext().getResources().getDrawable(imageResource);
       	text_colour_imv.setImageDrawable(image);
                break;
       	case 1 :    
    	                   	editor.putString("set_text_colour", "gg_blke");   /// Saved for next restart
    		                editor.commit();
    		           	String uri22 = "drawable/" +"gg_blke";
    		       	int imageResource22 = getApplicationContext().getResources().getIdentifier(uri22, null,getApplicationContext().getPackageName());
    		       	Drawable image22 = getApplicationContext().getResources().getDrawable(imageResource22);
    		       	text_colour_imv.setImageDrawable(image22);
    		                break;
       	case 2:
       		
           	editor.putString("set_text_colour", "gg_white");   /// Saved for next restart
            editor.commit();
         	String uri1 = "drawable/" +"gg_white";
   	     int imageResource1 = getApplicationContext().getResources().getIdentifier(uri1, null,getApplicationContext().getPackageName());
        	Drawable image1 = getApplicationContext().getResources().getDrawable(imageResource1);
        	text_colour_imv.setImageDrawable(image1);
       		
       		
       		            break;
                  
                  
                            }
                                                                           }
     });ad_m.show();

                                                         	}
                                                                });





set_main_bacground.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	AlertDialog.Builder ad_m = new AlertDialog.Builder(SlideAnimationThenCallLayout.this,AlertDialog.THEME_HOLO_DARK);
   //ad.setTitle("ttt");
 // ad_m.setTitle("Select Option");
	final CharSequence[] items = {"Default","Gradient Black", "Gradient Blue","Gradient Brown","Gradient Orange","Gradient Red ","Gradient Blue Light"};
 
	
	ad_m.setItems(items, new DialogInterface.OnClickListener() {
       public void onClick(DialogInterface dialog, int which) {
                  // TODO Auto-generated method stub
      
		   switch(which){
	       	case 0 :    
               	editor.putString("bg_colour_main", "g_def");   /// Saved for next restart
                editor.commit();
           	String uri = "drawable/" +"g_def";
       	int imageResource = getApplicationContext().getResources().getIdentifier(uri, null,getApplicationContext().getPackageName());
       	Drawable image = getApplicationContext().getResources().getDrawable(imageResource);
       	image_main_background.setImageDrawable(image);
                break;
       	case 1 :    
    	                   	editor.putString("bg_colour_main", "g_black");   /// Saved for next restart
    		                editor.commit();
    		           	String uri44 = "drawable/" +"g_black";
    		       	int imageResource44 = getApplicationContext().getResources().getIdentifier(uri44, null,getApplicationContext().getPackageName());
    		       	Drawable image44 = getApplicationContext().getResources().getDrawable(imageResource44);
    		       	image_main_background.setImageDrawable(image44);
    		                break;
       	case 2:  
       	                    	editor.putString("bg_colour_main", "g_blue");   /// Saved for next restart
                                editor.commit();
       	                       String uri1 = "drawable/" +"g_blue";
                               	int imageResource1 = getApplicationContext().getResources().getIdentifier(uri1, null,getApplicationContext().getPackageName());
   	                         Drawable image1 = getApplicationContext().getResources().getDrawable(imageResource1);
   	                            image_main_background.setImageDrawable(image1);
                                 break;
       	case 3:  
       	      	editor.putString("bg_colour_main", "g_gold_lite");
                  editor.commit();
 		           	String uri2 = "drawable/" +"g_gold_lite";
    		       	int imageResource2 = getApplicationContext().getResources().getIdentifier(uri2, null,getApplicationContext().getPackageName());
    		       	Drawable image2 = getApplicationContext().getResources().getDrawable(imageResource2);
    		       	image_main_background.setImageDrawable(image2);
                  break;
                  
       	case 4:  
       		        editor.putString("bg_colour_main", "g_orange");
                  editor.commit();
 		           	String uri3 = "drawable/" +"g_orange";
    		       	int imageResource3 = getApplicationContext().getResources().getIdentifier(uri3, null,getApplicationContext().getPackageName());
    		       	Drawable image3 = getApplicationContext().getResources().getDrawable(imageResource3);
    		       	image_main_background.setImageDrawable(image3);
                  break;
                  

       	case 5:  
       		     editor.putString("bg_colour_main", "g_red");
                  editor.commit();
 		           	String uri5 = "drawable/" +"g_red";
    		       	int imageResource5 = getApplicationContext().getResources().getIdentifier(uri5, null,getApplicationContext().getPackageName());
    		       	Drawable image5 = getApplicationContext().getResources().getDrawable(imageResource5);
    		       	image_main_background.setImageDrawable(image5);
                  break;
       	case 6:  
       		editor.putString("bg_colour_main", "g_sky_blue");
                  editor.commit();
 		           	String uri6 = "drawable/" +"g_sky_blue";
    		       	int imageResource6 = getApplicationContext().getResources().getIdentifier(uri6, null,getApplicationContext().getPackageName());
    		       	Drawable image6 = getApplicationContext().getResources().getDrawable(imageResource6);
    		       	image_main_background.setImageDrawable(image6);
                  break;


                  
                  
                            }
                                                                           }
     });ad_m.show();

                                                         	}
                                                                });

       
	    /////////////// 2 settings ends here///////////////////////////////
		
		
		
		
		
        
        ////////    CGPA-SGPA 

 spinnerBranch = (Spinner ) view_frame_inflate_child_sgpa.findViewById(R.id.Spinner_inflate_sgpa_branch);
 spinnerSemester = (Spinner ) view_frame_inflate_child_sgpa.findViewById(R.id.Spinner_inflate_sgpa_semester);
spinnerSgpa = (Spinner ) view_frame_inflate_child_sgpa.findViewById(R.id.Spinner_inflate_sgpa_sgpa);
final String bg_colour_main123 = setting.getString("set_text_colour", "gg_blke");        
	 

       String[] spinnerState_branch1 =  {"CS","CIVIL","IT","EC","EEE","MECH"};
       //Default spinner
        //ArrayAdapter<String> spinnerArrayAdapter_branch = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,spinnerState_branch);
  
       final ArrayAdapter<String> spinnerArrayAdapter_branch1;
  	 if(bg_colour_main123.equalsIgnoreCase("gg_white")){  spinnerArrayAdapter_branch1 = new ArrayAdapter<String>(this, R.layout.spinner_single_item_w,spinnerState_branch1);}
  	 else{spinnerArrayAdapter_branch1 = new ArrayAdapter<String>(this, R.layout.spinner_single_item,spinnerState_branch1);}
        
      spinnerBranch.setAdapter(spinnerArrayAdapter_branch1);

      String[] spinnerState_semester1 =  {"S1&2","S3","S4","S5","S6","S7","S8"};
     //Default spinner
     ArrayAdapter<String> spinnerArrayAdapter_semester1;
   	 if(bg_colour_main123.equalsIgnoreCase("gg_white")){  spinnerArrayAdapter_semester1 = new ArrayAdapter<String>(this, R.layout.spinner_single_item_w,spinnerState_branch1);}
   	 else{spinnerArrayAdapter_semester1 = new ArrayAdapter<String>(this, R.layout.spinner_single_item,spinnerState_semester1);}
    spinnerSemester.setAdapter(spinnerArrayAdapter_semester1);
       
    
    String[] spinnerState_sgpa1 =  {"SGPA","CGPA"};
    //Default spinner
     //ArrayAdapter<String> spinnerArrayAdapter_branch = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,spinnerState_branch);
     ArrayAdapter<String> spinnerArrayAdapter_sgpa1;
     if(bg_colour_main123.equalsIgnoreCase("gg_white")){  spinnerArrayAdapter_sgpa1 = new ArrayAdapter<String>(this, R.layout.spinner_single_item_w,spinnerState_sgpa1);}
   	 else{spinnerArrayAdapter_sgpa1 = new ArrayAdapter<String>(this, R.layout.spinner_single_item,spinnerState_sgpa1);}
    spinnerSemester.setAdapter(spinnerArrayAdapter_semester1);
   spinnerSgpa.setAdapter(spinnerArrayAdapter_sgpa1);
   
   spinnerBranch.setOnItemSelectedListener(new OnItemSelectedListener() {
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {  
		

		// TODO Auto-generated method stub
		switch(arg2){case 0:SPINNER_branch="CS"; break;   case 1:SPINNER_branch="CIVIL"; break;  case 2:SPINNER_branch="IT"; break;  case 3:SPINNER_branch="EC"; break;  case 4:SPINNER_branch="EEE"; break;  case 5:SPINNER_branch="MECH"; break;  }
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});
   
spinnerSemester.setOnItemSelectedListener(new OnItemSelectedListener() {
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){case 0:SPINNER_sem="S1&2"; break;   case 1:SPINNER_sem="S3"; break;  case 2:SPINNER_sem="S4"; break;  case 3:SPINNER_sem="S5"; break; 
                                 case 4:SPINNER_sem="S6"; break; case 5:SPINNER_sem="S7"; break;  case 6:SPINNER_sem="S8"; break;  }
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});

spinnerSgpa.setOnItemSelectedListener(new OnItemSelectedListener() {
	   
	   @Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		switch(arg2){case 0:SPINNER_sgpa="SGPA"; break;     case 1:SPINNER_sgpa="CGPA"; break;}
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
});


Button submit_sgpa = (Button) view_frame_inflate_child_sgpa.findViewById(R.id.button1_sgpa_submit);
submit_sgpa.setOnClickListener(new OnClickListener() {
public void onClick(View v) {
		// TODO Auto-generated method stub
		String sgpa_pass=SPINNER_branch+"@"+SPINNER_sem+"@"+SPINNER_sgpa;
		//Toast.makeText(getApplication(), sgpa_pass, Toast.LENGTH_LONG).show();
		
		if(SPINNER_sgpa.equalsIgnoreCase("CGPA")){
			Bundle bu = new Bundle();
			bu.putString("sgpa_sx", sgpa_pass);
			  Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_to_cgpa");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
			
		}else{
		Bundle bu = new Bundle();
		bu.putString("sgpa_sx", sgpa_pass);
 
		 if(SPINNER_sem.equalsIgnoreCase("S3")){
			   Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s3");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}else if(SPINNER_sem.equalsIgnoreCase("S4")){
			  Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s4");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}else if(SPINNER_sem.equalsIgnoreCase("S5")){
			  Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s5");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}else if(SPINNER_sem.equalsIgnoreCase("S6")){
			  Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s6");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}else if(SPINNER_sem.equalsIgnoreCase("S7")){
			  Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s7");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}else if(SPINNER_sem.equalsIgnoreCase("S8")){
			  Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s8");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}else if(SPINNER_sem.equalsIgnoreCase("S1&2")){
		       Intent spa_act = new Intent("com.ebin.bino.sgpa.cgpa.Sgpa_act_s12");
		       spa_act.putExtras(bu);
		       startActivity(spa_act);	
		}
		
		}
		   
	}
});

















        menu = findViewById(R.id.menu);
        app = findViewById(R.id.app);

        ViewUtils.printView("menu", menu);
        ViewUtils.printView("app", app);
        front_menu_list  = (ListView) findViewById(R.id.listview_front_menu);
        
        
       // ListView listView = (ListView) app.findViewById(R.id.listview_front_menu);                   //list view in right side items // actual code downloaded
        //  ViewUtils.initListView(this, listView, "Item ", 30, android.R.layout.simple_list_item_1);

        app.findViewById(R.id.BtnSlide).setOnClickListener(new ClickListener());
        
        
        
        
      //  menu_items.add(new Item("Calendar","f_menu_cal")); 
       menu_items.add(new Item("SGPA-CGPA","f_menu_calcu")); 
    //    menu_items.add(new Item("Staff Profile","f_menu_register")); 
     //   menu_items.add(new Item("Trivia","f_menu_trivia")); 
    //    menu_items.add(new Item("MG Link","f_menu_mg")); 
       menu_items.add(new Item("Settings","f_settin")); 
        menu_items.add(new Item("About Us","f_menu_abo")); 
        menu_items.add(new Item("5 Star","f_menu_star")); 
        menu_items.add(new Item("Exit","f_menu_exit1")); 
        
       are = new Adapter_saerch_result(SlideAnimationThenCallLayout.this,R.layout.frount_menu_single_item_def, menu_items); 
          front_menu_list.setAdapter(are); 
          
          
          
          front_menu_list.setOnItemClickListener(new OnItemClickListener() {
        	 @SuppressWarnings("deprecation")
			public void onItemClick(android.widget.AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        		 switch (arg2) {
        		 
        		 case 1:       	
        			 
        			 int apiLevel = Build.VERSION.SDK_INT;
        				

        				if(apiLevel<11){
        					AlertDialog alertbox = new AlertDialog.Builder(SlideAnimationThenCallLayout.this).create();
        					alertbox.setTitle("Alert !");
        					alertbox.setMessage("* Apply new settings on RESTART."+"\n"+"*  API 11 or higher Required.");
        					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
        						            public void onClick(DialogInterface dialog, int which) {
        							            // TODO Auto-generated method stub
        						                                                       }
        					                                   });
        					alertbox.show();
        				}else{
        					  AlertDialog.Builder addd = new AlertDialog.Builder(SlideAnimationThenCallLayout.this);
        					  addd.setTitle("Alert!");
        					  addd.setMessage("* Apply new settings on RESTART."+"\n"+"*  API 11 or higher Required.");
        	            		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
        	            		      public void onClick(DialogInterface dialog, int arg1) {
        	            		    			// TODO Auto-generated method stub
        	            				System.out.println();
        	            		    		}
        	            		    	} );
        	            		    	addd.show();
        				}
        			             
                                 framelayout_inflator = (FrameLayout)findViewById(R.id.frame_Layout_Inflate_me);     
                                 framelayout_inflator.removeAllViews();
                                  framelayout_inflator.addView(view_frame_inflate_child_settings);
                                  menu.setVisibility(View.INVISIBLE);
                                   menuOut = false;
                                   textView_tv_action_bar.setText("SETTINGS");
                                   
                           	   	 String bg_colour_main12 = setting.getString("bg_colour_main", "g_def");          
                        	   	 if(!(bg_colour_main12.equalsIgnoreCase("g_def"))){
                        	  Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
                        	   int nn = obb.get_main_linear_layout_bg(bg_colour_main12);
                        	   Relativelayout_child_settings.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work
                        	   	 }else{
                        	   		Relativelayout_child_settings.setBackgroundDrawable(getResources().getDrawable(R.drawable.background)); 
                        	   	 }
                        	   	String bg_colour_main120 = setting.getString("set_text_colour", "gg_blke");          
                        		 
                        		 if(bg_colour_main120.equalsIgnoreCase("gg_white")){
                     TextView textView2_inflate_sgpa_bg = (TextView) view_frame_inflate_child_settings.findViewById(R.id.textView2_inflate_sgpa_bg);
                     TextView textView2_inflate_sgpa_tv = (TextView) view_frame_inflate_child_settings.findViewById(R.id.textView2_inflate_sgpa_tv);
                     textView2_inflate_sgpa_bg.setTextColor(getResources().getColor(android.R.color.white));
                     textView2_inflate_sgpa_tv.setTextColor(getResources().getColor(android.R.color.white));

                        		 }else{

                                     TextView textView2_inflate_sgpa_bg = (TextView) view_frame_inflate_child_settings.findViewById(R.id.textView2_inflate_sgpa_bg);
                                     TextView textView2_inflate_sgpa_tv = (TextView) view_frame_inflate_child_settings.findViewById(R.id.textView2_inflate_sgpa_tv);
                                     textView2_inflate_sgpa_bg.setTextColor(getResources().getColor(android.R.color.black));
                                     textView2_inflate_sgpa_tv.setTextColor(getResources().getColor(android.R.color.black));
                                     
                        		 }
                        		 
                        	   	 
                     break;    		 
        		 
        		 
        		 case 0:       	
        			 
      
        	

                                        framelayout_inflator = (FrameLayout)findViewById(R.id.frame_Layout_Inflate_me);      
                                        framelayout_inflator.removeAllViews();
                                       framelayout_inflator.addView(view_frame_inflate_child_sgpa);
                                       menu.setVisibility(View.INVISIBLE);
                                       menuOut = false;
                                       textView_tv_action_bar.setText("BTECH MARKS");
                                      

TextView tvBranch = (TextView ) view_frame_inflate_child_sgpa.findViewById(R.id.TextView_inflate_sgpa_branch);
TextView tvSemester = (TextView ) view_frame_inflate_child_sgpa.findViewById(R.id.TextView_inflate_sgpa_semestet);

String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
	 
	 if(bg_colour_main121.equalsIgnoreCase("gg_white")){
tvBranch.setTextColor(getResources().getColor(android.R.color.white));
tvSemester.setTextColor(getResources().getColor(android.R.color.white));

String bg_colour_main123 = setting.getString("set_text_colour", "gg_blke");        

int apiLevel1 = Build.VERSION.SDK_INT;


if(apiLevel1>=16){
spinnerBranch.setPopupBackgroundResource(android.R.color.black);
spinnerSemester.setPopupBackgroundResource(android.R.color.background_dark);
spinnerSgpa.setPopupBackgroundResource(android.R.color.background_dark);

}
//Drawable dd = getResources().getDrawable(R.drawable.gradient_black);
//spinnerBranch.setPopupBackgroundDrawable(dd);


TextView tv = (TextView) spinnerBranch.getSelectedView();
tv.setTextColor(getResources().getColor(android.R.color.white));

TextView tv_semester = (TextView) spinnerSemester.getSelectedView();
tv_semester.setTextColor(getResources().getColor(android.R.color.white));

TextView tv_sgpa = (TextView) spinnerSgpa.getSelectedView();
tv_sgpa.setTextColor(getResources().getColor(android.R.color.white));


	 }else{
		 tvBranch.setTextColor(getResources().getColor(android.R.color.black));
		 tvSemester.setTextColor(getResources().getColor(android.R.color.black));
		 
		 TextView tv_branch = (TextView) spinnerBranch.getSelectedView();
		 tv_branch.setTextColor(getResources().getColor(android.R.color.black));
		 
		 TextView tv_semester = (TextView) spinnerSemester.getSelectedView();
		 tv_semester.setTextColor(getResources().getColor(android.R.color.black));
		 
		 TextView tv_sgpa = (TextView) spinnerSgpa.getSelectedView();
		 tv_sgpa.setTextColor(getResources().getColor(android.R.color.black));
	 }
	 
                                	   	 String bg_colour_main = setting.getString("bg_colour_main", "g_def");          
                                	   	 if(!(bg_colour_main.equalsIgnoreCase("g_def"))){
                                	  Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
                                	   int nn = obb.get_main_linear_layout_bg(bg_colour_main);
                                	   Relativelayout_child_sgpa.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work
                                	   	 }else{
                                	   	  Relativelayout_child_sgpa.setBackgroundDrawable(getResources().getDrawable(R.drawable.background)); 
                                	   	 }
                                       break;
                                       
         		 case 2:       	
                     framelayout_inflator = (FrameLayout)findViewById(R.id.frame_Layout_Inflate_me);      
                     framelayout_inflator.removeAllViews();
                    framelayout_inflator.addView(view_frame_inflate_child_about);
                    menu.setVisibility(View.INVISIBLE);
                    menuOut = false;
                    textView_tv_action_bar.setText("About Us");
                    
                    
                  TextView  TextView03_about_1,TextView03_about_2,TextView03_about_3,TextView03_about_4,TextView03_about_5,TextView03_about_6,TextView03_about_7,TextView03_about_8,TextView03_about_9,TextView03_about_10,TextView03_about_11,TextView03_about_12,TextView03_about_13,TextView03_about_14,TextView03_about_15,TextView03_about_16,TextView03_about_17,TextView03_about_18,TextView03_about_19,TextView03_about_20;
                  TextView03_about_1 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_1); TextView03_about_2 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_2); TextView03_about_3 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_3); TextView03_about_4 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_4); TextView03_about_5 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_5); TextView03_about_6 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_6);
               //   TextView03_about_7 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_7); TextView03_about_8 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_8); TextView03_about_9 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_9); TextView03_about_10 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_10); TextView03_about_11 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_11); TextView03_about_12 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_12);
                  TextView03_about_13 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_13); TextView03_about_14 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_14); TextView03_about_15 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_15); TextView03_about_16 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_16); TextView03_about_17= (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_17); TextView03_about_18 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_18);
                  TextView03_about_19 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_19); TextView03_about_20 = (TextView) view_frame_inflate_child_about.findViewById(R.id.TextView03_about_20);
                    
                    String bg_colour_main124 = setting.getString("set_text_colour", "gg_blke");          
               	 
               	 if(bg_colour_main124.equalsIgnoreCase("gg_white")){
               		 
               	  TextView03_about_1.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_2.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_3.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_4.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_5.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_6.setTextColor(getResources().getColor(android.R.color.white));
               // /  TextView03_about_7.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_8.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_9.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_10.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_11.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_12.setTextColor(getResources().getColor(android.R.color.white));
                  TextView03_about_13.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_14.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_15.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_16.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_17.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_18 .setTextColor(getResources().getColor(android.R.color.white));
                  TextView03_about_19.setTextColor(getResources().getColor(android.R.color.white)); TextView03_about_20.setTextColor(getResources().getColor(android.R.color.white));
                    
               	 }else  if(bg_colour_main124.equalsIgnoreCase("gg_blke")){
                 	  TextView03_about_1.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_2.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_3.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_4.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_5.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_6.setTextColor(getResources().getColor(android.R.color.black));
                   //   TextView03_about_7.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_8.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_9.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_10.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_11.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_12.setTextColor(getResources().getColor(android.R.color.black));
                      TextView03_about_13.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_14.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_15.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_16.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_17.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_18 .setTextColor(getResources().getColor(android.R.color.black));
                      TextView03_about_19.setTextColor(getResources().getColor(android.R.color.black)); TextView03_about_20.setTextColor(getResources().getColor(android.R.color.black));
                        
               	 }
                    
                    
                    
                    
                    
                    
             	   	 String bg_colour_main1 = setting.getString("bg_colour_main", "g_def");          
            	   	 if(!(bg_colour_main1.equalsIgnoreCase("g_def"))){
            	  Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
            	   int nn = obb.get_main_linear_layout_bg(bg_colour_main1);
            	   Relativelayout_child_about.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work
            	   	 }else{
            	   	  Relativelayout_child_about.setBackgroundDrawable(getResources().getDrawable(R.drawable.background)); 
            	   	 }
         
                    break;
                    
                    
         		case 3: 

         			 
       			 int apiLevelq = Build.VERSION.SDK_INT;
       				

       				if(apiLevelq<11){
       					AlertDialog alertbox = new AlertDialog.Builder(SlideAnimationThenCallLayout.this).create();
       					alertbox.setTitle("Alert !");
       					alertbox.setMessage("Give 5 star for this application on Google Play Store.");
       					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
       						            public void onClick(DialogInterface dialog, int which) {
       							            // TODO Auto-generated method stub
       						            	
       						            	
       						            	final String pk = "mg.sgpa.cgpa";
       						            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+pk)));
       						            	
       						            	
       						                                                       }
       					                                   });
       					
       					
       					alertbox.show();
       				}else{
       					  AlertDialog.Builder addd = new AlertDialog.Builder(SlideAnimationThenCallLayout.this);
       					  addd.setTitle("Alert!");
         					addd.setMessage("Give 5 star for this application on Google Play Store.");
       	            		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
       	            		      public void onClick(DialogInterface dialog, int arg1) {
       	            		    			// TODO Auto-generated method stub
       	            		      	final String pk = "mg.sgpa.cgpa";
						            	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+pk)));
						            	
						            	
       	            		    		}
       	            		    	} );
       	            		    	
       	            		    	addd.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
       	            		      public void onClick(DialogInterface dialog, int arg1) {
       	            		    			// TODO Auto-generated method stub
       	            				System.out.println();
       	            		    		}
       	            		    	} );
       	            		    	
       	            		    	
       	            		    	addd.show();
       				}
				break;
				
				
                    
				case 4:     SlideAnimationThenCallLayout.this.finish();
					
					break;

				default:
					break;
				}
        		 
        		  };
          
		});
          
          
          
          // framelayout_inflator.removeAllViews();
          framelayout_inflator.addView(view_frame_inflate_child_sgpa);  //1st disp CGPA inflator
         // menu.setVisibility(View.INVISIBLE);
          menuOut = false;
     // getActionBar().setTitle("");
          textView_tv_action_bar.setText("BTECH MARKS");
          
       
   		 
   		 String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
   		 spinnerBranch = (Spinner ) view_frame_inflate_child_sgpa.findViewById(R.id.Spinner_inflate_sgpa_branch);
   		 spinnerSemester = (Spinner ) view_frame_inflate_child_sgpa.findViewById(R.id.Spinner_inflate_sgpa_semester);
    spinnerSgpa = (Spinner ) view_frame_inflate_child_sgpa.findViewById(R.id.Spinner_inflate_sgpa_sgpa);
   		 
    TextView tvBranch = (TextView ) view_frame_inflate_child_sgpa.findViewById(R.id.TextView_inflate_sgpa_branch);
    TextView tvSemester = (TextView ) view_frame_inflate_child_sgpa.findViewById(R.id.TextView_inflate_sgpa_semestet);
 



   		 if(bg_colour_main121.equalsIgnoreCase("gg_white")){
   		   tvBranch.setTextColor(getResources().getColor(android.R.color.white));
   	    tvSemester.setTextColor(getResources().getColor(android.R.color.white));

   	int apiLevel11 = Build.VERSION.SDK_INT;


   	if(apiLevel11>=16){
   	spinnerBranch.setPopupBackgroundResource(android.R.color.black);
   	spinnerSemester.setPopupBackgroundResource(android.R.color.background_dark);
   	spinnerSgpa.setPopupBackgroundResource(android.R.color.background_dark);
	    String[] spinnerState_branch =  {"CS","CIVIL","IT","EC","EEE","MECH"};
    ArrayAdapter<String> spinnerArrayAdapter_branch = new ArrayAdapter<String>(this, R.layout.spinner_single_item_w,spinnerState_branch);
   spinnerBranch.setAdapter(spinnerArrayAdapter_branch);

  String[] spinnerState_semester =  {"S1&2","S3","S4","S5","S6","S7","S8"};
 ArrayAdapter<String> spinnerArrayAdapter_semester = new ArrayAdapter<String>(this, R.layout.spinner_single_item_w,spinnerState_semester);
spinnerSemester.setAdapter(spinnerArrayAdapter_semester);
   

  String[] spinnerState_sgpa =  {"SGPA","CGPA"};
  ArrayAdapter<String> spinnerArrayAdapter_sgpa = new ArrayAdapter<String>(this, R.layout.spinner_single_item_w,spinnerState_sgpa);
spinnerSgpa.setAdapter(spinnerArrayAdapter_sgpa);

   	}else{
		    String[] spinnerState_branch =  {"CS","CIVIL","IT","EC","EEE","MECH"};
	     ArrayAdapter<String> spinnerArrayAdapter_branch = new ArrayAdapter<String>(this, R.layout.spinner_single_item_r,spinnerState_branch);
	    spinnerBranch.setAdapter(spinnerArrayAdapter_branch);

	   String[] spinnerState_semester =  {"S1&2","S3","S4","S5","S6","S7","S8"};
	  ArrayAdapter<String> spinnerArrayAdapter_semester = new ArrayAdapter<String>(this, R.layout.spinner_single_item_r,spinnerState_semester);
	spinnerSemester.setAdapter(spinnerArrayAdapter_semester);
	    

	   String[] spinnerState_sgpa =  {"SGPA","CGPA"};
	   ArrayAdapter<String> spinnerArrayAdapter_sgpa = new ArrayAdapter<String>(this, R.layout.spinner_single_item_r,spinnerState_sgpa);
	 spinnerSgpa.setAdapter(spinnerArrayAdapter_sgpa);

   	}
   		 }else if(bg_colour_main121.equalsIgnoreCase("gg_blke")){
   		   tvBranch.setTextColor(getResources().getColor(android.R.color.black));
   	    tvSemester.setTextColor(getResources().getColor(android.R.color.black));
   		    String[] spinnerState_branch =  {"CS","CIVIL","IT","EC","EEE","MECH"};
   	     ArrayAdapter<String> spinnerArrayAdapter_branch = new ArrayAdapter<String>(this, R.layout.spinner_single_item,spinnerState_branch);
   	    spinnerBranch.setAdapter(spinnerArrayAdapter_branch);

   	   String[] spinnerState_semester =  {"S1&2","S3","S4","S5","S6","S7","S8"};
   	  ArrayAdapter<String> spinnerArrayAdapter_semester = new ArrayAdapter<String>(this, R.layout.spinner_single_item,spinnerState_semester);
   	spinnerSemester.setAdapter(spinnerArrayAdapter_semester);
   	    

   	   String[] spinnerState_sgpa =  {"SGPA","CGPA"};
   	   ArrayAdapter<String> spinnerArrayAdapter_sgpa = new ArrayAdapter<String>(this, R.layout.spinner_single_item,spinnerState_sgpa);
   	 spinnerSgpa.setAdapter(spinnerArrayAdapter_sgpa);
   		 }
   		 
   	   	 String bg_colour_main = setting.getString("bg_colour_main", "g_def");          
   	   	 if(!bg_colour_main.equalsIgnoreCase("g_def")){
   	  Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
   	   int nn = obb.get_main_linear_layout_bg(bg_colour_main);
   	   Relativelayout_child_sgpa.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work
   	   	 }
   	   	 
    }
    
    
    
    
    
    
    
    ///////////////3  calendar starts here///////////////////////////////
    

//	protected void setNextMonth() {
//		if (month.get(GregorianCalendar.MONTH) == month
//				.getActualMaximum(GregorianCalendar.MONTH)) {
//			month.set((month.get(GregorianCalendar.YEAR) + 1),
//					month.getActualMinimum(GregorianCalendar.MONTH), 1);
//		} else {
//			month.set(GregorianCalendar.MONTH,
//					month.get(GregorianCalendar.MONTH) + 1);
//		}
//
//	}
//
//	protected void setPreviousMonth() {
//		if (month.get(GregorianCalendar.MONTH) == month
//				.getActualMinimum(GregorianCalendar.MONTH)) {
//			month.set((month.get(GregorianCalendar.YEAR) - 1),
//					month.getActualMaximum(GregorianCalendar.MONTH), 1);
//		} else {
//			month.set(GregorianCalendar.MONTH,
//					month.get(GregorianCalendar.MONTH) - 1);
//		}
//
//	}
//
//	protected void showToast(String string) {
//		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
//
//	}
//
//	public void refreshCalendar() {
//		TextView title = (TextView) findViewById(R.id.title);
//
//		adapter1.refreshDays();
//		adapter1.notifyDataSetChanged();
//		handler.post(calendarUpdater); // generate some calendar items
//
//		title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
//	}
//
//	public Runnable calendarUpdater = new Runnable() {
//
//		@Override
//		public void run() {
//			items.clear();
//
//			// Print dates of the current week
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
//			String itemvalue;
//			event = Utility.readCalendarEvent(SlideAnimationThenCallLayout.this);
//			Log.d("=====Event====", event.toString());
//			Log.d("=====Date ARRAY====", Utility.startDates.toString());
//
//			for (int i = 0; i < Utility.startDates.size(); i++) {
//				itemvalue = df.format(itemmonth.getTime());
//				itemmonth.add(GregorianCalendar.DATE, 1);
//				items.add(Utility.startDates.get(i).toString());
//			}
//			adapter1.setItems(items);
//			adapter1.notifyDataSetChanged();
//		}
//	};
//    
//    
    
    /////////////// 3 calendar ends here///////////////////////////////
    
    
    
    
    
    
    
    
    void layoutApp(boolean menuOut) {
        System.out.println("layout [" + animParams.left + "," + animParams.top + "," + animParams.right + ","
                + animParams.bottom + "]");
        app.layout(animParams.left, animParams.top, animParams.right, animParams.bottom);
        //Now that we've set the app.layout property we can clear the animation, flicker avoided :)
        app.clearAnimation();

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        System.out.println("onAnimationEnd");
        ViewUtils.printView("menu", menu);
        ViewUtils.printView("app", app);
        menuOut = !menuOut;
        if (!menuOut) {
            menu.setVisibility(View.INVISIBLE);
        }
        layoutApp(menuOut);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        System.out.println("onAnimationRepeat");
    }

    @Override
    public void onAnimationStart(Animation animation) {
        System.out.println("onAnimationStart");
    }

    static class AnimParams {
        int left, right, top, bottom;

        void init(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }
}
