package com.api.desafio_injecao_dependencia;

import com.api.desafio_injecao_dependencia.entities.Order;
import com.api.desafio_injecao_dependencia.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioInjecaoDependenciaApplication implements CommandLineRunner {

	private OrderService orderService;

	public DesafioInjecaoDependenciaApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioInjecaoDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order1 = new Order(1034, 150.00, 0.20);
		Order order2 = new Order(2282, 800.00, 0.10);
		Order order3 = new Order(1309, 95.90, 0.0);

		System.out.println();
		System.out.println("### Cenário 1 ###");
		System.out.println("Pedido código.: " + order1.getCode());
		System.out.println("Valor total...: " + orderService.total(order1));
		System.out.println();

		System.out.println("### Cenário 2 ###");
		System.out.println("Pedido código.: " + order2.getCode());
		System.out.println("Valor total...: " + orderService.total(order2));
		System.out.println();

		System.out.println("### Cenário 3 ###");
		System.out.println("Pedido código.: " + order3.getCode());
		System.out.println("Valor total...: " + orderService.total(order3));
		System.out.println();
	}
}
