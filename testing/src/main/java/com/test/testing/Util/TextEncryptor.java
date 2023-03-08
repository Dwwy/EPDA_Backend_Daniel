package com.test.testing.Util;

import com.test.testing.Util.Encryption.KeyFactory;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;


/**
 *
 * @author Martin
 *
 */
public class TextEncryptor {

	/*
	 * Attributes
	 */

	private Encryptor encryptor;

	/*
	 * Constructor(s)
	 */

	/**
	 * <p>Constructs a default AES <code>TextEncryptor</code> instance using a randomly generated key. Obtain the key by calling {@link #getEncryptor()} and {@link Encryption#getKey()}.</p>
	 */
	public TextEncryptor() {
		this(KeyFactory.AES.randomKey());
	}

	/**
	 * <p>Constructs a default AES <code>TextEncryptor</code> instance using the given password.</p>
	 * @param password the password used for encryption
	 */
	public TextEncryptor(String password) {
		this(KeyFactory.AES.keyFromPassword(password.toCharArray()));
	}

	/**
	 * <p>Constructs a default AES <code>TextEncryptor</code> instance using the given AES key.</p>
	 * @param key the key used for encryption
	 */
	public TextEncryptor(Key key) {
		this(EncryptorFactory.AES.messageEncryptor(key));
	}

	/**
	 * <p>Constructs a <code>TextEncryptor</code> instance using the given <code>Encryptor</code>.</p>
	 * @param encryptor the encryptor used for encryption
	 */
	public TextEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	/*
	 * Class methods
	 */

	/**
	 * <p>Encrypts and Base64 encodes a message.</p>
	 * @param message the message
	 * @return the encrypted message
	 * @throws GeneralSecurityException
	 */
	public String encrypt(String message) {
		byte[] bytes = new byte[0];
		try {
			bytes = encryptor.encrypt(message.getBytes());
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
		return Base64.getUrlEncoder().encodeToString(bytes);
	}

	/**
	 * <p>Base64 decodes and decrypts an encrypted message.</p>
	 * @param message an encrypted message
	 * @return the decrypted message
	 * @throws GeneralSecurityException
	 */
	public String decrypt(String message)  {
		byte[] bytes = Base64.getUrlDecoder().decode(message);
		try {
			return new String(encryptor.decrypt(bytes));
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * <p>Returns the encryptor.</p>
	 * @return
	 */
	public Encryptor getEncryptor() {
		return encryptor;
	}

	/*
	 * Static methods
	 */

	/**
	 *
	 * @param args
	 */

}
