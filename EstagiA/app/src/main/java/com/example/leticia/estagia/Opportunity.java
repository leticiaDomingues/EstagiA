package com.example.leticia.estagia;

public class Opportunity {
    String empresa;
    String local;
    String logo;
    String data;
    String site;
    String descricao;

    public Opportunity() {
        setOpportunity("", "", "", "", "", "");
    }

    public Opportunity(String empresa, String local,  String logo, String data, String site, String descricao) {
        setOpportunity(empresa, local, logo, data, site, descricao);
    }
    public void setOpportunity(String empresa, String local, String logo, String data, String site, String descricao) {
        this.empresa = empresa;
        this.local = local;
        this.site = site;
        this.descricao = descricao;
        this.logo = logo;
        this.data = data;
    }

    public String getEmpresa() {return empresa; }
    public String getLocal() { return local; }
    public String getLogo() {return logo; }
    public String getData() { return data; }
    public String getSite() { return site; }
    public String getDescricao() { return descricao; }
}
