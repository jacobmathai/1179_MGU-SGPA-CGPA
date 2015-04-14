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

public class Sgpa_act_s7 extends Activity{
	String ss;
	TextView tv_semester7_name;
	TextView TextView2_s7_subject1, TextView2_s7_subject2, TextView2_s7_subject3, TextView2_s7_subject4, TextView2_s7_subject5, TextView2_s7_subject6,TextView2_s7_subject7,TextView2_s7_subject8,TextView2_s7_subject9,TextView2_s7_subject10 ;
	TextView	 TextView2_s7_credit1, TextView2_s7_credit2, TextView2_s7_credit3, TextView2_s7_credit4, TextView2_s7_credit5, TextView2_s7_credit6,TextView2_s7_credit7,TextView2_s7_credit8,TextView2_s7_credit9,TextView2_s7_credit10 ;
    TextView TextView2_s7_credit, TextView2_s7_subject, TextView2_s7_mark;

	///1.1
	SharedPreferences save_deatails ;
	int total_marks=0;
	float cgpa = 0; float cgpa1;
	float percentage;
	Button button_sgpa_s7_save;
	
	///11111
	TextView TextView_s7_cgpa,TextView_s7_percentage,TextView_s7_totmark,TextView_s7_cg;
	EditText EditText_sgpa_s7_mark1, EditText_sgpa_s7_mark2, EditText_sgpa_s7_mark3, EditText_sgpa_s7_mark4,
                	EditText_sgpa_s7_mark5, EditText_sgpa_s7_mark6, EditText_sgpa_s7_mark7, EditText_sgpa_s7_mark8,
                	EditText_sgpa_s7_mark9, EditText_sgpa_s7_mark10;
	Button button1_s7_submit;
	LinearLayout LinearLayout_sgpa_s7_result;
	boolean overflow_flag=false;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.sgpa_front_s7); 
	
	
	
	RelativeLayout Relativelayout_bg = (RelativeLayout) findViewById(R.id.Relativelayout_bg_s7);
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
	
	button_sgpa_s7_save = (Button) findViewById(R.id.button_sgpa_s7_save);
	
	
	
	tv_semester7_name = (TextView) findViewById(R.id.textView7_semester6_name);
	
	
	TextView2_s7_subject1 = (TextView) findViewById(R.id.TextView2_s7_subject1);
	TextView2_s7_subject2 = (TextView) findViewById(R.id.TextView2_s7_subject2);
	TextView2_s7_subject3 = (TextView) findViewById(R.id.TextView2_s7_subject3);
	TextView2_s7_subject4 = (TextView) findViewById(R.id.TextView2_s7_subject4);
	TextView2_s7_subject5 = (TextView) findViewById(R.id.TextView2_s7_subject5);
	TextView2_s7_subject6 = (TextView) findViewById(R.id.TextView2_s7_subject6);
	TextView2_s7_subject7 = (TextView) findViewById(R.id.TextView2_s7_subject7);
	TextView2_s7_subject8 = (TextView) findViewById(R.id.TextView2_s7_subject8);
	TextView2_s7_subject9 = (TextView) findViewById(R.id.TextView2_s7_subject9);
	TextView2_s7_subject10 = (TextView) findViewById(R.id.TextView2_s7_subject10);
	
	
	//2222
	EditText_sgpa_s7_mark1=(EditText) findViewById(R.id.EditText_sgpa_s7_mark1);
	EditText_sgpa_s7_mark2=(EditText) findViewById(R.id.EditText_sgpa_s7_mark2);
	EditText_sgpa_s7_mark3=(EditText) findViewById(R.id.EditText_sgpa_s7_mark3);
	EditText_sgpa_s7_mark4=(EditText) findViewById(R.id.EditText_sgpa_s7_mark4);
	EditText_sgpa_s7_mark5=(EditText) findViewById(R.id.EditText_sgpa_s7_mark5);
	EditText_sgpa_s7_mark6=(EditText) findViewById(R.id.EditText_sgpa_s7_mark6);
	EditText_sgpa_s7_mark7=(EditText) findViewById(R.id.EditText_sgpa_s7_mark7);
	EditText_sgpa_s7_mark8=(EditText) findViewById(R.id.EditText_sgpa_s7_mark8);
	EditText_sgpa_s7_mark9=(EditText) findViewById(R.id.EditText_sgpa_s7_mark9);
	EditText_sgpa_s7_mark10=(EditText) findViewById(R.id.EditText_sgpa_s7_mark10);

	
	TextView_s7_cgpa =(TextView) findViewById(R.id.TextView_s7_cgpa);
	TextView_s7_percentage = (TextView) findViewById(R.id.TextView_s7_percent);
	TextView_s7_totmark = (TextView) findViewById(R.id.TextView_s7_totmark);
	TextView_s7_cg = (TextView) findViewById(R.id.TextView_s7_cg);
	
	
	
	

	 TextView2_s7_credit1= (TextView) findViewById(R.id.TextView2_s7_credit1);
	 TextView2_s7_credit2= (TextView) findViewById(R.id.TextView2_s7_credit2);
	 TextView2_s7_credit3= (TextView) findViewById(R.id.TextView2_s7_credit3);
	 TextView2_s7_credit4= (TextView) findViewById(R.id.TextView2_s7_credit4);
	 TextView2_s7_credit5= (TextView) findViewById(R.id.TextView2_s7_credit5);
	 TextView2_s7_credit6= (TextView) findViewById(R.id.TextView2_s7_credit6);
	 TextView2_s7_credit7= (TextView) findViewById(R.id.TextView2_s7_credit7);
	 TextView2_s7_credit8 = (TextView) findViewById(R.id.TextView2_s7_credit8);
	 TextView2_s7_credit9 = (TextView) findViewById(R.id.TextView2_s7_credit9);
	 TextView2_s7_credit10 = (TextView) findViewById(R.id.TextView2_s7_credit10);
	 
