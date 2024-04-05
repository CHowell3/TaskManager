package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Test for NotebookReader class.
 * @author Rachel Cantrell
 */
public class NotebookReaderTest {

	/** Valid file with only a notebook name. */
	public static final File FILE_0 = new File("test-files/notebook0.txt");
	
	/** Valid file with three task lists. */
	public static final File FILE_1 = new File("test-files/notebook1.txt");
	
	/** Valid file with items that can be missing. */
	public static final File FILE_2 = new File("test-files/notebook2.txt");
	
	/** Missing leading ! in file - IAE thrown with message Unable to load file. */
	public static final File FILE_3 = new File("test-files/notebook3.txt");
	
	/** Task list without number of completed tasks - creates notebook with no task lists. */
	public static final File FILE_4 = new File("test-files/notebook4.txt");

	/** Task list with missing name - creates notebook with no tasks lists. */
	public static final File FILE_5 = new File("test-files/notebook5.txt");
	
	/** Task list with negative completed tasks - creates notebook with no tasks lists. */
	public static final File FILE_6 = new File("test-files/notebook6.txt");
	
	/** Task without a name - creates notebook with a task list - invalid task isn't added. */
	public static final File FILE_7 = new File("test-files/notebook7.txt");
	
	public static final File OUTPUT_FILE = new File("test-files/actual_out.txt");
	
	/**
	 * Tests readNotebookFile method
	 * Uses NotebookWriter class for some tests. NotebookWriter has already been tested and has passed all tests.
	 */
	@Test
	public void readNotebookFileTest() {
		Notebook n0 = NotebookReader.readNotebookFile(FILE_0);
		assertEquals("Summer Plans", n0.getNotebookName());
		String[] array0 = {"Active Tasks"};
		assertTrue(Arrays.equals(array0, n0.getTaskListsNames()));
		
		Notebook n1 = NotebookReader.readNotebookFile(FILE_1);
		assertEquals("School", n1.getNotebookName());
		String[] array1 = {"Active Tasks", "CSC 216", "CSC 226", "Habits"};
		assertTrue(Arrays.equals(array1, n1.getTaskListsNames()));
		n1.saveNotebook(OUTPUT_FILE);
		assertTrue(contentsEqual(FILE_1, OUTPUT_FILE));
		
		
	}
	
	private boolean contentsEqual(File file1, File file2) {
		try {
			Scanner scanner1 = new Scanner(file1);
			Scanner scanner2 = new Scanner(file2);
			while(scanner1.hasNext() && scanner2.hasNext()) {
				String string1 = scanner1.nextLine();
				String string2 = scanner2.nextLine();
				if(!string1.trim().equals(string2.trim())) {
					scanner1.close();
					scanner2.close();
					return false;
				}
			}
			if(scanner1.hasNext() || scanner2.hasNext()) {
				scanner1.close();
				scanner2.close();
				return false;
			}
			scanner1.close();
			scanner2.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
}
