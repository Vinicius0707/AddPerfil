package controller;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Connection {
    public static InitialDirContext newConnection() throws NamingException, IOException {
        System.out.println("Iniciando Conecxão");

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\properties\\credenciais.properties");

        prop.load(fis);
        String factory = prop.getProperty("factory");
        String url = prop.getProperty("url");
        String principal = prop.getProperty("principal");
        String credentials = prop.getProperty("credentials");

        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, factory);
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_PRINCIPAL, principal);
        env.put(Context.SECURITY_CREDENTIALS, credentials);

        InitialDirContext connection = new InitialDirContext(env);
        return connection;
    }
}
