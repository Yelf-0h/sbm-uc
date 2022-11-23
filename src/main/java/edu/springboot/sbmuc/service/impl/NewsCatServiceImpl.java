package edu.springboot.sbmuc.service.impl;

import edu.springboot.sbmuc.mapper.NewsCatMapper;
import edu.springboot.sbmuc.pojo.NewsCat;

import edu.springboot.sbmuc.service.NewsCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yefl
 * @description 针对表【NewsCat(用户)】的数据库操作Service实现
 * @createDate 2022-09-07 08:49:57
 */
@Service
public class NewsCatServiceImpl extends BaseServiceImpl<NewsCat> implements NewsCatService {

    @Autowired
    private NewsCatMapper newsCatMapper;

    @Override
    public List<NewsCat> list() {
        return newsCatMapper.list();
    }

    @Override
    public Long insert(NewsCat bean) {
        return newsCatMapper.insert(bean);
    }

    @Override
    public Long delete(Long id) {
        return newsCatMapper.delete(id);
    }

    @Override
    public Long update(NewsCat bean) {
        return newsCatMapper.update(bean);
    }

    @Override
    public NewsCat load(Long id) {

        return newsCatMapper.load(id);
    }

    @Override
    public Long count() {
        return newsCatMapper.count();
    }

    @Override
    public NewsCat loadByName(String name) {
        return newsCatMapper.loadByName(name);
    }

    @Override
    public Long countByName(String name) {
        return newsCatMapper.countByName(name);
    }
    @Override
    public List<NewsCat> pager(Long pageNum, Long pageSize) {
        pageNum = dealPageNum(pageNum,pageSize);
        pageSize = dealPageSize(pageNum,pageSize);
        return newsCatMapper.pager(pageNum,pageSize);
    }
    @Override
    public List<NewsCat> pagerByName(String name, Long pageNum, Long pageSize) {
        pageNum = dealPageNum(pageNum, pageSize);
        pageSize = dealPageSize(pageNum, pageSize);
        return newsCatMapper.pagerByName(name, pageNum, pageSize);
    }



}
