package com.example.mediaplayer;

import java.util.ArrayList;

import android.content.Context;

public class Database extends MainActivity
{
	int myMovies = 4; //declaring my 4 movies
	
	private DBAdapter database;
	
	private String[] movieName = {"The 300", "Transformers", "Kill Bill", "Avengers",};
	private String[] moviePath = {
	private ArrayList<String> list; //the array list of movies
	
	public void DataBase(Context context, String[] movieList)
	{
		database = new DBAdapter(context);
		
		//loop to go through movie list
		for (int i=0; i<movieList; i++){
			list.add(movieList[i]);
		}
	}
	
	
	//***********OPENING THE DATABASE
	db.database.open();
	db.database.insertMovie("The 300", "Transfromers", "Kill Bill", "Avengers",);
	db.database.close();
	

	
	public String movieId()
	{
		
	}
	
	
	public String title()
	{
		
	}
	
	public String rating()
	{
		
	}

	public String description()
	{
		
	}
	
	public String imageName()
	{
		
	}
	
	public String trailerName()
	{
		
	}
}























