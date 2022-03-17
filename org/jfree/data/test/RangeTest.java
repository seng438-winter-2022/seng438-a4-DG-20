/*
 * Course: SENG 438
 * Assignment: 4
 * Team Members: Curtis Silva, Divyansh Goyal, Gurpartap Sohi, Liam Parmar
 */

package org.jfree.data.test;

// Import statements.
import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

// Creating a class for the RangeTest test cases.
public class RangeTest {
	// Declaring Range objects for testing purposes.
	private Range generalRange;
	private Range zeroRange;
    private Range nullRange;
    private Range scaleRange;
    private Range shiftRangeTrueCrossing;
    private Range shiftRangeFalseCrossing;
    private Range shiftRangeBoundary;
    private Range centralValueTesterPositive;
    private Range centralValueTesterNegative;
    private Range centralValueTesterZero;
    private Range expandValidTester;
    private Range expandMarginBoundary;
    private Range toStringValidTester;
    private Range constructorLowerAboveUpper;
    private Range rangeNaN;
    private Range NaNBottom;
    private Range NaNUpper;
    private Range inverseRange;
    private Range centralRange;

    // Before the test cases below begin running, setting the private Range objects by initializing them or setting them to null.
    @Before
    public void setUp() throws Exception { 
    	// General-purpose Range objects.
    	nullRange = null;
    	generalRange = new Range(0, 100);
    	
    	zeroRange = new Range(0, 0);
    	
    	// Range objects for scale method test.
    	scaleRange = new Range(-2.25, 100);
    	
    	// Range objects for shift method tests.
    	shiftRangeTrueCrossing = new Range(-11.0, 10072.0);
    	shiftRangeFalseCrossing = new Range(3.5, 89.0);
    	shiftRangeBoundary = new Range(-50.35, 100.70);
    	
    	// Range objects for centralValue method tests.
    	centralValueTesterPositive = new Range(1.0, 100.00);
    	centralValueTesterNegative = new Range(-100.00, -8.00);
    	centralValueTesterZero = new Range(-20.0, 20.0);
    	
    	// Range objects for expand method tests.
    	expandValidTester = new Range(0.0, 14.0);
    	expandMarginBoundary = new Range(-2.0, 99.99);
    	
    	// Range objects for toString method test.
    	toStringValidTester = new Range(-12.0, 200.0);
    	
    	rangeNaN = new Range(Double.NaN, Double.NaN);
    	NaNBottom = new Range(Double.NaN, 100);
    	NaNUpper = new Range(1, Double.NaN);
    	inverseRange = new Range(50, 60);
    	centralRange = new Range(20, 30);
    }


    // Tests for the scale() method.
    
    // Tests for a null Range object with an invalid "factor" value which should cause an IllegalArgumentException to be thrown
    @Test(expected = IllegalArgumentException.class)
    public void scaleNullRangeNegativeFactorTest() throws Exception 
    {
    	Range returnObj = generalRange.scale(nullRange, -5.345);
    }
    
    // Tests for a valid Range object with a invalid "factor" value which should cause an IllegalArgumentException to be thrown
    @Test(expected = IllegalArgumentException.class)
    public void scaleValidRangeNegativeFactorTest() throws Exception
    {
    	Range returnObj = generalRange.scale(scaleRange, -5.123);
    }
    
    // Tests for a null Range object with a valid "factor" value which should cause an IllegalArgumentException to be thrown
    @Test(expected = IllegalArgumentException.class)
    public void scaleNullRangeValidFactorTest() throws Exception
    {
    	Range returnObj = generalRange.scale(nullRange, 1000);
    }
    
    // Tests for a valid Range object with a valid "factor" value which should return a Range object which matches the expected Range object
    @Test
    public void scaleValidRangeValidFactorTest()
    {
    	Range returnObj = generalRange.scale(scaleRange, 2.34);
    	Range expectedObj = new Range(-5.265, 234.00);
    	assertEquals(expectedObj, returnObj);
    }
    
