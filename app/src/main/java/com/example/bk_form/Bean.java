package com.example.bk_form;

public class Bean {
    public static String ID = "ID";
    public static String NAME = "NAME";
    public static String LAST_NAME = "LAST_NAME";
    public static String EMAIL = "EMAIL";
    public static String PASSWORD = "PASSWORD";
    public static String CPF = "CPF";
    public static String CNPJ = "CNPJ";
    public static String ADDRESS = "ADDRESS";
    public static String FORM = "FORM";

    private Integer id;
    private String name;
    private String last_name;
    private String email;
    private String password;
    private String cpf;
    private String cnpj;
    private String address;

    public Bean(String name, String last_name, String email, String password, String cpf, String cnpj, String address) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
    }

    public Bean(Integer id, String name, String last_name, String email, String password, String cpf, String cnpj, String address) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
