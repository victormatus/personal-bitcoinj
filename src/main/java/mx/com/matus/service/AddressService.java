package mx.com.matus.service;

import org.bitcoinj.core.Address;
import org.bitcoinj.kits.WalletAppKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.matus.model.AppKitContainer;
import mx.com.matus.util.Preconditions;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AddressService implements AddressInterface {

	private AppKitContainer kitContainer;
	
	@Autowired
	public AddressService(AppKitContainer kitContainer) {
		this.kitContainer = kitContainer;
	}
	
	@Override
	public Mono<String> createAddress() {
		
		Preconditions.validateStatus(kitContainer);
		WalletAppKit kit = kitContainer.getWalletAppKit();
		Address newAddress = kit.wallet().freshReceiveAddress();
		log.info("the new address generated is: " +  newAddress.toString());
		
		kit.wallet().addWatchedAddress(newAddress);
		return Mono.just(newAddress.toString());
	}

}
