package com.jverrecchia.template.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;


public interface View3 extends IsWidget{
void setPresenter(Presenter listener);


	
	public interface Presenter
	{
		
		void goTo(Place place);
	}
}