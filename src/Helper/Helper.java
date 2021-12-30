package Helper;

import javax.swing.JOptionPane;

public class Helper {
		public static void showMsg(String str) {
			String msg;
			switch (str) {
			case "fill":
				msg = "ERROR! Please fill in the fields!";
				break;
			case "sucsess" :
				msg = "Great!";
				break;
			default:
				msg = str;
			}
			JOptionPane.showMessageDialog(null, msg, "Warning", JOptionPane.INFORMATION_MESSAGE);
		}
}
