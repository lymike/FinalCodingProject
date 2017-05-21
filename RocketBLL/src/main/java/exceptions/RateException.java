package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel rdm;
	
	public void RateException (RateDomainModel rdm){
		rdm = this.rdm;
	}
	
	public RateDomainModel getrdm() {
		return rdm;
	}
}
