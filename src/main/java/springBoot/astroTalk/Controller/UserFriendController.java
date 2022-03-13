package springBoot.astroTalk.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import springBoot.astroTalk.Model.Friend;
import springBoot.astroTalk.Model.User;
import springBoot.astroTalk.Response.ErrorResponse;
import springBoot.astroTalk.Response.FriendListResponse;
import springBoot.astroTalk.Response.MapResponse;
import springBoot.astroTalk.Response.UserListResponse;
import springBoot.astroTalk.Service.UserFriendDao;


@RestController
@RequestMapping("/friend")
public class UserFriendController {
	

	@Autowired
	private UserFriendDao uDao;
	//Make a Friend
	@PostMapping("/makeFriend")
	public ResponseEntity<MapResponse> add(@RequestBody Friend userFriend) {
		MapResponse response =  new MapResponse();
		try {
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
	
	/*
	 * @RequestMapping("/show") public List<Friend> getUser() {
	 * 
	 * return uDao.getUser(); }
	 */
	//Get all friends of particular user
	@GetMapping("/user/allFriends/{id}")
	public ResponseEntity<FriendListResponse> allFriends(@PathVariable int id){
		FriendListResponse response = new FriendListResponse();
		try {
				response.setData(uDao.getUserById(id));
				response.setStatus(HttpStatus.OK.value());
		} catch(Exception ex) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setErrors(
				new ErrorResponse()
				.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.setErrorDesc(ex.getMessage())
			);	
			return new ResponseEntity<FriendListResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FriendListResponse>(response, HttpStatus.OK);
	}
	
	//All friends to kth position
	@RequestMapping("/near/{id}")
	public ResponseEntity<UserListResponse> nearFreinds(@PathVariable int id) {
		UserListResponse response =  new UserListResponse();
		try {
			response.setData(uDao.nearFriends(id));
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
	
	//Delete particular friend
	@DeleteMapping("/deleteFriend/{id}")
	public ResponseEntity<MapResponse> del(@PathVariable int id) {
		MapResponse response = new MapResponse();
		try {
				uDao.removeFriend(id);
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
