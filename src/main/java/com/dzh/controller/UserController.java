package com.dzh.controller;

import com.dzh.entity.Admin;
import com.dzh.entity.User;
import com.dzh.exception.UserExceptin;
import com.dzh.handler.UserExceptionHandler;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@Controller
//@RestController = @Controller +  @ResponseBody

//@RequestMapping(path="user",params = "name",method = RequestMethod.GET)

@RequestMapping("user")
/*
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
 */
public class UserController {

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request) {

        System.out.println("登录");
        String name = request.getParameter("name");
        String token = request.getHeader("token");

        System.out.println(token);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",name);
        modelAndView.setViewName("/login/login");

        return modelAndView;
    }

    @RequestMapping("admin01")
    public Admin login01(@RequestBody String name){
        System.out.println("login01");
        System.out.println(name);
        Admin admin = new Admin(1001, name, 123, new Date());
        System.out.println(admin);
        return admin;
    }

    @RequestMapping("register")
    public ModelAndView register(User user) {

        System.out.println("注册");
        System.out.println(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",user.getName());
        modelAndView.addObject("birthDay",user.getBirthDay());

        modelAndView.addObject("list",user.getList());

        modelAndView.addObject("map",user.getMap());

        modelAndView.setViewName("/register/success");

        return modelAndView;
    }

    /**
     * 传参数方式1
     * @param id 查询id
     */

    @RequestMapping("findById01")
    public void findById01(@RequestParam(value = "uid",required = false,defaultValue = "1002") Integer id) {
        User user = new User(id, "dzh", 123);

        System.out.println(user);
    }

    /**
     * 传参数方式2
     * @param id 查询id
     */
    @RequestMapping("findById02/{id}")
    public void findById02(@PathVariable("id") Integer id) {
        User user = new User(id, "dzh", 123);

        new User(1, "dzh", 1, "1");
        System.out.println(user);
    }
    /**
     *
     * @param id 查询id
     * @return admin 的 json 数据
     */
    @RequestMapping("findById03/{id}")
    @ResponseBody()
    public Admin findAdminById01(@PathVariable("id") Integer id) {

        return new Admin(id, "dzh", 123,new Date());

    }

    /**
     * 查询所有数据 并返回json数据
     * @return admin 返回前端json数据
     */
    @RequestMapping("findById04")
    @ResponseBody
    public ArrayList<Admin> findAdminAll() {

        //模拟数据库查询
        ArrayList<Admin> admins = new ArrayList<>();
        admins.add(new Admin(1001,"dzh",123,new Date()));
        admins.add(new Admin(1002,"lucky",456,new Date()));
        
        admins.add(new Admin(1003,"杰瑞",789,new Date()));
        admins.add(new Admin(1004,"汤姆",666,new Date()));

        return admins;
    }

    @RequestMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) {

        String uploadPath = "/Users/lucky/Downloads/file/";

        String filename = file.getOriginalFilename();
        System.out.println(filename);

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        String newName = uuid + filename;


        File files = new File(uploadPath, newName);

        try {
            file.transferTo(files);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "success";
    }

    @RequestMapping("textException")

    public void textException() throws UserExceptin {
        int i = 1 / 0;
    }

}
