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
                .buildSessionFactory();


        AirportEntity airport = new AirportEntity();

        AirportService airportService = new AirportService();

        DestinationEntity destination = new DestinationEntity();

        DestinationService destinationService = new DestinationService();

        destination.setDestination_id(325);
        destination.setAirline_name("Wizz");
        destination.setCountry("Germany");
        destination.setAirline_code("J456789K");



        airport.setAirportId(345679);
        airport.setAirportName("Nene Tereza");
        airport.setCountry("Albania");
        airport.setIATACode("A7220S");


        airport.getDestinations().add(destination);

        destination.getAirport().add(airport);

        airportService.addEntity(airport,sessionFactory);






    }
}
