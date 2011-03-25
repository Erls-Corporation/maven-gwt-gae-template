package com.jverrecchia.template.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Widget;
import com.jverrecchia.template.client.place.View3Place;

public class View2Impl extends Composite implements View2 {

	private Presenter listener;
	
	
	private static View2Impl2UiBinder uiBinder = GWT
			.create(View2Impl2UiBinder.class);

	interface View2Impl2UiBinder extends UiBinder<Widget, View2Impl> {
	}

	public View2Impl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	public View2Impl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		listener.goTo(new View3Place());
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
