
package livrariavirtual;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.Console;

/**
 *
 * @author Marcos
 */
public class LivrariaVirtual {
    
    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 10;
    private static final int MAX_VENDAS = 10;
    
    public static Impresso[] impressos = new Impresso [MAX_IMPRESSOS];
    public static Eletronico[] eletronicos = new Eletronico [MAX_ELETRONICOS];
    public static Venda[] vendas = new Venda [MAX_VENDAS];
    
    static private int numImpressos = 0;
    static private int numEletronicos = 0;
    static private int numVendas = 0;
    
    public static void main(String[] args) {
        menu();
        System.out.println("Programa encerrado.");
    }
    
    private static void menu() { // menu principal
        int opcao = 0;
        
        do {
                System.out.println("\n\n### Livraria Virtual ###");
                System.out.println("\n                  ==============================");
                System.out.println("                  |     1 - Cadastrar Livro      |");
                System.out.println("                  |     2 - Realizar Venda       |");
                System.out.println("                  |     3 - Listar Impressos     |");
                System.out.println("                  |     4 - Listar Eletronicos   |");
                System.out.println("                  |     5 - Listar Livros        |");
                System.out.println("                  |     6 - Listar Vendas        |");
                System.out.println("                  |     7 - Sair                 |");
                System.out.println("                  ==============================\n");

                //opcao = Console.readInt("Opção -> ");
                //System.out.print("\n");

                Scanner scanner = new Scanner(System.in);
                opcao = scanner.nextInt();
                //System.out.print("\n");

                switch (opcao) {
                case 1:
                    CadastrarLivro();
                    break;
                case 2:
                    RealizarVenda();
                    break;
                case 3:
                    ListarLivrosImpressos(impressos);
                    break;
                case 4:
                    ListarLivrosEletronicos(eletronicos);
                    break;
                case 5:
                    //ListarLivros();
                    break;
                case 6:
                    ListarVendas();
                    break;
                case 7:
                    //Sair();
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida!");
                    break;
                }
        } while (opcao != 0);
    }
    
