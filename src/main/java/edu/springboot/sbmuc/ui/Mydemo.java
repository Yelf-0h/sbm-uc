package edu.springboot.sbmuc.ui;

import edu.springboot.sbmuc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Yelf
 * @create 2022-09-07-9:10
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/mydemo")
public class Mydemo {

    @GetMapping("/hello")
    public String hello(){
        return "21软专1班20210340839叶凌发，您好。";
    }

    @Autowired
    MemberService memberService;


    @GetMapping("/member_list")
    public Object member_list(){
        return memberService.list();
    }

    @GetMapping("/member_pager")
    public Object member_pager(@RequestParam("pageNum") Long pageNum,
                               @RequestParam("pageSize") Long pageSize){
        return memberService.pager(pageNum, pageSize);
    }
    @GetMapping("/member_pagerByName")
    public Object member_pagerByName(@RequestParam("name") String name,
                                     @RequestParam("pageNum") Long pageNum, @RequestParam("pageSize") Long pageSize) {
        return memberService.pagerByName(name, pageNum, pageSize);
    }

    @GetMapping("/member_load/{id}") // /member_load/1
    public Object member_load(@PathVariable("id") Long id){
        return memberService.load(id);
    }
    @GetMapping("/member_loadByName/{name}") // /member_loadByName/admin
    public Object member_loadByName(@PathVariable("name") String name){
        return memberService.loadByName(name);
    }
    @GetMapping("/member_count") // /member_count
    public Object member_count(){
        return memberService.count();
    }
    @GetMapping("/member_countByName/{name}") // /member_countByName/s
    public Object member_countByName(@PathVariable("name") String name) {
        return memberService.countByName(name);
    }


    }
