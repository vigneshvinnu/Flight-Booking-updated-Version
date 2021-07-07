package com.capgemini.ticket.controller;

import com.capgemini.ticket.model.Passenger;
import com.capgemini.ticket.model.Ticket;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableFooter;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import com.itextpdf.text.Image;
import java.util.logging.Logger;

public class GeneratePdfReport {

    public static ByteArrayInputStream pdfReport(Ticket ticket) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(0f);
            table.setSpacingAfter(0f);



            PdfPCell cell1 = new PdfPCell(new Phrase("Ticket Booked"));
            cell1.setColspan(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setPadding(10.0f);
            cell1.setBackgroundColor(new BaseColor(140, 221, 8));

            table.addCell(cell1);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("TicketId", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell.setPadding(5.0f);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase(String.valueOf(ticket.getTicketId())));
            hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell.setPadding(5.0f);
            table.addCell(hcell);


            PdfPCell hcell1;
            hcell1 = new PdfPCell(new Phrase("FlightId", headFont));
            hcell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell1.setPadding(5.0f);
            table.addCell(hcell1);

                hcell1 = new PdfPCell(new Phrase(ticket.getFlightId().toString()));
                hcell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hcell1.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell1.setPadding(5.0f);
                table.addCell(hcell1);

            PdfPCell hcell2;

            hcell2 = new PdfPCell(new Phrase("Source", headFont));
            hcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell2.setPadding(5.0f);
            table.addCell(hcell2);


            hcell2 = new PdfPCell(new Phrase(String.valueOf(ticket.getFlightTakeOffStation())));
            hcell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell2.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell2.setPaddingRight(5);
            hcell2.setPadding(5.0f);
            table.addCell(hcell2);

            PdfPCell hcell3;

            hcell3 = new PdfPCell(new Phrase("Takeoff Date", headFont));
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell3.setPadding(5.0f);
            table.addCell(hcell3);


            hcell3 = new PdfPCell(new Phrase(String.valueOf(ticket.getDepartureDate())));
            hcell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell3.setPaddingRight(5);
            hcell3.setPadding(5.0f);
            table.addCell(hcell3);

            PdfPCell hcell4;

            hcell4 = new PdfPCell(new Phrase("Takeoff Time", headFont));
            hcell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell4.setPadding(5.0f);
            table.addCell(hcell4);


            hcell4 = new PdfPCell(new Phrase(String.valueOf(ticket.getDepartureTime())));
            hcell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell4.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell4.setPaddingRight(5);
            hcell4.setPadding(5.0f);
            table.addCell(hcell4);

            PdfPCell hcell5;

            hcell5 = new PdfPCell(new Phrase("Destination", headFont));
            hcell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell5.setPadding(5.0f);
            table.addCell(hcell5);



            hcell5 = new PdfPCell(new Phrase(ticket.getFlightLandingStation()));
            hcell5.setPaddingLeft(5);
            hcell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell5.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell5.setPadding(5.0f);
            table.addCell(hcell5);

            PdfPCell hcell6;

            hcell6 = new PdfPCell(new Phrase("ArrivalDate", headFont));
            hcell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell6.setPadding(5.0f);
            table.addCell(hcell6);



            hcell6 = new PdfPCell(new Phrase(String.valueOf(ticket.getArrivalDate())));
            hcell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell6.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell6.setPaddingRight(5);
            hcell6.setPadding(5.0f);
            table.addCell(hcell6);

            PdfPCell hcell7;

            hcell7 = new PdfPCell(new Phrase("ArrivalTime", headFont));
            hcell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell7.setPadding(5.0f);
            table.addCell(hcell7);


            hcell7 = new PdfPCell(new Phrase(String.valueOf(ticket.getArrivalTime())));
            hcell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell7.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell7.setPaddingRight(5);
            hcell7.setPadding(5.0f);
            table.addCell(hcell7);

            PdfPCell hcell8;

            hcell8 = new PdfPCell(new Phrase("price", headFont));
            hcell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell8.setPadding(5.0f);
            table.addCell(hcell8);


            hcell8 = new PdfPCell(new Phrase(String.valueOf(ticket.getTicketAmount())));
            hcell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            hcell8.setHorizontalAlignment(Element.ALIGN_LEFT);
            hcell8.setPaddingRight(5);
            hcell8.setPadding(5.0f);
            table.addCell(hcell8);

            PdfWriter.getInstance(document, out);
            document.open();
            Image image=Image.getInstance("logo.png");

            image.scaleAbsolute(50f, 50f);
            document.add(image);
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            Logger.getLogger(GeneratePdfReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}

