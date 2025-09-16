package com.example.OneTimePad;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/otp")
public class CreateOneTimePadController {

    private static final SecureRandom random = new SecureRandom();
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 _,.:!;@#$%*&-+/|'{}<>~`₹?()^=";
    private static final int length = characters.length();

    private String generateKey(String message) {
        StringBuilder key = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            key.append(characters.charAt(random.nextInt(length)));
        }
        return key.toString();
    }

    private String encryptMessage(String message, String key) {
        StringBuilder encrypted = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            int m = characters.indexOf(message.charAt(i));
            int k = characters.indexOf(key.charAt(i));
            encrypted.append(characters.charAt((m + k) % length));
        }
        return encrypted.toString();
    }

    private String decryptMessage(String encrypted, String key) {
        StringBuilder decrypted = new StringBuilder(encrypted.length());
        for (int i = 0; i < encrypted.length(); i++) {
            int e = characters.indexOf(encrypted.charAt(i));
            int k = characters.indexOf(key.charAt(i));
            decrypted.append(characters.charAt((e - k + length) % length));
        }
        return decrypted.toString();
    }
    // API endpoint to encrypt a message
    @PostMapping("/encrypt")
    public ResponseEntity<Map<String, String>> processEncryption(@RequestBody Map<String, String> request) {
        String message = request.get("message");

        if (message == null || message.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Message cannot be null or empty"));
        }

        String key = generateKey(message);
        String encryptedMessage = encryptMessage(message, key);

        Map<String, String> response = new HashMap<>();
        response.put("originalMessage", message);
        response.put("key", key);
        response.put("encryptedMessage", encryptedMessage);

        return ResponseEntity.ok(response);
    }

    // API endpoint to decrypt a message
    @PostMapping("/decrypt")
    public ResponseEntity<Map<String, String>> processDecryption(@RequestBody Map<String, String> request) {
        String encryptedMessage = request.get("encryptedMessage");
        String key = request.get("key");

        if (encryptedMessage == null || key == null || encryptedMessage.trim().isEmpty() || key.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Encrypted message and key cannot be null or empty"));
        }

        String decryptedMessage = decryptMessage(encryptedMessage, key);

        Map<String, String> response = new HashMap<>();
        response.put("decryptedMessage", decryptedMessage);

        return ResponseEntity.ok(response);
    }
}
