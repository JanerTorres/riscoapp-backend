package com.riscoapp.riscoappbackend.controllers;

import com.riscoapp.riscoappbackend.datamodel.Element;
import com.riscoapp.riscoappbackend.service.IElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/element")
public class ElementController {

    @Autowired
    IElementService elementService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(value = "/find")
    public ResponseEntity<List<Element>> getBestElements(@RequestParam("weight") float weight,
                                         @RequestParam("calories") float calories){
        List<Element> selectedElements = elementService.selectItems(weight,calories);
        if (selectedElements == null) return ResponseEntity.badRequest().build();
        return new ResponseEntity(selectedElements, HttpStatus.OK);
    }
}
