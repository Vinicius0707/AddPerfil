package model;

public class DadosPlanilha {
    private String login;
    private String perfil;

    public DadosPlanilha(String login, String perfil){
        super();
        this.login = login;
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }


    @Override
    public String toString() {
        return
                "uid=" + login + ",ou=people,ou=im,ou=ca,o=com"

                /* +
                ", perfil='" + perfil + '\'' +
                '}'*/;
    }

}
