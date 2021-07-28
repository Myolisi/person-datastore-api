package mapper;
import model.PersonAddress;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class PersonAddressMapper implements RowMapper<PersonAddress> {

        @Override
        public PersonAddress map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
            PersonAddress address = new PersonAddress();
            address.setId(resultSet.getInt("id"));
            address.setDateCreated(resultSet.getDate("date_created"));
            address.setDateModified(resultSet.getDate("date_modified"));
            address.setFkPersonId(resultSet.getInt("fk_person_id"));
            address.setFkAddressId(resultSet.getInt("fk_address_id"));
            address.setCurrent(resultSet.getBoolean("is_current"));
            return address;
        }

}
