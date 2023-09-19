package com.example.pp_3_1_2.dao;





import com.example.pp_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();

    void add(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);
}
