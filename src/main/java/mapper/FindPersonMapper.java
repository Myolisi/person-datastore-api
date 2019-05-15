package mapper;

import model.*;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FindPersonMapper implements RowMapper<Person> {

    @Override
    public Person map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setFirstName(resultSet.getString("first_name"));
        person.setSecondName(resultSet.getString("second_name"));
        person.setThirdName(resultSet.getString("third_name"));
        person.setSurname(resultSet.getString("surname"));
        person.setIdentifier(resultSet.getString("identifier"));
        person.setPassport(resultSet.getBoolean("is_passport"));
        person.setDateCreated(resultSet.getDate("date_created"));
        person.setDateModified(resultSet.getDate("date_modified"));
        return person;
    }
}
