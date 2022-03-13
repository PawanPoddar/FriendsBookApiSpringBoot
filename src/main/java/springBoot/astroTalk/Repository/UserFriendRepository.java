package springBoot.astroTalk.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springBoot.astroTalk.Model.Friend;

@Repository
public interface UserFriendRepository  extends CrudRepository<Friend,Long>{

//	@Query("select u from Friend u where u.user.id=:id")
	@Query("select f from Friend f join f.user u where f.user.id = :id")
	List<Friend> findById(@Param("id") int id);
	

}
