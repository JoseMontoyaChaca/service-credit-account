package com.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.entity.CreditCard;
import com.bootcamp.service.AccountCreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credit")
public class AccountCreditController {
	
	@Autowired
	AccountCreditService service;
	
	
	//PAY CREDIT CARD
	@PostMapping("/payCredit/{dniCustomer}/{shippingAccountNumber}/{destinationAccountNumber}/{amountDeposit}")
	public Mono<Void> payCreditCard (@PathVariable String dniCustomer,@PathVariable String shippingAccountNumber,@PathVariable String destinationAccountNumber,@PathVariable double amountDeposit) {
		return service.payCreditCard(dniCustomer, shippingAccountNumber, destinationAccountNumber, amountDeposit);
	}
	
	
	
	@PostMapping("/addCredit")
	public Mono<CreditCard> save (@RequestBody CreditCard c){
		return service.save(c);
	}
	
	@PutMapping("/updateCredit")
	public Mono<Void> update (@RequestBody CreditCard c){
		return service.update(c);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> delete (@PathVariable int id){
		return service.delete(id);
	}
	
	@GetMapping("/findAllCredit")
	public Flux<CreditCard> findAllCredit(){
		return service.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Mono<CreditCard> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@GetMapping("/getDNI/{dniCustomer}")
	public Flux<CreditCard> findDNI(@PathVariable String dniCustomer){
	return service.findDNI(dniCustomer);

}
	
	

}
