package br.com.spring.dao;

import br.com.spring.domain.Users;

import java.util.List;

public interface UserDao {

    void toSave(Users users);
    List<Users> toRecover();
    Users recoverByID(long id);
    void toUpdate(Users users);
    void toDelete(long id);

}
