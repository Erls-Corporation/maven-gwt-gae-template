package com.jverrecchia.template.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class View1Place extends Place {

	public View1Place(){
		
	}
	

	@Prefix("1") //enlever le Prefix
	public static class Tokenizer implements PlaceTokenizer<View1Place>
	{

		@Override
		public String getToken(View1Place place)
		{
			return "view1";
		}

		@Override
		public View1Place getPlace(String token)
		{
			return new View1Place();
		}

		

	}

	
	
}
