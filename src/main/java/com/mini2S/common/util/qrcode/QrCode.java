package com.mini2S.common.util.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mini2S.common.enums.ImageEnum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class QrCode {
    public static Optional<String> createQRCodeImage(String directory, String fileName, String url) {
        String name = fileName + ".png";
        try {
            File file = null;
            // qr코드 이미지를 저장할 디렉토리 지정
            file = new File("D:\\dWorkSpace\\qr_code\\qr_image");
            if (!file.exists()) {
                file.mkdirs();
            }

            // qr코드 인식시 이동할 url 주소
            String codeUrl = new String(url.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

            // QR 코드(URL + 바코드 형태 + 사이즈)
            BitMatrix bitMatrix = new QRCodeWriter().encode(codeUrl,
                                                            BarcodeFormat.QR_CODE,
                                                            ImageEnum.QRCODE_WIDTH.getValue(),
                                                            ImageEnum.QRCODE_HEIGHT.getValue());

            // QR 코드 색상 지정(2종류)
            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(
                                                            ImageEnum.QRCODE_COLOR.getValue(),
                                                            ImageEnum.QRCODE_BG_COLOR.getValue());

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);
            
            // 파일 생성
            ImageIO.write(bufferedImage, "png", new File("D:\\dWorkSpace\\qr_code\\qr_image\\" + name));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
