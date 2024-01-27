package com.example.testsalty.dao;

import com.example.testsalty.entity.Konsumen;

import java.util.List;

public interface KonsumenRepository {
    Konsumen saveKonsumen(Konsumen konsumen);

    Konsumen updateKonsumen(Konsumen konsumen);

    Konsumen getById(int id);

    String deleteById(int id);

    List<Konsumen> allKonsumen();
}
