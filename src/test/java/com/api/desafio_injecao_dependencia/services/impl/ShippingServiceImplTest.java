package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ShippingServiceImplTest {

    public static final double FAIXA_1 = 20.0;
    public static final double FAIXA_2 = 12.0;
    public static final double FAIXA_3 = 0.0;

    @InjectMocks
    private ShippingServiceImpl shippingServiceImpl;

    @Test
    void testShipmentFaixa1() {
        Order order = new Order();
        order.setCode(1009);
        order.setBasic(95.90);
        order.setDiscount(0.0);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_1, result);
    }

    @Test
    void testShipmentFaixa2() {
        Order order = new Order();
        order.setCode(1034);
        order.setBasic(150.00);
        order.setDiscount(0.20);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_2, result);
    }

    @Test
    void testShipmentFaixa3() {
        Order order = new Order();
        order.setCode(2282);
        order.setBasic(800.00);
        order.setDiscount(0.10);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_3, result);
    }

}