package pucmm.edu.servicios;

import dev.morphia.DeleteOptions;
import dev.morphia.experimental.MorphiaSession;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.bson.types.ObjectId;
import pucmm.edu.encapsulaciones.Formulario;

import java.util.List;

import static dev.morphia.query.experimental.filters.Filters.eq;

public class FormularioServices extends GestionDb<Formulario> {

    private static FormularioServices instancia;

    private FormularioServices() {
        super(Formulario.class);
    }

    public static FormularioServices getInstancia() {
        if (instancia == null) {
            instancia = new FormularioServices();
        }
        return instancia;
    }

    public List<Formulario> getFormsByUser(Long id) {

        EntityManager em = getEntityManager();
        List<Formulario> formularios;
        try{
            Query query = em.createQuery("select e from Formulario e where e.user.id like :id");
            query.setParameter("id", id+"%");
            formularios = query.getResultList();
        }finally{
            em.close();
        }
        return formularios;

//        try (MorphiaSession session = getDatastore().startSession()) {
//            return session.find(Formulario.class).filter(eq("user", id)).stream().toList();
//        } catch (Exception e) {
//            return null;
//        }
    }

//    public boolean eliminarById(String id) {
//        boolean ok = false;
//        try {
//            EntityManager em = getEntityManager();
//            try {
//                session.startTransaction();
//                session
//                        .find(Formulario.class)
//                        .filter(eq("_id", new ObjectId(id)))
//                        .delete(new DeleteOptions());
//                session.commitTransaction();
//                ok = true;
//            }finally {
//                session.close();
//            }
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        return ok;
//    }
}
