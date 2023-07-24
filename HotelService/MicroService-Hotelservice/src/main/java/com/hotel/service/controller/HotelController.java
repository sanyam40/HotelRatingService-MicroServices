package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entity.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        System.out.println(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('SCOPE_internal')")
    public ResponseEntity<Hotel> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
    }
}
