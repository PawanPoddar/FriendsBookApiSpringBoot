package springBoot.astroTalk.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.astroTalk.Model.User;
import springBoot.astroTalk.Repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao{
	
	@Autowired
	public UserRepository repo;
	
	public List<User> getUser(){
		
		return (List<User>) repo.findAll();
		
	}
	
	public User add(User user) {
		// TODO Auto-generated method stub
		User save=repo.save(user);
		return save;
	}

	public void remove(int id) {
		
		repo.deleteById(id);
	}

//	public List<User> auth(String name, String password) {
//		return repo.findByNameAndPassword(name,password);
//	}

	
	

}
