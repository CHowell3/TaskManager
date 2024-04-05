package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;



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
	
	public static final File OUTPUT_FILE = new File("actual_out.txt");
	
	/**
	 * Tests readNotebookFile method
	 * Uses NotebookWriter class for some tests. NotebookWriter has already been tested and has passed all tests.
	 */
	@Test
	public void readNotebookFileTest() {
		fail("Still debugging");
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
		
		Notebook n2 = NotebookReader.readNotebookFile(FILE_2);
		assertEquals("School", n2.getNotebookName());
		String[] array2 = {"Active Tasks", "CSC 216", "CSC 226", "Habits"};
		assertTrue(Arrays.equals(array2, n2.getTaskListsNames()));
		n2.saveNotebook(OUTPUT_FILE);
		assertTrue(contentsEqual(FILE_1, OUTPUT_FILE));
		
		Exception e = assertThrows(IllegalArgumentException.class, () -> NotebookReader.readNotebookFile(FILE_3));
		assertEquals("Unable to load file.", e.getMessage());
		
		Notebook n4 = NotebookReader.readNotebookFile(FILE_4);
		assertEquals("Personal", n4.getNotebookName());
		String[] array4 = {"Active Tasks"};
		assertTrue(Arrays.equals(array4, n4.getTaskListsNames()));
		
		Notebook n5 = NotebookReader.readNotebookFile(FILE_5);
		assertEquals("Personal", n5.getNotebookName());
		assertTrue(Arrays.equals(new String[0], n5.getTaskListsNames()));
		
		Notebook n6 = NotebookReader.readNotebookFile(FILE_6);
		assertEquals("Personal", n6.getNotebookName());
		assertTrue(Arrays.equals(new String[0], n6.getTaskListsNames()));
		
		Notebook n7 = NotebookReader.readNotebookFile(FILE_7);
		assertEquals("Personal", n7.getNotebookName());
		String[] array7 = {"Habits"};
		assertTrue(Arrays.equals(array7, n7.getTaskListsNames()));
		n7.setCurrentTaskList("Habits");
		ISwapList<Task> habits = n7.getCurrentTaskList().getTasks();
		assertEquals(1, habits.size());
		Task task = habits.get(0);
		assertEquals("Floss", task.getTaskName());
		assertEquals("Floss when brushing my teeth before bed! ", task.getTaskDescription());
		assertTrue(task.isActive());
		assertTrue(task.isRecurring());
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
