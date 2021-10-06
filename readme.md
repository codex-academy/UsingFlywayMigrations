# Using flyway with SQLite & JDBI

This is an example of how to use [FlyWay](https://flywaydb.org/documentation/getstarted/firststeps/maven) database migrations with SQLite.

You can also use it with [PostgreSQL](https://flywaydb.org/documentation/database/postgresql).

See the pom.xml file for the configuration


```xml
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>7.15.0</version>
    <configuration>
        <url>jdbc:sqlite:file:./pizza.db</url>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>org.xerial</groupId>
            <artifactId>sqlite-jdbc</artifactId>
            <version>3.36.0.3</version>
        </dependency>
    </dependencies>
</plugin>
```

To run the migrations use:

```
mvn flyway:migrate
```