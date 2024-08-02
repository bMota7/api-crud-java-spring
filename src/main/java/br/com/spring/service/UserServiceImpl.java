package br.com.spring.service;

import br.com.spring.dao.UserDao;
import br.com.spring.domain.Users;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void toSave(Users users) {
        userDao.toSave(users);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Users> toRecover() {
        return userDao.toRecover();
    }

    @Override
    @Transactional(readOnly = true)
    public Users recoverById(long id) {
        return userDao.recoverByID(id);
    }

    @Override
    public void toUpdate(Users users) {
        userDao.toUpdate(users);
    }

    @Override
    public void toDelete(long id) {
        userDao.toDelete(id);
    }

}
