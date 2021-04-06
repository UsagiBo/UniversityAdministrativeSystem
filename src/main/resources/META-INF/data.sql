/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  geusa
 * Created: Mar 27, 2021
 */

INSERT INTO students (ID, FullName, StudyYear) VALUES (1, 'Lilly Jane', 1);
INSERT INTO students (ID, FullName, StudyYear) VALUES (2, 'Keith Murphy', 3);
INSERT INTO students (ID, FullName, StudyYear) VALUES (3, 'Dwane Wane', 4);
INSERT INTO students (ID, FullName, StudyYear) VALUES (4, 'Anne Jhonson', 2);
INSERT INTO students (ID, FullName, StudyYear) VALUES (5, 'Vangie Mateo', 1);
INSERT INTO students (ID, FullName, StudyYear) VALUES (6, 'Silky Nutmeg Ganache', 4);

INSERT INTO teachers (ID, FullName, Title) VALUES (1, 'Jhon Murphy', 'Associate Professor');
INSERT INTO teachers (ID, FullName, Title) VALUES (2, 'Ellen Parton', 'PHD Student');

INSERT INTO subjects (ID, Credits, FullName, TeacherID) VALUES (1,15 ,'Algorithm Design', 1);
INSERT INTO subjects (ID, Credits, FullName, TeacherID) VALUES (2,7.5 ,'Parallel Programming', 2);

INSERT INTO enrollments (StudentID, SubjectID) VALUES (4,1);
INSERT INTO enrollments (StudentID, SubjectID) VALUES (6,1);
INSERT INTO enrollments (StudentID, SubjectID) VALUES (3,2);
INSERT INTO enrollments (StudentID, SubjectID) VALUES (5,2);

