package com.jverrecchia.template.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.jverrecchia.template.shared.User;

public class template implements EntryPoint {
  
	private final TemplateServiceAsync templateService = GWT.create(TemplateService.class);
	
	private Button addUser = new Button("Add User");
	private TextBox textBox = new TextBox();
	private Label usersList = new Label();
	
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
