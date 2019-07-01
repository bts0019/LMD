package com.sh.lmd.api.UserPowerApi.controller;

import com.sh.common.config.ProjectConfig;
import com.sh.common.util.QrCodeUtil;
import com.sh.common.vo.R;
import com.sh.lmd.api.UserPowerApi.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @GetMapping("invite/findMyInvite.do")
    public R findMyInvite(HttpServletRequest request){
        return inviteService.findMyInvite(request.getHeader(ProjectConfig.TOKENHEAD));
    }

    @GetMapping("invite/findInviteUser.do")
    public R findInviteUser(HttpServletRequest request){
        return inviteService.findInviteUser(request.getHeader(ProjectConfig.TOKENHEAD));
    }

    @GetMapping("invite/invite.do")
    public void findInvite(HttpServletResponse response) throws IOException {
        //自定义二维码内容
//        BufferedImage image = (BufferedImage)inviteService.findInvite(response).getData();
//        ImageIO.write(image,"png",response.getOutputStream());
        BufferedImage image= QrCodeUtil.createQrCode("123123",400);
        ImageIO.write(image,"png",response.getOutputStream());
    }
}
