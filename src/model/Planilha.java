package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Planilha {
    public static List<DadosPlanilha> plan() {
        String path = "C:\\properties\\PerfilVsUsersTest.csv";

        List<DadosPlanilha> list = new ArrayList<DadosPlanilha>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null){
                String[] vect = line.split(",");
                String login = vect[0];
                String perfil = vect[1];

                DadosPlanilha Dplan = new DadosPlanilha(login, perfil);

                list.add(Dplan);

                line = br.readLine();
            }

            //System.out.println("Pessoas");
            for (DadosPlanilha p : list){
                //System.out.println(p);
            }
        } catch (IOException e){
            System.out.println("ERROR: " + e.getMessage());
        }

        return list;
    }
    public static HashMap<String, String> hashMap(List<DadosPlanilha> users) {
        HashMap<String, String> map = new HashMap<>();
        for (DadosPlanilha user : users) {
            map.put(user.getLogin().toLowerCase(), user.getPerfil());
        }
        return map;
    }
}
