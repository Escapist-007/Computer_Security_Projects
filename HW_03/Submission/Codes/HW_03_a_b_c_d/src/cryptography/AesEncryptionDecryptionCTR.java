package cryptography;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

import java.io.InputStream;
import java.io.OutputStream;


import java.security.spec.AlgorithmParameterSpec;

public class AesEncryptionDecryptionCTR {
	 Cipher ecipher;
	 Cipher dcipher;

	 public AesEncryptionDecryptionCTR(SecretKey key) {
	  // Create an 8-byte initialization vector 
	  byte[] iv = new byte[] {0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x0a,0x0b,0x0c,0x0d,0x0e,0x0f};

	  AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
	  try {
	   ecipher = Cipher.getInstance("AES/CTR/PKCS5Padding");
	   dcipher = Cipher.getInstance("AES/CTR/PKCS5Padding");

	   // CBC/CTR requires an initialization vector 
	   ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
	   dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }

	 // Buffer used to transport the bytes from one stream to another 
	 byte[] buf = new byte[1024];

	 public void encrypt(InputStream in , OutputStream out) {
	  try {
	   // Bytes written to out will be encrypted 
	   out = new CipherOutputStream(out, ecipher);

	   // Read in the clear text bytes and write to out to encrypt 
	   int numRead = 0;
	   while ((numRead = in .read(buf)) >= 0) {
	    out.write(buf, 0, numRead);
	   }
	   out.close();
	  } catch (java.io.IOException e) {}
	 }

	 public void decrypt(InputStream in , OutputStream out) {
	  try {
	   // Bytes read from in will be decrypted 
	   in = new CipherInputStream( in , dcipher);

	   // Read in the decrypted bytes and write the cleartext to out 
	   int numRead = 0;
	   while ((numRead = in .read(buf)) >= 0) {
	    out.write(buf, 0, numRead);
	   }
	   out.close();
	  } catch (java.io.IOException e) {}
	 }
    
}
 
    
