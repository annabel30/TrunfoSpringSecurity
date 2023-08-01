package br.senai.sc.supertrunfospringnovo.business.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Weapon {

    Bow("Bow"),
    Catalyst("Catalyst"),
    Claymore("Claymore"),
    Polearm("Polearm"),
    Sword("Sword");

    String name;
}
