/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo.com.offercruz.bl.impl;

import bo.com.offercruz.bl.contratos.IEmpresaBO;
import bo.com.offercruz.bl.contratos.IUsuarioBO;
import bo.com.offercruz.bl.excepticiones.BusinessExceptionMessage;
import bo.com.offercruz.bl.impl.control.FactoriaObjetosNegocio;
import bo.com.offercruz.dal.contrato.IEmpresaDAO;
import bo.com.offercruz.entidades.Empresa;
import bo.com.offercruz.entidades.Perfil;
import bo.com.offercruz.entidades.Usuario;
import java.util.Date;



/**
 *
 * @author juanCarlos
 */
public class EmpresaBO extends ObjetoNegocioGenerico<Empresa, Integer, IEmpresaDAO> implements IEmpresaBO {

    @Override
    IEmpresaDAO getObjetoDAO() {
        return getDaoManager().getEmpresaDAO();
    }
    
    @Override
    protected void validar(Empresa entity) {
        //Nombre
        boolean nombreValido = true;
        if (isNullOrEmpty(entity.getRazonSocial())) {
            appendException(new BusinessExceptionMessage("La razón social es un campo requerido.", "nombre"));
            nombreValido = false;
        }
        if (nombreValido) {
            Empresa emp = getObjetoDAO().obtenerPorNombre(entity.getRazonSocial());
            if (emp != null) {
                appendException(new BusinessExceptionMessage("La empresa '" + entity.getRazonSocial() + "' ya existe.", "nombre"));
            }
        }
    }

    @Override
    protected void preInsertar(Empresa entidad) {
        IUsuarioBO objUsuario= FactoriaObjetosNegocio.getInstance().getIUsuarioBO();
        entidad.setEstado(1);
        entidad.setFechaCreacion(new Date());
        entidad.setFechaModificacion(new Date());
        Perfil p= new Perfil();
        p.setNombre("AdministradorEmpresa");
        Usuario user= new Usuario();
        user.setPerfil(p);
        user.setLogin(entidad.getRazonSocial().replaceAll(" ", ""));
        user.setCorreoElectronico(entidad.getCorreoElectronico());
        objUsuario.insertar(user);
    }
    
    
    @Override
    protected void preActualizar(Empresa entidad) {
        entidad.setFechaModificacion(new Date());
    }
}
