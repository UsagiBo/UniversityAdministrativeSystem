
DROP TABLE IF EXISTS Students;
CREATE TABLE Students (
    ID   INTEGER PRIMARY KEY ,
    FullName VARCHAR(255),
    StudyYear INTEGER
);

DROP TABLE IF EXISTS Teachers;
CREATE TABLE Teachers (
    ID  INTEGER PRIMARY KEY ,
    FullName  VARCHAR(255),
    Title VARCHAR(255)
);

DROP TABLE IF EXISTS Subjects;
CREATE TABLE Subjects (
    ID  INTEGER PRIMARY KEY,
    Credits  DOUBLE,
    FullName       VARCHAR(255),
    TeacherID INTEGER  NOT NULL,
    FOREIGN KEY (TeacherID) REFERENCES Teachers(ID)
);

DROP TABLE IF EXISTS Enrollments;
CREATE TABLE Enrollments (
    StudentID INTEGER REFERENCES Students (ID) ,
    SubjectID INTEGER REFERENCES Subjects (ID)
);