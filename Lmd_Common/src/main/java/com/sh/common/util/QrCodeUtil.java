package com.sh.common.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrCodeUtil {

    //生成二维码 返回缓存图片
    public static BufferedImage createQrCode(String content,int width){
        //创建 属性
        Map<EncodeHintType,Object> map = new HashMap<>();
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN,1);
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");

        //生成矩阵  参数说明：
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(
                    content, BarcodeFormat.QR_CODE,width,width,map);
            //配色
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000000,0XFFFFFFFF);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix,config);
            return image;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    //生成二维码 存储到指定文件中  返回绝对路径
    public static String qrcodeFile(String content, int width, File file){
        BufferedImage image = createQrCode(content, width);
        if (image != null){
            try {
                ImageIO.write(image,"png",file);
                return file.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
