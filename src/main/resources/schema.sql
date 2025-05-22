use npo1;

drop table if exists charity_member ;
drop table if exists `member`;
DROP TABLE IF EXISTS event;
drop table if exists employee;
drop table if exists charity ;

/* Spring Security tables start */

CREATE TABLE if not exists `authority` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uc_unique_authority_name (`name`)
);

CREATE table if not exists `site_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_site_user_username` (`username`)
);


CREATE table if not exists `user_authorities` (
  `user_id` bigint NOT NULL,
  `authority_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  CONSTRAINT `uc_ua_authority_id` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `uc_ua_user_id` FOREIGN KEY (`user_id`) REFERENCES `site_user` (`id`)
);

/* Spring Security tables end */

CREATE table if not exists MEMBER(
	id bigint PRIMARY KEY auto_increment,
	first_name varchar(100) NOT null,
	last_name varchar(100),
	dob date NOT null,
	email varchar(180),
	created_date datetime,
	created_by varchar(100),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE if not exists charity (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    registration_number VARCHAR(50) UNIQUE NOT NULL,
    contact_email VARCHAR(100),
    phone_number VARCHAR(20),
    address TEXT,
    website VARCHAR(255),
    established_date DATE,
    mission TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


create table if not exists charity_member(
	charity_id bigint not null,
	member_id bigint not null,
	foreign key (charity_id) references CHARITY(id),
	foreign key (MEMBER_ID) references member(id)
);

-- employees of the charity
CREATE TABLE if not exists employee (
    id bigint AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone_number VARCHAR(20),
    hire_date DATE NOT NULL,
    job_title VARCHAR(100),
    department_id INT,
    salary DECIMAL(10, 2),
    manager_id bigint,
    charity_id bigint,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (charity_id) REFERENCES charity(id) ON DELETE SET NULL
);

CREATE TABLE if not exists event (
    event_id bigint AUTO_INCREMENT PRIMARY KEY,
    charity_id bigint NOT NULL,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    event_date DATE NOT NULL,
    location VARCHAR(255),
    goal_amount DECIMAL(12, 2),
    raised_amount DECIMAL(12, 2) DEFAULT 0.00,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (charity_id) REFERENCES charity(id) ON DELETE cascade -- delete events if a charity is deleted
);


