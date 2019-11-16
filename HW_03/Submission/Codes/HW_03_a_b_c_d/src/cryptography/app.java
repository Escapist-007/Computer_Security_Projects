package cryptography;

import javax.crypto.KeyGenerator; // For Key Generaion
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
//import java.util.concurrent.TimeUnit;

public class app {

	public static void main(String[] args) {

		// System.out.println("Welcome to Cryptography");

		try {

			// ########## 128 BIT KEY GENERATION ###########

			long startTime = System.nanoTime();

			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128); // 128 bit
			SecretKey key = kgen.generateKey();

			long endTime = System.nanoTime();

			long keyGenerationTime128 = (endTime - startTime);

			System.out.println("128 bit Key Generation Time in nanoseconds: " + keyGenerationTime128);

			// ########## CBC MODE 128 bit key ##############

			// Create object of AesEncryptionDecryptionCBC class
			AesEncryptionDecryptionCBC encrypter = new AesEncryptionDecryptionCBC(key);

			// #### SMALL FILE - 1KB ####

			// Encrypt
			startTime = System.nanoTime();
			encrypter.encrypt(new FileInputStream("smallFile_1KB.txt"), new FileOutputStream("SmallFileEncrypted.txt"));
			endTime = System.nanoTime();

			long CBC_SmallFileEncryptionTime128 = (endTime - startTime);

			System.out.println(
					"Small file (1KB) Encryption time in nanoseconds - CBC Mode: " + CBC_SmallFileEncryptionTime128);

			// Decrypt
			startTime = System.nanoTime();
			encrypter.decrypt(new FileInputStream("SmallFileEncrypted.txt"),
					new FileOutputStream("SmallFileDecrypted.txt"));
			endTime = System.nanoTime();

			long CBC_SmallFileDecryptionTime128 = (endTime - startTime);

			System.out.println(
					"Small file (1KB) Decryption time in nanoseconds - CBC Mode: " + CBC_SmallFileDecryptionTime128);

			// #### LARGE FILE - 1MB ###

			// Encrypt
			startTime = System.nanoTime();
			encrypter.encrypt(new FileInputStream("largeFile_1MB.txt"), new FileOutputStream("LargeFileEncrypted.txt"));
			endTime = System.nanoTime();

			long CBC_LargeFileEncryptionTime128 = (endTime - startTime);

			System.out.println(
					"Large file (1MB) Encryption time in nanoseconds - CBC Mode: " + CBC_LargeFileEncryptionTime128);

			// Decrypt
			startTime = System.nanoTime();
			encrypter.decrypt(new FileInputStream("LargeFileEncrypted.txt"),
					new FileOutputStream("LargeFileDecrypted.txt"));
			endTime = System.nanoTime();

			long CBC_LargeFileDecryptionTime128 = (endTime - startTime);

			System.out.println(
					"Large file (1MB) Decryption time in nanoseconds - CBC Mode: " + CBC_LargeFileDecryptionTime128);

			// ########## CTR MODE 128 bit Key ###############

			// Create object of AesEncryptionDecryptionCTR class

			AesEncryptionDecryptionCTR encrypter1 = new AesEncryptionDecryptionCTR(key);

			// ### SMALL FILE - 1KB ###

			// Encrypt
			startTime = System.nanoTime();
			encrypter1.encrypt(new FileInputStream("smallFile_1KB.txt"),
					new FileOutputStream("SmallFileEncryptedCTR.txt"));
			endTime = System.nanoTime();

			long CTR_SmallFileEncryptionTime128 = (endTime - startTime);

			System.out.println(
					"Small file (1KB) Encryption time in nanoseconds - CTR Mode: " + CTR_SmallFileEncryptionTime128);

			// Decrypt
			startTime = System.nanoTime();
			encrypter1.decrypt(new FileInputStream("SmallFileEncryptedCTR.txt"),
					new FileOutputStream("SmallFileDecryptedCTR.txt"));
			endTime = System.nanoTime();

			long CTR_SmallFileDecryptionTime128 = (endTime - startTime);
			System.out.println(
					"Small file (1KB) Decryption time in nanoseconds - CTR Mode: " + CTR_SmallFileDecryptionTime128);

			// ### LARGE FILE - 1MB ###

			// Encrypt
			startTime = System.nanoTime();
			encrypter1.encrypt(new FileInputStream("largeFile_1MB.txt"),
					new FileOutputStream("LargeFileEncryptedCTR.txt"));
			endTime = System.nanoTime();

			long CTR_LargeFileEncryptionTime128 = (endTime - startTime);

			System.out.println(
					"Large file (1MB) Encryption time in nanoseconds - CTR Mode: " + CTR_LargeFileEncryptionTime128);

			// Decrypt
			startTime = System.nanoTime();
			encrypter1.decrypt(new FileInputStream("LargeFileEncryptedCTR.txt"),
					new FileOutputStream("LargeFileDecryptedCTR.txt"));
			endTime = System.nanoTime();

			long CTR_LargeFileDecryptionTime128 = (endTime - startTime);

			System.out.println(
					"Large file (1MB) Decryption time in nanoseconds - CTR Mode: " + CTR_LargeFileDecryptionTime128);

			// ########## CTR MODE 256 bit Key ###############

			// ########## 256 BIT KEY GENERATION ###########
			// https://www.andreafortuna.org/java/java-tips-how-to-fix-the-invalidkeyexception-illegal-key-size-or-default-parameters-runtime/

			startTime = System.nanoTime();

			KeyGenerator kgen1 = KeyGenerator.getInstance("AES");
			kgen1.init(256); // 256 bit
			SecretKey key1 = kgen1.generateKey();

			endTime = System.nanoTime();

			long keyGenerationTime256 = (endTime - startTime);

			System.out.println("256 bit Key Generation Time in nanoseconds: " + keyGenerationTime256);

			// Create object of AesEncryptionDecryptionCTR class

			AesEncryptionDecryptionCTR encrypter2 = new AesEncryptionDecryptionCTR(key1);

			// ### SMALL FILE - 1KB ###

			// Encrypt
			startTime = System.nanoTime();
			encrypter2.encrypt(new FileInputStream("smallFile_1KB.txt"),
					new FileOutputStream("SmallFileEncryptedCTR256.txt"));
			endTime = System.nanoTime();

			long CTR_SmallFileEncryptionTime256 = (endTime - startTime);

			System.out.println("Small file (1KB) Encryption time in nanoseconds - CTR Mode - 256 BIT KEY: "
					+ CTR_SmallFileEncryptionTime256);

			// Decrypt
			startTime = System.nanoTime();
			encrypter2.decrypt(new FileInputStream("SmallFileEncryptedCTR256.txt"),
					new FileOutputStream("SmallFileDecryptedCTR256.txt"));
			endTime = System.nanoTime();

			long CTR_SmallFileDecryptionTime256 = (endTime - startTime);

			System.out.println("Small file (1KB) Decryption time in nanoseconds - CTR Mode - 256 BIT KEY:"
					+ CTR_SmallFileDecryptionTime256);

			// ### LARGE FILE - 1MB ###

			// Encrypt
			startTime = System.nanoTime();
			encrypter2.encrypt(new FileInputStream("largeFile_1MB.txt"),
					new FileOutputStream("LargeFileEncryptedCTR256.txt"));
			endTime = System.nanoTime();

			long CTR_LargeFileEncryptionTime256 = (endTime - startTime);

			System.out.println("Large file (1MB) Encryption time in nanoseconds - CTR Mode - 256 BIT KEY: "
					+ CTR_LargeFileEncryptionTime256);

			// Decrypt
			startTime = System.nanoTime();
			encrypter2.decrypt(new FileInputStream("LargeFileEncryptedCTR256.txt"),
					new FileOutputStream("LargeFileDecryptedCTR256.txt"));
			endTime = System.nanoTime();

			long CTR_LargeFileDecryptionTime256 = (endTime - startTime);

			System.out.println("Large file (1MB) Decryption time in nanoseconds - CTR Mode - 256 BIT KEY: "
					+ CTR_LargeFileDecryptionTime256);

			// ####### HASH VALUE CALCULATION ############

			// SMALL FILE
			String[] HashArray = { "SHA-256", "SHA-512", "SHA3-256" };
			int m;
			for (m = 0; m < 3; m++) {

				MessageDigest md = MessageDigest.getInstance(HashArray[m]); 

				startTime = System.nanoTime();

				try {
					FileInputStream fis = new FileInputStream("smallFile_1KB.txt");
					byte[] dataBytes = new byte[1024];

					int nread = 0;
					while ((nread = fis.read(dataBytes)) != -1) {
						md.update(dataBytes, 0, nread);
					}
					fis.close();
				} catch (FileNotFoundException e) {
					System.out.println("File not found...");
				}

				byte[] mdbytes = md.digest();

				endTime = System.nanoTime();

				// convert the byte to hex format method
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < mdbytes.length; i++) {
					sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
				}

				// System.out.println("Hex format SHA 256 Hash Value of small
				// file is: "+ sb.toString());

				long hashTime = (endTime - startTime);
				System.out.println( HashArray[m] + "- Hashing time in nanoseconds - SMALL FILE " + hashTime);

				// LARGE FILE

				MessageDigest md2 = MessageDigest.getInstance(HashArray[m]);

				startTime = System.nanoTime();

				try {
					FileInputStream fis1 = new FileInputStream("largeFile_1MB.txt");
					byte[] dataBytes = new byte[1024];

					int nread = 0;
					while ((nread = fis1.read(dataBytes)) != -1) {
						md2.update(dataBytes, 0, nread);
					}
					fis1.close();
				} catch (FileNotFoundException e) {

				}

				byte[] mdbytes1 = md2.digest();

				endTime = System.nanoTime();
				// convert the byte to hex format method
				StringBuffer sb1 = new StringBuffer();
				for (int i = 0; i < mdbytes1.length; i++) {
					sb1.append(Integer.toString((mdbytes1[i] & 0xff) + 0x100, 16).substring(1));
				}

				// System.out.println("Hex format SHA 256 Hash Value of large
				// file is: "+ sb1.toString());

				hashTime = (endTime - startTime);
				System.out.println(HashArray[m] + "- Hashing time in nanoseconds- LARGE FILE " + hashTime);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
