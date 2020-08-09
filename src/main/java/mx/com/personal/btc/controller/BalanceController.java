package mx.com.personal.btc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.personal.btc.service.BalanceInterface;
import mx.com.personal.btc.util.Constants;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/balances")
public class BalanceController {
	
	@Autowired
	private BalanceInterface balanceService;
	
	@GetMapping
	Mono<Map<String, Object>> getBalance(){
		Map<String, Object>response = new HashMap<>();
		return balanceService.getBalance()
				.flatMap(balance -> {
					response.put(Constants.CODE_RESPONSE, 0);
					response.put("balance", balance);
					return Mono.just(response);
				});
	}
	
}
