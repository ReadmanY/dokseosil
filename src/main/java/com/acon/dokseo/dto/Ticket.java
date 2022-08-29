package com.acon.dokseo.dto;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Ticket {
	private int ticketno;
	private String price;
	private String type;
	@DateTimeFormat
	private Date days;
	private String branch;
}
