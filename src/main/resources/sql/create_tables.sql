GRANT ALL PRIVILEGES ON DATABASE school TO school_user;

DROP TABLE IF EXISTS student_courses;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS groups;

CREATE TABLE groups (
                        group_id SERIAL PRIMARY KEY,
                        group_name VARCHAR(10) NOT NULL
);

CREATE TABLE courses (
                         course_id SERIAL PRIMARY KEY,
                         course_name VARCHAR(255) NOT NULL,
                         course_description TEXT
);

CREATE TABLE students (
                          student_id SERIAL PRIMARY KEY,
                          group_id INT,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          FOREIGN KEY (group_id) REFERENCES groups(group_id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE student_courses (
                                 student_id INT,
                                 course_id INT,
                                 PRIMARY KEY (student_id, course_id),
                                 FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
                                 FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);
