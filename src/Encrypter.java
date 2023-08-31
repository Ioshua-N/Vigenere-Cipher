import java.util.Scanner;

public class Encrypter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String key; // Stores the key entered by the user
        String cleanKey = ""; // Stores the key with non-alphabet characters removed
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alphabet used for encryption
        int count = 0; // Counter for iterating over the clean key
        int index; // Index used for calculating encryption
        String encryptedText = ""; // Stores the encrypted text
        String openText; // Stores the original text entered by the user
        String longKey = ""; // Expanded key to match the length of the original text

        // Obtain the key
        System.out.print("Enter the key: ");
        key = scanner.nextLine().toUpperCase();

        // Iterate through the key to create the clean key
        for (int i = 0; i < key.length(); i++)
        {
            if (alphabet.indexOf(key.charAt(i)) != -1)
            {
                cleanKey += key.charAt(i);
            }
        }

        // Obtain the original text
        System.out.print("Enter the original text: ");
        openText = scanner.nextLine().toUpperCase();

        // Create an expanded key of the same length as the original text
        for (int i = 0; i < openText.length(); i++)
        {
            if (count < cleanKey.length())
            {
                longKey += cleanKey.charAt(count);
                count++;
            }
            else
            {
                count = 0;
                longKey += cleanKey.charAt(count);
                count++;
            }
        }

        // Iterate through the original text to encrypt
        for (int i = 0; i < openText.length(); i++)
        {
            if (alphabet.indexOf(openText.charAt(i)) != -1)
            {
                index = alphabet.indexOf(openText.charAt(i)) + alphabet.indexOf(longKey.charAt(i));
                while (index >= alphabet.length())
                {
                    index -= alphabet.length();
                }
                encryptedText += alphabet.charAt(index);
            }
            else
            {
                encryptedText += openText.charAt(i);
            }
        }

        // Display the encrypted text
        System.out.print(encryptedText);
    }
}