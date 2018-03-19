package xyz.meistertobias.jndi.server;

import javax.ejb.Stateless;

@Stateless
public class CalcBean implements CalcRemote {
	
	@Override
	public int add(int x, int y) {
		return x + y;
	}
	
	@Override
	public int subtract(int x, int y) {
		return x - y;
	}
	
	@Override
	public int multiply(int x, int y) {
		return x * y;
	}
	
	@Override
	public int divide(int x, int y) {
		return x / y;
	}
}
