package org.thingsboard.rule.engine.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class DeviceRelationsQueryDiffblueTest {
  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}, and {@link DeviceRelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceRelationsQuery#equals(Object)}
   *   <li>{@link DeviceRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(deviceRelationsQuery, deviceRelationsQuery2);
    int expectedHashCodeResult = deviceRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceRelationsQuery2.hashCode());
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}, and {@link DeviceRelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceRelationsQuery#equals(Object)}
   *   <li>{@link DeviceRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(null);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(null);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(deviceRelationsQuery, deviceRelationsQuery2);
    int expectedHashCodeResult = deviceRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceRelationsQuery2.hashCode());
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}, and {@link DeviceRelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceRelationsQuery#equals(Object)}
   *   <li>{@link DeviceRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType(null);

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType(null);

    // Act and Assert
    assertEquals(deviceRelationsQuery, deviceRelationsQuery2);
    int expectedHashCodeResult = deviceRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceRelationsQuery2.hashCode());
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}, and {@link DeviceRelationsQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceRelationsQuery#equals(Object)}
   *   <li>{@link DeviceRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(deviceRelationsQuery, deviceRelationsQuery);
    int expectedHashCodeResult = deviceRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, deviceRelationsQuery.hashCode());
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(deviceTypes);
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(null);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.TO);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(false);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(1);
    deviceRelationsQuery.setRelationType("Relation Type");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType(null);

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("org.thingsboard.rule.engine.data.DeviceRelationsQuery");

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, deviceRelationsQuery2);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, null);
  }

  /**
   * Test {@link DeviceRelationsQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceRelationsQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceRelationsQuery.equals(Object)",
    "int DeviceRelationsQuery.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(deviceRelationsQuery, "Different type to DeviceRelationsQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceRelationsQuery}
   *   <li>{@link DeviceRelationsQuery#setDeviceTypes(List)}
   *   <li>{@link DeviceRelationsQuery#setDirection(EntitySearchDirection)}
   *   <li>{@link DeviceRelationsQuery#setFetchLastLevelOnly(boolean)}
   *   <li>{@link DeviceRelationsQuery#setMaxLevel(int)}
   *   <li>{@link DeviceRelationsQuery#setRelationType(String)}
   *   <li>{@link DeviceRelationsQuery#toString()}
   *   <li>{@link DeviceRelationsQuery#getDeviceTypes()}
   *   <li>{@link DeviceRelationsQuery#getDirection()}
   *   <li>{@link DeviceRelationsQuery#getMaxLevel()}
   *   <li>{@link DeviceRelationsQuery#getRelationType()}
   *   <li>{@link DeviceRelationsQuery#isFetchLastLevelOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceRelationsQuery.<init>()",
    "List DeviceRelationsQuery.getDeviceTypes()",
    "EntitySearchDirection DeviceRelationsQuery.getDirection()",
    "int DeviceRelationsQuery.getMaxLevel()",
    "String DeviceRelationsQuery.getRelationType()",
    "boolean DeviceRelationsQuery.isFetchLastLevelOnly()",
    "void DeviceRelationsQuery.setDeviceTypes(List)",
    "void DeviceRelationsQuery.setDirection(EntitySearchDirection)",
    "void DeviceRelationsQuery.setFetchLastLevelOnly(boolean)",
    "void DeviceRelationsQuery.setMaxLevel(int)",
    "void DeviceRelationsQuery.setRelationType(String)",
    "String DeviceRelationsQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceRelationsQuery actualDeviceRelationsQuery = new DeviceRelationsQuery();
    ArrayList<String> deviceTypes = new ArrayList<>();
    actualDeviceRelationsQuery.setDeviceTypes(deviceTypes);
    actualDeviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    actualDeviceRelationsQuery.setFetchLastLevelOnly(true);
    actualDeviceRelationsQuery.setMaxLevel(3);
    actualDeviceRelationsQuery.setRelationType("Relation Type");
    String actualToStringResult = actualDeviceRelationsQuery.toString();
    List<String> actualDeviceTypes = actualDeviceRelationsQuery.getDeviceTypes();
    EntitySearchDirection actualDirection = actualDeviceRelationsQuery.getDirection();
    int actualMaxLevel = actualDeviceRelationsQuery.getMaxLevel();
    String actualRelationType = actualDeviceRelationsQuery.getRelationType();
    boolean actualIsFetchLastLevelOnlyResult = actualDeviceRelationsQuery.isFetchLastLevelOnly();

    // Assert
    assertEquals(
        "DeviceRelationsQuery(direction=FROM, maxLevel=3, relationType=Relation Type, deviceTypes=[],"
            + " fetchLastLevelOnly=true)",
        actualToStringResult);
    assertEquals("Relation Type", actualRelationType);
    assertEquals(3, actualMaxLevel);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertTrue(actualDeviceTypes.isEmpty());
    assertTrue(actualIsFetchLastLevelOnlyResult);
    assertSame(deviceTypes, actualDeviceTypes);
  }
}
