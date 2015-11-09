package test.quadrate;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import epam.saratov.homeWork.testng.objects.GeometricObjects;

/**
 * @author Nikita_Varchenko
 * 
 *         In the class of the being tested exclusions of the Quadrate
 * 
 *         Exclusion Test
 */
public class QuadrateExclusionTest {

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
     * @return These side length
     */
    @DataProvider(name = "DataForTest2")
    public Object[][] DataAreaExclusion() {
	return new Object[][] { new Object[] { null } };
    }

    /**
     * Test method to check the exclusions
     * 
     * @param side
     *            - side length
     */
    @Test(dataProvider = "DataForTest2", expectedExceptions = RuntimeException.class)
    public void checkingAreaCircleTestExclusion(Double side) {
	System.out.println("CheckingAreaCircleTest test started\n Check areas knit circle with a side " + side
		+ "\nIf you initialize a null value appears in an exception, the test fails");
	geometOb.getQuadrate(side);
	System.out.println("The test fails");
    }
}
