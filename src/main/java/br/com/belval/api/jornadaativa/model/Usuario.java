package br.com.belval.api.jornadaativa.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id ;
	private String nome ;
	private String email ;
	private String senha ;
	private String foto_perfil;

	public Usuario() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto_perfil() {
		return foto_perfil;
	}

	public void setFoto_perfil(String foto_perfil) {
		this.foto_perfil = foto_perfil;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(new Object[] { id, nome, email, senha, foto_perfil });
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(email, other.email) && Objects.equals(senha, other.senha)
				&& Objects.equals(foto_perfil, other.foto_perfil);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto_perfil=" + foto_perfil + "]";
	}
}



