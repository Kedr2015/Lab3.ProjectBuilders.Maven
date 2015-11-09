package test.circle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import epam.saratov.homeWork.testng.objects.GeometricObjects;
import epam.saratov.homeWork.testng.objects.GeometricObjects.Circle;

/**
 * @author Nikita_Varchenko
 * 
 *         In the class of the object being tested methods of the circle.
 */
public class CircleTest {
    private GeometricObjects geometOb;
    private Circle circle;
    private double expectedArea;
    private double expectedLength;

    /**
     * Actions performed before starting the test class
     */
    @BeforeClass
    public void initgeometOb() {
	this.geometOb = new GeometricObjects();
    }

    /**
     * Input validation tests for area
     * 
     * @return These range and rounding marks
     */
    @DataProvider(name = "DataForTest")
    public Object[][] DataArea() {
	return new Object[][] { new Object[] { 4 }, new Object[] { 0 }, new Object[] { -1 } };
    }

    /**
     * Test method to check the area
     * 
     * @param radius
     *            - radius
     */
    @Test(dataProvider = "DataForTest")
    public void checkingAreaCircleTest(double radius) {
	System.out.println("checkingAreaCircleTest test started\n Check areas knit circle with a radius " + radius);
	this.circle = geometOb.getCircle(radius);
	expectedArea = Math.PI * Math.abs(Math.pow(radius, 2));
	Assert.assertEquals(circle.getSquare(), expectedArea, 0.001,
		"For radius = " + radius + "\nThe test fails, the area or the number of decimal places does not match");
	System.out.println("The test successfully completed\n");
    }

    /**
     * Test method to check the Constructor
     * 
     * @param radius
     *            - radius
     */
    @Test(dataProvider = "DataForTest",dependsOnMethods="checkingLengthCircleTest")
    public void circleConstructorTest(double radius) {
	System.out.println("circleConstructorTest test started\n Check areas knit circle with a radius " + radius);
	Circle circle = new GeometricObjects().getCircle(radius);
	Assert.assertNotNull(circle, "For radius = " + radius + "\nThe object is not created");
	System.out.println("The test successfully completed\n");
    }

    /**
     * Test method to check the length
     * 
     * @param radius
     *            - radius
     */
    @Test(dataProvider = "DataForTest")
    public void checkingLengthCircleTest(double radius) {
	System.out.println("checkingLengthCircleTest test started\n Check areas knit circle with a radius " + radius);
	this.circle = geometOb.getCircle(radius);
	expectedLength = Math.PI * 2 * Math.abs(radius);
	Assert.assertEquals(circle.getCircumference(), expectedLength, 0.001, "For radius = " + radius
		+ "\nThe test fails, the length or the number of decimal places does not match");
	System.out.println("The test successfully completed");
    }

}
