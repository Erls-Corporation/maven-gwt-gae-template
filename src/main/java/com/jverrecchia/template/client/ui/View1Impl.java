package com.jverrecchia.template.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Widget;
import com.jverrecchia.template.client.place.View2Place;


public class View1Impl extends Composite implements View1 {

	private Presenter listener;
	
	
	
	private static View1Impl2UiBinder uiBinder = GWT
			.create(View1Impl2UiBinder.class);

	interface View1Impl2UiBinder extends UiBinder<Widget, View1Impl> {
	}

	public View1Impl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public View1Impl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		listener.goTo(new View2Place());
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
		
	}

}
