package com.Beni.Backend.album_portfolio_management.repository;

import com.Beni.Backend.album_portfolio_management.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}