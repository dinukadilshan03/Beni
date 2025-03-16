package com.Beni.Backend.album_portfolio_management.controller;

import com.Beni.Backend.album_portfolio_management.model.Album;
import com.Beni.Backend.album_portfolio_management.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    public Album createAlbum(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam List<MultipartFile> images,
            @RequestParam MultipartFile coverImage,
            @RequestParam String category,
            @RequestParam String location,
            @RequestParam String status) {
        return albumService.createAlbum(name, description, images, coverImage, category, location, status);
    }
}