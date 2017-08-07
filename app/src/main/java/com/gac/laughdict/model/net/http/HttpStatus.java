package com.gac.laughdict.model.net.http;

/**
 * Created by gacmy
 */
public enum HttpStatus {
    CONTINUE(100,"Continue"),
    SWITCHING_PROTOCOLS(101,"Switching Protocols"),
    OK(200,"OK"),
    CREATED(201,"Created"),
    ACCEPTED(202,"Accepted"),
    NON_AUTHORIATIVE_INFOMATION(203,"Non-Authoriative Information"),
    NO_CONTENT(204,"No Content"),
    RESET_CONTENT(205,"Reset Content"),

    /*重定向
    * */
    MULTIPLE_CHOICES(300,"Multiple Choices"),
    MOVED_PERMANENTLY(301,"Moved Permanently"),
    FOUND(302,"Found"),
    SEE_OTHER(303,"See Other"),
    USE_PROXY(305,"Use Proxy"),
    UNUSED(306,"Unused"),
    TEMPORARY_REDIRECT(307,"Temporary Redirect"),
    BAD_REQUEST(400,"Bad Request"),
    PAYMENT_REQUIRED(402,"Payment Required"),
    FORBIDDEN(403,"禁止访问服务器"),
    NOT_FOUND(404,"服务器地址错误"),
    METHOD_NOT_ALLOWED(405,"服务器禁止此方法"),
    NOT_ACCEPTABLE(406,"Not Accetable"),
    REQUEST_TIMEOUT(408,"Request Timeout"),
    CONFLICT(409,"Conflict"),
    GONE(410,"Gone"),
    LENGTH_REQUIRED(411,"Length Required"),
    PAYLOAD_TOO_LARGE(413,"Playload Too Large"),
    URI_TOO_LONG(414,"Uri Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415,"Unsupported Media Type Server Error"),
    FAILED(417,"Failed Server Error"),
    UPGRADE_REQUIRED(426,"Upgrad Required"),

    INTERNET_SERVER_ERROR(500,"服务器异常"),
    NOT_IMPLEMENTED(501,"Not Implemented"),
    BAD_GATWAY(502,"网关错误"),
    SERVICE_UNAVAILABLE(503,"服务不可用"),
    GATEWAY_TIMEOUT(504,"网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505,"HTTP Version Not Supported"),
    CONNECT_TIMEOUT(1000,"超时连接"),
    NET_ERROR(2000,"网络不可用");



    private int mCode;
    private String mMessage;
    private HttpStatus(int code, String message){
        mCode = code;
        mMessage = message;
    }

    public static String getMessage(int val){
        for(HttpStatus status : values()){
            if(val == status.mCode){
                return status.mMessage;
            }
        }
        return null;
    }
    public static HttpStatus getValue(int value){
        for(HttpStatus status : values()){
            if(value == status.mCode){
                return status;
            }
        }
        return null;
    }
}
