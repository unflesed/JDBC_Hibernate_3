package additional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Animal animal = new Animal();
        animal.setName("Vaska");
        animal.setAge(2);
        animal.setTail(true);

        addAnimal(animal);
    }
    public static void addAnimal(Animal animal){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(animal);
        transaction.commit();
        session.close();
    }
}