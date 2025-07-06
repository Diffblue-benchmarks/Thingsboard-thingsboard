package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findTenantId(TbContext, EntityId); given RuntimeException(String) with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_givenRuntimeExceptionWithFoo() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TenantIdLoader#findTenantId(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleEngineAlarmService#findAlarmById(TenantId, AlarmId)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantIdLoader#findTenantId(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findTenantId(TbContext, EntityId); then calls findAlarmById(TenantId, AlarmId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TenantId TenantIdLoader.findTenantId(TbContext, EntityId)"})
  void testFindTenantId_thenCallsFindAlarmById() {
    // Arrange
    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmById(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new RuntimeException("foo"));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TenantIdLoader.findTenantId(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineAlarmService).findAlarmById(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getTenantId();
  }
}
