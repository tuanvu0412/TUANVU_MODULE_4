package com.example.ss4_thymeleaf.repo;

import com.example.ss4_thymeleaf.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;



@Repository
public class ProductRepo implements IProductRepo {
    private static final String SELECT_ALL_PRODUCTS_QUERY = "SELECT p FROM Product AS p";
    private static final String queryStr="SELECT p FROM Product AS p WHERE p.name like concat('%',:name,'%')";
    @Override
    public List<Product> getList() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCTS_QUERY).getResultList();
    }

    @Override
    public void addNewProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).getId() == id) {
                return getList().get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product productOne =findById(product.getId());
            productOne.setName(product.getName());
            productOne.setPrice(product.getPrice());
            session.update(productOne);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void remove(int id) {
        for (Product p : getList()) {
            if (p.getId() == id) {
                Session session = null;
                Transaction transaction = null;
                try {
                    session = ConnectionUtils.getSessionFactory().openSession();
                    transaction = session.beginTransaction();
                    session.delete(p);
                    transaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (transaction != null) {
                        transaction.rollback();
                    }
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
            }
        }

    }

    @Override
    public List<Product> findOne(String name) {
        Session session=ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Product>query=  session.createQuery(queryStr,Product.class);
        query.setParameter("name",name);
        return query.getResultList();
    }
}
