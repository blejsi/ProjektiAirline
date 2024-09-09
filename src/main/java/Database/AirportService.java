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




    public void updateEntity() {

    }



}
