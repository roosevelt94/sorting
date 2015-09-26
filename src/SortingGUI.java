
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JComponent;

public class SortingGUI extends JComponent
{
	// Length of number array aka number of columns
	public static final int ARRAY_LENGTH = 30;

	// array to hold randomly generated numbers
	private Integer[] array;

	// width of each column
	private int width;

	/** Constructor for GUI sorting **/
	public SortingGUI()
	{
		generateRandomArray();
	}
	
	/** Create random array of length ARRAY_LENGTH 
	 * Each array element is a number between 0 and 230 
	 **/
	public void generateRandomArray()
	{
		// random array of 30 elements
		array = new Integer[ARRAY_LENGTH];
		for (int i = 0; i < ARRAY_LENGTH; i++)
		{
			// create a new instance of Random class
			Random rand = new Random();
			// generate a random number between 0 and 230
			int randomNum = rand.nextInt(320);
			array[i] = randomNum;
		}
	}

	/** Paint the bars, each bar representing a number 
	 * @param Graphics object
	 */
	public void paint(Graphics g)
	{
		setColWidth();
		
		int xCoord = 0;

		for ( int i = 0; i < ARRAY_LENGTH; i++)
		{
			// column height
			int colHeight = getColHeight(i);
			// y coord of current column
			int yCoord = getHeight() - colHeight;
			
			// set color and fill the bar
			g.setColor(Color.PINK);
			g.fillRect(xCoord, yCoord, width, colHeight);
			
			// draw the bar outline
			g.setColor(Color.BLACK);
			g.drawRect(xCoord, yCoord, width, colHeight);
			
			// draw the number
			g.drawString(Integer.toString((Integer)array[i]), xCoord, yCoord);
			
			// increment x coord and i
			xCoord += width;
		}
	}


	private void setColWidth()
	{
		// width of JComponent/number of bars
		width = getWidth()/ARRAY_LENGTH;
	}

	/** Find length of a column, given its index in the number array
	 *  @param index
	 *  @return int length of column in px
	 *  **/
	private int getColHeight(int index)
	{
		return (int)( array[index]*1.25);
	}

	/** setters for array **/
	public void setSelectionSort()
	{
		array = (Integer[])ArraySorter.selectionSort(array);
	}

	public void setInsertionSort()
	{
		array = (Integer[])ArraySorter.insertionSort(array);
	}

	public void setBubbleSort()
	{
		array = (Integer[])ArraySorter.bubbleSort(array);
	}

	public void setMergeSort()
	{
		array = (Integer[])ArraySorter.mergeSort(array);
	}
	
	public void setHeapSort()
	{
		// sort array using heapsort
		Comparable[] sortedArr = ArraySorter.heapSort(array);
		
		// copy the heapsorted array into array variable
		array = Arrays.copyOfRange(sortedArr, 1, sortedArr.length, Integer[].class);
	}
}

