**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      | 25    |
| -------------- | --- |
| Curtis Silva |     |
| Divyansh Goyal               |     |
| Gurpartap Sohi               |     |
| Liam Parmar               |     |

<hr>

**Table of Contents**

[1 Introduction](#introduction)

[2 Analysis of 10 Mutants of The Range class ](#analysis-of-10-mutants-of-the-range-class)

[3 Mutation Statistics Before and After](#mutation-statistics-before-and-after)
* [3.1 DataUtilities](#datautilities)
* [3.2 Range](#range)

[5 New Coverage Achieved with Further Test Cases Added](#new-coverage-achieved-with-further-test-cases-added)
* [5.1 DataUtilities](#datautilities-1)
* [5.2 Range](#range-1)

[7 Advantages and Disadvantages of Requirements-Based Test Generation and Coverage-Based Test Generation](#advantages-and-disadvantages-of-requirements-based-test-generation-and-coverage-based-test-generation)

[8 Selenium Test Case Design Process](#selenium-test-case-design-process)

[9 Explaination on The Use of Checkpoints and Verifications](#explaination-on-the-use-of-checkpoints-and-verifications)

[10 Use of Different Test Data for Functionalities](#use-of-different-test-data-for-functionalities)

[12 How The Team Work was Divided and Managed](#how-the-team-work-was-divided-and-managed)

[13 Difficulties Encountered, Challenges Overcome, and Lessons Learned](#difficulties-encountered-challenges-overcome-and-lessons-learned

<hr>

# Introduction

<hr>

# Analysis of 10 Mutants of The Range class 
1.
``` 
public double getCentralValue() {
        return this.lower / 2.0 + this.upper / 2.0;
    } 
```

<strong>Survived Mutant:</strong> Substituted 2.0 with 1.0

<strong>Analysis:</strong> One of the test cases, specifically getZeroCentralValueValidRangeTest(), utilized an object of type Range where the lower and upper bounds were -20 and 20 respectively. As such, if the calculation was replaced with this.lower / 1.0 + this.upper / 1.0, it would yield the same result, 0.0, thus not catching the mutant and killing it.

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

<strong>Killed Mutant:</strong> Substituted multiplication with division

<strong>Analysis:</strong> Since the calculation depends upon multiplication to expand the current upper and lower bounds, replacing it with division changes the performed calculation. Since the tests for this method cover margins which would yield different results when multiplying versus when dividing, the output changes, thus failing those tests. One of the test cases inputs 0 as the lower and upper margins, and if the multiplication was changed to division, it would produce a division by zero error. Hence, this mutant was killed.

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
    
<strong>Killed Mutant:</strong> Negated conditional

<strong>Analysis:</strong> Since the driving logic behind this function depends upon the condition where factor < 0, it is apparent that all test cases would fail as the opposite behavior would take place. As such, the mutant was killed by the tests.

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

<strong>Killed Mutant:</strong> Removed call to IllegalArgumentException

<strong>Analysis:</strong> The tests that are calling upon this method and passing in a negative factor expect the IllegalArgumentException to be thrown. This mutant removes this call, and thus the expectation is not met, killing this mutant and thus covering this change.

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

<strong>Survived Mutant:</strong> Greater or equal to equal

<strong>Analysis:</strong> For the test case intersectsLowerEndTest, the numbers passed in did not even reach the mutant introduced in the else block of code. As such, the first return statement returned a value which was expected and the test case passed, meaning the mutant survived.

6.
```
public boolean intersects(Range range) {
        return intersects(range.getLowerBound(), range.getUpperBound());
    }
```

<strong>Killed Mutant:</strong> Replaced boolean return with false for first return statement

<strong>Analysis:</strong> In this case, the first return statement is changed to always return false for the intersects method that this overload method calls upon. In the test case intersectsRangeValidTest, this overloaded intersects method is called upon which calls upon the other intersects method (in the analysis above). Here, the expected return value is true as the lower bound of the object passed in is lower than the object of which this method is called upon. However, creating a mutant which always returns false defies the expected return value, and thus is caught, killing the mutant.

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

<strong>Killed Mutant:</strong> Replaced equality check with true for second if statement

<strong>Analysis:</strong> If the equality is replaced with true at all times, where range2 is not null, it would still enter that if statement and return range1, which is not the expected behavior. For example, in the test combineValidTest, two non-null Range objects are passed in, and neither if statement should be entered, however, due to this mutant, the second if statement is entered and range1 is returned, which is caught by the test case, and the mutant is killed.

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

<strong>Killed Mutant:</strong> Replaced return value with null for first return statement

<strong>Analysis:</strong> When range1 is null and range2 is not null, the expected value is a non-null Range object. However, this mutant sets the return value to be null. An example of this is combineRange1IsNullTest, where the range1 object is null and the range2 object is not null. Here, since the expected return value is a non-null Range object, the test case catches and kills this mutation. 

9.
```
public String toString() {
        return ("Range[" + this.lower + "," + this.upper + "]");
    }
```

<strong>Survived Mutant:</strong> Incremented this.lower with a post-increment operation

<strong>Analysis:</strong> A post-increment only applies after the line of code it is contained within is fully executed. As such, post-incrementing this.lower does not impact the return value, and rather changes it after, at which point the function ends anyways. As such, the expected value stays the same and the mutant survives.

10.
```
public String toString() {
        return ("Range[" + this.lower + "," + this.upper + "]");
    }
```

<strong>Killed Mutant:</strong> Incremented this.upper with a pre-increment operation

<strong>Analysis:</strong> A pre-increment applies right away, before the statement is executed. As such, this mutant changes the actual output, and thus is caught in the test cases as it will not match the expected output. For example, the toStringValidRangeTest method expects an output where the upper range is 200.0, however, this mutant would return 201.0 for the upper value, which gets caught and killed.

<hr>

# Mutation Statistics Before and After

## DataUtilities

### Before

![BeforeDataUtilities](https://user-images.githubusercontent.com/58268240/158420578-19d501f3-dca6-4972-918a-2902587ca380.png?style=centerme)

### After

## Range

### Before

![BeforeRange](https://user-images.githubusercontent.com/58268240/158420843-5fe37ef4-c68f-4a80-9187-7b4ad4554f84.png?style=centerme)

### After

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Selenium Test Case Design Process

To test walmart.ca, the group decided to test 6 major functionalities. These were decided after a discussion on which aspects of the website are used most and thus need to be thoroughly tested. The 6 functionalities decided to be tested were: 
1. Clicking a category hyperlink on the main page (T1)
2. Entering a search into the input form on the main page (T2)
3. Entering an email for subscription purposes on the main page at the bottom (T3 tested an incorrect email address format and T4 tested a correct email address format input)
4. Creating an account (T5 tested with an email address already in use)
5. Logging into an existing account (T6 tested by entering an incorrect password and T7 tested by entering a correct password)
6. Usability of profile option after logging in (T8).

After coming up with the major functionalities to be tested, the team deliberated on which test cases would require more than one test to cover it fully (as outlined above). Using this discussion, the team was able to create 8 test cases, 2 for each team member, once the functionalities to be tested were solidified.

# Explaination on The Use of Checkpoints and Verifications

Assertions and verifications are used and generated automatically through the Selenium IDE. These testing endpoints provide a checklist for the steps taken in a test case. The steps are what are measured to ensure the sequence of usage is occurring correctly and in the right order. Furthermore, these are important as they are responsible for not only reaching the correct output but ensuring that the correct output was achieved through the right steps. This is significant because often times, the correct output is reached but through incorrect steps, which should be counted as a failed test. 

The automated verfication steps/points are shown for each test below:

<strong>T1:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523058-2c1662fa-37ca-4bef-a08c-563dd690be73.png)

<strong>T2:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523111-d8b40755-30ce-4e3e-9896-9035f055a55f.png)

<strong>T3:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523200-ddb8f0c4-90d2-4fd7-9d46-7da07952f34a.png)

<strong>T4:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523278-de5ceb0b-a9c8-41b3-96ba-7cfb134448ea.png)

<strong>T5:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523356-1ce6e126-46bb-4e91-9a9e-1ce494663209.png)
![image](https://user-images.githubusercontent.com/58268240/158523378-bdb14bf2-6ba8-497f-abfe-d313f9221108.png)

<strong>T6:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523439-78ba8613-b50e-4eb6-8ecd-3dcbd6824fff.png)

<strong>T7:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523471-ec20ed75-5056-4917-9905-c3637b55b803.png)

<strong>T8:</strong>

![image](https://user-images.githubusercontent.com/58268240/158523516-e926b177-e744-47c3-849d-8bbd9b7a04d0.png)

# Use of Different Test Data for Functionalities

As outlined above, the group tested various functionalities of which two were selected to perform multiple tests on using different test data. This is because the target of these tests was a form which is authenticated through the back-end of the website. The first such test was performed on the email subscription form. This form required a valid email address to be entered so that the user can be subscribed to receive notifications. As such, the two test cases performed on it were one with a valid email address format, for example: "asdf@gmail.com" and one with an invalid email format: "asdf". The other such test was performed on the login form, where the two conditions to test were an incorrect password and a correct password. With testing these, the group made use of using different test data for functionalities to cover all aspects of the test design.

# Discuss Advantages and Disadvantages of Selenium vs. Sikulix

The pros of Sikulix compared to Selenium is that Sikulix makes use of an RPA tool that uses images on the screen for testing automation which can be better in some cases such as image captcha. The cons of Sikulix compared to Selenium is that Sikulix requires an image storage to be used for image recognition within the web page. Sikulix is also not great for the reading of text as compared to Selenium HTML based operation. Sikulix is less applicable to testing in most cases as it uses RPA and Selenium uses HTML/XML.

# How The Team Work was Divided and Managed

The assignment was divided into pairs for the mutation testing with one pair focusing on the Range class and the other focusing on the DataUtilities class. Within the pairs, one group member would identify the mutants that survived while the other group member would create the test case that would kill the mutant identified. After both pairs were done the entire group came together to evaluate the test cases created and the coverage reports for the mutations. For the process of Selenium testing on the Walmart website, we discussed as a group what functionalities we were going to test and split off individually and did two tests each. This discussion also involved identifying which functionalities require tests with different data, which were then grouped together for one member to design and implement.

# Difficulties Encountered, Challenges Overcome, and Lessons Learned

Some difficulties encountered were with PIT mutations not working properly. The PIT summary window would either not show up or just completely not work saying it couldn’t connect and we needed to reload the page. For some group members the PIT summary page was not accessible and despite many searches on the internet they couldn’t be resolved, luckily we had some members that were able to see the coverage results for the mutation testing. The running of PIT mutations also seemed to cause CPU usage to go up by a lot and took very long. When running Selenium once we tried to hover over an element it didn't register as a verification endpoint and so when the group ran the tests it caused errors on the webpage which resulted in gaps when testing. The group overcame the challenge with Selenium by finding workarounds to the issue. However, attempting to resolve these challenges led to the group having to invest lots of time. Some lessons learned were how to increase mutant test coverage and GUI testing with a chrome extension on a live website. Another lesson learned was effective teamwork when performing testing.

# Comments/feedback on the lab itself
