    import java.util.List;
    import java.util.Map;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            // Criação do grafo de livros
            GrafoLivros grafo = new GrafoLivros();
            
            // Adicionando livros ao grafo
            Livro livro11 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", 1954, 1568);
            Livro livro12 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", 2017, 208);
            Livro livro13 = new Livro("O Hobbit", "J.R.R. Tolkien", "Fantasia", 2013, 328);
            Livro livro114 = new Livro("A Guerra dos Tronos", "George R.R. Martin", "Fantasia", 2010, 600);
            
            grafo.adicionarLivro(livro11);
            grafo.adicionarLivro(livro12);
            grafo.adicionarLivro(livro13);
            grafo.adicionarLivro(livro114);
            
            // Adicionando recomendações
            grafo.adicionarRecomendacao(livro11, livro12);
            grafo.adicionarRecomendacao(livro11, livro13);
            grafo.adicionarRecomendacao(livro12, livro114);
            
            SistemaRecomendacao sistema = new SistemaRecomendacao(grafo);
            System.out.println("Recomendações para " + livro11 + ":");
            for (Livro livro1 : sistema.recomendarBaseadoEm(livro11)) {
                System.out.println(livro1);
            }


            // Criação da Árvore
            ArvoreDeLivros biblioteca = new ArvoreDeLivros();

            biblioteca.inserir(new Livro("Dom Casmurro", "Machado de Assis", "Romance", 1899, 256));
            biblioteca.inserir(new Livro("A Hora Da Estrela", "Clarice Lispector", "Ficção", 1977, 87));
            biblioteca.inserir(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Fábula", 1949, 96));
            biblioteca.inserir(new Livro("Capitães da Areia", "Jorge Amado", "Romance", 1937, 256));
            biblioteca.inserir(new Livro("O Alienista", "Machado de Assis", "Novela", 1882, 85));

            Scanner scanner = new Scanner(System.in);

            System.out.println("Livros ordenados por título:");
            biblioteca.exibirOrdem();

            System.out.println("Digite o título do livro que deseja buscar: ");
            String tituloBusca = scanner.nextLine();

            Livro resultado = biblioteca.buscaPorTitulo(tituloBusca);
            if (resultado != null)  {
                System.out.println("\n Livro Encontrado \n" + resultado);
            } else {
                System.out.println("\n Livro Não Encontrado.");
            }
            
            System.out.println("\nCaminhos mais curtos a partir de: " + livro11.getTitulo());
            Map<Livro, List<Livro>> caminhos = grafo.djikstraComCaminho(livro11);

            for (Map.Entry<Livro, List<Livro>> entrada : caminhos.entrySet()) {
                Livro destino = entrada.getKey();
                List<Livro> caminho = entrada.getValue();
                
                System.out.print("Caminho até '" + destino.getTitulo() + "': ");
                for (int i = 0; i < caminho.size(); i++) {
                    System.out.print(caminho.get(i).getTitulo());
                    if (i < caminho.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }


            scanner.close();
        }    
    }
