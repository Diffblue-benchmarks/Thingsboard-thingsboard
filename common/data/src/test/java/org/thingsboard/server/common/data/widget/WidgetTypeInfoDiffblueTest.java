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
package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();

    // Act and Assert
    assertEquals(widgetTypeInfo, widgetTypeInfo2);
    int expectedHashCodeResult = widgetTypeInfo.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertEquals(widgetTypeInfo, widgetTypeInfo);
    int expectedHashCodeResult = widgetTypeInfo.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfo.hashCode());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(new WidgetTypeDetails());

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo(new WidgetTypeDetails()));
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setTags(new String[]{"Tags"});

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.isDeprecated()).thenReturn(true);
    when(widgetTypeDetails.isScada()).thenReturn(true);
    when(widgetTypeDetails.getDescriptor()).thenReturn(MissingNode.getInstance());
    when(widgetTypeDetails.getVersion()).thenReturn(1L);
    when(widgetTypeDetails.getFqn()).thenReturn("Fqn");
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetTypeDetails.getCreatedTime()).thenReturn(1L);
    when(widgetTypeDetails.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(EntityId.NULL_UUID));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.isDeprecated()).thenReturn(true);
    when(widgetTypeDetails.isScada()).thenReturn(true);
    when(widgetTypeDetails.getDescriptor()).thenReturn(MissingNode.getInstance());
    when(widgetTypeDetails.getVersion()).thenReturn(1L);
    when(widgetTypeDetails.getFqn()).thenReturn("Fqn");
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetTypeDetails.getCreatedTime()).thenReturn(1L);
    when(widgetTypeDetails.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(EntityId.NULL_UUID));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, widgetTypeInfo2);
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.isDeprecated()).thenReturn(true);
    when(widgetTypeDetails.isScada()).thenReturn(true);
    when(widgetTypeDetails.getDescriptor()).thenReturn(MissingNode.getInstance());
    when(widgetTypeDetails.getVersion()).thenReturn(1L);
    when(widgetTypeDetails.getFqn()).thenReturn("Fqn");
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetTypeDetails.getImage()).thenReturn(null);
    when(widgetTypeDetails.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetTypeDetails.getCreatedTime()).thenReturn(1L);
    when(widgetTypeDetails.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(EntityId.NULL_UUID));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, widgetTypeInfo2);
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.isDeprecated()).thenReturn(true);
    when(widgetTypeDetails.isScada()).thenReturn(true);
    when(widgetTypeDetails.getDescriptor()).thenReturn(MissingNode.getInstance());
    when(widgetTypeDetails.getVersion()).thenReturn(1L);
    when(widgetTypeDetails.getFqn()).thenReturn("Fqn");
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetTypeDetails.getCreatedTime()).thenReturn(1L);
    when(widgetTypeDetails.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(EntityId.NULL_UUID));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setDescription("The characteristics of someone or something");
    widgetTypeInfo2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, widgetTypeInfo2);
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.isDeprecated()).thenReturn(true);
    when(widgetTypeDetails.isScada()).thenReturn(true);
    when(widgetTypeDetails.getDescriptor()).thenReturn(MissingNode.getInstance());
    when(widgetTypeDetails.getVersion()).thenReturn(1L);
    when(widgetTypeDetails.getFqn()).thenReturn("Fqn");
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getDescription()).thenReturn(null);
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetTypeDetails.getCreatedTime()).thenReturn(1L);
    when(widgetTypeDetails.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(EntityId.NULL_UUID));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setDescription("The characteristics of someone or something");
    widgetTypeInfo2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, widgetTypeInfo2);
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeInfo(), null);
  }

  /**
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeInfo(), "Different type to WidgetTypeInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#WidgetTypeInfo()}
   *   <li>{@link WidgetTypeInfo#setDescription(String)}
   *   <li>{@link WidgetTypeInfo#setImage(String)}
   *   <li>{@link WidgetTypeInfo#setTags(String[])}
   *   <li>{@link WidgetTypeInfo#setWidgetType(String)}
   *   <li>{@link WidgetTypeInfo#toString()}
   *   <li>{@link WidgetTypeInfo#getDescription()}
   *   <li>{@link WidgetTypeInfo#getImage()}
   *   <li>{@link WidgetTypeInfo#getTags()}
   *   <li>{@link WidgetTypeInfo#getWidgetType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo();
    actualWidgetTypeInfo.setDescription("The characteristics of someone or something");
    actualWidgetTypeInfo.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeInfo.setTags(tags);
    actualWidgetTypeInfo.setWidgetType("Widget Type");
    String actualToStringResult = actualWidgetTypeInfo.toString();
    String actualDescription = actualWidgetTypeInfo.getDescription();
    String actualImage = actualWidgetTypeInfo.getImage();
    String[] actualTags = actualWidgetTypeInfo.getTags();

    // Assert that nothing has changed
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Widget Type", actualWidgetTypeInfo.getWidgetType());
    assertEquals("WidgetTypeInfo(image=Image, description=The characteristics of someone or something, tags=[Tags],"
        + " widgetType=Widget Type)", actualToStringResult);
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeId)}
   *   <li>{@link WidgetTypeInfo#setDescription(String)}
   *   <li>{@link WidgetTypeInfo#setImage(String)}
   *   <li>{@link WidgetTypeInfo#setTags(String[])}
   *   <li>{@link WidgetTypeInfo#setWidgetType(String)}
   *   <li>{@link WidgetTypeInfo#toString()}
   *   <li>{@link WidgetTypeInfo#getDescription()}
   *   <li>{@link WidgetTypeInfo#getImage()}
   *   <li>{@link WidgetTypeInfo#getTags()}
   *   <li>{@link WidgetTypeInfo#getWidgetType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(EntityId.NULL_UUID);

    // Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(id);
    actualWidgetTypeInfo.setDescription("The characteristics of someone or something");
    actualWidgetTypeInfo.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeInfo.setTags(tags);
    actualWidgetTypeInfo.setWidgetType("Widget Type");
    String actualToStringResult = actualWidgetTypeInfo.toString();
    String actualDescription = actualWidgetTypeInfo.getDescription();
    String actualImage = actualWidgetTypeInfo.getImage();
    String[] actualTags = actualWidgetTypeInfo.getTags();

    // Assert that nothing has changed
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Widget Type", actualWidgetTypeInfo.getWidgetType());
    assertEquals("WidgetTypeInfo(image=Image, description=The characteristics of someone or something, tags=[Tags],"
        + " widgetType=Widget Type)", actualToStringResult);
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertSame(id, actualWidgetTypeInfo.getId());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(BaseWidgetType)}
   */
  @Test
  void testNewWidgetTypeInfo() {
    // Arrange and Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(new BaseWidgetType());

    // Assert
    assertNull(actualWidgetTypeInfo.getTags());
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getDescription());
    assertNull(actualWidgetTypeInfo.getImage());
    assertNull(actualWidgetTypeInfo.getWidgetType());
    assertNull(actualWidgetTypeInfo.getUuidId());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(BaseWidgetType)}
   */
  @Test
  void testNewWidgetTypeInfo2() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setDeprecated(true);

    // Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(baseWidgetType);

    // Assert
    assertNull(actualWidgetTypeInfo.getTags());
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getDescription());
    assertNull(actualWidgetTypeInfo.getImage());
    assertNull(actualWidgetTypeInfo.getWidgetType());
    assertNull(actualWidgetTypeInfo.getUuidId());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertTrue(actualWidgetTypeInfo.isDeprecated());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  void testNewWidgetTypeInfo3() {
    // Arrange and Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(new WidgetTypeDetails());

    // Assert
    assertEquals("", actualWidgetTypeInfo.getWidgetType());
    assertNull(actualWidgetTypeInfo.getTags());
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getDescription());
    assertNull(actualWidgetTypeInfo.getImage());
    assertNull(actualWidgetTypeInfo.getUuidId());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  void testNewWidgetTypeInfo4() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDescriptor(MissingNode.getInstance());

    // Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    // Assert
    assertEquals("", actualWidgetTypeInfo.getWidgetType());
    assertNull(actualWidgetTypeInfo.getTags());
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getDescription());
    assertNull(actualWidgetTypeInfo.getImage());
    assertNull(actualWidgetTypeInfo.getUuidId());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  void testNewWidgetTypeInfo5() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDeprecated(true);

    // Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    // Assert
    assertEquals("", actualWidgetTypeInfo.getWidgetType());
    assertNull(actualWidgetTypeInfo.getTags());
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getDescription());
    assertNull(actualWidgetTypeInfo.getImage());
    assertNull(actualWidgetTypeInfo.getUuidId());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertTrue(actualWidgetTypeInfo.isDeprecated());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  void testNewWidgetTypeInfo6() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDescriptor(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    widgetTypeDetails.setDeprecated(true);

    // Act
    WidgetTypeInfo actualWidgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    // Assert
    assertEquals("", actualWidgetTypeInfo.getWidgetType());
    assertNull(actualWidgetTypeInfo.getTags());
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getDescription());
    assertNull(actualWidgetTypeInfo.getImage());
    assertNull(actualWidgetTypeInfo.getUuidId());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertTrue(actualWidgetTypeInfo.isDeprecated());
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}
   */
  @Test
  void testNewWidgetTypeInfo7() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertEquals(widgetTypeInfo, new WidgetTypeInfo(widgetTypeInfo));
  }

  /**
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}
   */
  @Test
  void testNewWidgetTypeInfo8() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetTypeInfo, new WidgetTypeInfo(widgetTypeInfo));
  }
}
