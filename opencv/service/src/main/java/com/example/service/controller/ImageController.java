package com.example.service.controller;

import com.example.service.objects.request.SaveImage;
import com.example.service.objects.request.SaveImageDB;
import com.example.service.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/saveImage")
    boolean saveImage(@RequestBody SaveImage saveImage){

        return(imageService.saveImage(saveImage));

    }

    @PostMapping("/getMatch")
    String getMatch(@RequestBody SaveImage saveImage){

        return(imageService.getMatch(saveImage));

    }

    @PostMapping("/saveImagetoDB")
    boolean saveImageDB(@RequestBody SaveImageDB saveImageDB) throws IOException {
        System.out.println("Image Controller!!!");
        return(imageService.saveImageDB(saveImageDB));

    }
}
