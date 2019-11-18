package com.basic.java.fzkutil.bsj;

import java.nio.charset.Charset;

public class BsjRespMsgConstants {

    //通油成功的回复内容

    //1.恢复油电成功！
    public static final String OIL_ACCESS_CONTENT = "BB D6 B8 B4 D3 CD B5 E7 B3 C9 B9 A6 21";
    //2.终端已处于油电接通状态，本指令不再执行! 
    public static final String OIL_ALREADY_ACCESS_CONTENT = "D6 D5 B6 CB D2 D1 B4 A6 D3 DA D3 CD B5 E7 BD D3 CD A8 D7 B4 CC AC A3 AC B1 BE D6 B8 C1 EE B2 BB D4 D9 D6 B4 D0 D0 21";
    //断油成功的回复内容
    //切断油电成功!
    public static final String OIL_BREAK_CONTENT = "C7 D0 B6 CF D3 CD B5 E7 B3 C9 B9 A6 21";
    //2.终端已处于断油电状态，本指令不再执行!
    public static final String OIL_ALREADY_BREAK_CONTENT = "D6 D5 B6 CB D2 D1 B4 A6 D3 DA B6 CF D3 CD B5 E7 D7 B4 CC AC A3 AC B1 BE D6 B8 C1 EE B2 BB D4 D9 D6 B4 D0 D0 21";
    // 断油电延后执行，GPS未定位！
    public static final String OIL_BREAK_DELAY_EXECUTE = "B6 CF D3 CD B5 E7 D1 D3 BA F3 D6 B4 D0 D0 A3 AC 47 50 53 CE B4 B6 A8 CE BB 21";

    //服务器地址设置成功，回复内容OK
    public static final String SERVER_SWITCH_SUCCESS = "4F 4B 21";


}
