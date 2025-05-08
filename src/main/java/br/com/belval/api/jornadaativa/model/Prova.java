package br.com.belval.api.jornadaativa.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Prova {
	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY	
	)
	private Integer id;
	private String nome;
	private Double distancia;
	private String local;
	private LocalDate data;
	
	public Prova() {
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

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	   
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(new Object[] { id, nome, distancia, local, data });
	}
	   
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		} else {
			Prova other = (Prova) obj;
			return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
					&& Objects.equals(distancia, other.distancia) && Objects.equals(local, other.local)
					&& Objects.equals(data, other.data);
		}
	}
	
	@Override
	public String toString() {
		return "Prova [id=" + id + ", nome=" + nome + ", distancia=" + distancia + ", local=" + local + ", data=" + data
				+ "]";
	}
}
