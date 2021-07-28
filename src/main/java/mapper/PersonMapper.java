package mapper;

import model.Person;
import model.Telephone;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonMapper implements RowMapper<Person> {


    public  List<Telephone> telephonesList;
    @Override
    public Person map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Person user = new Person();
        user.setId(resultSet.getInt("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setSecondName(resultSet.getString("second_name"));
        user.setThirdName(resultSet.getString("third_name"));
        user.setSurname(resultSet.getString("surname"));
        user.setDateCreated(resultSet.getDate("date_created"));
        user.setDateModified(resultSet.getDate("date_modified"));
        user.setIdentifier(resultSet.getString("identifier"));
        user.setFkCountryId(resultSet.getInt("fk_country_id"));
        user.setPassport(resultSet.getBoolean("is_passport"));

//        Telephone tel = new Telephone();
//        tel.setNumber(resultSet.getString("number"));
//        tel.setId(resultSet.getInt("id"));
//
//        telephonesList = new ArrayList<>();
//        telephonesList.add(tel);
//        user.setTelephones(tel.getNumber());
        return user;
    }


}

