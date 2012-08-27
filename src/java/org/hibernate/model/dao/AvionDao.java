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
import org.hibernate.model.Avion;

/**
 *
 * @author pollito
 */
public class AvionDao {
    Session sn = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = null;
    Query qr = null;
    
    public List<Avion> readAvion() {
        List<Avion> list = null;
        try {
            tx = sn.beginTransaction();
            qr = sn.createQuery("FROM Avion");
            list = qr.list();
            tx.commit();
            return list;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return list;
        }
    }

    public Avion findAvionById(int id) {
        Avion av = new Avion();
        try {
            tx = sn.beginTransaction();
            av = (Avion) sn.get("org.hibernate.model.Avion", id);
            tx.commit();
            return av;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return av;
        }
    }

    public List<Avion> findAvionByCriteria(Avion instance) {
        List<Avion> lis = null;
        try {
            tx = sn.beginTransaction();
            lis = sn.createCriteria("org.hibernate.model.Avion")
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
