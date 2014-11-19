/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.offercruzmail.imp;

import bo.com.offercruz.bl.contratos.IPerfilBO;
import bo.com.offercruz.bl.contratos.IPermisoBO;
import bo.com.offercruz.bl.impl.control.FactoriaObjetosNegocio;
import bo.com.offercruz.entidades.Perfil;
import bo.com.offercruz.entidades.Permiso;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Ernesto
 */
public class InterpretadorMensajePerfil extends InterpretadorMensajeGenerico<Perfil, Integer, IPerfilBO> {

    @Override
    Perfil convertirHojaEnEntidad() {
        Perfil entidad = new Perfil();
        Cell celda;
        //Id
        celda = hojaActual.getCelda(3, 2);
        if (celda.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            entidad.setId((int) celda.getNumericCellValue());
        }
        //Nombre
        celda = hojaActual.getCelda(4, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setNombre(hojaActual.getValorCeldaCadena(celda));
        }
        //Descripcion
        celda = hojaActual.getCelda(4, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setNombre(hojaActual.getValorCeldaCadena(celda));
        }
        //Permisos
        int fila = 9;
        do {
            celda = hojaActual.getCelda(fila, 1);
            if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
                String permiso = hojaActual.getValorCeldaCadena(celda);
                Permiso p = new Permiso();
                p.setPermisoTexto(permiso);
                entidad.getPermisos().add(p);
            }
            fila++;
        } while (celda.getCellType() != Cell.CELL_TYPE_BLANK);
        return entidad;
    }

    @Override
    protected void preparPlantillaAntesDeEnviar() {
        IPermisoBO permisoBO = FactoriaObjetosNegocio.getInstance().getIPermisoBO();
        List<Permiso> pers = permisoBO.obtenerTodos();
        String[] permisos = new String[pers.size()];
        for (int j = 0; j < permisos.length; j++) {
            permisos[j] = pers.get(j).getPermisoTexto();
        }
        hojaActual.agregarValidacionLista(9, 9 + permisos.length, 1, 1, permisos, true, true);
    }

    @Override
    IPerfilBO getObjetoNegocio() {
        return FactoriaObjetosNegocio.getInstance().getIPerfilBO();
    }

    @Override
    boolean esNuevo(Perfil entidad) {
        return entidad.getId() == null;
    }

    @Override
    String getId(Perfil entidad) {
        return entidad.getId().toString();
    }

    @Override
    Integer convertirId(String cadena) throws Exception {
        return convertirIdAEntero(cadena);
    }

    @Override
    void mostrarLista(List<Perfil> lista) {
        int i = 5;
        for (Perfil perfil : lista) {
            hojaActual.setValorCelda(i, 1, perfil.getId());
            hojaActual.setValorCelda(i, 2, perfil.getNombre());
            hojaActual.setValorCelda(i, 3, perfil.getDescripcion());
            i++;
        }
    }

    @Override
    void mostrarEntidad(Perfil entidad) {
        preparPlantillaAntesDeEnviar();
        hojaActual.setValorCelda(3, 2, entidad.getId());
        hojaActual.setValorCelda(4, 2, entidad.getNombre());
        hojaActual.setValorCelda(5, 2, entidad.getDescripcion());
    }

}