TextView2_s7_credit = (TextView) findViewById(R.id.TextView2_s7_credit);
TextView2_s7_subject= (TextView) findViewById(R.id.TextView2_s7_subject);
TextView2_s7_mark= (TextView) findViewById(R.id.TextView2_s7_mark);
	
String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
if(bg_colour_main121.equalsIgnoreCase("gg_white")){
	 
		TextView2_s7_subject1.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject2.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject3.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject4.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject5.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject6.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject7.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject8.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject9.setTextColor(getResources().getColor(R.color.white));
		TextView2_s7_subject10.setTextColor(getResources().getColor(R.color.white));
		
		
		//2222
		EditText_sgpa_s7_mark1.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark2.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark3.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark4.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark5.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark6.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark7.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark8.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark9.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s7_mark10.setTextColor(getResources().getColor(R.color.white));

		
		TextView_s7_cgpa.setTextColor(getResources().getColor(R.color.white));
		TextView_s7_percentage.setTextColor(getResources().getColor(R.color.white));
		TextView_s7_totmark.setTextColor(getResources().getColor(R.color.white));
		TextView_s7_cg.setTextColor(getResources().getColor(R.color.white));
		
		 TextView2_s7_credit1.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit2.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit3.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit4.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit5.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit6.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit7.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit8.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit9.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s7_credit10.setTextColor(getResources().getColor(R.color.white));
		 
	 TextView2_s7_credit.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s7_subject.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s7_mark.setTextColor(getResources().getColor(R.color.white));
}else if(bg_colour_main121.equalsIgnoreCase("gg_blke")){

		TextView2_s7_subject1.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject2.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject3.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject4.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject5.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject6.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject7.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject8.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject9.setTextColor(getResources().getColor(R.color.black));
		TextView2_s7_subject10.setTextColor(getResources().getColor(R.color.black));
		
		
		//2222
		EditText_sgpa_s7_mark1.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark2.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark3.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark4.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark5.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark6.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark7.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark8.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark9.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s7_mark10.setTextColor(getResources().getColor(R.color.black));

		
		TextView_s7_cgpa.setTextColor(getResources().getColor(R.color.black));
		TextView_s7_percentage.setTextColor(getResources().getColor(R.color.black));
		TextView_s7_totmark.setTextColor(getResources().getColor(R.color.black));
		TextView_s7_cg.setTextColor(getResources().getColor(R.color.black));
		
		 TextView2_s7_credit1.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit2.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit3.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit4.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit5.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit6.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit7.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit8.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit9.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s7_credit10.setTextColor(getResources().getColor(R.color.black));
		 
	 TextView2_s7_credit.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s7_subject.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s7_mark.setTextColor(getResources().getColor(R.color.black));
}


	button1_s7_submit = (Button) findViewById(R.id.button1_s7_submit111);

	LinearLayout_sgpa_s7_result = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_s7_result);
	
	
	if(ss_array[0].equalsIgnoreCase("CS")){ //uu
		TextView2_s7_subject1.setText("W T");
		TextView2_s7_subject2.setText("C C");
		TextView2_s7_subject3.setText("C G");
		TextView2_s7_subject4.setText("OOMD");
		TextView2_s7_subject5.setText("PPL");
		TextView2_s7_subject6.setText("Elective-II");
		TextView2_s7_subject7.setText("SP LAB");
		TextView2_s7_subject8.setText("NP LAB");
		TextView2_s7_subject9.setText("Semi.");
		TextView2_s7_subject10.setText("Proj.");
	}else if(ss_array[0].equalsIgnoreCase("CIVIL")){//uu
		TextView2_s7_subject1.setText("DHS");
		TextView2_s7_subject2.setText("EE-I");
		TextView2_s7_subject3.setText("DCS-II");
		TextView2_s7_subject4.setText("ATP");
		TextView2_s7_subject5.setText("TE-II");
		TextView2_s7_subject6.setText("Elective-II");
		TextView2_s7_subject7.setText("CA LAB");
		TextView2_s7_subject8.setText("TE LAB");
		TextView2_s7_subject9.setText("Semi.");
		TextView2_s7_subject10.setText("Proj.");
	}else if(ss_array[0].equalsIgnoreCase("IT")){//uu
		TextView2_s7_subject1.setText("F M");
		TextView2_s7_subject2.setText("OOMD");
		TextView2_s7_subject3.setText("CG");
		TextView2_s7_subject4.setText("IN");
		TextView2_s7_subject5.setText("WAD");
		TextView2_s7_subject6.setText("Elective-II");
		TextView2_s7_subject7.setText("IW LAB");
		TextView2_s7_subject8.setText("CASE LAB");
		TextView2_s7_subject9.setText("Semi.");
		TextView2_s7_subject10.setText("Proj.");
	}else if(ss_array[0].equalsIgnoreCase("EC")){//uu
		TextView2_s7_subject1.setText("VLSI");
		TextView2_s7_subject2.setText("ITC");
		TextView2_s7_subject3.setText("M E");
		TextView2_s7_subject4.setText("E I");
		TextView2_s7_subject5.setText("E S");
		TextView2_s7_subject6.setText("Elective-II");
		TextView2_s7_subject7.setText("AC LAB");
		TextView2_s7_subject8.setText("VLSI LAB");
		TextView2_s7_subject9.setText("Semi.");
		TextView2_s7_subject10.setText("Proj.");
	}else if(ss_array[0].equalsIgnoreCase("EEE")){//uuu
		TextView2_s7_subject1.setText("EPT");
		TextView2_s7_subject2.setText("S M");
		TextView2_s7_subject3.setText("D C");
		TextView2_s7_subject4.setText("MCT");
		TextView2_s7_subject5.setText("C E");
		TextView2_s7_subject6.setText("Elective-II");
		TextView2_s7_subject7.setText("E CAD");
		TextView2_s7_subject8.setText("EM LAB-II");
		TextView2_s7_subject9.setText("Semi.");
		TextView2_s7_subject10.setText("Proj.");
	}else if(ss_array[0].equalsIgnoreCase("MECH")){//uu
		TextView2_s7_subject1.setText("DME");
		TextView2_s7_subject2.setText("D M");
		TextView2_s7_subject3.setText("GD&J");
		TextView2_s7_subject4.setText("R&AC");
		TextView2_s7_subject5.setText("I E");
		TextView2_s7_subject6.setText("Elective-II");
		TextView2_s7_subject7.setText("MM LAB");
		TextView2_s7_subject8.setText("ACT LAB");
		TextView2_s7_subject9.setText("Semi.");
		TextView2_s7_subject10.setText("Proj.");
	}
	
	
	//333
	LinearLayout_sgpa_s7_result.setVisibility(View.GONE);
	button1_s7_submit.setOnClickListener(new OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			overflow_flag=false;
			float[] marks_grade = new float[10];
			int[] marks_o_credit = {4,4,3,3,3,4,2,2,2,1};
				
		
            int seminar,project;
    
            
			try{        seminar=Integer.parseInt(EditText_sgpa_s7_mark9.getText().toString());
            project=Integer.parseInt(EditText_sgpa_s7_mark10.getText().toString());
			int[] marks = { Integer.parseInt(EditText_sgpa_s7_mark1.getText().toString()),  Integer.parseInt(EditText_sgpa_s7_mark2.getText().toString()),  Integer.parseInt(EditText_sgpa_s7_mark3.getText().toString()),  Integer.parseInt(EditText_sgpa_s7_mark4.getText().toString()),  Integer.parseInt(EditText_sgpa_s7_mark5.getText().toString()),
					 Integer.parseInt(EditText_sgpa_s7_mark6.getText().toString()), Integer.parseInt(EditText_sgpa_s7_mark7.getText().toString()), Integer.parseInt(EditText_sgpa_s7_mark8.getText().toString()),(seminar*3),(project*3)};
				

				
				for(int i=0;i<=9;i++){
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
				
				if(LinearLayout_sgpa_s7_result.isShown()){LinearLayout_sgpa_s7_result.setVisibility(View.GONE);}
				int apiLevel = 0;
				try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception exc){}
				
				
				if(apiLevel<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s7.this).create();
					alertbox.setTitle("Attention !");
					alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all fields filled"+"\n"+"* Seminar and project are out of 50");
			
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
					  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s7.this);
					  addd.setTitle("Attention !");
					  addd.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all fields filled"+"\n"+"* Seminar and project are out of 50");

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
			  
					   for(int i=0;i<=9;i++){
						
						   if((i==8||i==9)){
							     if(i==8) total_marks=total_marks+seminar;
							     if(i==9) total_marks=total_marks+project;
						   }else{
							   total_marks=total_marks+marks[i];
						   }
						cgpa=cgpa+(marks_o_credit[i]*marks_grade[i]);
					   }
					  cgpa1=cgpa/28;
					   percentage=((float) total_marks/1300)*100;
					   
						LinearLayout_sgpa_s7_result.setVisibility(View.VISIBLE);
						DecimalFormat df = new DecimalFormat();
						df.setMaximumFractionDigits(2);
		
						 TextView_s7_cg.setText("TOT CG="+df.format(cgpa));
					   TextView_s7_cgpa.setText("SGPA="+df.format(cgpa1));
					   TextView_s7_percentage.setText(df.format(percentage)+"%");
					   TextView_s7_totmark.setText("TOT MARK="+Integer.toString(total_marks));
			}
				
				}catch(Exception exc){//Toast.makeText(getBaseContext(), exc.toString(), Toast.LENGTH_LONG).show();
			int apiLevel = 0;
			
			if(LinearLayout_sgpa_s7_result.isShown()){LinearLayout_sgpa_s7_result.setVisibility(View.GONE);}
			try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception excn){}
			
			
			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s7.this).create();
				alertbox.setTitle("Attention !");
				alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all fields filled"+"\n"+"* Seminar and project are out of 50");
		
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s7.this);
				  addd.setTitle("Attention !");
				  addd.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all fields filled"+"\n"+"* Seminar and project are out of 50");

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
	
	tv_semester7_name.setText(ss_array[0]+" Semester 7");
	
	//1.3
	
	button_sgpa_s7_save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		   editor.putFloat("s7TOT CG",cgpa);
		   editor.putFloat("s7SGPA",cgpa1);
		   editor.putFloat("s7%",percentage);
		   editor.putInt("s7TOT MARK", total_marks);
		   
            editor.commit();
            
            
int apiLevel = Build.VERSION.SDK_INT;
			

			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s7.this).create();
				alertbox.setTitle("Saved !");
				alertbox.setMessage("* SGPA saved for calculating CGPA");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s7.this);
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
	
	}}

