package com.techelevator;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.io.File;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Log {
	
	private String timeNow;
	private String currentStep;
	private double theBalanceBefore;
	private double theBalanceAfter;
	
	public Log(String currentTime, String step, double balanceBefore, double balanceAfter) {
		timeNow = currentTime;
		currentStep = step;
		theBalanceBefore = balanceBefore;
		theBalanceAfter = balanceAfter;
	}
	/**
	 * @return the timeNow
	 */
	public String getTimeNow() {
		return timeNow;
	}
	/**
	 * @return the currentStep
	 */
	public String getCurrentStep() {
		return currentStep;
	}
	/**
	 * @return the theBalanceBefore
	 */
	public double getTheBalanceBefore() {
		return theBalanceBefore;
	}
	/**
	 * @return the theBalanceAfter
	 */
	public double getTheBalanceAfter() {
		return theBalanceAfter;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		DecimalFormat format = new DecimalFormat("#.00");
		
		return timeNow + " " + currentStep + " $" + format.format(theBalanceBefore)
				+ " $" + format.format(theBalanceAfter);
	}
}
