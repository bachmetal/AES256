# AES256 Encryption/Decryption Tool

This project is a simple command-line tool for encrypting and decrypting text using the AES (Advanced Encryption Standard) algorithm with a 256-bit key. It is implemented in Java and allows users to securely encrypt their plaintext or decrypt their ciphertext using a user-defined key.

## Features

- **AES-256 Encryption**: Securely encrypt plaintext using a user-defined key.
- **Decryption**: Decrypt previously encrypted text using the same key.
- **User-Friendly Interface**: Simple command-line interface for easy interaction.

## Requirements

- Java Development Kit (JDK) 8 or higher
- Basic knowledge of Java and command-line operations

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/bachmetal/AES256.git
cd AES256
```

### Compile the Code

Make sure you have the JDK installed. You can compile the code using the following command:

```bash
javac Main.java
```

### Run the Tool

After compiling, you can run the tool with the following command:

```bash
java Main
```

### Usage

1. **Enter a Key**: When prompted, enter a key that will be used for encryption and decryption.
2. **Choose Operation**: You will be asked if you want to encrypt or decrypt text.
   - If you choose to encrypt, enter the plaintext you want to encrypt.
   - If you choose to decrypt, enter the encrypted text you want to decrypt.
3. **View Results**: The tool will display the encrypted or decrypted text based on your input.

### Example

```plaintext
Navid Rahbar presents:
AES256 encryption/decryption tool

Please enter your key: mysecretkey
Encryption? (y/n): y
Please enter your plaintext: Hello, World!
Encrypted: U2FsdGVkX1+...
```

## Error Handling

If the decryption fails (e.g., due to an incorrect key), the tool will notify you with an error message.

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author

Navid Rahbar

---

Feel free to modify the repository URL and author information as needed!
