package springBoot.astroTalk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springBoot.astroTalk.Model.Friend;
import springBoot.astroTalk.Model.User;
import springBoot.astroTalk.Repository.UserFriendRepository;
import springBoot.astroTalk.Repository.UserRepository;

@SpringBootApplication
public class SpringLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLoginApplication.class, args);
		
		
	}
//	private int id;
//	private String name;
//	private int age;
//	private String gender;
//	private String address;
//	private long mobile;
//	private String email;
//	private String password;
//	 @Bean
//	    public CommandLineRunner mappingDemo(repository usRepo,
//	                                         UserFriendRepository frRepo) {
//	        return args -> {
//
//	            User user = new User(35, "Hariom", 25, "Male", "Karawal Nagar",987684354,"abc@gmail.com","1235abc");
//
//	            usRepo.save(user);
//
//	            // create and save new pages
//	            frRepo.save(new Friend(1L,user,30L));
////	           
//	        };
	 }

//}
