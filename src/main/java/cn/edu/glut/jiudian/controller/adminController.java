package cn.edu.glut.jiudian.controller;

import cn.edu.glut.jiudian.entity.Admin;
import cn.edu.glut.jiudian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author stone(huangshizhang) at 2019-06-12 11:24
 */
@Controller
public class adminController {
    //ddddd
    @Autowired
    private UserService userService;

    @RequestMapping("updateAdminPassword")
    @ResponseBody
    public Object updateAdminPassword(Admin admin){
        HashMap<String, String> res = new HashMap<>();
        if (userService.updateAdminPassword(admin)) {
            res.put("stateCode", "1");
        } else {
            res.put("stateCode", "0");
        }
        return res;
    }

}
