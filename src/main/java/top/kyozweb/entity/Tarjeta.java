package top.kyozweb.entity;

import java.io.Serializable;
import java.util.Base64;

import org.apache.tika.Tika;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tarjetaId;

	@Column
	private String nombre;

	@Column
	private String imagenNombre;

	@Column(columnDefinition = "longblob")
	private byte[] imagenArchivo;

	@Column
	private Integer stock;

	@Column
	private Double precio;

	@Column
	private String descripcion;

	@Column
	private String url;

	@Column
	private String estado;

	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Categoria categoria;

	// convertir file en String base64
	public String getBase64Image() {
		String base64 = Base64.getEncoder().encodeToString(this.imagenArchivo);
		return base64;
	}

	// obtener tipo de imagen (jpeg,jpg,png,etc)
	public String getTypeImage() {
		String typeImage = new Tika().detect(this.imagenArchivo);
		return typeImage;
	}

	public Tarjeta() {
	}

	public Tarjeta(Integer tarjetaId, String nombre, String imagenNombre, byte[] imagenArchivo, Integer stock,
			Double precio, String descripcion, String url, String estado, Categoria categoria) {
		this.tarjetaId = tarjetaId;
		this.nombre = nombre;
		this.imagenNombre = imagenNombre;
		this.imagenArchivo = imagenArchivo;
		this.stock = stock;
		this.precio = precio;
		this.descripcion = descripcion;
		this.url = url;
		this.estado = estado;
		this.categoria = categoria;
	}

	public Integer getTarjetaId() {
		return this.tarjetaId;
	}

	public void setTarjetaId(Integer tarjetaId) {
		this.tarjetaId = tarjetaId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagenNombre() {
		return this.imagenNombre;
	}

	public void setImagenNombre(String imagenNombre) {
		this.imagenNombre = imagenNombre;
	}

	public byte[] getImagenArchivo() {
		return this.imagenArchivo;
	}

	public void setImagenArchivo(byte[] imagenArchivo) {
		this.imagenArchivo = imagenArchivo;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
