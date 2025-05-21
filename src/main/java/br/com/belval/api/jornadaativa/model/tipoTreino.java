package br.com.belval.api.jornadaativa.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class tipoTreino {
	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY
	)
	private Integer idtipoTreino;
	private double velocidade;
	private String resistencia;
	private String caminhada;
	
	public tipoTreino() {
		
	}
	public Integer getidtipoTreino() {
		return idtipoTreino;
	}
	
	public void setidtipoTreino(Integer idtipoTreino) {
		this.idtipoTreino = idtipoTreino;
	}
	
	public double getVelocidade() {
		return velocidade;
	} 
	public void setvelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public String getresistencia() {
		return resistencia;
	} 
	public void setresistencia(String resistencia) {
		this.resistencia = resistencia;
		}
	public String getcaminhada() {
		return caminhada;
	}
	public void setcaminhada(String caminhada) {
		this.caminhada = caminhada;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(new Object[] {velocidade, resistencia, caminhada});
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		}else if (this.getClass() != obj.getClass()) {
			return false;
		}else {
			tipoTreino other = (tipoTreino) obj;
			return Objects.equals(velocidade,other.velocidade) && Objects.equals(resistencia,other.resistencia) && Objects.equals(caminhada,other.caminhada);
		}
	}
	
	@Override
	public String toString() {
		return "tipotreino [velocidade=" + velocidade + ", resistencia=" + resistencia + ", caminhada" + caminhada + "]";
	}
	
}
