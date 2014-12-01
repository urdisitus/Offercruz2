/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offercruzdal;

import bo.com.offercruz.dal.imp.control.DAOManagerHibernate;
import bo.com.offercruz.dal.impl.CategoriaHibernateDAO;
import bo.com.offercruz.entidades.Categoria;
import bo.com.offercruz.enums.TipoOferta;
import java.util.Date;

/**
 *
 * @author Ernesto
 */
public class OfferCruzDAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOManagerHibernate manager = new DAOManagerHibernate();
        Categoria c = new Categoria();
        c.setEstado(1);
        c.setId(0);
        c.setNombre("Ernesto");
        //c.setTipoOferta(TipoOferta.PRODUCTO);
        c.setFechaModificacion(new Date());
        c.setFechaCreacion(new Date());
        manager.iniciarTransaccion();
        try {
            ((CategoriaHibernateDAO) manager.getCategoriaDAO()).persistir(c);
            manager.confirmarTransaccion();
        } catch (Exception e) {
            manager.cancelarTransaccion();
        }
    }

}
