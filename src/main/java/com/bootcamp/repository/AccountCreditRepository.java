package com.bootcamp.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.entity.AccountCredit;
import reactor.core.publisher.Flux;

@Repository
public interface AccountCreditRepository extends ReactiveMongoRepository<AccountCredit, Integer> {
	
	@Query("{dniCustomer:?0}")
	Flux<AccountCredit> findDNI(String dniCustomer);


}
