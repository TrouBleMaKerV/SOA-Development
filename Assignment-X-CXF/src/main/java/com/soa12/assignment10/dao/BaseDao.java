package com.soa12.assignment10.dao;

import java.util.List;

public interface BaseDao {

    public Object load(Class c, String id) ;

    public Object load(Class c, int id) ;

    public List<Object> load(Class c, String name, String value);

    public List<Object> load(Class c, String name, int value);

    public List getAllList(Class c, String id) ;

    public void save(Object bean) ;

    public void update(Object bean);

}
