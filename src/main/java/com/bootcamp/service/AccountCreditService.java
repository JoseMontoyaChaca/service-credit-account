package com.bootcamp.service;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.entity.CreditCard;
import com.bootcamp.repository.AccountCreditRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountCreditService {
	
	@Autowired
	private AccountCreditRepository repository;
	 	
	public Mono<Void> updateFirstCard (String dniCustomer, String shippingAccountNumber, String destinationAccountNumber,double amountDeposit){
		Mono<CreditCard> mono = repository.findByDNIAndAccountNumberCustomer(dniCustomer,shippingAccountNumber)
				.switchIfEmpty(Mono.error(new NotFound()))
				.map(p -> {
					p.setBalance(p.getBalance() - amountDeposit);
					return p;
				});
		
			
		
		Mono<CreditCard> mono2 = repository.findByDNIAndAccountNumberCustomer(dniCustomer, destinationAccountNumber)
				.switchIfEmpty(Mono.error(new NotFound()))
				.map(d -> {
					d.setBalance(d.getBalance() + amountDeposit);
					return d;
				});
		
			return Mono.when(repository.saveAll(mono),
					repository.saveAll(mono2));
	}
	
	
	public Mono<CreditCard> save (CreditCard accountCredit){
		return repository.save(accountCredit);
	}
	
	public Mono<Void> update   (CreditCard accountCredit)	{
		return findById(accountCredit.getId())
				.flatMap(repository::save)
				.thenEmpty(Mono.empty());
	}
	
	public Mono<Void> delete	(int id){
		return findById(id)
				.flatMap(repository::delete);
	}
	
	public Flux<CreditCard> findAll () 	{
		return repository.findAll();
	}
	
	public Mono<CreditCard> findById (int id) 	{
		return repository.findById(id);
	}
		
	public Flux<CreditCard> findDNI(String dniCustomer){
		return repository.findDNI(dniCustomer);
	}
	
	
	

}
