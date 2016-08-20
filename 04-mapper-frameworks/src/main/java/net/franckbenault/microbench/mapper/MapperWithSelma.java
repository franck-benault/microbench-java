package net.franckbenault.microbench.mapper;


import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

@Mapper(
	    withCustomFields = {
	        @Field({"billing.street", "billingStreet"}),
	        @Field({"billing.city", "billingCity"}),
	        @Field({"customer.name.firstName", "customerFirstName"}),
	        @Field({"customer.name.lastName", "customerLastName"})
	    }
	)
public interface MapperWithSelma {

    OrderDTO asOrderDTO(Order order);
    
    Order asOrder(OrderDTO orderDto);
}
