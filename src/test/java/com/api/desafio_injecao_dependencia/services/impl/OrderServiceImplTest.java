package com.api.desafio_injecao_dependencia.services.impl;

import com.api.desafio_injecao_dependencia.entities.Order;
import com.api.desafio_injecao_dependencia.services.ShippingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    public static final double FAIXA_1 = 20.0;
    public static final double FAIXA_2 = 12.0;
    public static final double FAIXA_3 = 0.0;

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;

    @Mock
    private ShippingService shippingService;

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.setCode(1034);
        order.setBasic(150.00);
        order.setDiscount(0.20);
    }

    @Test
    void testTotalFaixa1() {
        order.setBasic(95.90);
        order.setDiscount(0.0);

        when(shippingService.shipment(order)).thenReturn(FAIXA_1);

        Double result = assertDoesNotThrow(() -> orderServiceImpl.total(order));
        assertNotNull(result);
        assertEquals(115.90, result);
        verify(shippingService, times(1)).shipment(order);
    }

    @Test
    void testTotalFaixa2() {
        order.setBasic(150.00);
        order.setDiscount(0.20);

        when(shippingService.shipment(order)).thenReturn(FAIXA_2);

        Double result = assertDoesNotThrow(() -> orderServiceImpl.total(order));
        assertNotNull(result);
        assertEquals(132.00, result);
        verify(shippingService, times(1)).shipment(order);
    }

    @Test
    void testTotalFaixa3() {
        order.setBasic(800.00);
        order.setDiscount(0.10);

        when(shippingService.shipment(order)).thenReturn(FAIXA_3);

        Double result = assertDoesNotThrow(() -> orderServiceImpl.total(order));
        assertNotNull(result);
        assertEquals(720.0, result);
        verify(shippingService, times(1)).shipment(order);
    }

    @Test
    void testTotalBasicZero() {
        order.setBasic(0.00);

        Double result = assertDoesNotThrow(() -> orderServiceImpl.total(order));
        assertNotNull(result);
        assertEquals(0.0, result);
        verify(shippingService, times(0)).shipment(order);
    }

    @Test
    void testTotalOrderNull() {

        Double result = assertDoesNotThrow(() -> orderServiceImpl.total(null));
        assertNotNull(result);
        assertEquals(0.0, result);
        verify(shippingService, times(0)).shipment(order);
    }

}