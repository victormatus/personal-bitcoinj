package mx.com.personal.btc.vo.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1842069262146680229L;
	private String address;
	public Address(String address) {
		super();
		this.address = address;
	}
	
}
