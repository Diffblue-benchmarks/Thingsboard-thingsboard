package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmData;

@DisabledInAotMode
class AlarmDataUpdateDiffblueTest {
  @MockBean
  private AlarmDataUpdate alarmDataUpdate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataUpdate#AlarmDataUpdate(int, int, String)}
   *   <li>{@link AlarmDataUpdate#toString()}
   *   <li>{@link AlarmDataUpdate#getAllowedEntities()}
   *   <li>{@link AlarmDataUpdate#getCmdUpdateType()}
   *   <li>{@link AlarmDataUpdate#getTotalEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmDataUpdate actualAlarmDataUpdate = new AlarmDataUpdate(1, -1, "An error occurred");
    String actualToStringResult = actualAlarmDataUpdate.toString();
    long actualAllowedEntities = actualAlarmDataUpdate.getAllowedEntities();
    CmdUpdateType actualCmdUpdateType = actualAlarmDataUpdate.getCmdUpdateType();
    long actualTotalEntities = actualAlarmDataUpdate.getTotalEntities();

    // Assert
    assertEquals("AlarmDataUpdate(allowedEntities=0, totalEntities=0)", actualToStringResult);
    assertEquals("An error occurred", actualAlarmDataUpdate.getErrorMsg());
    assertNull(actualAlarmDataUpdate.getUpdate());
    assertNull(actualAlarmDataUpdate.getData());
    assertEquals(-1, actualAlarmDataUpdate.getErrorCode());
    assertEquals(0L, actualAllowedEntities);
    assertEquals(0L, actualTotalEntities);
    assertEquals(1, actualAlarmDataUpdate.getCmdId());
    assertEquals(CmdUpdateType.ALARM_DATA, actualCmdUpdateType);
  }

  /**
   * Test
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}.
   * <ul>
   *   <li>Then return Data is emptyPageData {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, int, String, long, long); then return Data is emptyPageData EMPTY_PAGE_DATA")
  void testNewAlarmDataUpdate_thenReturnDataIsEmptyPageDataEmpty_page_data() {
    // Arrange
    PageData<AlarmData> data = PageData.emptyPageData();

    // Act and Assert
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData,
        (new AlarmDataUpdate(1, data, new ArrayList<>(), -1, "An error occurred", 1L, 1L)).getData());
  }

  /**
   * Test
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}.
   * <ul>
   *   <li>Then return Data is emptyPageData {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, long, long); then return Data is emptyPageData EMPTY_PAGE_DATA")
  void testNewAlarmDataUpdate_thenReturnDataIsEmptyPageDataEmpty_page_data2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageData<AlarmData> data = PageData.emptyPageData();

    // Act and Assert
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, (new AlarmDataUpdate(1, data, new ArrayList<>(), 1L, 1L)).getData());
  }

  /**
   * Test
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}.
   * <ul>
   *   <li>When {@link PageData}.</li>
   *   <li>Then return ErrorMsg is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, int, String, long, long); when PageData; then return ErrorMsg is 'An error occurred'")
  void testNewAlarmDataUpdate_whenPageData_thenReturnErrorMsgIsAnErrorOccurred() {
    // Arrange
    PageData<AlarmData> data = mock(PageData.class);

    // Act
    AlarmDataUpdate actualAlarmDataUpdate = new AlarmDataUpdate(1, data, new ArrayList<>(), -1, "An error occurred", 1L,
        1L);

    // Assert
    assertEquals("An error occurred", actualAlarmDataUpdate.getErrorMsg());
    assertEquals(-1, actualAlarmDataUpdate.getErrorCode());
    assertEquals(1, actualAlarmDataUpdate.getCmdId());
    assertEquals(1L, actualAlarmDataUpdate.getAllowedEntities());
    assertEquals(1L, actualAlarmDataUpdate.getTotalEntities());
    assertEquals(CmdUpdateType.ALARM_DATA, actualAlarmDataUpdate.getCmdUpdateType());
    assertTrue(actualAlarmDataUpdate.getUpdate().isEmpty());
    assertSame(data, actualAlarmDataUpdate.getData());
  }

  /**
   * Test
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}.
   * <ul>
   *   <li>When {@link PageData}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, long, long); when PageData; then return ErrorMsg is 'null'")
  void testNewAlarmDataUpdate_whenPageData_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageData<AlarmData> data = mock(PageData.class);

    // Act
    AlarmDataUpdate actualAlarmDataUpdate = new AlarmDataUpdate(1, data, new ArrayList<>(), 1L, 1L);

    // Assert
    assertNull(actualAlarmDataUpdate.getErrorMsg());
    assertEquals(0, actualAlarmDataUpdate.getErrorCode());
    assertEquals(1, actualAlarmDataUpdate.getCmdId());
    assertEquals(1L, actualAlarmDataUpdate.getAllowedEntities());
    assertEquals(1L, actualAlarmDataUpdate.getTotalEntities());
    assertEquals(CmdUpdateType.ALARM_DATA, actualAlarmDataUpdate.getCmdUpdateType());
    assertTrue(actualAlarmDataUpdate.getUpdate().isEmpty());
    assertSame(data, actualAlarmDataUpdate.getData());
  }
}
