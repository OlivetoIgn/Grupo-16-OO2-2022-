package com.unla.aulas.controller;

import com.unla.aulas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    /*@Autowired
    OrderService orderService;

    @PostMapping("/save")
    public OrderEntity saveOrder(@RequestBody OrderEntity orderEntity){
        return this.orderService.saveOrder(orderEntity);
    }

    @GetMapping("/query")
    public ArrayList<OrderEntity> getOrders(){
        return this.orderService.getOrders();
    }

    @GetMapping(path = "/{id}")
    public Optional<OrderEntity> getOrder(@PathVariable("id") int id){
        return this.orderService.getOrder(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        boolean ok = this.orderService.deleteOrder(id);
        if(ok){
            return "Se ha borrado con exito";
        }else {
            return "No existe el id " + id;
        }
    }*/

}
