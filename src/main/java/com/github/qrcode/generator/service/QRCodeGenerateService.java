package com.github.qrcode.generator.service;

import com.github.qrcode.generator.exceptions.QRCodeGenerationFailedException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class QRCodeGenerateService implements IQRCodeGenerateService{
    private final QRCodeWriter qrCodeWriter;

    public QRCodeGenerateService(QRCodeWriter qrCodeWriter) {
        this.qrCodeWriter = qrCodeWriter;
    }

    @Override
    public BufferedImage generateQRCode(String content) {
        try{
            return MatrixToImageWriter.toBufferedImage(qrCodeWriter.encode(content,
                    BarcodeFormat.QR_CODE, 200, 200));
        }catch (Exception exception){
            throw new QRCodeGenerationFailedException(exception, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
