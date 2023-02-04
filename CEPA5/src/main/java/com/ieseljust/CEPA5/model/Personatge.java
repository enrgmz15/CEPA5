/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ieseljust.CEPA5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.ToString;

@Entity
@Table
public class Personatge {
    @Id
    @GeneratedValue
    private Long idPersonatge;
    
    @Column
    private String descripcio;
    
    @ManyToOne
    @JoinColumn(
            name="especie",
            foreignKey = @ForeignKey(name = "FK_ESP" ))
    @ToString.Exclude
    private Especie especie;

    public Long getIdPersonatge() {
        return idPersonatge;
    }

    public void setIdPersonatge(Long idPersonatge) {
        this.idPersonatge = idPersonatge;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    
    


    public Personatge() {
    }

    public Personatge(Long idPersonatge, String descripcio, Especie especie) {
        this.idPersonatge = idPersonatge;
        this.descripcio = descripcio;
        this.especie = especie;
    }
    
    

}
