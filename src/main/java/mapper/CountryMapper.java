package mapper;

import model.Country;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country>{
    @Override
    public Country map(ResultSet resultSet, StatementContext statementContext) throws SQLException{
        Country country = new Country();
        country.setId(resultSet.getInt("id"));
        country.setCode(resultSet.getString("code"));
        country.setName(resultSet.getString("name"));
        country.setDateCreated(resultSet.getDate("date_created"));
        country.setDateModified(resultSet.getDate("date_modified"));
        return country;
    }
}
