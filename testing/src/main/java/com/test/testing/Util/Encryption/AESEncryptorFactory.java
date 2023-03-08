package com.test.testing.Util.Encryption;

import com.test.testing.Util.Encryptor;
import com.test.testing.Util.EncryptorFactory;

import java.security.Key;


/**
 * <p>Factory class for constructing AES <code>Encryptor</code> instances.</p>
 * @author Martin
 *
 */
public class AESEncryptorFactory implements EncryptorFactory {

	@Override
	public final Encryptor messageEncryptor(Key key) {
		return new Encryptor(key, "AES/CBC/PKCS5Padding", 16);
	}

	@Override
	public final Encryptor streamEncryptor(Key key) {
		return new Encryptor(key, "AES/CTR/NoPadding", 16);
	}
}
