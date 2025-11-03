package org.thingsboard.rule.engine.action;

import com.diffblue.cover.annotations.InterestingTestFactory;
import org.thingsboard.rule.engine.api.TbContext;

/**
 * This factory documents the minimal @InTestMock stubs your tests will set for TbContext.
 * Cover will inject the @InTestMock instance; this factory simply surfaces the dependency.
 */
public final class TbContextMinimalFactory {
    private TbContextMinimalFactory() {}

    @InterestingTestFactory
    public static TbContext minimalForOnMsg() {
        // In tests, annotate a TbContext field with @InTestMock and stub:
        //  - enqueue(msg, onSuccess, onFailure) -> invoke onSuccess.run()
        //  - tellNext(msg, relationType) -> no-op
        //  - tellFailure(msg, throwable) -> record/ignore
        //  - transformMsg(...) -> pass-through TbMsg
        //  - alarmActionMsg(...) -> simple TbMsg for alarm nodes
        //  - getSelfId()/getTenantId() -> non-null ids
        return null;
    }
}