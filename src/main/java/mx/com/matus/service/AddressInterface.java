package mx.com.matus.service;

import reactor.core.publisher.Mono;

public interface AddressInterface {
	
	Mono<String> createAddress();

}
