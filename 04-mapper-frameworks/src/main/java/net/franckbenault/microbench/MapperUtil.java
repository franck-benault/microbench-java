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
	
	private static final Logger logger = LoggerFactory.getLogger(MapperUtil.class);
	private static DozerBeanMapper dozerMapper;



	
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
	

	
	public static OrderDTO mapWithDozer(Order order) {
		
		List<String> myMappingFiles = new ArrayList<>();
		myMappingFiles.add("dozerMapping.xml");
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(myMappingFiles);
		OrderDTO orderDTO =   
		    mapper.map(order, OrderDTO.class,"order");
		
		return orderDTO;
	}
	
	public static OrderDTO mapWithDozerOptimized(Order order) {
		if(dozerMapper==null) {
			List<String> myMappingFiles = new ArrayList<>();
			myMappingFiles.add("dozerMapping.xml");
		
			dozerMapper = new DozerBeanMapper();
			dozerMapper.setMappingFiles(myMappingFiles);
		}
		OrderDTO orderDTO =   
				dozerMapper.map(order, OrderDTO.class,"order");
		
		return orderDTO;
	}
}
