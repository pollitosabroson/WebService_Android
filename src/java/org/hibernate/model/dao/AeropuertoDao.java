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
import org.hibernate.model.Aeropuerto;

/**
 *
 * @author pollito
 */
public class AeropuertoDao {
    Session sn = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = null;
    Query qr = null;
    
    public List<Aeropuerto> readAeropuerto() {
        List<Aeropuerto> list = null;
        try {
            tx = sn.beginTransaction();
            qr = sn.createQuery("FROM Aeropuerto");
            list = qr.list();
            tx.commit();
            return list;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return list;
        }
    }

    public Aeropuerto findAeropuertoById(int id) {
        Aeropuerto pci = new Aeropuerto();
        try {
            tx = sn.beginTransaction();
            pci = (Aeropuerto) sn.get("org.hibernate.model.Aeropuerto", id);
            tx.commit();
            return pci;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return pci;
        }
    }

    public List<Aeropuerto> findAeropuertoByCriteria(Aeropuerto instance) {
        List<Aeropuerto> lis = null;
        try {
            tx = sn.beginTransaction();
            lis = sn.createCriteria("org.hibernate.model.Aeropuerto")
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
