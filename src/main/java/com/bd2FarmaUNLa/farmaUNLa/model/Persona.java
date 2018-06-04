package com.bd2FarmaUNLa.farmaUNLa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idPersona")
	private long idPersona;
	private int dni;
	private String numAfiliado;
	private String apellido;
	private String nombre;
	private String calle;
	private String numero;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idLocalidad", referencedColumnName = "idLocalidad", nullable = false, foreignKey = @ForeignKey(name = "FK_localidad_persona"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idLocalidad")
	@JsonIdentityReference(alwaysAsId = true)
	private Localidad localidad;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "idObraSocial", referencedColumnName = "idObraSocial", nullable = false, foreignKey = @ForeignKey(name = "FK_obraSocial_persona"))
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idObraSocial")
	@JsonIdentityReference(alwaysAsId = true)
	private ObraSocial obraSocial;
	
	@OneToMany(mappedBy = "cliente", fetch=FetchType.EAGER)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPersona")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<Factura> facturas;
	
	
	public Persona(){} 
	
	public Persona(long idPersona, int dni, String numAfiliado, String apellido, String nombre, String calle, String numero, Localidad localidad, ObraSocial obraSocial) {
		this.idPersona = idPersona;
		this.dni = dni;
		this.numAfiliado = numAfiliado;
		this.apellido = apellido;
		this.nombre = nombre;		
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.obraSocial = obraSocial;
	}
	
	
	public long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNumAfiliado() {
		return numAfiliado;
	}
	public void setNumAfiliado(String numAfiliado) {
		this.numAfiliado = numAfiliado;
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

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public ObraSocial getObraSocial() {
		return obraSocial;
	}
	public void setObraSocial(ObraSocial obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPersona ^ (idPersona >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (idPersona != other.idPersona)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [idPersona=" + idPersona  + ", dni=" + dni  + ", numAfiliado=" + numAfiliado  + ", apellido=" + apellido  + ", nombre=" + nombre  + ", calle=" + calle  + ", numero=" + numero + ", localidad=" + localidad.getIdLocalidad() +", obraSocial=" + obraSocial.getIdObraSocial()  + "]";
	}
	

}
