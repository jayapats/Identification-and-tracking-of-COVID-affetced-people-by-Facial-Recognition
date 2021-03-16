package com.example.service.repository;

import com.example.service.crud.ImageRepository;
import com.example.service.objects.binding.Image;
import com.example.service.objects.request.SaveImage;
import com.example.service.objects.request.SaveImageDB;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

@Repository
public class ImageRepo {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    RestTemplate restTemplate;

    String url = "http://127.0.0.1:5000/";

    public boolean addImage(SaveImage saveImage){
        String response = saveImageToLocal(saveImage);

        if(response.equals("True"))
            return true;
        return false;
     /*   Image image = populateImage(saveImage);
        imageRepository.save(image);
        return true;*/
    }


    public boolean addImageDB(SaveImageDB saveImageDB)  {

        String response = saveImageToLocalFolder(saveImageDB);

        Image image = populateImage(saveImageDB);
        System.out.println("Image data set!!");
        imageRepository.save(image);
        System.out.println("Image Saved to DB!");
        //return true;

        if(response.equals("True"))
            return true;
        return false;
    }

    public String getMatch(SaveImage saveImage){
        return  getMatchFromFlask(saveImage);

    }

    private String getMatchFromFlask(SaveImage saveImage)   {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/getMatch")
                .queryParam("encoded", saveImage.getImageData());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.PUT,
                entity,
                String.class);
        return response.getBody();

    }

    private String saveImageToLocal(SaveImage saveImage)   {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/addImage")
                .queryParam("encoded", saveImage.getImageData())
                .queryParam("name", saveImage.getName());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.PUT,
                entity,
                String.class);
        return response.getBody();

    }

    private String saveImageToLocalFolder(SaveImageDB saveImageDB)   {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"/addImage")
                .queryParam("encoded", saveImageDB.getImageData())
                .queryParam("name", saveImageDB.getName());
        HttpEntity<?> entity = new HttpEntity<>(headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.PUT,
                entity,
                String.class);
        return response.getBody();

    }

    private Image populateImage(SaveImageDB saveImageDB)  {
        Image image = new Image();
        image.setName(saveImageDB.getName());
        image.setLoc(saveImageDB.getLoc());
        //image.setImageData(saveImageDB.getImageData());

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(saveImageDB.getDateTime());
        System.out.println("Java's Default Date Format: " + mysqlDateString);

        image.setDateTime(saveImageDB.getDateTime());
        return image;
    }


    public static byte convertStringToByte(String str)
    {
        // Convert string to byte
        // using parseByte() method
        return Byte.parseByte(str);
    }
}
