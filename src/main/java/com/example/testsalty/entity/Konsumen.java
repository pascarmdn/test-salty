package com.example.testsalty.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Konsumen {
    private int id;
    private String nama;
    private String alamat;
    private String kota;
    private String provinsi;
    private Date tgl_registrasi;
    private String status;
}
