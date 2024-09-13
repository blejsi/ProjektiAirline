package Database;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PassengersService {

    public void addEntity(PassengersEntity passengersEntity, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(passengersEntity);
        transaction.commit();
        session.close();
    }

    public PassengersEntity findById(Integer id, SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        PassengersEntity passengersEntity = session.createQuery("Select p from PassengersEntity p where passengerId = :id", PassengersEntity.class)
                .setParameter("id",id)
                .getSingleResult();
        transaction.commit();
        session.close();
        return passengersEntity;
    }

    public void updateName(Integer id, String name,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT n FROM PassengersEntity n WHERE passengerId = :id";
        PassengersEntity passengersEntity = session.createQuery(hql, PassengersEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        passengersEntity.setName(name);
        session.saveOrUpdate(passengersEntity);

        transaction.commit();
        session.close();
    }

    public void updateSurname(Integer id, String surname,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT s FROM PassengersEntity s WHERE passengerId = :id";
        PassengersEntity passengersEntity = session.createQuery(hql, PassengersEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        passengersEntity.setSurname(surname);
        session.saveOrUpdate(passengersEntity);

        transaction.commit();
        session.close();
    }

    public void updateAge(Integer id, Integer age, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT a FROM PassengersEntity a WHERE passengerId = :id";
        PassengersEntity passengersEntity = session.createQuery(hql, PassengersEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        passengersEntity.setAge(age);
        session.saveOrUpdate(passengersEntity);

        transaction.commit();
        session.close();
    }

    public void updateGender(Integer id, String gender,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT g FROM PassengersEntity g WHERE passengerId = :id";
        PassengersEntity passengersEntity = session.createQuery(hql, PassengersEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        passengersEntity.setGender(gender);
        session.saveOrUpdate(passengersEntity);

        transaction.commit();
        session.close();
    }
}

