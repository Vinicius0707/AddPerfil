package model;

import controller.Connection;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Users {

    public static void getAllUsers() throws NamingException {
        List list = Planilha.plan();
        System.out.println(Planilha.plan());

        InitialDirContext connection = null;
        try {
            connection = Connection.newConnection();
        }catch (IOException e){
            System.out.println(e);
        }

        String searchFilter = "(uid=*)";
        String[] reqAtt = { "cn" };
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);

            for(Object Lista: list){
                try {
                    NamingEnumeration users = connection.search(Lista.toString(), searchFilter, controls);
                    System.out.println(list.size());
                    SearchResult result = null;

                    result = (SearchResult) users.next();
                    Attributes attr = result.getAttributes();
                    String name = attr.get("cn").get(0).toString();
                    System.out.println(attr.get("cn"));
                }catch (Exception e){
                    System.out.println("Usuário não encontrado");
                }
            }

    }
}
