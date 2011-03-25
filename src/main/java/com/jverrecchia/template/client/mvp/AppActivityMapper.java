package com.jverrecchia.template.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.jverrecchia.template.client.ClientFactory;
import com.jverrecchia.template.client.activity.View1Activity;
import com.jverrecchia.template.client.activity.View2Activity;
import com.jverrecchia.template.client.activity.View3Activity;
import com.jverrecchia.template.client.place.View1Place;
import com.jverrecchia.template.client.place.View2Place;
import com.jverrecchia.template.client.place.View3Place;

public class AppActivityMapper implements ActivityMapper{

	
	private ClientFactory clientFactory;
	
	
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {

		if(place instanceof View1Place){
			return new View1Activity((View1Place) place, clientFactory);
		}
		else if (place instanceof View2Place){
			return new View2Activity((View2Place) place, clientFactory);
		}
		else if (place instanceof View3Place){
			return new View3Activity((View3Place)place , clientFactory);
		}
		else
			return null;
	}

}
