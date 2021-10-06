import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String dbDiskURL = "jdbc:sqlite:file:./pizza.db";

        Jdbi jdbi = Jdbi.create(dbDiskURL);

// get a handle to the database
        Handle handle = jdbi.open();

        handle.execute("insert into pizza (type, size, price) values (?,?,?)", "Regina", "Small", 29.95);

        Pizza pizza = handle
            .select("select * from pizza")
            .mapToBean(Pizza.class)
            .findOnly();

        System.out.println(pizza);
    }
}