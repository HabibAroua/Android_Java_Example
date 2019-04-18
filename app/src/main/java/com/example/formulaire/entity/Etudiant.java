package com.example.formulaire.entity;

public class Etudiant
{
    private int numero;
    private String nom;

    public Etudiant()
    {

    }

    public Etudiant(int numero , String nom)
    {
        this.numero=numero;
        this.nom=nom;
    }

    public int getNumero()
    {
        return  this.numero;
    }

    public String getNom()
    {
        return this.nom;
    }

    public void setNumero(int numero)
    {
        this.numero=numero;
    }

    public void setNom(String nom)
    {
        this.nom=nom;
    }

    @Override
    public String toString()
    {
        return "Numéro : "+this.numero+" Nom : "+this.nom;
    }
}
