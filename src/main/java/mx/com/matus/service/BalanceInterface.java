package mx.com.matus.service;

import java.math.BigDecimal;

import reactor.core.publisher.Mono;

public interface BalanceInterface {
	
	Mono<BigDecimal> getBalance();
}
