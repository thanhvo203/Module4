package com.example.demo1.repository.impl;

import com.example.demo1.model.Product;
import com.example.demo1.repository.ConnectionUtils;
import com.example.demo1.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import static com.example.demo1.repository.ConnectionUtils.getEntityManager;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private static final String SELECT_ALL = "FROM Product";
    private static final String FIND_BY_ID = "from Product as p where p.id = :id";
    private static final String FIND_ID_PRODUCT = "select id from Product";

    @Override
    public List<Product> getListProduct() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL).getResultList();
    }

    @Override
    public void createProduct(Product product) {
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
    public void deleteProduct(int id) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(getProductByID(id));
            transaction.commit();
            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }


    @Override
    public void editProduct( int id,Product product) {
      Session session = null;
      Transaction transaction = null;
      try{
          session = ConnectionUtils.getSessionFactory().openSession();
          transaction = session.beginTransaction();
          session.saveOrUpdate(product);
          transaction.commit();
          ConnectionUtils.getEntityManager().clear();
      }catch (Exception e){
          e.printStackTrace();
          if (transaction != null){
              transaction.rollback();
          }
      }finally {
          if (session != null){
              session.close();
          }
      }
    }


    @Override
    public Product getProductByID(int id) {
        TypedQuery<Product> productTypedQuery = getEntityManager().createQuery(FIND_BY_ID, Product.class);
        productTypedQuery.setParameter("id", id);
        return productTypedQuery.getSingleResult();
    }

    @Override
    public List<Product> searchProduct(String name) {
        TypedQuery<Product> productTypedQuery = getEntityManager().createQuery("from Product as p where p.name like concat('%',:name,'%')", Product.class);
        productTypedQuery.setParameter("name", name);
        return productTypedQuery.getResultList();
    }

    @Override
    public boolean checkID(int id) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Integer> integerTypedQuery = session.createQuery(FIND_ID_PRODUCT);
        List<Integer> list = integerTypedQuery.getResultList();
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i)) {
                return true;
            }
        }
        return false;
    }
}
