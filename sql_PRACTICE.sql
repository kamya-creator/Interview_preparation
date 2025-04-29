(SELECT CITY, LENGTH(CITY) AS LEN  FROM STATION ORDER BY LEN , CITY ASC LIMIT 1)
UNION
(SELECT CITY , LENGTH(CITY) AS LEN FROM STATION ORDER BY LEN DESC, CITY ASC LIMIT 1);



SELECT DISTINCT(CITY) FROM STATION WHERE CITY LIKE 'a%' or city LIKE 'e%'
OR CITY LIKE 'i%' OR CITY LIKE 'o%' OR CITY LIKE 'u%';


Query the list of CITY names from STATION which have vowels (i.e., a, e, i, o, and u)
 as both their first and last characters. Your result cannot contain duplicates.

SELECT DISTINCT(CITY) FROM STATION 
WHERE LOWER(LEFT(CITY, 1)) IN ('a', 'e' ,'i','o','u')
      AND
      LOWER(RIGHT(CITY, 1)) IN ('a', 'e' ,'i','o','u')
;      


Query the list of CITY names from STATION that do not start with vowels. Your result cannot contain duplicates.
SELECT DISTINCT(CITY) FROM STATION
WHERE CITY NOT IN (
    SELECT CITY FROM STATION WHERE LEFT(CITY, 1) IN ('A', 'E','I','O','U')
);

SELECT DISTINCT CITY FROM STATION 
WHERE CITY NOT IN
(SELECT CITY FROM STATION WHERE UPPER(RIGHT(CITY, 1)) IN ('A','E','I','O','U'));





Query the list of CITY names from STATION that either do not start with vowels or do not end with vowels. Your result cannot contain duplicates.

SELECT DISTINCT CITY FROM STATION 
WHERE CITY NOT IN (
SELECT CITY FROM STATION WHERE UPPER(LEFT(CITY, 1)) IN ('A','E','I','O','U')
)

UNION

SELECT DISTINCT CITY FROM STATION 
WHERE CITY NOT IN (
SELECT CITY FROM STATION WHERE UPPER(RIGHT(CITY, 1)) IN ('A','E','I','O','U')
)
;

Query the Name of any student in STUDENTS who scored higher than  Marks.
 Order your output by the last three characters of each name. 
 If two or more students both have names ending in the same last three characters 
 (i.e.: Bobby, Robby, etc.), secondary sort them by ascending ID.

SELECT NAME FROM STUDENTS WHERE MARKS > 75
ORDER BY (RIGHT(NAME, 3)) ASC , ID ASC;


Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.

Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
SELECT SUM(CITY.POPULATION) FROM CITY
LEFT JOIN 
COUNTRY ON CITY.COUNTRYCODE = COUNTRY.CODE
WHERE COUNTRY.CONTINENT='Asia';

Asia 693038
Europe 175138
Oceania 109189
South America 147435


Asia 693038
Europe 175138
Oceania 109190
South America 147435
Africa 274439