package com.myshop.dao.plate;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;

import org.springframework.orm.jpa.JpaTemplate;

import com.myshop.domain.plate.Plat;

public abstract class AbstractDAO<T>  {
        
        private Class<T> entityClass;
        
        protected JpaTemplate jpaTemplate;

        protected Class<T> getEntityClass() {
                return entityClass;
        }
        
        @PersistenceContext
        public void setEntityManagerFactory(EntityManagerFactory emf) {
                this.jpaTemplate = new JpaTemplate(emf);
        }

        @SuppressWarnings("unchecked")
        public AbstractDAO(Class<T> entityClass) {
                this.entityClass = entityClass;
        }
        
     

        @SuppressWarnings("unchecked")
        public Collection<T> getAll() {
                return jpaTemplate.find("from " + entityClass.getSimpleName());
        }

        public void persist(T t) {
    		jpaTemplate.persist(t);
    	}
        
        public T getById(Long id) {
                return jpaTemplate.find(entityClass, id);
        }
        
        public void remove(T t) {
                jpaTemplate.remove(t);          
        }

        /*
        public void removeById(final Long id) {
                jpaTemplate.execute(new JpaCallback() {
                        @Override
                        public Object doInJpa(EntityManager em) {
                                Query q = 
                                        em.createQuery("delete " + entityClass.getSimpleName() + " e where e.id = :id");
                                q.setParameter("id", id);
                                q.executeUpdate();
                                return null;
                        }
                });
        }*/
        
        public void removeById(final Long id) {
                jpaTemplate.remove(jpaTemplate.find(entityClass, id));
                /*jpaTemplate.execute(new JpaCallback() {
                        @Override
                        public Object doInJpa(EntityManager em) {
                                Object entity = em.find(entityClass, id);
                                em.remove(entity);
                                return null;
                        }
                });*/
        }
        
        
        public void update(T t) {
                jpaTemplate.merge(t);
        }

}
