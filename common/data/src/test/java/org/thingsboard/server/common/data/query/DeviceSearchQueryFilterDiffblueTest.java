package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class DeviceSearchQueryFilterDiffblueTest {
  /**
   * Test {@link DeviceSearchQueryFilter#equals(Object)}, and {@link
   * DeviceSearchQueryFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQueryFilter#equals(Object)}
   *   <li>{@link DeviceSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceSearchQueryFilter.equals(Object)",
    "int DeviceSearchQueryFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
    int expectedHashCodeResult = deviceSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQueryFilter2.hashCode());
  }

  /**
   * Test {@link DeviceSearchQueryFilter#equals(Object)}, and {@link
   * DeviceSearchQueryFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSearchQueryFilter#equals(Object)}
   *   <li>{@link DeviceSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceSearchQueryFilter.equals(Object)",
    "int DeviceSearchQueryFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(deviceSearchQueryFilter, deviceSearchQueryFilter);
    int expectedHashCodeResult = deviceSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQueryFilter.hashCode());
  }

  /**
   * Test {@link DeviceSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceSearchQueryFilter.equals(Object)",
    "int DeviceSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("Relation Type");

    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(deviceTypes);
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
  }

  /**
   * Test {@link DeviceSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceSearchQueryFilter.equals(Object)",
    "int DeviceSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(null);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
  }

  /**
   * Test {@link DeviceSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceSearchQueryFilter.equals(Object)",
    "int DeviceSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, null);
  }

  /**
   * Test {@link DeviceSearchQueryFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceSearchQueryFilter.equals(Object)",
    "int DeviceSearchQueryFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, "Different type to DeviceSearchQueryFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceSearchQueryFilter}
   *   <li>{@link DeviceSearchQueryFilter#setDeviceTypes(List)}
   *   <li>{@link DeviceSearchQueryFilter#toString()}
   *   <li>{@link DeviceSearchQueryFilter#getDeviceTypes()}
   *   <li>{@link DeviceSearchQueryFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceSearchQueryFilter.<init>()",
    "List DeviceSearchQueryFilter.getDeviceTypes()",
    "EntityFilterType DeviceSearchQueryFilter.getType()",
    "void DeviceSearchQueryFilter.setDeviceTypes(List)",
    "String DeviceSearchQueryFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceSearchQueryFilter actualDeviceSearchQueryFilter = new DeviceSearchQueryFilter();
    ArrayList<String> deviceTypes = new ArrayList<>();
    actualDeviceSearchQueryFilter.setDeviceTypes(deviceTypes);
    String actualToStringResult = actualDeviceSearchQueryFilter.toString();
    List<String> actualDeviceTypes = actualDeviceSearchQueryFilter.getDeviceTypes();
    EntityFilterType actualType = actualDeviceSearchQueryFilter.getType();

    // Assert
    assertEquals(
        "DeviceSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), deviceTypes=[])",
        actualToStringResult);
    assertNull(actualDeviceSearchQueryFilter.getRelationType());
    assertNull(actualDeviceSearchQueryFilter.getRootEntity());
    assertNull(actualDeviceSearchQueryFilter.getDirection());
    assertEquals(0, actualDeviceSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.DEVICE_SEARCH_QUERY, actualType);
    assertFalse(actualDeviceSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualDeviceTypes.isEmpty());
    assertSame(deviceTypes, actualDeviceTypes);
  }
}
