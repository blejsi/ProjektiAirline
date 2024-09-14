package Database;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class DestinationService  {





        public void addEntity(DestinationEntity destinationEntity,SessionFactory sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            EntityManager entityManager = sessionFactory.getCurrentSession();

            Transaction transaction = session.beginTransaction();

            session.save(destinationEntity);
            transaction.commit();
            session.close();

        }

    public void FindByName(String name,SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        EntityManager em = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT d FROM destination d WHERE  d.airline_name = :name";

      List<DestinationEntity> destinations = em.createQuery(hql, DestinationEntity.class)
                .setParameter("name", name)
                .getResultList();
        System.out.println(destinations.toString());

        transaction.commit();
        session.close();
    }

    public void FindByID(Integer id,SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();
        EntityManager em = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT d FROM destination d WHERE  d.id = :id";

      DestinationEntity destinations = em.createQuery(hql, DestinationEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        System.out.println(destinations.toString());

        transaction.commit();
        session.close();
    }




    public void updateAirline_name(Integer id, String airline_name,SessionFactory sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
             String hql = "SELECT d FROM destination d WHERE  id = :id";
            DestinationEntity destinationEntity = session.createQuery(hql, DestinationEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            destinationEntity.setAirline_name(airline_name);
            session.saveOrUpdate(destinationEntity);

            transaction.commit();
            session.close();
        }
    public void updateCountry(Integer id, String country,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT d FROM destination d WHERE  id = :id";
        DestinationEntity destinationEntity = session.createQuery(hql, DestinationEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        destinationEntity.setCountry(country);
        session.saveOrUpdate(destinationEntity);

        transaction.commit();
        session.close();
    }

    public void updateAirline_code(Integer id, String airline_code,SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT d FROM destination d WHERE  id = :id";
        DestinationEntity destinationEntity = session.createQuery(hql, DestinationEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        destinationEntity.setAirline_code(airline_code);
        session.saveOrUpdate(destinationEntity);

        transaction.commit();
        session.close();
    }

    public void deleteInDb(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        DestinationEntity destinationEntity = session.createQuery("Select d from destination d where id = :id", DestinationEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        session.remove(destinationEntity);
        transaction.commit();
        session.close();
    }


}
