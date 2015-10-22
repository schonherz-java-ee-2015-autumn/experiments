package hu.schonherz.training.java.solid.cipher;

public interface CipherService {
  String encrypt(String unencrypted) throws EncryptionException;
}
