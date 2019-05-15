package mapper;

import model.Telephone;
import model.TelephoneType;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TelephoneMapper implements RowMapper<Telephone> {

    @Override
    public Telephone map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Telephone telephone = new Telephone();
        telephone.setId(resultSet.getInt("id"));
        telephone.setNumber(resultSet.getString("number"));
        telephone.setFkTelephoneTypeId(resultSet.getInt("fk_telephone_type_id"));
        telephone.setDateCreated(resultSet.getDate("date_created"));
        telephone.setDateModified(resultSet.getDate("date_modified"));

        TelephoneType telephoneType = new TelephoneType();
        telephoneType.setId(resultSet.getInt("id"));
        telephoneType.setCode(resultSet.getString("code"));

        telephone.setTelephoneType(telephoneType.getCode());

        return telephone;
    }

}

