package com.example.todoList.repo;


import com.example.todoList.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class TodoRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    RowMapper<Todo> mapper=new RowMapper<Todo>() {
        @Override
        public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Todo td=new Todo();
            td.setId(rs.getInt("id"));
            td.setTitle(rs.getString("title"));
            td.setCompleted(rs.getBoolean("isCompleted"));
            return td;
        }
    };
    public void save(String title) {
        String query="insert into list_table(title,isCompleted) values (?,false)";
        template.update(query,title);
    }

    public void markCompleted(int id) {
        String query="update list_table set isCompleted=true where id=?";
        template.update(query,id);
    }

    public void delete(int id) {
        String query="delete from list_table where id=?";
        template.update(query,id);
        
    }

    public List<Todo> findAll() {
        String query="select id,title,isCompleted from list_table order by id desc";
        return template.query(query,mapper);

    }
}
