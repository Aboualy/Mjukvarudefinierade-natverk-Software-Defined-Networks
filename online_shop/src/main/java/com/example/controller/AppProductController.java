package com.example.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.model.AppProduct;
import com.example.service.AppProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
public class AppProductController {

    @Autowired
    private AppProductService appProductService;
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public List<AppProduct> getAllAppProducts(){
        return appProductService.getAllAppProducts();
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public AppProduct getOneAppProduct (@PathVariable int id){
        return appProductService.findOne(id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addAppProduct(@RequestBody AppProduct appProduct){
        appProductService.addAppProduct(appProduct);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void putAppProduct(@PathVariable int id, @RequestBody AppProduct appProduct){
        appProductService.putAppProduct(appProduct, id);
    }
    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public void deleteAppProduct(@PathVariable int id){
        appProductService.deleteAppProduct(id);
    }
}
