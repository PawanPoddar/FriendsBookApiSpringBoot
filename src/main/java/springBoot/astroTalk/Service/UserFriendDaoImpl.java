package springBoot.astroTalk.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.astroTalk.Model.Friend;
import springBoot.astroTalk.Model.User;
import springBoot.astroTalk.Repository.UserFriendRepository;
import springBoot.astroTalk.Repository.UserRepository;


@Service
public class UserFriendDaoImpl extends NearestFriends implements UserFriendDao{

	@Autowired
	private UserFriendRepository userFrRepository;
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public String add(Friend user) {
		Friend save=userFrRepository.save(user);
		return ""+save;
	}

	@Override
	public List<Friend> getUser() {
		return (List<Friend>) userFrRepository.findAll();
	}

	@Override
	public List<User> getUserById(int userId) {
		List<User> userList = new ArrayList<User>();
		List<Friend> friendList= userFrRepository.findById(userId);
		for(Friend fr:friendList) {
			long l=fr.getfId();
			int a=(int)l;
			userList.add(repo.getUserFriend(a));
		}
		
		return userList;
//		System.out.println(userId);
//		return repo.getUserFriends(userId)
	}

	NearestFriends gfg = new NearestFriends();
	
	@Override
	public List<User> nearFriends(int distance) {
		List<User> userList = new ArrayList<User>();
		
		List<Friend> allFellow= (List<Friend>) userFrRepository.findAll();
		TreeNode root=new TreeNode(allFellow.size()-1);
		for(Friend fr:allFellow) {
			long l=fr.getfId();
			int a=(int)l;
			gfg.insert(root,a);
//			userList.add(repo.getUserFriend(a));
		}		
		TreeNode target=gfg.root;
		List<Integer> lst=gfg.distanceK(target, distance);
		Set<Integer> st=new HashSet<Integer>();
		for(int val:lst) {
			st.add(val);
		}
		for(int val:st) {
			userList.add(repo.getUserFriend(val));
		}	
		return userList;
	}

	@Override
	public void removeFriend(long id) {
		userFrRepository.deleteById(id);
	}

}
