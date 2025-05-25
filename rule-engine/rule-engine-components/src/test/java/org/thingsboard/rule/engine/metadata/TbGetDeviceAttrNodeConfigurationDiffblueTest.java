package org.thingsboard.rule.engine.metadata;

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
import org.thingsboard.rule.engine.data.DeviceRelationsQuery;
import org.thingsboard.rule.engine.util.TbMsgSource;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbGetDeviceAttrNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbGetDeviceAttrNodeConfiguration TbGetDeviceAttrNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGetDeviceAttrNodeConfiguration actualDefaultConfigurationResult = (new TbGetDeviceAttrNodeConfiguration())
        .defaultConfiguration();

    // Assert
    DeviceRelationsQuery deviceRelationsQuery = actualDefaultConfigurationResult.getDeviceRelationsQuery();
    assertEquals("Contains", deviceRelationsQuery.getRelationType());
    assertEquals(1, deviceRelationsQuery.getDeviceTypes().size());
    assertEquals(1, deviceRelationsQuery.getMaxLevel());
    assertEquals(TbMsgSource.METADATA, actualDefaultConfigurationResult.getFetchTo());
    assertEquals(EntitySearchDirection.FROM, deviceRelationsQuery.getDirection());
    assertFalse(deviceRelationsQuery.isFetchLastLevelOnly());
    assertFalse(actualDefaultConfigurationResult.isGetLatestValueWithTs());
    List<String> clientAttributeNames = actualDefaultConfigurationResult.getClientAttributeNames();
    assertTrue(clientAttributeNames.isEmpty());
    assertTrue(actualDefaultConfigurationResult.isTellFailureIfAbsent());
    assertSame(clientAttributeNames, actualDefaultConfigurationResult.getLatestTsKeyNames());
    assertSame(clientAttributeNames, actualDefaultConfigurationResult.getServerAttributeNames());
    assertSame(clientAttributeNames, actualDefaultConfigurationResult.getSharedAttributeNames());
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}, and {@link TbGetDeviceAttrNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration2 = new TbGetDeviceAttrNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetDeviceAttrNodeConfiguration, tbGetDeviceAttrNodeConfiguration2);
    int expectedHashCodeResult = tbGetDeviceAttrNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetDeviceAttrNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}, and {@link TbGetDeviceAttrNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();
    tbGetDeviceAttrNodeConfiguration.setDeviceRelationsQuery(deviceRelationsQuery);

    DeviceRelationsQuery deviceRelationsQuery2 = new DeviceRelationsQuery();
    deviceRelationsQuery2.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery2.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery2.setFetchLastLevelOnly(true);
    deviceRelationsQuery2.setMaxLevel(3);
    deviceRelationsQuery2.setRelationType("Relation Type");

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration2 = new TbGetDeviceAttrNodeConfiguration();
    tbGetDeviceAttrNodeConfiguration2.setDeviceRelationsQuery(deviceRelationsQuery2);

    // Act and Assert
    assertEquals(tbGetDeviceAttrNodeConfiguration, tbGetDeviceAttrNodeConfiguration2);
    int expectedHashCodeResult = tbGetDeviceAttrNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetDeviceAttrNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}, and {@link TbGetDeviceAttrNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetDeviceAttrNodeConfiguration, tbGetDeviceAttrNodeConfiguration);
    int expectedHashCodeResult = tbGetDeviceAttrNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetDeviceAttrNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetDeviceAttrNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();
    tbGetDeviceAttrNodeConfiguration.setDeviceRelationsQuery(deviceRelationsQuery);

    // Act and Assert
    assertNotEquals(tbGetDeviceAttrNodeConfiguration, new TbGetDeviceAttrNodeConfiguration());
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();
    tbGetDeviceAttrNodeConfiguration.setClientAttributeNames(new ArrayList<>());

    // Act and Assert
    assertNotEquals(tbGetDeviceAttrNodeConfiguration, new TbGetDeviceAttrNodeConfiguration());
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();

    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration2 = new TbGetDeviceAttrNodeConfiguration();
    tbGetDeviceAttrNodeConfiguration2.setDeviceRelationsQuery(deviceRelationsQuery);

    // Act and Assert
    assertNotEquals(tbGetDeviceAttrNodeConfiguration, tbGetDeviceAttrNodeConfiguration2);
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetDeviceAttrNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbGetDeviceAttrNodeConfiguration.equals(Object)",
      "int TbGetDeviceAttrNodeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetDeviceAttrNodeConfiguration(), "Different type to TbGetDeviceAttrNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetDeviceAttrNodeConfiguration}
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#setDeviceRelationsQuery(DeviceRelationsQuery)}
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#toString()}
   *   <li>{@link TbGetDeviceAttrNodeConfiguration#getDeviceRelationsQuery()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetDeviceAttrNodeConfiguration.<init>()",
      "DeviceRelationsQuery TbGetDeviceAttrNodeConfiguration.getDeviceRelationsQuery()",
      "void TbGetDeviceAttrNodeConfiguration.setDeviceRelationsQuery(DeviceRelationsQuery)",
      "String TbGetDeviceAttrNodeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetDeviceAttrNodeConfiguration actualTbGetDeviceAttrNodeConfiguration = new TbGetDeviceAttrNodeConfiguration();
    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");
    actualTbGetDeviceAttrNodeConfiguration.setDeviceRelationsQuery(deviceRelationsQuery);
    String actualToStringResult = actualTbGetDeviceAttrNodeConfiguration.toString();
    DeviceRelationsQuery actualDeviceRelationsQuery = actualTbGetDeviceAttrNodeConfiguration.getDeviceRelationsQuery();

    // Assert
    assertEquals(
        "TbGetDeviceAttrNodeConfiguration(deviceRelationsQuery=DeviceRelationsQuery(direction=FROM, maxLevel=3,"
            + " relationType=Relation Type, deviceTypes=[], fetchLastLevelOnly=true))",
        actualToStringResult);
    assertNull(actualTbGetDeviceAttrNodeConfiguration.getClientAttributeNames());
    assertNull(actualTbGetDeviceAttrNodeConfiguration.getLatestTsKeyNames());
    assertNull(actualTbGetDeviceAttrNodeConfiguration.getServerAttributeNames());
    assertNull(actualTbGetDeviceAttrNodeConfiguration.getSharedAttributeNames());
    assertNull(actualTbGetDeviceAttrNodeConfiguration.getFetchTo());
    assertFalse(actualTbGetDeviceAttrNodeConfiguration.isGetLatestValueWithTs());
    assertFalse(actualTbGetDeviceAttrNodeConfiguration.isTellFailureIfAbsent());
    assertSame(deviceRelationsQuery, actualDeviceRelationsQuery);
  }
}
