package com.example.demo.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepository;



@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private  CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args)throws Exception{
		
		repo.deleteAll();
		
		// Cash PlanData
		CitizenPlan c1= new CitizenPlan();
		c1.setCitizenName("Harshal");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmt(5000.00);
		
		
		CitizenPlan c2= new CitizenPlan();
		c2.setCitizenName("Sanket");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReaseon("Rental Income");
		
		
		CitizenPlan c3= new CitizenPlan();
		c3.setCitizenName("Nikita");
		c3.setGender("Fe-male");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitAmt(5000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");
		
		
		//food plan 
		
		CitizenPlan c4= new CitizenPlan();
		c4.setCitizenName("Manoj");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitAmt(4000.00);
		
		
		CitizenPlan c5= new CitizenPlan();
		c5.setCitizenName("Vicky");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReaseon("Property income is getting");
		
		
		CitizenPlan c6= new CitizenPlan();
		c6.setCitizenName("Utkarsha");
		c6.setGender("Fe-male");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitAmt(3000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Employed");
		
		//medical
		CitizenPlan c7= new CitizenPlan();
		c7.setCitizenName("Sky");
		c7.setGender("Male");
		c7.setPlanName("medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmt(4000.00);
		
		
		CitizenPlan c8= new CitizenPlan();
		c8.setCitizenName("Pravin");
		c8.setGender("Male");
		c8.setPlanName("medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReaseon("Property income is getting");
		
		
		CitizenPlan c9= new CitizenPlan();
		c9.setCitizenName("Aish");
		c9.setGender("Fe-male");
		c9.setPlanName("medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitAmt(3000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Govt job");
		
		//employment
				CitizenPlan c10= new CitizenPlan();
				c10.setCitizenName("Darshan");
				c10.setGender("Male");
				c10.setPlanName("employment");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenifitAmt(4000.00);
				
				
				CitizenPlan c11= new CitizenPlan();
				c11.setCitizenName("Alkesh");
				c11.setGender("Male");
				c11.setPlanName("employment");
				c11.setPlanStatus("Denied");
				c11.setDenialReaseon("Property income is getting");
				
				
				CitizenPlan c12= new CitizenPlan();
				c12.setCitizenName("sneha");
				c12.setGender("Fe-male");
				c12.setPlanName("employment");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenifitAmt(3000.00);
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Govt job");
		
	 List<CitizenPlan> list =Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
	 repo.saveAll(list);
	
	
	}
}
