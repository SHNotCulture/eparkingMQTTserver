package com.mqttserver.util;


import java.util.List;

public class CommonUtil {
	public final static String TYPELIST_PROPERTIES = "/typelist_zh_CN.properties";
	
	//维护权限设置ID的列表(排除包含该权限id在外所有列表)
	public final static Integer[] modu = {86,87,88,89,90,91,92,93,94,95,96};
	//是否是超级用户旗下的子用户
	public final static Integer adminIndex=1;
	//登录账号信息
	public final static String COMPANY_USER = "COMPANY_USER";
	public final static String DATE_TYPE_TO_SS = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_TYPE_TO_DD = "yyyy-MM-dd";

	//月卡计费模式
	public final static String COMPANY_PARK_MONTH_RULE = "COMPANY_PARK_MONTH_RULE";
	public final static Integer COMPANY_PARK_MONTH_RULE_01=1; //自然月
	public final static Integer COMPANY_PARK_MONTH_RULE_02=2; //到月底
	
	//物业总账号
	public final static String COMPANY_USER_ADMIN = "COMPANY_USER_ADMIN";
	public final static String COMPANY_USER_ADMIN_0="0";	//系统超级管理员
	public final static String COMPANY_USER_ADMIN_01="1";	//某物业公司的超级管理员
	public final static String COMPANY_USER_ADMIN_02="2";	//某物业公司的普通帐号
	public final static String COMPANY_USER_ADMIN_03="3";	//商户帐号

	//月卡规则设定	
	public final static String MEMBER_STATUS = "MEMBER_STATUS";
	public final static Integer MEMBER_STATUS_1 =1;//启用
	public final static Integer MEMBER_STATUS_2 = 2;//停用
	//月卡规则设定
	public final static String CARPAYRULE_RULE_NAME="CARPAYRULE_RULE_NAME";
	public final static Integer CARPAYRULE_RULE_NAME_01=1;//小车
	public final static Integer CARPAYRULE_RULE_NAME_02=2;//大车
	public final static Integer CARPAYRULE_RULE_NAME_03=3;//地库小车
	
	public final static String STATUS_YESORNO = "STATUS_YESORNO";
	public final static Integer STATUS_YES =1;//是
	public final static Integer STATUS_NO =0;//否
	
	//缴费方式
	public final static String CHARGE_TYPE = "CHARGE_TYPE";
	public final static String CHARGE_TYPE_1 = "1";//电子付费
	public final static String CHARGE_TYPE_2 = "2";//免付费
	public final static String CHARGE_TYPE_3 = "3";//现金
	public final static String CHARGE_TYPE_5 = "5";//银联扣费
	
	//车主性质
	public final static String CAR_NAME = "CAR_NAME";
	public final static String CAR_NAME_1 = "1";//会员临时车
	public final static String CAR_NAME_2 = "2";//月租车
	public final static String CAR_NAME_3 = "3";//临时车
	public final static String CAR_NAME_4 = "4";//月租绑定车
	public final static String CAR_NAME_5 = "5";//月租暂停车
	public final static String CAR_NAME_6 = "6";//月租过期车
	public final static String CAR_NAME_7 = "7";//月租无通道权限
		
	//时间类型
	public final static String TIME = "TIME";
	public final static String TIME_1 = "1";//进场时间
	public final static String TIME_2 = "2";//出场时间
	public final static String TIME_3 = "3";//纪录产生时间
	
	//收费规则
	public final static String PAY_TYPE_SYMBOL = "PAY_TYPE_SYMBOL";
	public final static String PAY_TYPE_SYMBOL_1 = "1";//等于
	public final static String PAY_TYPE_SYMBOL_2 = "2";//大于
	public final static String PAY_TYPE_SYMBOL_3 = "3";//大于等于
	public final static String PAY_TYPE_SYMBOL_4 = "4";//小于
	public final static String PAY_TYPE_SYMBOL_5 = "5";//小于等于
	
	//月卡缴费方式pay_type
	public final static String PAY_TYPE = "PAY_TYPE";
	public final static String PAY_TYPE_1 = "1";//现金
	public final static String PAY_TYPE_2 = "2";//电子支付
	
	public final static String CAR_PAY_RULE_TYPE="CAR_PAY_RULE_TYPE"; //缴费规则
	public final static Integer CAR_PAY_RULE_TYPE_Y=3;//按年交
	public final static Integer CAR_PAY_RULE_TYPE_Q=2;//按季交
	public final static Integer CAR_PAY_RULE_TYPE_M=1;//按月交
	public final static Integer CAR_PAY_RULE_TYPE_D=0;//按日交
	
