import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class TabelaTodos extends JFrame
{
	private Container cont;
	private String[] titulosDoutorado = {"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura","Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Tipo da viatura","Data de conclusao do doutoramento"};
	private String[] titulosNormal = {"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura","Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Tipo da vitura","Esteve no estrangeiro", "Numero de anos fora"};
	private String[] titulosRevendedor = {"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura","Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Quantidade de viaturas","Nome Comercial"};
	private String[] titulosEstado = {"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura","Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Quantidade de viaturas","Nome da instituicao governamental","Deseja incluir a manutencao"};
	private JTable tabelaD, tabelaN, tabelaR, tabelaE;
	private String[][] arrayD, arrayN, arrayR, arrayE;
	private JScrollPane scrollD, scrollN, scrollR, scrollE;
	private JLabel labelGeral;
	private JPanel panelTitulo;
	//Adicionando popup
	private JPopupMenu popup;
	private JMenuItem ordenar, sair;
	
	
	public TabelaTodos(ArrayList lista)
	{
		super("Todos os dados");
		
		ImageIcon icon = new ImageIcon("Imagens/DataImagesTitle1.jpg");
		JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);
		cont = getContentPane();
		cont.setLayout(new GridLayout(5,1,0,0));
		cont.setBackground(Color.LIGHT_GRAY);
		
		
		labelGeral = new JLabel("Dados de Todos os Clientes");
		labelGeral.setFont(new Font("Serif",Font.BOLD, 50));
		
		panelTitulo = new JPanel();
		labelGeral.setIcon(new ImageIcon("Imagens/DataImages1.png"));
		panelTitulo.add(labelGeral);
		panelTitulo.setBackground(new Color(0, 0, 0,0));
		
		
		cont.add(panelTitulo);
		arrayD = tabelaDoutorado(lista, lista.size());
		tabelaD = new JTable(arrayD, titulosDoutorado);
		scrollD = new JScrollPane(tabelaD);
		tabelaD.setEnabled(false);
		cont.add(scrollD);
		
//		System.out.println(titulosNormal.length);
		arrayN = tabelaNormal(lista, lista.size());
		tabelaN = new JTable(arrayN,titulosNormal);
		scrollN = new JScrollPane(tabelaN);
		tabelaN.setEnabled(false);
		cont.add(scrollN);
		
		arrayR = tabelaRevendedor(lista, lista.size());
		tabelaR = new JTable(arrayR,titulosRevendedor);
		scrollR = new JScrollPane(tabelaR);
		tabelaR.setEnabled(false);
		cont.add(scrollR);
		
		arrayE = tabelaEstado(lista, lista.size());
		tabelaE = new JTable(arrayE,titulosEstado);
		scrollE = new JScrollPane(tabelaE);
		tabelaE.setEnabled(false);
		cont.add(scrollE);
		
		//Colocando popup
				cont.addMouseListener
				(
					new MouseAdapter()
					{
						public void mouseReleased(MouseEvent e)
						{
							processMouseEvent(e);
						}
						public void processMouseEvent(MouseEvent e)
						{
							if(e.isPopupTrigger())
								popup.show(e.getComponent(), e.getX( ), e.getY( ));
							cont.repaint();
							cont.revalidate();
						}
					}
				);
				// Colocando popup (compatível com Windows e macOS)
				cont.addMouseListener
				(
				    new MouseAdapter() 
				    {
				        public void mousePressed(MouseEvent e) 
				        {
				            verificarPopup(e);
				        }

				        public void mouseReleased(MouseEvent e) 
				        {
				            verificarPopup(e);
				        }

				        private void verificarPopup(MouseEvent e) 
				        {
				            if (e.isPopupTrigger()) 
				            {
				                popup.show(e.getComponent(), e.getX(), e.getY());
				                cont.repaint();
				                cont.revalidate();
				            }
				        }
				    }
				);

				
						
				popup = new JPopupMenu();
				//Os JMenuItems
				ordenar = new JMenuItem("Opcao 1");
				ordenar.setToolTipText("Ordenar os dados dos clientes pela cilindragem");
				sair = new JMenuItem("Voltar");
				sair.setToolTipText("Voltar Para Menu");
				
				popup.add(ordenar);
				popup.addSeparator();
				popup.add(sair);
				
				ordenar.addActionListener
				(
				    new ActionListener()
				    {
				        public void actionPerformed(ActionEvent a)
				        {
				            cont.remove(scrollD); // Remove o antigo JScrollPane
				            bubbleSorte(lista);  //Eh a primeira vez, portanto precisamos reordenar
				            arrayD = tabelaDoutorado(lista, lista.size()); 
				            tabelaD = new JTable(arrayD, titulosDoutorado);
				            tabelaD.setEnabled(false);
				            scrollD = new JScrollPane(tabelaD);
				            cont.add(scrollD, 1); // Reinsere no índice correto
				            
				            cont.remove(scrollN); 
				            //Ja nao precisamos reordenar
				            arrayN = tabelaNormal(lista, lista.size()); 
				            tabelaN = new JTable(arrayN, titulosNormal);
				            tabelaN.setEnabled(false);
				            scrollN = new JScrollPane(tabelaN);
				            cont.add(scrollN, 2); 
				            

				            cont.remove(scrollR); 
				            //Das outras vezes ja nao precisamos reordenar
				            arrayR = tabelaRevendedor(lista, lista.size()); 
				            tabelaR = new JTable(arrayR, titulosRevendedor);
				            tabelaR.setEnabled(false);
				            scrollR = new JScrollPane(tabelaR);
				            cont.add(scrollR, 3); 
				            
				            cont.remove(scrollE); 
				            //Das outras vezes ja nao precisamos reordenar
				            arrayE = tabelaEstado(lista, lista.size()); 
				            tabelaE = new JTable(arrayE, titulosEstado);
				            tabelaE.setEnabled(false);
				            scrollE = new JScrollPane(tabelaE);
				            cont.add(scrollE, 4); 
				            
				            cont.revalidate();
				            cont.repaint();
				        }
				    }
				);
				sair.addActionListener
				(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent a)
						{
							dispose();
						}
					}
				);

		
		setSize(1200,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public String[][] tabelaDoutorado(ArrayList lista, int linhas)
	{
		String[][] array = new String[Doutorado.ctDoutorado][titulosDoutorado.length];
		int cont=0;
		Cliente cliente;
		Doutorado doutor;
		for(int i=0; i<linhas;i++)
		{
//			"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura","Modelo da viatura","Codigo da viatura",
//			"Cilindragem","Preco da viatura","Tpo da viatura","Data de conclusao do doutoramento"
			cliente = (Cliente) lista.get(i);
			if(cliente instanceof Doutorado)
			{
				doutor = (Doutorado) cliente;
				array[cont][0] = doutor.getnomeCliente();
				array[cont][1] = doutor.getnumeroTelefone();
				array[cont][2] = doutor.getdataCompra();
				array[cont][3] = doutor.getestadoCompra();
				array[cont][4] = doutor.getmarcaViatura();
				array[cont][5] = doutor.getmodeloViatura();
				array[cont][6] = String.valueOf(doutor.getcodeViatura());
				array[cont][7] = String.valueOf(doutor.getcilindragem());
				array[cont][8] = String.valueOf(doutor.getprecoViatura());
				array[cont][9] = doutor.gettipoViatura();
				array[cont][10] = doutor.getdataCDoutoramento();
				cont++;
			}
		}
		return array;
	}
	
	//Tabela de Normal
	public String[][] tabelaNormal(ArrayList lista, int linhas)
	{
		String[][] array = new String[Normal.ctNormal][titulosNormal.length];
		int cont=0;
		Cliente cliente;
		Normal normal;
		for(int i=0; i<linhas;i++)
		{
//			{"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura"
//			,"Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Tipo da vitura",
//			"Esteve no estrangeiro", "Numero de anos fora"};
			cliente = (Cliente) lista.get(i);
			if(cliente instanceof Normal)
			{
				normal = (Normal) cliente;
				array[cont][0] = normal.getnomeCliente();
				array[cont][1] = normal.getnumeroTelefone();
				array[cont][2] = normal.getdataCompra();
				array[cont][3] = normal.getestadoCompra();
				array[cont][4] = normal.getmarcaViatura();
				array[cont][5] = normal.getmodeloViatura();
				array[cont][6] = String.valueOf(normal.getcodeViatura());
				array[cont][7] = String.valueOf(normal.getcilindragem());
				array[cont][8] = String.valueOf(normal.getprecoViatura());
				array[cont][9] = normal.gettipoViatura();
				array[cont][10] = normal.gtestrangeiro();
				array[cont][11] = String.valueOf(normal.getnumeroAnosForaPais());
				cont++;
			}
		}
		return array;
	}
	
	public String[][] tabelaRevendedor(ArrayList lista, int linhas)
	{
		String[][] array = new String[Revendedor.ctRevendor][titulosRevendedor.length];
		int cont=0;
		Cliente cliente;
		Revendedor rev;
		for(int i=0; i<linhas;i++)
		{
//			{"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura"
//			,"Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Quantidade de viaturas"
//			,"Nome Comercial"};
			cliente = (Cliente) lista.get(i);
			if(cliente instanceof Revendedor)
			{
				rev = (Revendedor) cliente;
				array[cont][0] = rev.getnomeCliente();
				array[cont][1] = rev.getnumeroTelefone();
				array[cont][2] = rev.getdataCompra();
				array[cont][3] = rev.getestadoCompra();
				array[cont][4] = rev.getmarcaViatura();
				array[cont][5] = rev.getmodeloViatura();
				array[cont][6] = String.valueOf(rev.getcodeViatura());
				array[cont][7] = String.valueOf(rev.getcilindragem());
				array[cont][8] = String.valueOf(rev.getprecoViatura());
				array[cont][9] = String.valueOf(rev.getqtyViaturas());
				array[cont][10] = rev.getnomeComercial();
				cont++;
			}
		}
		return array;
	}
	
	public String[][] tabelaEstado(ArrayList lista, int linhas)
	{
		String[][] array = new String[Estado.ctEstado][titulosEstado.length];
		int cont=0;
		Cliente cliente;
		Estado estado;
		for(int i=0; i<linhas;i++)
		{
//			{"Nome do cliente", "Numero do cliente","Data de compra","Estado de compra","Marca da viatura"
//			,"Modelo da viatura","Codigo da viatura","Cilindragem","Preco da viatura","Quantidade de viaturas"
//			,"Nome da instituicao governamental","Deseja incluir a manutencao"};
			cliente = (Cliente) lista.get(i);
			if(cliente instanceof Estado)
			{
				estado = (Estado) cliente;
				array[cont][0] = estado.getnomeCliente();
				array[cont][1] = estado.getnumeroTelefone();
				array[cont][2] = estado.getdataCompra();
				array[cont][3] = estado.getestadoCompra();
				array[cont][4] = estado.getmarcaViatura();
				array[cont][5] = estado.getmodeloViatura();
				array[cont][6] = String.valueOf(estado.getcodeViatura());
				array[cont][7] = String.valueOf(estado.getcilindragem());
				array[cont][8] = String.valueOf(estado.getprecoViatura());
				array[cont][9] = String.valueOf(estado.getqtyViaturas());
				array[cont][10] = estado.getnomeIGovernal();
				array[cont][11] = estado.getincluirManutencao();
				cont++;
			}
		}
		return array;
	}
	public void bubbleSorte(ArrayList lista)
	{
		Cliente cliente1, cliente2;
		for(int j=0; j<lista.size()-1; j++)
		{
			for(int i=0; i<lista.size()-1-j; i++)
			{
				cliente1 = (Cliente)lista.get(i);
				cliente2 = (Cliente)lista.get(i+1);
				if(cliente1.getcilindragem() > cliente2.getcilindragem())
					troca(lista, i, i+1);
			}
		}
	}
	public void troca(ArrayList lista, int menor, int maior)
	{
		Cliente aux = (Cliente) lista.get(menor);
		lista.set(menor, lista.get(maior));
		lista.set(maior, aux);
	}
}
