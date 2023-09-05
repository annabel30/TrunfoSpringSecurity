package br.senai.sc.supertrunfospringnovo.business.model.DTO;

import br.senai.sc.supertrunfospringnovo.business.model.enums.Region;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Element;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    private String name;
    private int atk;
    private int criticalRate;
    private int criticalDamage;
    private int elementalMastery;
    private int energyRecharge;
    private Element element;
    private Region region;
    private String image;
}