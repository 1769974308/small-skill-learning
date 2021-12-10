package com.taotao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther ASUS
 * @date 2021/11/30
 */
@Controller
@RequestMapping("/docker")
public class DockerRegistryController {

    @GetMapping("/registry")
    @ResponseBody
    public String registry(){

        return  "maven plugin packaging  image successful ！！！ ";
    }
}
