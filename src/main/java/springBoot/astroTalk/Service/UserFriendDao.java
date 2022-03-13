package springBoot.astroTalk.Service;

import java.util.List;

import springBoot.astroTalk.Model.Friend;
import springBoot.astroTalk.Model.User;


public interface UserFriendDao {

	public String add(Friend user);
	public List<Friend> getUser();
	public List<User> getUserById(int userId);
	public List<User> nearFriends(int distance);
	public void removeFriend(long id);

}

