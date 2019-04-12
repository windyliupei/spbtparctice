package com.windy.codepractice.mvc.service;

import com.itextpdf.text.DocumentException;
import com.windy.Common.pdf.PdfReplacer;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ItextPDFService {

    public void writePdf(String pdfPath,String pdfOutFile) throws IOException, DocumentException {

        PdfReplacer textReplacer = new PdfReplacer(pdfPath);
        textReplacer.replaceText("123456", "654321001223",5);
        textReplacer.toPdf(pdfOutFile);
    }
}
