--INDEXES
--Person
CREATE INDEX idx_person_identifier
ON person (identifier);

CREATE INDEX idx_person_first_name
ON person (firstName);

CREATE INDEX idx_person_surname
ON person (surname);


--address 
CREATE INDEX idx_address_fullAddress
ON address (line1, line2, line3, line4);


--Telephone
CREATE INDEX idx_telephone_number
ON telephone (number);