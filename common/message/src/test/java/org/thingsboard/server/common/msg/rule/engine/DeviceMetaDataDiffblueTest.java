package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(deviceId, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Type", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, null, "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Name",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", null,
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Name", "Device Type", null);
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>())), 1);
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(deviceId, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    DeviceId deviceId2 = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(deviceId2, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, "Device Type", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(deviceId, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Test {@link DeviceMetaData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceMetaData.equals(Object)", "int DeviceMetaData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(null, null, "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, null, "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }
}
