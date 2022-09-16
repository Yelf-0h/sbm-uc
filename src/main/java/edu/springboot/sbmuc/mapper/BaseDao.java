package edu.springboot.sbmuc.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    List<T> list();
    Long insert(T bean);
    Long delete(Long id);
    Long update(T bean);
    T load(Long id);
    Long count();
    T loadByName(String name);
    Long countByName(String name);
    /**
     * 分页
     *
     * 方法参数超过一个，MyBatis要求使用@Param注解标明参数名称；
     * 否则，运行出错。
     *
     */
    List<T> pager(
            @Param("pageNum") Long pageNum, @Param("pageSize") Long pageSize);
    /**
     * 分页: 按查找的名称
     *
     * 方法参数超过一个，MyBatis要求使用@Param注解标明参数名称；
     * 否则，运行出错。
     */
    List<T> pagerByName(@Param("name") String name
            , @Param("pageNum") Long pageNum, @Param("pageSize") Long pageSize);
}
