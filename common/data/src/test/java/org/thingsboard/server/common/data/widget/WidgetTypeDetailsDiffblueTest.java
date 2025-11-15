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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeDetailsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails2);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setImage("Image");

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setImage("Image");

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails2);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDescription("The characteristics of someone or something");

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails2);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setExternalId(new WidgetTypeId(EntityId.NULL_UUID));

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setExternalId(new WidgetTypeId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails2);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails.hashCode());
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeDetails(), 1);
    assertNotEquals(new WidgetTypeDetails(), mock(WidgetType.class));
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTags(new String[]{"Tags"});

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setExternalId(new WidgetTypeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, widgetTypeDetails2);
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, widgetTypeDetails2);
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setExternalId(new WidgetTypeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(widgetTypeDetails, widgetTypeDetails2);
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeDetails(), null);
  }

  /**
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeDetails(), "Different type to WidgetTypeDetails");
  }

  /**
   * Method under test: {@link WidgetTypeDetails#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new WidgetTypeDetails()).getExternalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#WidgetTypeDetails()}
   *   <li>{@link WidgetTypeDetails#setDescription(String)}
   *   <li>{@link WidgetTypeDetails#setExternalId(WidgetTypeId)}
   *   <li>{@link WidgetTypeDetails#setImage(String)}
   *   <li>{@link WidgetTypeDetails#setTags(String[])}
   *   <li>{@link WidgetTypeDetails#toString()}
   *   <li>{@link WidgetTypeDetails#getDescription()}
   *   <li>{@link WidgetTypeDetails#getImage()}
   *   <li>{@link WidgetTypeDetails#getTags()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeDetails actualWidgetTypeDetails = new WidgetTypeDetails();
    actualWidgetTypeDetails.setDescription("The characteristics of someone or something");
    WidgetTypeId externalId = new WidgetTypeId(EntityId.NULL_UUID);
    actualWidgetTypeDetails.setExternalId(externalId);
    actualWidgetTypeDetails.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeDetails.setTags(tags);
    String actualToStringResult = actualWidgetTypeDetails.toString();
    String actualDescription = actualWidgetTypeDetails.getDescription();
    String actualImage = actualWidgetTypeDetails.getImage();
    String[] actualTags = actualWidgetTypeDetails.getTags();

    // Assert that nothing has changed
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("WidgetTypeDetails(image=Image, description=The characteristics of someone or something, tags=[Tags],"
        + " externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(0L, actualWidgetTypeDetails.getCreatedTime());
    assertFalse(actualWidgetTypeDetails.isDeprecated());
    assertFalse(actualWidgetTypeDetails.isScada());
    assertSame(externalId, actualWidgetTypeDetails.getExternalId());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeId)}
   *   <li>{@link WidgetTypeDetails#setDescription(String)}
   *   <li>{@link WidgetTypeDetails#setExternalId(WidgetTypeId)}
   *   <li>{@link WidgetTypeDetails#setImage(String)}
   *   <li>{@link WidgetTypeDetails#setTags(String[])}
   *   <li>{@link WidgetTypeDetails#toString()}
   *   <li>{@link WidgetTypeDetails#getDescription()}
   *   <li>{@link WidgetTypeDetails#getImage()}
   *   <li>{@link WidgetTypeDetails#getTags()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(EntityId.NULL_UUID);

    // Act
    WidgetTypeDetails actualWidgetTypeDetails = new WidgetTypeDetails(id);
    actualWidgetTypeDetails.setDescription("The characteristics of someone or something");
    WidgetTypeId externalId = new WidgetTypeId(EntityId.NULL_UUID);
    actualWidgetTypeDetails.setExternalId(externalId);
    actualWidgetTypeDetails.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeDetails.setTags(tags);
    String actualToStringResult = actualWidgetTypeDetails.toString();
    String actualDescription = actualWidgetTypeDetails.getDescription();
    String actualImage = actualWidgetTypeDetails.getImage();
    String[] actualTags = actualWidgetTypeDetails.getTags();

    // Assert that nothing has changed
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("WidgetTypeDetails(image=Image, description=The characteristics of someone or something, tags=[Tags],"
        + " externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(0L, actualWidgetTypeDetails.getCreatedTime());
    assertFalse(actualWidgetTypeDetails.isDeprecated());
    assertFalse(actualWidgetTypeDetails.isScada());
    assertSame(id, actualWidgetTypeDetails.getId());
    assertSame(externalId, actualWidgetTypeDetails.getExternalId());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(BaseWidgetType)}
   */
  @Test
  void testNewWidgetTypeDetails() {
    // Arrange and Act
    WidgetTypeDetails actualWidgetTypeDetails = new WidgetTypeDetails(new BaseWidgetType());

    // Assert
    assertNull(actualWidgetTypeDetails.getTags());
    assertNull(actualWidgetTypeDetails.getDescriptor());
    assertNull(actualWidgetTypeDetails.getVersion());
    assertNull(actualWidgetTypeDetails.getFqn());
    assertNull(actualWidgetTypeDetails.getName());
    assertNull(actualWidgetTypeDetails.getDescription());
    assertNull(actualWidgetTypeDetails.getImage());
    assertNull(actualWidgetTypeDetails.getUuidId());
    assertNull(actualWidgetTypeDetails.getTenantId());
    assertNull(actualWidgetTypeDetails.getId());
    assertNull(actualWidgetTypeDetails.getExternalId());
    assertEquals(0L, actualWidgetTypeDetails.getCreatedTime());
    assertFalse(actualWidgetTypeDetails.isDeprecated());
    assertFalse(actualWidgetTypeDetails.isScada());
  }

  /**
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(BaseWidgetType)}
   */
  @Test
  void testNewWidgetTypeDetails2() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setDeprecated(true);

    // Act
    WidgetTypeDetails actualWidgetTypeDetails = new WidgetTypeDetails(baseWidgetType);

    // Assert
    assertNull(actualWidgetTypeDetails.getTags());
    assertNull(actualWidgetTypeDetails.getDescriptor());
    assertNull(actualWidgetTypeDetails.getVersion());
    assertNull(actualWidgetTypeDetails.getFqn());
    assertNull(actualWidgetTypeDetails.getName());
    assertNull(actualWidgetTypeDetails.getDescription());
    assertNull(actualWidgetTypeDetails.getImage());
    assertNull(actualWidgetTypeDetails.getUuidId());
    assertNull(actualWidgetTypeDetails.getTenantId());
    assertNull(actualWidgetTypeDetails.getId());
    assertNull(actualWidgetTypeDetails.getExternalId());
    assertEquals(0L, actualWidgetTypeDetails.getCreatedTime());
    assertFalse(actualWidgetTypeDetails.isScada());
    assertTrue(actualWidgetTypeDetails.isDeprecated());
  }

  /**
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeDetails)}
   */
  @Test
  void testNewWidgetTypeDetails3() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetTypeDetails, new WidgetTypeDetails(widgetTypeDetails));
  }

  /**
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeDetails)}
   */
  @Test
  void testNewWidgetTypeDetails4() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetTypeDetails, new WidgetTypeDetails(widgetTypeDetails));
  }
}
