public class CarrinhoCompra{

    private ProdutoEstoque[] carrinho;
    private int qtdItens;
    private EstoqueProdutos estoque;

   // Construtor que recebe um objeto EstoqueProdutos como parâmetro
   public CarrinhoCompra(EstoqueProdutos estoque){

      // Inicializa o array 'carrinho' com espaço para 100 itens
      carrinho = new ProdutoEstoque[100];

      // Inicializa a quantidade de itens no carrinho como zero
      qtdItens = 0;

      // Atribui o objeto EstoqueProdutos recebido como parâmetro à variável de instância 'estoque'
      this.estoque = estoque;
   }

   // Método para adicionar itens ao carrinho com base no nome do produto e na quantidade desejada
   public void adicionaItem(String nomeProduto, int quantidade){

      // Chama o método privado encontraProdutoNoEstoque para obter o objeto ProdutoEstoque do estoque
      ProdutoEstoque produto = encontraProdutoNoEstoque(nomeProduto);

      // Verifica se o produto foi encontrado no estoque
      if(produto != null){

         // Verifica se a quantidade desejada está disponível no estoque
         if(quantidade <= produto.getQuantidade()){

            // Adiciona a quantidade desejada do produto ao carrinho
            for(int i = 0; i < quantidade; i++){
               carrinho[qtdItens] = produto;
               qtdItens++;
            }

            // Exibe uma mensagem indicando que os produtos foram adicionados ao carrinho
            System.out.println(quantidade + " " + nomeProduto + "(s) adicionado(s) ao carrinho.");
         }else{
            // Exibe uma mensagem se a quantidade desejada não estiver disponível no estoque
            System.out.println("Quantidade insuficiente de " + nomeProduto + " no estoque.");
         }
      }else{
         // Exibe uma mensagem se o produto não foi encontrado no estoque
         System.out.println(nomeProduto + " não encontrado no estoque.");
      }
   }

   // Método privado para encontrar um produto no estoque com base no nome
   private ProdutoEstoque encontraProdutoNoEstoque(String nomeProduto){

      // Percorre o estoque procurando um produto com o nome especificado
      for(int i = 0; i < estoque.getQtdProdutos(); i++){
         if(estoque.getProduto(i).getNome().equalsIgnoreCase(nomeProduto)){
            // Retorna o produto encontrado
            return estoque.getProduto(i);
         }
      }
      // Retorna null se o produto não for encontrado no estoque
      return null;
   }

   // Método para finalizar a compra, reduzindo a quantidade de cada item no estoque
   public void finalizaCompra(){

      // Percorre o carrinho e decrementa a quantidade de cada item no estoque
      for(int i = 0; i < qtdItens; i++){
         ProdutoEstoque item = carrinho[i];
         item.setQuantidade(item.getQuantidade() - 1);
      }

      // Reinicializa o carrinho e a quantidade de itens após a compra ser finalizada
      carrinho = new ProdutoEstoque[100];
      qtdItens = 0;
   }

   // Método para calcular o valor total dos itens no carrinho
   public Double calculaTotal(){

      // Inicializa a variável total como zero
      Double total = 0.0;
      ProdutoEstoque item;

      // Percorre o carrinho e soma o valor de cada item ao total
      for(int i = 0; i < qtdItens; i++){
         item = carrinho[i];
         total += item.getValor();
      }
      
      // Retorna o valor total
      return total;
   }
}