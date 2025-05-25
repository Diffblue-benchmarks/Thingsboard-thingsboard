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

class LatestTsDeletionHousekeeperTaskDiffblueTest {
  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}, and {@link LatestTsDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask2 = new LatestTsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask2);
    int expectedHashCodeResult = latestTsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, latestTsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}, and {@link LatestTsDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask2 = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask2);
    int expectedHashCodeResult = latestTsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, latestTsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}, and {@link LatestTsDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask);
    int expectedHashCodeResult = latestTsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, latestTsDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertNotEquals(latestTsDeletionHousekeeperTask, new LatestTsDeletionHousekeeperTask());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();
    latestTsDeletionHousekeeperTask.setKey("Key");

    // Act and Assert
    assertNotEquals(latestTsDeletionHousekeeperTask, new LatestTsDeletionHousekeeperTask());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();

    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask2 = new LatestTsDeletionHousekeeperTask();
    latestTsDeletionHousekeeperTask2.setKey("Key");

    // Act and Assert
    assertNotEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask2);
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LatestTsDeletionHousekeeperTask(), null);
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LatestTsDeletionHousekeeperTask.equals(Object)",
      "int LatestTsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LatestTsDeletionHousekeeperTask(), "Different type to LatestTsDeletionHousekeeperTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#LatestTsDeletionHousekeeperTask()}
   *   <li>{@link LatestTsDeletionHousekeeperTask#setKey(String)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#toString()}
   *   <li>{@link LatestTsDeletionHousekeeperTask#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LatestTsDeletionHousekeeperTask.<init>()", "String LatestTsDeletionHousekeeperTask.getKey()",
      "void LatestTsDeletionHousekeeperTask.setKey(String)", "String LatestTsDeletionHousekeeperTask.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LatestTsDeletionHousekeeperTask actualLatestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();
    actualLatestTsDeletionHousekeeperTask.setKey("Key");
    String actualToStringResult = actualLatestTsDeletionHousekeeperTask.toString();

    // Assert
    assertEquals("Key", actualLatestTsDeletionHousekeeperTask.getKey());
    assertEquals("LatestTsDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
        + " ts=0), key=Key)", actualToStringResult);
    assertNull(actualLatestTsDeletionHousekeeperTask.getTaskType());
    assertNull(actualLatestTsDeletionHousekeeperTask.getEntityId());
    assertNull(actualLatestTsDeletionHousekeeperTask.getTenantId());
    assertEquals(0L, actualLatestTsDeletionHousekeeperTask.getTs());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#LatestTsDeletionHousekeeperTask(TenantId, EntityId, String)}.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#LatestTsDeletionHousekeeperTask(TenantId, EntityId, String)}
   */
  @Test
  @DisplayName("Test new LatestTsDeletionHousekeeperTask(TenantId, EntityId, String); when SYS_TENANT_ID; then return 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LatestTsDeletionHousekeeperTask.<init>(TenantId, EntityId, String)"})
  void testNewLatestTsDeletionHousekeeperTask_whenSys_tenant_id_thenReturnKey() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    LatestTsDeletionHousekeeperTask actualLatestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, "Key");

    // Assert
    assertEquals("Key", actualLatestTsDeletionHousekeeperTask.getKey());
    assertEquals("latest telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        actualLatestTsDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_LATEST_TS, actualLatestTsDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualLatestTsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualLatestTsDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LatestTsDeletionHousekeeperTask.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("latest telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        (new LatestTsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key")).getDescription());
  }

  /**
   * Test {@link LatestTsDeletionHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link LatestTsDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LatestTsDeletionHousekeeperTask.getDescription()"})
  void testGetDescription2() {
    // Arrange, Act and Assert
    assertEquals("latest telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        (new LatestTsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, null)).getDescription());
  }
}
