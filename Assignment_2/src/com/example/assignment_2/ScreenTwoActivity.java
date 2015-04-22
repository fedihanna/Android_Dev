package com.example.assignment_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


//****************************SCREEN TWO***********************************//
public class ScreenTwoActivity extends ActionBarActivity {
	String name; //string created for the name we are entering
	int question = 0; //declaring a question as integer so it can have a value
	int score = 0; //declaring a "score" as integer so it can have a value
	List<String> QuizArray; // array list of the quiz
	
	// we are giving a string and receiving a string
	//Map is a data structure consisting of a set of keys and values in which each key is mapped to a single value
	//we have 10 questions which have 10 answers
	Map<String, String> HashMap = new java.util.HashMap<String, String>(10); //10 questions ..10 answers
	RadioButton rb1, rb2, rb3, rb4; // declaring the radio buttons
	TextView questionText; //displaying text "questionText" to the editor
	TextView nameScoreTextView;// declaring a text view that displays name and score
	Button nextButton;//representing the Button from Widget
	RadioGroup rGroup; //"RadioGroup" holds the series of the radio buttons
	
	
//***********************************ON CREATE *********************************//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Intent is the Abstract description of the incoming name
		Intent incomingName = getIntent(); // returning the Intent
		// gets the extended data from the intent
		name = incomingName.getStringExtra(MainScreenActivity.EXTRA_MESSAGE);
		setContentView(R.layout.screen_two);

		//finding the questions and next button on screen 2
		questionText = (TextView) findViewById(R.id.question);//finding the view of the TextView "questionTest" 
		nameScoreTextView  = (TextView) findViewById(R.id.nameScoreTextView);//
		nextButton = (Button) findViewById(R.id.nextquestion);//finding the view of the Button "nextButton" 
		
		// binding to the radio buttons for the radio Group on screen 2
		//the "find by view id" reads them, starting at zero
		rGroup = (RadioGroup)findViewById(R.id.radioGroup1);
		rb1 = (RadioButton) findViewById(R.id.radio0);
		rb2 = (RadioButton) findViewById(R.id.radio1);
		rb3 = (RadioButton) findViewById(R.id.radio2);
		rb4 = (RadioButton) findViewById(R.id.radio3);
		parseTextFile(); //calling on the "parseTextFile" function below
		setScreen(); // calling on the "setScreen" function below 

