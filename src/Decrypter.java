import java.util.Scanner;

public class Decrypter
{
    public static void main(String[] args)
    {
        // Declare variables
        Scanner scanner = new Scanner(System.in);
        String key; // Stores the decryption key entered by the user
        String cleanKey = ""; // Stores the cleaned decryption key without non-alphabet characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // The reference alphabet for decryption
        int count = 0; // Counter to iterate over the clean key
        int index; // Index used for decryption calculation
        String decryptedText = ""; // Stores the final decrypted text
        String encryptedText; // Stores the encrypted text to be decrypted
        String longKey = ""; // Expanded key to match the length of the encrypted text

        // Get the decryption key from the user
        System.out.print("Enter the decryption key: ");
        key = scanner.nextLine().toUpperCase();

        // Iterate through the key to create the clean key
        for (int i = 0; i < key.length(); i++)
        {
            // Test if the key's character exists in the alphabet
            if (alphabet.indexOf(key.charAt(i)) != -1)
            {
                // If yes, add it to the clean key
                cleanKey += key.charAt(i);
            }
        }

        // Get the encrypted text to be decrypted
        System.out.print("Enter the encrypted text: ");
        encryptedText = scanner.nextLine().toUpperCase();

        // Algorithm to create an expanded key with the same length as the encrypted text
        for (int i = 0; i < encryptedText.length(); i++)
        {
            // Test if the counter is within the bounds of the clean key's length
            if (count < cleanKey.length())
            {
                longKey += cleanKey.charAt(count);
                count++;
            }
            else
            {
                // Reset the counter if it exceeds the clean key's length
                count = 0;
                longKey += cleanKey.charAt(count); // Continue iteration from the start of the clean key
                count++;
            }
        }

        // Iterate through the encrypted text for decryption
        for (int i = 0; i < encryptedText.length(); i++)
        {
            // Test if the encrypted text's character exists in the alphabet
            if (alphabet.indexOf(encryptedText.charAt(i)) != -1)
            {
                // If exists, subtract the index of the encrypted text's character with the long key's character
                index = alphabet.indexOf(encryptedText.charAt(i)) - alphabet.indexOf(longKey.charAt(i));

                // Adjust index if it becomes negative
                while (index < 0)
                {
                    index += alphabet.length();
                }

                // Add the decrypted letter to the resulting string
                decryptedText += alphabet.charAt(index);
            }
            else
            {
                // If the character is not in the alphabet, add it to the decrypted text without decryption
                decryptedText += encryptedText.charAt(i);
            }
        }

        // Display the decrypted text
        System.out.print(decryptedText);
    }
}