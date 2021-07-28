	--creates person_database
	CREATE DATABASE person_database
    WITH
    OWNER = postgres
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;




	--adds table to person_database
	CREATE TABLE country(
		id SERIAL PRIMARY KEY NOT NULL,
		code VARCHAR (3) NOT NULL,
		name VARCHAR (150) NOT NULL,
		dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL
	);

	CREATE TABLE person(
		id SERIAL PRIMARY KEY NOT NULL,
	  	identifier VARCHAR(13) NOT NULL,
	  	passport BOOLEAN	NOT NULL,
	  	firstName VARCHAR (255) NOT NULL,
	  	secondName VARCHAR (255) NOT NULL,
	  	thirdName VARCHAR (255) NOT NULL,
	 	surname VARCHAR (255) NOT NULL,
		dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL,
	  	fk_country_id INT NOT NULL REFERENCES country(id)
	);

	CREATE TABLE address_type(
		id SERIAL PRIMARY KEY NOT NULL,
		code VARCHAR (20) NOT NULL,
		description VARCHAR (255) NOT NULL,
	  	dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL
	);

	CREATE TABLE address(
		id SERIAL PRIMARY KEY NOT NULL,
	  	line1 VARCHAR (255) NOT NULL,
	  	line2 VARCHAR  (255) NOT NULL,
	  	line3 VARCHAR (255) NOT NULL,
	  	line4 VARCHAR (255) NOT NULL,
	  	postal_code VARCHAR (10) NOT NULL,
	 	dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL,
	  	fk_address_type_id INT REFERENCES address_type(id)
	);

	CREATE TABLE person_address(
		id SERIAL PRIMARY KEY NOT NULL,
		dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL,
		fk_person_id INT NOT NULL REFERENCES person(id),
	  	fk_address_id INT NOT NULL REFERENCES address(id)
	);

	CREATE TABLE telephone_type(
		id SERIAL PRIMARY KEY NOT NULL,
		code VARCHAR (20) NOT NULL,
		description VARCHAR (255) not null,
	  	dateCreated TIMESTAMP NOT NULL,
		dateModified TIMESTAMP NOT NULL
	);

	CREATE TABLE telephone(
		id SERIAL PRIMARY KEY NOT NULL,
	  	number VARCHAR  (15) NOT NULL,
	  	dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL,
	  	fk_telephone_type_id INT REFERENCES telephone_type(id)
	);

	CREATE TABLE person_telephone(
		id SERIAL PRIMARY KEY NOT NULL,
		is_current BOOLEAN NOT NULL,
		dateCreated TIMESTAMP NOT NULL DEFAULT NOW(),
		dateModified TIMESTAMP NOT NULL,
		fk_person_id INT NOT NULL REFERENCES person(id),
	  	fk_telephone_id INT NOT NULL REFERENCES telephone(id)
	);

