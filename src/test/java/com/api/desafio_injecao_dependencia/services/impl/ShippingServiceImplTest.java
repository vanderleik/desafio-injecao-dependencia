package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import org.junit.jupiter.api.BeforeEach;
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

    private Order order;
    @BeforeEach
    void setUp() {
        order = new Order();
        order.setCode(1009);
        order.setBasic(95.90);
        order.setDiscount(0.0);
    }

    @Test
    void testShipmentFaixa1() {
        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_1, result);
    }

    @Test
    void testShipmentFaixa2() {
        order.setBasic(150.00);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_2, result);
    }

    @Test
    void testShipmentFaixa3() {
        order.setBasic(800.00);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_3, result);
    }

    @Test
    void testShipmentNull() {
        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(null));
        assertNotNull(result);
        assertEquals(FAIXA_3, result);
    }

    @Test
    void testShipmentBasicZero() {
        order.setBasic(0.00);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(FAIXA_3, result);
    }

}