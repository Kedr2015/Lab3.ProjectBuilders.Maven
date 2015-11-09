package test.quadrate;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import epam.saratov.homeWork.testng.objects.GeometricObjects;
import epam.saratov.homeWork.testng.objects.GeometricObjects.Quadrate;

/**
 * @author Nikita_Varchenko
 * 
 *         In the class of the object being tested methods of the Quadrate
 */
public class QuadrateTest {
    private GeometricObjects geometOb;
    private Quadrate quadrate;
    private double expectedArea;
    private double expectedPerimeter;

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
     * @return These side length
     */
    @DataProvider(name = "DataForTest")
    public Object[][] DataArea() {
	return new Object[][] { new Object[] { 4 }, new Object[] { 0 }, new Object[] { -1 } };
    }

    /**
     * Test method to check the area
     * 
     * @param side
     *            - side length
     */
    @Test(dataProvider = "DataForTest")
    public void quadrateAreaTest(double side) {
	System.out.println("CheckingAreaCircleTest test started\n Check areas knit circle with a radius " + side);
	this.quadrate = geometOb.getQuadrate(side);
	expectedArea = Math.abs(Math.pow(side, 2));
	Assert.assertEquals(quadrate.getSquare(), expectedArea,
		"For side = " + side + "\nThe test fails, the area or the number of decimal places does not match");
	System.out.println("The test successfully completed. Area= " + quadrate.getSquare() + "\n");
    }

    /**
     * Test method to check the Constructor
     * 
     * @param side
     *            - side length
     */
    @Test(dataProvider = "DataForTest")
    public void quadrateConstructorTest(double side) {
	System.out.println("quadrateConstructorTest test started\n Check areas knit circle with a radius " + side);
	Quadrate quadrate = new GeometricObjects().getQuadrate(side);
	Assert.assertNotNull(quadrate, "For radius = " + side + "\nThe object is not created");
	System.out.println("The test successfully completed\n");
    }

    /**
     * Test method to check the length
     * 
     * @param side
     *            - side length
     */
    @Test(dataProvider = "DataForTest")
    public void quadrateLengthTest(double side) {
	System.out.println("quadrateLengthTest test started\n Check areas knit circle with a side " + side);
	this.quadrate = geometOb.getQuadrate(side);
	expectedPerimeter = 4 * Math.abs(side);
	Assert.assertEquals(quadrate.getPerimeter(), expectedPerimeter,
		"For side = " + side + "\nThe test fails, the length or the number of decimal places does not match");
	System.out.println("The test successfully completed. Perimeter= " + quadrate.getPerimeter() + "\n");
    }

}
