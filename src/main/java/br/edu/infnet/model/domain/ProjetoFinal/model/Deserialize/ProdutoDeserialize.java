package br.edu.infnet.model.domain.ProjetoFinal.model.Deserialize;

import br.edu.infnet.model.domain.ProjetoFinal.Exceptions.BebidaException;
import br.edu.infnet.model.domain.ProjetoFinal.Exceptions.ComidaException;
import br.edu.infnet.model.domain.ProjetoFinal.Exceptions.ProdutoValorInvalidoException;
import br.edu.infnet.model.domain.ProjetoFinal.model.Bebida;
import br.edu.infnet.model.domain.ProjetoFinal.model.Comida;
import br.edu.infnet.model.domain.ProjetoFinal.model.Produto;
import br.edu.infnet.model.domain.ProjetoFinal.model.Sobremesa;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import java.text.DecimalFormat;

public class ProdutoDeserialize extends StdDeserializer<Produto> {
    Produto produto;
    Logger logger = LoggerFactory.getLogger(ProdutoDeserialize.class);
    DecimalFormat df = new DecimalFormat("##,##");


    public ProdutoDeserialize() {
        this(null);
    }

    public ProdutoDeserialize(Class<?> vc) {
        super(vc);
    }


    @Override
    public Produto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);

        String nome = node.get("Nome").asText();

        String tipoProduto = node.get("Tipo").asText();
        float valor;


        int codigo = node.get("Codigo").asInt();
        String tipo = node.get("Tipo").asText();


        produto = verificaTipo(tipo, node, produto);
        try {
            String valorString = node.get("Valor").asText();
            if (valorString.contains(",")) {
                valorString = valorString.replace(",", ".");
            }

            valor = Float.parseFloat(valorString);
            valor = Float.parseFloat(df.format(valor));
            if (valor <= 0) {
                throw new ProdutoValorInvalidoException(valor);
            }
            produto.setValor(valor);
        } catch (ProdutoValorInvalidoException e) {
            e.getStackTrace();
            logger.info(e.toString());

        }
        produto.setNome(nome);

        produto.setCodigo(codigo);
        produto.setTipo(tipo);

        return produto;


    }

    public Sobremesa cadastraSobremesa(JsonNode node) {


        String quantidadeString = node.get("Quantidade").asText();

        quantidadeString = conversor(quantidadeString);
        float quantidade = Float.parseFloat(quantidadeString);


        boolean doce = node.get("Doce").asBoolean();
        String informacao = node.get("Informacao").asText();

        Sobremesa sobremesa = new Sobremesa(quantidade, doce, informacao);
        produto = sobremesa;
        return sobremesa;
    }

    public Bebida cadastraBebida(JsonNode node) {
        float tamanho =0;
        try {
            String tamanhoString = node.get("Tamanho").asText();
            tamanhoString = conversor(tamanhoString);
            tamanho = Float.parseFloat(df.format(Float.parseFloat(tamanhoString)));
            if (tamanho <= 0) {
                throw new BebidaException(tamanho);
            }

            boolean gelada = node.get("Gelada").asBoolean();
            String marca = node.get("Marca").asText();

            Bebida Bebida = new Bebida(gelada, tamanho, marca);
            produto = Bebida;
            return Bebida;
        } catch (BebidaException e) {
            logger.info(e.toString());
        }


return null;
    }

    public Comida cadastraComida(JsonNode node) {

        try {
            String pesoString = node.get("Peso").asText();
            pesoString = conversor(pesoString);
            float peso = Float.parseFloat(df.format(Float.parseFloat(pesoString)));

            if (peso <= 0) {
                throw new ComidaException(peso);

            }
            boolean vegano = node.get("Vegano").asBoolean();
            String ingredientesPuro = node.get("ingredientes").asText();
            String[] ingredientes = leInformacao(ingredientesPuro);

            Comida Comida = new Comida(peso, vegano, ingredientes);
            return Comida;
        } catch (ComidaException e) {

            e.getStackTrace();
            logger.info(e.toString());
        }


        return null;
    }

    public String conversor(String texto) {

        if (texto.contains(",")) {
            texto = texto.replace(",", ".");
        }
        return texto;
    }

    public String[] leInformacao(String info) {
        String[] vet = info.split(",");
        return vet;
    }

    public Produto verificaTipo(String tipo, JsonNode node, Produto produto) {

        String tipoRefeicao = tipo.toLowerCase();
        switch (tipoRefeicao) {

            case "comida":
                produto = cadastraComida(node);
                break;

            case "sobremesa":
                produto = cadastraSobremesa(node);
                break;

            case "bebida":
                produto = cadastraBebida(node);
                break;
            default:
                logger.info("Opção invalida");


        }

        return produto;
    }


}

