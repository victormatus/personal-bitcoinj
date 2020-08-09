package mx.com.personal.btc.model;

import org.bitcoinj.params.AbstractBitcoinNetParams;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NetworkProfile {
	
	private AbstractBitcoinNetParams networkParams;
	private String walletPath;

}
