package com.test.todo.dao;

import com.test.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo , Integer> {
    @Query(value = "select * from tbl_todo where user_id = :id" , nativeQuery = true)
    List<Todo> getTodoByUserId(Integer id);

    @Query(value = "select * from tbl_todo where id= :todoId and user_id= :id",nativeQuery = true)
    public Todo findByUserIdAndTodoId(Integer id, Integer todoId);
}
