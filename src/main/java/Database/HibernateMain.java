package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure("Hibernate.xml")
                .addAnnotatedClass(AirportEntity.class)
                .addAnnotatedClass(DestinationEntity.class)
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(FlightEntity.class)
                .addAnnotatedClass(PassengersEntity.class)
                .addAnnotatedClass(AirlinesEntity.class)
                .addAnnotatedClass(RoutesEntity.class)
                .buildSessionFactory();





//        destination.setAirline_name("Wizz");
//        destination.setCountry("Germany");
//        destination.setAirline_code("J456789K");
//
//
//
//
//        airport.setAirportName("Nene Tereza");
//        airport.setCountry("Albania");
//        airport.setIATACode("A7220S");
//
//
//        airport.getDestinations().add(destination);
//
//        destination.getAirport().add(airport);
//
//        airportService.addEntity(airport,sessionFactory);
//        destinationService.addEntity(destination,sessionFactory);






    }
}
