package com.gac.laughdict.model.net;


import com.gac.laughdict.BuildConfig;

/**
 * Created by gacmy on 2017/3/17.
 */
public class URLConfig {
    //public static String TEST_URL = "http://115.29.185.47:9999/hlt/ws/";
//    public static String BASE_URL = "http://192.168.1.100/hlt/ws/";
    // public static String TEST_URL = "http://192.168.1.193/hlt/ws/";
    //public static String TEST_URL ="http://120.25.81.10/hlt/ws/";
    public static String BASE_URL = "http://115.29.185.47:9999/hlt/ws/";
    public static String TEST_URL = "http://115.29.185.47:9999/hlt/ws/";
    //public static String TEST_URL = "http://120.25.81.10/hlt/ws/";
   // public static String RELEASE_URL = "http://www.huliangtong.cn/hlt/ws/";
    public static String RELEASE_URL = "http://www.huliangtong.com/hlt/ws/";
    private static URLConfig intance = new URLConfig();

    //获取支付方式
    private String PAYWAY = "appPayType/get";
    //首页轮播图接口
    private String BANNER_IMGS = "apiAdvert/list";
    //请求热门分类
    private String HOT_CATEGORY = "system/getCategory";
    //请求最热供应
    public static String HOT_PROVIDE = "supplies/list";
    //我要买
    public static String BUY = "supplies/list";
    //全国行情
    public static String COUNTRY_MARKET = "quotation/home";

    //请求全国地址
    public static String COUNTRY_AREA = "area/producing";

    //供应首页接口
    public static String PROVIDE = "provision/home";
    //我的供应
    public static String MYPROVIDE="provision/mine";
    //下架
    public static String OFFSHELVE="provision/end";
    //上架
    public static String SHELVE = "provision/start";
    //删除我的供应
    public static String PROVIDE_DEL = "provision/delete";
    //重新发布
    public static String AGAIN = "provision/again";
    //单位获取1.数量单位 2.价格单位 3.包装规格单位 4.等级 5.运输方式 6.付款方式 7.品牌 8.报价方式
    public static String UNIT_GET = "unit/get";

    //type = 1压缩图  type =2 原图
    public static String UPLOAD = "upload/uploads";
    //获取糯米分类的接口
    public static String CATEGORY = "commodity/category/get";
    //发布我的供应
    public static String RELEASE_PROVIDE = "provision/publish";

    //发布采购
    public static String RELEASE_PURCHASE= "purchase/publish";

    //企业信息
    public static String COMPANYINFO = "enterprise/detail";

    //企业类型
    public static String COMPANYTYPE = "enterprise/type";
    //编辑企业资料
    public static String EDITCOMPANY = "enterprise/edit";

    //供应列表
    public static String PROVIDE_LIST ="provision/list";
    //供应详情
    public static String PROVIDE_DETAIL = "provision/look";
    //拿样
    public static String SAMPLE = "sample/request";
    //我的拿样
    public static String MY_SAMPLE = "sample/list";
    //发布意向单
    public static String RELEASE_OPION = "intention/publish";

    //市场行情
    public static String MARKET_DETAIL= "quotation/detail";

    //我的报价
    public static String MINE_PRICE = "quote/mine";
    //采购详情
    public static String PURCHASE_DETAIL = "purchase/look";

    //已报价详情
    public static String OFFERED_PRICE_DETAIL = "quote/detail";
    //发布报价
    public static String RELEASE_PRICE = "quote/publish";
    //实力企业列表
    public static String PRIOR_COM_LIST = "enterprise/list";
    //企业详情
    public static String COMPANY_DEAIL = "enterprise/look";
    //采购首页
    public static String PURCHASE = "purchase/home";

    //采购大厅
    public static String PURCHASE_HOME = "purchase/list";

