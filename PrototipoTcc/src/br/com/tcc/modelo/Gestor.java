package br.com.tcc.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("G")
public class Gestor extends Usuario{

}
