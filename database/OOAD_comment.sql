CREATE TABLE OOAD.comment
(
    comment_id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    course_id int(11) NOT NULL,
    user_id int(11) NOT NULL,
    content varchar(200) NOT NULL,
    username varchar(20) NOT NULL,
    create_time datetime DEFAULT '1970-01-01 00:00:00' NOT NULL,
    coursename varchar(100) NOT NULL
);
CREATE UNIQUE INDEX comment_comment_id_uindex ON OOAD.comment (comment_id);
INSERT INTO OOAD.comment (comment_id, course_id, user_id, content, username, create_time, coursename) VALUES (1, 1, 1, 'Great!!
', 'xiaohuang', '2017-06-04 00:00:00', 'Object-Oriented Analysis and Design');
INSERT INTO OOAD.comment (comment_id, course_id, user_id, content, username, create_time, coursename) VALUES (2, 1, 3, 'Awesome~
', 'aaa', '2018-03-06 05:02:00', 'Object-Oriented Analysis and Design');
INSERT INTO OOAD.comment (comment_id, course_id, user_id, content, username, create_time, coursename) VALUES (3, 2, 2, 'Wowwwwww!!', 'xiaohuang', '2018-09-23 22:38:36', 'Statistical Methods for Data Science');