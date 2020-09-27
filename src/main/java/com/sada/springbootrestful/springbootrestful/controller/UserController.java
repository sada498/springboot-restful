package com.sada.springbootrestful.springbootrestful.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sada.springbootrestful.springbootrestful.resource.UserRest;
@RestController
@RequestMapping("users") //url path http://localhost:8080/users
public class UserController {
	@GetMapping
	public String getUsers(@RequestParam(value="page", defaultValue="1",required=false)int page,
			                @RequestParam(value="limit")int limit,
	                       @RequestParam(value="sort",defaultValue="desc", required= false)String sort){
		return "get user from user page"+ page +" and limit="+ limit +" and sort=" + sort;
	}
	@GetMapping(path="/{userId}",
			produces= {
				MediaType.APPLICATION_XML_VALUE, 
				MediaType.APPLICATION_JSON_VALUE
				})
	public UserRest getUser(@PathVariable String userId) {
		UserRest  returnValue=new UserRest();
		returnValue.setEmail("sada@outlook.com");
		returnValue.setFirstName("sada");
		returnValue.setLastName("rao");
		return returnValue;
	}
	@PostMapping
	public String createUser(){
		return "create user in DB";
	}
	@PutMapping
	public String updateUser() {
		return "update the userin DB";
	}
	@DeleteMapping
	public String deleteUser() {
		return "dlete the uder from DB";
	}
	
	

}
