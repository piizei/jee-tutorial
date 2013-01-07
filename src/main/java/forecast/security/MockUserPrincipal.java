package forecast.security;

import java.security.Principal;

public class MockUserPrincipal implements Principal {

	String name;
	
	public MockUserPrincipal() {
		
	}
	
	public MockUserPrincipal(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
		

}
