CREATE TABLE OOAD.course
(
    course_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_name varchar(50) NOT NULL,
    course_number varchar(20) NOT NULL,
    description varchar(200),
    track varchar(30),
    comment_number mediumtext NOT NULL
);
CREATE UNIQUE INDEX course_course_id_uindex ON OOAD.course (course_id);
CREATE UNIQUE INDEX course_course_name_uindex ON OOAD.course (course_name);
CREATE UNIQUE INDEX course_course_number_uindex ON OOAD.course (course_number);
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (1, 'Object-Oriented Analysis and Design', '6359', ':)', '', '2');
INSERT INTO OOAD.course (course_id, course_name, course_number, description, track, comment_number) VALUES (2, 'Statistical Methods for Data Science', '6313', 'blabla', 'DS', '0');