package com.example.testsalty.dao;

import com.example.testsalty.entity.Konsumen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KonsumenRepositoryImpl implements KonsumenRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Konsumen saveKonsumen(Konsumen konsumen) {
        String query = "INSERT INTO KONSUMEN(id,nama,alamat,kota,provinsi,tgl_registrasi,status) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(query, konsumen.getId(), konsumen.getNama(), konsumen.getAlamat(),
                konsumen.getKota(), konsumen.getProvinsi(), konsumen.getTgl_registrasi(), konsumen.getStatus());
        return konsumen;
    }

    @Override
    public Konsumen updateKonsumen(Konsumen konsumen) {
        String query = "UPDATE KONSUMEN SET nama=?,alamat=?,kota=?,provinsi=?,tgl_registrasi=?,status=? WHERE ID=?";
        jdbcTemplate.update(query, konsumen.getNama(), konsumen.getAlamat(), konsumen.getKota(),
                konsumen.getProvinsi(), konsumen.getTgl_registrasi(), konsumen.getId());
        return konsumen;
    }

    @Override
    public Konsumen getById(int id) {
        String query = "SELECT * FROM KONSUMEN WHERE ID=?";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) ->{
            return new Konsumen(rs.getInt("id"),rs.getString("nama"),
                    rs.getString("alamat"), rs.getString("kota"),
                    rs.getString("provinsi"), rs.getDate("tgl_registrasi"),
                    rs.getString("status"));
        });
    }

    @Override
    public String deleteById(int id) {
        String query = "DELETE FROM KONSUMEN WHERE ID=?";
        jdbcTemplate.update(query, id);
        return "User got deleted with id " + id;
    }

    @Override
    public List<Konsumen> allKonsumen() {
        String query = "SELECT * FROM KONSUMEN";
        return jdbcTemplate.query(query, (rs, rowNum) ->{
            return new Konsumen(rs.getInt("id"),rs.getString("nama"),
                    rs.getString("alamat"), rs.getString("kota"),
                    rs.getString("provinsi"), rs.getDate("tgl_registrasi"),
                    rs.getString("status"));
        });
    }
}
