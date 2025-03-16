package com.Beni.Backend.album_portfolio_management.service;

import com.Beni.Backend.album_portfolio_management.model.Album;
import com.Beni.Backend.album_portfolio_management.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album createAlbum(Album album) {
        // The releaseDate will be automatically set when saving the album
        return albumRepository.save(album);
    }
}