
package livrariavirtual;

/**
 *
 * @author Marcos
 */
public class Impresso extends Livro {
    
    private float frete;
    private int estoque ;
    
     //Contrutor livre
    public Impresso() {

    }
    
    /**
     * @return the frete
     */
    public float getFrete() {
        return frete;
    }

    /**
     * @param frete the frete to set
     */
    public void setFrete(float frete) {
        this.frete = frete;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public String toString() {
        
        return super.toString() +
               ", Frete: " + this.getFrete() + ", Estoque: " + this.getEstoque();
    }
}
