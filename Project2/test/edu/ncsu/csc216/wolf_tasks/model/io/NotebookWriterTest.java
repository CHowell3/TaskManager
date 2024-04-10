package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Test for NotebookWriter class.
 * @author Rachel Cantrell
 */
public class NotebookWriterTest {
	
	/** File to write to to check output */
	public static final File FILE = new File("test-files/actual_out.txt");
	
	/** File that contains what the test should write */
	public static final File REFERENCE_FILE = new File("test-files/expected_out.txt");

	/** TaskList with name "ATaskList" */
	public static final TaskList LIST_A = new TaskList("ATaskList", 0);
	
	/** TaskList with name "Tasks1" */
	public static final TaskList LIST_1 = new TaskList("Tasks1", 0);
	
	/** TaskList with name "Tasks2" */
	public static final TaskList LIST_2 = new TaskList("Tasks2", 0);
	
	/** Task with name "Task1" */
	public static final Task TASK_1 = new Task("Task1", "Task1Description", true, false);

	/** Task with name "Task2" */
	public static final Task TASK_2 = new Task("Task2", "Task2Description", true, true);

	/** Task with name "Task3" */
	public static final Task TASK_3 = new Task("Task3", "Task3Description", false, false);

	/** Task with name "Task4" */
	public static final Task TASK_4 = new Task("Task4", "Task4Description", false, true);

	/** Task with name "Task5" */
	public static final Task TASK_5 = new Task("Task5", "Task5Description", true, false);
	
	/**
	 * Tests writeNotebookFile method
	 */
	@Test
	public void writeNotebookFileTest() {
		SortedList<TaskList> list = new SortedList<TaskList>();
		list.add(LIST_A);
		list.add(LIST_1);
		LIST_1.addTask(TASK_1);
		LIST_1.addTask(TASK_2);
		list.add(LIST_2);
		LIST_2.addTask(TASK_3);
		LIST_2.addTask(TASK_4);
		LIST_2.addTask(TASK_5);
		
		NotebookWriter.writeNotebookFile(FILE, "Notebook", list);
		
		assertTrue(contentsEqual(FILE, REFERENCE_FILE));
	}
	
	private boolean contentsEqual(File file1, File file2) {
		try {
			Scanner scanner1 = new Scanner(file1);
			Scanner scanner2 = new Scanner(file2);
			while(scanner1.hasNext() && scanner2.hasNext()) {
				String string1 = scanner1.nextLine();
				String string2 = scanner2.nextLine();
				if(!string1.trim().equals(string2.trim())) {
					closeScanners(scanner1, scanner2);
					return false;
				}
			}
			if(scanner1.hasNext() || scanner2.hasNext()) {
				closeScanners(scanner1, scanner2);
				return false;
			}
			closeScanners(scanner1, scanner2);
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
	
	private void closeScanners(Scanner scanner1, Scanner scanner2) {
		scanner1.close();
		scanner2.close();
	}
}
