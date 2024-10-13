package com.tiago.gerenciador_de_plantacao.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.tiago.gerenciador_de_plantacao.entity.Canteiro;
import com.tiago.gerenciador_de_plantacao.entity.Insumo;
import com.tiago.gerenciador_de_plantacao.entity.Planta;
import com.tiago.gerenciador_de_plantacao.entity.Responsavel;
import com.tiago.gerenciador_de_plantacao.repository.CanteiroRepository;
import com.tiago.gerenciador_de_plantacao.repository.InsumoRepository;
import com.tiago.gerenciador_de_plantacao.repository.PlantaRepository;
import com.tiago.gerenciador_de_plantacao.repository.ResponsavelRepository;

import java.util.Scanner;

@Component
public class CommandLineMenu implements CommandLineRunner{
    @Autowired
    CanteiroRepository canteiroRepository;

    @Autowired
    InsumoRepository insumoRepository;

    @Autowired
    PlantaRepository plantaRepository;

    @Autowired
    ResponsavelRepository responsavelRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        //Adicionando 3 de cada entidade pelo código:
            //Responsavel:
            Responsavel resTiago = responsavelRepository.save(new Responsavel("Tiago"));
            Responsavel resHelena = responsavelRepository.save(new Responsavel("Dona Helena"));
            Responsavel resDomigos = responsavelRepository.save(new Responsavel("Seu Domingos"));

            //Canteiro:
            Canteiro canteiro1 = canteiroRepository.save(new Canteiro(5.0 , resTiago));
            /*Canteiro canteiro1 = new Canteiro();
            canteiro1.setArea(5.0); canteiro1.setResponsavel(resTiago);
            canteiroRepository.save(canteiro1);
            */

            Canteiro canteiro2 = canteiroRepository.save(new Canteiro(12.0 , resDomigos));
            Canteiro canteiro3 = canteiroRepository.save(new Canteiro(8.0 , resHelena));

            //Insumo:
            Insumo insumo1 = insumoRepository.save(new Insumo("Estrume -> cocô de vaca."));
            Insumo insumo2 = insumoRepository.save(new Insumo("Casca de ovo -> em pó, facilita a absorcao pelas plantas."));
            Insumo insumo3 = insumoRepository.save(new Insumo("Cinzas -> ricas em minerais e nutrientes."));

            //Planta:
            Planta planta1 = plantaRepository.save(new Planta("Alface", 75));
            Planta planta2 = plantaRepository.save(new Planta("Abóbora", 105));
            Planta planta3 = plantaRepository.save(new Planta("Batata Doce", 105));

        //Adicionando 3 de cada relacionamento:
            //recuperando os canteiros:
            canteiro1 = canteiroRepository.findById(canteiro1.getId()).get();
            canteiro2 = canteiroRepository.findById(canteiro2.getId()).get();    
            canteiro3 = canteiroRepository.findById(canteiro3.getId()).get();     
        
            //Plantado:
            canteiro1.getPlantas().add(planta2);
            canteiro2.getPlantas().add(planta3);
            canteiro3.getPlantas().add(planta1);

            //Aplicado:
            canteiro1.getInsumos().add(insumo3);
            canteiro2.getInsumos().add(insumo1);
            canteiro3.getInsumos().add(insumo2);

            //Salvando:
            canteiroRepository.save(canteiro1);
            canteiroRepository.save(canteiro2);
            canteiroRepository.save(canteiro3);

        Scanner s = new Scanner(System.in);
        Integer r = 0;

