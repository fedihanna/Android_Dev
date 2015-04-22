package com.example.mediaplayer;



import java.util.ArrayList;

import com.example.listviewwithimages.CustomList;
import com.example.listviewwithimages.MainActivity;
import com.example.mygallery.ImageAdapter;

import android.R;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.AdapterView.OnItemClickListener;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
//***************IMAGES BUTTONS AND RATING BARS
	 ImageButton The300Btn;
	 ImageButton TransformersBtn;
	 ImageButton KillBillBtn;
	 ImageButton AvengersBtn;
	 VideoView vid;
	 RatingBar rating300;
	 RatingBar ratingTransformers;
	 RatingBar ratingKillBill;
	 RatingBar ratingAvengers;
	 
//***************ARRAYS
	 ArrayList<String> movieId;
	 ArrayList<String> title;
	 ArrayList<String> rating;
	 ArrayList<String> description;
	 ArrayList<String> imageName;
	 ArrayList<String> trailerName;
	
	
//***************ON CREATE
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		The300Btn = (ImageButton)findViewById(R.id.The300Btn);
		TransformersBtn = (ImageButton)findViewById(R.id.TransformersBtn);
		KillBillBtn = (ImageButton)findViewById(R.id.KillBillBtn);
		AvengersBtn = (ImageButton)findViewById(R.id.AvengersBtn);
		VideoView videoview = (VideoView) findViewById(R.id.videoview);
		rating300 = (RatingBar)findViewById(R.id.rating300);
		ratingTransformers = (RatingBar)findViewById(R.id.ratingTransformers);
		ratingKillBill = (RatingBar)findViewById(R.id.ratingKillBill);
		ratingAvengers = (RatingBar)findViewById(R.id.ratingAvengers);
		
		//message to send to next screen "name"
		public final static String EXTRA_MESSAGE = "com.example.mediaplayer.MESSAGE";

//******************************NEXT SCREEN*************************************//
		
		public void nextScreen(View view) { // again we implement our 'View" for user interface on the screen 
			
			//Intent is how user changes screens
			//performing late runtime binding between the code in different applications
			//launches the activity
			Intent intent = new Intent(this, ViewTrailer.class);
			
			//Representing the edit field in UI of my application so that I can run it with other classes. 
			EditText edittext = (EditText)findViewById(R.id.nameEditText);
			//gives name to the next screen
			intent.putExtra(EXTRA_MESSAGE, name);
			//launches next screen
			startActivity(intent);
		}
		
//*************GALLERY
		
		public class MainActivity extends ActionBarActivity {
			
			//images to display
				Integer[] imageIDs = 
					{
						R.drawable.pic1,
						R.drawable.pic2,
						R.drawable.pic3,
						R.drawable.pic4,
						
					};

			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				
				Gallery gallery=(Gallery)findViewById(R.id.gallery1);
				gallery.setAdapter(new ImageAdapter(this));
				
				gallery.setOnItemClickListener(new OnItemClickListener()
				{
					public void onItemClick(AdapterView<?> parent, View v,
							int position,long id)
					{
						Toast.makeText(getBaseContext(), 
								"pic" +(position+1)+"selected",
								Toast.LENGTH_SHORT).show();
						
						ImageView imageView = (ImageView)findViewById(R.id.imageView1);
						imageView.setImageResource(imageIDs[position]);
					
					}//end onItemClick
				});
		
//*************LIST VIEW WITH IMAGES
		public class MainActivity extends Activity {
			  ListView list;
			  String[] web = {
			      "Image 1",
			      "Image 2",
			      "Image 3",
			      "Image 4",
			     
			  } ;
			  Integer[] imageId = {
			      R.drawable.pic1,
			      R.drawable.pic2,
			      R.drawable.pic3,
			      R.drawable.pic4,
			     
			  };
			  @Override
			  protected void onCreate(Bundle savedInstanceState) {
			    super.onCreate(savedInstanceState);
			    setContentView(R.layout.activity_main);
			    CustomList adapter = new
			        CustomList(MainActivity.this, web, imageId);
			    list=(ListView)findViewById(R.id.list);
			        list.setAdapter(adapter);
			        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			                @Override
			                public void onItemClick(AdapterView<?> parent, View view,
			                                        int position, long id) {
			                    Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
			                }
			            });
			  }
			}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

}
