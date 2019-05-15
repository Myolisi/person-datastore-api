import org.jdbi.v3.core.Jdbi;

public class DB {

    private final Jdbi jdbi;

    private DB() {
        jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/person_database", "postgres", "Ngu@9267");
        jdbi.installPlugins();
    }

    public Jdbi getJdbi() {
        return jdbi;
    }

    private static DB instance;

    public static DB getDB() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }
}
