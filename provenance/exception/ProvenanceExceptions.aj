package exception;

import java.util.Date;

import dao.ExceptionErrorDAO;
import dao.ThrowableErrorDAO;
import model.ExceptionError;
import model.ThrowableError;

public aspect ProvenanceExceptions {

	before(Throwable t): handler(Throwable+) && args(t) {
		Date now = new Date();
		ThrowableError tr = new ThrowableError();
		tr.setThrowable(t.toString());
		tr.setInstant(now);
		new ThrowableErrorDAO().save(tr);
	}

	before(Exception e): handler(Exception+) && args(e) {
		Date now = new Date();
		ExceptionError er = new ExceptionError();
		er.setException(e.toString());
		er.setInstant(now);
		new ExceptionErrorDAO().save(er);
	}

}
