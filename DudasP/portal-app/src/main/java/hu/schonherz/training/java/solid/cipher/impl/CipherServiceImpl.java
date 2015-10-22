package hu.schonherz.training.java.solid.cipher.impl;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.Validate;

import hu.schonherz.training.java.solid.cipher.CipherService;
import hu.schonherz.training.java.solid.cipher.EncryptionException;

public class CipherServiceImpl implements CipherService {
  private SecretKeySpec secretKey;
  private IvParameterSpec iv;

  public CipherServiceImpl(String key, String iv) {
    Validate.notBlank(key);
    Validate.notBlank(iv);
    Validate.isTrue(Base64.isBase64(key), "Key must be in Base64 format");
    Validate.isTrue(Base64.isBase64(iv), "Initialization string must be Base64 format");

    byte[] encodedKey = Base64.decodeBase64(key);
    this.secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");

    byte[] encodedIv = Base64.decodeBase64(iv);
    this.iv = new IvParameterSpec(encodedIv);
  }

  @Override
  public String encrypt(String unencrypted) throws EncryptionException {
    Validate.notNull(unencrypted);
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, this.secretKey, this.iv);

      byte[] bytes = unencrypted.getBytes();

      byte[] raw = cipher.doFinal(bytes);

      return Base64.encodeBase64String(raw);
    } catch (Exception e) {
      throw new EncryptionException("Could not encrypt data", e);
    }
  }
}
