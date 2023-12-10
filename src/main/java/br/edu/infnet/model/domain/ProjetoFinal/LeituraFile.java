package br.edu.infnet.model.domain.ProjetoFinal;

import br.edu.infnet.model.domain.ProjetoFinal.model.*;
import br.edu.infnet.model.domain.ProjetoFinal.service.SolicitanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class LeituraFile implements ApplicationRunner {

    Logger logger = LoggerFactory.getLogger("LeituraFile.class");
    @Autowired
    SolicitanteService solicitanteService;
    boolean teste = true;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        File file = new File("\\C:\\Estudo\\Java\\ProjetoFinal\\src\\main\\java\\br\\edu\\infnet\\model\\domain\\ProjetoFinal\\Files\\leitura.csv");

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String line = br.readLine();

                line = br.readLine();

                while (line != null) {

                    String[] linha = line.split(",");
                    String nome = linha[0];
                    String cpf = linha[1];
                    ;
                    String email = linha[2];
                    ;
                    String pedidoText = linha[3];
                    Solicitante s = new Solicitante(nome, cpf, email);
                    String[] linhaPedido = pedidoText.split("Pedido");



                    linhaPedido = pedidoText.split("-");
                    String pedidoDescricao = linhaPedido[1];
                    String nomeProd = linhaPedido[3];

                    boolean pedidoWeb = Boolean.parseBoolean(linhaPedido[2]);

                    float prodValor = Float.parseFloat(linhaPedido[4]);
                    int prodCodigo = Integer.parseInt(linhaPedido[5]);
                    String prodTipo = linhaPedido[6];;
                    ArrayList<Produto> prod = new ArrayList<>();
                    Produto produto ;


                    ArrayList pedidos = new ArrayList<>();
                    Pedido pedido = new Pedido();
                    pedido.setDescricao(pedidoDescricao);

                    if (prodTipo.toLowerCase().equals("comida")) {
                        boolean foodVegano = Boolean.parseBoolean(linhaPedido[7]);
                        float foodPeso = Float.parseFloat(linhaPedido[8]);
                        String[] foodIngredientes = linhaPedido[9].split(",");
                        produto = new Comida(nomeProd, prodValor, prodCodigo, prodTipo, foodPeso, foodVegano, foodIngredientes);
                        produto.setTipo(prodTipo);
                        prod.add(produto);
                        pedido.setProdutos(prod);
                    }

                    if (prodTipo.toLowerCase().equals("bebida")) {
                        boolean drinkGelada = Boolean.parseBoolean(linhaPedido[7]);
                        float drinkTamanha = Float.parseFloat(linhaPedido[8]);
                        String drinkMarca = linhaPedido[9];
                        produto = new Bebida(nomeProd, prodValor, prodCodigo, prodTipo, drinkGelada, drinkTamanha, drinkMarca);
                        produto.setTipo(prodTipo);
                        prod.add(produto);
                        pedido.setProdutos(prod);
                    }

                    if (prodTipo.toLowerCase().equals("sobremesa")) {
                        boolean dessertDoce = Boolean.parseBoolean(linhaPedido[7]);
                        float dessertQuantidade = Float.parseFloat(linhaPedido[8]);
                        String dessertInformacao = linhaPedido[9];

                        produto = new Sobremesa(nomeProd, prodValor, prodCodigo, prodTipo, dessertQuantidade, dessertDoce, dessertInformacao);
                        produto.setTipo(prodTipo);
                        prod.add(produto);
                        pedido.setProdutos(prod);
                    }
                    pedidos.add(pedido);
                    s.setPedidos(pedidos);
                    solicitanteService.create(s);
                    line = br.readLine();
                }

            } catch (IOException e) {
                e.getStackTrace();
            }


        } else {
            try {
                if (file.createNewFile()) {
                    logger.info("O arquivo foi criado com sucesso.");
                } else {
                    logger.info("Algum erro impossibilitou a criação do arquivo.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



