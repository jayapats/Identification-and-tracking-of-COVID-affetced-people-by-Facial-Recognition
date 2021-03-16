package com.example.service.service;

import com.example.service.objects.request.SaveImage;
import com.example.service.objects.request.SaveImageDB;
import com.example.service.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    ImageRepo imageRepo;

    public boolean saveImage(SaveImage saveImage){
    return imageRepo.addImage(saveImage);
    }

    public boolean saveImageDB(SaveImageDB saveImageDB)  {
        return imageRepo.addImageDB(saveImageDB);
    }

    public String getMatch(SaveImage saveImage){
        return imageRepo.getMatch(saveImage);
    }
}
