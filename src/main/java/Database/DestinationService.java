package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DestinationService  {





        public void addEntity(DestinationEntity destinationEntity,SessionFactory sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(destinationEntity);
            transaction.commit();
            session.close();

        }





    public void updateEntity() {

    }
}
