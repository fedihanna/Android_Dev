package com.example.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity 
{

	//declaring buttons
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button add;
	Button subtract;
	Button multiply;
	Button divide;
	Button clear;
	Button equal;
	Button decimal;
	Button posNeg;
	
	//declaring variables
	TextView disp;// display screen
	String input1 = "";// input 1, = takes away the null
	String input2 = "";// input 2, = takes away the null
	String operation = "";// declaring an operation string, = takes away the
							// null
	Math math = new Math();// Aggregating the MATH class to GUI class

	// Equation: input1 operation input2 || These will contain: i.e......2 * 5
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		disp = (TextView) findViewById(R.id.screen);//screen is declared in the graphical output, making sure it works

		
		
		//allowing number buttons to be view either as input1 and input2
		one = (Button) findViewById(R.id.one);
		one.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "") 
				{
					input1 += 1;
				} else {// operation = + OR operation = * ... etc.
					input2 += 1;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for one button

		two = (Button) findViewById(R.id.two);
		two.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "") 
				{
					input1 += 2;
				} else {// operation = + OR operation = * ... etc.
					input2 += 2;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for two button

		three = (Button) findViewById(R.id.three);
		three.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				if (operation == "") 
				{
					input1 += 3;
				} else {// operation = + OR operation = * ... etc.
					input2 += 3;
				}//end public void
				setText();// this is displaying the if statement
			}
		});// ending onClickListener for three button

		four = (Button) findViewById(R.id.four);
		four.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "") 
				{
					input1 += 4;
				} else {// operation = + OR operation = * ... etc.
					input2 += 4;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for four button

		five = (Button) findViewById(R.id.five);
		five.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "") 
				{
					input1 += 5;
				} else {// operation = + OR operation = * ... etc.
					input2 += 5;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for five button

		six = (Button) findViewById(R.id.six);
		six.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "") 
				{
					input1 += 6;
				} else {// operation = + OR operation = * ... etc.
					input2 += 6;
				}//end public void
				setText();// this is displaying the if statement
			}
		});// ending onClickListener for six button

		seven = (Button) findViewById(R.id.seven);
		seven.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "")
{
					input1 += 7;
				} else {// operation = + OR operation = * ... etc.
					input2 += 7;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for seven button

		eight = (Button) findViewById(R.id.eight);
		eight.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "")
				{
					input1 += 8;
				} else {// operation = + OR operation = * ... etc.
					input2 += 8;
				}//end public void
				setText();// this is displaying the if statement
			}
		});// ending onClickListener for eight button

		nine = (Button) findViewById(R.id.nine);
		nine.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "") 
				{
					input1 += 9;
				} else {// operation = + OR operation = * ... etc.
					input2 += 9;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for nine button

		zero = (Button) findViewById(R.id.zero);
		zero.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				if (operation == "")
				{
					input1 += 0;
				} else {// operation = + OR operation = * ... etc.
					input2 += 0;
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for zero button

		
		
		//these  are the operation buttons
		// add, subtract, multiply, divide,

		add = (Button) findViewById(R.id.add);
		add.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				operation = "+";
				setText();// this is displaying the the operator
			}//end public void
		});// ending onClickListener for add button

		subtract = (Button) findViewById(R.id.subtract);
		subtract.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				operation = "-";
				setText();// this is displaying the operator
			}//end public void
		});// ending onClickListener for subtract button

		multiply = (Button) findViewById(R.id.multiply);
		multiply.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				operation = "*";
				setText();// this is displaying the operator
			}//end public void
		});// ending onClickListener for multiply button

		divide = (Button) findViewById(R.id.divide);
		divide.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				operation = "/";
				setText();// this is displaying the operator
			}//end public void
		});// ending onClickListener for divide button

		
		posNeg = (Button) findViewById(R.id.posNeg);
		posNeg.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v)
			{
				if(operation == "")// to display the -sign
				{
					input1 = math.posNeg(input1);//to display it for input 1
				}
				else
				{
					input2 = math.posNeg(input2);//to display it for input 2
				}
				setText();// this is displaying the -sign in front of number 
			}//end public void
		});// ending onClickListener for posNEg button
		
		
		equal = (Button) findViewById(R.id.equal);
		equal.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				input1 = math.operation(input1, operation, input2);
				operation = "";
				input2 = "";

				setText();// this is displaying the if statement
				if (input1.equals("NAN")) 
				{
					input1 = "";
				}
			}//end public void
		});// ending onClickListener for one button

		
		clear = (Button) findViewById(R.id.clear);
		clear.setOnClickListener(new OnClickListener()
		 {
			@Override
			public void onClick(View v)
			{
				operation = "";//clear operations
				input1 = "";//clears input1
				input2 = "";//clears input2
				setText();// this is displaying the screen as cleared
			}//end public void
		});// ending onClickListener for AC button

		
		decimal = (Button) findViewById(R.id.decimal);
		decimal.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				if (operation == "" && !input1.contains("."))
				{
					input1 += ".";
				} else if (!input2.contains(".")){// operation = + OR operation = * ... etc.
					input2 += ".";
				}
				setText();// this is displaying the if statement
			}//end public void
		});// ending onClickListener for decimal button
		
		
		
	}// end on create method

	// displaying my number and operation to another number on the screen
	//specs say it has to be displayed this way
	public void setText() 
	{
		disp.setText(input1 + " " + operation + " " + input2);
	}//end public void

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}//end public boolean

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}//end public boolean
}//end public class MainActivity extends ActionBarActivity 
