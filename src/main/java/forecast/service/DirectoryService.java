package forecast.service;

import java.util.Set;

public interface DirectoryService {
	
	Set<String> getTeamMembers(String userId);
	String getTeamLeader(String userId);
	String getManager(String userId);

}
