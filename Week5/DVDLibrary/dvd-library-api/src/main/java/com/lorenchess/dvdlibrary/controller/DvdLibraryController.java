package com.lorenchess.dvdlibrary.controller;


import com.lorenchess.dvdlibrary.model.DvdLibrary;
import com.lorenchess.dvdlibrary.services.DvdLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000") //authorization to have access to the data passed by the user catch in our web app UI
@RestController
@RequestMapping("/api/")
public class DvdLibraryController {

    private final DvdLibraryService service;

    @Autowired
    public DvdLibraryController(
            DvdLibraryService service) {
        this.service = service;
    }

    @PostMapping("/dvd")
    public DvdLibrary createDvd(@RequestBody DvdLibrary dvd) {
        return service.createDvd(dvd);
    }

    @GetMapping("/dvd")
    public List<DvdLibrary> getAllDvds() {

        return service.getAllDvds(); //we map to an object instead to html return
    }

    @DeleteMapping("/dvd/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDvd (@PathVariable int id) {
        boolean deleted = false;
        deleted = service.deleteDvd(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Dvd deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/dvd/{id}")
    public ResponseEntity<DvdLibrary> getDvdById (@PathVariable int id) {
       DvdLibrary dvd = null;
       dvd = service.getDvdById(id);
       return ResponseEntity.ok(dvd);
    }

    @PutMapping("/dvd/{id}")
    public ResponseEntity<DvdLibrary> updateDvd(@PathVariable int id, @RequestBody DvdLibrary dvd) {
        dvd = service.updateDvd(id, dvd);
        return ResponseEntity.ok(dvd);
    }











}
