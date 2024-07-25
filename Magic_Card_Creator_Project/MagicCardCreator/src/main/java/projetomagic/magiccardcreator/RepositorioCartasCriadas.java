/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetomagic.magiccardcreator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amand
 */
public class RepositorioCartasCriadas {

 //Classe responsável em salvar o objeto da classe criada em um ArrayList

    List<DadosCarta> listaCartas = new ArrayList<>();
    int quantidadeCartasNoRepositorio = 0;
    

    public void inserirCartaRepositorio(DadosCarta carta) {

        listaCartas.add(carta);
        quantidadeCartasNoRepositorio++;
    }

    public void mostrarObjCartaCriada() {
        
        
            System.out.println("Objeto da carta gerada:" + listaCartas);
        
        }
    }


