package edu.springboot.sbmuc.mapper;

import edu.springboot.sbmuc.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author Yefl
 * @description 针对表【member(用户)】的数据库操作Mapper
 * @createDate 2022-09-07 08:49:57
 * @Entity edu.springboot.sbmuc.pojo.Member
 */

public interface MemberMapper extends BaseDao<Member>{

}
