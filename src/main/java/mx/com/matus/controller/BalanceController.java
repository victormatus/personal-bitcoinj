package mx.com.matus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.matus.service.BalanceInterface;
import mx.com.matus.vo.response.GenericResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bitcoin-spv")
public class BalanceController {
	
	@Autowired
	private BalanceInterface balanceService;
	
	@GetMapping("/balances")
	Mono<GenericResponse> getBalance(){
		return Mono.just(new GenericResponse(0, balanceService.getBalance()));
	}
	
}
