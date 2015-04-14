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

public class Sgpa_act_s8 extends Activity{
	String ss;
	TextView tv_semester8_name;
	TextView TextView2_s8_subject1, TextView2_s8_subject2, TextView2_s8_subject3, TextView2_s8_subject4, TextView2_s8_subject5, TextView2_s8_subject6,TextView2_s8_subject7,TextView2_s8_subject8 ;
	TextView	 TextView2_s8_credit1, TextView2_s8_credit2, TextView2_s8_credit3, TextView2_s8_credit4, TextView2_s8_credit5, TextView2_s8_credit6,TextView2_s8_credit7,TextView2_s8_credit8 ;
    TextView TextView2_s8_credit, TextView2_s8_subject, TextView2_s8_mark;
	
	///1.1
	SharedPreferences save_deatails ;
	int total_marks=0;
	float cgpa = 0; float cgpa1;
	float percentage;
	Button button_sgpa_s8_save;
	
	///11111
	TextView TextView_s8_cgpa,TextView_s8_percentage,TextView_s8_totmark,TextView_s8_cg;
	EditText EditText_sgpa_s8_mark1, EditText_sgpa_s8_mark2, EditText_sgpa_s8_mark3, EditText_sgpa_s8_mark4,
                	EditText_sgpa_s8_mark5, EditText_sgpa_s8_mark6, EditText_sgpa_s8_mark7, EditText_sgpa_s8_mark8;
	Button button1_s8_submit;
	LinearLayout LinearLayout_sgpa_s8_result;
	boolean overflow_flag=false;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.sgpa_front_s8); 
	
	

	RelativeLayout Relativelayout_bg = (RelativeLayout) findViewById(R.id.Relativelayout_bg_s8);
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
	button_sgpa_s8_save = (Button) findViewById(R.id.button_sgpa_s8_save);
	
	
	tv_semester8_name = (TextView) findViewById(R.id.textView8_semester6_name);
	tv_semester8_name.setText(ss_array[0]+" Semester 8");
	
	TextView2_s8_subject1 = (TextView) findViewById(R.id.TextView2_s8_subject1);
	TextView2_s8_subject2 = (TextView) findViewById(R.id.TextView2_s8_subject2);
	TextView2_s8_subject3 = (TextView) findViewById(R.id.TextView2_s8_subject3);
	TextView2_s8_subject4 = (TextView) findViewById(R.id.TextView2_s8_subject4);
	TextView2_s8_subject5 = (TextView) findViewById(R.id.TextView2_s8_subject5);
	TextView2_s8_subject6 = (TextView) findViewById(R.id.TextView2_s8_subject6);
	TextView2_s8_subject7 = (TextView) findViewById(R.id.TextView2_s8_subject7);
	TextView2_s8_subject8 = (TextView) findViewById(R.id.TextView2_s8_subject8);

	//2222
	EditText_sgpa_s8_mark1=(EditText) findViewById(R.id.EditText_sgpa_s8_mark1);
	EditText_sgpa_s8_mark2=(EditText) findViewById(R.id.EditText_sgpa_s8_mark2);
	EditText_sgpa_s8_mark3=(EditText) findViewById(R.id.EditText_sgpa_s8_mark3);
	EditText_sgpa_s8_mark4=(EditText) findViewById(R.id.EditText_sgpa_s8_mark4);
	EditText_sgpa_s8_mark5=(EditText) findViewById(R.id.EditText_sgpa_s8_mark5);
	EditText_sgpa_s8_mark6=(EditText) findViewById(R.id.EditText_sgpa_s8_mark6);
	EditText_sgpa_s8_mark7=(EditText) findViewById(R.id.EditText_sgpa_s8_mark7);
	EditText_sgpa_s8_mark8=(EditText) findViewById(R.id.EditText_sgpa_s8_mark8);

	
	TextView_s8_cgpa =(TextView) findViewById(R.id.TextView_s8_cgpa);
	TextView_s8_percentage = (TextView) findViewById(R.id.TextView_s8_percent);
	TextView_s8_totmark = (TextView) findViewById(R.id.TextView_s8_totmark);
	TextView_s8_cg = (TextView) findViewById(R.id.TextView_s8_cg);
	
	
	

	 TextView2_s8_credit1= (TextView) findViewById(R.id.TextView2_s8_credit1);
	 TextView2_s8_credit2= (TextView) findViewById(R.id.TextView2_s8_credit2);
	 TextView2_s8_credit3= (TextView) findViewById(R.id.TextView2_s8_credit3);
	 TextView2_s8_credit4= (TextView) findViewById(R.id.TextView2_s8_credit4);
	 TextView2_s8_credit5= (TextView) findViewById(R.id.TextView2_s8_credit5);
	 TextView2_s8_credit6= (TextView) findViewById(R.id.TextView2_s8_credit6);
	 TextView2_s8_credit7= (TextView) findViewById(R.id.TextView2_s8_credit7);
	 TextView2_s8_credit8 = (TextView) findViewById(R.id.TextView2_s8_credit8);
	 
