package edu.springboot.sbmuc;

import edu.springboot.sbmuc.mapper.MemberMapper;
import edu.springboot.sbmuc.pojo.Member;
import edu.springboot.sbmuc.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SbmUcApplicationTests {

    @Autowired
    MemberService memberService;
    @Test
    void contextLoads() {
        List<Member> list = memberService.list();
        list.forEach(System.out::println);
    }

}