    // Tests for a boundary condition where "factor" value is 0.0 which should return a Range object where the lower and upper bounds are both 0.0
    @Test
    public void scaleFactorZeroTest()
    {
    	Range returnObj = generalRange.scale(scaleRange, 0.0);
    	Range expectedObj = new Range(0.0, 0.0);
    	assertEquals(expectedObj, returnObj);
    }
    
    // Tests for the shift() method.
    
    // Tests for a null Range object along with a true value for "allowZeroCrossing" which should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void shiftNullRangeTrueZeroCrossingTest() throws Exception
    {
    	Range returnObj = generalRange.shift(nullRange, -4.2325, true);
    }
    
    // Tests for a null Range object along with a false value for "allowZeroCrossing" which should throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void shiftNullRangeFalseZeroCrossingTest() throws Exception
    {
    	Range returnObj = generalRange.shift(nullRange, 500000, true);
    }
    
    // Tests for a valid Range object along with a true value for "allowZeroCrossing" which should return a Range object which matches the expected 
    // Range object
    @Test
    public void shiftValidRangeTrueZeroCrossingTest()
    {
    	Range returnObj = generalRange.shift(shiftRangeTrueCrossing, 500000.0, true);
    	Range expectedObj = new Range(499989.0, 510072.0);
    	assertEquals(expectedObj, returnObj);
    }
    
    // Tests for a valid Range object along with a false value for "allowZeroCrossing" which should return a Range object which matches the expected 
    // Range object
    @Test
    public void shiftValidRangeFalseZeroCrossingTest()
    {
    	Range returnObj = generalRange.shift(shiftRangeFalseCrossing, -4.2325, false);
    	Range expectedObj = new Range(0.00, 84.7675);
    	assertEquals(expectedObj, returnObj);
    }
    
    // Tests for a boundary condition where "delta" is 0.0 with a true value for "allowZeroCrossing" which should return a unchanged Range object 
    @Test
    public void shiftDeltaZeroTest()
    {
    	Range returnObj = generalRange.shift(shiftRangeBoundary, 0.0, true);
    	Range expectedObj = new Range(-50.35, 100.70);
    	assertEquals(expectedObj, returnObj);
    }
    
    // Tests for the getCentralValue() method.
    
    // Tests for a valid Range object where the central value is positive, it should return a double which matches the expected double
    @Test
    public void getPositiveCentralValueValidRangeTest()
    {
    	double expected = 50.5;
    	double actual = centralValueTesterPositive.getCentralValue();
    	assert(expected == actual);
    }
    
    // Tests for a valid Range object where the central value is negative, it should return a double which matches the expected double
    @Test
    public void getNegativeCentralValueValidRangeTest()
    {
    	double expected = -54.00;
    	double actual = centralValueTesterNegative.getCentralValue();
    	assert(expected == actual);
    }
    
    // Tests for a valid Range object where the central value is zero, it should return a double which is 0.0
    @Test
    public void getZeroCentralValueValidRangeTest()
    {
    	double expected = 0.00;
    	double actual = centralValueTesterZero.getCentralValue();
    	assert(expected == actual);
    }
    
    // Tests for a null Range object which should throw an NullPointerException
    @Test(expected = NullPointerException.class)
    public void getCentralValueNullRangeTest()
    {
    	double actual = nullRange.getCentralValue();
    }
    
    // Tests for the expand() method.
    
    // Tests for a valid Range object where one margin is negative and the other is positive, it should return a Range object 
    // which matches the expected Range object
    @Test
    public void expandValidMarginsTest()
    {
    	Range returnObj = Range.expand(expandValidTester, -0.10, 3.00);
    	Range expectedObj = new Range(1.4, 56.0);
    	// As seen in the example provided in the Github Repository, the bounds have been formatted 
    	// to account for the overflow of numbers for the least significant bit of the double  
    	double lowerBoundActual = Math.round(returnObj.getLowerBound() * 100000000.0) / 100000000.0;
    	double upperBoundActual = Math.round(returnObj.getUpperBound() * 100000000.0) / 100000000.0;
    	Range actualObj = new Range(lowerBoundActual, upperBoundActual);
    	assertEquals(expectedObj, actualObj);
    }
    
    // Tests for a null Range object, which should throw a IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void expandNullRangeTest()
    {
    	Range returnObj = Range.expand(nullRange, -0.30, 0.10);
    }
    
