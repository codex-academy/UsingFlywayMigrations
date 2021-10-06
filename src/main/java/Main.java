import java.util.List;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import static spark.Spark.*;

public class Main {

    public Main() {
    }

    public static void main(String[] args) {

        get("/hello", (req, res) -> "Hello World");

        String dbDiskURL = "jdbc:sqlite:file:./pizza.db";

        Jdbi jdbi = Jdbi.create(dbDiskURL);

// get a handle to the database
        Handle handle = jdbi.open();

        Pizza pizza = new Pizza("Regina", "Small", 29.95);

        Integer pizzaCount = handle.select("select count(*) from pizza where type = ? and size = ? ",
                        pizza.getType(),
                        pizza.getSize())
                .mapTo(Integer.class)
                .findOnly();

        if (pizzaCount > 0) {
            System.out.println("Pizza already added!");
            return;
        }
        handle.execute("insert into pizza (type, size, price) values (?,?,?)",
                pizza.getType(),
                pizza.getSize(),
                pizza.getPrice());

        List<Pizza> pizzas = handle
            .select("select * from pizza")
            .mapToBean(Pizza.class)
                .list();

        System.out.println(pizzas.size());

    }
}