package com.tiago.gerenciador_de_plantacao.Component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineMenu implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Menu de interação por linha de comando:");
        System.out.println("Com qual entidade voce quer trabalhar?\n" +
                "1 -> Canteiro.\n" +
                "2 -> Planta.\n" +
                "3 -> Responsável.\n" +
                "4 -> Remover Referencia.\n" +
                "5 -> Voltar ao Menu Principal.");
    }

}
