package com.jverrecchia.template.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.jverrecchia.template.client.ui.View1;
import com.jverrecchia.template.client.ui.View2;
import com.jverrecchia.template.client.ui.View3;

public interface ClientFactory 
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	View1 getView1();
	View2 getView2();
	View3 getView3();
}
