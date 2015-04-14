package mg.sgpa.cgpa;

import java.text.DecimalFormat;
import mg.sgpa.cgpa.R;

import com.ebin.bino.vjcetbtech.SlideAnimationThenCallLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Sgpa_to_cgpa  extends Activity{


String[] ss_array;
String ss;

Button button_sgpa_cgpa_submit;

LinearLayout LinearLayout_sgpa_to_cgpa_s12,LinearLayout_sgpa_to_cgpa_s3, LinearLayout_sgpa_to_cgpa_s4, LinearLayout_sgpa_to_cgpa_s5, LinearLayout_sgpa_to_cgpa_s6, LinearLayout_sgpa_to_cgpa_s7, LinearLayout_sgpa_to_cgpa_s8;


EditText EditText_sgpa_to_cgpa_s12, EditText_sgpa_to_cgpa_s3, EditText_sgpa_to_cgpa_s4, EditText_sgpa_to_cgpa_s5, EditText_sgpa_to_cgpa_s6, EditText_sgpa_to_cgpa_s7, EditText_sgpa_to_cgpa_s8;

LinearLayout LinearLayout_sgpa_cgpa_cgpa, LinearLayout_sgpa_cgpa_per__totmarks;

SharedPreferences save_deatails ;

TextView TextView_sgpa_cgpa_cgpa,TextView_s3_percent_s,TextView_s3_totmark_s;

float tot_cg_s12, tot_cg_s3, tot_cg_s4, tot_cg_s5, tot_cg_s6, tot_cg_s7, tot_cg_s8;
int  tot_mark_s12, tot_mark_s3, tot_mark_s4, tot_mark_s5, tot_mark_s6, tot_mark_s7,tot_mark_s8;


//added

TextView TextView2_sgpa_cgpa_s12,TextView2_sgpa_cgpa_s3,TextView2_sgpa_cgpa_s4,TextView2_sgpa_cgpa_s5,TextView2_sgpa_cgpa_s6,
                   TextView2_sgpa_cgpa_s7,TextView2_sgpa_cgpa_s8;

TextView TextView2_sgpa_cgpa_cg1,TextView2_sgpa_cgpa_cg2,TextView2_sgpa_cgpa_cg3,TextView2_sgpa_cgpa_cg4,
                   TextView2_sgpa_cgpa_cg5, TextView2_sgpa_cgpa_cg6, TextView2_sgpa_cgpa_cg7;

TextView TextView2_sgpa_cgpa_semester,TextView2_sgpa_cgpa_cg,TextView2_sgpa_cgpa_cg_o;

protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.sgpa_to_cgpa);
	
	

	RelativeLayout Relativelayout_bg = (RelativeLayout) findViewById(R.id.Relativelayout_bg_sgpa_cgpa);
    SharedPreferences setting = getSharedPreferences("settings", 0);     
	   	 String bg_colour_main12 = setting.getString("bg_colour_main", "g_def");          
	   	 if(!(bg_colour_main12.equalsIgnoreCase("g_def"))){
	  Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
	   int nn = obb.get_main_linear_layout_bg(bg_colour_main12);
	   Relativelayout_bg.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work
	   	 }else{
	   		Relativelayout_bg.setBackgroundDrawable(getResources().getDrawable(R.drawable.background)); 
	   	 }
	   	 
	   	 
	   	 
	int apiLevel=0;

	
	Bundle string_extras = getIntent().getExtras();
	if(string_extras!=null){
		ss = string_extras.getString("sgpa_sx");
	}
	
 ss_array = ss.split("@");
	
	LinearLayout_sgpa_to_cgpa_s12 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s12);
	LinearLayout_sgpa_to_cgpa_s3 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s3);
	LinearLayout_sgpa_to_cgpa_s4 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s4);
	LinearLayout_sgpa_to_cgpa_s5 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s5);
	LinearLayout_sgpa_to_cgpa_s6 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s6);
	LinearLayout_sgpa_to_cgpa_s7 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s7);
	LinearLayout_sgpa_to_cgpa_s8 = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_to_cgpa_s8);
	
	EditText_sgpa_to_cgpa_s12=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s12);
	EditText_sgpa_to_cgpa_s3=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s3);
	EditText_sgpa_to_cgpa_s4=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s4);
	EditText_sgpa_to_cgpa_s5=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s5);
	EditText_sgpa_to_cgpa_s6=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s6);
	EditText_sgpa_to_cgpa_s7=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s7);
	EditText_sgpa_to_cgpa_s8=(EditText)findViewById(R.id.EditText_sgpa_to_cgpa_s8);
	
	
	
	
	TextView_s3_totmark_s=(TextView)findViewById(R.id.TextView_s3_totmark_s);
	TextView_s3_percent_s=(TextView) findViewById(R.id.TextView_s3_percent_s);
	
 TextView2_sgpa_cgpa_s12=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s12);
 TextView2_sgpa_cgpa_s3=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s3);
 TextView2_sgpa_cgpa_s4=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s4);
 TextView2_sgpa_cgpa_s5=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s5);
 TextView2_sgpa_cgpa_s6=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s6);
 TextView2_sgpa_cgpa_s7=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s7);
 TextView2_sgpa_cgpa_s8=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_s8);

