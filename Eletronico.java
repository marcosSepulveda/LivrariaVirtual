
package livrariavirtual;

/**
 *
 * @author Marcos
 */
public class Eletronico extends Livro{

     private int tamanho;
     
    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
   
    public String toString() {
        
        return super.toString() +
               ", Tamanho: " + this.getTamanho();
    }
}
