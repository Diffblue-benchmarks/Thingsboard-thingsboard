package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.RuleEngineAlarmService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TenantIdLoaderDiffblueTest {
  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId); then throw RuntimeException")
  void testFindTenantId_thenThrowRuntimeException() {
    // Arrange
    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmById(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new RuntimeException("foo"));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> TenantIdLoader.findTenantId(ctx, new AlarmId(UUID.randomUUID())));
    verify(ruleEngineAlarmService).findAlarmById(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getTenantId();
  }
}
