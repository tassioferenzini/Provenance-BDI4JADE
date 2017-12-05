package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ExceptionError implements Serializable {

	private String id;
	private String exception;
	private Date instant;

	public ExceptionError() {
		super();
	}

	public ExceptionError(String id, String exception, Date instant) {
		this.id = id;
		this.exception = exception;
		this.instant = instant;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	@Override
	public String toString() {
		return "ExceptionError [id=" + id + ", exception=" + exception + ", instant=" + instant + "]";
	}

}
