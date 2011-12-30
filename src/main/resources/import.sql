insert into gtdusers (id, username, password, fullname) values(1,'test','password','Full Name')
insert into gtdcontexts (id, name, gtduser_id, version) values (1,'Home',1,0)
insert into gtdcontexts (id, name, gtduser_id, version) values (2,'Work',1,0)
insert into gtdprojects (id, name, start_date, completed_date, gtduser_id, version) values (1,'Test Project','2011-12-26 00:00:00', '2011-12-28 00:00:00',1,0)
