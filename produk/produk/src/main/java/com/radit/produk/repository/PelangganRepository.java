package com.radit.produk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radit.produk.model.pelanggan;

@Repository
public interface PelangganRepository extends JpaRepository<pelanggan, Long> {

}