    //我的采购
    public static String PURCHASE_MINE = "purchase/mine";
    //企业认证
    public static String ENTER_AUTH = "enterprise/authentication";
    //验证码接口
    public static String USER_CODE = "user/code";
    //注册
    public  static String REGISTER = "user/register";
    //登陆
    public static String LOGIN = "login";
    //修改密码
    public static String UPDATE_PWD = "user/updatePsw";
    //mine home
    public static String MINE_HOME = "mine/home";
    //我的意向单
    public static String MINE_OPION ="intention/list";
    //发布物流
    public static String RELEASE_TRANSFER = "logistics/request";
    //发布买梁
    public static String RELEASE_BUYFOOD = "buy/request";
    //发布卖梁
    public static String RELEASE_SELL = "sell/request";

    //我的服务单
    public static String MY_SERVICE = "mine/services";
    //查看服务单
    public static String LOOK_SERVICE= "mine/look";
    //消息中心
    public static String CENTER_MSG ="message/home";

    //消息列表
    public static String MSGLIST = "message/list";
    //意向单详情
    public static String INTETION_DETAIL = "intention/look";

    //新品上市
    public static String NEW_PRODUCT = "online/home";

    //新品上市详情
    public static String NEW_PRODUCT_DETAIL = "online/detail";

    //个人资料
    public static String USER_INFO = "user/info";
    //我的收藏
    public static String MY_COLLECT ="favorites/list";
    //采购详情的 报价
    public static String PURCHASE_PRICE= "quote/list";

    //采购详情
    public static String PURCHASE_PRICE_DETAIL="quote/look";

    //更新个人资料
    public static String UPDATE_INFO = "user/updateInfo";
    //拿样详情
    public static String SAMPLE_DETAIL = "sample/look";
    //收藏
    public static String COLLECT = "favorites/publish";

    //取消收藏
    public static String CANCLE_COLLECT = "favorites/cancel";
    //供应搜索
    public static String SEARCH = "provision/search";

    //产地直供
    public static String PLACE_HOME = "origin/home";
    //查看产地直供
    public static String ORIGIN_LOOK = "origin/look";
    //
    public static String FEEDBACK = "feedback/submit";
    public static String ORIGIN_MORE = "origin/detail";
    //发现模块
    public static String FIND = "news/home";

    ////新闻
    public static String NEWS = "news/list";

    //删除意向单接口
    public static String DEL_INTENTION = "intention/delete";
    //删除服务单
    public static String DEL_SERVICE ="mine/delete";

    //修改供应
    public static String UPDATE_PROVIDE = "provision/getUpdateDetail";
    //修改价格
    public static String UPDATE_PRICE = "provision/getUpdatePrice";
    //
    public static String UPDATE_PRICE_1= "provision/updatePrice";

    //资讯详情请
    public static String NEWS_DETAIL = "news/look";
    public static String HELP_DETAIL = "help/look";
    //结束报价
    public static String END_PRICE ="purchase/end";
    //获取原图
    public static String YUANTU = "image/get";

    //删除收藏
    public static String DEL_COLLECT = "favorites/delete";
    //取消报价
    public static String CANCLE_PRICE ="quote/delete";
    //删除拿样
    public static String DEL_SAMPLE ="sample/delete";
    //清空收藏
    public static String EMPTY_COLLECT = "favorites/empty";
    //最新版本
    public static String NEW_VERSION = "version/get";
    //获取浏览次数
    public static String LOOK_TIME = "provision/lookTimes";
    //帮助中心
    public static String HELP_CENTER = "help/home";

    //阅读消息
    public static String READ_MSG = "message/look";
    //打电话
    public static String CALL_PHONE = "call/phone";

    //物流货品分类
    public static String LOGISTICS_CLASS = "logistics/commodity/category/list";

    //删除消息
    public static String DEL_MSG = "message/delete";
    //清空消息
    public static String EMPTY_MSG = "message/empty";

   //热门搜索
    public static String HOT_SEARCH = "search/hot";

    //广告页
    public static String AD_START = "advert/start";

    //认证信息获取
    public static String AUTH_INFO = "enterprise/qualification/info";

    private URLConfig(){
        if (BuildConfig.IS_DEBUG){
            BASE_URL = TEST_URL;
        }else{
            BASE_URL = RELEASE_URL;
        }
    }
    public static URLConfig getInstance(){
        return intance;
    }


