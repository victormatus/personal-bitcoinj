package mx.com.personal.btc.service;

import java.math.BigDecimal;

import org.bitcoinj.core.Coin;
import org.bitcoinj.kits.WalletAppKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.personal.btc.model.AppKitContainer;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class BalanceService implements BalanceInterface {
	
	@Autowired
	private AppKitContainer kitContainer;

	@Override
	public Mono<BigDecimal>getBalance() {
		WalletAppKit kit = kitContainer.getWalletAppKit();
		
		Coin balance = kit.wallet().getBalance();
		log.info("the balance of my wallet is: " + balance);
		return Mono.just(BigDecimal.valueOf(balance.getValue()));
	}

}
