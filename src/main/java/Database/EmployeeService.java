package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeService {

    public void addEmployee(EmployeeEntity employeeEntity, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(employeeEntity);
        transaction.commit();
        session.close();
    }

    public void updateEmployeeName(Integer id, String name, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT e FROM employee e WHERE e.id = :id";
        EmployeeEntity employeeEntity = session.createQuery(hql, EmployeeEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        employeeEntity.setName(name);
        session.saveOrUpdate(employeeEntity);
        transaction.commit();
        session.close();
    }

    public void updateEmployeeAge(Integer id, int age, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT e FROM employee e WHERE e.id = :id";
        EmployeeEntity employeeEntity = session.createQuery(hql, EmployeeEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        employeeEntity.setAge(age);
        session.saveOrUpdate(employeeEntity);
        transaction.commit();
        session.close();
    }

    public EmployeeEntity findByName(String name, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT e FROM employee e WHERE e.name = :name";
        EmployeeEntity employeeEntity = session.createQuery(hql, EmployeeEntity.class)
                .setParameter("name", name)
                .getSingleResult();  
        transaction.commit();
        session.close();
        return employeeEntity;
    }
  public EmployeeEntity findByName(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT e FROM employee e WHERE e.uniqueID = :id";
        EmployeeEntity employeeEntity = session.createQuery(hql, EmployeeEntity.class)
                .setParameter("id", id)
                .getSingleResult();
        transaction.commit();
        session.close();
        return employeeEntity;
    }

    public void deleteEmployee(Integer id, SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
        if (employeeEntity != null) {
            session.delete(employeeEntity);
        }
        transaction.commit();
        session.close();
    }
}
