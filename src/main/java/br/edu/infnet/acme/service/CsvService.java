package br.edu.infnet.acme.service;

import br.edu.infnet.acme.model.Produto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.Formatter;

@Service
public class CsvService {

    public void ProdutoCsv(Produto produto) {
        String rootDir = System.getProperty("user.dir");
        String baseUri = "src.main.java.br.edu.infnet.acme";
        String separator = FileSystems.getDefault().getSeparator();
        String uri = rootDir + separator + baseUri.replaceAll("\\.", separator) + separator + produto.getNome() + ".csv";
        System.out.println(uri);
        File arquivo = new File(uri);

        Formatter output = null;
        try {
            output = new Formatter(arquivo);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        output.format("%s , %s, %s, %s, \n", "Id", "Nome", "Marca", "Valor");
        output.format("%d , %s, %s, %s, \n\n", produto.getId(), produto.getNome(), produto.getMarca(), produto.getValor());

        output.close();
    }
}
