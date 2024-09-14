package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AirlinesService {

    public void addEntity(AirlinesEntity airlinesEntity,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(airlinesEntity);
        transaction.commit();
        session.close();
    }

    public AirlinesEntity findById(Integer id,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        AirlinesEntity airlinesEntity = session.createQuery("Select a from airlines a where airlineId = :id", AirlinesEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        transaction.commit();
        session.close();
return airlinesEntity;
    }

    public void updateName(Integer id, String name,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT n FROM airlines n WHERE airlineId = :id";
        AirlinesEntity airlinesEntity = session.createQuery(hql, AirlinesEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airlinesEntity.setAirlineName(name);
        session.saveOrUpdate(airlinesEntity);

        transaction.commit();
        session.close();
    }

    public void updateIATACode(Integer id, String IATACode,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT i FROM airlines i WHERE airlineId = :id";
        AirlinesEntity airlinesEntity = session.createQuery(hql, AirlinesEntity.class)
                .setParameter("id", id )
                .getSingleResult();
        airlinesEntity.setIATACode(IATACode);
        session.saveOrUpdate(airlinesEntity);

        transaction.commit();
        session.close();
    }

    public void updateFleet(Integer id, Integer fleet,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT f FROM airlines f WHERE airlineId = :id";
        AirlinesEntity airlinesEntity = session.createQuery(hql, AirlinesEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airlinesEntity.setFleet(fleet);
        session.saveOrUpdate(airlinesEntity);

        transaction.commit();
        session.close();
    }

    public void updateEmployees(Integer id, Integer employees,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT e FROM airlines e WHERE airlineId = :id";
        AirlinesEntity airlinesEntity = session.createQuery(hql, AirlinesEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airlinesEntity.setFleet(employees);
        session.saveOrUpdate(airlinesEntity);

        transaction.commit();
        session.close();
    }

    public void updateCountry(Integer id, String country,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT c FROM airlines c WHERE airlineId = :id";
        AirlinesEntity airlinesEntity = session.createQuery(hql, AirlinesEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airlinesEntity.setCountry(country);
        session.saveOrUpdate(airlinesEntity);

        transaction.commit();
        session.close();
    }
}
