package br.senai.sc.supertrunfospringnovo.business.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlayer;
    private String name;
    private Integer age;
    private char gender;
    private String region;
    private String element;
    private String weapon;
    private String password;
    private Integer victories = 0;
    private Integer defeats = 0;

    public void setVictories() {
        this.victories++;
    }
    public void setDefeats() {
        this.defeats++;
    }
}
