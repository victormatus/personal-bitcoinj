package mx.com.matus.util;

import org.bouncycastle.crypto.RuntimeCryptoException;

import mx.com.matus.model.AppKitContainer;

public class Preconditions {
	
	public static void validateStatus(AppKitContainer kitContainer) {
		
		if ( kitContainer == null || !kitContainer.getCompletedSync()) {
			throw new RuntimeCryptoException("the node is not yet synchronized");
		}
	}

}
