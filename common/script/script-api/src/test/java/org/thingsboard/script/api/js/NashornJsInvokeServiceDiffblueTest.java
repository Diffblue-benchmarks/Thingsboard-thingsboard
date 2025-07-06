package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

class NashornJsInvokeServiceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NashornJsInvokeService#getMaxBlackListDurationSec()}
   *   <li>{@link NashornJsInvokeService#getMaxErrors()}
   *   <li>{@link NashornJsInvokeService#getMaxInvokeRequestsTimeout()}
   *   <li>{@link NashornJsInvokeService#getStatsName()}
   *   <li>{@link NashornJsInvokeService#isStatsEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int NashornJsInvokeService.getMaxBlackListDurationSec()",
    "int NashornJsInvokeService.getMaxErrors()",
    "long NashornJsInvokeService.getMaxInvokeRequestsTimeout()",
    "String NashornJsInvokeService.getStatsName()",
    "boolean NashornJsInvokeService.isStatsEnabled()"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));
    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act
    int actualMaxBlackListDurationSec = nashornJsInvokeService.getMaxBlackListDurationSec();
    int actualMaxErrors = nashornJsInvokeService.getMaxErrors();
    long actualMaxInvokeRequestsTimeout = nashornJsInvokeService.getMaxInvokeRequestsTimeout();
    String actualStatsName = nashornJsInvokeService.getStatsName();

    // Assert
    assertEquals("Nashorn JS Invoke Stats", actualStatsName);
    assertEquals(0, actualMaxBlackListDurationSec);
    assertEquals(0, actualMaxErrors);
    assertEquals(0L, actualMaxInvokeRequestsTimeout);
    assertFalse(nashornJsInvokeService.isStatsEnabled());
  }
}
