package com.jverrecchia.template.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.jverrecchia.template.client.ClientFactory;
import com.jverrecchia.template.client.place.View2Place;
import com.jverrecchia.template.client.ui.View2;

public class View2Activity extends AbstractActivity implements View2.Presenter{

	ClientFactory clientFactory;
	
	public View2Activity (View2Place place ,ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	
	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		View2 view2 = clientFactory.getView2();
		
		view2.setPresenter(this);
		panel.setWidget(view2.asWidget());
	}




	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}

}
