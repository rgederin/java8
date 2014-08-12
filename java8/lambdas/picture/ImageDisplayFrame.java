package java8.lambdas.picture;

import java.awt.*;
import java.net.*;
import java.util.concurrent.*;
import javax.swing.*;

public class ImageDisplayFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JPanel imagePanel;
	private final String imagePattern = "http://www.coreservlets.com/images/internet-cafes/cafe-%s.jpg";
	private final int numImages = 22;

	/**
	 * A poolsize argument of 1 means single threaded, so that you can easily
	 * compare timing for threaded and non-threaded versions.
	 */
	public ImageDisplayFrame(int poolSize) throws Exception {
		super("Some Internet Cafes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		LafUtils.SetNimbusLaf();
		imagePanel = new JPanel();
		imagePanel.setBackground(Color.LIGHT_GRAY);
		JScrollPane contentPane = new JScrollPane(imagePanel);
		setContentPane(contentPane);
		ExecutorService taskList = Executors.newFixedThreadPool(poolSize);
		long before = System.currentTimeMillis();
		for (int i = 1; i <= numImages; i++) {
			JLabel label = new JLabel();
			URL location = new URL(String.format(imagePattern, i));
			taskList.execute(() -> {
				ImageIcon icon = new ImageIcon(location);
				label.setIcon(icon);
			});
			imagePanel.add(label);
			System.out.println("Retrieved image " + i);
		}
		taskList.shutdown();
		taskList.awaitTermination(60, TimeUnit.SECONDS);
		long after = System.currentTimeMillis();
		System.out.println("Number of milliseconds for all images = "
				+ (after - before));
		setSize(640, 475);
		setVisible(true);
	}
	
	public static void main (String [] args) throws Exception{
		new ImageDisplayFrame(22);
	}
}
