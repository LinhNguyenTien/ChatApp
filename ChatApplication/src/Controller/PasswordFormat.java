package Controller;

public class PasswordFormat {
	// Ham kiem tra do manh cua mat khau
	public static boolean checkPasswordStrength(String password) {
		// Do dai toi thieu cua mat khau
		int minLength = 8;
		// Co chua ky tu dac biet
		boolean hasSpecialCharacter = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
		// Co chua chu cai viet hoa
		boolean hasUpperCase = password.matches(".*[A-Z].*");
		// Co chua chu cai viet thuong
		boolean hasLowerCase = password.matches(".*[a-z].*");
		// Co chua so
		boolean hasDigit = password.matches(".*\\d.*");
		// Tinh diem cua mat khau
		int score = 0;
		if(password.length() >= minLength) {
			score = score + 2;
		}
		if(hasSpecialCharacter) {
			score++;
		}
		if(hasUpperCase && hasLowerCase) {
			score++;
		}
		if(hasDigit) {
			score++;
		}
		// Kiem tra diem cua mat khau
		if(score >= 4) {
			return true;
		}else {
			return false;
		}
	}
}
