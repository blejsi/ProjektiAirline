package Database;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FlightService {

    public void addFlight(FlightEntity flightEntity, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(flightEntity);
        transaction.commit();
        session.close();
    }

    public void updateFlightNumber(Integer id, String flightNumber, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT f FROM flight f WHERE f.id = :id";
        FlightEntity flightEntity = session.createQuery(hql, FlightEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        flightEntity.setFlightNumber(flightNumber);
        session.saveOrUpdate(flightEntity);
        transaction.commit();
        session.close();
    }

    public void updateFlightDate(Integer id, String date, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT f FROM flight f WHERE f.id = :id";
        FlightEntity flightEntity = session.createQuery(hql, FlightEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        flightEntity.setDate(date);
        session.saveOrUpdate(flightEntity);
        transaction.commit();
        session.close();
    }

    public FlightEntity findByFlightNumber(String flightNumber, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT f FROM flight f WHERE f.flightNumber = :flightNumber";
        FlightEntity flightEntity = session.createQuery(hql, FlightEntity.class)
                .setParameter("flightNumber", flightNumber)
                .getSingleResult();
        transaction.commit();
        session.close();
        return flightEntity;
    }

    public void deleteFlight(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        FlightEntity flightEntity = session.get(FlightEntity.class, id);
        if (flightEntity != null) {
            session.delete(flightEntity);
        }
        transaction.commit();
        session.close();
    }
}
