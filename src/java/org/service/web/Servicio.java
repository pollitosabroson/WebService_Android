/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.service.web;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.hibernate.model.Aeropuerto;
import org.hibernate.model.Avion;
import org.hibernate.model.Clientes;
import org.hibernate.model.Reservaciones;
import org.hibernate.model.Vuelos;
import org.hibernate.model.dao.AeropuertoDao;
import org.hibernate.model.dao.AvionDao;
import org.hibernate.model.dao.ClientesDao;
import org.hibernate.model.dao.ReservacionesDao;
import org.hibernate.model.dao.VuelosDao;

/**
 *
 * @author pollito
 */
@WebService(serviceName = "Servicio")
public class Servicio {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaClientes")
    public List<Clientes> listaClientes() {
        //TODO write your implementation code here:
        ClientesDao dao = new ClientesDao();
        List<Clientes> lis = dao.readClientes();
        return lis;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearIdCliente")
    public Clientes SearIdCliente(@WebParam(name = "Id_cliente") String Id_cliente) {
        //TODO write your implementation code here:
        ClientesDao dao = new ClientesDao();
        return dao.findClientesById(Integer.parseInt(Id_cliente));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchCriteriosClientes")
    public List SearchCriteriosClientes(@WebParam(name = "Id_cliente") String Id_cliente, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "A_paterno") String A_paterno, @WebParam(name = "A_materno") String A_materno, @WebParam(name = "Sexo") String Sexo, @WebParam(name = "Edad") String Edad, @WebParam(name = "CantidadDeNinos") String CantidadDeNinos, @WebParam(name = "CantidadDeAdultos") String CantidadDeAdultos) {
        //TODO write your implementation code here:
        ClientesDao dao = new ClientesDao();
        return dao.findClientesByCriteria(new Clientes(Nombre, A_materno, A_materno, Sexo, Integer.parseInt(Edad), Integer.parseInt(CantidadDeNinos), Integer.parseInt(CantidadDeAdultos)));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listAeropuerto")
    public List<Aeropuerto> listAeropuerto() {
        //TODO write your implementation code here:
        AeropuertoDao dao = new AeropuertoDao();
        List<Aeropuerto> lis = dao.readAeropuerto();
        return lis;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchIdAeropuerto")
    public Aeropuerto SearchIdAeropuerto(@WebParam(name = "Id_aeropuerto") String Id_aeropuerto) {
        //TODO write your implementation code here:
        AeropuertoDao dao = new AeropuertoDao();
        return dao.findAeropuertoById(Integer.parseInt(Id_aeropuerto));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchCriterioAeropuerto")
    public List<Aeropuerto> SearchCriterioAeropuerto(@WebParam(name = "Id_aeropuerto") String Id_aeropuerto, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "Ciudad") String Ciudad) {
        //TODO write your implementation code here:
        AeropuertoDao dao = new AeropuertoDao();
        return dao.findAeropuertoByCriteria(new Aeropuerto(Nombre, Ciudad));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listAvion")
    public List<Avion> listAvion() {
        //TODO write your implementation code here:
        AvionDao dao = new AvionDao();
        List<Avion> lis = dao.readAvion();
        return lis;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searIdAvion")
    public Avion searIdAvion(@WebParam(name = "Id_avion") String Id_avion) {
        //TODO write your implementation code here:
        AvionDao dao = new AvionDao();
        return dao.findAvionById(Integer.parseInt(Id_avion));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchCriterioAvion")
    public List SearchCriterioAvion(@WebParam(name = "Id_avion") String Id_avion, @WebParam(name = "Capacidad") String Capacidad, @WebParam(name = "Id_Reservacion") String Id_Reservacion) {
        //TODO write your implementation code here:
        AvionDao dao = new AvionDao();
        return dao.findAvionByCriteria(new Avion(Integer.parseInt(Capacidad), Integer.parseInt(Id_Reservacion)));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateReservacion")
    public Boolean CreateReservacion(@WebParam(name = "Id_reservacion") String Id_reservacion, @WebParam(name = "Id_cliente") String Id_cliente) {
        //TODO write your implementation code here:
        Reservaciones pci = new Reservaciones(Integer.parseInt(Id_cliente));
        return new ReservacionesDao().createReservaciones(pci);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchIdReservacion")
    public Reservaciones SearchIdReservacion(@WebParam(name = "Id_reservacion") String Id_reservacion) {
        //TODO write your implementation code here:
        ReservacionesDao dao = new ReservacionesDao();
        return dao.findReservacionesById(Integer.parseInt(Id_reservacion));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaReservaciones")
    public List<Reservaciones> listaReservaciones() {
        //TODO write your implementation code here:
        ReservacionesDao dao = new ReservacionesDao();
        List<Reservaciones> lis = dao.readReservaciones();
        return lis;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listVuelos")
    public List<Vuelos> listVuelos() {
        //TODO write your implementation code here:
        VuelosDao dao = new VuelosDao();
        List<Vuelos> lis = dao.readVuelos();
        return lis;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchIdVuelos")
    public Vuelos searchIdVuelos(@WebParam(name = "Id_vuelos") String Id_vuelos) {
        //TODO write your implementation code here:
        VuelosDao dao = new VuelosDao();
        return dao.findVuelosById(Integer.parseInt(Id_vuelos));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateCliente")
    public Boolean CreateCliente(@WebParam(name = "Nombre") String Nombre, @WebParam(name = "A_paterno") String A_paterno, @WebParam(name = "A_materno") String A_materno, @WebParam(name = "Sexo") String Sexo, @WebParam(name = "Edad") String Edad, @WebParam(name = "CantidadDeNinos") String CantidadDeNinos, @WebParam(name = "CantidadDeAdultos") String CantidadDeAdultos) {
        //TODO write your implementation code here:
        Clientes pci = new Clientes(Nombre, A_paterno, A_materno, Sexo, Integer.parseInt(Edad), Integer.parseInt(CantidadDeNinos), Integer.parseInt(CantidadDeAdultos)); 
        return new ClientesDao().createClientes(pci);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchcriterioVuelos")
    public static List<Vuelos> SearchcriterioVuelos(@WebParam(name = "Ciudad_origen") String Ciudad_origen, @WebParam(name = "Ciudad_destino") String Ciudad_destino) {
        //TODO write your implementation code here:
        Vuelos dao = new Vuelos();
        dao.setCiudadDestino(Ciudad_destino);
        dao.setCiudadOrigen(Ciudad_origen);
        //return new VuelosDao().findVuelosByCriteria(dao);
        List<Vuelos> lista = new VuelosDao().findVuelosByCriteria(dao);
        System.out.println(lista.size());
        return null;
    }
    
    public static void main(String args[]){
        List<Vuelos> ls = SearchcriterioVuelos("a","d");
    }
}
