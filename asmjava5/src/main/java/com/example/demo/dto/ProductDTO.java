package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private String image;
	private Double price;
	private String des;
	private Long category_id;
}
