package mx.com.matus.vo.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8866720086598746851L;
	private Integer code;
	private Object detail;
	
	public GenericResponse(Integer code, Object detail) {
		super();
		this.code = code;
		this.detail = detail;
	}
	
	
}
