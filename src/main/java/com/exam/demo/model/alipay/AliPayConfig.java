package com.exam.demo.model.alipay;


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/**
 * 配置公共参数
 */
public final class AliPayConfig {
    public static String prefixHttp = "http://fkc7rn.natappfree.cc";
    /**
     * 应用号
     */
    public static String APP_ID = "";
    /**
     * 商户的私钥
     */
    public static String APP_PRIVATE_KEY = "";
    /**
     * 编码
     */
    public static String CHARSET = "utf-8";

    /**
     * 签名方式
     */
    public static String SIGN_TYPE = "RSA2";

    /**
     * 支付宝公钥
     */
    public static String ALIPAY_PUBLIC_KEY = "";

    /**
     * 支付宝网关地址
     */
    private static String GATEWAY = "https://openapi.alipay.com/gateway.do";
    /**
     * 成功付款回调
     */
    public static String PAY_NOTIFY = prefixHttp + "/pay/ali.html";
    /**
     * 支付成功回调
     */
    public static String REFUND_NOTIFY = prefixHttp + "/notify/alipay_refund";
    /**
     * 前台通知地址
     */
    public static String RETURN_URL = prefixHttp + "/return/alipay.html";
    /**
     * wap前台通知地址
     */
    public static String WAP_RETURN_URL = prefixHttp + "/return/alipay.html";
    /**
     * 参数类型
     */
    public static String PARAM_TYPE = "json";
    /**
     * 成功标识
     */
    public static final String SUCCESS_REQUEST = "TRADE_SUCCESS";
    /**
     * 交易关闭回调(当该笔订单全部退款完毕,则交易关闭)
     */
    public static final String TRADE_CLOSED = "TRADE_CLOSED";
    /**
     * 支付宝请求客户端入口
     */
    private volatile static AlipayClient alipayClient = null;

    /**
     * 不可实例化
     */
    private AliPayConfig() {
    }

    ;

    /**
     * 双重锁单例
     *
     * @return 支付宝请求客户端实例
     */
    public static AlipayClient getInstance() {
        if (alipayClient == null) {
            synchronized (AliPayConfig.class) {
                if (alipayClient == null) {
                    alipayClient = new DefaultAlipayClient(GATEWAY, APP_ID, APP_PRIVATE_KEY, PARAM_TYPE, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                }
            }
        }
        return alipayClient;
    }

}
