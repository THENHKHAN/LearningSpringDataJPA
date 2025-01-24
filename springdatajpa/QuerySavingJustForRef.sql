
-- show all tables in the myjpa db: 1st click on the desired db, click on New SQL Script and then type below.
SELECT * FROM pg_catalog.pg_tables
	WHERE schemaname != 'pg_catalog' AND
   	      schemaname != 'information_schema';


-- student Entity
SELECT * FROM public.jpa_students;



-- laptop Entity

SELECT * FROM public.jpa_laptops;