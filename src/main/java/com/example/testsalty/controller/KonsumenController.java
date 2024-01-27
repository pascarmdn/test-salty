package com.example.testsalty.controller;

import com.example.testsalty.dao.KonsumenRepository;
import com.example.testsalty.entity.Konsumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KonsumenController {
    @Autowired
    KonsumenRepository konsumenRepository;

    @PostMapping("/konsumen")
    public Konsumen addKonsumen(@RequestBody Konsumen konsumen) {
        return konsumenRepository.saveKonsumen(konsumen);
    }

    @PutMapping("/konsumen")
    public Konsumen updateKonsumen(@RequestBody Konsumen konsumen) {

        return konsumenRepository.updateKonsumen(konsumen);

    }

    @GetMapping("/konsumen/{id}")
    public Konsumen getKonsumen(@PathVariable("id") int id) {
        return konsumenRepository.getById(id);
    }

    @GetMapping("/konsumen")
    public List<Konsumen> getKonsumen() {
        return konsumenRepository.allKonsumen();
    }

    @DeleteMapping("/konsumen/{id}")
    public String deleteKonsumen(@PathVariable("id") int id){
        return konsumenRepository.deleteById(id);
    }
}
