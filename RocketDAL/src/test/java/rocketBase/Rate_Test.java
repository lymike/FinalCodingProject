package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

		
	@Test 
	public void Rate_order_test() {
		
		ArrayList <RateDomainModel> rates = RateDAL.getAllRates();
		
		assertTrue(rates.get(0).getiMinCreditScore() > rates.get(1).getiMinCreditScore());
		assertTrue(rates.get(1).getiMinCreditScore() > rates.get(2).getiMinCreditScore());
		assertTrue(rates.get(2).getiMinCreditScore() > rates.get(3).getiMinCreditScore());
		assertTrue(rates.get(3).getiMinCreditScore() > rates.get(4).getiMinCreditScore());
		
	}
	


}
