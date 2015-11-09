package test.rectangle;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import epam.saratov.homeWork.testng.objects.GeometricObjects;

/**
 * @author Nikita_Varchenko
 * 
 *         In the class of the being tested exclusions of the object Rectangle
 *         Exclusion Test
 */
public class RectangleExclusionTest {
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
     * @param sideOne
     *            - side One length
     * @param sideTwo
     *            - side Two length
     */
    @DataProvider(name = "DataForTest2")
    public Object[][] DataAreaExclusion() {
	return new Object[][] { new Object[] { null, 3 }, { 3, null }, { null, null } };
    }

    /**
     * Test method to check the exclusions
     * 
     * @param sideOne
     *            - side One length
     * @param sideTwo
     *            - side Two length
     */
    @Test(dataProvider = "DataForTest2", expectedExceptions = RuntimeException.class)
    public void checkingAreaCircleTestExclusion(Double sideOne, Double sideTwo) {
	System.out.println("CheckingAreaCircleTest test started\nCheck areas knit Rectang with a sideOne " + sideOne
		+ " and sideTwo" + sideTwo
		+ "\nIf you initialize a null value appears in an exception, the test fails");
	geometOb.getRectangle(sideOne, sideTwo);
    }

}
