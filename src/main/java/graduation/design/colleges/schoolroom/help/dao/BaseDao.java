package graduation.design.colleges.schoolroom.help.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import graduation.design.colleges.schoolroom.help.pagination.Page;

/**
 @Author 王钟鑫
 @date 2017年12月2日 下午11:26:08
 @see 封装基础的Dao操作
 */
public interface BaseDao<T> {
   
	public List<T> findPage(Page page); //分页查询
	public List<T> find(Map<?, ?> paraMap);    //带条件查询
	public T get(Serializable id);       //获取单条数据
	public void insert(T entity);        //插入   用实体作为参数
	public void update(T entity);        //修改   用实体作为参数
	public void delete(Serializable id);  //删除
	public void delete(Serializable[] ids); //批量删除
}
