package com.acon.dokseo.dto;

import lombok.Data;

/*
+---------------+------------+------+-----+---------+----------------+
| Field         | Type       | Null | Key | Default | Extra          |
+---------------+------------+------+-----+---------+----------------+
| ticket_no     | int        | NO   | PRI | NULL    | auto_increment |
| ticket_price  | int        | NO   |     | NULL    |                |
| ticket_type   | tinyint(1) | NO   |     | NULL    |                |
| ticket_days   | int        | NO   |     | NULL    |                |
| ticket_branch | int        | NO   | MUL | NULL    |                |
+---------------+------------+------+-----+---------+----------------+
*/

@Data
public class Ticket {
	private int ticket_no;
	private int ticket_price;
	private boolean ticket_type;
	private int ticket_days;
	private int ticket_branch;
}
