package com.example.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	public void generate(HttpServletResponse response, List<CitizenPlan> plans, File f) throws Exception {
		
Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();
		
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		
		Paragraph paragraph =new Paragraph("Citizen Plans", fontTitle);
		
		paragraph.setAlignment(paragraph.ALIGN_CENTER);
		document.add(paragraph);
		
		
		PdfPTable table = new PdfPTable(8);
		
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan Start Date");
		table.addCell("Plan End Date");
		table.addCell("Benifit Amt");
		
		
		
		for(CitizenPlan plan : plans) {
			
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");
			table.addCell(plan.getBenifitAmt()+"");
			
		}
		
		document.add(table);
		
		
		
		document.close();

	}

}
