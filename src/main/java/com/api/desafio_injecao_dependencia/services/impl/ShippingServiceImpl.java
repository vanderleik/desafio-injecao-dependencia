package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import com.api.desafio_injecao_dependencia.services.ShippingService;
import org.springframework.stereotype.Service;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Override
    public double shipment(Order order) {
        return 0;
    }
}
