package model;

/**
 *
 * @author gabrieldutra, MarceloFCandido, rubiotorres
 */
public class Item {

    private int chave;

    /**
     * Construtor do item
     *
     * @param chave chave inteira do item
     */
    public Item(int chave) {
        this.chave = chave;
    }

    /**
     * Compara um item com outro
     *
     * @param it Item a ser comparado
     * @return -1 para menor, 1 para maior e 0 para igual
     */
    public int compara(Item it) {
        Item item = it;
        if (this.chave < item.chave) {
            return -1;
        } else if (this.chave > item.chave) {
            return 1;
        }
        return 0;
    }

    /**
     * Getter da chave do item
     *
     * @return chave do item
     */
    public int getChave() {
        return chave;
    }
}
