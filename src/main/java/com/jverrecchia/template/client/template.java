package com.jverrecchia.template.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.jverrecchia.template.client.mvp.AppActivityMapper;
import com.jverrecchia.template.client.mvp.AppPlaceHistoryMapper;
import com.jverrecchia.template.client.place.View1Place;
import com.jverrecchia.template.shared.User;

public class Template implements EntryPoint {
  
	private final TemplateServiceAsync templateService = GWT.create(TemplateService.class);
	
	private Button addUser = new Button("Add User");
	private TextBox textBox = new TextBox();
	private Label usersList = new Label();
	
	private SimplePanel appWidget = new SimplePanel();
	private Place defaultPlace = new View1Place();	
	
  public void onModuleLoad() {
	  
	  refreshUsers();
	  
	  addUser.addClickHandler(new ClickHandler() {
		
		public void onClick(ClickEvent e) {
			addUser(textBox.getText());
			
		}
	});
	  
	  RootPanel.get().add(usersList);
	  RootPanel.get().add(textBox);
	  RootPanel.get().add(addUser);
	  
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace );
		
		RootPanel.get().add(appWidget);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();	  
	  
  }
  
  private void addUser(String userName){
	  User user = new User();
	  user.setName(userName);
	  
		templateService.persistUser(user, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {
				usersList.setText("getUsers Async call failure");
			}

			public void onSuccess(String result) {
				refreshUsers();
				
			}
		});		  
	  
  }
  
  private void refreshUsers(){
	  
		templateService.getUsers(new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						usersList.setText("getUsers Async call failure");
					}

					public void onSuccess(String result) {
						usersList.setText(result);
					}
				});	  
  }
}
