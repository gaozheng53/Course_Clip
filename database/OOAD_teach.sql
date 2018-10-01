CREATE TABLE OOAD.teach
(
    teach_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_id int(11) NOT NULL,
    professor_name varchar(50) NOT NULL,
    professor_link varchar(1000) NOT NULL
);
CREATE UNIQUE INDEX teach_teach_id_uindex ON OOAD.teach (teach_id);
INSERT INTO OOAD.teach (teach_id, course_id, professor_id) VALUES (1, 1, 'who am I?', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_id) VALUES (2, 1, 'who is she?', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_id) VALUES (3, 2, 'who am I?', 'https://www.utdallas.edu');
INSERT INTO OOAD.teach (teach_id, course_id, professor_id) VALUES (4, 2, 'who is she?', 'https://www.utdallas.edu');