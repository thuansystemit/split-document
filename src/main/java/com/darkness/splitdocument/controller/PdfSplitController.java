package com.darkness.splitdocument.controller;
import com.darkness.splitdocument.dto.PdfSplitDto;
import com.darkness.splitdocument.services.PdfSplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("split")
public class PdfSplitController {

    @Autowired
    private PdfSplitService pdfSplitService;

    @PostMapping
    public String splitPdf(@RequestBody PdfSplitDto pdfSplitDto) {
        try {
            pdfSplitService.splitPdf(pdfSplitDto.getSourcePdfPath(),
                    pdfSplitDto.getOutputPdfPrefix(), pdfSplitDto.getPagesPerFile());
            return "PDF split successfully.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error splitting PDF: " + e.getMessage();
        }
    }
}
