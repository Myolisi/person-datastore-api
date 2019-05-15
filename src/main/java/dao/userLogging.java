package dao;

import mapper.Mapper;
import mapper.PersonInforMapper;
import mapper.PersonMapper;
import mapper.TelephoneMapper;
import model.*;
import org.jdbi.v3.core.mapper.RowMapperFactory;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapperFactory;
import org.jdbi.v3.sqlobject.config.RegisterRowMappers;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface userLogging {

//    @SqlQuery(
//            "select * from person"
//    )
//    @RegisterRowMapper(Mapper.class)
//    List<Address> result();

    @SqlQuery(
            "SELECT distinct p.* " +
                    "FROM Person p " +
                    "left JOIN Person_address pa ON pa.fk_person_id = p.id " +
                    "left JOIN Address a ON a.id = pa.fk_address_id " +
                    "left JOIN Person_telephone pt " +
                    "ON pt.fk_person_id = p.id " +
                    "left JOIN telephone t " +
                    "ON t.id = pt.fk_telephone_id " +

                    "GROUP BY p.id, t.id, a.id " +
                    "ORDER BY p.id"
    )
    @RegisterRowMapper(PersonMapper.class)
    Person result();

}
