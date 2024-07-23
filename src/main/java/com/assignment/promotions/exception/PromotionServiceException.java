package com.assignment.promotions.exception;

public class PromotionServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public PromotionServiceException(String message) {
        super(message);
    }
}
