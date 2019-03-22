package model.beans;

import java.io.Serializable;
import java.util.Date;

public class Vendedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String email;
	private Date aniversario;
	private double salario;
	private Departamento departamento;
	
	public Vendedor() {}
	public Vendedor(int id, String nome, String email, Date aniversario, double salario, Departamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.aniversario = aniversario;
		this.salario = salario;
		this.departamento = departamento;
	}

	public int getId() {
		return id;
	}



	public void setId(int id) {
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



	public Date getAniversario() {
		return aniversario;
	}



	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public Departamento getDepartamento() {
		return departamento;
	}



	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}



	public String toString() {
		return id+", "+nome+", "+email+", "+aniversario+", "+salario+", "+departamento;
	}
	

}
