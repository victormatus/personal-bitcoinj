package mx.com.personal.btc.vo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendingResponse extends GenericResponse{

	private static final long serialVersionUID = 7165573688852194910L;
	private String txId;
	private String sended;
	private String fee;

	public SendingResponse(Integer code, Object detail, String txId, String sended, String fee) {
		super(code, detail);
		this.txId = txId;
		this.sended = sended;
		this.fee = fee;
	}
	
	
	
}
