package mg.sgpa.cgpa;

import java.text.DecimalFormat;

import mg.sgpa.cgpa.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Sgpa_act_s5 extends Activity{
	String ss;
	TextView tv_semester5_name;
	TextView TextView2_s5_subject1, TextView2_s5_subject2, TextView2_s5_subject3, TextView2_s5_subject4, TextView2_s5_subject5, TextView2_s5_subject6,TextView2_s5_subject7,TextView2_s5_subject8 ;
	
	TextView	 TextView2_s5_credit1, TextView2_s5_credit2, TextView2_s5_credit3, TextView2_s5_credit4, TextView2_s5_credit5, TextView2_s5_credit6,TextView2_s5_credit7,TextView2_s5_credit8 ;
    TextView TextView2_s5_credit, TextView2_s5_subject, TextView2_s5_mark;
    
	///1.1
	SharedPreferences save_deatails ;
	int total_marks=0;
	float cgpa = 0; float cgpa1;
	float percentage;
	Button button_sgpa_s5_save;
	
	///11111
		TextView TextView_s5_cgpa,TextView_s5_percentage,TextView_s5_totmark,TextView_s5_cg;
		EditText EditText_sgpa_s5_mark1, EditText_sgpa_s5_mark2, EditText_sgpa_s5_mark3, EditText_sgpa_s5_mark4,
	                	EditText_sgpa_s5_mark5, EditText_sgpa_s5_mark6, EditText_sgpa_s5_mark7, EditText_sgpa_s5_mark8;
		Button button1_s5_submit;
		LinearLayout LinearLayout_sgpa_s5_result;
		boolean overflow_flag=false;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.sgpa_front_s5); 
	
	
	


	RelativeLayout Relativelayout_bg = (RelativeLayout) findViewById(R.id.Relativelayout_bg_s5);
    SharedPreferences setting = getSharedPreferences("settings", 0);     
	   	 String bg_colour_main12 = setting.getString("bg_colour_main", "g_def");          
	   	 if(!(bg_colour_main12.equalsIgnoreCase("g_def"))){
	  Slsect_main_gridview_bg obb = new Slsect_main_gridview_bg();
	   int nn = obb.get_main_linear_layout_bg(bg_colour_main12);
	   Relativelayout_bg.setBackgroundDrawable(getResources().getDrawable(nn)); //gradient all effect work
	   	 }else{
	   		Relativelayout_bg.setBackgroundDrawable(getResources().getDrawable(R.drawable.background)); 
	   	 }
	   	 
	   	 
	Bundle string_extras = getIntent().getExtras();
	if(string_extras!=null){
		ss = string_extras.getString("sgpa_sx");
	}
	
	String[] ss_array = ss.split("@");
	
	//1.2
	save_deatails = getSharedPreferences(ss_array[0], 0);   //ss_array[0] get branch
	final SharedPreferences.Editor editor = save_deatails.edit();
	button_sgpa_s5_save = (Button) findViewById(R.id.button_sgpa_s5_save);
	
	
	tv_semester5_name = (TextView) findViewById(R.id.textView6_semester5_name);
	TextView2_s5_subject1 = (TextView) findViewById(R.id.TextView2_s5_subject1);
	TextView2_s5_subject2 = (TextView) findViewById(R.id.TextView2_s5_subject2);
	TextView2_s5_subject3 = (TextView) findViewById(R.id.TextView2_s5_subject3);
	TextView2_s5_subject4 = (TextView) findViewById(R.id.TextView2_s5_subject4);
	TextView2_s5_subject5 = (TextView) findViewById(R.id.TextView2_s5_subject5);
	TextView2_s5_subject6 = (TextView) findViewById(R.id.TextView2_s5_subject6);
	TextView2_s5_subject7 = (TextView) findViewById(R.id.TextView2_s5_subject7);
	TextView2_s5_subject8 = (TextView) findViewById(R.id.TextView2_s5_subject8);
	
	
	
	//2222
	EditText_sgpa_s5_mark1=(EditText) findViewById(R.id.EditText_sgpa_s5_mark1);
	EditText_sgpa_s5_mark2=(EditText) findViewById(R.id.EditText_sgpa_s5_mark2);
	EditText_sgpa_s5_mark3=(EditText) findViewById(R.id.EditText_sgpa_s5_mark3);
	EditText_sgpa_s5_mark4=(EditText) findViewById(R.id.EditText_sgpa_s5_mark4);
	EditText_sgpa_s5_mark5=(EditText) findViewById(R.id.EditText_sgpa_s5_mark5);
	EditText_sgpa_s5_mark6=(EditText) findViewById(R.id.EditText_sgpa_s5_mark6);
	EditText_sgpa_s5_mark7=(EditText) findViewById(R.id.EditText_sgpa_s5_mark7);
	EditText_sgpa_s5_mark8=(EditText) findViewById(R.id.EditText_sgpa_s5_mark8);

	
	TextView_s5_cgpa =(TextView) findViewById(R.id.TextView_s5_cgpa);
	TextView_s5_percentage = (TextView) findViewById(R.id.TextView_s5_percent);
	TextView_s5_totmark = (TextView) findViewById(R.id.TextView_s5_totmark);
	TextView_s5_cg = (TextView) findViewById(R.id.TextView_s5_cg);
	
	
	
	
	
	
	 TextView2_s5_credit1= (TextView) findViewById(R.id.TextView2_s5_credit1);
	 TextView2_s5_credit2= (TextView) findViewById(R.id.TextView2_s5_credit2);
	 TextView2_s5_credit3= (TextView) findViewById(R.id.TextView2_s5_credit3);
	 TextView2_s5_credit4= (TextView) findViewById(R.id.TextView2_s5_credit4);
	 TextView2_s5_credit5= (TextView) findViewById(R.id.TextView2_s5_credit5);
	 TextView2_s5_credit6= (TextView) findViewById(R.id.TextView2_s5_credit6);
	 TextView2_s5_credit7= (TextView) findViewById(R.id.TextView2_s5_credit7);
	 TextView2_s5_credit8 = (TextView) findViewById(R.id.TextView2_s5_credit8);
	 
 TextView2_s5_credit = (TextView) findViewById(R.id.TextView2_s5_credit);
 TextView2_s5_subject= (TextView) findViewById(R.id.TextView2_s5_subject);
 TextView2_s5_mark= (TextView) findViewById(R.id.TextView2_s5_mark);
	
 String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
 if(bg_colour_main121.equalsIgnoreCase("gg_white")){
	 
		TextView2_s5_subject1.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject2.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject3.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject4.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject5.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject6.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject7.setTextColor(getResources().getColor(R.color.white));
		TextView2_s5_subject8.setTextColor(getResources().getColor(R.color.white));
		
		
		//2222
		EditText_sgpa_s5_mark1.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark2.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark3.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark4.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark5.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark6.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark7.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s5_mark8.setTextColor(getResources().getColor(R.color.white));

		
		TextView_s5_cgpa.setTextColor(getResources().getColor(R.color.white));
		TextView_s5_percentage.setTextColor(getResources().getColor(R.color.white));
		TextView_s5_totmark.setTextColor(getResources().getColor(R.color.white));
		TextView_s5_cg.setTextColor(getResources().getColor(R.color.white));
		
		 TextView2_s5_credit1.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit2.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit3.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit4.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit5.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit6.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit7.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s5_credit8.setTextColor(getResources().getColor(R.color.white));
		 
	 TextView2_s5_credit.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s5_subject.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s5_mark.setTextColor(getResources().getColor(R.color.white));
 }else if(bg_colour_main121.equalsIgnoreCase("gg_blke")){

		TextView2_s5_subject1.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject2.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject3.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject4.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject5.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject6.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject7.setTextColor(getResources().getColor(R.color.black));
		TextView2_s5_subject8.setTextColor(getResources().getColor(R.color.black));
		
		
		//2222
		EditText_sgpa_s5_mark1.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark2.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark3.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark4.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark5.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark6.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark7.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s5_mark8.setTextColor(getResources().getColor(R.color.black));

		
		TextView_s5_cgpa.setTextColor(getResources().getColor(R.color.black));
		TextView_s5_percentage.setTextColor(getResources().getColor(R.color.black));
		TextView_s5_totmark.setTextColor(getResources().getColor(R.color.black));
		TextView_s5_cg.setTextColor(getResources().getColor(R.color.black));
		
		 TextView2_s5_credit1.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit2.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit3.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit4.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit5.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit6.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit7.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s5_credit8.setTextColor(getResources().getColor(R.color.black));
		 
	 TextView2_s5_credit.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s5_subject.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s5_mark.setTextColor(getResources().getColor(R.color.black));
 }
 
 
 
 
 
	button1_s5_submit = (Button) findViewById(R.id.button1_s5_submit111);

	LinearLayout_sgpa_s5_result = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_s5_result);
	
	if(ss_array[0].equalsIgnoreCase("CS")){ //uuuu
		TextView2_s5_subject1.setText("E MAT");
		TextView2_s5_subject2.setText("PM");
		TextView2_s5_subject3.setText("DBMS");
		TextView2_s5_subject4.setText("DSP");
		TextView2_s5_subject5.setText("OS");
		TextView2_s5_subject6.setText("AM&P");
		TextView2_s5_subject7.setText("DB LAB");
		TextView2_s5_subject8.setText("MP LAB");
	}else if(ss_array[0].equalsIgnoreCase("CIVIL")){//uuu
		TextView2_s5_subject1.setText("E MAT");
		TextView2_s5_subject2.setText("C P");
		TextView2_s5_subject3.setText("DCS-1");
		TextView2_s5_subject4.setText("G E-1");
		TextView2_s5_subject5.setText("QS & V");
		TextView2_s5_subject6.setText("S S-1");
		TextView2_s5_subject7.setText("CT LAB");
		TextView2_s5_subject8.setText("GE LAB");
	}else if(ss_array[0].equalsIgnoreCase("IT")){//uuuu
		TextView2_s5_subject1.setText("E MAT");
		TextView2_s5_subject2.setText("MP");
		TextView2_s5_subject3.setText("DC");
		TextView2_s5_subject4.setText("OS");
		TextView2_s5_subject5.setText("LT");
		TextView2_s5_subject6.setText("DBMS");
		TextView2_s5_subject7.setText("MP LAB");
		TextView2_s5_subject8.setText("SYS LAB");
	}else if(ss_array[0].equalsIgnoreCase("EC")){//u
		TextView2_s5_subject1.setText("E MAT");
		TextView2_s5_subject2.setText("C S");
		TextView2_s5_subject3.setText("DSD");
		TextView2_s5_subject4.setText("ED&C");
		TextView2_s5_subject5.setText("AET");
		TextView2_s5_subject6.setText("MP");
		TextView2_s5_subject7.setText("DE LAB");
		TextView2_s5_subject8.setText("EDC LAB");
	}else if(ss_array[0].equalsIgnoreCase("EEE")){//uuu
		TextView2_s5_subject1.setText("E MECH");
		TextView2_s5_subject2.setText("P M");
		TextView2_s5_subject3.setText("S S");
		TextView2_s5_subject4.setText("P E");
		TextView2_s5_subject5.setText("LIC");
		TextView2_s5_subject6.setText("MP A");
		TextView2_s5_subject7.setText("EM LAB");
		TextView2_s5_subject8.setText("IC LAB");
	}else if(ss_array[0].equalsIgnoreCase("MECH")){//uu
		TextView2_s5_subject1.setText("E MECH");
		TextView2_s5_subject2.setText("CAD");
		TextView2_s5_subject3.setText("AMM");
		TextView2_s5_subject4.setText("K M");
		TextView2_s5_subject5.setText("IC Eng.");
		TextView2_s5_subject6.setText("Therm.");
		TextView2_s5_subject7.setText("CG Draft.");
		TextView2_s5_subject8.setText("EE LAB");
	}
	
	//333
	LinearLayout_sgpa_s5_result.setVisibility(View.GONE);
	
	
	button1_s5_submit.setOnClickListener(new OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			overflow_flag=false;
			float[] marks_grade = new float[8];
			int[] marks_o_credit = {4,4,4,4,4,4,2,2};
				


			try{
			int[] marks = { Integer.parseInt(EditText_sgpa_s5_mark1.getText().toString()),  Integer.parseInt(EditText_sgpa_s5_mark2.getText().toString()),  Integer.parseInt(EditText_sgpa_s5_mark3.getText().toString()),  Integer.parseInt(EditText_sgpa_s5_mark4.getText().toString()),  Integer.parseInt(EditText_sgpa_s5_mark5.getText().toString()),
					 Integer.parseInt(EditText_sgpa_s5_mark6.getText().toString()), Integer.parseInt(EditText_sgpa_s5_mark7.getText().toString()), Integer.parseInt(EditText_sgpa_s5_mark8.getText().toString())};
				

				
				for(int i=0;i<=7;i++){
					if((marks[i]<=150)&&(marks[i]>=136)){
						marks_grade[i]=10;
					}else if((marks[i]<=135)&&(marks[i]>=121)){
						marks_grade[i]=9;
					}else if((marks[i]<=120)&&(marks[i]>=106)){
						marks_grade[i]=8;
					}else if((marks[i]<=105)&&(marks[i]>=91)){
						marks_grade[i]=7;
					}else if((marks[i]<=90)&&(marks[i]>=83)){
						marks_grade[i]=6;
					}else if((marks[i]<=82)&&(marks[i]>=75)){
						marks_grade[i]=(float) 5.5;
					}else if((marks[i]<=74)&&(marks[i]>=0)){
						marks_grade[i]=(float) 0;
					}else{
						overflow_flag=true;
					}
				}
				
			if(overflow_flag){
				
				if(LinearLayout_sgpa_s5_result.isShown()){LinearLayout_sgpa_s5_result.setVisibility(View.GONE);}
				int apiLevel = 0;
				try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception exc){}
				
				
				if(apiLevel<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s5.this).create();
					alertbox.setTitle("Attention !");
					alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
					  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s5.this);
					  addd.setTitle("Attention !");
						addd.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
	            		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
	            		      public void onClick(DialogInterface dialog, int arg1) {
	            		    			// TODO Auto-generated method stub
	            				System.out.println();
	            		    		}
	            		    	} );
	            		    	addd.show();
				}
			
			
			}else{
				//1.4
				total_marks=0;
				cgpa = 0;  cgpa1=0;
			  percentage=0;
			  
					
					   for(int i=0;i<=7;i++){
						total_marks=total_marks+marks[i];
						cgpa=cgpa+(marks_o_credit[i]*marks_grade[i]);
					   }
					    cgpa1=cgpa/28;
					      percentage=((float) total_marks/1200)*100;
					   
						LinearLayout_sgpa_s5_result.setVisibility(View.VISIBLE);
						DecimalFormat df = new DecimalFormat();
						df.setMaximumFractionDigits(2);
		
						 TextView_s5_cg.setText("TOT CG="+df.format(cgpa));
					   TextView_s5_cgpa.setText("SGPA="+df.format(cgpa1));
					   TextView_s5_percentage.setText(df.format(percentage)+"%");
					   TextView_s5_totmark.setText("TOT MARK="+Integer.toString(total_marks));
			}
				
				}catch(Exception exc){//Toast.makeText(getBaseContext(), exc.toString(), Toast.LENGTH_LONG).show();
			int apiLevel = 0;
			
			if(LinearLayout_sgpa_s5_result.isShown()){LinearLayout_sgpa_s5_result.setVisibility(View.GONE);}
			try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception excn){}
			
			
			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s5.this).create();
				alertbox.setTitle("Attention !");
				alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s5.this);
				  addd.setTitle("Attention !");
					addd.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
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
	});
	
	
	tv_semester5_name.setText(ss_array[0]+" Semester 5");
	
	//1.3
	
	button_sgpa_s5_save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		   editor.putFloat("s5TOT CG",cgpa);
		   editor.putFloat("s5SGPA",cgpa1);
		   editor.putFloat("s5%",percentage);
		   editor.putInt("s5TOT MARK", total_marks);
		   
            editor.commit();
            
            
int apiLevel = Build.VERSION.SDK_INT;
			

			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s5.this).create();
				alertbox.setTitle("Saved !");
				alertbox.setMessage("* SGPA saved for calculating CGPA");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s5.this);
				  addd.setTitle("Saved !");
					addd.setMessage("* SGPA saved for calculating CGPA");
            		    	addd.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            		      public void onClick(DialogInterface dialog, int arg1) {
            		    			// TODO Auto-generated method stub
            				System.out.println();
            		    		}
            		    	} );
            		    	addd.show();
			}
            
		}
	});
	
	
	}
	
}

