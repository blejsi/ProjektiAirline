package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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



}
