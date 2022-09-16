package edu.springboot.sbmuc.service.impl;

import edu.springboot.sbmuc.pojo.Member;
import edu.springboot.sbmuc.service.MemberService;
import edu.springboot.sbmuc.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yefl
 * @description 针对表【member(用户)】的数据库操作Service实现
 * @createDate 2022-09-07 08:49:57
 */
@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public List<Member> list() {
        return memberMapper.list();
    }

    @Override
    public Long insert(Member bean) {
        return memberMapper.insert(bean);
    }

    @Override
    public Long delete(Long id) {
        return memberMapper.delete(id);
    }

    @Override
    public Long update(Member bean) {
        return memberMapper.update(bean);
    }

    @Override
    public Member load(Long id) {
        return memberMapper.load(id);
    }

    @Override
    public Long count() {
        return memberMapper.count();
    }

    @Override
    public Member loadByName(String name) {
        return memberMapper.loadByName(name);
    }

    @Override
    public Long countByName(String name) {
        return memberMapper.countByName(name);
    }
    @Override
    public List<Member> pager(Long pageNum, Long pageSize) {
        pageNum = dealPageNum(pageNum,pageSize);
        pageSize = dealPageSize(pageNum,pageSize);
        return memberMapper.pager(pageNum,pageSize);
    }
    @Override
    public List<Member> pagerByName(String name, Long pageNum, Long pageSize) {
        pageNum = dealPageNum(pageNum, pageSize);
        pageSize = dealPageSize(pageNum, pageSize);
        return memberMapper.pagerByName(name, pageNum, pageSize);
    }



}
