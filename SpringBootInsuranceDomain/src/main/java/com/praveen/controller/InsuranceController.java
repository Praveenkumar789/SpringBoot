package com.praveen.controller;


import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.data_access_object.InsuranceDataAccessObject;
import com.praveen.model.InsuranceDetails;


@RestController
public class InsuranceController {
	@Autowired
	InsuranceDataAccessObject insuranceDataAccessObject;
	
	@RequestMapping (value="/insert", method=RequestMethod.GET)
	public String insertData(@RequestBody String passedDetails)
	{
		try {
			InsuranceDetails proposer = new InsuranceDetails();
			String [] values = passedDetails.split("&");
			int len =  values.length;
			
			HashMap<String, String> proposerdetails = new HashMap<String, String>();
			
			for(int index=0;index<len;index++)
			{
				String temp[] = values[index].split("=");
				proposerdetails.put(temp[0], temp[1]);
			}
			proposer.setPolicyNo(Integer.parseInt(proposerdetails.get("policyno")));
			proposer.setProposerName(proposerdetails.get("proposername"));
			proposer.setInsuranceType(proposerdetails.get("insurancetype"));
			proposer.setTenure(Integer.parseInt(proposerdetails.get("tenure")));
			proposer.setCustomerDueDiligence(proposerdetails.get("cdd"));
			proposer.setEnhancedDueDeligence(proposerdetails.get("edd"));
			
			
			
			insuranceDataAccessObject.insertData(proposer);
		
			System.out.println("LOG: insertData is called");
			
			return "Data insertion is successful";
		}
		catch(Exception e) {
			return "You are supposed to send details where \"=\" seperates key and value and & distinguishes the values\n"
					+ "Body Cannot be Empty";
		}
	}

	
	@RequestMapping("/delete/{id}")
	public String deleteDAta(@PathVariable("id") int id)
	{
		insuranceDataAccessObject.deleteRecord(id);
		return "Record deletion successful";
	}
	
	@RequestMapping("/update")
	public String updateData(@RequestParam("policyno") int id, @RequestParam("col") String col_name, @RequestParam("val") String new_val)
	{
		insuranceDataAccessObject.updateRecord(id, col_name, new_val);
		return "Updation of Record with Policy Number: "+ id +" is successful";
	}
	
	@RequestMapping("/displayAll")
	public List<InsuranceDetails> displayData()
	{
		List<InsuranceDetails> studentList = insuranceDataAccessObject.displayAll();
		return studentList;
	}
}
