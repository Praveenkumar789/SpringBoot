package com.praveen.data_access_object;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.model.UsersData;
import com.praveen.repository.UsersRepository;

@Service
public class UsersDataAccessObject  {
	
	@Autowired
	UsersRepository usersRepository;
	public void insertData(UsersData userObj)
	{
		System.out.println("Hey I am dao  INserting");
		usersRepository.save(userObj);
	}

	public void deleteRecord(int id)
	{
		usersRepository.deleteById(id);
	}
	public List<UsersData> displayAll()
	{
		List<UsersData> studentList = (List<UsersData>) usersRepository.findAll();
		return studentList;
	}
	

}