TextView2_sgpa_cgpa_cg1=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg1);
TextView2_sgpa_cgpa_cg2=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg2);
TextView2_sgpa_cgpa_cg3=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg3);
TextView2_sgpa_cgpa_cg4=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg4);
TextView2_sgpa_cgpa_cg5=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg5);
TextView2_sgpa_cgpa_cg6=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg6);
TextView2_sgpa_cgpa_cg7=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg7);

TextView2_sgpa_cgpa_semester=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_semester);
TextView2_sgpa_cgpa_cg=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg);
TextView2_sgpa_cgpa_cg_o=(TextView)findViewById(R.id.TextView2_sgpa_cgpa_cg_o);
	
TextView_sgpa_cgpa_cgpa = (TextView) findViewById(R.id.TextView_sgpa_cgpa_cgpa);


String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
if(bg_colour_main121.equalsIgnoreCase("gg_white")){
	
	TextView_sgpa_cgpa_cgpa.setTextColor(getResources().getColor(R.color.white));
	
	EditText_sgpa_to_cgpa_s12.setTextColor(getResources().getColor(R.color.white));
	EditText_sgpa_to_cgpa_s3.setTextColor(getResources().getColor(R.color.white));
	EditText_sgpa_to_cgpa_s4.setTextColor(getResources().getColor(R.color.white));
	EditText_sgpa_to_cgpa_s5.setTextColor(getResources().getColor(R.color.white));
	EditText_sgpa_to_cgpa_s6.setTextColor(getResources().getColor(R.color.white));
	EditText_sgpa_to_cgpa_s7.setTextColor(getResources().getColor(R.color.white));
	EditText_sgpa_to_cgpa_s8.setTextColor(getResources().getColor(R.color.white));
	
	
	
 TextView2_sgpa_cgpa_s12.setTextColor(getResources().getColor(R.color.white));
 TextView2_sgpa_cgpa_s3.setTextColor(getResources().getColor(R.color.white));
 TextView2_sgpa_cgpa_s4.setTextColor(getResources().getColor(R.color.white));
 TextView2_sgpa_cgpa_s5.setTextColor(getResources().getColor(R.color.white));
 TextView2_sgpa_cgpa_s6.setTextColor(getResources().getColor(R.color.white));
 TextView2_sgpa_cgpa_s7.setTextColor(getResources().getColor(R.color.white));
 TextView2_sgpa_cgpa_s8.setTextColor(getResources().getColor(R.color.white));

TextView2_sgpa_cgpa_cg1.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg2.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg3.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg4.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg5.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg6.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg7.setTextColor(getResources().getColor(R.color.white));

TextView2_sgpa_cgpa_semester.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg.setTextColor(getResources().getColor(R.color.white));
TextView2_sgpa_cgpa_cg_o.setTextColor(getResources().getColor(R.color.white));
	

}else if(bg_colour_main121.equalsIgnoreCase("gg_blke")){
	
	TextView_sgpa_cgpa_cgpa.setTextColor(getResources().getColor(R.color.black));

	EditText_sgpa_to_cgpa_s12.setTextColor(getResources().getColor(R.color.black));
	EditText_sgpa_to_cgpa_s3.setTextColor(getResources().getColor(R.color.black));
	EditText_sgpa_to_cgpa_s4.setTextColor(getResources().getColor(R.color.black));
	EditText_sgpa_to_cgpa_s5.setTextColor(getResources().getColor(R.color.black));
	EditText_sgpa_to_cgpa_s6.setTextColor(getResources().getColor(R.color.black));
	EditText_sgpa_to_cgpa_s7.setTextColor(getResources().getColor(R.color.black));
	EditText_sgpa_to_cgpa_s8.setTextColor(getResources().getColor(R.color.black));
	
	
	
 TextView2_sgpa_cgpa_s12.setTextColor(getResources().getColor(R.color.black));
 TextView2_sgpa_cgpa_s3.setTextColor(getResources().getColor(R.color.black));
 TextView2_sgpa_cgpa_s4.setTextColor(getResources().getColor(R.color.black));
 TextView2_sgpa_cgpa_s5.setTextColor(getResources().getColor(R.color.black));
 TextView2_sgpa_cgpa_s6.setTextColor(getResources().getColor(R.color.black));
 TextView2_sgpa_cgpa_s7.setTextColor(getResources().getColor(R.color.black));
 TextView2_sgpa_cgpa_s8.setTextColor(getResources().getColor(R.color.black));

TextView2_sgpa_cgpa_cg1.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg2.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg3.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg4.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg5.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg6.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg7.setTextColor(getResources().getColor(R.color.black));

TextView2_sgpa_cgpa_semester.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg.setTextColor(getResources().getColor(R.color.black));
TextView2_sgpa_cgpa_cg_o.setTextColor(getResources().getColor(R.color.black));

}











	button_sgpa_cgpa_submit= (Button) findViewById(R.id.button_sgpa_cgpa_submit);

	
	LinearLayout_sgpa_cgpa_cgpa = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_cgpa_cgpa);
	LinearLayout_sgpa_cgpa_per__totmarks= (LinearLayout) findViewById(R.id.LinearLayout_sgpa_cgpa_per__totmarks);
	LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.GONE);
	LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.GONE);
	
	if(ss_array[1].equalsIgnoreCase("S1&2")){

		LinearLayout_sgpa_to_cgpa_s3.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s4.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s5.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s6.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s7.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s8.setVisibility(View.GONE);
	}else if(ss_array[1].equalsIgnoreCase("S3")){

		LinearLayout_sgpa_to_cgpa_s4.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s5.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s6.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s7.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s8.setVisibility(View.GONE);
	}else if(ss_array[1].equalsIgnoreCase("S4")){

		LinearLayout_sgpa_to_cgpa_s5.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s6.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s7.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s8.setVisibility(View.GONE);
	}else if(ss_array[1].equalsIgnoreCase("S5")){

		LinearLayout_sgpa_to_cgpa_s6.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s7.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s8.setVisibility(View.GONE);
	}else if(ss_array[1].equalsIgnoreCase("S6")){


		LinearLayout_sgpa_to_cgpa_s7.setVisibility(View.GONE);
		LinearLayout_sgpa_to_cgpa_s8.setVisibility(View.GONE);
	}else if(ss_array[1].equalsIgnoreCase("S7")){


		LinearLayout_sgpa_to_cgpa_s8.setVisibility(View.GONE);
	}
	
	
	
	
	
	//2
	save_deatails = getSharedPreferences(ss_array[0], 0);   //ss_array[0] get branch
	final SharedPreferences.Editor editor = save_deatails.edit();
	
	 tot_cg_s12 =  save_deatails.getFloat("s12TOT CG", 5000);      
	 float sgpa_s12 =  save_deatails.getFloat("s12SGPA", 5000);    
	 float per_s12=  save_deatails.getFloat("s12%", 5000);    
	 tot_mark_s12 =  save_deatails.getInt("s12TOT MARK", 5000);    
	 
	 tot_cg_s3 =  save_deatails.getFloat("s3TOT CG", 5000);      
	 float sgpa_s3 =  save_deatails.getFloat("s3SGPA", 5000);    
	 float per_s3=  save_deatails.getFloat("s3%", 5000);    
	 tot_mark_s3=  save_deatails.getInt("s3TOT MARK", 5000);   
	
	  tot_cg_s4 =  save_deatails.getFloat("s4TOT CG", 5000);      
	 float sgpa_s4 =  save_deatails.getFloat("s4SGPA", 5000);    
	 float per_s4=  save_deatails.getFloat("s4%", 5000);    
	  tot_mark_s4 =  save_deatails.getInt("s4TOT MARK", 5000);   
	 
	 tot_cg_s5 =  save_deatails.getFloat("s5TOT CG", 5000);      
	 float sgpa_s5 =  save_deatails.getFloat("s5SGPA", 5000);    
	 float per_s5=  save_deatails.getFloat("s5%", 5000);    
	 tot_mark_s5 =  save_deatails.getInt("s5TOT MARK", 5000);   

	  tot_cg_s6 =  save_deatails.getFloat("s6TOT CG", 5000);      
	 float sgpa_s6 =  save_deatails.getFloat("s6SGPA", 5000);    
	 float per_s6=  save_deatails.getFloat("s6%", 5000);    
	 tot_mark_s6 =  save_deatails.getInt("s6TOT MARK", 5000);   
	 
      tot_cg_s7 =  save_deatails.getFloat("s7TOT CG", 5000);      
	 float sgpa_s7 =  save_deatails.getFloat("s7SGPA", 5000);    
	 float per_s7=  save_deatails.getFloat("s7%", 5000);    
	 tot_mark_s7 =  save_deatails.getInt("s7TOT MARK", 5000);   
	 
     tot_cg_s8 =  save_deatails.getFloat("s8TOT CG", 5000);      
	 float sgpa_s8 =  save_deatails.getFloat("s8SGPA", 5000);    
	 float per_s8=  save_deatails.getFloat("s8%", 5000);    
	  tot_mark_s8 =  save_deatails.getInt("s8TOT MARK", 5000);   
	 

	 if(tot_cg_s12!=5000f)EditText_sgpa_to_cgpa_s12.setText(Float.toString(tot_cg_s12));
	 if(tot_cg_s3!=5000f)EditText_sgpa_to_cgpa_s3.setText(Float.toString(tot_cg_s3));
	 if(tot_cg_s4!=5000f) EditText_sgpa_to_cgpa_s4.setText(Float.toString(tot_cg_s4));
	 if(tot_cg_s5!=5000f) EditText_sgpa_to_cgpa_s5.setText(Float.toString(tot_cg_s5));
	 if(tot_cg_s6!=5000f)EditText_sgpa_to_cgpa_s6.setText(Float.toString(tot_cg_s6));
	 if(tot_cg_s7!=5000f)EditText_sgpa_to_cgpa_s7.setText(Float.toString(tot_cg_s7));
	 if(tot_cg_s8!=5000f) EditText_sgpa_to_cgpa_s8.setText(Float.toString(tot_cg_s8));
	 
	 
	try{ apiLevel = Build.VERSION.SDK_INT;}catch(Exception exc){}
	
	if(apiLevel<11){
		AlertDialog alertbox = new AlertDialog.Builder(Sgpa_to_cgpa.this).create();
		alertbox.setTitle("Alert!");
		alertbox.setMessage("To calculate CGPA, you have to give the sum of CREDIT*GRADE(CG) of each semester till selected semester."+"\n\n"+"If you saved it earlier in SGPA section, it will loaded Automatically!");
		alertbox.setButton("OK", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
				            // TODO Auto-generated method stub
			                                                       }
		                                   });
		alertbox.show();
	}else{
    	  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_to_cgpa.this);
    	  addd.setTitle("Alert!");
    	  addd.setMessage("To calculate CGPA, you have to give the sum of CREDIT*GRADE(CG) of each semester till selected semester."+"\n\n"+"If you saved it earlier in SGPA section, it will loaded Automatically!");

    		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
    		      public void onClick(DialogInterface dialog, int arg1) {
    		    			// TODO Auto-generated method stub
    				System.out.println();
    		    		}
    		    	} );
    		    	addd.show();
	}

	
	
	

	button_sgpa_cgpa_submit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			try{
		
				tot_cg_s12=0f; 				tot_cg_s3=0f; 				tot_cg_s4=0f; 				tot_cg_s5=0f;
				tot_cg_s6=0f;              				tot_cg_s7=0f; 				tot_cg_s8=0f;
				
				
			if(ss_array[1].equalsIgnoreCase("S1&2")){
				
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				if(tot_cg_s12>440||tot_cg_s12<0){
					overFlowDialog();
				}else{
				float sgpa = tot_cg_s12/44;
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));
				
				}
			}else if(ss_array[1].equalsIgnoreCase("S3")){
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				tot_cg_s3=Float.valueOf(EditText_sgpa_to_cgpa_s3.getText().toString());
				
				if((tot_cg_s12>440f||tot_cg_s12<0f)||(tot_cg_s3>280f||tot_cg_s3<0f)) {
					overFlowDialog();
				}else{
					
		        float sgpa =(tot_cg_s12+tot_cg_s3)/(44+28);
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));
				}
				
			}else if(ss_array[1].equalsIgnoreCase("S4")){
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				tot_cg_s3=Float.valueOf(EditText_sgpa_to_cgpa_s3.getText().toString());
				tot_cg_s4=Float.valueOf(EditText_sgpa_to_cgpa_s4.getText().toString());
				
				
				if((tot_cg_s12>440f||tot_cg_s12<0f)||(tot_cg_s3>280f||tot_cg_s3<0f)||(tot_cg_s4>280f||tot_cg_s4<0f)) {
					overFlowDialog();
				}else{
					
				
				float sgpa =(tot_cg_s12+tot_cg_s3+tot_cg_s4)/(44+28+28);
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));
			}
			}else if(ss_array[1].equalsIgnoreCase("S5")){
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				tot_cg_s3=Float.valueOf(EditText_sgpa_to_cgpa_s3.getText().toString());
				tot_cg_s4=Float.valueOf(EditText_sgpa_to_cgpa_s4.getText().toString());
				tot_cg_s5=Float.valueOf(EditText_sgpa_to_cgpa_s5.getText().toString());
				if((tot_cg_s12>440f||tot_cg_s12<0f)||(tot_cg_s3>280f||tot_cg_s3<0f)||(tot_cg_s4>280f||tot_cg_s4<0f)||(tot_cg_s5>280f||tot_cg_s5<0f)) {
					overFlowDialog();
				}else{
					
				float sgpa =(tot_cg_s12+tot_cg_s3+tot_cg_s4+tot_cg_s5)/(44+28+28+28);
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));
				}
			}else if(ss_array[1].equalsIgnoreCase("S6")){
				
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				tot_cg_s3=Float.valueOf(EditText_sgpa_to_cgpa_s3.getText().toString());
				tot_cg_s4=Float.valueOf(EditText_sgpa_to_cgpa_s4.getText().toString());
				tot_cg_s5=Float.valueOf(EditText_sgpa_to_cgpa_s5.getText().toString());
				tot_cg_s6=Float.valueOf(EditText_sgpa_to_cgpa_s6.getText().toString());
				
				if((tot_cg_s12>440f||tot_cg_s12<0f)||(tot_cg_s3>280f||tot_cg_s3<0f)||(tot_cg_s4>280f||tot_cg_s4<0f)||(tot_cg_s5>280f||tot_cg_s5<0f)||(tot_cg_s6>280f||tot_cg_s6<0f)) {
					overFlowDialog();
				}else{
					
				float sgpa =(tot_cg_s12+tot_cg_s3+tot_cg_s4+tot_cg_s5+tot_cg_s6)/(44+28+28+28+28);
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));
				}
			}else if(ss_array[1].equalsIgnoreCase("S7")){
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				tot_cg_s3=Float.valueOf(EditText_sgpa_to_cgpa_s3.getText().toString());
				tot_cg_s4=Float.valueOf(EditText_sgpa_to_cgpa_s4.getText().toString());
				tot_cg_s5=Float.valueOf(EditText_sgpa_to_cgpa_s5.getText().toString());
				tot_cg_s6=Float.valueOf(EditText_sgpa_to_cgpa_s6.getText().toString());
				tot_cg_s7=Float.valueOf(EditText_sgpa_to_cgpa_s7.getText().toString());
				
				if((tot_cg_s12>440f||tot_cg_s12<0f)||(tot_cg_s3>280f||tot_cg_s3<0f)||(tot_cg_s4>280f||tot_cg_s4<0f)||(tot_cg_s5>280f||tot_cg_s5<0f)||(tot_cg_s6>280f||tot_cg_s6<0f)||(tot_cg_s7>280f||tot_cg_s7<0f)) {
					overFlowDialog();
				}else{
					
				float sgpa =(tot_cg_s12+tot_cg_s3+tot_cg_s4+tot_cg_s5+tot_cg_s6+tot_cg_s7)/(44+28+28+28+28+28);
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));}
			}else if(ss_array[1].equalsIgnoreCase("S8")){
				tot_cg_s12=Float.valueOf(EditText_sgpa_to_cgpa_s12.getText().toString());
				tot_cg_s3=Float.valueOf(EditText_sgpa_to_cgpa_s3.getText().toString());
				tot_cg_s4=Float.valueOf(EditText_sgpa_to_cgpa_s4.getText().toString());
				tot_cg_s5=Float.valueOf(EditText_sgpa_to_cgpa_s5.getText().toString());
				tot_cg_s6=Float.valueOf(EditText_sgpa_to_cgpa_s6.getText().toString());
				tot_cg_s7=Float.valueOf(EditText_sgpa_to_cgpa_s7.getText().toString());
				tot_cg_s8=Float.valueOf(EditText_sgpa_to_cgpa_s8.getText().toString());
				if((tot_cg_s12>440f||tot_cg_s12<0f)||(tot_cg_s3>280f||tot_cg_s3<0f)||(tot_cg_s4>280f||tot_cg_s4<0f)||(tot_cg_s5>280f||tot_cg_s5<0f)||(tot_cg_s6>280f||tot_cg_s6<0f)||(tot_cg_s7>280f||tot_cg_s7<0f)||(tot_cg_s8>280f||tot_cg_s8<0f)) {
					overFlowDialog();
				}else{
					
				float sgpa =(tot_cg_s12+tot_cg_s3+tot_cg_s4+tot_cg_s5+tot_cg_s6+tot_cg_s7+tot_cg_s8)/(44+28+28+28+28+28+28);
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.VISIBLE);
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				TextView_sgpa_cgpa_cgpa.setText("CGPA = "+df.format(sgpa));
				}
			}
			
			

			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			
			if(ss_array[1].equalsIgnoreCase("S1&2")){

				float per ;
				int tott;
				  if(tot_mark_s12!=5000){
					  tott=tot_mark_s12;
					  per=(float) tott/1650;
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.= "+df.format(per*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott);
				  }
				  
			}else if(ss_array[1].equalsIgnoreCase("S3")){

				float per3 ;
				int tott3;
				  if(tot_mark_s12!=5000&&tot_mark_s3!=5000){
					  tott3=tot_mark_s12+tot_mark_s3;
					  per3=(float) tott3/(1650+1200);
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.="+df.format(per3*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott3);
				  }
					  
			}else if(ss_array[1].equalsIgnoreCase("S4")){

				
				float per3 ;
				int tott3;
				  if(tot_mark_s12!=5000&&tot_mark_s3!=5000&&tot_mark_s4!=5000){
					  tott3=tot_mark_s12+tot_mark_s3+tot_mark_s4;
					  per3= (float) tott3/(1650+1200+1200);
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.="+df.format(per3*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott3);
				  }
		
			}else if(ss_array[1].equalsIgnoreCase("S5")){

				
				float per3 ;
				int tott3;
				  if(tot_mark_s12!=5000&&tot_mark_s3!=5000&&tot_mark_s4!=5000&&tot_mark_s5!=5000){
					  tott3=tot_mark_s12+tot_mark_s3+tot_mark_s4+tot_mark_s5;
					  per3= (float) tott3/(1650+1200+1200+1200);
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.="+df.format(per3*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott3);
				  }
				  
	
			}else if(ss_array[1].equalsIgnoreCase("S6")){


				float per3 ;
				int tott3;
				  if(tot_mark_s12!=5000&&tot_mark_s3!=5000&&tot_mark_s4!=5000&&tot_mark_s5!=5000&&tot_mark_s6!=5000){
					  tott3= tot_mark_s12+tot_mark_s3+tot_mark_s4+tot_mark_s5+tot_mark_s6;
					  per3= (float) tott3/(1650+1200+1200+1200+1200);
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.="+df.format(per3*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott3);
				  }
				  
				  
			}else if(ss_array[1].equalsIgnoreCase("S7")){

				
				float per3 ;
				int tott3;
				  if(tot_mark_s12!=5000&&tot_mark_s3!=5000&&tot_mark_s4!=5000&&tot_mark_s5!=5000&&tot_mark_s6!=5000&&tot_mark_s7!=5000){
					  tott3=tot_mark_s12+tot_mark_s3+tot_mark_s4+tot_mark_s5+tot_mark_s6+tot_mark_s7;
					  per3= (float) tott3/(1650+1200+1200+1200+1200+1300);
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.="+df.format(per3*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott3);
				  }
				  

			}else if(ss_array[1].equalsIgnoreCase("S8")){

				
				float per3 ;
				int tott3;
				  if(tot_mark_s12!=5000&&tot_mark_s3!=5000&&tot_mark_s4!=5000&&tot_mark_s5!=5000&&tot_mark_s6!=5000&&tot_mark_s7!=5000&&tot_mark_s8!=5000){
					  tott3=tot_mark_s12+tot_mark_s3+tot_mark_s4+tot_mark_s5+tot_mark_s6+tot_mark_s7+tot_mark_s8;
					  per3= (float) tott3/(1650+1200+1200+1200+1200+1300+1050);
					  
					  LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.VISIBLE);
					  TextView_s3_percent_s.setText("PERCE.="+df.format(per3*100));
					  TextView_s3_totmark_s.setText("TOT MARK="+tott3);
				  }
				  

			}
			
			
			
			}catch(Exception exc){
			
				LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.GONE);
				LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.GONE);
		int	apiLevel1= 0;
				try{ apiLevel1 = Build.VERSION.SDK_INT;}catch(Exception exyc){}
				
				if(apiLevel1<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_to_cgpa.this).create();
					alertbox.setTitle("Error Occurred!");
					alertbox.setMessage("Enter all fields");
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
			    	  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_to_cgpa.this);
			    	  addd.setTitle("Error Occurred!");
			    	  addd.setMessage("Enter all fields");

			    		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			    		      public void onClick(DialogInterface dialog, int arg1) {
			    		    			// TODO Auto-generated method stub
			    				System.out.println();
			    		    		}
			    		    	} );
			    		    	
			    		    	addd.show();
			}}
			
			
			

			
			
			
		}
	});
	
	
	
}


