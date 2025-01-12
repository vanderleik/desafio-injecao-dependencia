package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ShippingServiceImplTest {

    @InjectMocks
    private ShippingServiceImpl shippingServiceImpl;

    @Test
    void testShipment() {
        Order order = new Order();
        order.setCode(1034);
        order.setBasic(150.00);
        order.setDiscount(0.20);

        Double result = assertDoesNotThrow(() -> shippingServiceImpl.shipment(order));
        assertNotNull(result);
        assertEquals(12.0, result);
    }

}