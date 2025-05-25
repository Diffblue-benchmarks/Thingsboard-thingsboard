package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmData;

class AlarmDataUpdateDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmDataUpdate.<init>(int, int, String)", "long AlarmDataUpdate.getAllowedEntities()",
      "CmdUpdateType AlarmDataUpdate.getCmdUpdateType()", "long AlarmDataUpdate.getTotalEntities()",
      "String AlarmDataUpdate.toString()"})
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
   * Test {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Update is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, int, String, long, long); given 'null'; then return Update is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmDataUpdate.<init>(int, PageData, List, int, String, long, long)"})
  void testNewAlarmDataUpdate_givenNull_thenReturnUpdateIsArrayList() {
    // Arrange
    PageData<AlarmData> data = PageData.emptyPageData();

    ArrayList<AlarmData> update = new ArrayList<>();
    update.add(null);

    // Act
    AlarmDataUpdate actualAlarmDataUpdate = new AlarmDataUpdate(1, data, update, -1, "An error occurred", 1L, 1L);

    // Assert
    assertEquals("An error occurred", actualAlarmDataUpdate.getErrorMsg());
    assertEquals(-1, actualAlarmDataUpdate.getErrorCode());
    assertEquals(1, actualAlarmDataUpdate.getCmdId());
    assertEquals(1L, actualAlarmDataUpdate.getAllowedEntities());
    assertEquals(1L, actualAlarmDataUpdate.getTotalEntities());
    assertEquals(CmdUpdateType.ALARM_DATA, actualAlarmDataUpdate.getCmdUpdateType());
    assertSame(update, actualAlarmDataUpdate.getUpdate());
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, actualAlarmDataUpdate.getData());
  }

  /**
   * Test {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return Update is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, long, long); given 'null'; then return Update is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmDataUpdate.<init>(int, PageData, List, long, long)"})
  void testNewAlarmDataUpdate_givenNull_thenReturnUpdateIsArrayList2() {
    // Arrange
    PageData<AlarmData> data = PageData.emptyPageData();

    ArrayList<AlarmData> update = new ArrayList<>();
    update.add(null);

    // Act
    AlarmDataUpdate actualAlarmDataUpdate = new AlarmDataUpdate(1, data, update, 1L, 1L);

    // Assert
    assertNull(actualAlarmDataUpdate.getErrorMsg());
    assertEquals(0, actualAlarmDataUpdate.getErrorCode());
    assertEquals(1, actualAlarmDataUpdate.getCmdId());
    assertEquals(1L, actualAlarmDataUpdate.getAllowedEntities());
    assertEquals(1L, actualAlarmDataUpdate.getTotalEntities());
    assertEquals(CmdUpdateType.ALARM_DATA, actualAlarmDataUpdate.getCmdUpdateType());
    assertSame(update, actualAlarmDataUpdate.getUpdate());
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, actualAlarmDataUpdate.getData());
  }

  /**
   * Test {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Update Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, int, String, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, int, String, long, long); when ArrayList(); then return Update Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmDataUpdate.<init>(int, PageData, List, int, String, long, long)"})
  void testNewAlarmDataUpdate_whenArrayList_thenReturnUpdateEmpty() {
    // Arrange
    PageData<AlarmData> data = PageData.emptyPageData();

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
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, actualAlarmDataUpdate.getData());
  }

  /**
   * Test {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Update Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUpdate#AlarmDataUpdate(int, PageData, List, long, long)}
   */
  @Test
  @DisplayName("Test new AlarmDataUpdate(int, PageData, List, long, long); when ArrayList(); then return Update Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmDataUpdate.<init>(int, PageData, List, long, long)"})
  void testNewAlarmDataUpdate_whenArrayList_thenReturnUpdateEmpty2() {
    // Arrange
    PageData<AlarmData> data = PageData.emptyPageData();

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
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, actualAlarmDataUpdate.getData());
  }
}
