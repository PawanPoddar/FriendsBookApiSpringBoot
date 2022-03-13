package springBoot.astroTalk.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import springBoot.astroTalk.Model.User;
import springBoot.astroTalk.Response.ErrorResponse;
import springBoot.astroTalk.Response.MapResponse;
import springBoot.astroTalk.Response.UserListResponse;
import springBoot.astroTalk.Service.UserDao;

@RestController
@RequestMapping("/user")
public class UserController {
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEn;
	
	@Autowired
	public UserDao uDao;
	
	//User Registration
	@PostMapping("/register")
	public ResponseEntity<UserListResponse> add(@RequestBody User user) {
		UserListResponse response = new UserListResponse();
		List<User> userList = new ArrayList<User>();
		try {
				User result =uDao.add(user);
				userList.add(result);
				response.setData(userList);
				response.setStatus(HttpStatus.CREATED.value());
			}catch(Exception ex) {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				response.setErrors(
					new ErrorResponse()
					.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.setErrorDesc(ex.getMessage())
					);
				return new ResponseEntity<UserListResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		return new ResponseEntity<UserListResponse>(response, HttpStatus.CREATED);
	}
	//Fetch All Users
	@RequestMapping("/allUsers")
	public ResponseEntity<UserListResponse> getUser(Model modal) {
		UserListResponse response = new UserListResponse();
		try {
		response.setData(uDao.getUser());
		response.setStatus(HttpStatus.OK.value());
		} catch(Exception ex) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setErrors(
				new ErrorResponse()
				.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setErrorDesc(ex.getMessage())
				);
			return new ResponseEntity<UserListResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	return new ResponseEntity<UserListResponse>(response, HttpStatus.OK);
	}
	
	//Delete User
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<MapResponse> del(@PathVariable int id) {
		MapResponse response = new MapResponse();
		try {
				uDao.remove(id);
				response.setStatus(HttpStatus.OK.value());
		} catch(Exception ex) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setErrors(
				new ErrorResponse()
				.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setErrorDesc(ex.getMessage())
				);
			return new ResponseEntity<MapResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	return new ResponseEntity<MapResponse>(response, HttpStatus.OK);

	}
}