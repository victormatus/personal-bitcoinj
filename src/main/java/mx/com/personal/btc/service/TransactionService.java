package mx.com.personal.btc.service;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.AddressFormatException;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.InsufficientMoneyException;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.wallet.SendRequest;
import org.bitcoinj.wallet.Wallet;
import org.bitcoinj.wallet.Wallet.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.com.personal.btc.exception.SendingException;
import mx.com.personal.btc.model.AppKitContainer;
import mx.com.personal.btc.util.Preconditions;
import mx.com.personal.btc.vo.request.SendingRequest;
import mx.com.personal.btc.vo.response.SendingResponse;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class TransactionService implements TransactionInterface {
	
	
	@Autowired
	private AppKitContainer kitContainer;

	@Override
	public Mono<SendingResponse> sendToAddress(SendingRequest request) throws SendingException {
		Preconditions.validateStatus(kitContainer);
		Wallet wallet = kitContainer.getWalletAppKit().wallet();
		try {
			
			Address to = Address.fromString(kitContainer.getWalletAppKit().params(), request.getAddress());
			Coin value = Coin.parseCoin(String.valueOf(request.getAmount()));
			SendRequest sendRequest = SendRequest.to(to, value);
			sendRequest.recipientsPayFees = request.getIncludeFee();
			
			SendResult result = wallet.sendCoins(sendRequest);
			Transaction tx = result.tx;
			
			SendingResponse response = new SendingResponse(0, 
					"Successfully operation", 
					result.tx.getTxId().toString(), 
					tx.getValue(wallet).toString(), 
					tx.getFee().toString());
			
			return Mono.just(response);
		} catch( AddressFormatException e) {
			log.error("Invalid address: " + e.getMessage(), e);
			throw new SendingException("The address is invalid");
		} catch (InsufficientMoneyException e) {
			log.error("Insufficients funds: " +  e.getMessage(), e);
			throw new SendingException("Insufficients funds in your wallet");
		}
	}

}
