package xyz.meistertobias.jndi.server;

import xyz.meistertobias.jndi.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserRemote {
	
	List<User> getUsers();
	
	User getUser(String nickname);
	
	void addUser(User user);
	
	void deleteUser(String nickname);
}