    //获取支付方式
    public String getPayWay(){
        return new StringBuilder(BASE_URL+PAYWAY).toString();
    }
    //获取轮播图
    public String getBanners(){
        return new StringBuilder(BASE_URL+BANNER_IMGS).toString();
    }
    //获取热门分类
    public String getHotCategory(){
        return new StringBuilder(BASE_URL+HOT_CATEGORY).toString();
    }

    //获取最热供应
    public String getHotProvide(){
        return new StringBuilder(BASE_URL+HOT_PROVIDE).toString();
    }

    //我要买
    public String getBuy(){
        return new StringBuilder(BASE_URL+HOT_PROVIDE).toString();
    }
    //我要买
    public String getCountryMarket(){
        return new StringBuilder(BASE_URL+COUNTRY_MARKET).toString();
    }
    //供应首页接口
    public String getProvide(){
        return new StringBuilder(BASE_URL+PROVIDE).toString();
    }
    //获取全国地址
    public String getCountryArea(){
        return new StringBuilder(BASE_URL+COUNTRY_AREA).toString();
    }

    //我的供应
    public String getMyProvide(){
        return new StringBuilder(BASE_URL+MYPROVIDE).toString();
    }
    //下架
    public String getOffShelve(){
        return new StringBuilder(BASE_URL+OFFSHELVE).toString();
    }
    //上架
    public String getShelve(){
        return new StringBuilder(BASE_URL+SHELVE).toString();
    }

    //删除我的上架
    public String getDelProvide(){
        return new StringBuilder(BASE_URL+PROVIDE_DEL).toString();
    }
    //重新发布
    public String getAGAIN(){
        return new StringBuilder(BASE_URL+AGAIN).toString();
    }
    //获取单位
    public String getUnit(){
        return new StringBuilder(BASE_URL+UNIT_GET).toString();
    }

    //上传图片
    public String getUpload(){
        return new StringBuilder(BASE_URL+UPLOAD).toString();
    }
    //获取糯米分类
    public String getCategory(){
        return new StringBuilder(BASE_URL+CATEGORY).toString();
    }

    //发布我的供应
    public String getReleaseProvide(){
        return new StringBuilder(BASE_URL+RELEASE_PROVIDE).toString();
    }
    //发布采购
    public String getReleasePurchase(){
        return new StringBuilder(BASE_URL+RELEASE_PURCHASE).toString();
    }
    //获取企业信息
    public static String getCompanyInfo(){
        return new StringBuilder(BASE_URL+COMPANYINFO).toString();
    }

    //获取企业类型
    public static String getCompanyType(){
        return new StringBuilder(BASE_URL+COMPANYTYPE).toString();
    }
    //编辑资料
    public static String getEditCompany(){
        return new StringBuilder(BASE_URL+EDITCOMPANY).toString();
    }
    //获取供应列表
    public static String getProvideList(){
        return new StringBuilder(BASE_URL+PROVIDE_LIST).toString();
    }
    //获取供应详情
    public static String getProvideDetail(){
        return new StringBuilder(BASE_URL+PROVIDE_DETAIL).toString();
    }
    //拿样
    public static String getSample(){
        return new StringBuilder(BASE_URL+SAMPLE).toString();
    }

    //发布意向单
    public static String getReleaseOpion(){
        return new StringBuilder(BASE_URL+RELEASE_OPION).toString();
    }

    //市场行情
    public static String getMarketDetail(){
        return new StringBuilder(BASE_URL+MARKET_DETAIL).toString();
    }
    //我的报价
    public static String getMyPrice(){
        return new StringBuilder(BASE_URL+MINE_PRICE).toString();
    }
    //采购详情
    public static String getPurchaseDetail() {
        return new StringBuilder(BASE_URL + PURCHASE_DETAIL).toString();
    }
    //发布报价
    public static String getReleasePrice(){
        return new StringBuilder(BASE_URL + RELEASE_PRICE).toString();
    }
    //实力企业列表
    public static String getPriorCompanyList(){
        return new StringBuilder(BASE_URL + PRIOR_COM_LIST).toString();
    }

