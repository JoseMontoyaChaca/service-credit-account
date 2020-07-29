package com.bootcamp.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor 
@Data
@Document
public class AccountCredit implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;	
	private String nameAccount;
	private Long  cardNumber;
	private String dniCustomer;
	private double balance;
	private String idBank;

}
