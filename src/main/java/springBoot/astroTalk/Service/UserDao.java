package springBoot.astroTalk.Service;

import java.util.List;

import springBoot.astroTalk.Model.User;

public interface UserDao {
	public User add(User user);
	public List<User> getUser();
	public void remove(int id);
//	public List<User> auth(String name, String password);
}
