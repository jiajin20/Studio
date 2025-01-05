package com.cf.studio.util;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // 加密密码
    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // 验证密码
    public static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
