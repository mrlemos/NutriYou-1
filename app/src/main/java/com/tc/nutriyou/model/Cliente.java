package com.tc.nutriyou.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;

public class Cliente {

    private String id, nome, email, senha, sexo;
    private Date dtNascimento;
    private int peso, altura;

    public void setDadosCadastro(String nome, String email, String senha)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String[] getDadosCadastro()
    {
        String[] data = {nome, email, senha};
        return(data);
    }

    public Cliente()
    {

    }
}
