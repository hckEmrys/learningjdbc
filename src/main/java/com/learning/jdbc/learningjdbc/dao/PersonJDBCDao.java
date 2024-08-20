package com.learning.jdbc.learningjdbc.dao;

import com.learning.jdbc.learningjdbc.data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJDBCDao {

    // select * from person

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>
    {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));

            return person;
        }
    }

    public List<Person> findAll(){
        return jdbcTemplate.
          query("Select * from person",new PersonRowMapper());
    }


    public Person findById(int id){
        return jdbcTemplate.queryForObject("Select * from person where id=?", new Object[]{id},new PersonRowMapper());
    }

    public int deleteById(int id)
    {
        return
          jdbcTemplate.update("delete from person where id=?",new Object[]{id});
    }

    public int insertPerson(Person person)
    {
        return jdbcTemplate.update(
        "Insert into person(id, name,location, birth_date) values (?,?,?,?)",new Object[]{person.getId(),
          person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
    }

    public int update(Person person)
    {
        return jdbcTemplate.update(
          "Update person set name=?,location =?,birth_date=? where id=? ",new Object[]{
            person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()});
    }
}
