INSERT INTO users (user_name, password) VALUES ('somemail@dummy.com', '$2a$10$Wt4nCM3XL8PmKlKTMh8m5eiPNLQcg30vlYSQr5NDb6JlNdEETIOdi');
insert into roles (name) values ('ADMIN');
insert into user_role (user_id, role_id) values (1,1);

INSERT INTO department (department) VALUES('Desarrollo Productivo y Tecnologico');
INSERT INTO department (department) VALUES('Humanidades y Artes');
INSERT INTO department (department) VALUES('Planificacion y Politicas Publicas');
INSERT INTO department (department) VALUES('Salud Comunitaria');

INSERT INTO carrer(carrer, department_id) VALUES ('Licenciatura en sistemas',1);
INSERT INTO carrer(carrer, department_id) VALUES ('Licenciatura en audiovision',1);
INSERT INTO carrer(carrer, department_id) VALUES ('Licenciatura en trabajo social',3);
INSERT INTO carrer(carrer, department_id) VALUES ('Licenciatura en turismo',2);
INSERT INTO carrer(carrer, department_id) VALUES ('Licenciatura en musica de camara y sinfonica',2);

INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Matematica 1',1111,1);
INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Matematica 2',1112,1);
INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Matematica 3',1113,1);
INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Matematica discreta',1114,1);
INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Introduccion a recursos humanos',3331,3);
INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Planificacion pasajeros 1',4441,4);
INSERT INTO subject(subject, subject_code, carrer_id) VALUES ('Instrumentos de aire 1',5551,5);


