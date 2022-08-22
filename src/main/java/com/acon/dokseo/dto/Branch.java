package com.acon.dokseo.dto;

import lombok.Data;

/*
+--------------------+--------------+------+-----+---------+----------------+
| Field              | Type         | Null | Key | Default | Extra          |
+--------------------+--------------+------+-----+---------+----------------+
| branch_no          | int          | NO   | PRI | NULL    | auto_increment |
| branch_name        | varchar(255) | YES  | UNI | NULL    |                |
| branch_all_seat    | int          | NO   |     | NULL    |                |
| branch_filled_seat | int          | NO   |     | 0       |                |
+--------------------+--------------+------+-----+---------+----------------+
*/

@Data
public class Branch {
	private int branch_no;
	private String branch_name;
	private int branch_all_seat;
	private int branch_filled_seat;
}
