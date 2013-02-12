package androidbangladesh.bengali.support;


import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class BengaliUnicodeString {

	static Typeface tf;

	public static void getBengaliUTF(Context ctx, String text, View v){

		if(text.equals(null)){
			text = "";
		}
		GSUB.text = text.toCharArray();
		GSUB.newlength = text.length();
		//		int i;
		//		for(i=0;i<text.length();i++){
		//			if(text.charAt(i) == '\n'){
		//				
		//				Log.d("NEWLINE","Line: "+text.charAt(i-1));
		//			}
		//		}
		//		text.charAt(i-1);
		//		int newlength=count;
		int ll = 0,ret=2;
		//		__android_log_print(ANDROID_LOG_VERBOSE, "REORDER"), "%s",reorder);
		while ((ret=GSUB.mygsub(GSUB.newlength))==2 &&
				ll < 10) {
		}
		text = new String(GSUB.text,0,GSUB.newlength);
		text = new String(Shape.reorder(text.toCharArray()));
		try{

			tf = Typeface.createFromAsset(ctx.getAssets(), "solaimanlipinormal.ttf");
			
			if(v instanceof TextView){
				TextView tv = (TextView)v;
				tv.setTypeface(tf);
				tv.setText(text);
			}
			if(v instanceof Button){
				Button bv = (Button)v;
				bv.setTypeface(tf);
				bv.setText(text);
			}
			if(v instanceof CheckBox){
				CheckBox cv = (CheckBox)v;
				cv.setTypeface(tf);
				cv.setText(text);
			}
			if(v instanceof RadioButton){
				RadioButton rv = (RadioButton)v;
				rv.setTypeface(tf);
				rv.setText(text);
			}
			
		}catch(Exception e){

		}
	}

}
