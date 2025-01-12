package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import com.api.desafio_injecao_dependencia.services.OrderService;
import com.api.desafio_injecao_dependencia.services.ShippingService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {

    private final ShippingService shippingService;

    public OrderServiceImpl(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public double total(Order order) {
        if (Objects.isNull(order) || order.getBasic() <= 0.0) {
            return 0.0;
        }

        return order.getBasic() - (order.getBasic() * order.getDiscount()) + shippingService.shipment(order);
    }
}
