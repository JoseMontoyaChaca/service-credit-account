package com.bootcamp.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor 
@Data
@Document
public class CreditCard implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;	
	private String nameAccount;
	private String accountNumber;
	private String dniCustomer;
	private double balance;
	private double comsumeAmount;
	private String idBank;

}
