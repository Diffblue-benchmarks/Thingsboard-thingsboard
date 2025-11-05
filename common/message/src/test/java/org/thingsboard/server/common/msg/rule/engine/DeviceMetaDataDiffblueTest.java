package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;

class DeviceMetaDataDiffblueTest {
  /**
   * Test {@link DeviceMetaData#equals(Object)}, and {@link DeviceMetaData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceMetaData#equals(Object)}
   *   <li>{@link DeviceMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Type", null);
    DeviceMetaData deviceMetaData2 = new DeviceMetaData(null, "Device Name", "Device Type", null);

    // Act and Assert
    assertEquals(deviceMetaData, deviceMetaData2);
    assertEquals(deviceMetaData.hashCode(), deviceMetaData2.hashCode());
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    DeviceMetaData deviceMetaData =
        new DeviceMetaData(deviceId, "Device Name", "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Type", "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, null, "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Name", "Device Name", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", null, deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Type", null);
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertNotEquals(new DeviceMetaData(null, "Device Name", "Device Type", deviceAttributes), 1);
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    DeviceMetaData deviceMetaData =
        new DeviceMetaData(deviceId, "Device Name", "Device Type", deviceAttributes);
    DeviceId deviceId2 = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData,
        new DeviceMetaData(deviceId2, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData =
        new DeviceMetaData(null, "Device Type", "Device Type", deviceAttributes);
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData,
        new DeviceMetaData(deviceId, "Device Name", "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, null, "Device Type", deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, null, "Device Type", deviceAttributes2));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", null, deviceAttributes);
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    DeviceAttributes deviceAttributes2 =
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        deviceMetaData, new DeviceMetaData(null, "Device Name", null, deviceAttributes2));
  }
}
