/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ieseljust.CEPA5.model;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Data
@Entity
public class Especie {
    @Id
    @GeneratedValue
    Long idEspecie;
    
    @Column
    Integer puntsVida;
    
    @Column
    String tipus;
    
    @OneToMany(
            mappedBy="especie",
            fetch=FetchType.LAZY)
    @ToString.Exclude
    List <Personatge> personatges=new ArrayList<Personatge>();
    
    public Especie() {
    }

    public Especie(Long idEspecie, Integer puntsDeVida, String tipus) {
        this.idEspecie = idEspecie;
        this.puntsVida = puntsDeVida;
        this.tipus = tipus;
    }
    
}
