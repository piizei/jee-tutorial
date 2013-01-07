package forecast.security;

import java.security.Principal;

public class MockRolePrincipal implements Principal{
	
	String name;
	
	public MockRolePrincipal() {
		
	}
	
	public MockRolePrincipal(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
