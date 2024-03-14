package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.request.SearchRequest;


public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStauses();
	
	public List<CitizenPlan>search(SearchRequest request);
	
	public boolean exportExcel (HttpServletResponse response )throws Exception;
	
	public boolean exportPdf(HttpServletResponse response )throws Exception;

}
