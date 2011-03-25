package com.jverrecchia.template.server;

import java.util.ArrayList;
import java.util.List;

import com.jverrecchia.template.client.TemplateService;
import com.jverrecchia.template.shared.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

@SuppressWarnings("serial")
public class TemplateServiceImpl extends RemoteServiceServlet implements
    TemplateService {

	static{
		ObjectifyService.register(User.class);
	}
	
  public String getUsers() throws IllegalArgumentException {

    User user = new User();
    user.setName("Jonathan");
    
    
    Objectify ofy = ObjectifyService.begin();
    Query<User> q = ofy.query(User.class);
    
    List<String> usersNames = new ArrayList<String>();
    for(User currentUser : q){
    	usersNames.add(currentUser.getName());
    }
    
    return usersNames.toString();
  }

  public String persistUser(User user) throws IllegalArgumentException {
	    Objectify ofy = ObjectifyService.begin();
	    return ofy.put(user).toString();
	  }
 
  
}
