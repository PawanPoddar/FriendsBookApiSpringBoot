package springBoot.astroTalk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springBoot.astroTalk.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

//	@Query("select f from User f  where f.id = :id")
//	public List<User> getUserFriends(@Param("id") int id);
	
	@Query("select f from User f  where f.id = :id")
	public User getUserFriend(@Param("id") int id);
	

}
