import com.jverrecchia.template.shared.User;

import junit.framework.TestCase;


public class UserTest extends TestCase{
	
	public void testUserName(){
		User user = new User();
		user.setName("Jonathan");
		assert(user.getName().equals("Jonathan"));
	}	
	
}