        do {
            System.out.println("Menu de interação por linha de comando:");
            System.out.println("Com qual entidade ou relacionamento voce quer trabalhar?\n" +
                    "1 -> Canteiro.\n" +
                    "2 -> Insumo.\n" +
                    "3 -> Planta.\n" +
                    "4 -> Responsavel.\n" +
                    "5 -> Criar relacionamento Plantado.\n" +
                    "     (Planta_Canteiro)\n" +
                    "6 -> Criar relacionamento Aplicado.\n" + 
                    "     (Insumo_Canteiro)\n" +
                    "7 -> Nenhuma. (ENCERRAR PROGRAMA)");

            r = s.nextInt();

            while (r < 1 || r > 7) {
                System.out.println("Resposta inválida, por favor digite novamente: ");
                r = s.nextInt();
            }

            switch (r) {
                case 1: //CANTEIRO:
                    System.out.println("CANTEIRO: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");

                    Integer r2 = s.nextInt();

                    while (r2 < 1 || r2 > 5) {
                        System.out.println("Resposta inválida, por favor digite novamente: ");
                        r = s.nextInt();
                    }

                    switch (r2) {
                        case 1:
                            Double area; Integer responsavel_id;
                            System.out.println("Digite a area: ");
                            area = s.nextDouble();
                            System.out.println("Digite o responsavel_id: ");
                            responsavel_id = s.nextInt();
                            
                            Canteiro c = new Canteiro();
                            c.setArea(area);
                            Responsavel responsavel = responsavelRepository.findById(responsavel_id).orElseThrow(
                                () -> new RuntimeException("Responsavel nao encontrado"));
                            c.setResponsavel(responsavel);
                            canteiroRepository.save(c);
                            break;
                    
                        case 2:
                            System.out.println("Digite o id: (digite \"-1\" para recuperar todos)");
                            Integer id = s.nextInt();
                            if (id > 0) System.out.println(canteiroRepository.findById(id).toString());

                            else canteiroRepository.findAll().forEach(ca -> System.out.println(ca.toString()));

                            break;
                    
                        case 3:
                            Integer idu; Double areau; Integer responsavel_idu;
                            System.out.println("Digite o id: ");
                            idu = s.nextInt();
                            System.out.println("Digite a area: ");
                            areau = s.nextDouble();
                            System.out.println("Digite o responsavel_id: ");
                            responsavel_idu = s.nextInt();
                            
                            Canteiro c_up = new Canteiro();
                            c_up.setId(idu);
                            c_up.setArea(areau);
                            Responsavel responsavelu = responsavelRepository.findById(responsavel_idu).orElseThrow(
                                () -> new RuntimeException("Responsavel nao encontrado"));
                                c_up.setResponsavel(responsavelu);
                            canteiroRepository.save(c_up);
                            break;
                    
                        case 4:
                            Integer idd;
                            System.out.println("Digite o id:");
                            idd = s.nextInt();
                            canteiroRepository.deleteById(idd);
                            break;
                    }

                    break;

                case 2: //INSUMO:
                    System.out.println("INSUMO: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");

                    Integer r3 = s.nextInt();
                    s.nextLine();

                    while (r3 < 1 || r3 > 5) {
                        System.out.println("Resposta inválida, por favor digite novamente: ");
                    }

                    switch (r3) {
                        case 1:
                            String descricao;
                            System.out.println("Digite a descricao: ");
                            descricao = s.nextLine();
                            
                            Insumo e = new Insumo();
                            e.setDescricao(descricao);

                            insumoRepository.save(e);
                            break;
                    
                        case 2:
                            System.out.println("Digite o id: (digite \"-1\" para recuperar todos)");
                            Integer id = s.nextInt();
                            if (id > 0) System.out.println(insumoRepository.findById(id).toString());

                            else insumoRepository.findAll().forEach(ca -> System.out.println(ca.toString()));

                            break;
                    
                        case 3:
                            Integer idu; String descricaou;
                            System.out.println("Digite o id: ");
                            idu = s.nextInt(); s.nextLine();
                            System.out.println("Digite a descricao: ");
                            descricaou = s.nextLine();
                            
                            
                            Insumo e_up = new Insumo();
                            e_up.setId(idu);
                            e_up.setDescricao(descricaou);

                            insumoRepository.save(e_up);
                            break;
                    
                        case 4:
                            Integer idd;
                            System.out.println("Digite o id: ");
                            idd = s.nextInt(); s.nextLine();
                            insumoRepository.deleteById(idd);
                            break;
                    }

                    break;
            
                case 3: //PLANTA:
                    System.out.println("PLANTA: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");

                    Integer r4 = s.nextInt();
                    s.nextLine();

                    while (r4 < 1 || r4 > 5) {
                        System.out.println("Resposta inválida, por favor digite novamente: ");
                    }

                    switch (r4) {
                        case 1:
                            String nome;
                            System.out.println("Digite o nome: ");
                            nome = s.nextLine();
                            
                            Integer periodo_colheita;
                            System.out.println("Digite o período, em dias, até a colheita: ");
                            periodo_colheita = s.nextInt();

                            Planta p = new Planta();
                            p.setNome(nome);
                            p.setPeriodo_colheita(periodo_colheita);

                            plantaRepository.save(p);
                            break;
                    
                        case 2:
                            System.out.println("Digite o id: (digite \"-1\" para recuperar todos)");
                            Integer id = s.nextInt();
                            if (id > 0) System.out.println(plantaRepository.findById(id).toString());

                            else plantaRepository.findAll().forEach(ca -> System.out.println(ca.toString()));

                            break;
                    
                        case 3:
                            Integer idu; String nomeu; Integer periodo_colheitau;
                            System.out.println("Digite o id: ");
                            idu = s.nextInt(); s.nextLine();
                            System.out.println("Digite o nome: ");
                            nomeu = s.nextLine();
                            System.out.println("Digite o período, em dias, até a colheita: ");
                            periodo_colheitau = s.nextInt();

                            Planta p_up = new Planta();
                            p_up.setId(idu);
                            p_up.setNome(nomeu);
                            p_up.setPeriodo_colheita(periodo_colheitau);

                            plantaRepository.save(p_up);
                            break;
                    
                        case 4:
                            Integer idd;
                            System.out.println("Digite o id: ");
                            idd = s.nextInt(); s.nextLine();
                            plantaRepository.deleteById(idd);
                            break;
                    }


                    break;
            
                case 4: //RESPONSAVEL:
                    System.out.println("RESPONSAVEL: \n" +
                    "Selecione a operacao: \n" +
                    "1 -> Criar.\n" +
                    "2 -> Recuperar.\n" +
                    "3 -> Atualizar.\n" +
                    "4 -> Deletar.\n" +
                    "5 -> Nenhuma. (VOLTAR AO MENU ANTERIOR)");

                    Integer r5 = s.nextInt();
                    s.nextLine();

                    while (r5 < 1 || r5 > 5) {
                        System.out.println("Resposta inválida, por favor digite novamente: ");
                    }

                    switch (r5) {
                        case 1:
                            String nome;
                            System.out.println("Digite o nome: ");
                            nome = s.nextLine();
                            
                            Responsavel res = new Responsavel();
                            res.setNome(nome);

                            responsavelRepository.save(res);
                            break;
                    
                        case 2:
                            System.out.println("Digite o id: (digite \"-1\" para recuperar todos)");
                            Integer id = s.nextInt();
                            if (id > 0) System.out.println(responsavelRepository.findById(id).toString());

                            else responsavelRepository.findAll().forEach(ca -> System.out.println(ca.toString()));

                            break;
                    
                        case 3:
                            Integer idu; String nomeu;
                            System.out.println("Digite o id: ");
                            idu = s.nextInt(); s.nextLine();
                            System.out.println("Digite a nome: ");
                            nomeu = s.nextLine();
                            
                            
                            Responsavel res_up = new Responsavel();
                            res_up.setId(idu);
                            res_up.setNome(nomeu);

                            responsavelRepository.save(res_up);
                            break;
                    
                        case 4:
                            Integer idd;
                            System.out.println("Digite o id: ");
                            idd = s.nextInt(); s.nextLine();
                            responsavelRepository.deleteById(idd);
                            break;
                    }

                    break;
            
                case 5: //PLANTADO:
                    Integer canteiro_id, planta_id;
                    System.out.println("Digite o id do canteiro: ");
                    canteiro_id = s.nextInt();
                    System.out.println("Digite o id da planta: ");
                    planta_id = s.nextInt();

                    Canteiro c = canteiroRepository.findById(canteiro_id).get();
                    Planta p = plantaRepository.findById(planta_id).get();

                    if (c != null && p != null) {
                        c.getPlantas().add(p);
                        canteiroRepository.save(c);

                        System.out.println("Relação entre canteiro e planta foi criada.");
                    } else {
                        System.out.println("Canteiro e/ou planta não existem!");
                    }

                    break;

                case 6: //APLICADO:
                    Integer canteiro_id2, insumo_id;
                    System.out.println("Digite o id do canteiro: ");
                    canteiro_id2 = s.nextInt();
                    System.out.println("Digite o id do insumo: ");
                    insumo_id = s.nextInt();

                    Canteiro c2 = canteiroRepository.findById(canteiro_id2).get();
                    Insumo i = insumoRepository.findById(insumo_id).get();

                    if (c2 != null && i != null) {
                        c2.getInsumos().add(i);
                        canteiroRepository.save(c2);

                        System.out.println("Relação entre canteiro e insumo foi criada.");
                    } else {
                        System.out.println("Canteiro e/ou insumo não existem!");
                    }
                    
                    break;

                case 7: //ENCERRAR PROGRAMA:
                    System.out.println("PROGRAMA ENCERRADO...");
                    
                    break;
            }
        } while (r != 7);

        s.close();
    }

}