package com.darkness.splitdocument.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdfSplitDto {
    private String sourcePdfPath;
    private String outputPdfPrefix;
    private int pagesPerFile;
}
