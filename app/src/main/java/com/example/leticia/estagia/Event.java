package com.example.leticia.estagia;


public class Event {
    String empresa;
    String local;
    String logo;
    String data;
    String descricao;

    public Event() {
        setEvent("", "", "", "", "");
    }

    public Event(String empresa, String local,  String logo, String data, String descricao) {
        setEvent(empresa, local, logo, data, descricao);
    }
    public void setEvent(String empresa, String local, String logo, String data,  String descricao) {
        this.empresa = empresa;
        this.local = local;
        this.descricao = descricao;
        this.logo = logo;
        this.data = data;
    }

    public String getEmpresa() {return empresa; }
    public String getLocal() { return local; }
    public String getLogo() {return logo; }
    public String getData() { return data; }
    public String getDescricao() { return descricao; }
}

