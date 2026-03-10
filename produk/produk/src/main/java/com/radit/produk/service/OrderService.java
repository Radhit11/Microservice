package com.radit.produk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radit.produk.model.order;
import com.radit.produk.repository.OrderRepository;
import com.radit.produk.repository.PelangganRepository;
import com.radit.produk.repository.ProdukRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProdukRepository produkRepository;

    @Autowired
    private PelangganRepository pelangganRepository;

    public List<order> getAllOrders() {
        return orderRepository.findAll();
    }

    public order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public order createOrder(order order) {
        if (order.getProduk() == null || order.getProduk().getId() == null
                || !produkRepository.existsById(order.getProduk().getId())) {
            return null;
        }
        if (order.getPelanggan() == null || order.getPelanggan().getId() == null
                || !pelangganRepository.existsById(order.getPelanggan().getId())) {
            return null;
        }
        if (order.getHarga() != null && order.getJumlah() != null) {
            order.setTotal(order.getHarga() * order.getJumlah());
        }
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}