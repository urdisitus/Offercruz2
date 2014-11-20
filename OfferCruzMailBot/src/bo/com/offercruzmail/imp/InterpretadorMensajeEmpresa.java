/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.com.offercruzmail.imp;

import bo.com.offercruz.bl.contratos.IEmpresaBO;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean esNuevo(Empresa entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getId(Empresa entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Integer convertirId(String cadena) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void mostrarLista(List<Empresa> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void mostrarEntidad(Empresa entidad, Workbook libro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
