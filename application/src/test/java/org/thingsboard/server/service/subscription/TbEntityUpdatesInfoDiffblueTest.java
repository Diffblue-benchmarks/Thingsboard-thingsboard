package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbEntityUpdatesInfoDiffblueTest {
  /**
   * Test {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long)}.
   * <p>
   * Method under test: {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long)}
   */
  @Test
  @DisplayName("Test new TbEntityUpdatesInfo(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbEntityUpdatesInfo.<init>(long)"})
  void testNewTbEntityUpdatesInfo() {
    // Arrange and Act
    TbEntityUpdatesInfo actualTbEntityUpdatesInfo = new TbEntityUpdatesInfo(1L);

    // Assert
    assertEquals(1L, actualTbEntityUpdatesInfo.attributesUpdateTs);
    assertEquals(1L, actualTbEntityUpdatesInfo.timeSeriesUpdateTs);
  }

  /**
   * Test {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long, long)}.
   * <ul>
   *   <li>Then return {@link TbEntityUpdatesInfo#timeSeriesUpdateTs} is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityUpdatesInfo#TbEntityUpdatesInfo(long, long)}
   */
  @Test
  @DisplayName("Test new TbEntityUpdatesInfo(long, long); then return timeSeriesUpdateTs is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbEntityUpdatesInfo.<init>(long, long)"})
  void testNewTbEntityUpdatesInfo_thenReturnTimeSeriesUpdateTsIsTen() {
    // Arrange and Act
    TbEntityUpdatesInfo actualTbEntityUpdatesInfo = new TbEntityUpdatesInfo(1L, 10L);

    // Assert
    assertEquals(10L, actualTbEntityUpdatesInfo.timeSeriesUpdateTs);
    assertEquals(1L, actualTbEntityUpdatesInfo.attributesUpdateTs);
  }
}
