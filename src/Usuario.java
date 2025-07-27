
public class Usuario 
{
	private String nome,pin,numeroTelefone;
	
	public Usuario(String nome,String pin,String numeroTelefone)
	{
		this.nome=nome;
		this.pin=pin;
		this.numeroTelefone=numeroTelefone;
	}
	public Usuario()
	{
		this("","","");
	}
	public String getnome() {return nome;}
	public String getpin() {return pin;}
	public String getnumeroTelefone() {return numeroTelefone;}
	
	public void setnome(String nome) {this.nome=nome;}
	public void setpin(String pin) {this.pin=pin;}
	public void setnumeroTelefone(String numeroTelefone) {this.numeroTelefone=numeroTelefone;}
	
}
