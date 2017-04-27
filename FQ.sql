DROP TABLE User_FQ, Session_Metadata, List_Metadata, Media, Question, Session_Content, List_Content, Scores, Answer, StatAnswer;
CREATE TABLE User_FQ(ID_User SERIAL PRIMARY KEY, First_Name VARCHAR(32) NOT NULL, Last_Name VARCHAR(32) NOT NULL, Login VARCHAR(32) UNIQUE NOT NULL, Password VARCHAR(32) NOT NULL, Rank INT NOT NULL);

CREATE TABLE Session_Metadata(ID_Session SERIAL PRIMARY KEY, ID_User INT NOT NULL, Opening_Date DATE NOT NULL, Closing_Date DATE NOT NULL, Type BOOL NOT NULL, Title VARCHAR(48) NOT NULL, Password VARCHAR(32) NOT NULL, FOREIGN KEY (ID_User) REFERENCES User_FQ (ID_User));

CREATE TABLE List_Metadata(ID_List SERIAL PRIMARY KEY, ID_User INT NOT NULL, Title VARCHAR(32) NOT NULL);

CREATE TABLE Media(ID_Media SERIAL PRIMARY KEY, Type INT NOT NULL, Content TEXT NOT NULL);

CREATE TABLE Question(ID_Question SERIAL PRIMARY KEY, Type INT NOT NULL, Content_Question TEXT NOT NULL, ID_Media INT NOT NULL, FOREIGN KEY (ID_Media) REFERENCES Media (ID_Media));

CREATE TABLE Session_Content(ID_Session INT NOT NULL, ID_List INT NOT NULL, FOREIGN KEY (ID_Session) REFERENCES Session_Metadata (ID_Session), FOREIGN KEY (ID_List) REFERENCES List_Metadata (ID_List));

CREATE TABLE List_Content(ID_List INT NOT NULL, ID_Question INT NOT NULL, FOREIGN KEY (ID_Question) REFERENCES Question (ID_Question), FOREIGN KEY (ID_List) REFERENCES List_Metadata (ID_List));

CREATE TABLE Scores(ID_Session INT PRIMARY KEY, ID_User INT NOT NULL, Score INT NOT NULL, FOREIGN KEY (ID_User) REFERENCES User_FQ (ID_User));

CREATE TABLE Answer(ID_Answer SERIAL PRIMARY KEY, ID_Question INT, Content TEXT, Correct BOOL NOT NULL, FOREIGN KEY (ID_Question) REFERENCES Question (ID_Question));

CREATE TABLE StatAnswer(ID_Session INT NOT NULL, ID_User INT NOT NULL, ID_Question INT NOT NULL, ID_Answer INT NOT NULL, Content_FreeAnswer TEXT NOT NULL, FOREIGN KEY (ID_Session) REFERENCES Session_Metadata (ID_Session), FOREIGN KEY (ID_User) REFERENCES User_FQ (ID_User), FOREIGN KEY (ID_Question) REFERENCES Question (ID_Question), FOREIGN KEY (ID_Answer) REFERENCES Answer (ID_Answer));
