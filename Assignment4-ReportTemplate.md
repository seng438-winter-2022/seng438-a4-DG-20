**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       |   |
|-----------------|---|
| Student Names:  |   |
|                 |   |
|                 |   |
|                 |   |

# Introduction


# Analysis of 10 Mutants of the Range class 
1.
``` 
public double getCentralValue() {
        return this.lower / 2.0 + this.upper / 2.0;
    } 
```

Survived Mutant: Substituted 2.0 with 1.0
Analysis: One of the test cases, specifically getZeroCentralValueValidRangeTest(), utilized an object of type Range where the lower and upper bounds were -20 and 20 respectively. As such, if the calculation was replaced with this.lower / 1.0 + this.upper / 1.0, it would yield the same result, 0.0, thus not catching the mutant and killing it.

2.
```
public static Range expand(Range range,
                               double lowerMargin, double upperMargin) {
        ParamChecks.nullNotPermitted(range, "range");
        double length = range.getLength();
        double lower = range.getLowerBound() - length * lowerMargin;
        double upper = range.getUpperBound() + length * upperMargin;
        if (lower > upper) {
            lower = lower / 2.0 + upper / 2.0;
            upper = lower;
        }
        return new Range(lower, upper);
    }
```

Killed Mutant: Substituted multiplication with division
Analysis: Since the calculation depends upon multiplication to expand the current upper and lower bounds, replacing it with division changes the performed calculation. Since the tests for this method cover margins which would yield different results when multiplying versus when dividing, the output changes, thus failing those tests. One of the test cases inputs 0 as the lower and upper margins, and if the multiplication was changed to division, it would produce a division by zero error. Hence, this mutant was killed.

3.
```
public static Range scale(Range base, double factor) {
        ParamChecks.nullNotPermitted(base, "base");
        if (factor < 0) {
            throw new IllegalArgumentException("Negative 'factor' argument.");
        }
        return new Range(base.getLowerBound() * factor,
                base.getUpperBound() * factor);
    }
```
    
Killed Mutant: Negated conditional
Analysis: Since the driving logic behind this function depends upon the condition where factor < 0, it is apparent that all test cases would fail as the opposite behavior would take place. As such, the mutant was killed by the tests.

4.
```
public static Range scale(Range base, double factor) {
        ParamChecks.nullNotPermitted(base, "base");
        if (factor < 0) {
            throw new IllegalArgumentException("Negative 'factor' argument.");
        }
        return new Range(base.getLowerBound() * factor,
                base.getUpperBound() * factor);
    }
```

Killed Mutant: Removed call to IllegalArgumentException
Analysis: The tests that are calling upon this method and passing in a negative factor expect the IllegalArgumentException to be thrown. This mutant removes this call, and thus the expectation is not met, killing this mutant and thus covering this change.

5.
```
public boolean intersects(double b0, double b1) {
        if (b0 <= this.lower) {
            return (b1 > this.lower);
        }
        else {
            return (b0 < this.upper && b1 >= b0);
        }
    }
```

Survived Mutant: Greater or equal to equal
Analysis: For the test case intersectsLowerEndTest, the numbers passed in did not even reach the mutant introduced in the else block of code. As such, the first return statement returned a value which was expected and the test case passed, meaning the mutant survived.

6.
```
public boolean intersects(Range range) {
        return intersects(range.getLowerBound(), range.getUpperBound());
    }
```

Killed Mutant: Replaced boolean return with false for first return statement
Analysis: In this case, the first return statement is changed to always return false for the intersects method that this overload method calls upon. In the test case intersectsRangeValidTest, this overloaded intersects method is called upon which calls upon the other intersects method (in the analysis above). Here, the expected return value is true as the lower bound of the object passed in is lower than the object of which this method is called upon. However, creating a mutant which always returns false defies the expected return value, and thus is caught, killing the mutant.

7.
```
public static Range combine(Range range1, Range range2) {
        if (range1 == null) {
            return range2;
        }
        if (range2 == null) {
            return range1;
        }
        double l = Math.min(range1.getLowerBound(), range2.getLowerBound());
        double u = Math.max(range1.getUpperBound(), range2.getUpperBound());
        return new Range(l, u);
    }
```

Killed Mutant: Replaced equality check with true for second if statement
Analysis: If the equality is replaced with true at all times, where range2 is not null, it would still enter that if statement and return range1, which is not the expected behavior. For example, in the test combineValidTest, two non-null Range objects are passed in, and neither if statement should be entered, however, due to this mutant, the second if statement is entered and range1 is returned, which is caught by the test case, and the mutant is killed.

8.
```
public static Range combine(Range range1, Range range2) {
        if (range1 == null) {
            return range2;
        }
        if (range2 == null) {
            return range1;
        }
        double l = Math.min(range1.getLowerBound(), range2.getLowerBound());
        double u = Math.max(range1.getUpperBound(), range2.getUpperBound());
        return new Range(l, u);
    }
```

Killed Mutant: Replaced return value with null for first return statement
Analysis: When range1 is null and range2 is not null, the expected value is a non-null Range object. However, this mutant sets the return value to be null. An example of this is combineRange1IsNullTest, where the range1 object is null and the range2 object is not null. Here, since the expected return value is a non-null Range object, the test case catches and kills this mutation. 

9.
```
public String toString() {
        return ("Range[" + this.lower + "," + this.upper + "]");
    }
```

Survived Mutant: Incremented this.lower with a post-increment operation
Analysis: A post-increment only applies after the line of code it is contained within is fully executed. As such, post-incrementing this.lower does not impact the return value, and rather changes it after, at which point the function ends anyways. As such, the expected value stays the same and the mutant survives.

10.
```
public String toString() {
        return ("Range[" + this.lower + "," + this.upper + "]");
    }
```

Killed Mutant: Incremented this.upper with a pre-increment operation
Analysis: A pre-increment applies right away, before the statement is executed. As such, this mutant changes the actual output, and thus is caught in the test cases as it will not match the expected output. For example, the toStringValidRangeTest method expects an output where the upper range is 200.0, however, this mutant would return 201.0 for the upper value, which gets caught and killed.

# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
