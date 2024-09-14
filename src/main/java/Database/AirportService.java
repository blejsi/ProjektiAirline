package Database;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class AirportService {






    public void addEntity(AirportEntity airportEntity,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(airportEntity);
        transaction.commit();
        session.close();

    }




    public void updateCountry(Integer id, String country,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT a FROM airport a WHERE  airportId = :id";
        AirportEntity airportEntity = session.createQuery(hql, AirportEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airportEntity.setCountry(country);
        session.saveOrUpdate(airportEntity);

        transaction.commit();
        session.close();
    }

public void updateIATAcode(Integer id, String IATAcode,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT a FROM airport a WHERE  airportId = :id";
        AirportEntity airportEntity = session.createQuery(hql, AirportEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airportEntity.setIATACode(IATAcode);
        session.saveOrUpdate(airportEntity);

        transaction.commit();
        session.close();
    }

public void updateAirportName(Integer id, String AirportName,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT a FROM airport a WHERE  airportId = :id";
        AirportEntity airportEntity = session.createQuery(hql, AirportEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        airportEntity.setAirportName(AirportName);
        session.saveOrUpdate(airportEntity);

        transaction.commit();
        session.close();
    }


public void FindByID(Integer id,SessionFactory sessionFactory) {
        EntityManager em = sessionFactory.getCurrentSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT a FROM airport a WHERE  airportId = :id";

    List<AirportEntity> cars = em.createQuery("FROM airport ", AirportEntity.class).getResultList();
    System.out.println(cars.toString());
        transaction.commit();
        session.close();
    }

    public void FindByName(String name,SessionFactory sessionFactory) {
        EntityManager em = sessionFactory.getCurrentSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT a FROM airport a WHERE  airportName = :name";

    List<AirportEntity> cars = em.createQuery(hql, AirportEntity.class).getResultList();
    System.out.println(cars.toString());

        transaction.commit();
        session.close();
    }




    public void deleteInDb(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        AirportEntity airportEntity = session.createQuery("Select s from airport s where id = :id", AirportEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        session.remove(airportEntity);
        transaction.commit();
        session.close();
    }




}
