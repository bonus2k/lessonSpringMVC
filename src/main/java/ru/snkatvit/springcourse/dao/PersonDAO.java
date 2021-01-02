package ru.snkatvit.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.snkatvit.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(?, ?, ?, ?)",
                new Object[]{person.getId(), person.getName(), person.getAge(), person.getEmail()});
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMaper());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Person personUpdate) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                new Object[]{personUpdate.getName(), personUpdate.getAge(), personUpdate.getEmail(), id});
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", new Object[]{id});
    }
}