		//calling back the value from the 'answer radio button' we select when  "Next" button is clicked
		nextButton.setOnClickListener(new View.OnClickListener() { 
			
//****************************************ON CLICK********************//			
			@Override
			public void onClick(View view) {
				
				RadioButton tempRB = (RadioButton)findViewById(rGroup.getCheckedRadioButtonId());
				
				//calling the Hash Map with the current question
				//to see if its equal to the selected Radio buttons text
				//hash map values match, it will display "correct answer" using TOAST.
				//shows the TOAST a short time
				if ((HashMap.get(QuizArray.get(question))).equals((String)tempRB.getText())){
					score++; //adds #1 to the score
					Toast.makeText(getBaseContext(), "Correct Answer.",
							Toast.LENGTH_SHORT).show();
					
					//if the hash map values do not match
					//display "incorrect answer"
				} else {
					Toast.makeText(getBaseContext(), "Incorrect Answer.",
							Toast.LENGTH_SHORT).show();
				}
				question+=2; //+=2 because the array list has a question every second spot
				setScreen(); //displays on screen using SET SCCREEN function
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.screen_two, menu);
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
//*****************SET SCREEN ******************//
	public void setScreen() {
		
		
		//if there is another question
		//display it, or else display the score
		//and disable the "Next" button
		
		if(question<=18){ //in the array there is 19 spots spoken for
						//every 2nd one is a question
						//we want to exit on the 18th spot which is the last question
			
		questionText.setText(QuizArray.get(question));
		ArrayList<String> sQuiz = shuffledQuiz(); //sQuiz is representing the shuffling of the quiz answers
		//the 4 radio buttons being set to the string value of the text view
		//being read out of the string array ....so 0, 1, 2, 3
		//being shuffled each time
		rb1.setText(sQuiz.get(0));
		rb2.setText(sQuiz.get(1));
		rb3.setText(sQuiz.get(2));
		rb4.setText(sQuiz.get(3));
		
		
		}else{
			
			//once the 18 spot is reached ...the quiz is complete
			questionText.setText("Quiz Complete"); //displays "Quiz Complete"
			nextButton.setEnabled(false);//disabled the "Next" button
			}
		
		nameScoreTextView.setText(name+"'s score:" +score+"/10");//displaying my name and my score out of 10
	}
	
//****************PUBLIC ARRAY LIST******************//
	// shuffling the quiz
	// one has to be the answer and 3 have to be random
	// we want answer to be in a different spot each time
	public ArrayList<String> shuffledQuiz() {
		//declaring array list "sQuiz"
		ArrayList<String> sQuiz = new ArrayList<String>(4); //we want 4 answers
		sQuiz.add(QuizArray.get(question + 1));  // we don't want questions appearing in the answers section 
												//so we add +1 to skip it

		//provides methods that return random values. 
		Random random = new Random();
		int[] intArray = new int[3]; //array that will hold 4 spots which will be shuffled
		int randInt; //declaring an int "randInt"
		
		//we are making these because we do not to have answers appear twice
		//we check the 1 and 2 spot in the array
		//0 spot is always the answer
		//3rd spot is always auto generated
		//then all 4 get thrown into a shuffle 
		int ansCheck1 = -1;
		int ansCheck2 = -1;

		for (int i = 0; i < 3; i++) { //putting the randInt in a for loop that shuffles through
			
			do {// do while loop showing the array containing the values being used...0->19 (20 spots)
				randInt = random.nextInt(19);
				
				
				//when randInt is displaying a question or picking every second spot and randInt to grab a question
				//ansCheck1 is checking the 0 spot
				//ansCheck2 is checking the 1 spot
				//the 3rd spot ends the loop
			} while (randInt == question + 1 || randInt % 2 == 0 || randInt == ansCheck1 || randInt == ansCheck2);
			sQuiz.add(QuizArray.get(randInt)); //takes the array list QuizArray..which is using the randInt (Randomizing the 19 spots)
											  // then adds the sQuiz(shuffled Quiz)
			
			//if the i is in the 0 spot
			//then ansCheck1 is randInt..which puts in a random answer
			if (i==0)
			{
				ansCheck1 = randInt;
			}
			//if i is in the 1 spot 
			//then ansCheck2 is randInt...which puts in a random answer
			else if (i == 1)
			{
				ansCheck2 = randInt;
			}
		}
		
		//a long seed is a needed for  randomizing numbers
		long seed = System.nanoTime(); //nanoTime is returning the value of the "long seed"
									//using time stamping to see where the answer was put 
									//so it will not put it in the same location
		
		//Moves every element of the list to a random new position 
		Collections.shuffle(sQuiz, new Random(seed));
		return sQuiz;
	}

	//********************PARSE TEXT FILE which puts it into an array list**************
	
	//we need to make the textfile readable by "parse" 
	//function for parsing the text file
	public void parseTextFile() {
		String temp = ""; // contents of the string are turned into the temp array
						  // "temp will be used for 'str' and 'split'
							
		//A try statement is used to catch exceptions that might be thrown as your program executes. 
		try {
			// BufferedReader is taking the text file and making readable
			BufferedReader br = new BufferedReader(new InputStreamReader(this
					.getResources().openRawResource(R.raw.quiztextfile))); //getting the raw resources text file

			String str = null; //string is automatically NULL

			// while there is still lines in the text file...read the text file
			while ((str = br.readLine()) != null) { 
													
				temp += str; //if its not NULL, str is the temp which  is reading the textfile

			}
			br.close(); //close the buffered reader
			
			//exception for an error 
		} catch (IOException e) {
			//Log.v sends out log output
			//showing the order in terms of least to most...."fileError" then ""textfile"
			//showing that there is an error first...then what the error is related to
			Log.v("fileError", "textfile");
		}
		
		//Array "tempArray" using the 'SPLIT' so it will separate every time it sees a";" 
		String[] tempArray = temp.split(";"); // every time "split" sees a ";"
												// it will end the array
		
		QuizArray = new ArrayList<String>(tempArray.length); //setting the entire length of the array "temp array"

		for (int i = 0; i < tempArray.length; i++) // for loop that goes through
													// the array
		{
			//populating the tempArray 
			QuizArray.add(tempArray[i]);// Quiz array is now populated
		}
		
		//loop going through the entire length of the temp array
		//going in increments of 2 ....so it can go to every 2nd spot for a question
		for (int i = 1; i < tempArray.length; i += 2) {
			//using the hashmap ...calling a "-1" so it can grab the question in the 0 spot
			//"HashMap.put" method puts in a key first, then its value.
			HashMap.put(tempArray[i - 1], tempArray[i]);
		}
	}

}
