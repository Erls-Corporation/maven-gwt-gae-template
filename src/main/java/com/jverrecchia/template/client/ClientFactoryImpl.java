package com.jverrecchia.template.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.jverrecchia.template.client.ui.View1;
import com.jverrecchia.template.client.ui.View1Impl;
import com.jverrecchia.template.client.ui.View2;
import com.jverrecchia.template.client.ui.View2Impl;
import com.jverrecchia.template.client.ui.View3;
import com.jverrecchia.template.client.ui.View3Impl;

public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final View1 view1 = new View1Impl();
	private static final View2 view2 = new View2Impl();
	private static final View3 view3 = new View3Impl();
	
	@Override
	public EventBus getEventBus() 
	{
		return eventBus;		
	}
	
	@Override
	public PlaceController getPlaceController() 
	{
		return placeController;
	}
	
	@Override
	public View1 getView1() 
	{
		return view1;
	}
	
	@Override
	public View2 getView2() 
	{
		return view2;
	}

	@Override
	public View3 getView3() {
		return view3;
	}







}
