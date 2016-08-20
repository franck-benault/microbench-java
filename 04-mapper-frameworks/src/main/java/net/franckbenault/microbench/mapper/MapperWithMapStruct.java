package net.franckbenault.microbench.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

@Mapper
public interface MapperWithMapStruct {
	
	MapperWithMapStruct INSTANCE = Mappers.getMapper( MapperWithMapStruct.class );

	 @Mappings({
	        @Mapping(source = "billingAddress.street", target = "billingStreet"),
	        @Mapping(source = "billingAddress.city", target = "billingCity"),
	        @Mapping(source = "customer.name.firstName", target="customerFirstName"),
	        @Mapping(source = "customer.name.lastName", target="customerLastName")
	    })
	    OrderDTO asOrderDTO(Order order);
	 
	 
	 @InheritInverseConfiguration
	    Order asOrder(OrderDTO orderDto);


}
