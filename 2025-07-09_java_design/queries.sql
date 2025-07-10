/*

Query 1: Display the top 3 students with highest GPA.
        

-- 1. Teachers Table Fields
(
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

-- 2. Students Table Fields
 (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    enrollment_year YEAR,
    email VARCHAR(100) UNIQUE
);

-- 3. Courses Table Fields
 (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    credits INT,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);

-- 4. Results Table Fileds
 (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    grade CHAR(2),
    semester VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

  Sample output:
  --------------
student_id	name	gpa
12	Deepika Ghosh	3.85
4	Aditi Singh	3.85
15	Harsh Vardhan	3.65


*/

use fstest;

-- select s.student_id, s.name, avg(r.grade) as gpa
-- from students s
-- join results r on s.student_id = r.student_id
-- group by r.student_id
select * from results
----------------------------------------------------------------------------------------------------------------
/*

Query 2: Find the course that has the highest number of students enrolled.


-- 1. Teachers Table Fields
(
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

-- 2. Students Table Fields
 (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    enrollment_year YEAR,
    email VARCHAR(100) UNIQUE
);

-- 3. Courses Table Fields
 (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    credits INT,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);

-- 4. Results Table Fileds
 (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    grade CHAR(2),
    semester VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

Sample output:
--------------
course_id	course_name	student_count
1	Data Structures	2



*/

use fstest;

select c.course_id, c.course_name, count(r.student_id) as student_count
from courses c
join results r on c.course_id = r.course_id
group by c.course_id
order by student_count desc
limit 1
/*
Query 3: List all students who have taken all the courses taught by teacher with ID 1.
-- 1. Teachers Table Fields
(
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    email VARCHAR(100) UNIQUE
);
-- 2. Students Table Fields
 (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    enrollment_year YEAR,
    email VARCHAR(100) UNIQUE
);
-- 3. Courses Table Fields
 (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    credits INT,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);
-- 4. Results Table Fileds
 (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    grade CHAR(2),
    semester VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);
  Sample output:
  --------------
student_id	name
1	Rohan Sharma
*/
use fstest;
select s.student_id, s.name
from students s
join results r on s.student_id = r.student_id
join courses c on r.course_id = c.course_id
where c.teacher_id=1
group by s.student_id, s.name
having count(distinct c.course_id) = (
    select count(distinct course_id)
    from courses
    where teacher_id = 1
)
/*

Query 4: Show semester-wise grade distribution for the course ‘Algorithms’.


-- 1. Teachers Table Fields
(
    teacher_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

-- 2. Students Table Fields
 (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    enrollment_year YEAR,
    email VARCHAR(100) UNIQUE
);

-- 3. Courses Table Fields
 (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    course_name VARCHAR(100),
    credits INT,
    teacher_id INT,
    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
);

-- 4. Results Table Fileds
 (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    grade CHAR(2),
    semester VARCHAR(10),
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

  Sample output:
  --------------
semester	grade	count
Fall2022	A+	1
Spring2023	B+	1


*/

use fstest;


