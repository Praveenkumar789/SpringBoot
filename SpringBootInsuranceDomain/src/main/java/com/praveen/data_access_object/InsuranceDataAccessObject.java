package com.praveen.data_access_object;

import java.util.List;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.model.InsuranceDetails;
import com.praveen.repository.InsuranceRepository;

import java.util.Iterator;


@Service
public class InsuranceDataAccessObject {
	
	@Autowired
	InsuranceRepository insuranceRepository;
	public void insertData(InsuranceDetails studentObj)
	{
//		System.out.println("Hey I am dao  INserting");
		insuranceRepository.save(studentObj);
	}

	public void deleteRecord(int id)
	{
		insuranceRepository.deleteById(id);
	}
	public List<InsuranceDetails> displayAll()
	{
		List<InsuranceDetails> proposerList = (List<InsuranceDetails>) insuranceRepository.findAll();
		return proposerList;
	}
	
	@SuppressWarnings("finally")
	public InsuranceDetails updateRecord(int id, String col_name, String new_value)
	{
		try {
			int found = 0;
			List<InsuranceDetails> proposerList = this.displayAll();
			Iterator<InsuranceDetails> itr = proposerList.iterator();
			InsuranceDetails fproposer = null;
			while(itr.hasNext())
			{
				InsuranceDetails proposer = itr.next();
				if(proposer.getPolicyNo() == id)
				{
					found  = 1;
					fproposer = proposer;
					break;
				}
			}
			if(found == 1 && fproposer != null)
			{
	
				if(col_name == "policyno") {
					fproposer.setPolicyNo(Integer.parseInt(new_value));
				}
				else if (col_name == "proposername") {
					fproposer.setProposerName(new_value);
				}
				else if (col_name == "insurancetype") {
					fproposer.setInsuranceType(new_value);
				}
				else if (col_name == "tenure")
				{
					fproposer.setTenure(Integer.parseInt(new_value));
				}
				else if(col_name == "cdd")
				{
					fproposer.setCustomerDueDiligence(new_value);
				}
				else if(col_name =="edd")
				{
					fproposer.setEnhancedDueDeligence(new_value);
				}
				
					insuranceRepository.save(fproposer);
					System.out.println(col_name+","+new_value);
					System.out.println(fproposer.toString());
					return fproposer;
				}
				else {
					System.out.println("sorry ID not found in our records");
				}
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong\n");
			e.printStackTrace();
		}
		finally {
			return null;
		}
	}
}
	
	