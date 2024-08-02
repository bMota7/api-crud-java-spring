package br.com.spring.dao;

import br.com.spring.domain.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void toSave(Users users) {
        em.persist(users);
    }

    @Override
    public List<Users> toRecover() {
        return em.createQuery("select u from Users u", Users.class).getResultList();
    }

    @Override
    public Users recoverByID(long id) {
        return em.find(Users.class, id);
    }

    @Override
    public void toUpdate(Users users) {
        em.merge(users);
    }

    @Override
    public void toDelete(long id) {
        em.remove(em.getReference(Users.class, id));
    }

}
