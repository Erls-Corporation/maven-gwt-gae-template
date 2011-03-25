package com.jverrecchia.template.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.jverrecchia.template.client.place.View1Place;

public class View3Impl extends Composite implements View3 {

	
	
	
	
	private static View3ImplUiBinder uiBinder = GWT
			.create(View3ImplUiBinder.class);

	interface View3ImplUiBinder extends UiBinder<Widget, View3Impl> {
	}

	public View3Impl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;
	
	private Presenter listener;

	public View3Impl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		listener.goTo(new View1Place());
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
