package org.thingsboard.rule.engine.action;

import com.diffblue.cover.annotations.InterestingTestFactory;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.id.EntityId;

public final class TbAlarmMsgFactory {
    private TbAlarmMsgFactory() {}

    @InterestingTestFactory
    public static TbMsg alarmMsg(EntityId originator) {
        TbMsgMetaData md = new TbMsgMetaData();
        md.putValue("severity", "MAJOR");
        md.putValue("isExistingAlarm", "false");
        String json = "{\"alarmType\":\"threshold\",\"active\":true}";
        return TbMsg.newMsg(TbMsgType.ALARM, originator, md, json);
    }
}
