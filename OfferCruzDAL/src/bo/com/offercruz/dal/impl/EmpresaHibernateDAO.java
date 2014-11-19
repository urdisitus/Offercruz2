/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo.com.offercruz.dal.impl;

import bo.com.offercruz.dal.base.DAOGenericoHibernate;
import bo.com.offercruz.dal.contrato.IEmpresaDAO;
import bo.com.offercruz.entidades.Empresa;
import org.hibernate.Query;

/**
 *
 * @author Ernesto
 */
public class EmpresaHibernateDAO extends DAOGenericoHibernate<Empresa, Integer> implements IEmpresaDAO{

    @Override
    public Empresa obtenerPorNombre(String nombre) {
           
        /*Query query = getSession().createQuery("SELECT 1 from " + Categoria.class.getName() + " c where c.nombre = :Nombre AND c.estado > 0 AND c.id != :Id");
        query.setParameter("Nombre", nombre);
        query.setParameter("Id", id);
        return (Categoria)query.uniqueResult();*/
        Query query = getSession().createQuery("SELECT 1 from " + Empresa.class.getName() + " c where c.razonSocial = :Nombre AND c.estado > 0 ");
        query.setParameter("Nombre", nombre);
        
        return (Empresa)query.uniqueResult(); 
    }
    
}
