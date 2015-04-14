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
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Sgpa_act_s12 extends Activity{
	///1.1
	SharedPreferences save_deatails ;
	int total_marks=0;
	float cgpa = 0; float cgpa1;
	float percentage;
	Button button_sgpa_s12_save;
	
	boolean overflow_flag=false;
	String ss;
	TextView tv_semester12_name, 
                           	textView_c_s12_sub, textView_c_s12_cre, textView_c_s12_mark,
	                      TextView_s12_cgpa,TextView_s12_percentage,TextView_s12_totmark,TextView_s12_cg,
	                     textView_c_s12_cre1, textView_c_s12_cre2, textView_c_s12_cre3 , textView_c_s12_cre4, textView_c_s12_cre5,
	                     textView_c_s12_cre6, textView_c_s12_cre7, textView_c_s12_cre8, textView_c_s12_cre9, textView_c_s12_cre10,
	                     textView_c_s12_cre11,
	                     textView_c_s12_sub1, textView_c_s12_sub2, textView_c_s12_sub3, textView_c_s12_sub4, textView_c_s12_sub5,
	                     textView_c_s12_sub6, textView_c_s12_sub7, textView_c_s12_sub8, textView_c_s12_sub9, textView_c_s12_sub10,
	                     textView_c_s12_sub11;
	EditText EditText_sgpa_s12_mark1, EditText_sgpa_s12_mark2, EditText_sgpa_s12_mark3, EditText_sgpa_s12_mark4,
                	EditText_sgpa_s12_mark5, EditText_sgpa_s12_mark6, EditText_sgpa_s12_mark7, EditText_sgpa_s12_mark8,
                	EditText_sgpa_s12_mark9, EditText_sgpa_s12_mark10, EditText_sgpa_s12_mark11;
	Button button1_s12_submit;
	LinearLayout LinearLayout_sgpa_s12_result;

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.sgpa_front_s12); 
	
	RelativeLayout Relativelayout_bg = (RelativeLayout) findViewById(R.id.Relativelayout_bg);
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
	button_sgpa_s12_save = (Button) findViewById(R.id.Button_sgpa_s12_save);
	
	
	tv_semester12_name = (TextView) findViewById(R.id.textView6_semester12_name);
	
	EditText_sgpa_s12_mark1=(EditText) findViewById(R.id.EditText_sgpa_s12_mark1);
	EditText_sgpa_s12_mark2=(EditText) findViewById(R.id.EditText_sgpa_s12_mark2);
	EditText_sgpa_s12_mark3=(EditText) findViewById(R.id.EditText_sgpa_s12_mark3);
	EditText_sgpa_s12_mark4=(EditText) findViewById(R.id.EditText_sgpa_s12_mark4);
	EditText_sgpa_s12_mark5=(EditText) findViewById(R.id.EditText_sgpa_s12_mark5);
	EditText_sgpa_s12_mark6=(EditText) findViewById(R.id.EditText_sgpa_s12_mark6);
	EditText_sgpa_s12_mark7=(EditText) findViewById(R.id.EditText_sgpa_s12_mark7);
	EditText_sgpa_s12_mark8=(EditText) findViewById(R.id.EditText_sgpa_s12_mark8);
	EditText_sgpa_s12_mark9=(EditText) findViewById(R.id.EditText_sgpa_s12_mark9);
	EditText_sgpa_s12_mark10=(EditText) findViewById(R.id.EditText_sgpa_s12_mark10);
	EditText_sgpa_s12_mark11=(EditText) findViewById(R.id.EditText_sgpa_s12_mark11);
	
	TextView_s12_cgpa =(TextView) findViewById(R.id.TextView_s12_cgpa);
	TextView_s12_percentage = (TextView) findViewById(R.id.TextView_s12_percent);
	TextView_s12_totmark = (TextView) findViewById(R.id.TextView_s12_totmark);
	TextView_s12_cg = (TextView) findViewById(R.id.TextView_s12_cg);
	
	
	textView_c_s12_sub=(TextView) findViewById(R.id.textView_c_s12_sub);
	textView_c_s12_cre=(TextView) findViewById(R.id.textView_c_s12_cre);
	textView_c_s12_mark=(TextView) findViewById(R.id.textView_c_s12_mark);
	textView_c_s12_cre1=(TextView) findViewById(R.id.textView_c_s12_cre1);
	textView_c_s12_cre2=(TextView) findViewById(R.id.textView_c_s12_cre2);
	textView_c_s12_cre3=(TextView) findViewById(R.id.textView_c_s12_cre3);
	textView_c_s12_cre4=(TextView) findViewById(R.id.textView_c_s12_cre4);
	textView_c_s12_cre5=(TextView) findViewById(R.id.textView_c_s12_cre5);
	textView_c_s12_cre6=(TextView) findViewById(R.id.textView_c_s12_cre6);
	textView_c_s12_cre7=(TextView) findViewById(R.id.textView_c_s12_cre7);
	textView_c_s12_cre8=(TextView) findViewById(R.id.textView_c_s12_cre8);
	textView_c_s12_cre9=(TextView) findViewById(R.id.textView_c_s12_cre9);
	textView_c_s12_cre10=(TextView) findViewById(R.id.textView_c_s12_cre10);
	textView_c_s12_cre11=(TextView) findViewById(R.id.textView_c_s12_cre11);
	
	textView_c_s12_sub1=(TextView) findViewById(R.id.textView_c_s12_sub1);
	textView_c_s12_sub2=(TextView) findViewById(R.id.textView_c_s12_sub2);
	textView_c_s12_sub3=(TextView) findViewById(R.id.textView_c_s12_sub3);
	textView_c_s12_sub4=(TextView) findViewById(R.id.textView_c_s12_sub4);
	textView_c_s12_sub5=(TextView) findViewById(R.id.textView_c_s12_sub5);
	textView_c_s12_sub6=(TextView) findViewById(R.id.textView_c_s12_sub6);
	textView_c_s12_sub7=(TextView) findViewById(R.id.textView_c_s12_sub7);
	textView_c_s12_sub8=(TextView) findViewById(R.id.textView_c_s12_sub8);
	textView_c_s12_sub9=(TextView) findViewById(R.id.textView_c_s12_sub9);
	textView_c_s12_sub10=(TextView) findViewById(R.id.textView_c_s12_sub10);
	textView_c_s12_sub11=(TextView) findViewById(R.id.textView_c_s12_sub11);
	
	
	
	
	
	
	
	 String bg_colour_main121 = setting.getString("set_text_colour", "gg_blke");          
	 if(bg_colour_main121.equalsIgnoreCase("gg_white")){
			EditText_sgpa_s12_mark1.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark2.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark3.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark4.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark5.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark6.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark7.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark8.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark9.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark10.setTextColor(getResources().getColor(R.color.white));
			EditText_sgpa_s12_mark11.setTextColor(getResources().getColor(R.color.white));
			
			TextView_s12_cgpa.setTextColor(getResources().getColor(R.color.white));
			TextView_s12_percentage.setTextColor(getResources().getColor(R.color.white));
			TextView_s12_totmark.setTextColor(getResources().getColor(R.color.white));
			TextView_s12_cg.setTextColor(getResources().getColor(R.color.white));
			
			
			textView_c_s12_sub.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_mark.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre1.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre2.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre3.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre4.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre5.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre6.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre7.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre8.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre9.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre10.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_cre11.setTextColor(getResources().getColor(R.color.white));
			
			textView_c_s12_sub1.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub2.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub3.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub4.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub5.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub6.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub7.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub8.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub9.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub10.setTextColor(getResources().getColor(R.color.white));
			textView_c_s12_sub11.setTextColor(getResources().getColor(R.color.white));
			
	 }else  if(bg_colour_main121.equalsIgnoreCase("gg_blke")){

			EditText_sgpa_s12_mark1.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark2.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark3.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark4.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark5.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark6.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark7.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark8.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark9.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark10.setTextColor(getResources().getColor(R.color.black));
			EditText_sgpa_s12_mark11.setTextColor(getResources().getColor(R.color.black));
			
			TextView_s12_cgpa.setTextColor(getResources().getColor(R.color.black));
			TextView_s12_percentage.setTextColor(getResources().getColor(R.color.black));
			TextView_s12_totmark.setTextColor(getResources().getColor(R.color.black));
			TextView_s12_cg.setTextColor(getResources().getColor(R.color.black));
			
			
			textView_c_s12_sub.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_mark.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre1.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre2.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre3.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre4.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre5.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre6.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre7.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre8.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre9.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre10.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_cre11.setTextColor(getResources().getColor(R.color.black));
			
			textView_c_s12_sub1.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub2.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub3.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub4.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub5.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub6.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub7.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub8.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub9.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub10.setTextColor(getResources().getColor(R.color.black));
			textView_c_s12_sub11.setTextColor(getResources().getColor(R.color.black));
			
	 
	 }
	 
	 
	 
	
	button1_s12_submit = (Button) findViewById(R.id.button1_s12_submit111);

	LinearLayout_sgpa_s12_result = (LinearLayout) findViewById(R.id.LinearLayout_sgpa_s12_result);

	
	tv_semester12_name.setText(ss_array[0]+" Semester 1 & 2");
	LinearLayout_sgpa_s12_result.setVisibility(View.GONE);
	
	
	button1_s12_submit.setOnClickListener(new OnClickListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			overflow_flag=false;
			float[] marks_grade = new float[11];
			int[] marks_o_credit = {5,4,4,6,6,4,4,4,5,1,1};
				


			try{
			int[] marks = { Integer.parseInt(EditText_sgpa_s12_mark1.getText().toString()),  Integer.parseInt(EditText_sgpa_s12_mark2.getText().toString()),  Integer.parseInt(EditText_sgpa_s12_mark3.getText().toString()),  Integer.parseInt(EditText_sgpa_s12_mark4.getText().toString()),  Integer.parseInt(EditText_sgpa_s12_mark5.getText().toString()),
					 Integer.parseInt(EditText_sgpa_s12_mark6.getText().toString()), Integer.parseInt(EditText_sgpa_s12_mark7.getText().toString()), Integer.parseInt(EditText_sgpa_s12_mark8.getText().toString()), Integer.parseInt(EditText_sgpa_s12_mark9.getText().toString()),
					 Integer.parseInt(EditText_sgpa_s12_mark10.getText().toString()), Integer.parseInt(EditText_sgpa_s12_mark11.getText().toString())};
				

				
				for(int i=0;i<=10;i++){
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
				
				if(LinearLayout_sgpa_s12_result.isShown()){LinearLayout_sgpa_s12_result.setVisibility(View.GONE);}
				int apiLevel = 0;
				try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception exc){}
	
				if(apiLevel<11){
					AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s12.this).create();
					alertbox.setTitle("Attention !");
					alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
					alertbox.setButton("OK", new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
							            // TODO Auto-generated method stub
						                                                       }
					                                   });
					alertbox.show();
				}else{
					  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s12.this);
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
					
					   for(int i=0;i<=10;i++){
						total_marks=total_marks+marks[i];
						cgpa=cgpa+(marks_o_credit[i]*marks_grade[i]);
					   }
					 cgpa1=cgpa/44;
					 percentage=((float) total_marks/1650)*100;
					   
						LinearLayout_sgpa_s12_result.setVisibility(View.VISIBLE);
						DecimalFormat df = new DecimalFormat();
						df.setMaximumFractionDigits(2);
		
						 TextView_s12_cg.setText("TOT CG="+df.format(cgpa));
					   TextView_s12_cgpa.setText("SGPA="+df.format(cgpa1));
					   TextView_s12_percentage.setText(df.format(percentage)+"%");
					   TextView_s12_totmark.setText("TOT MARK="+Integer.toString(total_marks));
					
					   
					   
					   
			}
				
				}catch(Exception exc){//Toast.makeText(getBaseContext(), exc.toString(), Toast.LENGTH_LONG).show();
			int apiLevel = 0;
			
			if(LinearLayout_sgpa_s12_result.isShown()){LinearLayout_sgpa_s12_result.setVisibility(View.GONE);}
			try{apiLevel=Build.VERSION.SDK_INT;}catch(Exception excn){}
			

			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s12.this).create();
				alertbox.setTitle("Attention !");
				alertbox.setMessage("* The marks range should be 0~150"+"\n"+"* Make sure that all field filled");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s12.this);
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
	
	button_sgpa_s12_save.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		   editor.putFloat("s12TOT CG",cgpa);
		   editor.putFloat("s12SGPA",cgpa1);
		   editor.putFloat("s12%",percentage);
		   editor.putInt("s12TOT MARK", total_marks);
		   
            editor.commit();
            
            
int apiLevel = Build.VERSION.SDK_INT;
			

			if(apiLevel<11){
				AlertDialog alertbox = new AlertDialog.Builder(Sgpa_act_s12.this).create();
				alertbox.setTitle("Saved !");
				alertbox.setMessage("* SGPA saved for calculating CGPA");
				alertbox.setButton("OK", new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
						            // TODO Auto-generated method stub
					                                                       }
				                                   });
				alertbox.show();
			}else{
				  AlertDialog.Builder addd = new AlertDialog.Builder(Sgpa_act_s12.this);
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
