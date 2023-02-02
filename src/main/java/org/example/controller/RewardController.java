package org.example.controller;

import org.example.pojo.dto.RewardResponseDTO;
import org.example.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardController {

    private final RewardService service;

    @Autowired
    public RewardController(RewardService service){ this.service = service;}

    @GetMapping("/reward/{id}")
    public ResponseEntity<RewardResponseDTO.RewardDTO> getPointsByUser(@PathVariable String id){
        return new ResponseEntity<>(service.getPointsByUser(id), HttpStatus.OK);
    }

    @GetMapping("/reward/{id}/{month}")
    public ResponseEntity<RewardResponseDTO.RewardDTO> getPointsByUserAndMonth(@PathVariable String id, @PathVariable int month){
        return new ResponseEntity<>(service.getPointsByUserAndMonth(id, month), HttpStatus.OK);
    }

}
