package com.unla.aulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderService {

    /*@Autowired
    OrderRepository orderRepository;

    public ArrayList<OrderEntity> getOrders(){
        return (ArrayList<OrderEntity>) orderRepository.findAll();
    }

    public OrderEntity saveOrder(OrderEntity orderEntity){
        return orderRepository.save(orderEntity);
    }

    public Optional<OrderEntity> getOrder(int id){
        return orderRepository.findById(id);
    }

    public boolean deleteOrder(int id){
        try {
            orderRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }*/


}
