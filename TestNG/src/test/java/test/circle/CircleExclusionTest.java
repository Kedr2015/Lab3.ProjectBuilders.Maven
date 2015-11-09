package test.circle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import epam.saratov.homeWork.testng.objects.GeometricObjects;

/**
 * @author Nikita_Varchenko
 * 
 *         In the class of the object being tested methods of the circle.
 *         Exclusion Test
 */
public class CircleExclusionTest {
    private GeometricObjects geometOb;

    /**
     * Actions performed before starting the test class
     */
    @BeforeClass
    public void initgeometOb() {
	this.geometOb = new GeometricObjects();
    }

    /**
     * Input validation tests for exclusions
     * 
     * @return These range and rounding marks
     */
    @DataProvider(name = "DataForTest2")
    public Object[][] DataAreaExclusion() {
	return new Object[][] { new Object[] { null, 3 } };
    }

    /**
     * Test method to check the exclusions
     * 
     * @param radius
     *            - radius
     * @param numberDigitsDecimalPoint
     *            - rounding marks
     */
    @Test(dataProvider = "DataForTest2", expectedExceptions = RuntimeException.class)
    public void checkingAreaCircleTestExclusion(Double radius, Integer numberDigitsDecimalPoint) {
	System.out.println("checkingAreaCircleTestExclusion test started\n Check areas knit circle with a radius "
		+ radius + "\nIf you initialize a null value appears in an exception, the test fails");
	geometOb.getCircle(radius);
	System.out.println("The test fails");
    }
}
