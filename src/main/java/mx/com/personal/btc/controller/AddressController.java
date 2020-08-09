package mx.com.personal.btc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.personal.btc.service.AddressInterface;
import mx.com.personal.btc.util.Constants;
import mx.com.personal.btc.vo.response.Address;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	private AddressInterface addressService;
	
	@Autowired
	public AddressController(AddressInterface addressService) {
		this.addressService = addressService;
	}
	
	@PostMapping
	public Mono<Map<String, Object>>createAddress(){
		Map<String, Object> response = new HashMap<>();
		return addressService.createAddress()
		.flatMap(address->{
			response.put(Constants.CODE_RESPONSE, 0);
			response.put(Constants.ADDRESS_FIELD_RESPONSE, address);
			return Mono.just(response);
		});
	}
	
	@GetMapping
	public Flux<Address>listAddresses(){
		return addressService.listAddresses()
				.map(address->(new Address(address.toString())));

	}

}
