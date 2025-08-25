    import java.util.*;

    public class GrafoLivros {
        
        private Map<Livro, Set<Livro>> grafo;

        public GrafoLivros() {
            grafo = new HashMap<>();
        }

        public void adicionarLivro(Livro livro) {
            grafo.putIfAbsent(livro, new HashSet<>());
        }

        public void adicionarRecomendacao(Livro livroOrigem, Livro livroRecomendacao) {
            grafo.putIfAbsent(livroOrigem, new HashSet<>());
            grafo.putIfAbsent(livroRecomendacao, new HashSet<>());
            grafo.get(livroOrigem).add(livroRecomendacao);
        }

        public Set<Livro> getRecomendacoes(Livro livro) {
            return grafo.getOrDefault(livro, Collections.emptySet());
        }

        public Set<Livro> getTodosLivros()  {
            return grafo.keySet();
        }

        public Map<Livro, List<Livro>> djikstraComCaminho(Livro origem) {
            Map<Livro, Integer> distancias = new HashMap<>();
            Map<Livro, Livro> predecessores = new HashMap<>();
            Queue<Livro> fila = new LinkedList<>();
        
            distancias.put(origem, 0);
            fila.add(origem);
        
            while (!fila.isEmpty()) {
                Livro atual = fila.poll();
                int distanciaAtual = distancias.get(atual);
        
                for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {
                    if (!distancias.containsKey(vizinho)) {
                        distancias.put(vizinho, distanciaAtual + 1);
                        predecessores.put(vizinho, atual);
                        fila.add(vizinho);
                    }
                }
            }
        
            // Reconstruir caminhos
            Map<Livro, List<Livro>> caminhos = new HashMap<>();
            for (Livro destino : distancias.keySet()) {
                List<Livro> caminho = new LinkedList<>();
                for (Livro at = destino; at != null; at = predecessores.get(at)) {
                    caminho.add(0, at);
                }
                caminhos.put(destino, caminho);
            }
        
            return caminhos;
        }
    }
