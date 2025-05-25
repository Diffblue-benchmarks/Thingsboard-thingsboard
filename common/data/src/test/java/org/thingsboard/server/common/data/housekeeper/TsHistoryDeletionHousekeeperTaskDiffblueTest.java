package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TsHistoryDeletionHousekeeperTaskDiffblueTest {
  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}, and {@link TsHistoryDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask2 = new TsHistoryDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask2);
    int expectedHashCodeResult = tsHistoryDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tsHistoryDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}, and {@link TsHistoryDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask2 = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask2);
    int expectedHashCodeResult = tsHistoryDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tsHistoryDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}, and {@link TsHistoryDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask);
    int expectedHashCodeResult = tsHistoryDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tsHistoryDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertNotEquals(tsHistoryDeletionHousekeeperTask, new TsHistoryDeletionHousekeeperTask());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();
    tsHistoryDeletionHousekeeperTask.setKey("Key");

    // Act and Assert
    assertNotEquals(tsHistoryDeletionHousekeeperTask, new TsHistoryDeletionHousekeeperTask());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();

    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask2 = new TsHistoryDeletionHousekeeperTask();
    tsHistoryDeletionHousekeeperTask2.setKey("Key");

    // Act and Assert
    assertNotEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask2);
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsHistoryDeletionHousekeeperTask(), null);
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TsHistoryDeletionHousekeeperTask.equals(Object)",
      "int TsHistoryDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsHistoryDeletionHousekeeperTask(), "Different type to TsHistoryDeletionHousekeeperTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#TsHistoryDeletionHousekeeperTask()}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#setKey(String)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#toString()}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsHistoryDeletionHousekeeperTask.<init>()",
      "String TsHistoryDeletionHousekeeperTask.getKey()", "void TsHistoryDeletionHousekeeperTask.setKey(String)",
      "String TsHistoryDeletionHousekeeperTask.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TsHistoryDeletionHousekeeperTask actualTsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();
    actualTsHistoryDeletionHousekeeperTask.setKey("Key");
    String actualToStringResult = actualTsHistoryDeletionHousekeeperTask.toString();

    // Assert
    assertEquals("Key", actualTsHistoryDeletionHousekeeperTask.getKey());
    assertEquals("TsHistoryDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
        + " ts=0), key=Key)", actualToStringResult);
    assertNull(actualTsHistoryDeletionHousekeeperTask.getTaskType());
    assertNull(actualTsHistoryDeletionHousekeeperTask.getEntityId());
    assertNull(actualTsHistoryDeletionHousekeeperTask.getTenantId());
    assertEquals(0L, actualTsHistoryDeletionHousekeeperTask.getTs());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#TsHistoryDeletionHousekeeperTask(TenantId, EntityId, String)}.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#TsHistoryDeletionHousekeeperTask(TenantId, EntityId, String)}
   */
  @Test
  @DisplayName("Test new TsHistoryDeletionHousekeeperTask(TenantId, EntityId, String); when SYS_TENANT_ID; then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TsHistoryDeletionHousekeeperTask.<init>(TenantId, EntityId, String)"})
  void testNewTsHistoryDeletionHousekeeperTask_whenSys_tenant_id_thenReturnKey() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    TsHistoryDeletionHousekeeperTask actualTsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, "Key");

    // Assert
    assertEquals("Key", actualTsHistoryDeletionHousekeeperTask.getKey());
    assertEquals("timeseries history deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        actualTsHistoryDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_TS_HISTORY, actualTsHistoryDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualTsHistoryDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualTsHistoryDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TsHistoryDeletionHousekeeperTask.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("timeseries history deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        (new TsHistoryDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key")).getDescription());
  }

  /**
   * Test {@link TsHistoryDeletionHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TsHistoryDeletionHousekeeperTask.getDescription()"})
  void testGetDescription2() {
    // Arrange, Act and Assert
    assertEquals("timeseries history deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        (new TsHistoryDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, null)).getDescription());
  }
}
