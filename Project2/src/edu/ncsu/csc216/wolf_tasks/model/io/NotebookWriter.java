package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * Class that writes a notebook to a file.
 * Throws an IllegalArgumentException if any exceptions or errors occur.
 */
public class NotebookWriter {
	
	/**
	 * Constructor for NotebookWriter. Since all methods are static, this should not usually be used.
	 */
	public NotebookWriter() {
		// Constructor intentionally left empty
	}

	/**
	 * Writes a Notebook to a file. Uses the Task.toString() method.
	 * If there are any errors, an IllegalArgumentException is thrown with the message "Unable to save file."
	 * @param file the file to write to
	 * @param notebookName the name of the notebook name saved
	 * @param taskLists the TaskLists in the notebook being saved
	 * @throws IllegalArgumentException in the case of any errors or exceptions
	 */
	public static void writeNotebookFile(File file, String notebookName, ISortedList<TaskList> taskLists) {
		// Method not yet implemented
	}

}
