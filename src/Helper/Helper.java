package Helper;

import javax.swing.JOptionPane;

public class Helper {
	public static void showMsg(String str) {
		String msg;
		switch (str) {
		case "fill":
			msg = "ERROR! Please fill in the fields!";
			break;

		default:
			msg = str;
		}
		JOptionPane.showMessageDialog(null, msg, "Warning", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void showMsg2(String str2) {
		String msg2;
		switch (str2) {

		case "sucsess":
			msg2 = " Your changes are entered in the table! ";
			break;
		default:
			msg2 = str2;
		}
		JOptionPane.showMessageDialog(null, msg2, "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean confirm(String str) {
		String msg;
		switch (str) {
		case "sure":
			msg = "Are you sure you want to delete?";
			break;
		default:
			msg = str;
			break;
		}
		int res = JOptionPane.showConfirmDialog(null, msg, "Warning!", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			return true;
		} else {
			return false;
		}
	}

}
