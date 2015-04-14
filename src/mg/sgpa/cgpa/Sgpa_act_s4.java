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

public class Sgpa_act_s4 extends Activity{
	String ss;
	TextView tv_semester4_name; 
	TextView TextView2_s4_subject1, TextView2_s4_subject2, TextView2_s4_subject3, TextView2_s4_subject4, TextView2_s4_subject5, TextView2_s4_subject6,TextView2_s4_subject7,TextView2_s4_subject8 ;
	TextView	 TextView2_s4_credit1, TextView2_s4_credit2, TextView2_s4_credit3, TextView2_s4_credit4, TextView2_s4_credit5, TextView2_s4_credit6,TextView2_s4_credit7,TextView2_s4_credit8 ;
    TextView TextView2_s4_credit, TextView2_s4_subject, TextView2_s4_mark;
	
	///1.1
	SharedPreferences save_deatails ;
	int total_marks=0;
	float cgpa = 0; float cgpa1;
	float percentage;
	Button button_sgpa_s4_save;
	
	
	///11111
	TextView TextView_s4_cgpa,TextView_s4_percentage,TextView_s4_totmark,TextView_s4_cg;
	EditText EditText_sgpa_s4_mark1, EditText_sgpa_s4_mark2, EditText_sgpa_s4_mark3, EditText_sgpa_s4_mark4,
                	EditText_sgpa_s4_mark5, EditText_sgpa_s4_mark6, EditText_sgpa_s4_mark7, EditText_sgpa_s4_mark8;
	Button button1_s4_submit;
	LinearLayout LinearLayout_sgpa_s4_result;
	boolean overflow_flag=false;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.sgpa_front_s4); 
	
	

	RelativeLayout Relativelayout_bg = (RelativeLayout) findViewById(R.id.Relativelayout_bg_s4);
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
	button_sgpa_s4_save = (Button) findViewById(R.id.button_sgpa_s4_save);
	
	
	tv_semester4_name = (TextView) findViewById(R.id.textView6_semester4_name);
	TextView2_s4_subject1 = (TextView) findViewById(R.id.TextView2_s4_subject1);
	TextView2_s4_subject2 = (TextView) findViewById(R.id.TextView2_s4_subject2);
	TextView2_s4_subject3 = (TextView) findViewById(R.id.TextView2_s4_subject3);
	TextView2_s4_subject4 = (TextView) findViewById(R.id.TextView2_s4_subject4);
	TextView2_s4_subject5 = (TextView) findViewById(R.id.TextView2_s4_subject5);
	TextView2_s4_subject6 = (TextView) findViewById(R.id.TextView2_s4_subject6);
	TextView2_s4_subject7 = (TextView) findViewById(R.id.TextView2_s4_subject7);
	TextView2_s4_subject8 = (TextView) findViewById(R.id.TextView2_s4_subject8);
	//2222
	EditText_sgpa_s4_mark1=(EditText) findViewById(R.id.EditText_sgpa_s4_mark1);
	EditText_sgpa_s4_mark2=(EditText) findViewById(R.id.EditText_sgpa_s4_mark2);
	EditText_sgpa_s4_mark3=(EditText) findViewById(R.id.EditText_sgpa_s4_mark3);
	EditText_sgpa_s4_mark4=(EditText) findViewById(R.id.EditText_sgpa_s4_mark4);
	EditText_sgpa_s4_mark5=(EditText) findViewById(R.id.EditText_sgpa_s4_mark5);
	EditText_sgpa_s4_mark6=(EditText) findViewById(R.id.EditText_sgpa_s4_mark6);
	EditText_sgpa_s4_mark7=(EditText) findViewById(R.id.EditText_sgpa_s4_mark7);
	EditText_sgpa_s4_mark8=(EditText) findViewById(R.id.EditText_sgpa_s4_mark8);

	
	TextView_s4_cgpa =(TextView) findViewById(R.id.TextView_s4_cgpa);
	TextView_s4_percentage = (TextView) findViewById(R.id.TextView_s4_percent);
	TextView_s4_totmark = (TextView) findViewById(R.id.TextView_s4_totmark);
	TextView_s4_cg = (TextView) findViewById(R.id.TextView_s4_cg);
	
	
	
	
	 TextView2_s4_credit1= (TextView) findViewById(R.id.TextView2_s4_credit1);
	 TextView2_s4_credit2= (TextView) findViewById(R.id.TextView2_s4_credit2);
	 TextView2_s4_credit3= (TextView) findViewById(R.id.TextView2_s4_credit3);
	 TextView2_s4_credit4= (TextView) findViewById(R.id.TextView2_s4_credit4);
	 TextView2_s4_credit5= (TextView) findViewById(R.id.TextView2_s4_credit5);
	 TextView2_s4_credit6= (TextView) findViewById(R.id.TextView2_s4_credit6);
	 TextView2_s4_credit7= (TextView) findViewById(R.id.TextView2_s4_credit7);
	 TextView2_s4_credit8 = (TextView) findViewById(R.id.TextView2_s4_credit8);
	 
 TextView2_s4_credit = (TextView) findViewById(R.id.TextView2_s4_credit);
 TextView2_s4_subject= (TextView) findViewById(R.id.TextView2_s4_subject);
 TextView2_s4_mark= (TextView) findViewById(R.id.TextView2_s4_mark);
	
 String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
 if(bg_colour_main121.equalsIgnoreCase("gg_white")){
	 
		TextView2_s4_subject1.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject2.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject3.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject4.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject5.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject6.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject7.setTextColor(getResources().getColor(R.color.white));
		TextView2_s4_subject8.setTextColor(getResources().getColor(R.color.white));
		
		
		//2222
		EditText_sgpa_s4_mark1.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark2.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark3.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark4.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark5.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark6.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark7.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s4_mark8.setTextColor(getResources().getColor(R.color.white));

		
		TextView_s4_cgpa.setTextColor(getResources().getColor(R.color.white));
		TextView_s4_percentage.setTextColor(getResources().getColor(R.color.white));
		TextView_s4_totmark.setTextColor(getResources().getColor(R.color.white));
		TextView_s4_cg.setTextColor(getResources().getColor(R.color.white));
		
		 TextView2_s4_credit1.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit2.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit3.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit4.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit5.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit6.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit7.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s4_credit8.setTextColor(getResources().getColor(R.color.white));
		 
	 TextView2_s4_credit.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s4_subject.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s4_mark.setTextColor(getResources().getColor(R.color.white));
 }else if(bg_colour_main121.equalsIgnoreCase("gg_blke")){

		TextView2_s4_subject1.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject2.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject3.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject4.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject5.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject6.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject7.setTextColor(getResources().getColor(R.color.black));
		TextView2_s4_subject8.setTextColor(getResources().getColor(R.color.black));
		
		
		//2222
		EditText_sgpa_s4_mark1.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark2.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark3.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark4.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark5.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark6.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark7.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s4_mark8.setTextColor(getResources().getColor(R.color.black));

		
		TextView_s4_cgpa.setTextColor(getResources().getColor(R.color.black));
		TextView_s4_percentage.setTextColor(getResources().getColor(R.color.black));
		TextView_s4_totmark.setTextColor(getResources().getColor(R.color.black));
		TextView_s4_cg.setTextColor(getResources().getColor(R.color.black));
		
		 TextView2_s4_credit1.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit2.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit3.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit4.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit5.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit6.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit7.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s4_credit8.setTextColor(getResources().getColor(R.color.black));
		 
	 TextView2_s4_credit.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s4_subject.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s4_mark.setTextColor(getResources().getColor(R.color.black));
 }
 
	button1_s4_submit = (Button) findViewById(R.id.button1_s4_submit111);

	LinearLayout_sgpa_s4_result = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_s4_result);
	
	if(ss_array[0].equalsIgnoreCase("CS")){ //
		TextView2_s4_subject1.setText("E MAT");
		TextView2_s4_subject2.setText("OOP");
		TextView2_s4_subject3.setText("DSA");
		TextView2_s4_subject4.setText("S&CS");
		TextView2_s4_subject5.setText("M S");
		TextView2_s4_subject6.setText("TOC");
		TextView2_s4_subject7.setText("DS LAB");
		TextView2_s4_subject8.setText("ECC LAB");
	}else if(ss_array[0].equalsIgnoreCase("CIVIL")){//
		TextView2_s4_subject1.setText("E MAT");
		TextView2_s4_subject2.setText("CEM");
		TextView2_s4_subject3.setText("M S-II");
		TextView2_s4_subject4.setText("OCF& HM");
		TextView2_s4_subject5.setText("SUR-II");
		TextView2_s4_subject6.setText("CED");
		TextView2_s4_subject7.setText("SUR PRA-II");
		TextView2_s4_subject8.setText("Hyd. LAB");
	}else if(ss_array[0].equalsIgnoreCase("IT")){//
		TextView2_s4_subject1.setText("E MAT");
		TextView2_s4_subject2.setText("P M");
		TextView2_s4_subject3.setText("COA");
		TextView2_s4_subject4.setText("TOC");
		TextView2_s4_subject5.setText("DSA");
		TextView2_s4_subject6.setText("OOT");
		TextView2_s4_subject7.setText("LD LAB");
		TextView2_s4_subject8.setText("DS LAB");
	}else if(ss_array[0].equalsIgnoreCase("EC")){
		TextView2_s4_subject1.setText("E MAT");
		TextView2_s4_subject2.setText("P M");
		TextView2_s4_subject3.setText("S S");
		TextView2_s4_subject4.setText("D E");
		TextView2_s4_subject5.setText("A C");
		TextView2_s4_subject6.setText("A C-II");
		TextView2_s4_subject7.setText("AC-II LAB");
		TextView2_s4_subject8.setText("AC LAB");
	}else if(ss_array[0].equalsIgnoreCase("EEE")){//
		TextView2_s4_subject1.setText("E MECH");
		TextView2_s4_subject2.setText("DCM&T");
		TextView2_s4_subject3.setText("LSA");
		TextView2_s4_subject4.setText("E T");
		TextView2_s4_subject5.setText("DSCO");
		TextView2_s4_subject6.setText("C P");
		TextView2_s4_subject7.setText("CP LAB");
		TextView2_s4_subject8.setText("EC LAB");
	}else if(ss_array[0].equalsIgnoreCase("MECH")){//
		TextView2_s4_subject1.setText("E MECH");
		TextView2_s4_subject2.setText("P M");
		TextView2_s4_subject3.setText("H M");
		TextView2_s4_subject4.setText("M P");
		TextView2_s4_subject5.setText("M D");
		TextView2_s4_subject6.setText("E T");
		TextView2_s4_subject7.setText("HM LAB");
		TextView2_s4_subject8.setText("SM LAB");
	}
	
	//333
	LinearLayout_sgpa_s4_result.setVisibility(View.GONE);
	
	
	button1_s4_submit.setOnClickListener(new OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			overflow_flag=false;
			float[] marks_grade = new float[8];
			int[] marks_o_credit = {4,4,4,4,4,4,2,2};
				
		

			try{
			int[] marks = { Integer.parseInt(EditText_sgpa_s4_mark1.getText().toString()),  Integer.parseInt(EditText_sgpa_s4_mark2.getText().toString()),  Integer.parseInt(EditText_sgpa_s4_mark3.getText().toString()),  Integer.parseInt(EditText_sgpa_s4_mark4.getText().toString()),  Integer.parseInt(EditText_sgpa_s4_mark5.getText().toString()),
					 Integer.parseInt(EditText_sgpa_s4_mark6.getText().toString()), Integer.parseInt(EditText_sgpa_s4_mark7.getText().toString()), Integer.parseInt(EditText_sgpa_s4_mark8.getText().toString())};
				

				
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
				
				if(LinearLayout_sgpa_s4_result.isShown()){LinearLayout_sgpa_s4_result.setVisibility(View.GONE);}
				int apiLevel = 0;
				try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception exc){}
				
				
				if(apiLevel<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s4.this).create();
					alertbox.setTitle("Attention !");
					alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
					  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s4.this);
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
					   
						LinearLayout_sgpa_s4_result.setVisibility(View.VISIBLE);
						DecimalFormat df = new DecimalFormat();
						df.setMaximumFractionDigits(2);
		
						 TextView_s4_cg.setText("TOT CG="+df.format(cgpa));
					   TextView_s4_cgpa.setText("SGPA="+df.format(cgpa1));
					   TextView_s4_percentage.setText(df.format(percentage)+"%");
					   TextView_s4_totmark.setText("TOT MARK="+Integer.toString(total_marks));
			}
				
				}catch(Exception exc){//Toast.makeText(getBaseContext(), exc.toString(), Toast.LENGTH_LONG).show();
			int apiLevel = 0;
			
			if(LinearLayout_sgpa_s4_result.isShown()){LinearLayout_sgpa_s4_result.setVisibility(View.GONE);}
			try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception excn){}
			
			
			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s4.this).create();
				alertbox.setTitle("Attention !");
				alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s4.this);
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
	
	
	tv_semester4_name.setText(ss_array[0]+" Semester 4");
	
	
	//1.3
	
	button_sgpa_s4_save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		   editor.putFloat("s4TOT CG",cgpa);
		   editor.putFloat("s4SGPA",cgpa1);
		   editor.putFloat("s4%",percentage);
		   editor.putInt("s4TOT MARK", total_marks);
		   
            editor.commit();
            
            
int apiLevel = Build.VERSION.SDK_INT;
			

			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s4.this).create();
				alertbox.setTitle("Saved !");
				alertbox.setMessage("* SGPA saved for calculating CGPA");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s4.this);
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
