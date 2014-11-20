/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.offercruzmail.imp;

import bo.com.offercruz.bl.contratos.IEmpresaBO;
import bo.com.offercruz.bl.impl.control.FactoriaObjetosNegocio;
import bo.com.offercruz.entidades.Categoria;
import bo.com.offercruz.entidades.Empresa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author juanCarlos
 */
public class InterpretadorMensajeEmpresa extends InterpretadorMensajeGenerico<Empresa, Integer, IEmpresaBO> {

    @Override
    Empresa convertirHojaEnEntidad() {
        Empresa entidad = new Empresa();
        Cell celda;
        //Id
        celda = hojaActual.getCelda(3, 2);
        if (celda.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            entidad.setId((int) celda.getNumericCellValue());
        }
        //Razon social
        celda = hojaActual.getCelda(4, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setRazonSocial(hojaActual.getValorCeldaCadena(celda));
        }
        //Slogan
        celda = hojaActual.getCelda(5, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setSlogan(hojaActual.getValorCeldaCadena(celda));
        }

        celda = hojaActual.getCelda(6, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setMision(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(7, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setVision(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(8, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setTelefono(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(9, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setDireccion(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(10, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setTipoSociedad(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(11, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setCorreoElectronico(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(12, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setFax(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(13, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            entidad.setNit(hojaActual.getValorCeldaCadena(celda));
        }
        celda = hojaActual.getCelda(14, 2);
        if (celda.getCellType() != Cell.CELL_TYPE_BLANK) {
            try {
                entidad.setFechaApertura(new SimpleDateFormat("dd/MM/yyyy").parse(hojaActual.getValorCeldaCadena(celda)));
            } catch (ParseException ex) {
                Logger.getLogger(InterpretadorMensajeEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return entidad;
    }

    @Override
    IEmpresaBO getObjetoNegocio() {
        return FactoriaObjetosNegocio.getInstance().getIEmpresaBO();
    }

    @Override
    boolean esNuevo(Empresa entidad) {
        return entidad.getId() == null;
    }

    @Override
    String getId(Empresa entidad) {
        return entidad.getId().toString();
    }

    @Override
    Integer convertirId(String cadena) throws Exception {
        return convertirIdAEntero(cadena);
    }

    @Override
    void mostrarLista(List<Empresa> lista) {
        int i = 5;
        for (Empresa empresa : lista) {
            hojaActual.setValorCelda(i, 1, empresa.getId());
            hojaActual.setValorCelda(i, 2, empresa.getRazonSocial());
            hojaActual.setValorCelda(i, 3, empresa.getSlogan());
            hojaActual.setValorCelda(i, 4, empresa.getMision());
            hojaActual.setValorCelda(i, 5, empresa.getVision());
            hojaActual.setValorCelda(i, 6, empresa.getTelefono());
            hojaActual.setValorCelda(i, 7, empresa.getDireccion());
            hojaActual.setValorCelda(i, 8, empresa.getTipoSociedad());
            hojaActual.setValorCelda(i, 9, empresa.getCorreoElectronico());
            hojaActual.setValorCelda(i, 10, empresa.getFax());
            hojaActual.setValorCelda(i, 11, empresa.getNit());
            hojaActual.setValorCelda(i, 12, empresa.getFechaApertura().toString());
            
            
            StringBuilder categorias = new StringBuilder();
            for (Object object : empresa.getCategorias()) {
                Categoria categoria = (Categoria) object;
                categorias.append(categoria.getNombre()).append(", ");
            }
            hojaActual.setValorCelda(i, 13, categorias.toString());
            i++;
        }
    }

    @Override
    void mostrarEntidad(Empresa entidad, Workbook libro) {
        preparPlantillaAntesDeEnviar(libro);
        int i = 5; 
        hojaActual.setValorCelda(i, 1, entidad.getId());
            hojaActual.setValorCelda(i, 2, entidad.getRazonSocial());
            hojaActual.setValorCelda(i, 3, entidad.getSlogan());
            hojaActual.setValorCelda(i, 4, entidad.getMision());
            hojaActual.setValorCelda(i, 5, entidad.getVision());
            hojaActual.setValorCelda(i, 6, entidad.getTelefono());
            hojaActual.setValorCelda(i, 7, entidad.getDireccion());
            hojaActual.setValorCelda(i, 8, entidad.getTipoSociedad());
            hojaActual.setValorCelda(i, 9, entidad.getCorreoElectronico());
            hojaActual.setValorCelda(i, 10,entidad.getFax());
            hojaActual.setValorCelda(i, 11,entidad.getNit());
            hojaActual.setValorCelda(i, 12,entidad.getFechaApertura().toString());
            
            
//            StringBuilder categorias = new StringBuilder();
//            for (Object object : empresa.getCategoriaempresas()) {
//                Categoria categoria = (Categoria) object;
//                categorias.append(categoria.getNombre()).append(", ");
//            }   
    }

}
