package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.*;

/**
 * Classe Principal
 *
 * @author gabrieldutra
 */
public class Principal {

    private static List<Item> criaListaOrdenada(int inicio, int quantidade) {
        ArrayList<Item> lista = new ArrayList<>();
        for (int i = inicio; i < inicio + quantidade; i++) {
            lista.add(new Item(i));
        }
        return lista;
    }

    private static void insereElementosOrdenados(List<Item> lista, ArvoreSBB arvore) {
        for (Item i : lista) {
            arvore.insere(i);
        }
    }

    private static void insereElementosAleatorios(List<Item> lista, ArvoreSBB arvore) {
        Random random = new Random();
        while (!lista.isEmpty()) {
            int indiceAleatorio = random.nextInt(lista.size());
            Item itemAleatorio = lista.get(indiceAleatorio);
            arvore.insere(itemAleatorio);
            lista.remove(itemAleatorio);
        }
    }

    private static void calculaItensOrdenados() {

        ArvoreSBB arvoreSBB;
        List<Item> itens;

        System.out.println("Itens ordenados:");

        // n varia de 10.000 a 100.000, de 10.000 em 10.000
        for (int n = 10000; n <= 100000; n += 10000) {
            arvoreSBB = new ArvoreSBB();
            itens = criaListaOrdenada(0, n);
            insereElementosOrdenados(itens, arvoreSBB);

            // avalia tempo de pesquisa            
            long inicio = System.nanoTime();
            Item itemPesquisado = arvoreSBB.pesquisa(new Item(n));
            long termino = System.nanoTime();

            System.out.println("Tempo - " + n + " itens: " + (termino - inicio));
        }
    }

    private static void calculaItensAleatorios() {

        ArvoreSBB arvoreSBB;
        List<Item> itens;

        System.out.println("Itens aleatórios:");

        // n varia de 10.000 a 100.000, de 10.000 em 10.000
        for (int n = 10000; n <= 100000; n += 10000) {
            arvoreSBB = new ArvoreSBB();
            itens = criaListaOrdenada(0, n);
            insereElementosAleatorios(itens, arvoreSBB);

            // avalia tempo de pesquisa            
            long inicio = System.nanoTime();
            Item itemPesquisado = arvoreSBB.pesquisa(new Item(n));
            long termino = System.nanoTime();

            System.out.println("Tempo - " + n + " itens: " + (termino - inicio));
        }
    }

    /**
     * Método Principal
     *
     * @param args
     */
    public static void main(String[] args) {

        // Itens ordenados
        calculaItensOrdenados();

        // Itens aleatórios
        calculaItensAleatorios();

    }

}
