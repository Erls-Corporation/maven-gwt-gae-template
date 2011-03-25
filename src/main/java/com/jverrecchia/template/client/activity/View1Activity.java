package com.jverrecchia.template.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jverrecchia.template.client.ClientFactory;
import com.jverrecchia.template.client.place.View1Place;
import com.jverrecchia.template.client.ui.View1;

public class View1Activity extends AbstractActivity implements View1.Presenter{

	ClientFactory clientFactory;
	
	public View1Activity(View1Place place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		View1 view1 = clientFactory.getView1();
		
		view1.setPresenter(this);
		panel.setWidget(view1.asWidget());
	}


	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}

}
