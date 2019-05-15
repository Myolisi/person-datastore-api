package mapper;
import model.PersonTelephone;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonTelephoneMapper implements RowMapper<PersonTelephone> {

    @Override
    public PersonTelephone map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        PersonTelephone telephone = new PersonTelephone();
        telephone.setId(resultSet.getInt("id"));
        telephone.setDateCreated(resultSet.getDate("date_created"));
        telephone.setDateModified(resultSet.getDate("date_modified"));
        telephone.setFkPersonId(resultSet.getInt("fk_person_id"));
        telephone.setFkTelephoneId(resultSet.getInt("fk_telephone_id"));
        telephone.setCurrent(resultSet.getBoolean("is_current"));
        return telephone;
    }
}
