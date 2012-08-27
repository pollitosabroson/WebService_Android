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
import org.hibernate.model.Reservaciones;

/**
 *
 * @author pollito
 */
public class ReservacionesDao {

    Session sn = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = null;
    Query qr = null;

    public boolean createReservaciones(Reservaciones instance) {
        try {
            tx = sn.beginTransaction();
            sn.save(instance);
            tx.commit();
            return true;

        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return false;
        }
    }

    public List<Reservaciones> readReservaciones() {
        List<Reservaciones> list = null;
        try {
            tx = sn.beginTransaction();
            qr = sn.createQuery("FROM Reservaciones");
            list = qr.list();
            tx.commit();
            return list;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return list;
        }
    }

    public boolean updateReservaciones(Reservaciones instance) {
        try {
            tx = sn.beginTransaction();
            sn.update(instance);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return false;
        }
    }

    public boolean deleteReservaciones(Reservaciones instance) {
        try {
            tx = sn.beginTransaction();
            sn.delete(instance);
            tx.commit();
            return true;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return false;
        }
    }

    public Reservaciones findReservacionesById(int id) {
        Reservaciones re = new Reservaciones();
        try {
            tx = sn.beginTransaction();
            re = (Reservaciones) sn.get("org.hibernate.model.Reservaciones", id);
            tx.commit();
            return re;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return re;
        }
    }

    public List<Reservaciones> findReservacionesByCriteria(Reservaciones instance) {
        List<Reservaciones> lis = null;
        try {
            tx = sn.beginTransaction();
            lis = sn.createCriteria("org.hibernate.model.Reservaciones")
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
