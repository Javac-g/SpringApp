package com.MAX.v8.Controller;

import com.MAX.v8.Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Main")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private Service_Main serviceMain;


    public Controller(Service_Main serviceMain) {
        this.serviceMain = serviceMain;
    }



    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addUser(@RequestBody RequestDTO user){
        logger.info("Post mapping --- https:192.168.0.102:8080/Main/addUser --- body-" + user);
        return serviceMain.Create(user);
    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findUser(@RequestParam Integer id){
        logger.info("Get mapping --- https:192.168.0.102:8080/Main/f?id = " + id);
        return serviceMain.Read(id);
    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateUser(@RequestParam Integer id,
                                  @RequestBody RequestDTO user){
        logger.info("Put mapping --- https:192.168.0.102:8080/Main/u?id=" + id);
        logger.info("body - " + user);
        return serviceMain.update(id,user);
    }

    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteUser(@RequestParam Integer id){
        if (id < 2){
            logger.info("Post mapping - Method A - https:192.168.0.102:8080/Main/d?id =" + id);
            return serviceMain.print("Was deleted person N: " + serviceMain.deleteA(id));
        } else if (id >= 2) {
            logger.info("Post mapping - Method B - https:192.168.0.102:8080/Main/d?id =" + id);
            return serviceMain.print("Was deleted person N: ") + serviceMain.deleteB(id);
        }
        return "Nope";
    }
}
