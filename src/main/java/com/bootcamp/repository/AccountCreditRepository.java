package com.bootcamp.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.entity.CreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountCreditRepository extends ReactiveMongoRepository<CreditCard, Integer> {
	
	@Query("{dniCustomer:?0}")
	Flux<CreditCard> findDNI(String dniCustomer);
	
	@Query("{$and:[{dniCustomer:?0},{accountNumber:?1}]}")
	Mono<CreditCard> findByDNIAndAccountNumberCustomer (String dniCustomer,String accountNumber);


}
