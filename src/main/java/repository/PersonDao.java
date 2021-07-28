package repository;

import model.Person;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@UseClasspathSqlLocator
@RegisterBeanMapper(Person.class)
public interface PersonDao extends  {

    @SqlQuery
    List<Person> getUsers();

}
