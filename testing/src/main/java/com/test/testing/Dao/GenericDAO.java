package com.test.testing.Dao;

import com.test.testing.Model.GenericQuery;
import com.test.testing.Util.StaticVariable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GenericDAO<T> {

    protected EntityManager em;
    private Class<T> entityClass;

    public GenericDAO(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }
    public GenericDAO(){

    }
    public T create(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }

    public T update(T entity) {
        em.getTransaction().begin();
        T mergedEntity = em.merge(entity);
        em.getTransaction().commit();
        return mergedEntity;
    }

    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public T findById(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        return em.createQuery(all).getResultList();
    }
    public List<T> findListByWhereCondition (List<GenericQuery> query, StaticVariable.Condition condition){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        List<Predicate> predicateList = new ArrayList<>();
        query.forEach(x->{
            switch (x.getWhereCondition()){
                case id: {
                    predicateList.add(rootEntry.get("id").in(x.getValue()));
                    break;
                }
                case like: {
                    predicateList.add(cb.like(rootEntry.get(x.getWhereColumn()),x.getValue().toString()));
                    break;
                }
                case equal:{
                    predicateList.add(cb.equal(rootEntry.get(x.getWhereColumn()),x.getValue()));
                    break;
                }
                case between:{
                    if (x.getType() == GenericQuery.type.timestamp){
                        String dateFormat = "yyyy-MM-dd HH:mm:ss"; // the format of the date string in the object
                        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                        try {
                            predicateList.add(cb.between(rootEntry.get(x.getWhereColumn()),
                                    sdf.parse(x.getValue().toString()),
                                    sdf.parse(x.getValue2().toString())));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x.getType() == GenericQuery.type.integer){
                        predicateList.add(cb.between(rootEntry.get(x.getWhereColumn()),
                                Integer.parseInt(x.getValue().toString()),
                                Integer.parseInt(x.getValue2().toString())));
                    }
                    break;
                }
                case lesserOrEqual: {
                    if (x.getType() == GenericQuery.type.timestamp){
                        String dateFormat = "yyyy-MM-dd HH:mm:ss"; // the format of the date string in the object
                        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                        try {
                            predicateList.add(cb.lessThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                    sdf.parse(x.getValue().toString())));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x.getType() == GenericQuery.type.integer){
                        predicateList.add(cb.lessThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                Integer.parseInt(x.getValue().toString())));
                    }
                    break;
                }
                case greaterOrEqual:{
                    if (x.getType() == GenericQuery.type.timestamp){
                        String dateFormat = "yyyy-MM-dd HH:mm:ss"; // the format of the date string in the object
                        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                        try {
                            predicateList.add(cb.greaterThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                    sdf.parse(x.getValue().toString())));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x.getType() == GenericQuery.type.integer){
                        predicateList.add(cb.greaterThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                Integer.parseInt(x.getValue().toString())));
                    }
                    break;
                }
            }

        });
        if (predicateList.size() == 1){
            cq.where(predicateList.get(0));
            return em.createQuery(cq).getResultList();
        }
        Predicate predicate;
        if (condition == StaticVariable.Condition.or){
            predicate = cb.or(predicateList.toArray(new Predicate[0]));
        }
        else {
            predicate = cb.and(predicateList.toArray(new Predicate[0]));
        }
        cq.where(predicate);
        return em.createQuery(cq).getResultList();

    }
}