package com.test.todo.services;

import com.test.todo.dao.TodoRepo;
import com.test.todo.dao.UserRepo;
import com.test.todo.models.Todo;
import com.test.todo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TodoRepo todoRepo;

    public Todo save(Todo todo, String username, String password) {
        boolean flag = userService.login(username, password);
        if (flag) {
            User user = userRepo.findByUserName(username);
            Todo todo1 = todo;
            todo1.setUser(user);
            return todoRepo.save(todo1);
        }
        return null;
    }

    public List<Todo> getTodos(String username, String password) {
        boolean flag = userService.login(username, password);
        if (flag) {
            User user = userRepo.findByUserName(username);
            List<Todo> todoList = todoRepo.getTodoByUserId(user.getId());
            return todoList;
        }
        return null;
    }

    public boolean updateTodo(Integer todoId, String username, String password, Todo todo) {
        boolean flag = userService.login(username, password);
        if (flag) {
            User user = userRepo.findByUserName(username);
            Todo todo1 = todoRepo.findByUserIdAndTodoId(user.getId(), todoId);
            todo1.setDescription(todo.getDescription());
            todo1.setTitle(todo.getTitle());
            todo1.setStatus(todo.getStatus());
            todoRepo.save(todo1);
            return true;
        }
        return false;
    }

    public void deleteTodo(Integer todoId, String username, String password) {
        boolean flag = userService.login(username, password);
        if (flag) {
            User user = userRepo.findByUserName(username);
            Todo todo1 = todoRepo.findByUserIdAndTodoId(user.getId(), todoId);
            todoRepo.deleteById(todoId);
        }
    }
}