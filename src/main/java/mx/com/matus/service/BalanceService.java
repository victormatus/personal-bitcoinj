package mx.com.matus.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.bitcoinj.core.Coin;
import org.bitcoinj.kits.WalletAppKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.com.matus.model.AppKitContainer;

@Service
@Log4j2
public class BalanceService implements BalanceInterface {
	
	@Autowired
	private AppKitContainer kitContainer;

	@Override
	public BigDecimal getBalance() {
		WalletAppKit kit = kitContainer.getWalletAppKit();
		
		Coin balance = kit.wallet().getBalance();
		log.info("the balance of my wallet is: " + balance);
		return BigDecimal.valueOf(balance.getValue());
	}

}
