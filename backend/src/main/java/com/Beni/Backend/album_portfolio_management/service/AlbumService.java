package com.Beni.Backend.album_portfolio_management.service;

import com.Beni.Backend.album_portfolio_management.model.Album;
import com.Beni.Backend.album_portfolio_management.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public Album createAlbum(
            String name,
            String description,
            List<MultipartFile> images,
            MultipartFile coverImage,
            String category,
            String location,
            String status) {

        // Save the uploaded images and get their paths
        List<String> imagePaths = fileStorageService.saveFiles(images);
        String coverImagePath = fileStorageService.saveFile(coverImage);

        // Create and save the album
        Album album = new Album();
        album.setName(name);
        album.setDescription(description);
        album.setImages(imagePaths);
        album.setCoverImage(coverImagePath);
        album.setCategory(category);
        album.setLocation(location);
        album.setStatus(status);

        return albumRepository.save(album);
    }
}