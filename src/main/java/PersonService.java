import dao.PersonDao;
import dao.userLogging;
import mapper.PersonInforMapper;
import mapper.PersonMapper;
import mapper.PersonTelephoneMapper;
import mapper.TelephoneMapper;
import model.*;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.JdbiException;
import org.jdbi.v3.core.mapper.JoinRowMapper;
import org.jdbi.v3.core.mapper.RowMapperFactory;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import java.util.*;

class PersonService   {

    private static PersonDao dao;

    //GET all
    public static List<Address> getAddresses(int user) throws DaoException{
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getAllAddresses(user);
        }catch (JdbiException e){
            throw new DaoException("Could not get addresses", e);
        }
    }

    //GET all
    public static List<Telephone> getTelephones(int user) throws DaoException{
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getAllTelephones(user);
        }catch (JdbiException e){
            throw new DaoException("Could not get telephones", e);
        }
    }

    //GET person
    public static List<Person> getAllPersons() throws DaoException{
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getPersons();
        }catch (JdbiException e){
            throw new DaoException("Problem getting all persons", e);
        }
    }

    //GET telephones
    public static List<Telephone> getTelephone () throws DaoException {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getTelephones();
        }catch (JdbiException e){
            throw new DaoException("Could not getting a persons telephone", e);
        }
    }

    //GET person country
    public static List<Country> getPersonCountry (int searchBy) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getPersonCountry(searchBy);
        }
    }


    //GET person telephone
    public static List<PersonTelephone> getPersonTelephone () {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getPersonTelephone();
        }
    }

    //GET country
    public static List<Country> getCountry () {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getCountry();
        }
    }

    //GET address
//    public static List<Address> getAddress () {
//        try (Handle handle = DB.getDB().getJdbi().open()){
//            dao = handle.attach(PersonDao.class);
//            return dao.getAddress();
//        }
//    }

    //GET person address
    public static List<PersonAddress> getPersonAddress () {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getPersonAddress();
        }
    }


    //Find person
    public static List<Person> findPerson(String searchBy) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.findPerson(searchBy);
        }
    }

    //Find country
    public static List<Country> findCountry(String searchBy) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.findCountry(searchBy);
        }
    }

    //Find by person by ID
    public static List<Person> findById(String searchBy) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.findById(searchBy);
        }
    }


    //insert telephone number
    public static void addTelephone(Telephone telephone) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.insertTelephoneNumber(telephone);
        }
    }

    //insert person telephone
    public static void addPersonTelephone(PersonTelephone telephone) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.insertPersonTelephone(telephone);
        }
    }

    //insert address
    public static void addAddress(Address address) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.insertAddress(address);
        }
    }

    //insert person address
    public static void addPersonAddress(PersonAddress personAddress) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.insertPersonAddress(personAddress);
        }
    }

    //insert country
    public static void addCountry(Country country) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.insertCountry(country);
        }
    }

    //insert person
    public static void addPerson (Person person) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.insertPerson(person);
        }
    }

    //update person
    public static void updatePerson(Person person,int id) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.updatePerson(person,id);
        }
    }

    //update telephone
    public static void updateTelephone(Telephone telephone,int id) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.updateTelephone(telephone,id);
        }
    }

    //update person telephone
    public static void updatePersonTelephone(PersonTelephone personTelephone,int id) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.updatePersonTelephone(personTelephone,id);
        }
    }

    public static void updateAddress (Address address,int id) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.updateAddress(address,id);
        }
    }

    public static void updatePersonAddress (PersonAddress address,int id) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.updatePersonAddress(address,id);
        }
    }

    //update country
    public static void updateCountry(Country country,int id) {
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            dao.updateCountry(country,id);
        }
    }


    //GET person telephone
    public static List<PersonTelephone> getPerTelephone() throws DaoException{
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getPerTelephone();
        }catch (JdbiException e){
            throw new DaoException("",e);
        }
    }

    //GET person telephone
    public static List<PersonAddress> getPerAddress() throws DaoException{
        try (Handle handle = DB.getDB().getJdbi().open()){
            dao = handle.attach(PersonDao.class);
            return dao.getPerAddress();
        }catch (JdbiException e){
            throw new DaoException("", e);
        }
    }

    static userLogging userDao;
    public static Person getPerson(){
        try (Handle handle = DB.getDB().getJdbi().open()) {
            handle.registerRowMapper(BeanMapper.factory(Person.class));
            handle.registerRowMapper(BeanMapper.factory(Telephone.class));
            handle.registerRowMapper(JoinRowMapper.forTypes(Person.class, Telephone.class));
            userDao = handle.attach(userLogging.class);
            return userDao.result();
        }
    }
}

