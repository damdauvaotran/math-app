/*++*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import javax.servlet.http.HttpSession;
import model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Nghĩa Phan
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {
    private UserModel usermodel;

    public UserController() {
        usermodel = new UserModel();
    }
    @RequestMapping(value = "/initLogin")
    public ModelAndView initLogin(){
        ModelAndView mav = new ModelAndView("login");
        User user = new User();
        mav.addObject("userLogin", user);
        return mav;
    }
    
//    @RequestMapping(value = "/initLog")
//    public String test(Model model){
//        model.addAttribute("userLogin", new User());
//        return "login";
//    }
    
    @RequestMapping(value = "/login")
    public String checkUser (HttpSession session,User userLogin){
        //Ktra user co ton tai hay k
        boolean check = usermodel.checkUser(userLogin);
        if (check) {
            session.setAttribute("userName", userLogin.getUserName());
            session.setAttribute("passWord", userLogin.getPassWord());
            return "success";
        }else{
            return "error";
        }
    }
}
