package clicker;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;

public class Main {
	public static void main(String[] args) throws AWTException {
		Provider provider = Provider.getCurrentProvider(false);
		provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK),
		new HotKeyListener() {
			public void onHotKey(HotKey hotKey) {
				Point pos = MouseInfo.getPointerInfo().getLocation();
				do {
					try {
						Robot clicker = new Robot();
						clicker.mousePress(InputEvent.BUTTON1_MASK);
						clicker.delay(10);
						clicker.mouseRelease(InputEvent.BUTTON1_MASK);
						clicker.delay(30);
					} catch (AWTException e) {
						e.printStackTrace();
					}
					if (!MouseInfo.getPointerInfo().getLocation().equals(pos)) {
						break;
					}
				} while (true);
			}
		});

		provider.register(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK),
		new HotKeyListener() {
			public void onHotKey(HotKey hotKey) {
				System.exit(0);
			}
		});
	}
}
