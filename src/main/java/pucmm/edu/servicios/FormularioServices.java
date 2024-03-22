package pucmm.edu.servicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import pucmm.edu.encapsulaciones.Formulario;
import java.util.List;

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
