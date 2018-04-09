package loadUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *   
 * 
 * @Title: DateHelper.java
 * @Package com.jarvis.base.util
 * @Description:日期工具类
 * @author Jack 
 * @date 2017年9月2日 下午2:33:46
 * @version V1.0  
 */
public class DateHelper {

	/**
	 * 日期格式yyyy-MM-dd
	 */
	public static final String pattern_date = "yyyy-MM-dd";

	/**
	 * 日期时间格式yyyy-MM-dd HH:mm:ss
	 */
	public static final String pattern_time = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 描述：日期格式化
	 * 
	 * @param date
	 *            日期
	 * @return 输出格式为 yyyy-MM-dd 的字串
	 */
	public static String formatDate(Date date) {
		return formatDate(date, pattern_time);
	}

	/**
	 * 描述：日期格式化
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            格式化类型
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 描述：解析日期字串
	 * 
	 * @param dateStr
	 *            日期字串
	 * @return 按 yyyy-MM-dd HH:mm:ss 格式解析
	 */
	public static Date parseString(String dateStr) {
		return parseString(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 描述：解析日期字串
	 * 
	 * @param dateStr
	 *            日期字串
	 * @param pattern
	 *            字串日期格式
	 * @return 对应日期类型数据
	 */
	public static Date parseString(String dateStr, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
			if (!StringHelper.isEmpty(dateStr)) {
				return dateFormat.parse(dateStr);
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
			System.err.println(dateStr + "转换成日期失败，可能是不符合格式：" + pattern);
		}
		return null;
	}

	/**
	 * 描述：获取指定日期的中文星期数
	 * 
	 * @param date
	 *            指定日期
	 * @return 星期数，如：星期一
	 */
	public static String getWeekStr(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int week = calendar.get(7);
		--week;
		String weekStr = "";
		switch (week) {
		case 0:
			weekStr = "星期日";
			break;
		case 1:
			weekStr = "星期一";
			break;
		case 2:
			weekStr = "星期二";
			break;
		case 3:
			weekStr = "星期三";
			break;
		case 4:
			weekStr = "星期四";
			break;
		case 5:
			weekStr = "星期五";
			break;
		case 6:
			weekStr = "星期六";
		}
		return weekStr;
	}

	/**
	 * 描述：间隔时间
	 * 
	 * @param date1
	 * @param date2
	 * @return 毫秒数
	 */
	public static long getDateMiliDispersion(Date date1, Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return 0L;
		}

		long time1 = date1.getTime();
		long time2 = date2.getTime();

		return time1 - time2;
	}

	/**
	 * 描述：间隔天数
	 * 
	 * @param date1
	 * @param date2
	 * @return 天数
	 */
	public static int getDateDiff(Date date1, Date date2) {
		if ((date1 == null) || (date2 == null)) {
			return 0;
		}
		long time1 = date1.getTime();
		long time2 = date2.getTime();

		long diff = time1 - time2;

		Long longValue = new Long(diff / 86400000L);
		return longValue.intValue();
	}

	/**
	 * 描述：获取指定日期之前多少天的日期
	 * 
	 * @param date
	 *            指定日期
	 * @param day
	 *            天数
	 * @return 日期
	 */
	public static Date getDataDiff(Date date, int day) {
		if (date == null) {
			return null;
		}
		long time = date.getTime();
		time -= 86400000L * day;
		return new Date(time);
	}

	/**
	 * 描述：获取当前周
	 * 
	 * @return
	 */
	public static int getCurrentWeek() {
		Calendar calendar = Calendar.getInstance();
		int week = calendar.get(7);
		--week;
		if (week == 0) {
			week = 7;
		}
		return week;
	}

	/**
	 * 描述：获取中文当前周
	 * 
	 * @return
	 */
	public static String getCurrentWeekStr() {
		return getWeekStr(new Date());
	}

	/**
	 * 描述：获取本年
	 * 
	 * @return
	 */
	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(1);
	}

