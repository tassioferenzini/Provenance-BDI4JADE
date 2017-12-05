package model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ThrowableError implements Serializable {
	
	private String Id;
	private String throwable;
	private Date instant;

	public ThrowableError() {
		super();
	}

	public ThrowableError(String id, String throwable, Date instant) {
		Id = id;
		this.throwable = throwable;
		this.instant = instant;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getThrowable() {
		return throwable;
	}

	public void setThrowable(String throwable) {
		this.throwable = throwable;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	@Override
	public String toString() {
		return "ThrowableError [Id=" + Id + ", throwable=" + throwable + ", instant=" + instant + "]";
	}

}
