package mx.com.personal.btc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.personal.btc.service.TransactionInterface;
import mx.com.personal.btc.vo.response.SendingResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/send")
public class SendingController {
	
	@Autowired
	private TransactionInterface transactionService;
	
	public Mono<SendingResponse>sendToAddress(){
		
		
		return Mono.empty();
	}
}
