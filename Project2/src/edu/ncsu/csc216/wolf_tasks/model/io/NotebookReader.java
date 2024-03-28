package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Class that reads a notebook from a file.
 * Since this is a static class, the constructor should not be used.
 * @author Rachel Cantrell
 */
public class NotebookReader {
	
	/**
	 * Constructor for NotebookReader. Since all methods are static, this should not usually be used.
	 */
	public NotebookReader() {
		// Constructor intentionally left empty
	}
	
	/**
	 * Loads a Notebook object from the file provided.
	 * @param file the file to load from
	 * @return the Notebook loaded from the file
	 */
	public static Notebook readNotebookFile(File file) {
		processTaskList("");
		return null;
	}
	
	/**
	 * Private helper method for processing a taskList.
	 * @param taskListString the string to be processed
	 * @return the TaskList
	 */
	private static TaskList processTaskList(String taskListString){
		processTask(null, "");
		return null;
	}
	
	/**
	 * Private helper method for processing a task.
	 * @param taskList the taskList of the task being processed
	 * @param taskString the string to be processed
	 * @return the Task
	 */
	private static Task processTask(AbstractTaskList taskList, String taskString) {
		return null;
	}
		
}
