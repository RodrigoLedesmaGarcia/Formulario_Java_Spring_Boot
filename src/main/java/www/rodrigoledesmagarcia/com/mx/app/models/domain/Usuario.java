package www.rodrigoledesmagarcia.com.mx.app.models.domain;


import java.util.Date;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Usuario {
	
	@NotEmpty
	private String apellido;

	@NotEmpty
	private String nombre;
	
    @NotEmpty
    private String username;
    
    @NotEmpty
    @Size(min=5, max=15)
    private String password;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date fecha;
    
    
    @NotEmpty
    private String pais;

    public Usuario() {
    }

    public Usuario(String username, String password, String email, String apellido, String nombre) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
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
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
    
    
    
    
}


