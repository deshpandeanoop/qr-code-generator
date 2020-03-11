package com.github.qrcode.generator.service;

import java.awt.image.BufferedImage;

public interface IQRCodeGenerateService {

    BufferedImage generateQRCode(String content);
}
