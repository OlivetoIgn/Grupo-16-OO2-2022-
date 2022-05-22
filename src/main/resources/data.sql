INSERT INTO users (user_name, password) VALUES ('somemail@dummy.com', '$2a$10$Wt4nCM3XL8PmKlKTMh8m5eiPNLQcg30vlYSQr5NDb6JlNdEETIOdi');
insert into roles (name) values ('ADMIN');
insert into user_role (user_id, role_id) values (1,1);