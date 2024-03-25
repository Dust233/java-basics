package com.example.javabasics;

/**
 * @author LiJingZhi
 * @since 2023-11-10 16:20
 */
public class DingDemo {

    /**
     * 使用 Token 初始化账号Client
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dingtalkconference_1_0.Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkconference_1_0.Client(config);
    }

    public static void main(String[] args_) throws Exception {
//        java.util.List<String> args = java.util.Arrays.asList(args_);
//        com.aliyun.dingtalkconference_1_0.Client client = DingDemo.createClient();
//        com.aliyun.dingtalkconference_1_0.models.CreateScheduleConferenceHeaders createScheduleConferenceHeaders = new com.aliyun.dingtalkconference_1_0.models.CreateScheduleConferenceHeaders();
//        createScheduleConferenceHeaders.xAcsDingtalkAccessToken = "<your access token>";
//        com.aliyun.dingtalkconference_1_0.models.CreateScheduleConferenceRequest createScheduleConferenceRequest = new com.aliyun.dingtalkconference_1_0.models.CreateScheduleConferenceRequest();
//        try {
//            client.createScheduleConferenceWithOptions(createScheduleConferenceRequest, createScheduleConferenceHeaders, new com.aliyun.teautil.models.RuntimeOptions());
//        } catch (TeaException err) {
//            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
//                // err 中含有 code 和 message 属性，可帮助开发定位问题
//            }
//
//        } catch (Exception _err) {
//            TeaException err = new TeaException(_err.getMessage(), _err);
//            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
//                // err 中含有 code 和 message 属性，可帮助开发定位问题
//            }
//
//        }

        // 创建一个 Calendar 对象，并设置时区为 UTC
        // Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        //
        // // 获取当前时间的 UTC 时间
        // Date utcTime = calendar.getTime();
        // System.out.println("当前 UTC 时间：" + utcTime);
        //
        // // 将 UTC 时间转换为时间戳
        // long timestamp = utcTime.getTime();
        // System.out.println("当前时间戳：" + timestamp);

    }

}
