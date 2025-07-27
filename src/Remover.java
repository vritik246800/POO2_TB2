import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Remover
{
	public void remover(ArrayList a)
	{
		Cliente pai;
		Doutorado dou;
		Normal nor;
		Revendedor rev;
		Estado est;
		
		for(int i=0;i<a.size();i++)
		{
			pai=(Cliente)a.get(i);
			if(pai.getestadoCompra().equalsIgnoreCase("entrega concluida"))
			{
				try
				{
					FileWriter fr=new FileWriter("Cliente_de_Entregue_concluida.txt",true);
					BufferedWriter bw=new BufferedWriter(fr);
					
					if(pai instanceof Doutorado)
					{
						dou=(Doutorado)pai;
						bw.write(dou.getnumeroTelefone()+";"+dou.getnomeCliente()+";"+dou.getdataCompra()+";"+dou.getestadoCompra()+";"+dou.getmarcaViatura()+";"+dou.getmodeloViatura()+";"+dou.getcodeViatura()+";"+dou.getcilindragem()+";"+dou.getprecoViatura()+";"+'p'+";"+dou.gettipoViatura()+";"+'d'+";"+dou.getdataCDoutoramento());
						bw.newLine();
					}
					else if(pai instanceof Normal)
					{
						nor=(Normal)pai;
						bw.write(nor.getnumeroTelefone()+";"+nor.getnomeCliente()+";"+nor.getdataCompra()+";"+nor.getestadoCompra()+";"+nor.getmarcaViatura()+";"+nor.getmodeloViatura()+";"+nor.getcodeViatura()+";"+nor.getcilindragem()+";"+nor.getprecoViatura()+";"+'p'+";"+nor.gettipoViatura()+";"+'n'+";"+nor.gtestrangeiro()+";"+nor.getnumeroAnosForaPais());
						bw.newLine();
					}
					else if(pai instanceof Revendedor)
					{
						rev=(Revendedor)pai;
						bw.write(rev.getnumeroTelefone()+";"+rev.getnomeCliente()+";"+rev.getdataCompra()+";"+rev.getestadoCompra()+";"+rev.getmarcaViatura()+";"+rev.getmodeloViatura()+";"+rev.getcodeViatura()+";"+rev.getcilindragem()+";"+rev.getprecoViatura()+";"+'e'+";"+rev.getqtyViaturas()+";"+'r'+";"+rev.getnomeComercial());
						bw.newLine();
					}
					else if(pai instanceof Estado)
					{
						est=(Estado)pai;
						bw.write(est.getnumeroTelefone()+";"+est.getnomeCliente()+";"+est.getdataCompra()+";"+est.getestadoCompra()+";"+est.getmarcaViatura()+";"+est.getmodeloViatura()+";"+est.getcodeViatura()+";"+est.getcilindragem()+";"+est.getprecoViatura()+";"+'e'+";"+est.getqtyViaturas()+";"+'e'+";"+est.getnomeIGovernal()+";"+est.getincluirManutencao());
						bw.newLine();
					}
				
					a.remove(i);
					a.trimToSize();
					i--;
					
					if(pai instanceof Doutorado)
						Doutorado.ctDoutorado--;
					else if(pai instanceof Normal)
						Normal.ctNormal--;
					else if(pai instanceof Revendedor)
						Revendedor.ctRevendor--;
					else if(pai instanceof Estado)
						Estado.ctEstado--;
				bw.close();
				}
				catch(IOException io)
				{
					System.out.println(io.getMessage());
				}
			}
		}
		try {
		    FileWriter fr = new FileWriter("Dados.txt");
		    BufferedWriter bw = new BufferedWriter(fr);

		    for (int i = 0; i < a.size(); i++) 
		    {
		        pai=(Cliente)a.get(i);
		        if (!pai.getestadoCompra().equalsIgnoreCase("entrega concluida")) 
		        {
		        	if(pai instanceof Doutorado)
					{
						dou=(Doutorado)pai;
						bw.write(dou.getnumeroTelefone()+";"+dou.getnomeCliente()+";"+dou.getdataCompra()+";"+dou.getestadoCompra()+";"+dou.getmarcaViatura()+";"+dou.getmodeloViatura()+";"+dou.getcodeViatura()+";"+dou.getcilindragem()+";"+dou.getprecoViatura()+";"+'p'+";"+dou.gettipoViatura()+";"+'d'+";"+dou.getdataCDoutoramento());
						bw.newLine();
					}
					else if(pai instanceof Normal)
					{
						nor=(Normal)pai;
						bw.write(nor.getnumeroTelefone()+";"+nor.getnomeCliente()+";"+nor.getdataCompra()+";"+nor.getestadoCompra()+";"+nor.getmarcaViatura()+";"+nor.getmodeloViatura()+";"+nor.getcodeViatura()+";"+nor.getcilindragem()+";"+nor.getprecoViatura()+";"+'p'+";"+nor.gettipoViatura()+";"+'n'+";"+nor.gtestrangeiro()+";"+nor.getnumeroAnosForaPais());
						bw.newLine();
					}
					else if(pai instanceof Revendedor)
					{
						rev=(Revendedor)pai;
						bw.write(rev.getnumeroTelefone()+";"+rev.getnomeCliente()+";"+rev.getdataCompra()+";"+rev.getestadoCompra()+";"+rev.getmarcaViatura()+";"+rev.getmodeloViatura()+";"+rev.getcodeViatura()+";"+rev.getcilindragem()+";"+rev.getprecoViatura()+";"+'e'+";"+rev.getqtyViaturas()+";"+'r'+";"+rev.getnomeComercial());
						bw.newLine();
					}
					else if(pai instanceof Estado)
					{
						est=(Estado)pai;
						bw.write(est.getnumeroTelefone()+";"+est.getnomeCliente()+";"+est.getdataCompra()+";"+est.getestadoCompra()+";"+est.getmarcaViatura()+";"+est.getmodeloViatura()+";"+est.getcodeViatura()+";"+est.getcilindragem()+";"+est.getprecoViatura()+";"+'e'+";"+est.getqtyViaturas()+";"+'e'+";"+est.getnomeIGovernal()+";"+est.getincluirManutencao());
						bw.newLine();
					}
		        }
		    }

		    bw.close();
		} catch (IOException io) {
		    System.out.println(io.getMessage());
		}

		;
		JOptionPane.showMessageDialog(null, "Remocao do estado de entregue concluida!");		
	}
}