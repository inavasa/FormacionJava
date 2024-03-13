package org.indra.claseDos.models;

public class Automovil {
	private String matricula;
	private Color color;
	private String modelo;
	private int año;

	/**
	 * @param matricula
	 * @param color
	 * @param modelo
	 * @param año
	 */
	public Automovil(String matricula, Color color, String modelo, int año) {
		// super();
		this.matricula = matricula;
		this.color = color;
		this.modelo = modelo;
		this.año = año;
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the año
	 */
	public int getAño() {
		return año;
	}

	/**
	 * @param año the año to set
	 */
	public void setAño(int año) {
		this.año = año;
	}

}
