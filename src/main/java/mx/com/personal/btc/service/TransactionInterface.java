package mx.com.personal.btc.service;

import mx.com.personal.btc.exception.SendingException;
import mx.com.personal.btc.vo.request.SendingRequest;
import mx.com.personal.btc.vo.response.SendingResponse;
import reactor.core.publisher.Mono;

public interface TransactionInterface {
	
	Mono<SendingResponse> sendToAddress(SendingRequest request) throws SendingException;

}
