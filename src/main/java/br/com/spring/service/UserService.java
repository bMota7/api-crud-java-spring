package br.com.spring.service;

import br.com.spring.domain.Users;

import java.util.List;

public interface UserService {

    void toSave(Users users);
    List<Users> toRecover();
    Users recoverById(long id);
    void toUpdate(Users users);
    void toDelete(long id);

}
