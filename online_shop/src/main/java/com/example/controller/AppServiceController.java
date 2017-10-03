package com.example.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.model.AppService;
import com.example.service.AppServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppServiceController {

    @Autowired
    private AppServiceService appServiceService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/services")
    public List<AppService> getAllAppServices(){
        return appServiceService.getAllAppServices();
    }
   @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/services/{id}")
    public AppService getOneAppService (@PathVariable int id){
        return appServiceService.findOne(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/services")
    public void addAppService(@RequestBody AppService appService){
        appServiceService.addAppService(appService);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/services/{id}")
    public void putAppService(@PathVariable int id, @RequestBody AppService appService){
        appServiceService.putAppService(appService, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/services/{id}")
    public void deleteAppService(@PathVariable int id){
        appServiceService.deleteAppService(id);
    }
}
