package net.franckbenault.microbench;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Stopwatch;

import net.franckbenault.microbench.destination.OrderDTO;
import net.franckbenault.microbench.source.Order;

public class MapperUtil {
	
	private static ModelMapper modelMapper = new ModelMapper();
	private static final Logger logger = LoggerFactory.getLogger(MapperUtil.class);


	public static  OrderDTO mapWithModelMapper(Order order) {

		ModelMapper modelMapper = new ModelMapper();
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}
	
	public static  OrderDTO mapWithModelMapperWithStopWatch(Order order) {

		Stopwatch stopwatch = Stopwatch.createStarted(); // Guava 
		ModelMapper modelMapper = new ModelMapper();
		stopwatch.stop();
		logger.info("Model mapper creation took " + stopwatch); 
		
		stopwatch = Stopwatch.createStarted(); // Guava 
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		stopwatch.stop();
		logger.info("mapping took " + stopwatch);
		return orderDTO;
	}
	
	public static  OrderDTO mapWithModelMapperOptimized(Order order) {
		
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		return orderDTO;
	}
	
	public static OrderDTO mapWithDozer(Order order) {
		
		List<String> myMappingFiles = new ArrayList<>();
		myMappingFiles.add("dozerMapping.xml");
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		OrderDTO orderDTO =   
		    mapper.map(order, OrderDTO.class,"order");
		
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
