package com.api.desafio_injecao_dependencia.services;

import com.api.desafio_injecao_dependencia.entities.Order;

public interface ShippingService {

    double shipment(Order order);

}
