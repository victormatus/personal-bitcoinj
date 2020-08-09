package mx.com.personal.btc.util;

import mx.com.personal.btc.exception.SyncException;
import mx.com.personal.btc.model.AppKitContainer;

public class Preconditions {
	
	public static void validateStatus(AppKitContainer kitContainer) throws SyncException {
		
		if ( kitContainer == null || !kitContainer.getCompletedSync()) {
			throw new SyncException("the node is not yet synchronized");
		}
	}

}
