package com.Beni.Backend.album_portfolio_management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/album/management")

public class AlbumController {

    @GetMapping
    public String testPrint(){
        return "Work Properly";
    }
}
