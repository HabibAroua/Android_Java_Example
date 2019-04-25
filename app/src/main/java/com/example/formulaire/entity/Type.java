package com.example.formulaire.entity;

public class Type
{
    private int id;
    private String libelle;

    public Type()
    {

    }

    public Type(String libelle)
    {
        this.libelle=libelle;
    }

    public int getId()
    {
        return this.id;
    }

    public String getLibelle()
    {
        return this.libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle=libelle;
    }

    @Override
    public String toString()
    {
        return "id : "+this.id+" libellé : "+this.libelle;
    }
}
