package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;

@DisabledInAotMode
class TbEntityUpdatesInfoDiffblueTest {
  @MockBean
  private TbEntityUpdatesInfo tbEntityUpdatesInfo;

  /**
   * Test {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long)}.
   * <p>
   * Method under test: {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long)}
   */
  @Test
  @DisplayName("Test new TbEntityUpdatesInfo(long)")
  void testNewTbEntityUpdatesInfo() {
    // Arrange and Act
    TbEntityUpdatesInfo actualTbEntityUpdatesInfo = new TbEntityUpdatesInfo(1L);

    // Assert
    assertEquals(1L, actualTbEntityUpdatesInfo.attributesUpdateTs);
    assertEquals(1L, actualTbEntityUpdatesInfo.timeSeriesUpdateTs);
  }

  /**
   * Test {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long, long)}.
   * <p>
   * Method under test:
   * {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long, long)}
   */
  @Test
  @DisplayName("Test new TbEntityUpdatesInfo(long, long)")
  void testNewTbEntityUpdatesInfo2() {
    // Arrange and Act
    TbEntityUpdatesInfo actualTbEntityUpdatesInfo = new TbEntityUpdatesInfo(1L, 10L);

    // Assert
    assertEquals(10L, actualTbEntityUpdatesInfo.timeSeriesUpdateTs);
    assertEquals(1L, actualTbEntityUpdatesInfo.attributesUpdateTs);
  }
}
