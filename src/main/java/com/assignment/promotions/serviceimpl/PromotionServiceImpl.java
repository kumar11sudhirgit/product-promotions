package com.assignment.promotions.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.assignment.promotions.exception.PromotionServiceException;
import com.assignment.promotions.model.Product;
import com.assignment.promotions.model.Promotion;
import com.assignment.promotions.model.RequestDTO;
import com.assignment.promotions.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Override
	public List<Promotion> calculatePromotions(RequestDTO requestDto) {
		if(requestDto == null || requestDto.getProducts().isEmpty()) {
			throw new PromotionServiceException("Request body can not be empty or null");
		}
		List<Product> products = requestDto.getProducts();
		Map<String, Integer> productCount = new HashMap<>();
        for (Product product : products) {
            productCount.put(product.getId(), productCount.getOrDefault(product.getId(), 0) + 1);
        }

        List<Promotion> promotions = new ArrayList<>();
        boolean hasProductA = productCount.getOrDefault("A", 0) > 0;
        long countB = productCount.getOrDefault("B", 0);
        long countC = productCount.getOrDefault("C", 0);
        long countD = productCount.getOrDefault("D", 0);
        long countBC = Stream.of(countB, countC).mapToLong(Long::longValue).sum();

        if (hasProductA) {
        	
        	promotions.add(new Promotion("X", countB + countC ));
        	promotions.add(new Promotion("Y", (countD >= 1 ? countD : 0)));
			
        } else {
        	
            promotions.add(new Promotion("X", (countB + countC)>1 ? countBC :0));
            promotions.add(new Promotion("Y", 0));
        }

        return promotions;
	}
	
}
