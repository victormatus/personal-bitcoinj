package mx.com.matus.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.matus.vo.response.GenericResponse;
import mx.com.matus.vo.response.SendingResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/send")
public class SendingController {
	
	public Mono<SendingResponse>sendToAddress(){
		
		
		return Mono.empty();
	}
}
