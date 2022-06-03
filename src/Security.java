
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import Decoder.BASE64Decoder;
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

    /**
     * Metodo para desencriptar un texto
     * @param texto Texto encriptado
     * @return String texto desencriptado
     */
    public String desencriptar(String texto){
        String str="";
        try {
            byte[] value = new BASE64Decoder().decodeBuffer(texto);
            cipher = Cipher.getInstance(algoritmo);
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] cipherbytes= cipher.doFinal(value);
            str = new String(cipherbytes);
        } catch (IOException e) {
            System.err.println(e.getMessage());
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
        return str;
    }
}
