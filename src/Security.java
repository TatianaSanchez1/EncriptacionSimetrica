
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import Decoder.BASE64Encoder;


public class Security {
    private SecretKey key;
    private Cipher cipher;
    private final String algoritmo = "AES";
    private final int keySize = 16;

    /**
     *  Se crea la llave para encriptar o desencriptar
     * @param value
     */
    public void addKey(String value){
        byte[] valueBytes = value.getBytes();
        key = new SecretKeySpec(Arrays.copyOf(valueBytes, keySize), algoritmo);
    }

    /**
     * Método para encriptar un texto
     * @param text texto desencriptado
     * @return String texto encriptado
     */
    public String encriptar(String text){
        String value = "";

        try {
            cipher = Cipher.getInstance(algoritmo);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] textBytes = text.getBytes();
            byte[] cipherBytes = cipher.doFinal(textBytes);
            value = new BASE64Encoder().encode(cipherBytes);
        } catch (NoSuchPaddingException e) {
            System.err.println(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
        } catch (InvalidKeyException e) {
            System.err.println(e.getMessage());
        } catch (IllegalBlockSizeException e) {
            System.err.println(e.getMessage());
        } catch (BadPaddingException e) {
            System.err.println(e.getMessage());
        }

        return value;
    }
}
