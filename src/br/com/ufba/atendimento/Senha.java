package br.com.ufba.atendimento;

import java.util.Date;

public class Senha {
	private int id;
	private String tipo; // P - Preferencial; N - Normal
	private Date dataAtendimento;
	private Date dataRegistro;

	public Senha(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
		this.dataRegistro = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
}
