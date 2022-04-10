package com.laioffer.onlinefoodorder.controller;

import com.laioffer.onlinefoodorder.entity.MenuItem;
import com.laioffer.onlinefoodorder.entity.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import java.util.List;

@Controller
public class MenuInfoController {
    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {
        //@PathVariable:  can be used to handle template variables in the request URI mapping.
        return new ArrayList<>();
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    //this is used to convert object to json (from Spring MVC)
    public List<Restaurant> getRestaurants() {
        return new ArrayList<>();
    }
}