	//充值类型
	public final static String OPER_TYPE = "OPER_TYPE";
	public final static Integer OPER_TYPE_1 = 1;//充值
	public final static Integer OPER_TYPE_2 = 2;//充正
	public final static Integer OPER_TYPE_3 = 3;//退款
	
	//车型
	public final static String PARK_TYPE = "PARK_TYPE";
	public final static Integer PARK_TYPE_1 = 1;//小车
	public final static Integer PARK_TYPE_2 = 2;//大车
	public final static Integer PARK_TYPE_3 = 3;//超大车
	public final static Integer PARK_TYPE_4 = 4;//其他车
	
	//商户状态
	public final static String BUSINE_STATUS="BUSINE_STATUS";
	public final static Integer BUSINE_STATUS_0=0;//休业
	public final static Integer BUSINE_STATUS_1=1;//营业
	public final static Integer BUSINE_STATUS_2=2;//删除
	//商户类型
	public final static String BUSINE_PARK_TYPE="BUSINE_PARK_TYPE";
	public final static Integer BUSINE_PARK_TYPE_0=0;//酒店
	public final static Integer BUSINE_PARK_TYPE_1=1;//商场
	public final static Integer BUSINE_PARK_TYPE_2=2;//餐厅
	public final static Integer BUSINE_PARK_TYPE_3=3;//办公
	public final static Integer BUSINE_PARK_TYPE_4=4;//其它
	
	/**
	 * 操作实体类型
	 */
	public final static String ENTITY_TYPE="ENTITY_TYPE";
	public final static Integer ENTITY_TYPE_TOPCOMPANY=0;// 总公司--（后台运营公司）
	public final static Integer ENTITY_TYPE_SUBCOMPANY=1;// 子公司账号--（物业公司）
	public final static Integer ENTITY_TYPE_BUSINE=2;//商家账号
	public final static Integer ENTITY_TYPE_CENTRALCHARGE=3;//中央收费帐号
	
	/**
	 * 公司类型
	 */
	public final static String COMPANY_TYPE="COMPANY_TYPE";
	public final static Integer COMPANY_TYPE_1=1;//物业公司
	public final static Integer COMPANY_TYPE_2=2;//地产商
	public final static Integer COMPANY_TYPE_3=3;//政府部门
	public final static Integer COMPANY_TYPE_4=4;//商广场
	public final static Integer COMPANY_TYPE_5=5;//其他
	
	/**
	 * 会员激活状态
	 */
	public final static String MEMBER_LIVE_STATUS="MEMBER_LIVE_STATUS";
	public final static Integer MEMBER_LIVE_STATUS_1=1;//未激活
	public final static Integer MEMBER_LIVE_STATUS_2=2;//已激活
	public final static Integer MEMBER_LIVE_STATUS_3=3;//已注销
	
	/**
	 * 会员实名认证
	 */
	public final static String MEMBER_CHECK_NAME="MEMBER_CHECK_NAME";
	public final static Integer MEMBER_CHECK_NAME_1=1;//未认证
	public final static Integer MEMBER_CHECK_NAME_2=2;//认证中
	public final static Integer MEMBER_CHECK_NAME_3=3;//未通过
	public final static Integer MEMBER_CHECK_NAME_4=4;//已通过
	
	
	public final static String CARD_STATUS="CARD_STATUS";
	public final static Integer CARD_STATUS_STATUS_1=1;//库存
	public final static Integer CARD_STATUS_STATUS_2=2;//已发行
	public final static Integer CARD_STATUS_STATUS_3=3;//已挂失
	
	/**
	 * 报表类型Report Type
	 */
	public final static String REPORT_TYPE = "REPORT_TYPE";
	public final static Integer REPORT_TYPE_1 =1;//日报表
	public final static Integer REPORT_TYPE_2 =2;//月报表
	public final static Integer REPORT_TYPE_3 =3;//年报表
	
	/**
	 * 锁车状态lock_status
	 */
	public final static String LOCK_STATUS = "LOCK_STATUS";
	public final static Integer LOCK_STATUS_0 = 0;//手动锁车
	public final static Integer LOCK_STATUS_1 = 1;//手动解锁
	public final static Integer LOCK_STATUS_2 = 2;//云锁车
	public final static Integer LOCK_STATUS_3 = 3;//云解锁
	
	/**
	 * 锁车时间是否启用Lock_time_status
	 */
	public final static String LOCK_TIME_STATUS = "LOCK_TIME_STATUS";
	public final static Integer LOCK_TIME_STATUS_0 = 0;//不启用
	public final static Integer LOCK_TIME_STATUS_1 = 1;//启用
	
