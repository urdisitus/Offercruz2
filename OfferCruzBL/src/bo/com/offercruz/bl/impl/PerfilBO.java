/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo.com.offercruz.bl.impl;

import bo.com.offercruz.bl.contratos.IPerfilBO;
import bo.com.offercruz.dal.contrato.IPerfilDAO;
import bo.com.offercruz.entidades.Perfil;
import bo.com.offercruz.entidades.Usuario;
import java.util.concurrent.Callable;

/**
 *
 * @author Ernesto
 */
public class PerfilBO extends ObjetoNegocioGenerico<Perfil, Integer, IPerfilDAO>
        implements IPerfilBO {

    @Override
    IPerfilDAO getObjetoDAO() {
        return getDaoManager().getPerfilDAO();
    }

    @Override
    public boolean verificarPermiso(Integer idPermiso, Usuario usuario) {
        if (usuario == null) {
            return false;
        }

        if (usuario.getPerfil() == null) {
            return false;
        }

        if (usuario.getPerfil().getId() == null) {
            return false;
        }

        return true;
    }
    
}
