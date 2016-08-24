package net.franckbenault.microbench.mapper.impl;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import static com.googlecode.jmapper.api.JMapperAPI.*;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.mapper.AbstractMapper;
import net.franckbenault.microbench.source.Order;


public class MapperWithJMapper implements AbstractMapper {
	
	private static JMapper<OrderDTO, Order> mapper;
	private static JMapperAPI jmapperAPI;
	private static JMapper<Order, OrderDTO> inverseMapper;
	
	static {
		
		 jmapperAPI = new JMapperAPI()
			    .add(mappedClass(OrderDTO.class)
			             .add(attribute("customerFirstName")
			                     .value("${customer.name.firstName}"))
			             .add(attribute("customerLastName")
			                     .value("${customer.name.lastName}"))
			             .add(attribute("billingCity")
			                     .value("${billingAddress.city}"))
			             .add(attribute("billingStreet")
			                     .value("${billingAddress.street}"))
			             );

		mapper = new JMapper<>(OrderDTO.class, Order.class, jmapperAPI);
		
		inverseMapper = new JMapper<>(Order.class, OrderDTO.class, jmapperAPI);

	}
	
	public OrderDTO asOrderDTO(Order order) {
		
		
		return mapper.getDestination(order);
		}

	public Order asOrder(OrderDTO orderDto) {

		return inverseMapper.getDestination(orderDto);
	
	}
}
