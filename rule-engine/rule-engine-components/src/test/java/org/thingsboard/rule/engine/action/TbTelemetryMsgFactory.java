package org.thingsboard.rule.engine.action;

import com.diffblue.cover.annotations.InterestingTestFactory;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.id.EntityId;

public final class TbTelemetryMsgFactory {
    private TbTelemetryMsgFactory() {}

    @InterestingTestFactory
    public static TbMsg telemetryMsg(EntityId originator, String key, Object value) {
        TbMsgMetaData md = new TbMsgMetaData();
        String json = "{\"" + key + "\":" + toJsonValue(value) + "}";
        return TbMsg.newMsg(TbMsgType.POST_TELEMETRY_REQUEST, originator, md, json);
    }

    private static String toJsonValue(Object v) {
        if (v instanceof Number || v instanceof Boolean) return String.valueOf(v);
        return "\"" + String.valueOf(v).replace("\"", "\\\"") + "\"";
    }
}