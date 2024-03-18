package pucmm.edu.servicios;

import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import dev.morphia.experimental.MorphiaSession;
import dev.morphia.query.Query;
import org.bson.types.ObjectId;

import java.util.List;

import static dev.morphia.query.experimental.filters.Filters.eq;

/**
 * Created by vacax on 03/06/16.
 */
public class GestionDb<T> {

    private static EntityManagerFactory emf;
    private final Class<T> claseEntidad;

    public GestionDb(Class<T> claseEntidad) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
        }
        this.claseEntidad = claseEntidad;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     *
     */
    public T crear(T entidad) throws IllegalArgumentException, EntityExistsException, PersistenceException{
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();

        }finally {
            em.close();
        }
        return entidad;
    }

    /**
     *
     */
    public T editar(T entidad) throws PersistenceException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(entidad);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return entidad;
    }

    /**
     *
     */
    public boolean eliminar(Object entidadId) throws PersistenceException{
        boolean ok = false;
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            try {
                T entidad = em.find(claseEntidad, entidadId);
                em.remove(entidad);
                em.getTransaction().commit();
                ok = true;
            }finally {
                em.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ok;
    }

    /**
     *
     */
    public T find (Object id)  throws PersistenceException {
        EntityManager em = getEntityManager();
        try{
            return em.find(claseEntidad, id);
        } catch (Exception e) {
            return null;
        }
        finally {
            em.close();
        }
    }

    /**
     */
    public List<T> findAll()throws PersistenceException {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(claseEntidad);
            criteriaQuery.select(criteriaQuery.from(claseEntidad));
            return em.createQuery(criteriaQuery).getResultList();
        }finally {
            em.close();
        }
    }
}