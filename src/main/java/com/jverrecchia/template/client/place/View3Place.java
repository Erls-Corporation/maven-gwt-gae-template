package com.jverrecchia.template.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class View3Place extends Place{

	public View3Place(){
		
	}
	
	@Prefix("3") //changer le Prefix Attention ! pas laisser le meme prefix
	public static class Tokenizer implements PlaceTokenizer<View3Place>
	{

		@Override
		public String getToken(View3Place place)
		{
			return "view3";
		}

		@Override
		public View3Place getPlace(String token)
		{
			return new View3Place();
		}

		

	}
}
