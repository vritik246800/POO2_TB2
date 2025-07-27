import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class ExportarComprasPDF 
{

    public void exportarParaPDF(ArrayList<Cliente> a, String caminhoSaida) 
    {
        Document documento = new Document(PageSize.A2.rotate());

        try 
        {
            PdfWriter.getInstance(documento, new FileOutputStream(caminhoSaida));
            documento.open();
            documento.add(new Paragraph("Relatório de Compras (Entregas Concluídas ou em Trânsito)\n\n"));

            // Criar tabelas para cada tipo de cliente
            PdfPTable tabelaD = criarTabela
    		(
                new String[]
        		{
                    "Nome do cliente", "Numero do cliente", "Data de compra", "Estado de compra", "Marca da viatura",
                    "Modelo da viatura", "Codigo da viatura", "Cilindragem", "Preco da viatura", "Tipo da viatura",
                    "Data de conclusao do doutoramento"
                }
            );

            PdfPTable tabelaN = criarTabela
    		(
                new String[]
        		{
                    "Nome do cliente", "Numero do cliente", "Data de compra", "Estado de compra", "Marca da viatura",
                    "Modelo da viatura", "Codigo da viatura", "Cilindragem", "Preco da viatura", "Tipo da viatura",
                    "Esteve no estrangeiro", "Numero de anos fora"
                }
            );

            PdfPTable tabelaR = criarTabela
    		(
                new String[]
        		{
                    "Nome do cliente", "Numero do cliente", "Data de compra", "Estado de compra", "Marca da viatura",
                    "Modelo da viatura", "Codigo da viatura", "Cilindragem", "Preco da viatura", "Quantidade de viaturas",
                    "Nome Comercial"
                }
            );

            PdfPTable tabelaE = criarTabela
    		(
                new String[]
        		{
                    "Nome do cliente", "Numero do cliente", "Data de compra", "Estado de compra", "Marca da viatura",
                    "Modelo da viatura", "Codigo da viatura", "Cilindragem", "Preco da viatura", "Quantidade de viaturas",
                    "Nome da instituicao governamental", "Deseja incluir a manutencao"
                }
            );

            // Contadores para verificar se há dados em cada tabela
            int countD = Doutorado.ctDoutorado, countN = Normal.ctNormal, countR = Revendedor.ctRevendor, countE = Estado.ctEstado;

            // Processar cada cliente
            for (int i = 0; i < a.size(); i++) 
            {
                Cliente cliente = a.get(i);
                
                String estado = "";

                // Obter estado da compra
                if (cliente instanceof Doutorado) 
                {
                    estado = ((Doutorado) cliente).getestadoCompra();
                }
                else if (cliente instanceof Normal) 
                {
                    estado = ((Normal) cliente).getestadoCompra();
                }
                else if (cliente instanceof Revendedor) 
                {
                    estado = ((Revendedor) cliente).getestadoCompra();
                }
                else if (cliente instanceof Estado) 
                {
                    estado = ((Estado) cliente).getestadoCompra();
                }

                // Verificar se o estado é válido
                if (estado == null) 
                	continue;

                estado = estado.toLowerCase().trim();
                if (!(estado.equals("entrega concluida") || estado.equals("em transito"))) 
                    continue;

                // Adicionar dados às tabelas
                if (cliente instanceof Doutorado) 
                {
                    Doutorado d = (Doutorado) cliente;
                    adicionarDadosDoutorado(tabelaD, d);
                }
                else if (cliente instanceof Normal) 
                {
                    Normal n = (Normal) cliente;
                    adicionarDadosNormal(tabelaN, n);
                }
                else if (cliente instanceof Revendedor) 
                {
                    Revendedor r = (Revendedor) cliente;
                    adicionarDadosRevendedor(tabelaR, r);
                }
                else if (cliente instanceof Estado) 
                {
                    Estado e = (Estado) cliente;
                    adicionarDadosEstado(tabelaE, e);
                }
            }

            // Adicionar tabelas ao documento apenas se contiverem dados
            if (countD > 0) 
            {
                documento.add(new Paragraph("Clientes Doutorados"));
                documento.add(tabelaD);
                documento.add(new Paragraph("\n"));
            }
            if (countN > 0) 
            {
                documento.add(new Paragraph("Clientes Normais"));
                documento.add(tabelaN);
                documento.add(new Paragraph("\n"));
            }
            if (countR > 0) 
            {
                documento.add(new Paragraph("Clientes Revendedores"));
                documento.add(tabelaR);
                documento.add(new Paragraph("\n"));
            }
            if (countE > 0) 
            {
                documento.add(new Paragraph("Clientes do Estado"));
                documento.add(tabelaE);
                documento.add(new Paragraph("\n"));
            }

            // Verificar se há dados para exportar
            if (countD == 0 && countN == 0 && countR == 0 && countE == 0) 
            {
                documento.add(new Paragraph("Nenhum cliente com compras concluídas ou em trânsito foi encontrado."));
            }

            documento.close();
            JOptionPane.showMessageDialog(null,"PDF exportado com sucesso: " + caminhoSaida+"\nTotal de registros exportados: " + (countD + countN + countR + countE));
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao exportar PDF: " + e.getMessage());
        }
    }

    private void adicionarDadosDoutorado(PdfPTable tabela, Doutorado d) 
    {
        tabela.addCell(verificarNulo(d.getnomeCliente()));
        tabela.addCell(verificarNulo(d.getnumeroTelefone()));
        tabela.addCell(verificarNulo(d.getdataCompra()));
        tabela.addCell(verificarNulo(d.getestadoCompra()));
        tabela.addCell(verificarNulo(d.getmarcaViatura()));
        tabela.addCell(verificarNulo(d.getmodeloViatura()));
        tabela.addCell(String.valueOf(d.getcodeViatura()));
        tabela.addCell(String.valueOf(d.getcilindragem()));
        tabela.addCell(String.valueOf(d.getprecoViatura()));
        tabela.addCell(verificarNulo(d.gettipoViatura()));
        tabela.addCell(verificarNulo(d.getdataCDoutoramento()));
    }

    private void adicionarDadosNormal(PdfPTable tabela, Normal n) 
    {
        tabela.addCell(verificarNulo(n.getnomeCliente()));
        tabela.addCell(verificarNulo(n.getnumeroTelefone()));
        tabela.addCell(verificarNulo(n.getdataCompra()));
        tabela.addCell(verificarNulo(n.getestadoCompra()));
        tabela.addCell(verificarNulo(n.getmarcaViatura()));
        tabela.addCell(verificarNulo(n.getmodeloViatura()));
        tabela.addCell(String.valueOf(n.getcodeViatura()));
        tabela.addCell(String.valueOf(n.getcilindragem()));
        tabela.addCell(String.valueOf(n.getprecoViatura()));
        tabela.addCell(verificarNulo(n.gettipoViatura()));
        tabela.addCell(verificarNulo(n.gtestrangeiro()));
        tabela.addCell(String.valueOf(n.getnumeroAnosForaPais()));
    }

    private void adicionarDadosRevendedor(PdfPTable tabela, Revendedor r) 
    {
        tabela.addCell(verificarNulo(r.getnomeCliente()));
        tabela.addCell(verificarNulo(r.getnumeroTelefone()));
        tabela.addCell(verificarNulo(r.getdataCompra()));
        tabela.addCell(verificarNulo(r.getestadoCompra()));
        tabela.addCell(verificarNulo(r.getmarcaViatura()));
        tabela.addCell(verificarNulo(r.getmodeloViatura()));
        tabela.addCell(String.valueOf(r.getcodeViatura()));
        tabela.addCell(String.valueOf(r.getcilindragem()));
        tabela.addCell(String.valueOf(r.getprecoViatura()));
        tabela.addCell(String.valueOf(r.getqtyViaturas()));
        tabela.addCell(verificarNulo(r.getnomeComercial()));
    }

    private void adicionarDadosEstado(PdfPTable tabela, Estado e)
    {
        tabela.addCell(verificarNulo(e.getnomeCliente()));
        tabela.addCell(verificarNulo(e.getnumeroTelefone()));
        tabela.addCell(verificarNulo(e.getdataCompra()));
        tabela.addCell(verificarNulo(e.getestadoCompra()));
        tabela.addCell(verificarNulo(e.getmarcaViatura()));
        tabela.addCell(verificarNulo(e.getmodeloViatura()));
        tabela.addCell(String.valueOf(e.getcodeViatura()));
        tabela.addCell(String.valueOf(e.getcilindragem()));
        tabela.addCell(String.valueOf(e.getprecoViatura()));
        tabela.addCell(String.valueOf(e.getqtyViaturas()));
        tabela.addCell(verificarNulo(e.getnomeIGovernal()));
        tabela.addCell(verificarNulo(e.getincluirManutencao()));
    }
    private String verificarNulo(String valor) 
    {
        if (valor != null) 
            return valor;
        return "";
    }

    private PdfPTable criarTabela(String[] titulos) 
    {
        PdfPTable tabela = new PdfPTable(titulos.length);
        try 
        {
            tabela.setWidthPercentage(100);
            for (int i = 0; i < titulos.length; i++) 
            {
                String titulo = titulos[i];
                PdfPCell cell = new PdfPCell(new Phrase(titulo, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8)));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(5);
                tabela.addCell(cell);
            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao criar tabela: " + e.getMessage());
        }
        return tabela;
    }
}