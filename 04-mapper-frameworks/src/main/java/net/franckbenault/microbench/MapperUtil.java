package net.franckbenault.microbench;

import org.modelmapper.ModelMapper;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperUtil {

	public static OrderDTO mapWithModelMapper(Order order) {

		ModelMapper modelMapper = new ModelMapper();
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}

	public static OrderDTO mapManual(Order order) {

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
}
