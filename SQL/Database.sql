--------------------------------------------------------
--  File created - œroda-marzec-16-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ADDRESS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."ADDRESS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 64 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CASEEVIDENCE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."CASEEVIDENCE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 4 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence CASEMEMBERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."CASEMEMBERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 64 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OFFICERNOTES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."OFFICERNOTES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 4 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OFFICER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."OFFICER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 24 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence PERSON_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."PERSON_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 64 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence POLICECASE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."POLICECASE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 24 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence STATE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "PROJEKTINZYNIERIA"."STATE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 44 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table ADDRESS
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."ADDRESS" 
   (	"ID" NUMBER(9,0), 
	"CITY" VARCHAR2(50 BYTE), 
	"STREET" VARCHAR2(50 BYTE), 
	"HOUSE" VARCHAR2(50 BYTE), 
	"POSTALCODE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CASE_EVIDENCE
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."CASE_EVIDENCE" 
   (	"ID" NUMBER(9,0), 
	"CASE_ID" NUMBER(9,0), 
	"FILE_PATH" VARCHAR2(500 BYTE), 
	"FILE_TYPE" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CASE_MEMBERS
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."CASE_MEMBERS" 
   (	"ID" NUMBER(9,0), 
	"CASE_ID" NUMBER(9,0), 
	"PERSON_ID" NUMBER(9,0), 
	"MEMBER_TYPE" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table OFFICER
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."OFFICER" 
   (	"ID" NUMBER(9,0), 
	"PERSON_ID" NUMBER(9,0), 
	"ACC_TYPE" VARCHAR2(20 BYTE), 
	"POLICE_RANK" VARCHAR2(50 BYTE), 
	"LOGIN" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table OFFICER_NOTES
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."OFFICER_NOTES" 
   (	"ID" NUMBER(9,0), 
	"NOTE" CLOB, 
	"NOTE_HEADER" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("NOTE") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table PERSON
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."PERSON" 
   (	"ID" NUMBER(9,0), 
	"FIRSTNAME" VARCHAR2(50 BYTE), 
	"SECONDNAME" VARCHAR2(50 BYTE), 
	"AGE" NUMBER(3,0), 
	"ADDRESS_ID" NUMBER(9,0), 
	"PHONENUMBER" NUMBER(12,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table POLICECASE
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."POLICECASE" 
   (	"ID" NUMBER(9,0), 
	"OFFICER_ID" NUMBER(9,0), 
	"HEADER" CLOB, 
	"DESCRIPTION" CLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" 
 LOB ("HEADER") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) 
 LOB ("DESCRIPTION") STORE AS BASICFILE (
  TABLESPACE "SYSTEM" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table STATE
--------------------------------------------------------

  CREATE TABLE "PROJEKTINZYNIERIA"."STATE" 
   (	"ID" NUMBER(2,0), 
	"CASE_ID" NUMBER(9,0), 
	"VAL" VARCHAR2(50 BYTE), 
	"STATUS_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for View FULL_CASE_MEMBERS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "PROJEKTINZYNIERIA"."FULL_CASE_MEMBERS" ("ID", "CASE_ID", "MEMBER_TYPE", "FIRSTNAME", "SECONDNAME", "AGE", "PHONENUMBER", "CITY", "STREET", "HOUSE", "POSTALCODE") AS 
  SELECT C.ID,C.CASE_ID,C.MEMBER_TYPE,P.FIRSTNAME,P.SECONDNAME,P.AGE,P.PHONENUMBER,A.CITY,A.STREET,A.HOUSE,A.POSTALCODE
  FROM
    CASE_MEMBERS C JOIN PERSON P ON C.PERSON_ID = P.ID
    JOIN ADDRESS A ON P.ADDRESS_ID = A.ID;
--------------------------------------------------------
--  DDL for View FULL_OFFICER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "PROJEKTINZYNIERIA"."FULL_OFFICER" ("ID", "LOGIN", "PASSWORD", "POLICE_RANK", "ACC_TYPE", "FIRSTNAME", "SECONDNAME", "AGE", "PHONENUMBER", "CITY", "STREET", "HOUSE", "POSTALCODE") AS 
  SELECT O.ID,O.LOGIN,O.PASSWORD,O.POLICE_RANK,O.ACC_TYPE,P.FIRSTNAME,P.SECONDNAME,P.AGE,P.PHONENUMBER,A.CITY,A.STREET,A.HOUSE,A.POSTALCODE 
    FROM OFFICER O join PERSON P on O.PERSON_ID = P.ID
    join ADDRESS A on P.ADDRESS_ID  = A.ID;
--------------------------------------------------------
--  DDL for View FULL_PERSON
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "PROJEKTINZYNIERIA"."FULL_PERSON" ("ID", "FIRSTNAME", "SECONDNAME", "AGE", "PHONENUMBER", "CITY", "STREET", "HOUSE", "POSTALCODE") AS 
  SELECT P.ID,P.FIRSTNAME,P.SECONDNAME,P.AGE,P.PHONENUMBER, A.CITY,A.STREET,A.HOUSE,A.POSTALCODE FROM PERSON P join ADDRESS A on P.ADDRESS_ID = A.ID;
REM INSERTING into PROJEKTINZYNIERIA.ADDRESS
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('1','Kielce','Nowowiejska','22/196','25-512');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('2','Smyków','Œwiêtokrzyskasdasdasdasd','103','22');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('6','Krolewiec','Krolewiecka','103a','26-212');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('9','TEST','TEST','TEST','TEST');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('8','TEST','TEST','TEST','TEST');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('10','asda','asdasd','asdads','asdasd');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('11','t','t','t','t');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('12','asdads','asdasd','adasda','12');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('13','Kielce','Jagiellonska','15/122','12-221');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('24','Smyków','Œwiêtokrzyskasdasdasdasd','103','22');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('25','cc','dd','ee','ff');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('26','CCC','DDD','d','e');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('27','a','a','a','b');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('28','cc','aa','dd','ee');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('29','s','d','e','f');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('30','cada','dad','adad','adad');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('31','s','d','e','f');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('32','aa','aa','aa','aa');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('33','aa','aa','aaa','aaa');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('36','c','d','e','f');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('38','c','de','e','f');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('39','c','de','ee','fff');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('40','b','c','d','e');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('41','aaa','aaa','aaa','aaaa');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('42','aaa','aaa','aaa','aaaa');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('43','Smyków','Œwiêtokrzyskasdasdasdasd','103','22');
Insert into PROJEKTINZYNIERIA.ADDRESS (ID,CITY,STREET,HOUSE,POSTALCODE) values ('44','Smykoska Górka','-','103','26-212');
REM INSERTING into PROJEKTINZYNIERIA.CASE_EVIDENCE
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.CASE_EVIDENCE (ID,CASE_ID,FILE_PATH,FILE_TYPE) values ('1','1','E:\p.png','image');
REM INSERTING into PROJEKTINZYNIERIA.CASE_MEMBERS
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('24','2','24','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('29','10','30','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('28','9','29','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('30','11','31','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('31','11','32','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('32','11','33','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('38','13','36','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('41','9','29','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('42','9','38','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('43','8','39','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('44','8','39','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('45','8','39','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('46','8','39','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('47','9','29','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('48','9','29','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('49','9','38','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('50','2','43','Victim');
Insert into PROJEKTINZYNIERIA.CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE) values ('51','2','44','Victim');
REM INSERTING into PROJEKTINZYNIERIA.OFFICER
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.OFFICER (ID,PERSON_ID,ACC_TYPE,POLICE_RANK,LOGIN,PASSWORD) values ('1','1','Supervisor','Deputy Sheriff','b','haslo');
REM INSERTING into PROJEKTINZYNIERIA.OFFICER_NOTES
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.OFFICER_NOTES (ID,NOTE_HEADER) values ('1','Moja pierwsza notka');
Insert into PROJEKTINZYNIERIA.OFFICER_NOTES (ID,NOTE_HEADER) values ('3','note_header');
Insert into PROJEKTINZYNIERIA.OFFICER_NOTES (ID,NOTE_HEADER) values ('13','note_header');
REM INSERTING into PROJEKTINZYNIERIA.PERSON
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('1','Bartosz','Surma','23','1','81231231');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('24','Aa','Bunczitta','11','24','131231313');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('29','B','a','0','29','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('31','b','a','0','31','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('30','aa','bbcc','0','30','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('32','a','a','0','32','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('33','aaa','aaa','0','33','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('36','a','b','0','36','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('38','a','b','0','38','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('39','a','b','0','39','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('40','celina','a','0','40','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('41','aaa','aaa','0','41','0');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('42','aaa','aaa','16','42','889077654');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('43','Aa','Buncazitta','11','43','131231313');
Insert into PROJEKTINZYNIERIA.PERSON (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values ('44','Bartunio','aaa','14','44','777000333');
REM INSERTING into PROJEKTINZYNIERIA.POLICECASE
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('1','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('2','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('10','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('11','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('12','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('13','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('8','1');
Insert into PROJEKTINZYNIERIA.POLICECASE (ID,OFFICER_ID) values ('9','1');
REM INSERTING into PROJEKTINZYNIERIA.STATE
SET DEFINE OFF;
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('1','1','In Progress',to_date('2016/01/21  17:45:56','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('2','1','Completed',to_date('2016/01/25  12:38:49','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('4','2','Suspended',to_date('2016/01/06  12:51:19','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('24','2','In Progress',to_date('2016/01/31  19:08:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('26','8','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('27','9','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('28','10','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('29','11','In Progress',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('30','12','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('34','13','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('36','9','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('37','8','Completed',to_date('2016/01/31  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('38','8','In Progress',to_date('2016/02/01  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('39','8','In Progress',to_date('2016/02/01  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('40','9','Suspended',to_date('2016/02/01  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
Insert into PROJEKTINZYNIERIA.STATE (ID,CASE_ID,VAL,STATUS_DATE) values ('41','2','Suspended',to_date('2016/02/01  00:00:00','YYYY/MM/DD  HH24:MI:SS'));
--------------------------------------------------------
--  Constraints for Table CASE_MEMBERS
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_MEMBERS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_MEMBERS" ADD CONSTRAINT "CHK_MEMBER" CHECK (member_type IN 
  ('Victim','Suspect','Witness')) ENABLE;
--------------------------------------------------------
--  Constraints for Table ADDRESS
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."ADDRESS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table OFFICER_NOTES
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."OFFICER_NOTES" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."OFFICER_NOTES" MODIFY ("NOTE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table POLICECASE
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."POLICECASE" MODIFY ("OFFICER_ID" NOT NULL ENABLE);
  ALTER TABLE "PROJEKTINZYNIERIA"."POLICECASE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PERSON
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."PERSON" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CASE_EVIDENCE
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_EVIDENCE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_EVIDENCE" ADD CONSTRAINT "CHK_FILETYPE" CHECK (file_type IN 
  ('video','document','image')) ENABLE;
--------------------------------------------------------
--  Constraints for Table STATE
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."STATE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."STATE" ADD CONSTRAINT "CHK_VAL" CHECK (VAL IN ('In Progress', 'Completed', 'Suspended')) ENABLE;
--------------------------------------------------------
--  Constraints for Table OFFICER
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."OFFICER" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."OFFICER" ADD CONSTRAINT "CHK_TYPE" CHECK (ACC_TYPE IN 
  ('Supervisor','Standard')) ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."OFFICER" ADD CONSTRAINT "CHK_RANK" CHECK (POLICE_RANK IN 
  ('Sheriff', 'Undersheriff', 'Captain','Sergeant','Corporal','Deputy Sheriff')) ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CASE_EVIDENCE
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_EVIDENCE" ADD FOREIGN KEY ("CASE_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."POLICECASE" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CASE_MEMBERS
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_MEMBERS" ADD FOREIGN KEY ("CASE_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."POLICECASE" ("ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "PROJEKTINZYNIERIA"."CASE_MEMBERS" ADD FOREIGN KEY ("PERSON_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."PERSON" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OFFICER
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."OFFICER" ADD FOREIGN KEY ("PERSON_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."PERSON" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PERSON
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."PERSON" ADD FOREIGN KEY ("ADDRESS_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."ADDRESS" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table POLICECASE
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."POLICECASE" ADD FOREIGN KEY ("OFFICER_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."OFFICER" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table STATE
--------------------------------------------------------

  ALTER TABLE "PROJEKTINZYNIERIA"."STATE" ADD FOREIGN KEY ("CASE_ID")
	  REFERENCES "PROJEKTINZYNIERIA"."POLICECASE" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  DDL for Trigger ADDRESS_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."ADDRESS_TRG1" 
          before insert on ADDRESS
          for each row
          begin
              if :new.id is null then
                  select address_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."ADDRESS_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger CASEEVIDENCE_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."CASEEVIDENCE_TRG1" 
          before insert on CASE_EVIDENCE
          for each row
          begin
              if :new.id is null then
                  select caseevidence_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."CASEEVIDENCE_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger CASEMEMBERS_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."CASEMEMBERS_TRG1" 
          before insert on PERSON
          for each row
          begin
              if :new.id is null then
                  select casemembers_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."CASEMEMBERS_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FULLCASEMEMBERS_TRG2
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."FULLCASEMEMBERS_TRG2" 
  instead of insert on FULL_CASE_MEMBERS
  for each row
  declare
  vperson number(9);
  vaddress number(9);
  begin
    SELECT P.ID  INTO vperson FROM PERSON P JOIN ADDRESS A ON P.ADDRESS_ID = A.ID
    WHERE
      P.FIRSTNAME = :new.firstname and
      P.SECONDNAME = :new.secondname and
      P.AGE = :new.age and
      P.PHONENUMBER = :new.phonenumber and
      A.CITY = :new.city and
      A.STREET  = :new.street and
      A.HOUSE = :new.house and 
      A.POSTALCODE = :new.postalcode;
  INSERT INTO CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE)
    VALUES(casemembers_seq.nextval,:new.case_id,vperson,:new.member_type);
    EXCEPTION WHEN NO_DATA_FOUND
      THEN  
        INSERT INTO ADDRESS(ID,CITY,STREET,HOUSE,POSTALCODE) VALUES (address_seq.nextval,:new.city,:new.street,:new.house,:new.postalcode);
        INSERT INTO PERSON(ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) 
          VALUES(person_seq.nextval,:new.firstname,:new.secondname,:new.age,address_seq.currval,:new.phonenumber);
        INSERT INTO CASE_MEMBERS (ID,CASE_ID,PERSON_ID,MEMBER_TYPE)
         VALUES(casemembers_seq.nextval,:new.case_id,person_seq.currval,:new.member_type);
  end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."FULLCASEMEMBERS_TRG2" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FULLOFFICER_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."FULLOFFICER_TRG" 
  instead of insert on FULL_OFFICER
  for each row
  begin
    insert into address (id,city,street,house,postalcode) values (address_seq.nextval,:new.city,:new.street,:new.house,:new.postalcode);
    insert into person (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values (person_seq.nextval,:new.firstname,:new.secondname,:new.age,address_seq.currval,:new.phonenumber);
    insert into officer (ID,PERSON_ID,ACC_TYPE,POLICE_RANK,LOGIN,PASSWORD) values (officer_seq.nextval,person_seq.currval,:new.acc_type,:new.police_rank,:new.login,:new.password);
  end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."FULLOFFICER_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FULLOFFICER_TRG2
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."FULLOFFICER_TRG2" 
  instead of update on FULL_OFFICER
  for each row
  declare
  vperson number(9);
  vaddress number(9);
  begin
    SELECT person_id into vperson from officer where id = :new.id;
    SELECT address_id into vaddress from person where id = vperson; 
    
    update OFFICER
      set
        ACC_TYPE = :new.acc_type,
        POLICE_RANK = :new.police_rank,
        LOGIN = :new.login,
        PASSWORD = :new.password
      where
        id = :new.id;
    update PERSON 
      set
        FIRSTNAME = :new.firstname,
        SECONDNAME = :new.secondname,
        AGE = :new.age,
        PHONENUMBER = :new.phonenumber
      where 
        ID = vperson;
    update ADDRESS
      set
        CITY = :new.city,
        STREET = :new.street,
        HOUSE = :new.house,
        POSTALCODE = :new.postalcode
      where
        ID = vaddress;

  end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."FULLOFFICER_TRG2" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FULLPERSON_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."FULLPERSON_TRG" 
  instead of insert on FULL_PERSON
  for each row
  begin
    insert into address (id,city,street,house,postalcode) values (address_seq.nextval,:new.city,:new.street,:new.house,:new.postalcode);
    insert into person (ID,FIRSTNAME,SECONDNAME,AGE,ADDRESS_ID,PHONENUMBER) values (person_seq.nextval,:new.firstname,:new.secondname,:new.age,address_seq.currval,:new.phonenumber);
  end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."FULLPERSON_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger FULLPERSON_TRG2
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."FULLPERSON_TRG2" 
  instead of update on FULL_PERSON
  for each row
  declare
  v number(9);
  begin
    SELECT address_id into v from person where id = :new.id; 
    update person 
      set
        FIRSTNAME = :new.firstname,
        SECONDNAME = :new.secondname,
        AGE = :new.age,
        PHONENUMBER = :new.phonenumber
      where 
        ID = :new.id;
    update address
      set
        CITY = :new.city,
        STREET = :new.street,
        HOUSE = :new.house,
        POSTALCODE = :new.postalcode
      where
        ID = v;
  end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."FULLPERSON_TRG2" ENABLE;
--------------------------------------------------------
--  DDL for Trigger OFFICERNOTES_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."OFFICERNOTES_TRG1" 
          before insert on OFFICER_NOTES
          for each row
          begin
              if :new.id is null then
                  select officernotes_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."OFFICERNOTES_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger OFFICER_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."OFFICER_TRG1" 
          before insert on OFFICER
          for each row
          begin
              if :new.id is null then
                  select officer_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."OFFICER_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger PERSON_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."PERSON_TRG1" 
          before insert on PERSON
          for each row
          begin
              if :new.id is null then
                  select person_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."PERSON_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger POLICECASE_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."POLICECASE_TRG1" 
          before insert on POLICECASE
          for each row
          begin
              if :new.id is null then
                  select policecase_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."POLICECASE_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger STATE_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PROJEKTINZYNIERIA"."STATE_TRG1" 
          before insert on STATE
          for each row
          begin
              if :new.id is null then
                  select state_seq.nextval into :new.id from dual;
             end if;
          end;
/
ALTER TRIGGER "PROJEKTINZYNIERIA"."STATE_TRG1" ENABLE;
