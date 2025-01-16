package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AttributeKey;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;

class DeviceAttributesDiffblueTest {
  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link KvEntry#getKey()} return
   * {@code Key}.</li>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName("Test new DeviceAttributes(List, List, List); given AttributeKvEntry getKey() return 'Key'; then calls getKey()")
  void testNewDeviceAttributes_givenAttributeKvEntryGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);

    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    serverPrivateAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> serverPublicAttributes = new ArrayList<>();
    serverPublicAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    DeviceAttributes actualDeviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        serverPublicAttributes);

    // Assert
    verify(attributeKvEntry).getKey();
    assertEquals(1, actualDeviceAttributes.getClientSideAttributes().size());
    assertEquals(1, actualDeviceAttributes.getServerSideAttributes().size());
    assertEquals(1, actualDeviceAttributes.getServerSidePublicAttributes().size());
  }

  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   * <ul>
   *   <li>Then return ClientSideAttributes size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName("Test new DeviceAttributes(List, List, List); then return ClientSideAttributes size is one")
  void testNewDeviceAttributes_thenReturnClientSideAttributesSizeIsOne() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    serverPrivateAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    ArrayList<AttributeKvEntry> serverPublicAttributes = new ArrayList<>();
    serverPublicAttributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    DeviceAttributes actualDeviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        serverPublicAttributes);

    // Assert
    assertEquals(1, actualDeviceAttributes.getClientSideAttributes().size());
    assertEquals(1, actualDeviceAttributes.getServerSideAttributes().size());
    assertEquals(1, actualDeviceAttributes.getServerSidePublicAttributes().size());
  }

  /**
   * Test {@link DeviceAttributes#DeviceAttributes(List, List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ClientSideAttributes Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  @DisplayName("Test new DeviceAttributes(List, List, List); when ArrayList(); then return ClientSideAttributes Empty")
  void testNewDeviceAttributes_whenArrayList_thenReturnClientSideAttributesEmpty() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    DeviceAttributes actualDeviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());

    // Assert
    assertTrue(actualDeviceAttributes.getClientSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSideAttributes().isEmpty());
    assertTrue(actualDeviceAttributes.getServerSidePublicAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getClientSideAttributes()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getClientSideAttributes()}
   */
  @Test
  @DisplayName("Test getClientSideAttributes(); then return Empty")
  void testGetClientSideAttributes_thenReturnEmpty() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getClientSideAttributes()
        .isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getClientSideAttributes()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getClientSideAttributes()}
   */
  @Test
  @DisplayName("Test getClientSideAttributes(); then return size is one")
  void testGetClientSideAttributes_thenReturnSizeIsOne() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    Collection<AttributeKvEntry> actualClientSideAttributes = (new DeviceAttributes(clientSideAttributes,
        serverPrivateAttributes, new ArrayList<>())).getClientSideAttributes();

    // Assert
    verify(attributeKvEntry).getKey();
    assertEquals(1, actualClientSideAttributes.size());
  }

  /**
   * Test {@link DeviceAttributes#getServerSideAttributes()}.
   * <p>
   * Method under test: {@link DeviceAttributes#getServerSideAttributes()}
   */
  @Test
  @DisplayName("Test getServerSideAttributes()")
  void testGetServerSideAttributes() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getServerSideAttributes()
        .isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getServerSideAttributes()}.
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link KvEntry#getKey()} return
   * {@code Key}.</li>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getServerSideAttributes()}
   */
  @Test
  @DisplayName("Test getServerSideAttributes(); given AttributeKvEntry getKey() return 'Key'; then calls getKey()")
  void testGetServerSideAttributes_givenAttributeKvEntryGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    Collection<AttributeKvEntry> actualServerSideAttributes = (new DeviceAttributes(clientSideAttributes,
        serverPrivateAttributes, new ArrayList<>())).getServerSideAttributes();

    // Assert
    verify(attributeKvEntry).getKey();
    assertTrue(actualServerSideAttributes.isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getServerSidePublicAttributes()}.
   * <p>
   * Method under test: {@link DeviceAttributes#getServerSidePublicAttributes()}
   */
  @Test
  @DisplayName("Test getServerSidePublicAttributes()")
  void testGetServerSidePublicAttributes() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getServerSidePublicAttributes()
        .isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getServerSidePublicAttributes()}.
   * <ul>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getServerSidePublicAttributes()}
   */
  @Test
  @DisplayName("Test getServerSidePublicAttributes(); then calls getKey()")
  void testGetServerSidePublicAttributes_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    Collection<AttributeKvEntry> actualServerSidePublicAttributes = (new DeviceAttributes(clientSideAttributes,
        serverPrivateAttributes, new ArrayList<>())).getServerSidePublicAttributes();

    // Assert
    verify(attributeKvEntry).getKey();
    assertTrue(actualServerSidePublicAttributes.isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#getClientSideAttribute(String)}.
   * <p>
   * Method under test: {@link DeviceAttributes#getClientSideAttribute(String)}
   */
  @Test
  @DisplayName("Test getClientSideAttribute(String)")
  void testGetClientSideAttribute() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertFalse((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getClientSideAttribute("Attribute")
        .isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getClientSideAttribute(String)}.
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link KvEntry#getKey()} return
   * {@code Key}.</li>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getClientSideAttribute(String)}
   */
  @Test
  @DisplayName("Test getClientSideAttribute(String); given AttributeKvEntry getKey() return 'Key'; then calls getKey()")
  void testGetClientSideAttribute_givenAttributeKvEntryGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    Optional<AttributeKvEntry> actualClientSideAttribute = (new DeviceAttributes(clientSideAttributes,
        serverPrivateAttributes, new ArrayList<>())).getClientSideAttribute("Attribute");

    // Assert
    verify(attributeKvEntry).getKey();
    assertFalse(actualClientSideAttribute.isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getServerPrivateAttribute(String)}.
   * <p>
   * Method under test: {@link DeviceAttributes#getServerPrivateAttribute(String)}
   */
  @Test
  @DisplayName("Test getServerPrivateAttribute(String)")
  void testGetServerPrivateAttribute() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertFalse((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getServerPrivateAttribute("Attribute")
        .isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getServerPrivateAttribute(String)}.
   * <ul>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getServerPrivateAttribute(String)}
   */
  @Test
  @DisplayName("Test getServerPrivateAttribute(String); then calls getKey()")
  void testGetServerPrivateAttribute_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    Optional<AttributeKvEntry> actualServerPrivateAttribute = (new DeviceAttributes(clientSideAttributes,
        serverPrivateAttributes, new ArrayList<>())).getServerPrivateAttribute("Attribute");

    // Assert
    verify(attributeKvEntry).getKey();
    assertFalse(actualServerPrivateAttribute.isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getServerPublicAttribute(String)}.
   * <p>
   * Method under test: {@link DeviceAttributes#getServerPublicAttribute(String)}
   */
  @Test
  @DisplayName("Test getServerPublicAttribute(String)")
  void testGetServerPublicAttribute() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertFalse((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getServerPublicAttribute("Attribute")
        .isPresent());
  }

  /**
   * Test {@link DeviceAttributes#getServerPublicAttribute(String)}.
   * <ul>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#getServerPublicAttribute(String)}
   */
  @Test
  @DisplayName("Test getServerPublicAttribute(String); then calls getKey()")
  void testGetServerPublicAttribute_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act
    Optional<AttributeKvEntry> actualServerPublicAttribute = (new DeviceAttributes(clientSideAttributes,
        serverPrivateAttributes, new ArrayList<>())).getServerPublicAttribute("Attribute");

    // Assert
    verify(attributeKvEntry).getKey();
    assertFalse(actualServerPublicAttribute.isPresent());
  }

  /**
   * Test {@link DeviceAttributes#remove(AttributeKey)}.
   * <ul>
   *   <li>Given {@link AttributeKvEntry} {@link KvEntry#getKey()} return
   * {@code Key}.</li>
   *   <li>Then calls {@link KvEntry#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#remove(AttributeKey)}
   */
  @Test
  @DisplayName("Test remove(AttributeKey); given AttributeKvEntry getKey() return 'Key'; then calls getKey()")
  void testRemove_givenAttributeKvEntryGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    clientSideAttributes.add(attributeKvEntry);
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());

    // Act
    deviceAttributes.remove(new AttributeKey("Scope", "Attribute Key"));

    // Assert that nothing has changed
    verify(attributeKvEntry).getKey();
  }

  /**
   * Test {@link DeviceAttributes#update(String, List)}.
   * <p>
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  @DisplayName("Test update(String, List)")
  void testUpdate() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());

    // Act
    deviceAttributes.update("Scope", new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(deviceAttributes.getClientSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#update(String, List)}.
   * <p>
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  @DisplayName("Test update(String, List)")
  void testUpdate2() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(attributeKvEntry);

    // Act
    deviceAttributes.update("CLIENT_SCOPE", values);

    // Assert
    verify(attributeKvEntry).getKey();
    assertEquals(1, deviceAttributes.getClientSideAttributes().size());
  }

  /**
   * Test {@link DeviceAttributes#update(String, List)}.
   * <p>
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  @DisplayName("Test update(String, List)")
  void testUpdate3() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    when(attributeKvEntry.getKey()).thenReturn("Key");

    ArrayList<AttributeKvEntry> values = new ArrayList<>();
    values.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("CLIENT_SCOPE", "42")));
    values.add(attributeKvEntry);

    // Act
    deviceAttributes.update("CLIENT_SCOPE", values);

    // Assert
    verify(attributeKvEntry).getKey();
    assertEquals(2, deviceAttributes.getClientSideAttributes().size());
  }

  /**
   * Test {@link DeviceAttributes#update(String, List)}.
   * <ul>
   *   <li>When {@code CLIENT_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  @DisplayName("Test update(String, List); when 'CLIENT_SCOPE'")
  void testUpdate_whenClientScope() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());

    // Act
    deviceAttributes.update("CLIENT_SCOPE", new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(deviceAttributes.getClientSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#update(String, List)}.
   * <ul>
   *   <li>When {@code SERVER_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  @DisplayName("Test update(String, List); when 'SERVER_SCOPE'")
  void testUpdate_whenServerScope() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());

    // Act
    deviceAttributes.update("SERVER_SCOPE", new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(deviceAttributes.getClientSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#update(String, List)}.
   * <ul>
   *   <li>When {@code SHARED_SCOPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  @DisplayName("Test update(String, List); when 'SHARED_SCOPE'")
  void testUpdate_whenSharedScope() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceAttributes deviceAttributes = new DeviceAttributes(clientSideAttributes, serverPrivateAttributes,
        new ArrayList<>());

    // Act
    deviceAttributes.update("SHARED_SCOPE", new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(deviceAttributes.getClientSideAttributes().isEmpty());
  }

  /**
   * Test {@link DeviceAttributes#toString()}.
   * <p>
   * Method under test: {@link DeviceAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertEquals(
        "DeviceAttributes{clientSideAttributesMap={}, serverPrivateAttributesMap={}, serverPublicAttributesMap"
            + "={}}",
        (new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>())).toString());
  }
}
