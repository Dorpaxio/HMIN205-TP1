package io.dorpax.cours.hmin205.tp1;

import java.io.Serializable;

public class Infos implements Serializable {
    private final String prenom, nom, domaine, age, phone;

    public Infos(String prenom, String nom, String domaine, String age, String phone) {
        this.prenom = prenom;
        this.nom = nom;
        this.domaine = domaine;
        this.age = age;
        this.phone = phone;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Prénom = " + this.prenom + "\n" +
                "Nom = " + nom + "\n" +
                "Age = " + age + "\n" +
                "Domaine = " + domaine + "\n" +
                "Téléphone = " + phone;
    }
}
