package com.carpool.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.carpool.model.Login;
import com.carpool.model.DriverTripResponse;
import com.carpool.service.LoginService;

import java.util.List;

/**
 * Created by Shawn on 12/11/2016.
 */

@Controller
@RequestMapping("/login")


public class LoginController {

    private LoginService loginService;



    @RequestMapping(method = RequestMethod.GET)

    public String loadhome(ModelMap model)
    {
        return "login";
    }

}
