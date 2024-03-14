package com.example.demo.request;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
public class SearchRequest {
	
	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;
	private String benifitAmt;
	
	
}
