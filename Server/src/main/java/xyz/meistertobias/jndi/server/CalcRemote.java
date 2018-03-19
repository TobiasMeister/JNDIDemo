package xyz.meistertobias.jndi.server;

import javax.ejb.Remote;

@Remote
public interface CalcRemote {
	
	int add(int x, int y);
	
	int subtract(int x, int y);
	
	int multiply(int x, int y);
	
	int divide(int x, int y);
}
