/* 
 * DISCLAIMER PLACEHOLDER 
 */
package com.ogprover.pp.tp.auxiliary;

import java.util.HashSet;

import com.ogprover.pp.tp.geoconstruction.Point;
import com.ogprover.thmprover.AreaMethodProver;

/**
 * <dl>
 * <dt><b>Class description:</b></dt>
 * <dd>Class for representing basic numbers in the area method. For the moment,
 * 		they are only integers - not floating numbers, to avoid approximation errors.</dd>
 * </dl>
 * 
 * @version 1.00
 * @author Damien Desfontaines
 */
public class AMNumber extends AMExpression {
	/*
	 * ======================================================================
	 * ========================== VARIABLES =================================
	 * ======================================================================
	 */
	/**
	 * <i><b>
	 * Version number of class in form xx.yy where
	 * xx is major version/release number and yy is minor
	 * release number.
	 * </b></i>
	 */
	public static final String VERSION_NUM = "1.00"; // this should match the version number from class comment
	
	/**
	 * Value of the number.
	 */
	protected int n;

	
	/*
	 * ======================================================================
	 * ========================== GETTERS/SETTERS ===========================
	 * ======================================================================
	 */
	public int value() {
		return n;
	}
	
	/**
	 * @see com.ogprover.pp.tp.auxiliary.AMExpression#getPoints()
	 */
	public HashSet<Point> getPoints() {
		return new HashSet<Point>();
	}
	
	
	/*
	 * ======================================================================
	 * ========================== CONSTRUCTORS ==============================
	 * ======================================================================
	 */
	/**
	 * Constructor method
	 * 
	 * @param n		Number
	 */
	public AMNumber(int n) {
		this.n = n;
	}

	
	/*
	 * ======================================================================
	 * ======================= COMMON OBJECT METHODS ========================
	 * ======================================================================
	 */
	@Override
	public String print() {
		return Integer.toString(n);
	}
	
	@Override
	public boolean equals(Object expr) {
		if (!(expr instanceof AMNumber))
			return false;
		AMNumber number = (AMNumber)expr;
		return (n == number.value());
	}

	
	/*
	 * ======================================================================
	 * ========================== SPECIFIC METHODS ==========================
	 * ======================================================================
	 */
	@Override
	public boolean containsOnlyFreePoints() {
		return true;
	}
	
	@Override
	public AMExpression uniformize() {
		return this;
	}
	
	@Override
	public AMExpression simplifyInOneStep() {
		return this;
	}
	
	@Override
	public AMExpression eliminate(Point pt, AreaMethodProver prover) {
		return this;
	}

	@Override
	public AMExpression reduceToSingleFraction() {
		return this;
	}

	@Override
	public AMExpression reductToRightAssociativeForm() {
		return this;
	}

	@Override
	public AMExpression toIndependantVariables() {
		return this;
	}

	@Override
	public int size() {
		return 1;
	}
}