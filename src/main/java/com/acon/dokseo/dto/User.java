package com.acon.dokseo.dto;

import java.util.Date;

import lombok.Data;

/*
+-----------------+--------------+------+-----+-------------------+-------------------+
| Field           | Type         | Null | Key | Default           | Extra             |
+-----------------+--------------+------+-----+-------------------+-------------------+
| user_no         | int          | NO   | UNI | NULL              | auto_increment    |
| user_id         | varchar(255) | NO   | PRI | NULL              |                   |
| user_name       | varchar(255) | YES  |     | NULL              |                   |
| user_pw         | varchar(255) | NO   |     | NULL              |                   |
| user_phone      | varchar(255) | NO   | UNI | NULL              |                   |
| user_email      | varchar(255) | NO   | UNI | NULL              |                   |
| user_birth      | date         | YES  |     | NULL              |                   |
| user_gender     | tinyint      | YES  |     | NULL              |                   |
| user_signuptime | datetime     | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| is_admin        | tinyint(1)   | YES  |     | 0                 |                   |
| branch_admin    | int          | YES  |     | NULL              |                   |
+-----------------+--------------+------+-----+-------------------+-------------------+
*/

@Data
public class User {
	private int user_no;
	private String user_name;
	private String user_pw;
	private String user_phone;
	private String user_email;
	private Date user_birth;		
	private	int user_gender;		// 0:남성, 1:여성, 2:그 외, null:무입력
	private Date user_signuptime;
	private boolean is_admin;
	private int branch_admin;		// 일반유저, 앱admin:null, 가맹점admin:가맹점 번호(branch_no)

}
