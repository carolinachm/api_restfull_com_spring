package br.com.springboot.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

    /**
     * Gerar um hast utilizando o BCrypt
     * @param senha
     * @return
     */
    public static String gerarBCrypt(String senha){
        if(senha == null){
            return senha;
        }
        BCryptPasswordEncoder byCryptEndocer = new BCryptPasswordEncoder();
        return byCryptEndocer.encode(senha);
    }
    /**
     * Verificar se a senha é valida
     * @param senha
     * @param senhaEncoded
     * @return boolean
     */
    public static boolean senhaValida(String senha, String senhaEncoded){
        BCryptPasswordEncoder byCryptEndocer = new BCryptPasswordEncoder();
        return byCryptEndocer.matches(senha,senhaEncoded);
    }

}