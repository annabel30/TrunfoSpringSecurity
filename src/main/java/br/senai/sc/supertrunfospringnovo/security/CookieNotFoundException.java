package br.senai.sc.supertrunfospringnovo.security;

public class CookieNotFoundException extends RuntimeException {

    public CookieNotFoundException(String nome) {
        super("O cookie com nome " + nome + " não foi encontrado!");
    }
}