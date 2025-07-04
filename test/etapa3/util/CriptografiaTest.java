/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package etapa3.util;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author HEARTHLONELY
 */
public class CriptografiaTest {

    @Test
    public void testCriptografarSenha() {
        String senha = "123456";
        String hashEsperado = "e10adc3949ba59abbe56e057f20f883e"; // MD5 de "123456"

        String hashGerado = Criptografia.criptografarSenha(senha);

        assertNotNull("O hash não deve ser nulo", hashGerado);
        assertEquals("O hash gerado deve ser igual ao hash esperado", hashEsperado, hashGerado);
    }

    @Test
    public void testCriptografarSenhaMesmoValor() {
        String senha = "senhaTeste";

        String hash1 = Criptografia.criptografarSenha(senha);
        String hash2 = Criptografia.criptografarSenha(senha);

        assertEquals("Hashes de chamadas iguais devem ser iguais", hash1, hash2);
    }
}
