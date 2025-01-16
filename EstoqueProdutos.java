public class EstoqueProdutos {

   private ProdutoEstoque[] produtos;
   private int qtdProdutos;

   // Construtor que inicia a array de 'produtos' com tamanho de 100 itens e define a quantidade inicial como zero.
   public EstoqueProdutos(){
      produtos = new ProdutoEstoque[1000];
      qtdProdutos = 0;
   }

   // Método para adicionar um produto ao estoque
   public void adicionaProduto(ProdutoEstoque produto){

      // Verifica se o espaço disponível no estoque
      if(qtdProdutos < produtos.length){
         // Adiciona o produto ao array 'produtos' e incrementa a quantidade de produtos ao final
         produtos[qtdProdutos] = produto;
         qtdProdutos++;
      }else {
         // Mensagem caso o estoque esteja cheio
         System.out.println("Estoque cheio. Adicione mais espaço no estoque!");
      }
   }

   // Método para obter um produto do estoque pelo id
   public ProdutoEstoque getProduto(int id){
      // Verifica se o id é válido e retorna o produto do id especificado
      if(id >= 0 && id < qtdProdutos){
         return produtos[id];
      }
      // Se for inválido o id retorna null
      return null;
   }

   // Método para obter a quantidade de produtos no estoque
   public int getQtdProdutos(){
      // Retorna a quantidade atual de produtos já adicionados
      return qtdProdutos;
   }

}