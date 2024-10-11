package com.tiago.gerenciador_de_plantacao.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tiago.gerenciador_de_plantacao.entity.Canteiro;
import com.tiago.gerenciador_de_plantacao.entity.Responsavel;
import com.tiago.gerenciador_de_plantacao.repository.CanteiroRepository;
import com.tiago.gerenciador_de_plantacao.repository.EnsumoRepository;
import com.tiago.gerenciador_de_plantacao.repository.PlantaRepository;
import com.tiago.gerenciador_de_plantacao.repository.ResponsavelRepository;

import java.util.Scanner;

@Component
public class CommandLineMenu implements CommandLineRunner{
    @Autowired
    CanteiroRepository canteiroRepository;

    @Autowired
    EnsumoRepository ensumoRepository;

    @Autowired
    PlantaRepository plantaRepository;

    @Autowired
    ResponsavelRepository responsavelRepository;

    @Override
    public void run(String... args) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer r;

        do {
            System.out.println("Menu de interação por linha de comando:");
            System.out.println("Com qual entidade voce quer trabalhar?\n" +
                    "1 -> Canteiro.\n" +
                    "2 -> Ensumo.\n" +
                    "3 -> Planta.\n" +
                    "4 -> Responsavel.\n" +
                    "5 -> Nenhuma. (ENCERRAR PROGRAMA)");

            r = s.nextInt();
            s.nextLine();

            while (r < 1 || r > 5) {
                System.out.println("Resposta inválida, por favor digite novamente: ");
                r = s.nextInt();
                s.nextLine();
            }

            switch (r) {
                case 1:
                    System.out.println("CANTEIRO: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");

                    Integer r2 = s.nextInt();
                    s.nextLine();

                    while (r2 < 1 || r2 > 5) {
                        System.out.println("Resposta inválida, por favor digite novamente: ");
                        r = s.nextInt();
                        s.nextLine();
                    }

                    switch (r2) {
                        case 1:
                            Double area; Integer responsavel_id;
                            System.out.println("Digite a area: ");
                            area = s.nextDouble();
                            System.out.println("Digite o responsavel_id: ");
                            responsavel_id = s.nextInt(); s.nextLine();
                            
                            Canteiro c = new Canteiro();
                            c.setArea(area);
                            Responsavel responsavel = responsavelRepository.findById(responsavel_id).orElseThrow(
                                () -> new RuntimeException("Responsavel nao encontrado"));
                            c.setResponsavel(responsavel);
                            canteiroRepository.save(c);
                            break;
                    
                        case 2:
                            System.out.println("Digite o id: ");
                            Integer id = s.nextInt();
                            System.out.println(canteiroRepository.findById(id).toString());
                            break;
                    
                        case 3:
                            Integer idu; Double areau; Integer responsavel_idu;
                            System.out.println("Digite o id: ");
                            idu = s.nextInt();
                            System.out.println("Digite a area: ");
                            areau = s.nextDouble();
                            System.out.println("Digite o responsavel_id: ");
                            responsavel_idu = s.nextInt(); s.nextLine();
                            
                            Canteiro c_up = new Canteiro();
                            c_up.setId(idu);
                            c_up.setArea(areau);
                            Responsavel responsavelu = responsavelRepository.findById(responsavel_idu).orElseThrow(
                                () -> new RuntimeException("Responsavel nao encontrado"));
                                c_up.setResponsavel(responsavelu);
                            canteiroRepository.save(c_up);
                            break;
                    
                        case 4:
                            canteiroRepository.save(new Canteiro());

                            Integer idd;
                            System.out.println("Digite o id: ");
                            idd = s.nextInt(); s.nextLine();
                            canteiroRepository.deleteById(idd);
                            break;
                    }

                    break;

                case 2:
                    System.out.println("Ensumo: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");
                    break;
            
                case 3:
                    System.out.println("PLANTA: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");
                    break;
            
                case 4:
                    System.out.println("RESPONSAVEL: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");
                    break;
            
                case 5:
                    System.out.println("PROGRAMA ENCERRADO...");
                    
                    break;
            }
        } while (r != 5);

        s.close();
    }

}
