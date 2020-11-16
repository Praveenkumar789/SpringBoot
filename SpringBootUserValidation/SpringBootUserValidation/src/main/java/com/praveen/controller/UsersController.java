package com.praveen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.data_access_object.UsersDataAccessObject;
import com.praveen.model.UsersData;


@RestController
public class UsersController {
	@Autowired
	UsersDataAccessObject studentDao;
	@RequestMapping (value="/insert", method=RequestMethod.POST)
	public String insertData(@RequestBody String userdetails)
	{
		String [] vals = userdetails.split("&");
		int userId = Integer.parseInt(vals[0].split("=")[1]);
		String password = vals[1].split("=")[1];
		UsersData userObject = new UsersData();
		userObject.setUserId(userId);
		userObject.setUserPassword(password);
		
		studentDao.insertData(userObject);

		System.out.println("LOG : method insertData of UsersContoller is about to return");
		
		return "Data insertion is successful";
	}

	
	@RequestMapping("/delete/{userId}")
	public String deleteDAta(@PathVariable("userId") int userId)
	{
		studentDao.deleteRecord(userId);
		return "Record deletion successful";
	}
	
	@RequestMapping("/update")
	public String updateData()
	{
		return "Updation is not yet available";
	}
	
	@RequestMapping("/displayAll")
	public List<UsersData> displayData()
	{
		List<UsersData> studentList = studentDao.displayAll();
		return studentList;
	}
}