    //实力企业详情
    public static String getComppanyDetail(){
        return new StringBuilder(BASE_URL + COMPANY_DEAIL).toString();
    }
    //采购首页
    public static String getPurchase(){
        return new StringBuilder(BASE_URL + PURCHASE).toString();
    }

    //采购大厅
    public static String getPurchaseHome(){
        return new StringBuilder(BASE_URL + PURCHASE_HOME).toString();
    }
    //我的 采购
    public static String getMinePurchase(){
        return new StringBuilder(BASE_URL + PURCHASE_MINE).toString();
    }
    //企业认证
    public static String getEnterAuth(){
        return new StringBuilder(BASE_URL + ENTER_AUTH).toString();
    }
    //获取验证码
    public static String getCode(){
        return new StringBuilder(BASE_URL + USER_CODE).toString();
    }
    //注册
    public static String getRegister(){
        return new StringBuilder(BASE_URL + REGISTER).toString();
    }
    //登陆
    public static String getLogin(){
        return new StringBuilder(BASE_URL + LOGIN).toString();
    }

    //我的页面接口
    public static String getMine(){
        return new StringBuilder(BASE_URL + MINE_HOME).toString();
    }
    //我的意向单
    public static String getMineOpion(){
        return new StringBuilder(BASE_URL + MINE_OPION).toString();
    }

    //发送物流
    public static String getReleaseTransfer(){
        return new StringBuilder(BASE_URL + RELEASE_TRANSFER).toString();
    }
    //发布买粮
    public static String getReleaseBuy(){
        return new StringBuilder(BASE_URL + RELEASE_BUYFOOD).toString();
    }
    //发布卖梁
    public static String getReleaseSell(){
        return new StringBuilder(BASE_URL +RELEASE_SELL).toString();
    }

    //我的服务单
    public static String getMyService(){
        return new StringBuilder(BASE_URL +MY_SERVICE).toString();
    }
    //查看服务单
    public static String getLookService(){
        return new StringBuilder(BASE_URL +LOOK_SERVICE).toString();
    }
    //消息中新
    public static String getMsgCenter(){
        return new StringBuilder(BASE_URL +CENTER_MSG).toString();
    }
    //消息列表

    public static String getMsgList(){
        return new StringBuilder(BASE_URL +MSGLIST).toString();
    }
    //意向单详情
    public static String getIntetionDetail(){
        return new StringBuilder(BASE_URL +INTETION_DETAIL).toString();
    }
    //新品上市
    public static String getNewProduct(){
        return new StringBuilder(BASE_URL +NEW_PRODUCT).toString();
    }
    //新品上市详情
    public static String getNewProductDetail(){
        return new StringBuilder(BASE_URL +NEW_PRODUCT_DETAIL).toString();
    }

    //获取去个人资料
    public static String getUserInfo(){
        return new StringBuilder(BASE_URL +USER_INFO).toString();
    }
    //我的收藏列表
    public static String getMyCollect(){
        return new StringBuilder(BASE_URL +MY_COLLECT).toString();
    }
    //采购详情的报价
    public static String getPurchasePrice(){
        return new StringBuilder(BASE_URL +PURCHASE_PRICE).toString();
    }

    //采购详情
    public static String getPurchasePriceDtail(){
        return new StringBuilder(BASE_URL +PURCHASE_PRICE_DETAIL).toString();
    }
    //更新个人资料
    public static String getUpdateInfo(){
        return new StringBuilder(BASE_URL +UPDATE_INFO).toString();
    }
    //我的拿样
    public static String getMySample(){
        return new StringBuilder(BASE_URL +MY_SAMPLE).toString();
    }
    //拿样详情
    public static String getSampleDetail(){
        return new StringBuilder(BASE_URL +SAMPLE_DETAIL).toString();
    }
    //收藏
    public static String getCollect(){
        return new StringBuilder(BASE_URL +COLLECT).toString();
    }
    //取消收藏
    public static String getCancelCollect(){
        return new StringBuilder(BASE_URL +CANCLE_COLLECT).toString();
    }
    public static String getSearch(){
        return new StringBuilder(BASE_URL +SEARCH).toString();
    }
    //产地直供
    public static String getPlaceHome(){
        return new StringBuilder(BASE_URL +PLACE_HOME).toString();
    }
    //
    public static String getOriginLook(){
        return new StringBuilder(BASE_URL +ORIGIN_LOOK).toString();
    }

