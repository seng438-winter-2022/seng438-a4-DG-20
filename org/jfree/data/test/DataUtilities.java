/*
 * Course: SENG 438
 * Assignment: 4
 * Team Members: Curtis Silva, Divyansh Goyal, Gurpartap Sohi, Liam Parmar
 */
package org.jfree.data.test;

// Import statements.
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Creating a class for the DataUtilitiesTest test cases
public class DataUtilitiesTest extends DataUtilities {
  // Declaring Mock objects for testing purposes
	Mockery mockCalculateColumnTotalValidDataReal;
	Mockery mockCalculateColumnTotalValidDataExtraRandomReal;
	Mockery mockCalculateColumnTotalValidDataExtraValReal;
	Mockery mockCalculateColumnTotalNULLDataReal;
	Mockery mockCalculateColumnTotalValidDataExtra;
	Mockery mockCalculateColumnTotalUnderAcceptableCol;
	Mockery mockCalculateColumnTotalOverAcceptableCol;
	Mockery mockCalculateColumnTotalBoundary;
	Mockery mockCalculateColumnTotalNULL;
	Mockery mockCalculateRowTotalValidDataReal;
	Mockery mockCalculateRowTotalValidDataNULL;
	Mockery mockCalculateRowTotalValidDataExtra;
	Mockery mockCalculateRowTotalUnderAcceptableCol;
	Mockery mockCalculateRowTotalOverAcceptableCol;
	Mockery mockCalculateRowTotalBoundary;
	Mockery mockCalculateRowTotalBoundaryNull;
	Mockery mockGetCumulativePercentagesReal;
	Mockery mockGetCumulativePercentagesNULL;
	
    Values2D nullValue;
    Values2D valuesCalculateColumnTotalValidDataReal;
    Values2D valuesCalculateColumnTotalValidDataExtraReal;
    Values2D valuesCalculateColumnTotalValidDataExtraRandomReal;
    Values2D valuesCalculateColumnTotalNULLDataReal;
    Values2D valuesCalculateColumnTotalValidDataExtra;
    Values2D valuesCalculateColumnTotalUnderAcceptableCol;
    Values2D valuesCalculateColumnTotalOverAcceptableCol;
    Values2D valuesCalculateColumnTotalBoundary;
    Values2D valuesCalculateColumnTotalNULL;
    Values2D valuesCalculaterowTotalValidDataReal;
    Values2D valuesCalculaterowTotalValidDataNULL;
    Values2D valuesCalculaterowTotalValidDataExtra;
    Values2D valuesCalculaterowTotalUnderAcceptableCol;
    Values2D valuesCalculaterowTotalOverAcceptableCol;
    Values2D valuesCalculaterowTotalBoundary;
    Values2D valuesCalculaterowTotalBoundaryNULL;
    
    KeyedValues getCumulativePercentagesReal;
    KeyedValues getCumulativePercentagesNULL;
    
    double [] nullArray;
    double [] createNumberArrayNegativeDoubles;
    double [] createNumberArrayPositiveDoubles;
    double [] createNumberArrayInts;
    double [] createNumberArrayMixed;
    
    double [][] null2DArrayA;
    double [][] null2DArrayB;
    double [][] equalNullAndValid;
    double [][] equalNumbersMatchAndMismatchA;
    double [][] equalNumbersMatchB;
    double [][] equalNumbersMismatchB;
    double [][] equalDifferentDimensionsA;
    double [][] equalDifferentDimensionsB;
    double [][] equalNaNOnlyA;
    double [][] equalNaNOnlyB;
    double [][] equalINFOnlyA;
    double [][] equalINFOnlyB;
    double [][] equalINFAndNaNMatchA;
    double [][] equalINFAndNaNMatchB;
    double [][] equalINFAndNaNMismatchA;
    double [][] equalINFAndNaNMismatchB;

    double [][] clonePositiveDoubles;
    double [][] cloneNegativeDoubles;
    double [][] cloneInts;
    double [][] cloneMixed;
    double [][] cloneWithNull;
    
    int [] validRowsAndCols;
    int [] validRowsTwoAndCols;
    int [] invalidRowsAndCols;
    int [] largerValueThanRowsAndCols;
    int [] largerValueThanRows;
    
    double [][] create2D;

