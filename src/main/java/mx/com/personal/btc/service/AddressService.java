package mx.com.personal.btc.service;

import java.util.List;

import org.bitcoinj.core.Address;
import org.bitcoinj.kits.WalletAppKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.personal.btc.exception.SyncException;
import mx.com.personal.btc.model.AppKitContainer;
import mx.com.personal.btc.util.Preconditions;
import reactor.core.publisher.Flux;
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
		
		
		WalletAppKit kit = getKit();
		Address newAddress = kit.wallet().freshReceiveAddress();
		log.info("the new address generated is: " +  newAddress.toString());
		
		kit.wallet().addWatchedAddress(newAddress);
		return Mono.just(newAddress.toString());
	}

	@Override
	public Flux<Address> listAddresses() {
		WalletAppKit kit = getKit();
		List<Address>addresses = kit.wallet().getWatchedAddresses();
		
		return Flux.fromIterable(addresses);
		
	}
	
	private WalletAppKit getKit() throws SyncException{
		Preconditions.validateStatus(kitContainer);
		
		return kitContainer.getWalletAppKit();
	}

}
