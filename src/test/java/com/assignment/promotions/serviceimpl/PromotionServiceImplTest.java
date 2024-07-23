package com.assignment.promotions.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.promotions.exception.PromotionServiceException;
import com.assignment.promotions.model.Product;
import com.assignment.promotions.model.Promotion;
import com.assignment.promotions.model.RequestDTO;

public class PromotionServiceImplTest {

    private PromotionServiceImpl promotionService;

    @BeforeEach
    void setUp() {
        promotionService = new PromotionServiceImpl();
    }

    @Test
    void testCalculatePromotions_withValidProducts() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProducts(Arrays.asList(
                new Product("A"), new Product("B"), new Product("C"), new Product("C"), new Product("D")
        ));

        List<Promotion> promotions = promotionService.calculatePromotions(requestDTO);

        assertEquals("X", promotions.get(0).getId());
        assertEquals(3, promotions.get(0).getQuantity());
        assertEquals("Y", promotions.get(1).getId());
        assertEquals(1, promotions.get(1).getQuantity());
    }

    @Test
    void testCalculatePromotions_withOnlyB() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProducts(Collections.singletonList(new Product("B")));

        List<Promotion> promotions = promotionService.calculatePromotions(requestDTO);

        assertEquals("X", promotions.get(0).getId());
        assertEquals(0, promotions.get(0).getQuantity());
        assertEquals("Y", promotions.get(1).getId());
        assertEquals(0, promotions.get(1).getQuantity());
    }
    
    @Test
    void testCalculatePromotions_withOnlyBD() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProducts(Arrays.asList(new Product("B"), new Product("D")));

        List<Promotion> promotions = promotionService.calculatePromotions(requestDTO);

        assertEquals("X", promotions.get(0).getId());
        assertEquals(0, promotions.get(0).getQuantity());
        assertEquals("Y", promotions.get(1).getId());
        assertEquals(0, promotions.get(1).getQuantity());
    }
    
    @Test
    void testCalculatePromotions_withValidProductsACCD() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProducts(Arrays.asList(
                new Product("A"), new Product("C"), new Product("C"), new Product("D")
        ));

        List<Promotion> promotions = promotionService.calculatePromotions(requestDTO);

        assertEquals("X", promotions.get(0).getId());
        assertEquals(2, promotions.get(0).getQuantity());
        assertEquals("Y", promotions.get(1).getId());
        assertEquals(1, promotions.get(1).getQuantity());
    }

    @Test
    void testCalculatePromotions_withOnlyA() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProducts(Collections.singletonList(new Product("A")));

        List<Promotion> promotions = promotionService.calculatePromotions(requestDTO);

        assertEquals("X", promotions.get(0).getId());
        assertEquals(0, promotions.get(0).getQuantity());
        assertEquals("Y", promotions.get(1).getId());
        assertEquals(0, promotions.get(1).getQuantity());
    }

    @Test
    void testCalculatePromotions_withNullRequest() {
        assertThrows(Exception.class, () -> {
            promotionService.calculatePromotions(null);
        });
    }

    @Test
    void testCalculatePromotions_withEmptyProductList() {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setProducts(Collections.emptyList());

        assertThrows(PromotionServiceException.class, () -> {
            promotionService.calculatePromotions(requestDTO);
        });
    }
}