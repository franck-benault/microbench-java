package net.franckbenault.microbench.mapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Address;
import net.franckbenault.microbench.source.Customer;
import net.franckbenault.microbench.source.Name;
import net.franckbenault.microbench.source.Order;

public class MapperWithHand {

    public OrderDTO asOrderDTO(Order order) {
		if (order == null) {
			return null;
		} else {

			OrderDTO orderDTO = new OrderDTO();
			if(order.getBillingAddress()!=null) {
				orderDTO.setBillingCity(order.getBillingAddress().getCity());
				orderDTO.setBillingStreet(order.getBillingAddress().getStreet());
			}
			if(order.getCustomer()!=null && order.getCustomer().getName()!=null) {
				orderDTO.setCustomerFirstName(order.getCustomer().getName().getFirstName());
				orderDTO.setCustomerLastName(order.getCustomer().getName().getLastName());
			}
			return orderDTO;
		}
    }
    
    public Order asOrder(OrderDTO orderDto) {
    	if (orderDto == null) {
			return null;
		} else {

			Order order = new Order();
			order.setBillingAddress(new Address());
			order.setCustomer(new Customer());
			order.getCustomer().setName(new Name());
			
			order.getBillingAddress().setCity(orderDto.getBillingCity());
			order.getBillingAddress().setStreet(orderDto.getBillingStreet());
			order.getCustomer().getName().setFirstName(orderDto.getCustomerFirstName());
			order.getCustomer().getName().setLastName(orderDto.getCustomerLastName());
			
			
			return order;
		}
    }
}
