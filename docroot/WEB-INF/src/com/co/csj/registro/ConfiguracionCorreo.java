package com.co.csj.registro;

public class ConfiguracionCorreo {

	private String correo;
	private String clave;
	private String host;
	private String puerto;
	
	public ConfiguracionCorreo() {}
	
	public ConfiguracionCorreo(String correo, String clave, String host,
			String puerto) {
		super();
		this.correo = correo;
		this.clave = clave;
		this.host = host;
		this.puerto = puerto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
	
}