    // Tests for a boundary condition with a valid Range object where both margins are 0.00, it should return a unchanged Range object
    @Test
    public void expandZeroMarginsTest()
    {
    	Range returnObj = Range.expand(expandMarginBoundary, 0.00, 0.00);
    	Range expectedObj = new Range(-2.0, 99.99);
    	assertEquals(expectedObj, returnObj);
    }
    
    // Tests for the toString() method.
    
    // Tests for a valid Range object which should return a String which matches the expected String
    @Test
    public void toStringValidRangeTest()
    {
    	String actualMessage = toStringValidTester.toString();
    	String expectedMessage = "Range[-12.0,200.0]";
    	assertEquals(expectedMessage, actualMessage);
    }
    
    // Tests for a null Range object which should throw a NullPointerException
    @Test(expected = NullPointerException.class)
    public void toStringNullRangeTest() throws Exception
    {
    	String actualMessage = nullRange.toString();
    }
    
    // ----------------Tests to improve all coverage.-------------------
    @Test(expected = IllegalArgumentException.class)
    public void constructorWithLowerAboveUpperTest(){
    	constructorLowerAboveUpper = new Range(10, 5);
    }
    
    @Test
    public void containsValidTest(){
    	assertEquals(true, generalRange.contains(50));
    }
    
    @Test
    public void intersectsLowerEndTest(){
    	assertEquals(true, generalRange.intersects(-50, 10));
    }
    
    @Test
    public void intersectsUpperEndTest(){
    	assertEquals(true, generalRange.intersects(50, 110));
    }
    
    @Test
    public void intersectsRangeValidTest() {
    	assertEquals(true, generalRange.intersects(scaleRange));
    }
    
    @Test
    public void constrainValAboveUpperTest() {
    	assert(100 == generalRange.constrain(110));
    }
    
    @Test
    public void constrainValBelowLowerTest() {
    	assert(0 == generalRange.constrain(-2));
    }
    
    @Test
    public void combineRange1IsNullTest() {
    	assertEquals(generalRange, Range.combine(nullRange, generalRange));
    }
    
    @Test
    public void combineRange2IsNullTest() {
    	assertEquals(generalRange, Range.combine(generalRange, nullRange));
    }
    
    @Test
    public void combineValidTest() {
    	assertEquals(new Range(-2.25, 100), Range.combine(generalRange, scaleRange));
    }
    
    @Test
    public void combineIgnoringNaNRange1IsNullRange2NotNaNTest() {
    	assertEquals(scaleRange, Range.combineIgnoringNaN(nullRange, scaleRange));
    }
    
    @Test
    public void combineIgnoringNaNRange1IsNullRange2NaNTest() {
    	assertEquals(null, Range.combineIgnoringNaN(nullRange, rangeNaN));
    }
    
    @Test
    public void combineIgnoringNaNRange2IsNullRange1NotNaNTest() {
    	assertEquals(scaleRange, Range.combineIgnoringNaN(scaleRange, nullRange));
    }
    
    @Test
    public void combineIgnoringNaNRange2IsNullRange1NaNTest() {
    	assertEquals(null, Range.combineIgnoringNaN(rangeNaN, nullRange));
    }
    
    @Test
    public void combineIgnoringNaNRangeBothNaNsTest() {
    	assertEquals(null, Range.combineIgnoringNaN(rangeNaN, rangeNaN));
    }
    
    @Test
    public void combineIgnoringNaNRangeValidTest() {
    	assertEquals(new Range(-2.25, 100), Range.combineIgnoringNaN(scaleRange, generalRange));
    }
    
    @Test
    public void expandToIncludeNullRangeTest() {
    	assertEquals(new Range(60, 60), Range.expandToInclude(nullRange, 60));
    }
    
    @Test
    public void expandToIncludeValueBelowLowerTest() {
    	assertEquals(new Range(-6, 100), Range.expandToInclude(generalRange, -6));
    }
    
    @Test
    public void expandToIncludeValueAboveUpperTest() {
    	assertEquals(new Range(0, 110), Range.expandToInclude(generalRange, 110));
    }
    
