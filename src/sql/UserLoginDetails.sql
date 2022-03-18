CREATE TABLE event_project.user_login_details (
	first_name varchar NOT NULL,
	last_name varchar NULL,
	email_id varchar NOT NULL,
	"password" varchar NOT NULL,
	mobile_num varchar NOT NULL,
	alternate_mobile_num varchar NULL,
	user_id bigint NOT NULL,
	CONSTRAINT user_login_details_pk PRIMARY KEY (user_id),
	CONSTRAINT user_login_details_un UNIQUE (email_id)
);
