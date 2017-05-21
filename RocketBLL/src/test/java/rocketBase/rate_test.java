package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	
	@Test
	public void Interest_rate_test() throws RateException {
		assertEquals(RateBLL.getRate(605), 7, 0.01);
		assertEquals(RateBLL.getRate(655), 6.5, 0.01);
		assertEquals(RateBLL.getRate(730), 6, 0.01);
		assertEquals(RateBLL.getRate(775), 5.75, 0.01);
		assertEquals(RateBLL.getRate(805), 5.5, 0.01);
	}
	
	
	@Test (expected = RateException.class)
	public void Interest_rate_test2() throws RateException {
		RateBLL.getRate(500);
	}

}
