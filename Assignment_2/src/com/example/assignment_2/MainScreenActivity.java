package com.example.assignment_2;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainScreenActivity extends ActionBarActivity {
	Button nextButton; //creating a button
	EditText nameEntry; //creating a text area to put name
	String name; //creating a string "name" so we can enter a name
	
	//message to send to next screen "name"
	public final static String EXTRA_MESSAGE = "com.example.assingment_2.MESSAGE";

	
	//on create method
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		
		nameEntry = (EditText) findViewById(R.id.nameEditText); //sees the name entry
		nextButton = (Button) findViewById(R.id.nextButton); //see the button
		//takes value when button is pressed
		nextButton.setOnClickListener(new View.OnClickListener() {
			
			
//********************************ON CLICK**********************************//			
			//validation for the name entry
			@Override
			public void onClick(View view) { // "View" is for user interface components on our screen			
				name = nameEntry.getText().toString(); //Returning the text the TextView is displaying
				
				//returning text displayed, must have an entry greater than zero
				if (name.length() > 0) {
					nextScreen(view); //go to next screen when name is entered
				} else {
					//showing message for user
					Toast.makeText(getBaseContext(), "Invalid Name.", //return "Invalid"
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}


//******************************NEXT SCREEN*************************************//
	
	public void nextScreen(View view) { // again we implement our 'View" for user interface on the screen 
		
		//Intent is how user changes screens
		//performing late runtime binding between the code in different applications
		//launches the activity
		Intent intent = new Intent(this, ScreenTwoActivity.class);
		
		//Representing the edit field in UI of my application so that I can run it with other classes. 
		EditText edittext = (EditText)findViewById(R.id.nameEditText);
		//gives name to the next screen
		intent.putExtra(EXTRA_MESSAGE, name);
		//launches next screen
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_screen, menu);
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
