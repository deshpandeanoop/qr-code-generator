package com.github.qrcode.generator.controller;

import com.github.qrcode.generator.request.QRCodeGenerateRequest;
import com.github.qrcode.generator.service.IQRCodeGenerateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/qrCodes")
public class QRCodeGenerateController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeGenerateController.class);
    private final IQRCodeGenerateService qrCodeGenerateService;

    public QRCodeGenerateController(IQRCodeGenerateService qrCodeGenerateService) {
        this.qrCodeGenerateService = qrCodeGenerateService;
    }

    @PostMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generateQRCode(@RequestBody QRCodeGenerateRequest request){
        LOGGER.info("Generating QRCode for {}", request.getContent());
        return ResponseEntity.ok(qrCodeGenerateService.generateQRCode(request.getContent()));
    }
}
