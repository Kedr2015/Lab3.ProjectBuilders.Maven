package test.rectangle;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import epam.saratov.homeWork.testng.objects.GeometricObjects;
import epam.saratov.homeWork.testng.objects.GeometricObjects.Rectangle;

/**
 * @author Nikita_Varchenko
 * 
 *         In the class of the object being tested methods of the Rectangle
 * 
 *         It does not work without factory
 */
public class RectangleTest {
    private Double sideOne;
    private Double sideTwo;
    private GeometricObjects geometOb;
    private Rectangle rectangle;
    private double expectedArea;
    private double expectedPerimeter;

    /**
     * The constructor for the factory method
     * 
     * @param sideOne
     *            - side One length
     * @param sideTwo
     *            - side Two length
     */
    public RectangleTest(Double sideOne, Double sideTwo) {
	this.sideOne = sideOne;
	this.sideTwo = sideTwo;
    }

    /**
     * Actions performed before starting the test class
     */
    @BeforeClass
    public void initgeometOb() {
	this.geometOb = new GeometricObjects();
    }

    /**
     * 
     * Check equality of the parties
     */
    public boolean isQuadrate(double sideOne, double sideTwo) {
	int compare = Double.compare(Math.abs(sideOne), Math.abs(sideTwo));
	if (compare == 0) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Test method to check the area
     * 
     */
    @Test
    public void rectangleAreaTest() {
	System.out.println("checkingAreaRectangleTest test started\nCheck areas knit Rectang with a sideOne " + sideOne
		+ " and sideTwo" + sideTwo);
	this.rectangle = geometOb.getRectangle(sideOne, sideTwo);
	expectedArea = Math.abs(sideOne) * Math.abs(sideTwo);
	Assert.assertEquals(rectangle.getSquare(), expectedArea,
		"For sideOne = " + sideOne + " and sideTwo" + sideTwo + "\nThe test fails, the area does not match");
	System.out.println("The test successfully completed");
    }

    /**
     * Test method to check the length
     * 
     */
    @Test
    public void rectangleLengthTest() {
	System.out.println("checkingLengthRectangleTest test started\nCheck areas knit Rectang with a sideOne "
		+ sideOne + " and sideTwo" + sideTwo);
	this.rectangle = geometOb.getRectangle(sideOne, sideTwo);
	expectedPerimeter = 2 * (Math.abs(sideOne) + Math.abs(sideTwo));
	Assert.assertEquals(rectangle.getPerimeter(), expectedPerimeter, "Rectang with a sideOne " + sideOne
		+ " and sideTwo" + sideTwo + "\nThe test fails, the perimeter  places does not match");
	System.out.println("The test successfully completed");
    }

    /**
     * Test method to check the sign square
     * 
     */
    @Test
    public void rectangleQuadrateTest() {
	System.out.println("checkingQuadrateRectangleTest test started\nCheck areas knit Rectang with a sideOne "
		+ sideOne + " and sideTwo " + sideTwo);
	this.rectangle = geometOb.getRectangle(sideOne, sideTwo);
	Assert.assertEquals(rectangle.isQuadrate(), isQuadrate(sideOne, sideTwo), "Rectang with a sideOne " + sideOne
		+ " and sideTwo " + sideTwo + "\nThe method attribute of a square does not work properly");
	System.out.println("The test successfully completed");
    }

}
