package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class EntityAlarmDiffblueTest {
  /**
   * Test {@link EntityAlarm#equals(Object)}, and {@link EntityAlarm#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    EntityAlarm entityAlarm2 = new EntityAlarm();

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}, and {@link EntityAlarm#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setTenantId(TenantId.SYS_TENANT_ID);

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}, and {@link EntityAlarm#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setEntityId(TenantId.SYS_TENANT_ID);

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}, and {@link EntityAlarm#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmType("Alarm Type");

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAlarmType("Alarm Type");

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}, and {@link EntityAlarm#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm2);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm2.hashCode());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}, and {@link EntityAlarm#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#equals(Object)}
   *   <li>{@link EntityAlarm#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    // Act and Assert
    assertEquals(entityAlarm, entityAlarm);
    int expectedHashCodeResult = entityAlarm.hashCode();
    assertEquals(expectedHashCodeResult, entityAlarm.hashCode());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarm(), 1);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmType("Alarm Type");

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAlarmType("Alarm Type");

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAssigneeId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();
    entityAlarm.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(entityAlarm, new EntityAlarm());
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAssigneeId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityAlarm entityAlarm = new EntityAlarm();

    EntityAlarm entityAlarm2 = new EntityAlarm();
    entityAlarm2.setAlarmId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(entityAlarm, entityAlarm2);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarm(), null);
  }

  /**
   * Test {@link EntityAlarm#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityAlarm#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityAlarm.equals(Object)", "int EntityAlarm.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityAlarm(), "Different type to EntityAlarm");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityAlarm#EntityAlarm()}
   *   <li>{@link EntityAlarm#setAlarmType(String)}
   *   <li>{@link EntityAlarm#setCreatedTime(long)}
   *   <li>{@link EntityAlarm#setCustomerId(CustomerId)}
   *   <li>{@link EntityAlarm#setEntityId(EntityId)}
   *   <li>{@link EntityAlarm#setTenantId(TenantId)}
   *   <li>{@link EntityAlarm#toString()}
   *   <li>{@link EntityAlarm#getAlarmId()}
   *   <li>{@link EntityAlarm#getAlarmType()}
   *   <li>{@link EntityAlarm#getAssigneeId()}
   *   <li>{@link EntityAlarm#getCreatedTime()}
   *   <li>{@link EntityAlarm#getCustomerId()}
   *   <li>{@link EntityAlarm#getEntityId()}
   *   <li>{@link EntityAlarm#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityAlarm.<init>()", "AlarmId EntityAlarm.getAlarmId()",
      "String EntityAlarm.getAlarmType()", "UserId EntityAlarm.getAssigneeId()", "long EntityAlarm.getCreatedTime()",
      "CustomerId EntityAlarm.getCustomerId()", "EntityId EntityAlarm.getEntityId()",
      "TenantId EntityAlarm.getTenantId()", "void EntityAlarm.setAlarmId(AlarmId)",
      "void EntityAlarm.setAlarmType(String)", "void EntityAlarm.setAssigneeId(UserId)",
      "void EntityAlarm.setCreatedTime(long)", "void EntityAlarm.setCustomerId(CustomerId)",
      "void EntityAlarm.setEntityId(EntityId)", "void EntityAlarm.setTenantId(TenantId)",
      "String EntityAlarm.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityAlarm actualEntityAlarm = new EntityAlarm();
    actualEntityAlarm.setAlarmType("Alarm Type");
    actualEntityAlarm.setCreatedTime(1L);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualEntityAlarm.setCustomerId(customerId);
    actualEntityAlarm.setEntityId(TenantId.SYS_TENANT_ID);
    actualEntityAlarm.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualEntityAlarm.toString();
    AlarmId actualAlarmId = actualEntityAlarm.getAlarmId();
    String actualAlarmType = actualEntityAlarm.getAlarmType();
    UserId actualAssigneeId = actualEntityAlarm.getAssigneeId();
    long actualCreatedTime = actualEntityAlarm.getCreatedTime();
    CustomerId actualCustomerId = actualEntityAlarm.getCustomerId();
    EntityId actualEntityId = actualEntityAlarm.getEntityId();
    TenantId actualTenantId = actualEntityAlarm.getTenantId();

    // Assert
    assertEquals("Alarm Type", actualAlarmType);
    assertEquals(
        "EntityAlarm(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080,"
            + " createdTime=1, alarmType=Alarm Type, customerId=784f394c-42b6-435a-983c-b7beff2784f9, assigneeId=null,"
            + " alarmId=null)",
        actualToStringResult);
    assertNull(actualAlarmId);
    assertNull(actualAssigneeId);
    assertEquals(1L, actualCreatedTime);
    assertSame(customerId, actualCustomerId);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
