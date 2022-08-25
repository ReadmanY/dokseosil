package com.acon.dokseo.dto;

import lombok.Data;

/*
+-------------+--------------+------+-----+---------+----------------+
| Field       | Type         | Null | Key | Default | Extra          |
+-------------+--------------+------+-----+---------+----------------+
| seat_no     | int          | NO   | PRI | NULL    | auto_increment |
| seat_branch | int          | NO   | MUL | NULL    |                |
| seat_bno    | int          | NO   |     | NULL    |                |
| seat_filled | tinyint(1)   | NO   |     | 0       |                |
| seat_user   | varchar(255) | YES  | MUL | NULL    |                |
+-------------+--------------+------+-----+---------+----------------+
*/

@Data
public class Seats {
	private int seat_no;
	private int seat_branch;
	private int seat_bno;
	private boolean seat_filled;
	private String seat_user;
}
