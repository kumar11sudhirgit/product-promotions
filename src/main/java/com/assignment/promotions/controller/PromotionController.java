package com.assignment.promotions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.promotions.model.Promotion;
import com.assignment.promotions.model.RequestDTO;
import com.assignment.promotions.service.PromotionService;

@RestController
@RequestMapping("/api")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @PostMapping("/promotions")
    public List<Promotion> getPromotions(@RequestBody RequestDTO requestDto) {
        return  promotionService.calculatePromotions(requestDto);
    }
}

