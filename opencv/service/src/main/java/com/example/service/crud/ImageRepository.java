package com.example.service.crud;

import com.example.service.objects.binding.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,  Integer> {
}
