package Database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {

    SessionFactory sessionFactory = new Configuration()
            .configure("Hibernate.xml")
            .buildSessionFactory();
}
