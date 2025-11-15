/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.AttributeKey;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;

class DeviceAttributesDiffblueTest {
  /**
   * Method under test: {@link DeviceAttributes#getClientSideAttributes()}
   */
  @Test
  void testGetClientSideAttributes() {
    // Arrange
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertTrue((new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()))
        .getClientSideAttributes()
        .isEmpty());
  }

  /**
   * Method under test: {@link DeviceAttributes#getClientSideAttributes()}
   */
  @Test
  void testGetClientSideAttributes2() {
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
   * Method under test: {@link DeviceAttributes#getServerSideAttributes()}
   */
  @Test
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
   * Method under test: {@link DeviceAttributes#getServerSideAttributes()}
   */
  @Test
  void testGetServerSideAttributes2() {
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
   * Method under test: {@link DeviceAttributes#getServerSidePublicAttributes()}
   */
  @Test
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
   * Method under test: {@link DeviceAttributes#getServerSidePublicAttributes()}
   */
  @Test
  void testGetServerSidePublicAttributes2() {
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
   * Method under test: {@link DeviceAttributes#getClientSideAttribute(String)}
   */
  @Test
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
   * Method under test: {@link DeviceAttributes#getClientSideAttribute(String)}
   */
  @Test
  void testGetClientSideAttribute2() {
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
   * Method under test: {@link DeviceAttributes#getServerPrivateAttribute(String)}
   */
  @Test
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
   * Method under test: {@link DeviceAttributes#getServerPrivateAttribute(String)}
   */
  @Test
  void testGetServerPrivateAttribute2() {
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
   * Method under test: {@link DeviceAttributes#getServerPublicAttribute(String)}
   */
  @Test
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
   * Method under test: {@link DeviceAttributes#getServerPublicAttribute(String)}
   */
  @Test
  void testGetServerPublicAttribute2() {
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
   * Method under test: {@link DeviceAttributes#remove(AttributeKey)}
   */
  @Test
  void testRemove() {
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
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
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
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  void testUpdate2() {
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
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  void testUpdate3() {
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
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  void testUpdate4() {
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
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  void testUpdate5() {
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
   * Method under test: {@link DeviceAttributes#update(String, List)}
   */
  @Test
  void testUpdate6() {
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
   * Method under test:
   * {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  void testNewDeviceAttributes() {
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
   * Method under test:
   * {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  void testNewDeviceAttributes2() {
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
   * Method under test:
   * {@link DeviceAttributes#DeviceAttributes(List, List, List)}
   */
  @Test
  void testNewDeviceAttributes3() {
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
   * Method under test: {@link DeviceAttributes#toString()}
   */
  @Test
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
