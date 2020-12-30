package ru.snkatvit.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.snkatvit.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int COUNT = 0;
    private static final String URL = "jdbc:mysql://localhost:3306/first_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private static Connection connection;

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = String.format("INSERT INTO Person VALUES(%d, '%s', %d, '%s');",
                    person.getId(), person.getName(), person.getAge(), person.getEmail());
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person;";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getInt("age"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
                System.out.println(person.getName() + person.getId());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        return null;
    }

    public void update(int id, Person personUpdate) {
//        personList.removeIf(person -> person.getId() == id);
//        personList.add(personUpdate);
    }

    public void delete(int id) {
//        personList.removeIf(person -> person.getId() == id);
    }
}
