/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetomagic.magiccardcreator;

import javafx.scene.text.Text;

/**
 *
 * @author amand
 */
public class DadosCarta {//objeto para receber o valor digitado pelo usuário dos campos do modal da carta, todos os campos são condizentes com o que eles iram receber do modal 

    String nome;
    String autor;
    String descricaoImagem;
    String descricao;
    String manaBranca;
    String manaIncolor;
    String manaVerde;
    String manaVermelha;
    String manaAzul;
    String danoAtaque;
    //Constructor, getters e setters
    public DadosCarta(String nome, String autor, String descricaoImagem, String descricao, String manaBranca, String manaIncolor, String manaVerde, String manaVermelha, String manaAzul, String danoAtaque) {
        this.nome = nome;
        this.autor = autor;
        this.descricaoImagem = descricaoImagem;
        this.descricao = descricao;
        this.manaBranca = manaBranca;
        this.manaIncolor = manaIncolor;
        this.manaVerde = manaVerde;
        this.manaVermelha = manaVermelha;
        this.manaAzul = manaAzul;
        this.danoAtaque = danoAtaque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricaoImagem() {
        return descricaoImagem;
    }

    public void setDescricaoImagem(String descricaoImagem) {
        this.descricaoImagem = descricaoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getManaBranca() {
        return manaBranca;
    }

    public void setManaBranca(String manaBranca) {
        this.manaBranca = manaBranca;
    }

    public String getManaIncolor() {
        return manaIncolor;
    }

    public void setManaIncolor(String manaIncolor) {
        this.manaIncolor = manaIncolor;
    }

    public String getManaVerde() {
        return manaVerde;
    }

    public void setManaVerde(String manaVerde) {
        this.manaVerde = manaVerde;
    }

    public String getManaVermelha() {
        return manaVermelha;
    }

    public void setManaVermelha(String manaVermelha) {
        this.manaVermelha = manaVermelha;
    }

    public String getManaAzul() {
        return manaAzul;
    }

    public void setManaAzul(String manaAzul) {
        this.manaAzul = manaAzul;
    }

    public String getDanoAtaque() {
        return danoAtaque;
    }

    public void setDanoAtaque(String danoAtaque) {
        this.danoAtaque = danoAtaque;
    }

    

}
