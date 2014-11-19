/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.offercruz.bl.impl.control;

import bo.com.offercruz.bl.contratos.ICategoriaBO;
import bo.com.offercruz.bl.contratos.IImagenBO;
import bo.com.offercruz.bl.contratos.IPerfilBO;
import bo.com.offercruz.bl.contratos.IUsuarioBO;
import bo.com.offercruz.bl.impl.CategoriaBO;
import bo.com.offercruz.bl.impl.ImagenBO;
import bo.com.offercruz.bl.impl.PerfilBO;
import bo.com.offercruz.bl.impl.UsuarioBO;

/**
 *
 * @author Olvinho
 */
public class FactoriaObjetosNegocio {

    private static final ThreadLocal<FactoriaObjetosNegocio> caja = new ThreadLocal<>();

    private FactoriaObjetosNegocio() {

    }

    public static FactoriaObjetosNegocio getInstance() {
        FactoriaObjetosNegocio businessObjectsFactory = caja.get();
        if (businessObjectsFactory == null) {
            businessObjectsFactory = new FactoriaObjetosNegocio();
            caja.set(businessObjectsFactory);
        }
        return businessObjectsFactory;
    }

    private ICategoriaBO categoriaBO;

    public ICategoriaBO getICategoriaBO() {
        if (categoriaBO == null) {
            categoriaBO = new CategoriaBO();
        }
        return categoriaBO;
    }

    private IPerfilBO perfilBO;

    public IPerfilBO getIPerfilBO() {
        if (perfilBO == null) {
            perfilBO = new PerfilBO();
        }
        return perfilBO;
    }

    private IUsuarioBO usuarioBO;

    public IUsuarioBO getIUsuarioBO() {
        if (usuarioBO == null) {
            usuarioBO = new UsuarioBO();
        }
        return usuarioBO;
    }

    private IImagenBO imagenBO;

    public IImagenBO getIImagenBO() {
        if (imagenBO == null) {
            imagenBO = new ImagenBO();
        }
        return imagenBO;
    }
}
