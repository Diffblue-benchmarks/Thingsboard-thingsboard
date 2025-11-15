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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeInfoDiffblueTest {
  /**
   * Test {@link WidgetTypeInfo#equals(Object)}, and {@link WidgetTypeInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
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
   * Test {@link WidgetTypeInfo#equals(Object)}, and {@link WidgetTypeInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(new WidgetTypeDetails());
    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo(new WidgetTypeDetails());

    // Act and Assert
    assertEquals(widgetTypeInfo, widgetTypeInfo2);
    int expectedHashCodeResult = widgetTypeInfo.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfo2.hashCode());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}, and {@link WidgetTypeInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setImage("Image");

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setImage("Image");

    // Act and Assert
    assertEquals(widgetTypeInfo, widgetTypeInfo2);
    int expectedHashCodeResult = widgetTypeInfo.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfo2.hashCode());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}, and {@link WidgetTypeInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setDescription("The characteristics of someone or something");

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(widgetTypeInfo, widgetTypeInfo2);
    int expectedHashCodeResult = widgetTypeInfo.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfo2.hashCode());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}, and {@link WidgetTypeInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfo#equals(Object)}
   *   <li>{@link WidgetTypeInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertEquals(widgetTypeInfo, widgetTypeInfo);
    int expectedHashCodeResult = widgetTypeInfo.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfo.hashCode());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(new WidgetTypeDetails());

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo(new WidgetTypeDetails()));
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setTags(new String[]{"Tags"});

    // Act and Assert
    assertNotEquals(widgetTypeInfo, new WidgetTypeInfo());
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, widgetTypeInfo2);
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeInfo, widgetTypeInfo2);
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeInfo(), null);
  }

  /**
   * Test {@link WidgetTypeInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetTypeInfo.equals(Object)", "int WidgetTypeInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeInfo(), "Different type to WidgetTypeInfo");
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>()", "void WidgetTypeInfo.<init>(WidgetTypeId)",
      "String WidgetTypeInfo.getDescription()", "String WidgetTypeInfo.getImage()", "String[] WidgetTypeInfo.getTags()",
      "String WidgetTypeInfo.getWidgetType()", "void WidgetTypeInfo.setDescription(String)",
      "void WidgetTypeInfo.setImage(String)", "void WidgetTypeInfo.setTags(String[])",
      "void WidgetTypeInfo.setWidgetType(String)", "String WidgetTypeInfo.toString()"})
  void testGettersAndSetters_thenReturnIdIsNull() {
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

    // Assert
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Widget Type", actualWidgetTypeInfo.getWidgetType());
    assertEquals("WidgetTypeInfo(image=Image, description=The characteristics of someone or something, tags=[Tags],"
        + " widgetType=Widget Type)", actualToStringResult);
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertNull(actualWidgetTypeInfo.getId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@link WidgetTypeId#WidgetTypeId(UUID)} with id is {@link EntityId#NULL_UUID}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; then return Id is WidgetTypeId(UUID) with id is NULL_UUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>()", "void WidgetTypeInfo.<init>(WidgetTypeId)",
      "String WidgetTypeInfo.getDescription()", "String WidgetTypeInfo.getImage()", "String[] WidgetTypeInfo.getTags()",
      "String WidgetTypeInfo.getWidgetType()", "void WidgetTypeInfo.setDescription(String)",
      "void WidgetTypeInfo.setImage(String)", "void WidgetTypeInfo.setTags(String[])",
      "void WidgetTypeInfo.setWidgetType(String)", "String WidgetTypeInfo.toString()"})
  void testGettersAndSetters_thenReturnIdIsWidgetTypeIdWithIdIsNull_uuid() {
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

    // Assert
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Widget Type", actualWidgetTypeInfo.getWidgetType());
    assertEquals("WidgetTypeInfo(image=Image, description=The characteristics of someone or something, tags=[Tags],"
        + " widgetType=Widget Type)", actualToStringResult);
    assertNull(actualWidgetTypeInfo.getVersion());
    assertNull(actualWidgetTypeInfo.getFqn());
    assertNull(actualWidgetTypeInfo.getName());
    assertNull(actualWidgetTypeInfo.getTenantId());
    assertEquals(0L, actualWidgetTypeInfo.getCreatedTime());
    assertFalse(actualWidgetTypeInfo.isDeprecated());
    assertFalse(actualWidgetTypeInfo.isScada());
    assertSame(id, actualWidgetTypeInfo.getId());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeDetails); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(WidgetTypeDetails)"})
  void testNewWidgetTypeInfo_givenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()} Descriptor is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeDetails); given Instance; when WidgetTypeDetails() Descriptor is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(WidgetTypeDetails)"})
  void testNewWidgetTypeInfo_givenInstance_whenWidgetTypeDetailsDescriptorIsInstance() {
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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(BaseWidgetType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Deprecated.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(BaseWidgetType); given 'true'; then return Deprecated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(BaseWidgetType)"})
  void testNewWidgetTypeInfo_givenTrue_thenReturnDeprecated() {
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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Deprecated.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeDetails); given 'true'; then return Deprecated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(WidgetTypeDetails)"})
  void testNewWidgetTypeInfo_givenTrue_thenReturnDeprecated2() {
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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link WidgetTypeInfo#WidgetTypeInfo()} Deprecated is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeInfo); given 'true'; when WidgetTypeInfo() Deprecated is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(WidgetTypeInfo)"})
  void testNewWidgetTypeInfo_givenTrue_whenWidgetTypeInfoDeprecatedIsTrue() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();
    widgetTypeInfo.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetTypeInfo, new WidgetTypeInfo(widgetTypeInfo));
  }

  /**
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(BaseWidgetType)}.
   * <ul>
   *   <li>When {@link BaseWidgetType#BaseWidgetType()}.</li>
   *   <li>Then return not Deprecated.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(BaseWidgetType); when BaseWidgetType(); then return not Deprecated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(BaseWidgetType)"})
  void testNewWidgetTypeInfo_whenBaseWidgetType_thenReturnNotDeprecated() {
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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}.
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   *   <li>Then return not Deprecated.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeDetails); when WidgetTypeDetails(); then return not Deprecated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(WidgetTypeDetails)"})
  void testNewWidgetTypeInfo_whenWidgetTypeDetails_thenReturnNotDeprecated() {
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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}.
   * <ul>
   *   <li>When {@link WidgetTypeInfo#WidgetTypeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeInfo); when WidgetTypeInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetTypeInfo.<init>(WidgetTypeInfo)"})
  void testNewWidgetTypeInfo_whenWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertEquals(widgetTypeInfo, new WidgetTypeInfo(widgetTypeInfo));
  }
}
