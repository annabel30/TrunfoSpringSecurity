package br.senai.sc.supertrunfospringnovo.security.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Profile implements GrantedAuthority {

    ADMIN, PLAYER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}