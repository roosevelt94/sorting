import javax.swing.JFrame;

public class SortingGUIApplication {

	public static void main(String[] args) 
	{
		// create a JFrame
		JFrame sortFrame = new JFrame("Sort an unsorted array");
		
		// set size
		sortFrame.setSize(800,500);
		
		// set normal exiting upon closing the window
		sortFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add sorting panel to frame
		SortPanel sortPanel = new SortPanel();
		
		sortFrame.add(sortPanel);
		
		// set visible
		sortFrame.setVisible(true);
	}

}
