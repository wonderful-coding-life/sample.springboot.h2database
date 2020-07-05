package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

@Controller
public class WebController {
	private UserProfileMapper mapper;
	
	public WebController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}
	
	@GetMapping("/temp/user/{id}")
	@ResponseBody
	public String getUserProfile(@PathVariable("id") int id) {
		UserProfile userProfile = mapper.getUserProfile(id);
		if (userProfile == null) {
			throw new IllegalArgumentException("invalid user Id:" + id);
		}
		String result = "<body>";
		result += "이름: " + userProfile.getName() + "<br>";
		result += "전화: " + userProfile.getPhone() + "<br>";
		result += "주소: " + userProfile.getAddress() + "<br>";
		result += "</body>";
		return result;
	}
	
	@GetMapping("/user/{id}")
	public String getUserProfileTemplate(@PathVariable("id") int id, Model model) {
		UserProfile userProfile = mapper.getUserProfile(id);
		model.addAttribute("userProfile", userProfile);
		return "user/user";
	}
	
	@GetMapping("/user/list")
	public String userList(Model model) {
		List<UserProfile> userProfileList = mapper.getUserProfileList();
		model.addAttribute("userProfileList", userProfileList);
		return "user/list";
	}
	
	@GetMapping("/user/add")
	public String getUserAdd() {
		return "user/add";
	}
	
	@PostMapping("/user/add")
	public String postUserAdd(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.insertUserProfile(name, phone, address);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/edit/{id}")
	public String getUserEdit(@PathVariable("id") int id, Model model) {
		UserProfile userProfile = mapper.getUserProfile(id);
		model.addAttribute("userProfile", userProfile);
		return "user/edit";
	}
	
	@PostMapping("/user/edit/{id}")
	public String postUserEdit(UserProfile userProfile) {
		mapper.updateUserProfile(userProfile.getId(), userProfile.getName(), userProfile.getPhone(), userProfile.getAddress());
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/delete/{id}")
	public String getUserDelete(@PathVariable("id") int id) {
		mapper.deleteUserProfile(id);
		return "redirect:/user/list";
	}
}
