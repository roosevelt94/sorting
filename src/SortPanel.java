import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class SortPanel extends JPanel implements ActionListener
{
	private SortingGUI sortDisplay;

	// a drop-down JComboBox
	private JComboBox sortMethod;

	// method option labels
	public static final String[] OPTIONS = {"Selection sort", "Insertion sort", "Bubble sort", "Merge sort", "Heap sort"}; 

	// two JButton
	private JButton createRandArr;
	private JButton sortArr;

	/** Construct a sorting GUI panel **/
	public SortPanel()
	{
		// set border layout
		setLayout( new BorderLayout() );
		add( createDropDownBox(), BorderLayout.NORTH);
		add( createButtonPanel(), BorderLayout.SOUTH);
		
		// initialize sorter
		sortDisplay = new SortingGUI();
		add(sortDisplay, BorderLayout.CENTER);
		refreshDisplay();
	}

	/** Drop down menu to select sorting method
	 * @return JPanel with the drop-down menu
	 */
	private JPanel createDropDownBox()
	{
		// drop down box: options string
		sortMethod = new JComboBox(OPTIONS);

		// select item at index 0 (selection sort)
		sortMethod.setSelectedIndex(0);

		// add action listener
		sortMethod.addActionListener(this);

		// create panel and add the drop down box to it
		JPanel comboBoxPanel = new JPanel();

		comboBoxPanel.add(sortMethod);

		return comboBoxPanel;
	}

	/** JPanel of two buttons: generate a new unsorted array, and to sort that array 
	 * 
	 * @return
	 */
	private JPanel createButtonPanel()
	{
		// create a JPanel
		JPanel buttonPanel = new JPanel( new GridLayout(1,2) );

		// initialize two buttons
		createRandArr = new JButton("Generate new unsorted array");
		sortArr = new JButton("Sort it!");

		// add action listener
		createRandArr.addActionListener(this);
		sortArr.addActionListener(this);

		// add to panel
		buttonPanel.add(createRandArr);
		buttonPanel.add(sortArr);
		return buttonPanel;
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof JComboBox)
		{
			// cast JComboBox to source
			JComboBox cbChosen = (JComboBox)e.getSource();
			// get the sort type chosen by user
			String sortType = (String)cbChosen.getSelectedItem();

			if (sortType.equals("Selection sort"))
			{
				// do selection sort
				sortDisplay.setSelectionSort();
			}
			else if (sortType.equals("Insertion sort"))
			{
				// do insertion sort
				sortDisplay.setInsertionSort();			
			}
			else if (sortType.equals("Bubble sort"))
			{
				// do bubble sort
				sortDisplay.setBubbleSort();
			}
			else 
			{
				sortDisplay.setMergeSort();
			}
		}
		else if (e.getSource() instanceof JButton)
		{
			// cast JButton
			JButton buttonPressed = (JButton)e.getSource();
			
			// if generate random array button is clicked
			if (buttonPressed.equals(createRandArr))
			{
				sortDisplay.generateRandomArray();
				refreshDisplay();

			}
			// else if user wants to sort 
			else if (buttonPressed.equals(sortArr))
			{
				// depends on which option in the drop-down box is chosen
				if (sortMethod.getSelectedItem().equals("Selection sort"))
				{
					sortDisplay.setSelectionSort();
				}
				else if (sortMethod.getSelectedItem().equals("Insertion sort"))
				{
					sortDisplay.setInsertionSort();
				}
				else if (sortMethod.getSelectedItem().equals("Bubble sort"))
				{
					sortDisplay.setBubbleSort();
				}
				else if (sortMethod.getSelectedItem().equals("Merge sort"))
				{
					sortDisplay.setMergeSort();
				}
				else
					sortDisplay.setHeapSort();
				
				refreshDisplay();
			}
		}
	}

	public void refreshDisplay()
	{
		repaint();
	}
}
