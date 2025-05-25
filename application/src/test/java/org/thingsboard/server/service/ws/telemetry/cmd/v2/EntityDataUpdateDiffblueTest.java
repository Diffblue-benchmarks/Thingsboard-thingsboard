package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityKeyType;
import org.thingsboard.server.common.data.query.TsValue;

class EntityDataUpdateDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Update is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataUpdate#EntityDataUpdate(int, int, String)}
   *   <li>{@link EntityDataUpdate#toString()}
   *   <li>{@link EntityDataUpdate#getAllowedEntities()}
   *   <li>{@link EntityDataUpdate#getCmdUpdateType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return Update is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityDataUpdate.<init>(int, int, String)",
      "void EntityDataUpdate.<init>(int, PageData, List, int, String)", "long EntityDataUpdate.getAllowedEntities()",
      "CmdUpdateType EntityDataUpdate.getCmdUpdateType()", "String EntityDataUpdate.toString()"})
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnUpdateIsNull() {
    // Arrange and Act
    EntityDataUpdate actualEntityDataUpdate = new EntityDataUpdate(1, -1, "An error occurred");
    String actualToStringResult = actualEntityDataUpdate.toString();
    long actualAllowedEntities = actualEntityDataUpdate.getAllowedEntities();
    CmdUpdateType actualCmdUpdateType = actualEntityDataUpdate.getCmdUpdateType();

    // Assert
    assertEquals("An error occurred", actualEntityDataUpdate.getErrorMsg());
    assertEquals("EntityDataUpdate(allowedEntities=0)", actualToStringResult);
    assertNull(actualEntityDataUpdate.getUpdate());
    assertNull(actualEntityDataUpdate.getData());
    assertEquals(-1, actualEntityDataUpdate.getErrorCode());
    assertEquals(0L, actualAllowedEntities);
    assertEquals(1, actualEntityDataUpdate.getCmdId());
    assertEquals(CmdUpdateType.ENTITY_DATA, actualCmdUpdateType);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When emptyPageData.</li>
   *   <li>Then return Update Empty.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataUpdate#EntityDataUpdate(int, PageData, List, int, String)}
   *   <li>{@link EntityDataUpdate#toString()}
   *   <li>{@link EntityDataUpdate#getAllowedEntities()}
   *   <li>{@link EntityDataUpdate#getCmdUpdateType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when emptyPageData; then return Update Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityDataUpdate.<init>(int, int, String)",
      "void EntityDataUpdate.<init>(int, PageData, List, int, String)", "long EntityDataUpdate.getAllowedEntities()",
      "CmdUpdateType EntityDataUpdate.getCmdUpdateType()", "String EntityDataUpdate.toString()"})
  void testGettersAndSetters_whenEmptyPageData_thenReturnUpdateEmpty() {
    // Arrange
    PageData<EntityData> data = PageData.emptyPageData();
    ArrayList<EntityData> update = new ArrayList<>();

    // Act
    EntityDataUpdate actualEntityDataUpdate = new EntityDataUpdate(1, data, update, -1, "An error occurred");
    String actualToStringResult = actualEntityDataUpdate.toString();
    long actualAllowedEntities = actualEntityDataUpdate.getAllowedEntities();
    CmdUpdateType actualCmdUpdateType = actualEntityDataUpdate.getCmdUpdateType();

    // Assert
    assertEquals("An error occurred", actualEntityDataUpdate.getErrorMsg());
    assertEquals("EntityDataUpdate(allowedEntities=0)", actualToStringResult);
    assertEquals(-1, actualEntityDataUpdate.getErrorCode());
    assertEquals(0L, actualAllowedEntities);
    assertEquals(1, actualEntityDataUpdate.getCmdId());
    assertEquals(CmdUpdateType.ENTITY_DATA, actualCmdUpdateType);
    List<EntityData> update2 = actualEntityDataUpdate.getUpdate();
    assertTrue(update2.isEmpty());
    assertSame(update, update2);
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, actualEntityDataUpdate.getData());
  }

  /**
   * Test {@link EntityDataUpdate#EntityDataUpdate(int, PageData, List, long)}.
   * <ul>
   *   <li>Then return Update is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataUpdate#EntityDataUpdate(int, PageData, List, long)}
   */
  @Test
  @DisplayName("Test new EntityDataUpdate(int, PageData, List, long); then return Update is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityDataUpdate.<init>(int, PageData, List, long)"})
  void testNewEntityDataUpdate_thenReturnUpdateIsArrayList() {
    // Arrange
    PageData<EntityData> data = PageData.emptyPageData();

    ArrayList<EntityData> update = new ArrayList<>();
    HashMap<EntityKeyType, Map<String, TsValue>> latest = new HashMap<>();
    update.add(new EntityData(null, latest, new HashMap<>()));

    // Act and Assert
    assertSame(update, (new EntityDataUpdate(1, data, update, 1L)).getUpdate());
  }

  /**
   * Test {@link EntityDataUpdate#EntityDataUpdate(int, PageData, List, long)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataUpdate#EntityDataUpdate(int, PageData, List, long)}
   */
  @Test
  @DisplayName("Test new EntityDataUpdate(int, PageData, List, long); when ArrayList(); then return ErrorMsg is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityDataUpdate.<init>(int, PageData, List, long)"})
  void testNewEntityDataUpdate_whenArrayList_thenReturnErrorMsgIsNull() {
    // Arrange
    PageData<EntityData> data = PageData.emptyPageData();

    // Act
    EntityDataUpdate actualEntityDataUpdate = new EntityDataUpdate(1, data, new ArrayList<>(), 1L);

    // Assert
    assertNull(actualEntityDataUpdate.getErrorMsg());
    assertEquals(0, actualEntityDataUpdate.getErrorCode());
    assertEquals(1, actualEntityDataUpdate.getCmdId());
    assertEquals(1L, actualEntityDataUpdate.getAllowedEntities());
    assertEquals(CmdUpdateType.ENTITY_DATA, actualEntityDataUpdate.getCmdUpdateType());
    assertTrue(actualEntityDataUpdate.getUpdate().isEmpty());
    PageData expectedData = data.EMPTY_PAGE_DATA;
    assertSame(expectedData, actualEntityDataUpdate.getData());
  }
}