TextView2_s8_credit = (TextView) findViewById(R.id.TextView2_s8_credit);
TextView2_s8_subject= (TextView) findViewById(R.id.TextView2_s8_subject);
TextView2_s8_mark= (TextView) findViewById(R.id.TextView2_s8_mark);
	
String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
if(bg_colour_main121.equalsIgnoreCase("gg_white")){
	 
		TextView2_s8_subject1.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject2.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject3.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject4.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject5.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject6.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject7.setTextColor(getResources().getColor(R.color.white));
		TextView2_s8_subject8.setTextColor(getResources().getColor(R.color.white));
		
		
		//2222
		EditText_sgpa_s8_mark1.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark2.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark3.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark4.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark5.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark6.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark7.setTextColor(getResources().getColor(R.color.white));
		EditText_sgpa_s8_mark8.setTextColor(getResources().getColor(R.color.white));

		
		TextView_s8_cgpa.setTextColor(getResources().getColor(R.color.white));
		TextView_s8_percentage.setTextColor(getResources().getColor(R.color.white));
		TextView_s8_totmark.setTextColor(getResources().getColor(R.color.white));
		TextView_s8_cg.setTextColor(getResources().getColor(R.color.white));
		
		 TextView2_s8_credit1.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit2.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit3.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit4.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit5.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit6.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit7.setTextColor(getResources().getColor(R.color.white));
		 TextView2_s8_credit8.setTextColor(getResources().getColor(R.color.white));
		 
	 TextView2_s8_credit.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s8_subject.setTextColor(getResources().getColor(R.color.white));
	 TextView2_s8_mark.setTextColor(getResources().getColor(R.color.white));
}else if(bg_colour_main121.equalsIgnoreCase("gg_blke")){

		TextView2_s8_subject1.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject2.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject3.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject4.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject5.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject6.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject7.setTextColor(getResources().getColor(R.color.black));
		TextView2_s8_subject8.setTextColor(getResources().getColor(R.color.black));
		
		
		//2222
		EditText_sgpa_s8_mark1.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark2.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark3.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark4.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark5.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark6.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark7.setTextColor(getResources().getColor(R.color.black));
		EditText_sgpa_s8_mark8.setTextColor(getResources().getColor(R.color.black));

		
		TextView_s8_cgpa.setTextColor(getResources().getColor(R.color.black));
		TextView_s8_percentage.setTextColor(getResources().getColor(R.color.black));
		TextView_s8_totmark.setTextColor(getResources().getColor(R.color.black));
		TextView_s8_cg.setTextColor(getResources().getColor(R.color.black));
		
		 TextView2_s8_credit1.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit2.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit3.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit4.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit5.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit6.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit7.setTextColor(getResources().getColor(R.color.black));
		 TextView2_s8_credit8.setTextColor(getResources().getColor(R.color.black));
		 
	 TextView2_s8_credit.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s8_subject.setTextColor(getResources().getColor(R.color.black));
	 TextView2_s8_mark.setTextColor(getResources().getColor(R.color.black));
}
	
	button1_s8_submit = (Button) findViewById(R.id.button1_s8_submit111);

	LinearLayout_sgpa_s8_result = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_s8_result);
	
	
	
	if(ss_array[0].equalsIgnoreCase("CS")){ //uuu
		TextView2_s8_subject1.setText("HPC");
		TextView2_s8_subject2.setText("A I");
		TextView2_s8_subject3.setText("S C");
		TextView2_s8_subject4.setText("Elective-III");
		TextView2_s8_subject5.setText("Elective-IV");
		TextView2_s8_subject6.setText("CG LAB");
		TextView2_s8_subject7.setText("Proj.");
		TextView2_s8_subject8.setText("Viva Voce");
	}else if(ss_array[0].equalsIgnoreCase("CIVIL")){//uu
		TextView2_s8_subject1.setText("ASD");
		TextView2_s8_subject2.setText("BT&M");
		TextView2_s8_subject3.setText("EE-II");
		TextView2_s8_subject4.setText("Elective-III");
		TextView2_s8_subject5.setText("Elective-IV");
		TextView2_s8_subject6.setText("EE LAB");
		TextView2_s8_subject7.setText("Proj.");
		TextView2_s8_subject8.setText("Viva Voce");
	}else if(ss_array[0].equalsIgnoreCase("IT")){//uu
		TextView2_s8_subject1.setText("W C");
		TextView2_s8_subject2.setText("CNS");
		TextView2_s8_subject3.setText("A I");
		TextView2_s8_subject4.setText("Elective-III");
		TextView2_s8_subject5.setText("Elective-IV");
		TextView2_s8_subject6.setText("WA LAB");
		TextView2_s8_subject7.setText("Proj.");
		TextView2_s8_subject8.setText("Viva Voce");
	}else if(ss_array[0].equalsIgnoreCase("EC")){//uuu
		TextView2_s8_subject1.setText("W C");
		TextView2_s8_subject2.setText("C N");
		TextView2_s8_subject3.setText("LWC");
		TextView2_s8_subject4.setText("Elective-III");
		TextView2_s8_subject5.setText("Elective-IV");
		TextView2_s8_subject6.setText("SS LAB");
		TextView2_s8_subject7.setText("Proj.");
		TextView2_s8_subject8.setText("Viva Voce");
	}else if(ss_array[0].equalsIgnoreCase("EEE")){//uuu
		TextView2_s8_subject1.setText("PSA");
		TextView2_s8_subject2.setText("SGP");
		TextView2_s8_subject3.setText("ESD");
		TextView2_s8_subject4.setText("Elective-III");
		TextView2_s8_subject5.setText("Elective-IV");
		TextView2_s8_subject6.setText("CS LAB");
		TextView2_s8_subject7.setText("Proj.");  /////////////////////////////////////////// !!!!! ATTENTION !!

		 TextView2_s8_subject8.setText("Viva Voce");
	}else if(ss_array[0].equalsIgnoreCase("MECH")){//uuu
		TextView2_s8_subject1.setText("DTE");
		TextView2_s8_subject2.setText("O M");
		TextView2_s8_subject3.setText("P E");
		TextView2_s8_subject4.setText("Elective-III");
		TextView2_s8_subject5.setText("Elective-IV");
		TextView2_s8_subject6.setText("MS LAB");
		TextView2_s8_subject7.setText("Proj.");
		TextView2_s8_subject8.setText("Viva Voce");
	}
	//333
		LinearLayout_sgpa_s8_result.setVisibility(View.GONE);
		
		
		button1_s8_submit.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				overflow_flag=false;
				float[] marks_grade = new float[8];
				int[] marks_o_credit = {4,4,4,4,4,2,4,2};
					
	
				try{
				int[] marks = { Integer.parseInt(EditText_sgpa_s8_mark1.getText().toString()),  Integer.parseInt(EditText_sgpa_s8_mark2.getText().toString()),  Integer.parseInt(EditText_sgpa_s8_mark3.getText().toString()),  Integer.parseInt(EditText_sgpa_s8_mark4.getText().toString()),  Integer.parseInt(EditText_sgpa_s8_mark5.getText().toString()),
						 Integer.parseInt(EditText_sgpa_s8_mark6.getText().toString()), Integer.parseInt(EditText_sgpa_s8_mark7.getText().toString()), Integer.parseInt(EditText_sgpa_s8_mark8.getText().toString())};
					
				float rrm = marks[6];
					float rr=(rrm/100);
					rr= rr*150;
				int	marks_6=(int) rr;
					int		marks_7=marks[7]*3;
							
					for(int i=0;i<=7;i++){
					if(i==6){
						if((marks_6<=150)&&(marks_6>=136)){
							marks_grade[i]=10;
						}else if((marks_6<=135)&&(marks_6>=121)){
							marks_grade[i]=9;
						}else if((marks_6<=120)&&(marks_6>=106)){
							marks_grade[i]=8;
						}else if((marks_6<=105)&&(marks_6>=91)){
							marks_grade[i]=7;
						}else if((marks_6<=90)&&(marks_6>=83)){
							marks_grade[i]=6;
						}else if((marks_6<=82)&&(marks_6>=75)){
							marks_grade[i]=(float) 5.5;
						}else if((marks_6<=74)&&(marks_6>=0)){
							marks_grade[i]=(float) 0;
						}else{
							overflow_flag=true;
						}
					}else if(i==7){
						if((marks_7<=150)&&(marks_7>=136)){
							marks_grade[i]=10;
						}else if((marks_7<=135)&&(marks_7>=121)){
							marks_grade[i]=9;
						}else if((marks_7<=120)&&(marks_7>=106)){
							marks_grade[i]=8;
						}else if((marks_7<=105)&&(marks_7>=91)){
							marks_grade[i]=7;
						}else if((marks_7<=90)&&(marks_7>=83)){
							marks_grade[i]=6;
						}else if((marks_7<=82)&&(marks_7>=75)){
							marks_grade[i]=(float) 5.5;
						}else if((marks_7<=74)&&(marks_7>=0)){
							marks_grade[i]=(float) 0;
						}else{
							overflow_flag=true;
						}
					}else{
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
						
						
					}
					
				if(overflow_flag){
					
					if(LinearLayout_sgpa_s8_result.isShown()){LinearLayout_sgpa_s8_result.setVisibility(View.GONE);}
					int apiLevel = 0;
					try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception exc){}
					
					if(apiLevel<11){
						AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s8.this).create();
						alertbox.setTitle("Attention !");
						alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Project out of 100"+"\n"+"* Viva Voce out of 50"+"\n"+"* Make sure that all field filled");
						alertbox.setButton("OK", new DialogInterface.OnClickListener() {
							            public void onClick(DialogInterface dialog, int which) {
								            // TODO Auto-generated method stub
							                                                       }
						                                   });
						alertbox.show();
					}else{
						  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s8.this);
						  addd.setTitle("Attention !");
							addd.setMessage("* The marks range should be 0~150"+"\n"+"* Project out of 100"+"\n"+"* Viva Voce out of 50"+"\n"+"* Make sure that all field filled");
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
						  percentage=((float) total_marks/1050)*100;
							LinearLayout_sgpa_s8_result.setVisibility(View.VISIBLE);
							DecimalFormat df = new DecimalFormat();
							df.setMaximumFractionDigits(2);
			
							 TextView_s8_cg.setText("TOT CG="+df.format(cgpa));
						   TextView_s8_cgpa.setText("SGPA="+df.format(cgpa1));
						   TextView_s8_percentage.setText(df.format(percentage)+"%");
						   TextView_s8_totmark.setText("TOT MARK="+Integer.toString(total_marks));
				}
					
					}catch(Exception exc){//Toast.makeText(getBaseContext(), exc.toString(), Toast.LENGTH_LONG).show();
				int apiLevel = 0;
				
				if(LinearLayout_sgpa_s8_result.isShown()){LinearLayout_sgpa_s8_result.setVisibility(View.GONE);}
				try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception excn){}
				
				if(apiLevel<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s8.this).create();
					alertbox.setTitle("Attention !");
					alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
					  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s8.this);
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
		
		//1.3
		
		button_sgpa_s8_save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			   editor.putFloat("s8TOT CG",cgpa);
			   editor.putFloat("s8SGPA",cgpa1);
			   editor.putFloat("s8%",percentage);
			   editor.putInt("s8TOT MARK", total_marks);
			   
	            editor.commit();
	            
	            
	int apiLevel = Build.VERSION.SDK_INT;
				

				if(apiLevel<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s8.this).create();
					alertbox.setTitle("Saved !");
					alertbox.setMessage("* SGPA saved for calculating CGPA");
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
					  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s8.this);
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