  // Before the test cases below begin running, setting the Mock objects by initializing them  
	@Before
    public void setUp() throws Exception { 
		nullValue = null;
		
		// calculateColumnTotal() initializations of mock objects
		mockCalculateColumnTotalValidDataReal = new Mockery();
		valuesCalculateColumnTotalValidDataReal = mockCalculateColumnTotalValidDataReal.mock(Values2D.class);
		mockCalculateColumnTotalValidDataReal.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalValidDataReal).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalValidDataReal).getValue(0, 2);
	             will(returnValue(3.123));
	             one(valuesCalculateColumnTotalValidDataReal).getValue(1, 2);
	             will(returnValue(4));
	             one(valuesCalculateColumnTotalValidDataReal).getValue(2, 2);
	             will(returnValue(-55.009));
	         }
	     });
		
		mockCalculateColumnTotalValidDataExtraValReal = new Mockery();
		valuesCalculateColumnTotalValidDataExtraReal = mockCalculateColumnTotalValidDataExtraValReal.mock(Values2D.class);
		mockCalculateColumnTotalValidDataExtraValReal.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalValidDataExtraReal).getRowCount();
	             will(returnValue(1));
	             one(valuesCalculateColumnTotalValidDataExtraReal).getValue(0, 2);
	             will(returnValue(3.123));
	             one(valuesCalculateColumnTotalValidDataExtraReal).getValue(1, 2);
	             will(returnValue(4));
	         }
	     });
		
		mockCalculateColumnTotalValidDataExtraRandomReal = new Mockery();
		valuesCalculateColumnTotalValidDataExtraRandomReal = mockCalculateColumnTotalValidDataExtraRandomReal.mock(Values2D.class);
		mockCalculateColumnTotalValidDataExtraRandomReal.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalValidDataExtraRandomReal).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalValidDataExtraRandomReal).getValue(0, 2);
	             will(returnValue(3.123));
	             one(valuesCalculateColumnTotalValidDataExtraRandomReal).getValue(1, 2);
	             will(returnValue(4));
	             one(valuesCalculateColumnTotalValidDataExtraRandomReal).getValue(2, 2);
	             will(returnValue(-55.009));
	             one(valuesCalculateColumnTotalValidDataExtraRandomReal).getValue(3, 2);
	             will(returnValue(11));
	         }
	     });
		
		mockCalculateColumnTotalNULLDataReal = new Mockery();
		valuesCalculateColumnTotalNULLDataReal = mockCalculateColumnTotalNULLDataReal.mock(Values2D.class);
		mockCalculateColumnTotalNULLDataReal.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalNULLDataReal).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalNULLDataReal).getValue(0, 2);
	             will(returnValue(3.123));
	             one(valuesCalculateColumnTotalNULLDataReal).getValue(1, 2);
	             will(returnValue(4));
	             one(valuesCalculateColumnTotalNULLDataReal).getValue(2, 2);
	             will(returnValue(-55.009));
	         }
	     });
		
		mockCalculateColumnTotalValidDataExtra = new Mockery();
		valuesCalculateColumnTotalValidDataExtra = mockCalculateColumnTotalValidDataExtra.mock(Values2D.class);
		mockCalculateColumnTotalValidDataExtra.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalValidDataExtra).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalValidDataExtra).getValue(0, 2);
	             will(returnValue(2.873));
	             one(valuesCalculateColumnTotalValidDataExtra).getValue(1, 2);
	             will(returnValue(0));
	             one(valuesCalculateColumnTotalValidDataExtra).getValue(1, 1);
	             will(returnValue(97.622));
	             one(valuesCalculateColumnTotalValidDataExtra).getValue(0, 1);
	             will(returnValue(null));
	             one(valuesCalculateColumnTotalValidDataExtra).getValue(2, 2);
	             will(returnValue(-43.132));
	         }
	     });
		
		mockCalculateColumnTotalUnderAcceptableCol = new Mockery();
		valuesCalculateColumnTotalUnderAcceptableCol = mockCalculateColumnTotalUnderAcceptableCol.mock(Values2D.class);
		mockCalculateColumnTotalUnderAcceptableCol.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalUnderAcceptableCol).getRowCount();
	             will(returnValue(4));
	             one(valuesCalculateColumnTotalUnderAcceptableCol).getValue(0, 3);
	             will(returnValue(17.17));
	             one(valuesCalculateColumnTotalUnderAcceptableCol).getValue(1, 3);
	             will(returnValue(-2));
	             one(valuesCalculateColumnTotalUnderAcceptableCol).getValue(2, 3);
	             will(returnValue(-0.93));
	             one(valuesCalculateColumnTotalUnderAcceptableCol).getValue(3, 3);
	             will(returnValue(32.11));
	         }
	     });
		
		mockCalculateColumnTotalOverAcceptableCol = new Mockery();
		valuesCalculateColumnTotalOverAcceptableCol = mockCalculateColumnTotalOverAcceptableCol.mock(Values2D.class);
		mockCalculateColumnTotalOverAcceptableCol.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalOverAcceptableCol).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalOverAcceptableCol).getValue(0, 1);
	             will(returnValue(90.80));
	             one(valuesCalculateColumnTotalOverAcceptableCol).getValue(1, 1);
	             will(returnValue(88.320));
	             one(valuesCalculateColumnTotalOverAcceptableCol).getValue(2, 1);
	             will(returnValue(7.8123));
	             one(valuesCalculateColumnTotalOverAcceptableCol).getValue(0, 0);
	             will(returnValue(76.323));
	             one(valuesCalculateColumnTotalOverAcceptableCol).getValue(1, 0);
	             will(returnValue(59.92));
	             one(valuesCalculateColumnTotalOverAcceptableCol).getValue(2, 0);
	             will(returnValue(5.454));
	         }
	     });
		
		mockCalculateColumnTotalBoundary = new Mockery();
		valuesCalculateColumnTotalBoundary = mockCalculateColumnTotalBoundary.mock(Values2D.class);
		mockCalculateColumnTotalBoundary.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalBoundary).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalBoundary).getValue(0, 1);
	             will(returnValue(58.62));
	             one(valuesCalculateColumnTotalBoundary).getValue(1, 1);
	             will(returnValue(98.73));
	             one(valuesCalculateColumnTotalBoundary).getValue(2, 1);
	             will(returnValue(5.123));
	             one(valuesCalculateColumnTotalBoundary).getValue(0, 0);
	             will(returnValue(5.6));
	             one(valuesCalculateColumnTotalBoundary).getValue(1, 0);
	             will(returnValue(-9.3));
	             one(valuesCalculateColumnTotalBoundary).getValue(2, 0);
	             will(returnValue(501.13));
	         }
	     });
		
		mockCalculateColumnTotalNULL = new Mockery();
		valuesCalculateColumnTotalNULL = mockCalculateColumnTotalNULL.mock(Values2D.class);
		mockCalculateColumnTotalNULL.checking(new Expectations() {
	         {
	             one(valuesCalculateColumnTotalNULL).getRowCount();
	             will(returnValue(3));
	             one(valuesCalculateColumnTotalNULL).getValue(0, 1);
	             will(returnValue(58.62));
	             one(valuesCalculateColumnTotalNULL).getValue(1, 1);
	             will(returnValue(null));
	             one(valuesCalculateColumnTotalNULL).getValue(2, 1);
	             will(returnValue(5.123));
	         }
	     });
		
		// calculateRowTotal() initializations of mock objects
		mockCalculateRowTotalValidDataReal = new Mockery();
		valuesCalculaterowTotalValidDataReal = mockCalculateRowTotalValidDataReal.mock(Values2D.class);
		mockCalculateRowTotalValidDataReal.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalValidDataReal).getColumnCount();
	             will(returnValue(3));
	             one(valuesCalculaterowTotalValidDataReal).getValue(0, 0);
	             will(returnValue(8.71));
	             one(valuesCalculaterowTotalValidDataReal).getValue(0, 1);
	             will(returnValue(1));
	             one(valuesCalculaterowTotalValidDataReal).getValue(0, 2);
	             will(returnValue(-22.394));
	         }
	     });
		
		mockCalculateRowTotalValidDataNULL = new Mockery();
		valuesCalculaterowTotalValidDataNULL = mockCalculateRowTotalValidDataNULL.mock(Values2D.class);
		mockCalculateRowTotalValidDataNULL.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalValidDataNULL).getColumnCount();
	             will(returnValue(3));
	             one(valuesCalculaterowTotalValidDataNULL).getValue(0, 0);
	             will(returnValue(8.71));
	             one(valuesCalculaterowTotalValidDataNULL).getValue(0, 1);
	             will(returnValue(null));
	             one(valuesCalculaterowTotalValidDataNULL).getValue(0, 2);
	             will(returnValue(-22.394));
	         }
	     });
		
		mockCalculateRowTotalValidDataExtra = new Mockery();
		valuesCalculaterowTotalValidDataExtra = mockCalculateRowTotalValidDataExtra.mock(Values2D.class);
		mockCalculateRowTotalValidDataExtra.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalValidDataExtra).getColumnCount();
	             will(returnValue(3));
	             one(valuesCalculaterowTotalValidDataExtra).getValue(1, 0);
	             will(returnValue(37.17));
	             one(valuesCalculaterowTotalValidDataExtra).getValue(1, 1);
	             will(returnValue(0));
	             one(valuesCalculaterowTotalValidDataExtra).getValue(1, 2);
	             will(returnValue(63.193));
	             one(valuesCalculaterowTotalValidDataExtra).getValue(2, 2);
	             will(returnValue(-200.837));
	         }
	     });
		
		mockCalculateRowTotalUnderAcceptableCol = new Mockery();
		valuesCalculaterowTotalUnderAcceptableCol = mockCalculateRowTotalUnderAcceptableCol.mock(Values2D.class);
		mockCalculateRowTotalUnderAcceptableCol.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalUnderAcceptableCol).getColumnCount();
	             will(returnValue(4));
	             one(valuesCalculaterowTotalUnderAcceptableCol).getValue(0, 0);
	             will(returnValue(17.17));
	             one(valuesCalculaterowTotalUnderAcceptableCol).getValue(0, 1);
	             will(returnValue(-9));
	             one(valuesCalculaterowTotalUnderAcceptableCol).getValue(0, 2);
	             will(returnValue(-0.123));
	             one(valuesCalculaterowTotalUnderAcceptableCol).getValue(0, 3);
	             will(returnValue(8.127));
	         }
	     });
		
		mockCalculateRowTotalOverAcceptableCol = new Mockery();
		valuesCalculaterowTotalOverAcceptableCol = mockCalculateRowTotalOverAcceptableCol.mock(Values2D.class);
		mockCalculateRowTotalOverAcceptableCol.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalOverAcceptableCol).getColumnCount();
	             will(returnValue(3));
	             one(valuesCalculaterowTotalOverAcceptableCol).getValue(1, 0);
	             will(returnValue(90.80));
	             one(valuesCalculaterowTotalOverAcceptableCol).getValue(1, 1);
	             will(returnValue(88.320));
	             one(valuesCalculaterowTotalOverAcceptableCol).getValue(1, 2);
	             will(returnValue(7.8123));
	             one(valuesCalculaterowTotalOverAcceptableCol).getValue(0, 0);
	             will(returnValue(31.912));
	             one(valuesCalculaterowTotalOverAcceptableCol).getValue(0, 1);
	             will(returnValue(8.29));
	             one(valuesCalculaterowTotalOverAcceptableCol).getValue(0, 2);
	             will(returnValue(14.289));
	         }
	     });
		
		mockCalculateRowTotalBoundary = new Mockery();
		valuesCalculaterowTotalBoundary = mockCalculateRowTotalBoundary.mock(Values2D.class);
		mockCalculateRowTotalBoundary.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalBoundary).getColumnCount();
	             will(returnValue(3));
	             one(valuesCalculaterowTotalBoundary).getValue(1, 0);
	             will(returnValue(36.738));
	             one(valuesCalculaterowTotalBoundary).getValue(1, 1);
	             will(returnValue(89.324));
	             one(valuesCalculaterowTotalBoundary).getValue(1, 2);
	             will(returnValue(2.145));
	             one(valuesCalculaterowTotalBoundary).getValue(0, 0);
	             will(returnValue(32.483));
	             one(valuesCalculaterowTotalBoundary).getValue(0, 1);
	             will(returnValue(19.82));
	             one(valuesCalculaterowTotalBoundary).getValue(0, 2);
	             will(returnValue(71.21));
	         }
	     });
		
		mockCalculateRowTotalBoundaryNull = new Mockery();
		valuesCalculaterowTotalBoundaryNULL = mockCalculateRowTotalBoundaryNull.mock(Values2D.class);
		mockCalculateRowTotalBoundaryNull.checking(new Expectations() {
	         {
	             one(valuesCalculaterowTotalBoundaryNULL).getColumnCount();
	             will(returnValue(3));
	             one(valuesCalculaterowTotalBoundaryNULL).getValue(0, 0);
	             will(returnValue(null));
	             one(valuesCalculaterowTotalBoundaryNULL).getValue(0, 1);
	             will(returnValue(19.82));
	             one(valuesCalculaterowTotalBoundaryNULL).getValue(0, 2);
	             will(returnValue(71.21));
	         }
	     });
		
		mockGetCumulativePercentagesReal = new Mockery();
		getCumulativePercentagesReal = mockGetCumulativePercentagesReal.mock(KeyedValues.class);
		mockGetCumulativePercentagesReal.checking(new Expectations() {
	         {
	        	 allowing(getCumulativePercentagesReal).getItemCount();
	             will(returnValue(2));
	             allowing(getCumulativePercentagesReal).getValue(0);
	             will(returnValue(3));
	             allowing(getCumulativePercentagesReal).getKey(0);
	             will(returnValue("Tester"));
	             allowing(getCumulativePercentagesReal).getIndex("Tester");
	             will(returnValue(0));
	             allowing(getCumulativePercentagesReal).getValue(1);
	             will(returnValue(4));
	             allowing(getCumulativePercentagesReal).getKey(1);
	             will(returnValue("Buster"));
	             allowing(getCumulativePercentagesReal).getIndex("Buster");
	             will(returnValue(1));
	         }
	     });
		
		mockGetCumulativePercentagesNULL = new Mockery();
		getCumulativePercentagesNULL = mockGetCumulativePercentagesNULL.mock(KeyedValues.class);
		mockGetCumulativePercentagesNULL.checking(new Expectations() {
	         {
	        	 allowing(getCumulativePercentagesNULL).getItemCount();
	             will(returnValue(2));
	             allowing(getCumulativePercentagesNULL).getValue(0);
	             will(returnValue(null));
	             allowing(getCumulativePercentagesNULL).getKey(0);
	             will(returnValue("Tester"));
	             allowing(getCumulativePercentagesNULL).getIndex("Tester");
	             will(returnValue(0));
	             allowing(getCumulativePercentagesNULL).getValue(1);
	             will(returnValue(4));
	             allowing(getCumulativePercentagesNULL).getKey(1);
	             will(returnValue("Buster"));
	             allowing(getCumulativePercentagesNULL).getIndex("Buster");
	             will(returnValue(1));
	         }
	     });
		
		// createNumberArray() initialization for testing
		nullArray = null;
		createNumberArrayNegativeDoubles = new double[]{-9.1, -100.43, -99.5555};
	    createNumberArrayPositiveDoubles = new double[]{123.123123123, 8.888888888};
	    createNumberArrayInts = new double[] {1, 2, 3, 4};
	    createNumberArrayMixed = new double[] {20.91123123, -73.12, 7};
	    
	    // equal() initialization for testing
	    null2DArrayA = null;
      	null2DArrayB = null;
	    equalNullAndValid = new double[][] {{0, 1, 2}, {0, 1, 2}};
	    equalNumbersMatchAndMismatchA = new double[][] {{0, 1, 2}, {3, 4, 5}};
	    equalNumbersMatchB = new double[][] {{0, 1, 2}, {3, 4, 5}};
	    equalNumbersMismatchB = new double[][] {{3, 4, 5}, {0, 1, 2}};
	    equalDifferentDimensionsA = new double[][] {{0, 1}, {3, 4}};
	    equalDifferentDimensionsB = new double[][] {{0, 1}, {3, 4}, {Double.NaN, Double.NaN}};
	    equalNaNOnlyA = new double[][] {{Double.NaN, Double.NaN}, {Double.NaN, Double.NaN}};
	    equalNaNOnlyB = new double[][] {{Double.NaN, Double.NaN}, {Double.NaN, Double.NaN}};
	    equalINFOnlyA = new double[][] {{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};
	    equalINFOnlyB = new double[][] {{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};
	    equalINFAndNaNMatchA = new double[][] {{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, {Double.NaN, Double.NaN}};
	    equalINFAndNaNMatchB = new double[][] {{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, {Double.NaN, Double.NaN}};
	    equalINFAndNaNMismatchA = new double[][] {{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, {Double.NaN, Double.NaN}};
	    equalINFAndNaNMismatchB = new double[][] {{Double.NaN, Double.NaN}, {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};

        // clone() initialization for testing
        clonePositiveDoubles = new double[][]{{12.32, 29.48, 30.7}, {91.91, 8.19, 28.29}};
        cloneNegativeDoubles = new double[][]{{-9.88, -9766.2, -0.1}, {-0.2}, {-908.123}};
        cloneInts = new double[][]{{-2, 3, 5}, {6, 13, -12}, {4, 9, 2}, {7, 8, 9}};
        cloneMixed = new double[][]{{12, 13.1, -1, 123.456456}};
        cloneWithNull = new double[][]{{}};
        cloneWithNull[0] = null;
        
        validRowsAndCols = new int[] {0, 1, 2};
        validRowsTwoAndCols = new int[] {0, 1};
        invalidRowsAndCols = new int[]{-1, 0};
        largerValueThanRowsAndCols = new int[]{5, 0};
        largerValueThanRows = new int[]{0, 1, 2, 3};
        
        
        create2D = new double [][] {{0,1,2},{4,5,6}};
    }

   // Tests for the calculateColumnTotal()

   // Tests for a null Values2D object which should cause an IllegalArgumentException to be thrown
	 @Test(expected = IllegalArgumentException.class)
	 public void calculateColumnTotalForNullDataTest() {
	     DataUtilities.calculateColumnTotal(nullValue, 2);
	 }
	 
   // Tests for a valid Values2D object with a valid value for columns which should return a summation which matches the expected summation
	 @Test
	 public void calculateColumnTotalValidDataRealTest()
	 {
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataReal, 2);
		 assertEquals(-47.886, returnVal, .000000001d);
	 }
	 
   // Tests for a valid Values2D object that contains a "dummy" column value that does not match the column value asked for in the test (2) and thus should not be included in the summation, which should return a summation which matches the expected summation 
	 @Test
	 public void calculateColumnTotalValidDataExtraTest()
	 {
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataExtra, 2);
		 assertEquals(-40.259, returnVal, .000000001d);
	 }
	 
   // Tests for an unacceptable column value (-1) which should return a ExpectationError from JMock API
	 @Test(expected = org.jmock.api.ExpectationError.class)
	 public void calculateColumnTotalUnderAcceptableColTest()
	 {
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalUnderAcceptableCol, -1);
	 }
	 
   // Tests for a column value over the acceptable column range for which values have been allocated which should return an ExpectationError from JMock API
	 @Test(expected = org.jmock.api.ExpectationError.class)
	 public void calculateColumnTotalOverAcceptableColTest()
	 {
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalOverAcceptableCol, 2);
	 }
	 
   // Tests for a boundary condition where column is 1 and the max column is also 1 which should return a summation that matches the expected summation
	 @Test
	 public void calculateColumnTotalBoundaryTest()
	 {
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalBoundary, 1);
		 assertEquals(162.473, returnVal, .000000001d);
	 }
   
   // Tests for the calculateRowTotal()

   // Tests for a null Values2D object which should cause an IllegalArgumentException to be thrown 
   @Test(expected = IllegalArgumentException.class)
	 public void calculateRowTotalForNullDataTest() {
	     DataUtilities.calculateRowTotal(nullValue, 2);
	 }
	 
   // Tests for a valid Values2D object with a valid value for row which should return a summation which matches the expected summation
	 @Test
	 public void calculateRowTotalValidDataRealTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataReal, 0);
     assertEquals(-12.684, returnVal, .000000001d);
	 }

   // Tests for a valid Values2D object that contains a "dummy" row value that does not match the row value asked for in the test (1) and thus should not be included in the summation, which should return a summation which matches the expected summation of that row excluding the "dummy" row
   @Test
	 public void calculateRowTotalValidDataExtraTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataExtra, 1);
     assertEquals(100.363, returnVal, .000000001d);
	 }
	 
   // Tests for an unacceptable row value (-1) which should return a ExpectationError from JMock API
	 @Test(expected = org.jmock.api.ExpectationError.class)
	 public void calculateRowTotalUnderAcceptableColTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalUnderAcceptableCol, -1);
	 }
	 
   // Tests for a column row over the acceptable row range for which values have been allocated which should return an ExpectationError from JMock API
	 @Test(expected = org.jmock.api.ExpectationError.class)
	 public void calculateRowTotalOverAcceptableColTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalOverAcceptableCol, 2);
	 }
	 
   // Tests for a boundary condition where row is 1 and the max row is also 1 which should return a summation that matches the expected summation
	 @Test
	 public void calculateRowTotalBoundaryTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalBoundary, 1);
     assertEquals(128.207, returnVal, .000000001d);
	 }

  // Tests for the createNumberArray(double[] data)

  // Tests for a null double array which should cause an IllegalArgumentException to be thrown
  @Test(expected = IllegalArgumentException.class)
  public void createNumberArrayNullDataTest()
  {
    Number [] returnVal = DataUtilities.createNumberArray(nullArray);
  }
  
  // Tests for a negative array of doubles which should return a array of Number objects that matches the expected array of Number objects
  @Test
  public void createNumberArrayNegativeDoublesTest()
  {
    Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayNegativeDoubles);
  }

  // Tests for a positive array of doubles which should return a array of Number objects that matches the expected array of Number objects 
  @Test
	public void createNumberArrayPositiveDoublesTest()
  {
    Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayPositiveDoubles);
    Number [] expectedVal = {Double.valueOf(123.123123123), Double.valueOf(8.888888888)};
    assertArrayEquals(expectedVal, returnVal);
  }

  // Tests for a integer array which should return a array of Number objects that matches the expected array of Number objects 
  @Test
	public void createNumberArrayIntsTest()
  {
    Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayInts);
    Number [] expectedVal = {Double.valueOf(1), Double.valueOf(2), Double.valueOf(3), Double.valueOf(4)};
    assertArrayEquals(expectedVal, returnVal);
  }

  // Tests for a mixed array of doubles and integers with different signs which should return a array of Number objects that matches the expected array of Number objects 
  @Test
	public void createNumberArrayMixedTest()
  {
    Number [] returnVal = DataUtilities.createNumberArray(createNumberArrayMixed);
    Number [] expectedVal = {Double.valueOf(20.91123123), Double.valueOf(-73.12), Double.valueOf(7)};
    assertArrayEquals(expectedVal, returnVal);
  }

  // Tests for the equals(double[][] a, double[][] b)
  
  // Tests for a null double array for "a" and "b" which should return true that matches the expected boolean value 
  @Test
  public void equalNullsTest()
  {
    boolean returnVal = DataUtilities.equal(null2DArrayA, null2DArrayB);
    assertEquals(true, returnVal);
  }
  
  // Tests for a null double 2D array for "a" and a 2 element 2 level double array for "b" which should return false that matches the expected boolean value
  @Test
  public void equalNullAndValidTest()
  {
    boolean returnVal = DataUtilities.equal(null2DArrayA, equalNullAndValid);
    assertEquals(false, returnVal);
  }
  
  // Tests for a 2 element per level 2D double array for "a" and an identical array for "b" which should return true that matches the expected boolean value
  @Test
  public void equalNumbersMatchTest()
  {
    boolean returnVal = DataUtilities.equal(equalNumbersMatchAndMismatchA, equalNumbersMatchB);
    assertEquals(true, returnVal);
  }

  // Tests for a 2 element per level 2D double array for "a" and a reversed array for "b" which should return false that matches the expected boolean value
  @Test
  public void equalNumbersWrongOrderTest()
  {
    boolean returnVal = DataUtilities.equal(equalNumbersMatchAndMismatchA, equalNumbersMismatchB);
    assertEquals(false, returnVal);
  }

  // Tests for a 2 element per level 2D double array for "a" and a 3 element 2 level double array for "b" including NaN, which should return false that matches the expected boolean value 
  @Test
  public void equalNumbersDifferentDimensionsTest()
  {
    boolean returnVal = DataUtilities.equal(equalDifferentDimensionsA, equalDifferentDimensionsB);
    assertEquals(false, returnVal);
  }
  
  // Tests for a 2 element per level 2D double array for "a" containing NaN and an identical array for "b" which should return true that matches the expected boolean value
  @Test
  public void equalNaNMatchTest()
  {
    boolean returnVal = DataUtilities.equal(equalNaNOnlyA, equalNaNOnlyB);
    assertEquals(true, returnVal);
  }

  // Tests for a 2 element per level 2D double array for "a" containing INF and an identical array for "b" which should return true that matches the expected boolean value
  @Test
  public void equalINFMatchTest()
  {
    boolean returnVal = DataUtilities.equal(equalINFOnlyA, equalINFOnlyB);
    assertEquals(true, returnVal);
  }

  // Tests for a 4 element per level 2D double array for "a" containing combinations of INF and NaN and an identical array for "b" which should return true that matches the expected boolean value
  @Test
  public void equalINFAndNaNMatchTest()
  {
    boolean returnVal = DataUtilities.equal(equalINFAndNaNMatchA, equalINFAndNaNMatchB);
    assertEquals(true, returnVal);
  }

  // Tests for a 4 element per level 2D double array for "a" containing combinations of INF and NaN and a reversed array for "b" which should return false that matches the expected boolean value 
  @Test
  public void equalINFAndNaNMismatchTest()
  {
    boolean returnVal = DataUtilities.equal(equalINFAndNaNMismatchA, equalINFAndNaNMismatchB);
    assertEquals(false, returnVal);
  }
  
  // New tests for statement coverage improvement
  @Test
  public void equalWhereBIsNull()
  {
	  boolean returnVal = DataUtilities.equal(equalNullAndValid, null);
	  assertEquals(false, returnVal);
  }
  
  @Test
  public void equalWhereBIsNotNull()
  {
	  boolean returnVal = DataUtilities.equal(equalNumbersMatchAndMismatchA, null);
	  assertEquals(false, returnVal);
  }
  
  // Tests for the clone(double[][] source)
  
  // Tests for a null 2D double array "source" which causes a IllegalArgumentException to be thrown
  @Test(expected = IllegalArgumentException.class)
  public void cloneNullTest()
  {
    double [][] returnVal = DataUtilities.clone(null2DArrayA);  
  }

  // Tests for a positive 2D double array "source" which should return a array that matches the expected array
  @Test
  public void clonePositiveDoublesTest()
  {
    double [][] returnVal = DataUtilities.clone(clonePositiveDoubles);
    double [][] expectedVal = new double[][]{{12.32, 29.48, 30.7}, {91.91, 8.19, 28.29}};
    assertArrayEquals(expectedVal, returnVal);
  }

  // Tests for a negative 2D double array "source" which should return a array that matches the expected array
  @Test
  public void cloneNegativeDoublesTest()
  {
    double [][] returnVal = DataUtilities.clone(cloneNegativeDoubles);
    double [][] expectedVal = new double[][]{{-9.88, -9766.2, -0.1}, {-0.2}, {-908.123}};
    assertArrayEquals(expectedVal, returnVal);
  }
  
  // Tests for a integer 2D double array "source" which should return a array that matches the expected array
  @Test
  public void cloneIntegersTest()
  {
    double [][] returnVal = DataUtilities.clone(cloneInts);
    double [][] expectedVal = new double[][]{{-2, 3, 5}, {6, 13, -12}, {4, 9, 2}, {7, 8, 9}};
    assertArrayEquals(expectedVal, returnVal);
  }
  
  // Tests for a mixed 2D double array "source" which should return a array that matches the expected array
  @Test
  public void cloneMixedTest()
  {
    double [][] returnVal = DataUtilities.clone(cloneMixed);
    double [][] expectedVal = new double[][]{{12, 13.1, -1, 123.456456}};
    assertArrayEquals(expectedVal, returnVal);
  }
  
  // ----------------Tests to improve coverage.-------------------
  
  @Test
  public void cloneWithNullTest()
  {
    double [][] returnVal = DataUtilities.clone(cloneWithNull);
    double [][] expectedVal = new double[][] {{}};
    expectedVal[0] = null;
    assertArrayEquals(expectedVal, returnVal);
  }
  
  @Test(expected = IllegalArgumentException.class)
	 public void calculateColumnTotalSecondForNullDataTest() {
	     DataUtilities.calculateColumnTotal(nullValue, 2, validRowsAndCols);
	 }
  
  @Test
	 public void calculateColumnTotalSecondForValidDataTest() {
	     double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataReal, 2, validRowsAndCols);
	     assertEquals(-47.886, returnVal, .000000001d);
	 }
  
  @Test(expected = org.jmock.api.ExpectationError.class)
	 public void calculateColumnTotalSecondForValidDataTestInvalidRows() {
	     double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataReal, 2, invalidRowsAndCols);
	 }
  
  @Test
	 public void calculateColumnTotalForARowNumberTooLarge() {
	     double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataReal, 2, largerValueThanRowsAndCols);
	     assertEquals(3.123, returnVal, .000000001d);
	 }
  
  @Test
	 public void calculateColumnTotalForAReturnValOfNull() {
	     double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataExtra, 1, validRowsTwoAndCols);
	     assertEquals(97.622, returnVal, .000000001d);
	 }
  
  @Test(expected = IllegalArgumentException.class)
	 public void calculateRowTotal2ForNullDataTest() {
	     DataUtilities.calculateRowTotal(nullValue, 2, validRowsAndCols);
	 }
	 
	 @Test
	 public void calculateRowTotal2ValidDataRealTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataReal, 0, validRowsAndCols);
  assertEquals(-12.684, returnVal, .000000001d);
	 }

	 @Test
	 public void calculateRowTotalValidAboveRowCountTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataExtra, 1, largerValueThanRowsAndCols);
  assertEquals(37.17, returnVal, .000000001d);
	 }
	 
	 @Test
	 public void getCumulativePercentagesRealTest()
	 {
		 KeyedValues returnVal = DataUtilities.getCumulativePercentages(getCumulativePercentagesReal);
		 Number [] returnArr = new Number[] {Double.valueOf((double) returnVal.getValue("Tester")), Double.valueOf((double) returnVal.getValue("Buster"))};
		 Number [] expectedArr = new Number[] {Double.valueOf(0.42857142857142855), Double.valueOf(1)};
		 assertArrayEquals(expectedArr, returnArr);
	 }

	 @Test
	 public void createNumberArray2DTest()
	 {
	   Number [][] returnVal = DataUtilities.createNumberArray2D(create2D);
	   Number [][] expectedVal = new Number[][] {{Double.valueOf(0), Double.valueOf(1), Double.valueOf(2)}, {Double.valueOf(4), Double.valueOf(5), Double.valueOf(6)}};
	   assertArrayEquals(expectedVal, returnVal);
	 }
	 
	 //--------------------------------------------------------------------------------------------------
	 
	 @Test
	 public void getCumulativePercentagesNULLTest()
	 {
		 KeyedValues returnVal = DataUtilities.getCumulativePercentages(getCumulativePercentagesNULL);
		 Number [] returnArr = new Number[] {Double.valueOf((double) returnVal.getValue("Tester")), Double.valueOf((double) returnVal.getValue("Buster"))};
		 Number [] expectedArr = new Number[] {Double.valueOf(0), Double.valueOf(1)};
		 assertArrayEquals(expectedArr, returnArr);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void getCumulativePercentagesNULLArguementTest()
	 {
		 KeyedValues returnVal = DataUtilities.getCumulativePercentages(null);
	 }
	 
	 @Test(expected=IllegalArgumentException.class)
	 public void createNumberArrayNULLArgumentTest()
	 {
	   Number [][] returnVal = DataUtilities.createNumberArray2D(null);
	 }
	 
	 @Test
	 public void calculateRowTotal2ValidDataNULLTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataNULL, 0, validRowsAndCols);
  assertEquals(-13.684, returnVal, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotal2ValidDataTooLargeTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataReal, 0, largerValueThanRows);
  assertEquals(-12.684, returnVal, .000000001d);
	 }
	 
	 @Test
	 public void calculateRowTotalForNullValueTest() {
	     double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalBoundaryNULL, 0);
	     double expectedVal = 91.03;
	     assertTrue(expectedVal == returnVal);
	 }
	 
	 @Test
	 public void calculateColumnTotal2ValidDataTooLargeTest()
	 {
		 double returnVal = DataUtilities.calculateRowTotal(valuesCalculaterowTotalValidDataReal, 0, largerValueThanRows);
  assertEquals(-12.684, returnVal, .000000001d);
	 }
	 
	 @Test
	 public void calculateColumnTotalNULLTest()
	 {
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalNULL, 1);
		 assertEquals(63.743, returnVal, .000000001d);
	 }
	 
	 @Test
	  public void equalNumbersDifferentDimensionsFlippedTest()
	  {
	    boolean returnVal = DataUtilities.equal(equalDifferentDimensionsB, equalDifferentDimensionsA);
	    assertEquals(false, returnVal);
	  }
	 
	 @Test
	 public void calculateColumnTotal2BoundaryConditionTest()
	 {
		 int validRows[] = new int[] {0, 1, 2, 3};
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataExtraRandomReal, 2, validRows);
		 assertEquals(-47.886, returnVal, .000000001d);
	 }
	 
	 @Test
	 public void calculateColumnTotal2IncrementrowCountTest()
	 {
		 int validRows[] = new int[] {0, 1,};
		 double returnVal = DataUtilities.calculateColumnTotal(valuesCalculateColumnTotalValidDataExtraReal, 2, validRows);
		 assertEquals(3.123, returnVal, .000000001d);
	 }
	 
  //Tear-down is not needed for these tests.
  @After
  public void tearDown()
  {
  	
  }
}
