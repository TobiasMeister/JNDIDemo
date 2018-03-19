package xyz.meistertobias.jndi.client;

import xyz.meistertobias.jndi.User;
import xyz.meistertobias.jndi.server.CalcRemote;
import xyz.meistertobias.jndi.server.UserRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ClientUI {
	
	public static void main(String[] args) throws IOException, NamingException {
		var properties = new Properties();
		properties.load(new FileReader("Client/jndi.properties"));
		var ctx = new InitialContext(properties);
		
		// JNDI: calc
		{
			var calcJndiName = "jndi-server/CalcBean!xyz.meistertobias.jndi.server.CalcRemote";
			var calcRemote = (CalcRemote) ctx.lookup(calcJndiName);
			
			// add
			System.out.println(calcRemote.add(5, 9));
			
			// subtract
			System.out.println(calcRemote.subtract(5, 9));
			
			// divide
			System.out.println(calcRemote.divide(5, 9));
			
			// multiply
			System.out.println(calcRemote.multiply(5, 9));
		}

		System.out.println();

		// JNDI: user
		{
			var userJndiName = "jndi-server/UserBean!xyz.meistertobias.jndi.server.UserRemote";
			var userRemote = (UserRemote) ctx.lookup(userJndiName);
			
			// addUser
			var user = new User("Marcel", "Davis", "Leiter für Kundenzufriedenheit");
			userRemote.addUser(user);
			
			// getUsers
			userRemote.getUsers().forEach(System.out::println);
			
			// getUser
			System.out.println(userRemote.getUser("Leiter für Kundenzufriedenheit"));
			
			// deleteUser
			userRemote.deleteUser("Leiter für Kundenzufriedenheit");
		}
	}
}
