package util;
import java.util.List;

import entity.User;

public interface UserCRUDUtil {
	
	void addUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	
	List<User> readAllUsers();
}
