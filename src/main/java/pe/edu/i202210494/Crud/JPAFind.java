package pe.edu.i202210494.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import pe.edu.i202210494.domain.Country;

import jakarta.persistence.Persistence;


public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("world");
            em = emf.createEntityManager();

            Country peru = em.find(Country.class, "PER");

            if (peru != null) {
                System.out.println("ciudades peruanas con población > 700k:");
                peru.getCities().stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println("- " + city.getName()));
            } else {
                System.out.println(" fallo no se encontró el país 'PER'.");
            }
        } catch (Exception e) {
            System.err.println(" intentar de nuevo : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}

