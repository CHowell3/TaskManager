package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * Class that writes a notebook to a file.
 * Throws an IllegalArgumentException if any exceptions or errors occur.
 * @author Johnathan Howell and Rachel Cantrell
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
		try {
			PrintStream writer = new PrintStream(file);
			writer.println("! " + notebookName);
			int numLists = taskLists.size();
			for(int i = 0; i < numLists; i++) {
				TaskList t = taskLists.get(i);
				writer.println("# " + t.getTaskListName() + "," + t.getCompletedCount());
				int numTasks = t.getTasks().size();
				for(int j = 0; j < numTasks; j++) {
					if(i == numLists - 1 && j == numTasks - 1) {
						writer.print(t.getTask(j));
					}
					else
						writer.println(t.getTask(j));
				}
			}
			writer.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}

}
