package mx.com.personal.btc.service;

import org.bitcoinj.core.Address;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressInterface {
	
	Mono<String> createAddress();
	Flux<Address> listAddresses();

}
