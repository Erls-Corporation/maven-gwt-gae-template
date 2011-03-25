package com.jverrecchia.template.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jverrecchia.template.client.ClientFactory;
import com.jverrecchia.template.client.place.View3Place;
import com.jverrecchia.template.client.ui.View3;

public class View3Activity extends AbstractActivity implements View3.Presenter{

	ClientFactory clientFactory;
	
	public View3Activity(View3Place place ,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		View3 view3 = clientFactory.getView3();
		
		
		view3.setPresenter(this);
		panel.setWidget(view3.asWidget());
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}

}
