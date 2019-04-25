package com.bookstore.controller;

import com.bookstore.common.BaseResponse;
import com.bookstore.domain.CodeEntity;
import com.bookstore.response.CodeResp;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/20 10:17
 * @Version 1.0.0
 */
@Controller
@Api(tags = "验证码模块")  //swagger分类标题注解
public class KaptchaController {
    @Resource
    private Producer captchaProducer;

    @ApiOperation(value = "获取后台生成的验证码图片(并把数据存到session)")
    @RequestMapping(value = "/verification", method = RequestMethod.GET)
    public ModelAndView verification(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    @ApiOperation(value = "前端验证码与后端session中的数据比较")
    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<CodeResp> checkCode(HttpServletRequest request, @RequestBody CodeEntity codeEntity) {
        String startCode = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println(startCode+"......");
        CodeResp codeResp = new CodeResp();
        if(startCode.equals(codeEntity.getCode())){
            codeResp.setSuccess("1");
        }else{
            codeResp.setSuccess("0");
        }
        return new BaseResponse(codeResp);
    }
}
