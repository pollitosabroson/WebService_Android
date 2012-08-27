/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hibernate.model.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.model.Vuelos;

/**
 *
 * @author pollito
 */
public class VuelosDao {

    Session sn = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = null;
    Query qr = null;

    public List<Vuelos> readVuelos() {
        List<Vuelos> list = null;
        try {
            tx = sn.beginTransaction();
            qr = sn.createQuery("FROM Vuelos");
            list = qr.list();
            tx.commit();
            return list;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return list;
        }
    }


    public Vuelos findVuelosById(int id) {
        Vuelos vu = new Vuelos();
        try {
            tx = sn.beginTransaction();
            vu = (Vuelos) sn.get("org.hibernate.model.Vuelos", id);
            tx.commit();
            return vu;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return vu;
        }
    }

    public List<Vuelos> findVuelosByCriteria(Vuelos instance) {
        List<Vuelos> lis = null;
        try {
            tx = sn.beginTransaction();
            lis = sn.createCriteria("org.hibernate.model.Vuelos")
                    .add(Example.create(instance)).list();
            tx.commit();
            return lis;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return lis;
        }
    }
}
