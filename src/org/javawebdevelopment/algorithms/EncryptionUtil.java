package org.javawebdevelopment.algorithms;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptionUtil {
	public static String encript(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	public static boolean match(String password, String encryptedPassword) {
		return BCrypt.checkpw(password, encryptedPassword);
	}
}