	/**
	 * 描述：获取本月
	 * 
	 * @return
	 */
	public static int getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(2) + 1;
	}

	/**
	 * 描述：获取本月的当前日期数
	 * 
	 * @return
	 */
	public static int getCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(5);
	}

	/**
	 * 描述：当前时间与指定时间的差
	 * 
	 * @param str
	 *            秒数
	 * @return 时间差，单位：秒
	 */
	public static int getUnixTime(String str) {
		if ((str == null) || ("".equals(str))) {
			return 0;
		}
		try {
			long utime = Long.parseLong(str) * 1000L;
			Date date1 = new Date(utime);

			Date date = new Date();

			long nowtime = (date.getTime() - date1.getTime()) / 1000L;
			return (int) nowtime;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("获取时差失败");
		}
		return 0;
	}

	/**
	 * 描述：去除日期字串中原“-”和“:”
	 * 
	 * @param dateTime日期字串
	 * @return
	 */
	public static String formatString(String dateTime) {
		if ((dateTime != null) && (dateTime.length() >= 8)) {
			String formatDateTime = dateTime.replaceAll("-", "");
			formatDateTime = formatDateTime.replaceAll(":", "");
			String date = formatDateTime.substring(0, 8);
			return date;
		}

		return "";
	}

	/**
	 * 描述：当前时间与指定时间的差
	 * 
	 * @param str
	 *            yyyy-MM-dd HH:mm:ss 格式的日期
	 * @return 时间差，单位：秒
	 */
	public static int getTimesper(String str) {
		if ((str == null) || ("".equals(str))) {
			return 0;
		}
		try {
			Date date1 = new Date(Long.parseLong(str));
			Date date = new Date();
			long nowtime = (date.getTime() - date1.getTime()) / 1000L;
			return (int) nowtime;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("日期转换出错");
		}
		return 0;
	}

	/**
	 * 描述：获取16位日期时间，yyyyMMddHHmmss
	 * 
	 * @param dateTime
	 *            字串日期
	 * @return
	 */
	public static String formatDateTime(String dateTime) {
		if ((dateTime != null) && (dateTime.length() >= 8)) {
			String formatDateTime = dateTime.replaceAll("-", "");
			formatDateTime = formatDateTime.replaceAll(":", "");
			String date = formatDateTime.substring(0, 8);
			String time = formatDateTime.substring(8).trim();
			for (int i = time.length(); i < 6; ++i) {
				time = time + "0";
			}
			return date + time;
		}

		return "";
	}

	/**
	 * 描述：获取16位日期时间，yyyyMMddHHmmss
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String formatDateTime(Date date) {
		String dateTime = formatDate(date);
		return formatDateTime(dateTime);
	}

    /**
     *   
     *
     * @Title: DateHelper.FastJsonUtil.java
     * @Package com.jarvis.base.util
     * @Description:fastjson工具类
     * @author Jack 
     * @date 2017年9月2日 下午4:16:27
     * @version V1.0  
     */
    public static class FastJsonUtil {

        private static final SerializeConfig config;

        static {
            config = new SerializeConfig();
            config.put(Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
            config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        }

        private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
                SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
                SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
                SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
                SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为""，而不是null
                SerializerFeature.PrettyFormat  //是否需要格式化输出Json数据
        };

        /**
         * Author:Jack Time:2017年9月2日下午4:24:14
         *
         * @param object
         * @return Return:String Description:将对象转成成Json对象
         */
        public static String toJSONString(Object object) {
            return JSON.toJSONString(object, config, features);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:27:25
         *
         * @param object
         * @return Return:String Description:使用和json-lib兼容的日期输出格式
         */
        public static String toJSONNoFeatures(Object object) {
            return JSON.toJSONString(object, config);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:24:54
         *
         * @param jsonStr
         * @return Return:Object Description:将Json数据转换成JSONObject
         */
        public static JSONObject toJsonObj(String jsonStr) {
            return (JSONObject) JSON.parse(jsonStr);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:25:20
         *
         * @param jsonStr
         * @param clazz
         * @return Return:T Description:将Json数据转换成Object
         */
        public static <T> T toBean(String jsonStr, Class<T> clazz) {
            return JSON.parseObject(jsonStr, clazz);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:25:34
         *
         * @param jsonStr
         * @return Return:Object[] Description:将Json数据转换为数组
         */
        public static <T> Object[] toArray(String jsonStr) {
            return toArray(jsonStr, null);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:25:57
         *
         * @param jsonStr
         * @param clazz
         * @return Return:Object[] Description:将Json数据转换为数组
         */
        public static <T> Object[] toArray(String jsonStr, Class<T> clazz) {
            return JSON.parseArray(jsonStr, clazz).toArray();
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:26:08
         *
         * @param jsonStr
         * @param clazz
         * @return Return:List<T> Description:将Json数据转换为List
         */
        public static <T> List<T> toList(String jsonStr, Class<T> clazz) {
            return JSON.parseArray(jsonStr, clazz);
        }

        /**
         * 将javabean转化为序列化的JSONObject对象
         *
         * @param keyvalue
         * @return
         */
        public static JSONObject beanToJsonObj(Object bean) {
            String jsonStr = JSON.toJSONString(bean);
            JSONObject objectJson = (JSONObject) JSON.parse(jsonStr);
            return objectJson;
        }
        /**
         * json字符串转化为map
         *
         * @param s
         * @return
         */
        public static Map<?, ?> stringToCollect(String jsonStr) {
            Map<?, ?> map = JSONObject.parseObject(jsonStr);
            return map;
        }

        /**
         * 将map转化为string
         *
         * @param m
         * @return
         */
        public static String collectToString(Map<?, ?> map) {
            String jsonStr = JSONObject.toJSONString(map);
            return jsonStr;
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:19:00
         *
         * @param t
         * @param file
         * @throws IOException
         *             Return:void Description:将对象的Json数据写入文件。
         */
        public static <T> void writeJsonToFile(T t, File file) throws IOException {
            String jsonStr = JSONObject.toJSONString(t, SerializerFeature.PrettyFormat);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(jsonStr);
            bw.close();
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:19:12
         *
         * @param t
         * @param filename
         * @throws IOException
         *             Return:void Description:将对象的Json数据写入文件。
         */
        public static <T> void writeJsonToFile(T t, String filename) throws IOException {
            writeJsonToFile(t, new File(filename));
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:22:07
         *
         * @param cls
         * @param file
         * @return
         * @throws IOException
         *             Return:T Description:将文件中的Json数据转换成Object对象
         */
        public static <T> T readJsonFromFile(Class<T> cls, File file) throws IOException {
            StringBuilder strBuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = br.readLine()) != null) {
                strBuilder.append(line);
            }
            br.close();
            return JSONObject.parseObject(strBuilder.toString(), cls);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:22:30
         *
         * @param cls
         * @param filename
         * @return
         * @throws IOException
         *             Return:T Description:将文件中的Json数据转换成Object对象
         */
        public static <T> T readJsonFromFile(Class<T> cls, String filename) throws IOException {
            return readJsonFromFile(cls, new File(filename));
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:23:06
         *
         * @param typeReference
         * @param file
         * @return
         * @throws IOException
         *             Return:T Description:从文件中读取出Json对象
         */
        public static <T> T readJsonFromFile(TypeReference<T> typeReference, File file) throws IOException {
            StringBuilder strBuilder = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = br.readLine()) != null) {
                strBuilder.append(line);
            }
            br.close();
            return JSONObject.parseObject(strBuilder.toString(), typeReference);
        }

        /**
         * Author:Jack Time:2017年9月2日下午4:23:11
         *
         * @param typeReference
         * @param filename
         * @return
         * @throws IOException
         *             Return:T Description:从文件中读取出Json对象
         */
        public static <T> T readJsonFromFile(TypeReference<T> typeReference, String filename) throws IOException {
            return readJsonFromFile(typeReference, new File(filename));
        }

    }
}