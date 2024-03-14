package com.example.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepository;
import com.example.demo.request.SearchRequest;
import com.example.demo.util.EmailUtils;
import com.example.demo.util.ExcelGenerator;
import com.example.demo.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public List<String> getPlanNames() {
	
		return planRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStauses() {
		// TODO Auto-generated method stub
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
     
		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName()))			
		entity.setPlanName(request.getPlanName());
		
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus()))	
			entity.setPlanStatus(request.getPlanStatus());
		
		if (null != request.getGender() && !"".equals(request.getGender()))			
			entity.setGender(request.getGender());
		
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate= request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
			
		}
		
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate= request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);
			
		}
		
		return planRepo.findAll(Example.of(entity));
		
		 
	}

	@Override
	public boolean exportExcel (HttpServletResponse response) throws Exception {
		File f = new File("plans.xls");	
	List <CitizenPlan> plans =planRepo.findAll();
	
	excelGenerator.generate(response, plans, f);	
	String subject = "Test mail subject";
	String body = "<h1>This is mail body</h1>";
	String to = "HelloHello@gmail.com";
	
	
	
	emailUtils.sendEmail(subject, body, to, f);
	f.delete();
	
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response )throws Exception{

		File f = new File("plans.pdf");	
		List<CitizenPlan> plans = planRepo.findAll();
		pdfGenerator.generate(response, plans,f);
		
		String subject = "Test mail subject";
		String body = "<h1>This is mail body</h1>";
		String to = "HelloHello@gmail.com";
		
		emailUtils.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
