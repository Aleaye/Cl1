package pe.edu.i202210494.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import pe.edu.i202210494.domain.Country;
import jakarta.persistence.Persistence;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("world");
            em = emf.createEntityManager();
            em.getTransaction().begin();

            Country country = em.find(Country.class, "GL");

            if (country != null) {
                em.remove(country);
                System.out.println(" 'GL' pais eliminado .");
            } else {
                System.out.println(" 'DLD' sin datos.");
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Ocurrió un error : " + e.getMessage());
            e.printStackTrace();
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Revertir transacción en caso de error
            }
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}

