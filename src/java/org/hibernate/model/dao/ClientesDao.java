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
import org.hibernate.model.Clientes;

/**
 *
 * @author pollito
 */
public class ClientesDao {
    
    Session sn = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction tx = null;
    Query qr = null;
    
    public boolean createClientes(Clientes instance) {
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

    public List<Clientes> readClientes() {
        List<Clientes> list = null;
        try {
            tx = sn.beginTransaction();
            qr = sn.createQuery("FROM Clientes");
            list = qr.list();
            tx.commit();
            return list;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return list;
        }
    }

    public boolean updateClientes(Clientes instance) {
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

    public boolean deleteClientes(Clientes instance) {
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

    public Clientes findClientesById(int id) {
        Clientes cl = new Clientes();
        try {
            tx = sn.beginTransaction();
            cl = (Clientes) sn.get("org.hibernate.model.Clientes", id);
            tx.commit();
            return cl;
        } catch (HibernateException he) {
            tx.rollback();
            System.out.println(he.getMessage());
            return cl;
        }
    }

    public List<Clientes> findClientesByCriteria(Clientes instance) {
        List<Clientes> lis = null;
        try {
            tx = sn.beginTransaction();
            lis = sn.createCriteria("org.hibernate.model.Clientes")
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
