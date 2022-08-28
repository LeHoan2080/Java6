package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailDTO {
	private Long id;
    private Long product_id;
    private Long cart_id;
	private Long quantity;
}
