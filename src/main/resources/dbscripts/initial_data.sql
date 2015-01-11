Insert into users (login,name,last_name,email,mobile,password) values('admin','Adam','Adminowicz','adm@adm.pl','999-999-999','$2a$10$YgqLV1teWqr6ubACzSX8yusr7iMGYB65pPZjDtGVrBs.mb7B8K2Qu');
insert into doctor(name,last_name) values('Lekarz','Pierwszy');
insert into doctor(name,last_name) values('Lekarz','Drugi');
insert into appointment(user_id,doctor_id,app_Date) values(1,1,'2015-01-02 11:00:00'); 

insert into role (name) values('ROLE_ADMIN');
insert into role (name) values('ROLE_USER');

insert into user_role (user_id,role_id) values (1,1);
insert into user_role (user_id,role_id) values (1,2);