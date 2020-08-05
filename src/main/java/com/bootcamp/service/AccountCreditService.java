package com.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.entity.AccountCredit;
import com.bootcamp.repository.AccountCreditRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountCreditService {
	
	@Autowired
	private AccountCreditRepository repository;
	 
	public Mono<AccountCredit> save (AccountCredit accountCredit){
		return repository.save(accountCredit);
	}
	
	public Mono<Void> update   (AccountCredit accountCredit)	{
		return findById(accountCredit.getId())
				.flatMap(repository::save)
				.thenEmpty(Mono.empty());
	}
	
	public Mono<Void> delete	(int id){
		return findById(id)
				.flatMap(repository::delete);
	}
	
	public Flux<AccountCredit> findAll () 	{
		return repository.findAll();
	}
	
	public Mono<AccountCredit> findById (int id) 	{
		return repository.findById(id);
	}
	
	
	
	
	public Flux<AccountCredit> findDNI(String dniCustomer){
		return repository.findDNI(dniCustomer);
	}
	
	
	

}
