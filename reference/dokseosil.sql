DROP DATABASE READ_ROOM;

CREATE DATABASE READ_ROOM;

DROP USER 'room_admin'@'localhost';
CREATE USER 'room_admin'@'localhost' IDENTIFIED WITH mysql_native_password by 'group1';
GRANT SELECT, INSERT, UPDATE, DELETE on SPRING_BOARD.* to 'room_admin'@'localhost';

USE READ_ROOM;

CREATE TABLE USER(
    user_no INT AUTO_INCREMENT,
    user_id VARCHAR(255),
	user_name VARCHAR(255),
	user_pw VARCHAR(255) NOT NULL,
	user_phone VARCHAR(255) NOT NULL,
	user_email VARCHAR(255) NOT NULL,
	user_birth DATE, #change to can null
    user_gender tinyint, #gender male=0, female=1, etc=2, nodata=null 
	user_signuptime DATETIME DEFAULT CURRENT_TIMESTAMP(),
    is_admin BOOLEAN default false,
    branch_admin INT,
	CONSTRAINT PRIMARY KEY(user_id),
	CONSTRAINT UNIQUE KEY(user_no),
	CONSTRAINT UNIQUE KEY(user_phone),
	CONSTRAINT UNIQUE KEY(user_email)
);

CREATE TABLE BRANCH(
    branch_no INT AUTO_INCREMENT,	
    branch_name VARCHAR(255),
    branch_all_seat INT NOT NULL,
    branch_filled_seat INT NOT NULL DEFAULT 0,
    CONSTRAINT PRIMARY KEY(branch_no),
    CONSTRAINT UNIQUE KEY(branch_name)
);

CREATE TABLE SEATS(
    seat_no INT AUTO_INCREMENT,
    seat_branch INT NOT NULL,
    seat_bno INT NOT NULL,
    seat_filled BOOLEAN NOT NULL DEFAULT false,
    seat_user VARCHAR(255),
	CONSTRAINT PRIMARY KEY(seat_no),
    FOREIGN KEY(seat_user) REFERENCES USER(user_id),
    FOREIGN KEY(seat_branch) REFERENCES BRANCH(branch_no)
    ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT UNIQUE KEY(seat_branch, seat_bno)
);

CREATE TABLE ENTER_CHK(
    enter_no INT AUTO_INCREMENT,
    enter_id VARCHAR(255),
    enter_branch INT,
    enter_seat INT,
    enter_time DATETIME DEFAULT CURRENT_TIMESTAMP(),
    leave_time DATETIME,
    CONSTRAINT PRIMARY KEY(enter_no),
    FOREIGN KEY(enter_seat) REFERENCES SEATS(seat_no)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TICKET(
    ticket_no INT AUTO_INCREMENT,
    ticket_price INT NOT NULL,
    ticket_type BOOLEAN NOT NULL,
    ticket_days INT NOT NULL,
    ticket_branch INT NOT NULL,
    CONSTRAINT PRIMARY KEY(ticket_no),
    FOREIGN KEY(ticket_branch) REFERENCES BRANCH(branch_no)
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TICKET_SOLD(
    sold_no INT AUTO_INCREMENT,
    sold_id VARCHAR(255) NOT NULL,
    sold_price INT,
    sold_branch INT NOT NULL,
    sold_ticket INT NOT NULL,
    sold_date DATETIME DEFAULT CURRENT_TIMESTAMP(),
    sold_type INT NOT NULL,
    sold_active BOOLEAN DEFAULT true,
    expire_date DATETIME,
    remain_days INT,
    CONSTRAINT PRIMARY KEY(sold_no),
    FOREIGN KEY(sole_id) REFERENCES USER(user_id),
    FOREIGN KEY(sold_ticket) REFERENCES TICKET(ticket_no),
    FOREIGN KEY(sold_branch) REFERENCES BRANCH(branch_no)	#BRANCH_NO 참조 추가
    ON UPDATE CASCADE ON DELETE CASCADE
);

ALTER TABLE USER ADD FOREIGN KEY(user_ticket)
REFERENCES TICKET_BUY(sold_no)
ON UPDATE CASCADE ON DELETE CASCADE;