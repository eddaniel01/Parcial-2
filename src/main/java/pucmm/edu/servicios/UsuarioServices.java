package pucmm.edu.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import pucmm.edu.encapsulaciones.Usuario;

public class UsuarioServices extends GestionDb<Usuario>{

    private static UsuarioServices instancia;

    private UsuarioServices() {
        super(Usuario.class);
    }

    public static UsuarioServices getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioServices();
        }
        return instancia;
    }

    /**
     *
     */
    public Usuario getUsuarioByUsername(String username) {
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("select e from Usuario e where e.usuario like :username");
            query.setParameter("username", username+"%");
            return (Usuario) query.getSingleResult();
        }catch (Exception e) {
        return null;
        }finally{
            em.close();
        }

    }

    public boolean eliminarById(Object entidadId) throws PersistenceException {
        boolean ok = false;
        try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            try {
                Usuario entidad = em.find(Usuario.class, entidadId);
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
}