package mx.com.matus.model;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.bitcoinj.kits.WalletAppKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Component("kitContainer")
@Getter
@Setter
@Slf4j
public class AppKitContainer {
	
	@Value("${bitcoin.wallet.name}")
	private String walletName; 
	
	@Autowired
	private NetworkProfile networkProfile;
	
	private WalletAppKit walletAppKit;
	private Boolean completedSync;
	
	
	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	private final LocalDateTime now = LocalDateTime.now();  

	/**
	 * Initialize and sync wallet before to start the application
	 * */
	@PostConstruct
	public void initAndSync() {
		log.info("Init and sync at  " + dtf.format(now));
		completedSync = false;
		try {
			walletAppKit = new WalletAppKit(networkProfile.getNetworkParams(), 
					new File(networkProfile.getWalletPath()), 
					walletName);
			walletAppKit.setAutoSave(true);
			walletAppKit.setBlockingStartup(true);
			walletAppKit.startAsync();
			walletAppKit.awaitRunning();
			completedSync = true;
		}catch(Exception e) {
			log.error(e.getMessage(), e);
			completedSync = false;
		}

	}
	
	@PreDestroy
	public void destroy() {
		walletAppKit.stopAsync();
		walletAppKit.awaitTerminated();
	}

}
