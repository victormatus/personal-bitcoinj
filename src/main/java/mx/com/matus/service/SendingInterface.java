package mx.com.matus.service;

import java.math.BigDecimal;

import mx.com.matus.vo.response.SendingResponse;

public interface SendingInterface {
	
	SendingResponse sendToAddress(String targetAddress, BigDecimal amount, boolean includeFee);

}
