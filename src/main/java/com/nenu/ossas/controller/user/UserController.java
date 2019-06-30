package com.nenu.ossas.controller.user;

import com.nenu.ossas.entity.user.User;
import com.nenu.ossas.service.userservice.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Resource
    UserService userService;

    @ResponseBody
    @RequestMapping("delUser")
    public String delUser(User user){
        userService.delUser(user);
        return "success";
    }

    @RequestMapping("manage")
    public String toManage(){
        return "PAGES/manage";
    }

    @ResponseBody
    @RequestMapping("addUser")
    public String addUser(User user){
        System.out.println(user);
        userService.addUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping("listAll")
    public List getAllUsers(){
        List list = userService.getAllUsers();
        return list;
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        userService.logout();
        return "PAGES/login";
    }

    @RequestMapping("login")
    public String login(String username,String password, HttpServletRequest request){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在");
            return "redirect:toLogin";
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            return "redirect:toLogin";
        }
        HttpSession session = request.getSession();
        User user = (User)subject.getPrincipal();
        System.out.println(user);
        if (user.getPerms().equals("perm:add")) {
            session.setAttribute("perm", 0);
        }else {
            session.setAttribute("perm",1);
        }
        return "redirect:queryAM";
    }

    @RequestMapping("toHome")
    public String home(){
        return "PAGES/Home";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("unAuth")
    public String unAuthorized(){
        return "unAuth";
    }
}