    private static int menuTipoLivro() {
        int opcao = 0;
        
        do {
                System.out.println("\n\n### Tipo do Livro ###");
                System.out.println("\n                  =========================");
                System.out.println("                  |     1 - Impresso         |");
                System.out.println("                  |     2 - Eletronico       |");
                System.out.println("                  |     3 - Ambos             |");
                System.out.println("                  |     4 - Sair       |");
                System.out.println("                  =========================\n");

                //opcao = Console.readInt("Opção -> ");
                //System.out.print("\n");

                Scanner scanner = new Scanner(System.in);
                opcao = scanner.nextInt();
                System.out.print("\n");

                switch (opcao) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    default:
                        return -1;
                }
        } while (opcao != 0);
    }
    
    private static void CadastrarLivro() {
        
        //OBTER A OPÇAO DO MENU
        int opcaoMenu = menuTipoLivro();
        if (opcaoMenu == 1){
            CadastrarLivroImpresso();
        }
        else if (opcaoMenu == 2){
            CadastrarLivroEletronico();
        }
        else if (opcaoMenu == 3){
            //CadastrarLivroImpresso();
            //CadastrarLivroEletronico();
        }
        else {
            System.out.print("Opção inválida \n");
        }
   }
    
    private static void RealizarVenda(){
        Scanner entrada = new Scanner(System.in);
        String nomCliente;
        int qtdLivros;
        int opcaoLivro;
        Venda venda = new Venda();
        
        System.out.println("Informe o nome do cliente: \n");
        venda.setCliente(entrada.nextLine());
        
        System.out.println("Informe a quantidade de livros: \n");
        qtdLivros = entrada.nextInt();
        
        //PARA CADA LIVRO DA VENDA
        for (int i = 0; i < qtdLivros; i++) {
            System.out.println("Escolha o tipo do Livro" + (i + 1) + ": \n");
            int opcaoMenu = menuTipoLivro();

            if (opcaoMenu == 1){
                ListarLivrosImpressos(impressos);
                System.out.println("Informe o número do Livro para a venda: \n");
                opcaoLivro = entrada.nextInt()-1;
                IncluirLivroVenda(venda, opcaoLivro, 1);
            }
            else if (opcaoMenu == 2){
                ListarLivrosEletronicos(eletronicos);
                System.out.println("Informe o número do Livro para a venda: \n");
                opcaoLivro = entrada.nextInt()-1;
                IncluirLivroVenda(venda, opcaoLivro,  2);
            }
            else if (opcaoMenu == 3){
                //CadastrarLivroImpresso();
                //CadastrarLivroEletronico();
            }
            else {
                System.out.print("Opção inválida \n");
            }
        }
        
        //INCLUIR A VENDA
        vendas[numVendas] = venda;
        numVendas = numVendas +1;
    }
    
    private static void ListarLivrosImpressos(Impresso [] tmpImpressos){        
        System.out.println("\n\n### Livros Impressos ###");
        for (int i = 0; i < numImpressos; i++) {
            System.out.print("Livro " + (i+1) + ": ");
            System.out.println(tmpImpressos[i].toString());
	}
    }
    
    private static void ListarLivrosEletronicos(Eletronico[] tmpEletronicos){  
        System.out.println("\n\n### Livros Eletrônicos ###");
        for (int i = 0; i < numEletronicos; i++) {
            System.out.print("Livro " + (i+1) + ": ");
            System.out.println(tmpEletronicos[i].toString());
	}
    }
    
    private static void ListarVendas(){  
        System.out.println("\n\n### Lista de Vendas ###");        
        System.out.println("### Qtde Vendas - " + numVendas + " \n");
        
        for (int i = 0; i < numVendas; i++) {
            System.out.print(" @Venda " + (i) + ": ");
            System.out.println(vendas[i].toString());
	}
    }
    
    private static void CadastrarLivroImpresso(){
        Scanner entrada = new Scanner(System.in);
        String titulo;
        String editora;
        String autores;
        float preco;
        float frete;
        int estoque;
        
        System.out.println("Informe o título do Livro: \n");
        titulo = entrada.nextLine();
        
        System.out.printf("Informe os autores do Livro: \n");
        autores = entrada.nextLine();
       
        System.out.printf("Informe a editora do Livro: \n");
        editora = entrada.nextLine();
        
        System.out.printf("Informe o preço do Livro: \n");
        preco = entrada.nextFloat();
        
        System.out.printf("Informe o frete do Livro: \n");
        frete = entrada.nextFloat();
        
        System.out.printf("Informe o estoque do Livro: \n");
        estoque = entrada.nextInt();
       
        Impresso impresso = new Impresso();
           
        impresso.setTitulo(titulo);
        impresso.setAutores(autores);
        impresso.setEditora(editora);
        impresso.setPreco(preco);
        impresso.setFrete(frete);
        impresso.setEstoque(estoque);
        
        impressos[numImpressos] = impresso;
        numImpressos = numImpressos + 1;
        
        System.out.printf("Livro impresso cadastrado com sucesso!");
    }
    
    private static void CadastrarLivroEletronico(){
        Scanner entrada = new Scanner(System.in);
        String titulo;
        String editora;
        String autores;
        float preco;
        int tamanho;
        
        System.out.println("Informe o título do Livro: \n");
        titulo = entrada.nextLine();
        
        System.out.printf("Informe os autores do Livro: \n");
        autores = entrada.nextLine();
       
        System.out.printf("Informe a editora do Livro: \n");
        editora = entrada.nextLine();
        
        System.out.printf("Informe o preço do Livro: \n");
        preco = entrada.nextFloat();
        
        System.out.printf("Informe o tamanho do Livro: \n");
        tamanho = entrada.nextInt();
       
        Eletronico eletronico = new Eletronico();
           
        eletronico.setTitulo(titulo);
        eletronico.setAutores(autores);
        eletronico.setEditora(editora);
        eletronico.setPreco(preco);
        eletronico.setTamanho(tamanho);
        
        eletronicos[numEletronicos] = eletronico;
        numEletronicos = numEletronicos + 1;
        
        System.out.printf("Livro eletônico cadastrado com sucesso!");
    }
    
    private static void IncluirLivroVenda(Venda tmpVenda, int opcaoLivro, int tipoLivro){
        if(tipoLivro == 1){
            tmpVenda.addLivro(impressos[opcaoLivro], (tmpVenda.qtdeLivros() -1));
        }
        else if (tipoLivro == 2){
            tmpVenda.addLivro(eletronicos[opcaoLivro], (tmpVenda.qtdeLivros() -1));
        }
        else{
            System.out.print("ERRO!");
        }
    }
}
