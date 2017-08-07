package com.keruis.report.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/11/22.
 */
@Controller
public class BaseController {
//    @Autowired
//    protected HttpServletRequest req;
//    @Autowired
//    HttpSession httpSession;


    protected HttpServletRequest req;
    protected HttpServletResponse res;
    protected HttpSession httpSession;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest req, HttpServletResponse res){
        this.req = req;
        this.res = res;
        this.httpSession = req.getSession();
    }

}
