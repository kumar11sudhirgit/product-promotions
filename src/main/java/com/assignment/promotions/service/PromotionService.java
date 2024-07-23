package com.assignment.promotions.service;

import java.util.List;

import com.assignment.promotions.model.Promotion;
import com.assignment.promotions.model.RequestDTO;

public interface PromotionService {

	public List<Promotion> calculatePromotions(RequestDTO requestDto);
}