	/**
	 * 交易记录状态status
	 */
	public final static String STATUS = "STATUS";
	public final static Integer STATUS_0 = 0;//未充值
	public final static Integer STATUS_1 = 1;//充值成功
	public final static Integer STATUS_2 = 2;//充值失败
	public final static Integer STATUS_3 = 3;//支付成功
	public final static Integer STATUS_4 = 4;//支付失败
	
	/**
	 * 日志事件状态operatingType
	 */
	public final static String OPERATINGTYPE = "OPERATINGTYPE";
	public final static Integer OPERATINGTYPE_1 = 1;//操作日志
	public final static Integer OPERATINGTYPE_2 = 2;//事件日志
	
	/**
	 * 放行方式OUT_TYPE
	 */
	public final static String OUT_TYPE = "OUT_TYPE";
	public static final Integer OUT_TYPE_1 = 1;	//月租车自动放行
	public static final Integer OUT_TYPE_2 = 2;	//出口现金缴费放行		(指车辆在出口地方缴现金，保安确认放行)
	public static final Integer OUT_TYPE_3 = 3;	//中央缴费放行			(指车辆在中央缴费后，在出口自动放行)
	public static final Integer OUT_TYPE_4 = 4;	//云闪付自动放行		    (指线下刷银行卡缴费后，自动放行)
	public static final Integer OUT_TYPE_5 = 5;//线上自动缴费放行		(指银联自动扣费、会员账户自动扣费后，自动放行)
	public static final Integer OUT_TYPE_6 = 6;	//线上预缴费放行			(指车主通过APP预先缴费后，在出口自动放行)
	public static final Integer OUT_TYPE_7 = 7;	//商户代缴放行			(指商户全额代缴后，在出口自动放行，如果非全额，在归类到其他的缴费放行方式，须填写商户号及名)
	
	public static final Integer OUT_TYPE_8 = 8;		//免费放行				(指特殊车辆，或特殊情况下保安免费放行)
	public static final Integer OUT_TYPE_9 = 9;		//保安未确认			(指车辆须缴费，但是保安未确认，可能是遥控或非法方式开闸放行)
	public static final Integer OUT_TYPE_10 = 10;		//保安手动开闸		(指通过电脑手动开)
	public static final Integer OUT_TYPE_11 = 11;	//保安取消出场
	public static final Integer OUT_TYPE_12 = 12;	//无入场记录放行
	public static final Integer OUT_TYPE_13 = 13;	//出口优惠减免放行
	
	//车位状态
	public final static String PARKING_STATE = "PARKING_STATE";
	public final static Integer PARKING_STATE_1 = 1;//已售
	public final static Integer PARKING_STATE_2 = 2;//在租
	public final static Integer PARKING_STATE_3 = 3;//免费
	public final static Integer PARKING_STATE_4 = 4;//空闲
	
	//车位性质
	public final static String PARKING_SPACE = "PARKING_SPACE";
	public final static Integer PARKING_SPACE_1 = 1;//机械车位
	public final static Integer PARKING_SPACE_2 = 2;//子母车位
	public final static Integer PARKING_SPACE_3 = 3;//普通车位

	//线下聚合支付类型
	public final static String EPAY_TYPE = "EPAY_TYPE";
	public final static Integer EPAY_TYPE_1 = 1;
	public final static Integer EPAY_TYPE_2 = 2;
	public final static Integer EPAY_TYPE_3 = 3;
	public final static Integer EPAY_TYPE_4 = 4;
	public final static Integer EPAY_TYPE_5 = 5;
	public final static Integer EPAY_TYPE_6 = 6;
	public final static Integer EPAY_TYPE_7 = 7;
	public final static Integer EPAY_TYPE_8 = 8;
	public final static Integer EPAY_TYPE_9 = 9;
	
	//是否允许自动续缴
	public final static String AUTO_RENEW = "AUTO_RENEW";
	public final static Integer AUTO_RENEW_0 = 0;//不允许
	public final static Integer AUTO_RENEW_1 = 1;//允许
	
	//是否允许多次代缴
	public final static String AUTO_ISMANYPREFERENTIAL = "AUTO_ISMANYPREFERENTIAL";
	public final static Integer AUTO_ISMANYPREFERENTIAL_0 = 0;//不允许
	public final static Integer AUTO_ISMANYPREFERENTIAL_1 = 1;//允许
	
	//预缴子类型
	public final static String PREPAY_TYPE = "PREPAY_TYPE";
	public final static Integer PREPAY_TYPE_1= 1;//微信预缴
	public final static Integer PREPAY_TYPE_2= 2;//支付宝预缴
	public final static Integer PREPAY_TYPE_3= 3;//云闪付预缴
	public final static Integer PREPAY_TYPE_4= 4;//猫酷预缴
	public final static Integer PREPAY_TYPE_5= 5;//招行一网通预缴


}
