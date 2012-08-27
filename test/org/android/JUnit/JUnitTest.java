/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.android.JUnit;

import java.util.List;
import org.hibernate.model.Clientes;
import org.hibernate.model.Vuelos;
import org.hibernate.model.dao.ClientesDao;
import org.hibernate.model.dao.VuelosDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pollito
 */
public class JUnitTest {

    public JUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /*
    
     @Test
     public void crear(){
     Clientes cl = new Clientes("Alejandro", "Hernandez", "perez", "hombre", 23, 1, 2);
     ClientesDao dao = new ClientesDao();
     if(dao.createClientes(cl)){
     System.out.println("Se agrego a la base de datos");
     }
     else{
     System.out.println("No se agrego nada");
     }
        
     }

    */
    @Test
    public void listar() {
        List<Vuelos> lista = new VuelosDao().readVuelos();

        if (lista != null) {
            System.out.println("Se encontraron" + lista.size() + " registros!");
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).getCiudadDestino());
            }
        }
    }
    
/*
    @Test
    public void findVuelosByCriteria() {
        VuelosDao dao= new VuelosDao();
        Vuelos re = new Vuelos();
        re.setCiudadOrigen("a");
        re.setCiudadDestino("d");
        re.setHoraLlegada("");
        re.setHoraSalida("");
        re.setIdAvion(1);
        re.setIdReservacion(2);
        re.setPrecioAdultos(0);
        re.setPrecioAdultos(0);
        List<Vuelos> lis = dao.findVuelosByCriteria(re);
        System.out.println(lis.size());
        for (int i = 0; i < lis.size(); i++) {
            System.out.println("Registro numero: " + lis.get(i).getCiudadOrigen());
        }
    }
    * */
}
