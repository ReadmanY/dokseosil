package com.acon.dokseo.dto;

import java.util.Date;

import lombok.Data;

/*
+--------------+--------------+------+-----+-------------------+-------------------+
| Field        | Type         | Null | Key | Default           | Extra             |
+--------------+--------------+------+-----+-------------------+-------------------+
| enter_no     | int          | NO   | PRI | NULL              | auto_increment    |
| enter_id     | varchar(255) | YES  |     | NULL              |                   |
| enter_branch | int          | YES  |     | NULL              |                   |
| enter_seat   | int          | YES  | MUL | NULL              |                   |
| enter_time   | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| leave_time   | datetime     | YES  |     | NULL              |                   |
+--------------+--------------+------+-----+-------------------+-------------------
*/

@Data
public class Enter_Chk {
	private int enter_no;
	private String enter_id;
	private int enter_branch;
	private int enter_seat;
	private Date enter_time;
	private Date leave_time;
}
