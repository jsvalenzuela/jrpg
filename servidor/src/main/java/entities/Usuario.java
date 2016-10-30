package entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {

	private int idUsuario;
	private String username;
	private String password;

	public Usuario(String username, String password) {
		this.username = username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}

	public int guardarUsuario() {
		return 1;
	}

	public int validarIngreso(String username, String password) {
		return 0;
	}

	public boolean equals(Usuario obj) {
		if (this.idUsuario == obj.idUsuario && this.username == obj.username)
			return true;

		return false;
	}
}