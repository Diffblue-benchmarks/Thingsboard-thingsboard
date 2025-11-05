package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;

class DeviceAttributesDiffblueTest {
  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   *
   * <ul>
   *   <li>Then return ClientSideAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName(
      "Test new DeviceAttributes(List, List, List); then return ClientSideAttributes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceAttributes.<init>(List, List, List)"})
  void testNewDeviceAttributes_thenReturnClientSideAttributesSizeIsOne() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    clientSideAttributes.add(baseAttributeKvEntry);

    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    serverPrivateAttributes.add(baseAttributeKvEntry2);

    ArrayList<AttributeKvEntry> serverPublicAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry3 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    serverPublicAttributes.add(baseAttributeKvEntry3);

    // Act
    DeviceAttributes actualDeviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, serverPublicAttributes);

    // Assert
    assertEquals(1, actualDeviceAttributes.getClientSideAttributes().size());
    assertEquals(1, actualDeviceAttributes.getServerSideAttributes().size());
    assertEquals(1, actualDeviceAttributes.getServerSidePublicAttributes().size());
  }

  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   *
   * <ul>
   *   <li>Then return ServerSidePublicAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName(
      "Test new DeviceAttributes(List, List, List); then return ServerSidePublicAttributes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceAttributes.<init>(List, List, List)"})
  void testNewDeviceAttributes_thenReturnServerSidePublicAttributesSizeIsOne() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    ArrayList<AttributeKvEntry> serverPublicAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    serverPublicAttributes.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    serverPublicAttributes.add(baseAttributeKvEntry2);

    // Act
    DeviceAttributes actualDeviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, serverPublicAttributes);

    // Assert
    assertEquals(1, actualDeviceAttributes.getServerSidePublicAttributes().size());
    assertTrue(actualDeviceAttributes.getClientSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ClientSideAttributes Empty.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName(
      "Test new DeviceAttributes(List, List, List); when ArrayList(); then return ClientSideAttributes Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceAttributes.<init>(List, List, List)"})
  void testNewDeviceAttributes_whenArrayList_thenReturnClientSideAttributesEmpty() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    DeviceAttributes actualDeviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Assert
    assertTrue(actualDeviceAttributes.getClientSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSidePublicAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ClientSideAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName(
      "Test new DeviceAttributes(List, List, List); when ArrayList(); then return ClientSideAttributes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceAttributes.<init>(List, List, List)"})
  void testNewDeviceAttributes_whenArrayList_thenReturnClientSideAttributesSizeIsOne() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    clientSideAttributes.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    clientSideAttributes.add(baseAttributeKvEntry2);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    DeviceAttributes actualDeviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Assert
    assertEquals(1, actualDeviceAttributes.getClientSideAttributes().size());
    assertTrue(actualDeviceAttributes.getServerSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSidePublicAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ServerSideAttributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName(
      "Test new DeviceAttributes(List, List, List); when ArrayList(); then return ServerSideAttributes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceAttributes.<init>(List, List, List)"})
  void testNewDeviceAttributes_whenArrayList_thenReturnServerSideAttributesSizeIsOne() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();

    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    BaseAttributeKvEntry baseAttributeKvEntry =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    serverPrivateAttributes.add(baseAttributeKvEntry);
    BaseAttributeKvEntry baseAttributeKvEntry2 =
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    serverPrivateAttributes.add(baseAttributeKvEntry2);

    // Act
    DeviceAttributes actualDeviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Assert
    assertEquals(1, actualDeviceAttributes.getServerSideAttributes().size());
    assertTrue(actualDeviceAttributes.getClientSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSidePublicAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getClientSideAttributes()}.
   *
   * <p>Method under test: {@link DeviceAttributes#getClientSideAttributes()}
   */
  @Test
  @DisplayName("Test getClientSideAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection DeviceAttributes.getClientSideAttributes()"})
  void testGetClientSideAttributes() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertTrue(deviceAttributes.getClientSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getServerSideAttributes()}.
   *
   * <p>Method under test: {@link DeviceAttributes#getServerSideAttributes()}
   */
  @Test
  @DisplayName("Test getServerSideAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection DeviceAttributes.getServerSideAttributes()"})
  void testGetServerSideAttributes() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertTrue(deviceAttributes.getServerSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getServerSidePublicAttributes()}.
   *
   * <p>Method under test: {@link DeviceAttributes#getServerSidePublicAttributes()}
   */
  @Test
  @DisplayName("Test getServerSidePublicAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection DeviceAttributes.getServerSidePublicAttributes()"})
  void testGetServerSidePublicAttributes() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertTrue(deviceAttributes.getServerSidePublicAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getClientSideAttribute(String)}.
   *
   * <p>Method under test: {@link DeviceAttributes#getClientSideAttribute(String)}
   */
  @Test
  @DisplayName("Test getClientSideAttribute(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional DeviceAttributes.getClientSideAttribute(String)"})
  void testGetClientSideAttribute() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertFalse(deviceAttributes.getClientSideAttribute("Attribute").isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getServerPrivateAttribute(String)}.
   *
   * <p>Method under test: {@link DeviceAttributes#getServerPrivateAttribute(String)}
   */
  @Test
  @DisplayName("Test getServerPrivateAttribute(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional DeviceAttributes.getServerPrivateAttribute(String)"})
  void testGetServerPrivateAttribute() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertFalse(deviceAttributes.getServerPrivateAttribute("Attribute").isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getServerPublicAttribute(String)}.
   *
   * <p>Method under test: {@link DeviceAttributes#getServerPublicAttribute(String)}
   */
  @Test
  @DisplayName("Test getServerPublicAttribute(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional DeviceAttributes.getServerPublicAttribute(String)"})
  void testGetServerPublicAttribute() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertFalse(deviceAttributes.getServerPublicAttribute("Attribute").isPresent());
  }

  /**
   * Test {@link DeviceAttributes#toString()}.
   *
   * <p>Method under test: {@link DeviceAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeviceAttributes.toString()"})
  void testToString() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    DeviceAttributes deviceAttributes =
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>());

    // Act and Assert
    assertEquals(
        "DeviceAttributes{clientSideAttributesMap={}, serverPrivateAttributesMap={}, serverPublicAttributesMap"
            + "={}}",
        deviceAttributes.toString());
  }
}
