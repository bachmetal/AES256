import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static SecretKey generateKey(String keyword) throws Exception {
        byte[] key = keyword.getBytes(StandardCharsets.UTF_8);
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        return new SecretKeySpec(key, "AES");
    }

    // Encrypts the given plaintext using the provided secret key
    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypts the given ciphertext using the provided secret key
    public static String decrypt(String ciphertext, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decoded = Base64.getDecoder().decode(ciphertext);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("ERROR: Encrypted message is not matching your key or AES algorithm.");
        }
        return "This message can not be decrypted!";
    }

    public static String keyInput(Scanner scanner) {
        System.out.print("Please enter your key: ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Navid Rahbar presents:");
                System.out.println("AES256 encryption/decryption tool\n");
                String keyword = keyInput(scanner);
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                SecretKey key = generateKey(keyword);
                String input;
                while (true) {
                    System.out.print("Encryption? (y/n): ");
                    input = scanner.nextLine().toLowerCase();
                    if (input.length() == 1 && (input.charAt(0) == 'y' || input.charAt(0) == 'n'))
                        break;
                    System.out.println("Invalid input, try again");
                }
                char i = input.charAt(0);

                switch (i) {
                    case 'y':
                        System.out.print("Please enter your plaintext: ");
                        String plaintext = scanner.nextLine();
                        String encryptedText = encrypt(plaintext, key);
                        System.out.println("Encrypted: " + encryptedText);
                        break;

                    case 'n':
                        System.out.print("Please enter your encrypted text: ");
                        String plaintext2 = scanner.nextLine();
                        String decryptedText = decrypt(plaintext2, key);
                        if (decryptedText.equals("This message can not be decrypted!")) break;
                        System.out.println("Decrypted: " + decryptedText);
                        break;
                }
                System.out.print("Press any key to exit...");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