    public static String getOriginMore(){
        return new StringBuilder(BASE_URL +ORIGIN_MORE).toString();
    }
    public static String getUpdatePwd(){
        return new StringBuilder(BASE_URL +UPDATE_PWD).toString();
    }
    public static String getFeedBack(){
        return new StringBuilder(BASE_URL +FEEDBACK).toString();
    }
    //发现
    public static String getFind(){
        return new StringBuilder(BASE_URL +FIND).toString();
    }
    //新闻
    public static String getNews(){
        return new StringBuilder(BASE_URL +NEWS).toString();
    }

    //删除意向单
    public static String getDelIntention(){
        return new StringBuilder(BASE_URL +DEL_INTENTION).toString();
    }
    public static String getDelService(){
        return new StringBuilder(BASE_URL +DEL_SERVICE).toString();
    }

    public static String getUpdateProvide(){
        return new StringBuilder(BASE_URL +UPDATE_PROVIDE).toString();
    }
    public static String getUpdatePrice(){
        return new StringBuilder(BASE_URL +UPDATE_PRICE).toString();
    }
    public static String updatePrice(){
        return new StringBuilder(BASE_URL +UPDATE_PRICE_1).toString();
    }
    //资讯详情
    public static String getNewsDetail(){
        return new StringBuilder(BASE_URL +NEWS_DETAIL).toString();
    }
    public static String getEndPrice(){
        return new StringBuilder(BASE_URL +END_PRICE).toString();
    }
    public static String getYuantu(){
        return new StringBuilder(BASE_URL +YUANTU).toString();
    }
    //删除收藏
    public static String delCollect(){
        return new StringBuilder(BASE_URL +DEL_COLLECT).toString();
    }
    //取消报价
    public static String cancelPrice(){
        return new StringBuilder(BASE_URL +CANCLE_PRICE).toString();
    }
    public static String delSample(){
        return new StringBuilder(BASE_URL +DEL_SAMPLE).toString();
    }

    public static String emptyCollect(){
        return new StringBuilder(BASE_URL +EMPTY_COLLECT).toString();
    }
    public static String getNewVersion(){
        return new StringBuilder(BASE_URL +NEW_VERSION).toString();
    }
    public static String getLookTimes(){
        return new StringBuilder(BASE_URL +LOOK_TIME).toString();
    }
    public static String getOfferedPriceDetail(){
        return new StringBuilder(BASE_URL +OFFERED_PRICE_DETAIL).toString();
    }
    public static String getHelpCenter(){
        return new StringBuilder(BASE_URL +HELP_CENTER).toString();
    }
    public static String getHelpDetail(){
        return new StringBuilder(BASE_URL +HELP_DETAIL).toString();
    }

    public static String getReadMsg(){
        return new StringBuilder(BASE_URL +READ_MSG).toString();
    }
    public static String getCallPhone(){
     return new StringBuilder(BASE_URL +CALL_PHONE).toString();
    }

   public static String getLogisticsClass(){
     return new StringBuilder(BASE_URL +LOGISTICS_CLASS).toString();
   }
    public static String getAdStart(){
        return new StringBuilder(BASE_URL +AD_START).toString();
    }
 public static String getDelMsg(){
  return new StringBuilder(BASE_URL +DEL_MSG).toString();
 }
 public static String getEmptyMsg(){
  return new StringBuilder(BASE_URL +EMPTY_MSG).toString();
 }
 public static String getHotSearch(){
  return new StringBuilder(BASE_URL +HOT_SEARCH).toString();
 }
    public static String getAuthInfo(){
        return new StringBuilder(BASE_URL +AUTH_INFO).toString();
    }
}

