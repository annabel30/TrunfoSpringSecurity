package br.senai.sc.supertrunfospringnovo.business.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Region {

    Mondstadt("Mondstadt"),
    Liyue("Liyue"),
    Inazuma("Inazuma"),
    Sumeru("Sumeru"),
    Fontaine("Fontaine");

    String nome;
}