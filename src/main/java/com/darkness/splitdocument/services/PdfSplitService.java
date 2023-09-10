package com.darkness.splitdocument.services;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PdfSplitService {

    public void splitPdf(String sourcePdfPath, String outputPdfPrefix, int pagesPerFile) throws IOException {
        try (PDDocument document = PDDocument.load(new File(sourcePdfPath))) {
            int pageCount = document.getNumberOfPages();

            for (int i = 0; i < pageCount; i += pagesPerFile) {
                int endPage = Math.min(i + pagesPerFile - 1, pageCount - 1);

                PDDocument newDocument = new PDDocument();
                for (int j = i; j <= endPage; j++) {
                    newDocument.addPage(document.getPage(j));
                }

                String outputPdfPath = outputPdfPrefix + "/after" + (i / pagesPerFile + 1) + ".pdf";
                newDocument.save(outputPdfPath);
                newDocument.close();
            }
        }
    }
}
