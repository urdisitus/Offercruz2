/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.offercruz.dal.impl;

import bo.com.offercruz.dal.base.DAOGenericoHibernate;
import bo.com.offercruz.dal.contrato.IOfertaDAO;
import bo.com.offercruz.entidades.Oferta;
import org.hibernate.Query;

/**
 *
 * @author Ernesto
 */
public class OfertaHibernateDAO extends DAOGenericoHibernate<Oferta, Integer> implements IOfertaDAO {

    @Override
    public Integer getIdPorNombre(String nombre) {
        Query query = getSession().createQuery("SELECT id from Oferta r WHERE r.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Integer intte = (Integer) query.uniqueResult();
        return intte;
    }

}
