package mx.com.matus.vo.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendingResponse extends GenericResponse{

	private static final long serialVersionUID = 7165573688852194910L;
	private String txId;
	private BigDecimal sended;
	private BigDecimal fee;

	public SendingResponse(Integer code, Object detail, String txId, BigDecimal sended, BigDecimal fee) {
		super(code, detail);
		this.txId = txId;
		this.sended = sended;
		this.fee = fee;
	}
	
	
	
}
