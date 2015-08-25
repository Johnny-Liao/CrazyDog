package org.crazydog;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;
import java.util.Map;

/**
 * 本类是DAO工具类，定义了dao基本的操作接口，并且支持进行复杂的hql查询
 * 支持分页查询
 * Created by never on 2015/8/25.
 */
public abstract class Basedao<T> {

    @Autowired
    protected HibernateTemplate hibernateTemplate;

    /**
     * 添加实体
     *
     * @param t 实体对象
     */
    public abstract void addEntity(T t);

    /**
     * 修改实体
     *
     * @param t 实体对象
     */
    public abstract void modifyEntity(T t);

    /**
     * load具有懒加载效果，获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public abstract T loadEntity(int id);

    /**
     * 获得实体类
     *
     * @param id 实体对象的id
     * @return
     */
    public abstract T getEntity(int id);

    /**
     * 获得所有的实体类
     *
     * @return
     */
    public abstract List<T> getAllEntities();


    /**
     * 删除指定的某个实体
     *
     * @param t 实体对象
     * @return
     */
    public abstract void deleteEntity(T t);

    /**
     * 使用hql语言进行查询操作
     *
     * @param hql hql语句
     * @return
     */
    public List<T> find(String hql) {
        Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
        return q.list();
    }

    /**
     * 提供Map对应的传参hql查询
     * <p>
     * from table t where t.id =:id and t.name=:name
     * map中应该这样添加
     * map.put("id",Id);
     * map.put("name",Name);
     *
     * @param hql    hql语句
     * @param params 参数集
     * @return hql语句的结果集
     */
    public List<T> find(String hql, Map<String, Object> params) {
        Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.list();
    }

    /**
     * 支持分页查询提供Map对应的传参hql查询
     * <p>
     * from table t where t.id =:id and t.name=:name
     * map中应该这样添加
     * map.put("id",Id);
     * map.put("name",Name);
     *
     * @param hql    hql语句
     * @param params 参数集
     * @param page   分页中页数
     * @param rows   每页中的行数
     * @return hql语句的结果集
     */
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

    /**
     * 支持分页查询hql查询
     * <p>
     * from table t where t.id =:id and t.name=:name
     * map中应该这样添加
     * map.put("id",Id);
     * map.put("name",Name);
     *
     * @param hql  hql语句
     * @param page 分页中页数
     * @param rows 每页中的行数
     * @return hql语句的结果集
     */
    public List<T> find(String hql, int page, int rows) {
        Query q = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }
}