void overFlowDialog(){
	
	LinearLayout_sgpa_cgpa_cgpa.setVisibility(View.GONE);
	LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.GONE);
	int	apiLevel1= 0;
	try{ apiLevel1 = Build.VERSION.SDK_INT;}catch(Exception exyc){}
	
	if(apiLevel1<11){	LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.GONE);
		AlertDialog alertbox = new AlertDialog.Builder(Sgpa_to_cgpa.this).create();
		alertbox.setTitle("Alert!");
		alertbox.setMessage("S1&2 CG should be 0~440"+"\n"+"Others should be 0~280");
		alertbox.setButton("OK", new DialogInterface.OnClickListener() {
			            public void onClick(DialogInterface dialog, int which) {
				            // TODO Auto-generated method stub
			                                                       }
		                                   });
		alertbox.show();
	}else{	LinearLayout_sgpa_cgpa_per__totmarks.setVisibility(View.GONE);
    	  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_to_cgpa.this);
    	  addd.setTitle("Alert!");
    	  addd.setMessage("S1&2 CG should be 0~440"+"\n"+"Others should be 0~280");

    		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
    		      public void onClick(DialogInterface dialog, int arg1) {
    		    			// TODO Auto-generated method stub
    				System.out.println();
    		    		}
    		    	} );
    		    	addd.show();
}
	
}

}
