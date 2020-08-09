package mx.com.personal.btc.vo.request;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendingRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303000372482652190L;
	
	private String address;
	private BigDecimal amount;
	private Boolean includeFee;

}
