package mapper;

import model.Address;
import model.AddressType;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {

    @Override
    public Address map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Address address = new Address();
        address.setId(resultSet.getInt("id"));
        address.setLine1(resultSet.getString("line1"));
        address.setLine2(resultSet.getString("line2"));
        address.setLine3(resultSet.getString("line3"));
        address.setLine4(resultSet.getString("line4"));
        address.setPostalCode(resultSet.getString("postal_code"));
        address.setDateCreated(resultSet.getDate("date_created"));
        address.setDateModified(resultSet.getDate("date_modified"));
        address.setFkAddressTypeId(resultSet.getInt("fk_address_type_id"));

        AddressType addressType = new AddressType();
        addressType.setId(resultSet.getInt("id"));
        addressType.setCode(resultSet.getString("code"));

        address.setAddressType(addressType.getCode());
        return address;
    }
}
