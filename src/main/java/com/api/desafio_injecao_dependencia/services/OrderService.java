package com.api.desafio_injecao_dependencia.services;

import com.api.desafio_injecao_dependencia.entities.Order;

public interface OrderService {

    double total(Order order);

}
