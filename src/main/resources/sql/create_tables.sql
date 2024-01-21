
DROP TABLE IF EXISTS student_courses;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS courses;

-- Create the 'groups' table
CREATE TABLE IF NOT EXISTS groups (
                                      group_id SERIAL PRIMARY KEY,
                                      group_name VARCHAR(255) NOT NULL
);

-- Create the 'courses' table
CREATE TABLE IF NOT EXISTS courses (
                                       course_id SERIAL PRIMARY KEY,
                                       course_name VARCHAR(255) NOT NULL,
                                       course_description TEXT
);

-- Create the 'students' table with a foreign key reference to 'groups'
CREATE TABLE IF NOT EXISTS students (
                                        student_id SERIAL PRIMARY KEY,
                                        group_id INT,
                                        first_name VARCHAR(255) NOT NULL,
                                        last_name VARCHAR(255) NOT NULL,
                                        FOREIGN KEY (group_id) REFERENCES groups(group_id)
);

-- Create the 'student_courses' table with composite primary key and foreign keys
CREATE TABLE IF NOT EXISTS student_courses (
                                               student_id INT,
                                               course_id INT,
                                               PRIMARY KEY (student_id, course_id),
                                               FOREIGN KEY (student_id) REFERENCES students(student_id),
                                               FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
