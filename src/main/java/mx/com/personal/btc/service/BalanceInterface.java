package mx.com.personal.btc.service;

import java.math.BigDecimal;

import reactor.core.publisher.Mono;

public interface BalanceInterface {
	
	Mono<BigDecimal> getBalance();
}