    @Test
    public void expandToIncludeValueInRangeTest() {
    	assertEquals(generalRange, Range.expandToInclude(generalRange, 80));
    }
    
    @Test
    public void shiftValidTest() {
    	assertEquals(new Range(2, 102), Range.shift(generalRange, 2));
    }
    
    @Test
    public void hashCodeValidTest() {
    	assert(1079574528 == generalRange.hashCode());
    }
    
    //-------------------------------------------------------------------------------
    // Tests for Improving Mutation results
    @Test
    public void containsReturnsFalseTest(){
    	assertEquals(false, generalRange.contains(150));
    }
    
    @Test
    public void containsUpperBoundaryTest(){
    	assertEquals(true, generalRange.contains(100));
    }
    
    @Test
    public void containsLowerBoundaryTest(){
    	assertEquals(true, generalRange.contains(0));
    }
    
    @Test
    public void intersectsReturnsFalseTest(){
    	assertEquals(false, generalRange.intersects(10, -10));
    }
    
    @Test
    public void intersectsBOAndB1EqualOneTest(){
    	assertEquals(true, generalRange.intersects(1, 1));
    }
    
    @Test
    public void intersectsDecrementLowerBoundTest(){
    	assertEquals(false, generalRange.intersects(-2, 0));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void scaleFactorRemoveFirstConditionTest()
    {
    	Range returnObj = Range.scale(zeroRange, -1);
    	assertEquals(null, returnObj);
    
    }
   
    @Test
    public void isNanRangeNaNLowerTest()
    {
    	boolean returnVal = NaNBottom.isNaNRange();
    	assertEquals(false, returnVal);
    }
    
    @Test
    public void isNanRangeNaNUpperTest()
    {
    	boolean returnVal = NaNUpper.isNaNRange();
    	assertEquals(false, returnVal);
    }
    
    @Test
    public void isNanRangeTest()
    {
    	boolean returnVal = rangeNaN.isNaNRange();
    	assertEquals(true, returnVal);
    }
    
    @Test
    public void toStringWithGeneralRangeTest()
    {
    	String returnVal = generalRange.toString();
    	boolean match = returnVal.equals("Range[0.0,100.0]");
    	assertEquals(true, match);
    }
    
    @Test
    public void intersectsFirstConditionTrueTest(){
    	//50, 60
    	assertEquals(false, generalRange.intersects(500, 10));
    }
    
    @Test
    public void intersectsWithNegativesLessThanLowerBoundTest(){
    	//50, 60
    	assertEquals(false, inverseRange.intersects(40, 50));
    }
    
    @Test
    public void intersectsIfFirstConditionChangedToEqualEqualTest(){
    	assertEquals(false, generalRange.intersects(-10, 0));
    }
    
    @Test
    public void intersectsWithDecrementingLowerBoundInSecondConditionTest(){
    	assertEquals(false, generalRange.intersects(0, 0));
    }
    
    @Test
    public void intersectsWithIncrementingLowerBoundInSecondConditionTest(){
    	assertEquals(true, generalRange.intersects(0, 1));
    }
    
    @Test
    public void intersectsWithThirdConditionAlteredTrueTest(){
    	assertEquals(false, generalRange.intersects(500, 500));
    }
    
    @Test
    public void intersectsWithUpperBoundIncrementedInThirdConditionTest(){
    	assertEquals(false, generalRange.intersects(100, 100));
    }
    
    @Test
    public void intersectsWithUpperBoundDecrementedInThirdConditionTest(){
    	assertEquals(true, generalRange.intersects(99, 99));
    }
    
    @Test
    public void intersectsWithB0DecrementedInThirdConditionTest(){
    	assertEquals(false, generalRange.intersects(100, 100));
    }
    
    @Test
    public void getLengthTest()
    {
    	double returnVal = scaleRange.getLength();
    	assertTrue(102.25 == returnVal);
    }
    
    @Test
    public void getCentralValueFor1Test()
    {
    	double returnVal = centralRange.getCentralValue();
    	assertTrue(25 == returnVal);
    }
    
    // Tear-down is not needed for these tests.
    @After
    public void tearDown()
    {
    	
    }
}
