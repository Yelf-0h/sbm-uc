package edu.springboot.sbmuc.service;
import java.util.List;

public interface BaseService<T> {
    List<T> list();
    Long insert(T bean);
    Long delete(Long id);
    Long update(T bean);
    T load(Long id);
    Long count();
    List<T> pager(Long pageNum,Long pageSize);
    T loadByName(String name);
    Long countByName(String name);
    List<T> pagerByName(String name,Long pageNum,Long pageSize);
}
