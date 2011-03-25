package com.jverrecchia.template.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jverrecchia.template.shared.User;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("user")
public interface TemplateService extends RemoteService {
	public String getUsers() throws IllegalArgumentException;
	public String persistUser(User user) throws IllegalArgumentException;
}
