package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import com.api.desafio_injecao_dependencia.services.ShippingService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ShippingServiceImpl implements ShippingService {

    public static final double FAIXA_1 = 20.0;
    public static final double FAIXA_2 = 12.0;
    public static final double FAIXA_3 = 0.0;

    @Override
    public double shipment(Order order) {
        if (Objects.isNull(order)) {
            return 0;
        }

        return getShipping(order.getBasic());
    }

    private double getShipping(Double basic) {
        if (basic < 100.00) {
            return FAIXA_1;
        } else if (basic < 200.00) {
            return FAIXA_2;
        } else {
            return FAIXA_3;
        }
    }
}
