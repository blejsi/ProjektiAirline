package Database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RinasApp {
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
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Zgjidhni opsionin:");
        System.out.println("1. Sign up");
        System.out.println("2. Log in");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            signup(sessionFactory, scanner);
        } else if (option == 2) {
            login(sessionFactory, scanner);
        } else {
            System.out.println("Opsion i pavlefshem!");
        }
    }

    public static void signup(SessionFactory sessionFactory, Scanner scanner) {
        System.out.println("Vendosni username:");
        String username = scanner.nextLine();

        System.out.println("Vendosni password:");
        String password = scanner.nextLine();

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            UserEntity user = session.createQuery("SELECT u FROM users u WHERE u.username = :username AND u.password = :password", UserEntity.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();

            transaction.commit();
            session.close();

            if (user != null) {
                System.out.println("Sign up i suksesshem " + user.getRole());
            }
        } catch (Exception e) {
            System.out.println("Gabim gjate regjistrimit.");
            transaction.rollback();
        }
    }

    public static void login(SessionFactory sessionFactory, Scanner scanner) {
        System.out.println("Vendosni username per Log in:");
        String username = scanner.nextLine();

        System.out.println("Vendosni password:");
        String password = scanner.nextLine();

        System.out.println("Jeni punonjes apo pasagjer? (1 per punonjes, 2 per pasagjer)");
        int roleOption = scanner.nextInt();
        scanner.nextLine();

        String role;
        if (roleOption == 1) {
            role = "EMPLOYEE";
        } else if (roleOption == 2) {
            role = "PASSENGER";
        } else {
            System.out.println("Opsion i pavlefshem!");
            return;
        }

        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(newUser);
        transaction.commit();
        session.close();

        System.out.println("Log in i suksesshem " + role);

        selectFlight(sessionFactory, scanner);
    }

    public static void selectFlight(SessionFactory sessionFactory, Scanner scanner) {
        System.out.println("Zgjidhni daten e fluturimit (1 per sot, 2 per neser, 3 per date tjeter):");
        int dateOption = scanner.nextInt();
        scanner.nextLine();

        LocalDate selectedDate;
        if (dateOption == 1) {
            selectedDate = LocalDate.now();
        } else if (dateOption == 2) {
            selectedDate = LocalDate.now().plusDays(1);
        } else if (dateOption == 3) {
            System.out.println("Vendosni daten (yyyy-mm-dd):");
            String dateInput = scanner.nextLine();
            selectedDate = LocalDate.parse(dateInput);
        } else {
            System.out.println("Opsion i pavlefshem!");
            return;
        }

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<FlightEntity> flights = session.createQuery("SELECT f FROM flight f WHERE airport = :airportName AND f.date = :flightDate", FlightEntity.class)
                    .setParameter("airportName", "Rinasi")
                    .setParameter("flightDate", selectedDate)
                    .getResultList();

            transaction.commit();
            session.close();

            if (!flights.isEmpty()) {
                System.out.println("Fluturimet nga Rinasi me daten " + selectedDate + ":");
                for (FlightEntity flight : flights) {
                    System.out.println("Fluturimi ID: " + flight.getFlightID() + ", Flight Number: " + flight.getFlightNumber() + ", Data e fluturimit :" + flight.getDate() + ",Kohzgjatja e fluturimit:" + flight.getDuration() + ",Koha e uljes" + flight.getLandingTime() + ", Route i Udhetimit" + flight.getRouteID());
                }

                System.out.println("Zgjidhni nje fluturim sipas ID:");
                int flightId = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Fluturimi me ID " + flightId + " u zgjodh me sukses.");
            } else {
                System.out.println("Nuk ka fluturime te disponueshme me daten " + selectedDate + ".");
            }

        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Gabim gjate kerkimit te fluturimeve.");
        }
    }
}

