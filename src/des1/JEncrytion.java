/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des1;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.lang.String;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class JEncrytion {

    public static void main(String[] argv) throws UnsupportedEncodingException {

        try {

            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            String clave = new String(myDesKey.getEncoded(), "ISO-8859-1");
            System.out.println("clave: "+ clave);

            Cipher desCipher;

            // Create the cipher
            desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

            //sensitive information
            byte[] text = "Kim Dotcom fundador del portal de descargas Megaupload comenzo un nuevo intento de apelación ante los tribunales de Nueva Zelanda para evitar su extradicion a los Estados Unidos El titan alemán de internet que es requerido por cargos de pirateria informatica y otros delitos ha protagonizado una batalla de mas de seis anos desde que en enero de 2012 la policia armada entro a su mansion de Auckland mientras el se atrinchero en un cuarto blindado en una operacion espectacular que respondio a una peticion del FBI en Estados Unidos".getBytes();

            System.out.println("Text [Byte Format] : " + text);
            System.out.println("Text : " + new String(text, "ISO-8859-1"));

            // Encrypt the text
            byte[] textEncrypted = desCipher.doFinal(text);
            String cifrado = new String(textEncrypted, "ISO-8859-1");
            System.out.println("Text Encryted : " + cifrado);

            // Initialize the same cipher for decryption
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

            // Decrypt the text
            byte[] textDecrypted = desCipher.doFinal(textEncrypted);

            System.out.println("Text Decryted : " + new String(textDecrypted));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

    }
}
