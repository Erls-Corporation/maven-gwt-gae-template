package com.jverrecchia.template.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class View2Place extends Place{
	
	public View2Place(){
		
	}

	@Prefix("2") //enlever le Prefix Attention ! pas laisser le meme prefix
	public static class Tokenizer implements PlaceTokenizer<View2Place>
	{

		@Override
		public String getToken(View2Place place)
		{
			return "view2";
		}

		@Override
		public View2Place getPlace(String token)
		{
			return new View2Place();
		}

		

	}
}
