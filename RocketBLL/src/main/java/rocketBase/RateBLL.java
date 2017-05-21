package rocketBase;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		
		ArrayList<RateDomainModel> rates = (ArrayList<RateDomainModel>) RateDAL.getAllRates().stream().filter(r -> r.getiMinCreditScore()<=GivenCreditScore).collect(Collectors.toList());
		
		if (rates.isEmpty()) {
			RateDomainModel rde = new RateDomainModel();
			rde.setdInterestRate(GivenCreditScore);
			throw new RateException();
		}
		else {
			dInterestRate = rates.get(0).getdInterestRate();
		}
		
		
		return dInterestRate;
		
		
	}
	

	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
