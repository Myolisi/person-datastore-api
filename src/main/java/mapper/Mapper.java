package mapper;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Mapper implements RowMapper<HashMap<String, String>> {
    @Override
    public HashMap<String, String> map(ResultSet rs, StatementContext context) throws SQLException{

        int noOfColumnsInRow = rs.getMetaData().getColumnCount();
        HashMap<String, String>  map = new HashMap<>();

        for (int columnIndex = 1; columnIndex <= noOfColumnsInRow; columnIndex ++ ){

            //find column name
            String columnName = rs.getMetaData().getColumnName(columnIndex);

            //get Value for the column
            Object columnValue = rs.getObject(columnIndex);

            if (columnValue != null){
                map.put(columnName, columnValue.toString());
            }else {
                map.put(columnName, "");
            }
        }

        return map;
    }
}
