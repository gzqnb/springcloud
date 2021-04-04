package com.atguigu.gulimall.order.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.atguigu.gulimall.order.vo.PayVo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "2021000117616675";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public  String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQD3AqhZ4zQUyHfWY/pVUPuYySqTwRafnONrJnusdvgEqRdyq7T5jRIMEpuAdRe+Sn4i+3ztD2I0twLwLofdDVDnciVsm3A6RncCQzaLu6uswUa9JQzvIF+uIg99bcCsjNpeG3qOkxbSSnoR+2xcoVJZBj1Zqk9gFzu4ZKYH+dAeQ1dF35vkGZfUOSqtZg0XAYqMJD6c+GmDBvlTYSClGpLl7MuOURYNiGzY09fZ9Y/qTnc2rUiZlZUZfhowq5+mdeoNsblxbnlIG8ru8mzzRcrnTPusjrzZ9BSDZdqrL4iyxkQ+9If1CTCuLRcn/4vHF50/7uAZUK6cgNmANtrgY2ebAgMBAAECggEAeFdSH+DiidGVGN1Co/g9a5VuaefjlsW/wn9QN5kKgnLDGrnvBLmm9jzGh9IETFBMncx6c6BQDzCufMeep6KKLQhelUgxaCLWbkLCu1cmb5cGWLZJU+Mo2lR7yXcELMy+wqSOlBGzR6bDTCl7BLIPxZGVqC6iV0Vach6PCUm7DFJ7jQWsr+GV003HMNhVapCErZ6L16B6pkvrV5+ujLKONHNxlnM21mBP3aJX+Mh8ilFFOCPXQJNC04ya3tWCAE3S8G9Hst0KdsrF4LxWoDr/RnVqM80gIw0edeceZ4p3VYkZwd309djLn0ZJuumK3iJLtoqShHUw/O9re0ZA/05sAQKBgQD/6W/JfsNcXD7l4sB/dphaMKAbARunek5eyy/4K4JqDNSj63fH1yhM4yvD08XMbeDXjdvaQC2h4gBehaWnu/SZFSGwHFLjkD05Kxerr1Kt+0TXk68u/+L7yz7feOJ0SBeh5pjMlP0FbkXkTHFlmpryDIrsfUcBSwbwjMZl+sKdmwKBgQD3GG+l1icphpbWDYr8+n3ExAKds80GWv6/BEBHPHdFeLMEo6sSmGyAm0EZ0/m6qPfzRg//rSXS+o99NsdDOog3uInxHhmLsoUHhKwvSftoRw1fDumb4axx9QjjVIvNzdWtrrx75mEpabmBV5ineKN9+1Ha39i5j3drzb/xXFP+AQKBgGdxebFOHzPnSbls9fjP/HeAbkdcJEyHYMRqh4JePAIYG6AC31EVRIIH1bn7kVm4FImtGvBWvttP2mxaw4JQtGdopkxktpCrzkOcip3oaZhQGBy34rkx0BONrWVxnL/6ICteZedUVg5q66+DwtaaLwWmUkWTwi7gn/Z+QPgZ667/AoGAD30MooyF7+hr1AcNS0Y4U/klYNVAaMGTbk3J6a00nLowHn5T3tqHEpiowAG1ianFwQ4HOrOTx2HFVMf2PZSRrUx3+RE18LfD9vCuCljM1YB+qhK5OfgvYwVFBVrrWH8qgbSORAXw2TOzWRQwkW7ScLcsLlgRsa/4gF1pRqvO6AECgYASeuun0cLge0h2rNIEU+l/0qfAAfNoGsCWohgouAglMdsnMfHLisPqgRDYyA2xvusyb/Lg19t1XWZsrrrAIAEVIOZpDrPLNIMGCceil2LV4dOqIN1WLLoPbfkPqlu9XgRjaCJTuRyUOYk5hO9TFrGnIOQ7i/6si1r+VCjs45vEKg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1i96RWXLoCT1JD10y9/U99DdZvg34CTiH33A9HnEVYddas23Qi/ldgTRecipoq+NEgQcNZPpcIHsL3v32/l6soE4yeLjrY7c7+FLxz09iXm6+c5Eg7IZaWuX1ipj6L8CnCC4hLHm/BxLZT3mA9NuLVJW6xo2r2bBdadeSZLsMU8pDAyVP9u31U1cS9gp+8AFxN9WOzoQy2JArW5GQVdckoeF047XMuiBHlNfLG/V6XvQP8j01uzz037q2OiNuA20KmqQkwSQF43Ldawgl7hFSnJVJ9ifhocoABiVcZlO1pXwyLsuujTuyL7KjzFLtw8Tq4vh+kGV7DaveC+K1te8oQIDAQAB";

    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url = "http://z2ctuytzlp.52http.net/payed/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url = "http://member.gulimall.com/memberOrder.html" ;

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    private String timeout = "30m";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";


    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+timeout+"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        System.out.println("支付宝的响应："+result);

        return result;

    }
}
