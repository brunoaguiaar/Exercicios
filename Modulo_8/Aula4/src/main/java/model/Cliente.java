package model;

import java.util.Date;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id 
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize=1)
    private Long id;

    @Column(name = "NOME")
    @Basic(optional = false)
    private String nome;
    
    @Column(name = "CPF")
    @Basic(optional = false)
    private String cpf;
    
    @Column(name = "BAIRRO")
    private String bairro;
    
    @Column(name = "CIDADE")
    private String cidade;
    
    @Column(name = "NUMERO_CASA")
    private String numeroCasa;
    
    @Column(name = "RUA")
    private String rua;
    
    @Column(name = "RG")
    @Basic(optional = false)
    private String rg;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "TELEFONE")
    private String telefone;
    
    @Column(name = "CELULAR")
    private String celular;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "NASCIMENTO")
    private Date nascimento;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
}
