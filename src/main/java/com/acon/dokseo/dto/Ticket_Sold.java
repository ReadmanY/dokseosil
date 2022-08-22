package com.acon.dokseo.dto;

import java.util.Date;

import lombok.Data;


/*
+-------------+--------------+------+-----+-------------------+-------------------+
| Field       | Type         | Null | Key | Default           | Extra             |
+-------------+--------------+------+-----+-------------------+-------------------+
| sold_no     | int          | NO   | PRI | NULL              | auto_increment    |
| sold_id     | varchar(255) | NO   | MUL | NULL              |                   |
| sold_price  | int          | YES  |     | NULL              |                   |
| sold_branch | int          | NO   | MUL | NULL              |                   |
| sold_ticket | int          | NO   | MUL | NULL              |                   |
| sold_date   | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| sold_type   | int          | NO   |     | NULL              |                   |
| sold_active | tinyint(1)   | YES  |     | 1                 |                   |
| expire_date | datetime     | YES  |     | NULL              |                   |
| remain_days | int          | YES  |     | NULL              |                   |
+-------------+--------------+------+-----+-------------------+-------------------+
*/

@Data
public class Ticket_Sold {
	private int sold_no;
	private String sold_id;
	private int sold_price;
	private int sold_branch;
	private int sold_ticket;
	private Date sold_date;
	private int sold_type;
	private boolean sold_active;
	private Date expire_date;
	private int remain_days;
}
