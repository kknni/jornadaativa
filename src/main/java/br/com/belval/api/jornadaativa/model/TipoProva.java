package br.com.belval.api.jornadaativa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
 
@Entity
public class TipoProva {
 
    @Id
    @GeneratedValue(
    		strategy = GenerationType.IDENTITY
    )
 
    private Integer id;
    private String nome;
    private Double maratona;
    private Double meiamaratona;
    private Double metrosrasos;

    public TipoProva() {}
    public TipoProva(String nome) {
 
        this.nome = nome;
 
    }
    public Integer getId() {
 
        return id;
 
    }
    public void setId(Integer id) {
 
        this.id = id;
 
    }
    public String getNome() {
 
        return nome;
 
    }
    public void setNome(String nome) {
 
        this.nome = nome;
 
    }
	public Double getMaratona() {
		return maratona;
	}
	public void setMaratona(Double maratona) {
		this.maratona = maratona;
	}
	
	public Double getMeiamaratona() {
		return meiamaratona;
	}
	public void setMeiamaratona(Double meiamaratona) {
		this.meiamaratona = meiamaratona;
	}
	
	public Double getMetrosrasos() {
		return metrosrasos;
	}
	public void setMetrosrasos(Double metrosrasos) {
		this.metrosrasos = metrosrasos;
	}
    
}
