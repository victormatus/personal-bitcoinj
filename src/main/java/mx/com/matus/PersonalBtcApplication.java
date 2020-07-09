package mx.com.matus;

import java.io.File;

import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.TestNet3Params;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.log4j.Log4j2;
import mx.com.matus.model.NetworkProfile;
import mx.com.matus.util.Constants;

@SpringBootApplication
@Log4j2
public class PersonalBtcApplication {
	
	@Value("${bitcoin.network.profile}")
	private String profile;
	
	@Value("${bitcoin.wallet.path}")
	private String walletPath;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalBtcApplication.class, args);
	}
	
	@Bean
	public NetworkProfile networkProfile() {
		log.info("Initializing network profile: " + profile);
		NetworkProfile networkProfile = new NetworkProfile();
		
		if(Constants.TEST_NETWORK.equals(profile)) {
			networkProfile.setNetworkParams(TestNet3Params.get());
			networkProfile.setWalletPath(walletPath + File.separator + Constants.TEST_NETWORK);
		}else if(Constants.MAIN_NETWORK.equals(profile)){
			networkProfile.setNetworkParams(MainNetParams.get());
			networkProfile.setWalletPath(walletPath + File.separator + Constants.MAIN_NETWORK);
		}else {
			log.error("could'nt be recognized the network profile");
			
		}
		
		return networkProfile;
	}
	
	

}
