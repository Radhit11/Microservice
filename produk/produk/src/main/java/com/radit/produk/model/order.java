package com.radit.produk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders") 
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produk_id", nullable = false)
    private produk produk;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = false)
    private pelanggan pelanggan;

    private Double harga;
    private Integer jumlah;
    private Double total;
}
