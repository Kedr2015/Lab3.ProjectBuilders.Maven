package imageSearch;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.epam.searcher.googlesearch.ImageSearch;

/**
 * The class is used to test the method saveFilesToDisk search image Search
 * 
 * @author Nikita_Varchenko
 *
 */
@RunWith(Parameterized.class)
public class SaveImageToDiskTest {

    private int numberFilesInDirectory = 0;
    private static final String Parh = "C:\\temp\\img\\";// Path file storage
    private final String nameObjectSearch;// Object search
    private final int numberResultsSearch;// Number of results
    ImageSearch name = new ImageSearch();
    File file = new File(Parh);

    /**
     * Clears folders, before running the test
     */
    @Before
    public void DelFiles() {
	for (File dirDel : new File(Parh).listFiles())
	    if (dirDel.isFile()) {
		dirDel.delete();
	    }
	try {
	    name.saveFilesToDisk(nameObjectSearch, numberResultsSearch);
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error method saveFilesToDisk\nWith the following parameters:\nSearch for \"" + nameObjectSearch
		    + "\"\nThe amount of " + numberResultsSearch);
	}
	try {
	    for (String item : name.getLinksList(nameObjectSearch, numberResultsSearch)) {
		for (File nameFileInDirectory : file.listFiles()) {
		    if (item.indexOf(nameFileInDirectory.getName()) >= 1) {
			numberFilesInDirectory++;
		    }
		}
	    }
	} catch (IndexOutOfBoundsException e) {
	    fail("Fatal error method getLinksList\nWith the following parameters:\nSearch for \"" + nameObjectSearch
		    + "\"\nThe amount of " + numberResultsSearch);
	}

    }

    /**
     * Constructor initialization parameter tests
     * 
     * @param testSubject
     *            - Object search
     * @param testCount
     *            - Number of results
     */
    public SaveImageToDiskTest(final String testSubject, final int testCount) {
	this.nameObjectSearch = testSubject;
	this.numberResultsSearch = testCount;
    }

    /**
     * Input parameters for the test
     * 
     * @return List Object
     */
    @Parameters
    public static List<Object[]> isEmptyData() {
	return Arrays.asList(new Object[][] { { "giraffe", 8 }, { "Buffalo", 3 }, { "Buffalo", 0 }, { "", 0 },
		{ "", 1 }, { " ", 0 }, { "Buffalo", 9 } });
    }

    /**
     * Check the names of the stored Image from search results
     */
    @Test
    public void namesSavedImageTest() {
	System.out.println("Starting with the namesSavedImageTest of the test parameters:\nSearch for \""
		+ nameObjectSearch + "\"\nThe amount of " + numberResultsSearch);
	assertEquals("Test fails finished.\nIn the catalog, not all the files " + numberResultsSearch,
		numberFilesInDirectory, numberResultsSearch);
	System.out.println("Test successfully finished.\n");
    }

    /**
     * Check the number of the stored Image from search results
     */
    @Test
    public void amountSavedImageTest() {
	System.out.println("Starting with the amountSavedImageTest of the test parameters:\nSearch for \""
		+ nameObjectSearch + "\"\nThe amount of " + numberResultsSearch);
	assertEquals("Test fails finished.\nThe number of files in the directory     are not the same search results ",
		file.listFiles().length, numberResultsSearch);
	System.out.println("Test successfully finished.\n");
    }

}
