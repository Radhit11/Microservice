package com.radit.produk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.radit.produk.model.order;

@Repository
public interface OrderRepository extends JpaRepository<order, Long> {

	@Query("SELECT o FROM order o WHERE o.id_pelanggan = :idPelanggan")
	List<order> findByPelangganId(@Param("idPelanggan") Long idPelanggan);
}