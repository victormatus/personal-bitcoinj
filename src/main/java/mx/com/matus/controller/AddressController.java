package mx.com.matus.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.matus.service.AddressInterface;
import mx.com.matus.util.Constants;
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
			response.put("address", address);
			return Mono.just(response);
		});
		
		
		
	}

}
