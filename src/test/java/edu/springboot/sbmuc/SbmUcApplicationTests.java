package edu.springboot.sbmuc;

import edu.springboot.sbmuc.mapper.MemberMapper;
import edu.springboot.sbmuc.pojo.Member;
import edu.springboot.sbmuc.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Duration;
import java.util.List;

@Slf4j
@SpringBootTest
@DisplayName("这是测试类")
class SbmUcApplicationTests {

    @Autowired
    MemberService memberService;

    @Test
    void contextLoads() {
        List<Member> list = memberService.list();
        list.forEach(System.out::println);
    }

    @BeforeAll
    static void begin() {
        log.info("********************************************");
        log.info("***** 测试模块：开始 ");
        log.info("********************************************");
    }

    @AfterAll
    static void end() {
        log.info("********************************************");
        log.info("***** 测试模块：结束 ");
        log.info("********************************************");
    }

    @BeforeEach
    void start() {
        log.info("--------------------------------------------");
        log.info("----- 测试方法：开始 ");
        log.info("--------------------------------------------");
    }

    @AfterEach
    void stop() {
        log.info("--------------------------------------------");
        log.info("----- 测试方法：结束 ");
        log.info("--------------------------------------------");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DisplayName("直接统计行数")
    @Test
    void countMember() {
        String sql = "select count(1) from member";
        Long num = jdbcTemplate.queryForObject(sql, Long.class);
        log.info("直接统计member的行数：" + num);
    }

    @DisplayName("三层统计行数")
    @Test
    void countMember2() {
        Long num = memberService.count();

        log.info("三层统计member的行数：" + num);
    }

    @DisplayName("使用断言判断三层统计行数")
    @Test
    void countMember3() {
        Long expected = 9L; // 期望值
        Long actual = memberService.count(); // 真实值
// 断言：判断期望值和真实值是否相等。true则测试通过，false则测试未通过
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        Long age = 1L;
        if (age < 0) {
            Assertions.fail("Age 不能小于零。");
        }
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
//扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));
    }

    @Test
    @DisplayName("超时断言测试")
    public void timeOutTest() {
        Assertions.assertTimeout(Duration.ofMillis(1000),()->{Thread.sleep(999);},"超时了");
    }

    @Test
    @DisplayName("assert all")
    public void all() {
        Assertions.assertAll("Math",
                () -> Assertions.assertEquals(2, 1 + 1),
                () -> Assertions.assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }
    @Test
    @DisplayName("simple assertion")
    public void simple() {
        Assertions.assertEquals(3, 1 + 2, "simple math");

        Assertions.assertNotEquals(3, 1 + 1);
        Assertions.assertNotSame(new Object(), new Object());
        Object obj = new Object();
        Assertions.assertSame(obj, obj);
        Assertions.assertFalse(1 > 2);
        Assertions.assertTrue(1 < 2);
        Assertions.assertNull(null);
        Assertions.assertNotNull(new Object());
    }


}
