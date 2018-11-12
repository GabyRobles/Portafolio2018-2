/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupon;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author solita
 */
public class Pdf {
        //atributos de la letra del Archivo PDF Tipo de letra/tamaño/fuente
    private Font fuenteBold = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER, 8, Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER, 8, Font.ITALIC);
    

    


    public void generarPDF(String header, String info, String footer, String rutaImagen, String salida, String codigo) {
        try {
            //margenes 36,36,10,10 documento
            Document document = new Document(PageSize.A4, 36, 36, 10, 10);//tamaño de salida del documento A4
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream(salida));//salida del documento
            document.open();//abrimos el documento para ingresar los datos
            document.add(getHeader(header));//titulo del documento
            document.add(new Phrase(Chunk.NEWLINE));//salto de linea
            document.add(new Phrase(Chunk.NEWLINE));//salto de linea
            Image imagen = Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(100, 100);//tamaño de imagen
            imagen.setAlignment(Element.ALIGN_CENTER);//imagen centrada
            document.add(imagen);//guardamos la imagen
            document.add(getInfo(info));//guardamos la info del ticket
            document.add(new Phrase(Chunk.NEWLINE));//salto de linea
            document.add(new Phrase(Chunk.NEWLINE));//salto de linea
            document.add(getCodigoBarra(document, pw, codigo));
            document.add(new Phrase(Chunk.NEWLINE));//salto de linea
            document.add(new Phrase(Chunk.NEWLINE));//salto de linea             
            document.add(getFooter(footer));//guardamos el footer del ticket
            document.close();//cerramos el PDF            

        } catch (DocumentException | IOException e) {
           
        }
    }

    //cabecera del archivo
    private Paragraph getHeader(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);//E texto estara alineado
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }

    //cuerpo del PDF
    private Paragraph getInfo(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED_ALL);//El texto estara justificado
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }

    //foote del archivo
    private Paragraph getFooter(String texto) {
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);//El texto estara alineado a la derecha
        c.append(texto);
        c.setFont(fuenteItalic);
        p.add(c);
        return p;
    }

    private Image getCodigoBarra(Document document, PdfWriter pw, String codigo) {
        PdfContentByte cimg = pw.getDirectContent();//creamos un contenedor de PDF para poner el codigo
        Barcode128 barcode128 = new Barcode128();//estilo de codigo de barra
        barcode128.setCode(getFormatoCodigo(codigo));//ingresamos el codigo que pondremo en el codigo de barra sera el ID del cupón
        barcode128.setCodeType(Barcode128.CODE128);//formato del codigo de barra
        barcode128.setTextAlignment(Element.ALIGN_CENTER);//lo alineamos em el centro

        //imagen del codigo de barra
        Image image = barcode128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);//color,tipo y Forma codigo de barra
        //posicion del codigo de barra centrado y de tamaño 50 px
        float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - 0 / image.getWidth() * 50));
        image.scalePercent(scaler);//tamaño  de imagen
        image.setAlignment(Element.ALIGN_CENTER);//centrado del codigo
        return image;
    }
    //formato de codigo de barras

    private String getFormatoCodigo(String numero) {
        NumberFormat formato = new DecimalFormat("0000000");
        return formato.format((numero != null) ? Integer.parseInt(numero) : 0000000);

    }


}

