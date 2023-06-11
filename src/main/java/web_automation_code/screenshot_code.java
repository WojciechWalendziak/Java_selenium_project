package web_automation_code;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Screenshot_code {

	public void make_screenshot() {
		// TODO Auto-generated method stub
		try {
			// Capture the screen
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);

            // Save the screenshot as an image file
            File screenshotFile = new File("screenshot.jpg");
            ImageIO.write(screenCapture, "jpg", screenshotFile);

            System.out.println("Screenshot saved successfully.");
        } catch (AWTException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }

	}

}
