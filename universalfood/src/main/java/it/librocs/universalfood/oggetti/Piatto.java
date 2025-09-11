package it.librocs.universalfood.oggetti;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonInclude(Include.NON_NULL)
public class Piatto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nome;
    String descrizione;
    Double costo;
    Boolean disponibile;

    @ManyToOne
    @JsonBackReference
    Menu menu;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public Double getCosto() {
        return costo;
    }
    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public Boolean getDisponibile() {
        return disponibile;
    }
    public void setDisponibile(Boolean disponibile) {
        this.disponibile = disponibile;
    }
    public Menu getMenu() {
        return menu;
    }
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
