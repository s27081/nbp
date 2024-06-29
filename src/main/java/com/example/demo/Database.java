package com.example.demo;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
 @Entity
 @Table(name = "`database`")
public class Database {
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     private Integer id;
    private String waluta;
    private Long dnie;
    private Double kurs;
    private LocalDate dataZapytania;


     public Database(String waluta, Long dnie, Double kurs, LocalDate dataZapytania) {
         this.waluta = waluta;
         this.dnie = dnie;
         this.kurs = kurs;
         this.dataZapytania = dataZapytania;
     }

     public Database() {

     }

     public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public Long getDnie() {
        return dnie;
    }

    public void setDnie(Long dnie) {
        this.dnie = dnie;
    }

    public Double getKurs() {
        return kurs;
    }

    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    public LocalDate getDataZapytania() {
        return dataZapytania;
    }

    public void setDataZapytania(LocalDate dataZapytania) {
        this.dataZapytania = dataZapytania;
    }
}
