package Database;

import com.mysql.cj.jdbc.DatabaseMetaData;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.print.attribute.standard.Destination;
import java.sql.Connection;
import java.sql.SQLException;
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

        DestinationService destinationService = new DestinationService();

        DestinationEntity destination = new DestinationEntity();


        DestinationEntity destination1 = new DestinationEntity();
        DestinationEntity destination2 = new DestinationEntity();
        DestinationEntity destination3 = new DestinationEntity();
        DestinationEntity destination4 = new DestinationEntity();
        DestinationEntity destination5 = new DestinationEntity();
        DestinationEntity destination6 = new DestinationEntity();




            destination.setId(1);
            destination.setAirline_name("Wizz");
            destination.setCountry("Germany");
            destination.setAirline_code("J489K");
            destination.setAirport(airport);


            destination1.setId(2);
            destination1.setAirline_name("AlbaWings");
            destination1.setCountry("France");
            destination1.setAirline_code("J490K");
             destination1.setAirport(airport);

            destination2.setId(3);
            destination2.setAirline_name("Air Albania");
            destination2.setCountry("Italy");
            destination2.setAirline_code("J491K");
          destination2.setAirport(airport);

            destination3.setId(4);
            destination3.setAirline_name("Wizz");
            destination3.setCountry("Russia");
            destination3.setAirline_code("J492K");
          destination3.setAirport(airport);

            destination4.setId(5);
            destination4.setAirline_name("AlbaWings");
            destination4.setCountry("Turkey");
            destination4.setAirline_code("J493K");
             destination4.setAirport(airport);



            airport.setAirportId(1);
            airport.setAirportName("Nene Tereza");
            airport.setCountry("Albania");
            airport.setIATACode("A7220S");





//        try {
//            destinationService.addEntity(destination4, sessionFactory);
//        }catch (IllegalStateException illegalArgumentException){
//            System.out.println("Error: " + illegalArgumentException.getMessage());
//        }







           destinationService.FindByName("Wizz", sessionFactory);



    }
}
