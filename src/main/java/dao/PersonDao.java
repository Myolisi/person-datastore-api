package dao;

import mapper.*;
import model.*;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.*;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface PersonDao {

    //get all telephone numbers for a user
    @SqlQuery(
            "SELECT distinct t.*, ttype.code \n" +
                    "FROM Person p " +
                    "JOIN Person_telephone pt \n" +
                    "ON pt.fk_person_id = p.id\n" +
                    "JOIN telephone t \n" +
                    "ON t.id = pt.fk_telephone_id \n" +
                    "JOIN telephone_type ttype \n" +
                    "ON ttype.id = t.fk_telephone_type_id \n" +
                    "Where p.id in(:user)\n" +
                    "group by t.id, ttype.id"
    )
    @RegisterRowMapper(TelephoneMapper.class)
    List<Telephone> getAllTelephones(@Bind("user") int user);

    //get all addresses for a user
    @SqlQuery(
            "SELECT distinct a.*, atype.code  \n" +
                    "FROM Person p " +
                    "JOIN Person_address pa ON pa.fk_person_id = p.id \n" +
                    "JOIN Address a ON a.id = pa.fk_address_id \n" +
                    "JOIN Address_type atype ON atype.id = a.fk_address_type_id\n" +
                    "Where p.id in(:user) \n" +
                    "group by a.id, atype.id"
    )
    @RegisterRowMapper(AddressMapper.class)
    List<Address> getAllAddresses(@Bind("user") int user);

    //get country
    @SqlQuery("SELECT distinct * FROM country c  " +
            "JOIN person p " +
            "ON p.fk_country_id = c.id \n" +
            "WHERE p.id in(:searchBy) " +
            "GROUP BY c.id, p.id " +
            "ORDER BY 1, 2 "
    )
    @RegisterRowMapper(CountryMapper.class)
    List<Country> getPersonCountry(@Bind("searchBy") int search);

    //search country
    @SqlQuery("SELECT distinct * FROM country " +
            "WHERE :searchBy ILIKE (name) "
    )
    @RegisterRowMapper(CountryMapper.class)
    List<Country> findCountry(@Bind("searchBy") String search);



    @SqlQuery("SELECT * FROM Person ORDER BY id")
    @RegisterRowMapper(PersonMapper.class)
    List<Person> getPersons();

    @SqlQuery("SELECT * FROM person_telephone ORDER BY id")
    @RegisterRowMapper(PersonTelephoneMapper.class)
    List<PersonTelephone> getPerTelephone();

    @SqlQuery("SELECT * FROM person_address ORDER BY id")
    @RegisterRowMapper(PersonAddressMapper.class)
    List<PersonAddress> getPerAddress();


    //get telphone numbers
    @SqlQuery("SELECT distinct * FROM telephone t  " +
            "JOIN telephone_type ttype ON ttype.id = t.fk_telephone_type_id \n" +
            "GROUP BY t.id, ttype.id " +
            "ORDER BY 1"
    )
    @RegisterRowMapper(TelephoneMapper.class)
    List<Telephone> getTelephones();

    //get country
    @SqlQuery("SELECT * FROM country ORDER BY id")
    @RegisterRowMapper(CountryMapper.class)
    List<Country> getCountry();

    //return person telephones
    @SqlQuery("SELECT * FROM person_telephone ORDER BY id")
    @RegisterRowMapper(PersonTelephoneMapper.class)
    List<PersonTelephone> getPersonTelephone();



    //return person addresses
    @SqlQuery("SELECT * FROM person_address ORDER BY id")
    @RegisterRowMapper(PersonAddressMapper.class)
    List<PersonAddress> getPersonAddress();


    //find person
    @SqlQuery(
            "SELECT p.id, p.first_name, p.second_name, p.third_name ,p.surname, p.identifier, p.is_passport, p.date_created, p.date_modified " +
                    "FROM Person p " +
                    "left JOIN Person_address pa ON pa.fk_person_id = p.id " +
                    "left JOIN Address a ON a.id = pa.fk_address_id " +
                    "left JOIN Person_telephone pt " +
                    "ON pt.fk_person_id = p.id " +
                    "left JOIN telephone t " +
                    "ON t.id = pt.fk_telephone_id " +
                    "WHERE :searchBy ILIKE any (values(first_name), (second_name), (third_name), (surname), (identifier)," +
                                              "(a.line1), (a.line2), (a.line3), (a.line4), (a.line1 ||' '||a.line2), (a.line1 ||' '|| a.line2 ||' '|| a.line3), " +
                                              "(first_name ||' '|| surname), (first_name ||' '|| second_name ||' '|| surname), (first_name ||' '|| second_name ||' '|| third_name ||' '|| surname) " +
                                              ",(t.number)) " +
                    "GROUP BY p.id"
    )
    @RegisterRowMapper(FindPersonMapper.class)
    List<Person> findPerson(@Bind("searchBy") String search);

    //find person by ID
    @SqlQuery(
            "SELECT p.id, p.first_name, p.second_name, p.third_name ,p.surname, p.identifier, p.is_passport, p.date_created, p.date_modified \n" +
                    "FROM Person p "  +
                    "WHERE :searchBy in(p.id::varchar)"
    )
    @RegisterRowMapper(FindPersonMapper.class)
    List<Person> findById(@Bind("searchBy") String Id);

    //insert telephone number
    @SqlUpdate(
            "INSERT INTO telephone(\"number\", date_created, date_modified, fk_telephone_type_id) " +
                    "VALUES (:tel.number,now(),now(), :tel.fkTelephoneTypeId)"
    )
    @RegisterRowMapper(TelephoneMapper.class)
    void insertTelephoneNumber(@BindBean("tel") Telephone telephone);


    //insert person telephone
    @SqlUpdate(
            "INSERT INTO person_telephone(is_current,date_created, date_modified, fk_person_id, fk_telephone_id) " +
                    "VALUES (:tel.isCurrent ,now(), now(), :tel.getFkPersonId ,:tel.getFkTelephoneId);"
    )
    @RegisterRowMapper(PersonTelephoneMapper.class)
    void insertPersonTelephone(@BindMethods("tel") PersonTelephone telephone);

    //insert person
    @SqlUpdate(
            "INSERT INTO person(identifier, is_passport, first_name, second_name, third_name, surname, date_created, date_modified, fk_country_id) " +
                    "VALUES (:p.getIdentifier, :p.isPassport, :p.getFirstName, :p.getSecondName, :p.getThirdName, :p.getSurname, now(), now(), :p.getFkCountryId);"
    )
    @RegisterRowMapper(PersonMapper.class)
    void insertPerson(@BindMethods("p") Person person);


    //insert address
    @SqlUpdate(
            "INSERT INTO public.address(line1, line2, line3, line4, postal_code, date_created, date_modified, fk_address_type_id) " +
                    "VALUES (:addr.getLine1, :addr.getLine2, :addr.getLine3, :addr.getLine4, :addr.getPostalCode, now(), now(), :addr.getFkAddressTypeId);"
    )
    @RegisterRowMapper(AddressMapper.class)
    void insertAddress(@BindMethods("addr") Address address);

    //insert person address
    @SqlUpdate(
            "INSERT INTO person_address(date_created, date_modified, fk_person_id, fk_address_id, is_current) " +
                    "VALUES (now(), now(), :addr.getFkPersonId ,:addr.getFkAddressId, :addr.isCurrent);"
    )
    @RegisterRowMapper(PersonAddressMapper.class)
    void insertPersonAddress(@BindMethods("addr") PersonAddress address);

    //insert country
    @SqlUpdate(
            "INSERT INTO country (code, name, date_created, date_modified) " +
            "SELECT :c.code, :c.name, now(), now() " +
            "WHERE :c.name NOT IN (SELECT name FROM country WHERE name ILIKE (:c.name))"
    )
    @RegisterRowMapper(CountryMapper.class)
    void insertCountry(@BindBean("c") Country country);

    /*
     *
     * Updates
     *
     *
     */

    //update person
    @SqlUpdate(
            "UPDATE person " +
                    "SET first_name= :p.getFirstName, second_name= :p.getSecondName, third_name= :p.getThirdName, surname= :p.getSurname," +
                    "date_modified= now(), fk_country_id= :p.getFkCountryId " +
                    "WHERE id in(:id) ;"
    )
    @RegisterRowMapper(PersonMapper.class)
    void updatePerson(@BindMethods("p") Person person, @Bind("id") int id);

    //update telephone
    @SqlUpdate(
            "UPDATE telephone " +
                    "SET \"number\" = :tel.getNumber, date_modified = now(), fk_telephone_type_id = :tel.getFkTelephoneTypeId " +
                    "WHERE id in(:id);"
    )
    @RegisterRowMapper(PersonTelephoneMapper.class)
    void updateTelephone(@BindMethods("tel") Telephone telephone, @Bind("id") int id);

    //update person telephone
    @SqlUpdate(
            "UPDATE person_telephone " +
                    "SET is_current = :tel.isCurrent , date_modified = now(), fk_person_id = :tel.getFkPersonId, fk_telephone_id = :tel.getFkTelephoneId " +
                    "WHERE id in(:id);"
    )
    @RegisterRowMapper(TelephoneMapper.class)
    void updatePersonTelephone(@BindMethods("tel") PersonTelephone personTelephone, @Bind("id") int id);

    //update address
    @SqlUpdate(
            "UPDATE address " +
                    "SET line1 = :addr.getLine1, line2 = :addr.getLine2 , line3 = :addr.getLine3, line4 = :addr.getLine4, " +
                    "postal_code = :addr.getPostalCode, date_modified = now(), fk_address_type_id = :addr.getFkAddressTypeId " +
                    "WHERE id in(:id);"
    )
    @RegisterRowMapper(AddressMapper.class)
    void updateAddress(@BindMethods("addr") Address address, @Bind("id") int id);

    //update person address
    @SqlUpdate(
            "UPDATE person_address " +
                    "SET date_modified = now(), fk_person_id = :addr.getFkPersonId, fk_address_id = :addr.getFkAddressId, is_current = :addr.isCurrent" +
                    "WHERE id in(:id);"
    )
    @RegisterRowMapper(PersonAddressMapper.class)
    void updatePersonAddress(@BindMethods("addr") PersonAddress address, @Bind("id") int id);

    //update country
    @SqlUpdate(
            "UPDATE country " +
                    "SET code= :c.getCode, name = :c.getName, date_modified = now() " +
                    "WHERE id in(:id);"
    )
    @RegisterRowMapper(AddressMapper.class)
    void updateCountry(@BindMethods("c") Country country, @Bind("id") int id);
}
