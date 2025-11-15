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
package org.thingsboard.server.common.data.notification.template;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.math.BigInteger;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class WebDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull((new WebDeliveryMethodNotificationTemplate()).getBody());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  void testGetButtonText() {
    // Arrange, Act and Assert
    assertNull((new WebDeliveryMethodNotificationTemplate()).getButtonText());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  void testGetButtonText2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonText());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  void testGetButtonText3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    webDeliveryMethodNotificationTemplate
        .setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonText());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#setButtonText(String)}
   */
  @Test
  void testSetButtonText() {
    // Arrange
    ArrayNode additionalConfig = mock(ArrayNode.class);
    when(additionalConfig.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    webDeliveryMethodNotificationTemplate.setButtonText("Button Text");

    // Assert
    verify(additionalConfig).get(eq("actionButtonConfig"));
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  void testGetButtonLink() {
    // Arrange, Act and Assert
    assertNull((new WebDeliveryMethodNotificationTemplate()).getButtonLink());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  void testGetButtonLink2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonLink());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  void testGetButtonLink3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    webDeliveryMethodNotificationTemplate
        .setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonLink());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#setButtonLink(String)}
   */
  @Test
  void testSetButtonLink() {
    // Arrange
    ArrayNode additionalConfig = mock(ArrayNode.class);
    when(additionalConfig.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    webDeliveryMethodNotificationTemplate.setButtonLink("Button Link");

    // Assert
    verify(additionalConfig).get(eq("actionButtonConfig"));
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy() {
    // Arrange and Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = (new WebDeliveryMethodNotificationTemplate()).copy();

    // Assert
    assertNull(actualCopyResult.getAdditionalConfig());
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    MissingNode additionalConfig = MissingNode.getInstance();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertSame(additionalConfig, actualCopyResult.getAdditionalConfig());
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    JsonNode additionalConfig2 = actualCopyResult.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    BigIntegerNode additionalConfig = new BigIntegerNode(BigInteger.valueOf(1L));
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertSame(additionalConfig, actualCopyResult.getAdditionalConfig());
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy5() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    JsonNode additionalConfig2 = actualCopyResult.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy6() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addArray();
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    JsonNode additionalConfig2 = actualCopyResult.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy7() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addObject();
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    JsonNode additionalConfig2 = actualCopyResult.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  void testCopy8() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addPOJO("Pojo");
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualCopyResult = webDeliveryMethodNotificationTemplate.copy();

    // Assert
    JsonNode additionalConfig2 = actualCopyResult.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualCopyResult.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualCopyResult.getBody());
    assertNull(actualCopyResult.getButtonLink());
    assertNull(actualCopyResult.getButtonText());
    assertNull(actualCopyResult.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualCopyResult.getMethod());
    assertFalse(actualCopyResult.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = webDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, webDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(), mock(EmailDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(),
        "Different type to WebDeliveryMethodNotificationTemplate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link WebDeliveryMethodNotificationTemplate#setAdditionalConfig(JsonNode)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getAdditionalConfig()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    MissingNode additionalConfig = MissingNode.getInstance();

    // Act
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    webDeliveryMethodNotificationTemplate.toString();
    JsonNode actualAdditionalConfig = webDeliveryMethodNotificationTemplate.getAdditionalConfig();
    NotificationDeliveryMethod actualMethod = webDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = webDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues = webDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert that nothing has changed
    assertEquals(4, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(NotificationDeliveryMethod.WEB, actualMethod);
    assertSame(additionalConfig, actualAdditionalConfig);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig());
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate2() {
    // Arrange and Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        new WebDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig());
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    MissingNode additionalConfig = MissingNode.getInstance();
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertSame(additionalConfig, actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    JsonNode additionalConfig2 = actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate5() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    BigIntegerNode additionalConfig = new BigIntegerNode(BigInteger.valueOf(1L));
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertSame(additionalConfig, actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig());
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate6() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    JsonNode additionalConfig2 = actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate7() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addArray();
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    JsonNode additionalConfig2 = actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate8() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addObject();
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    JsonNode additionalConfig2 = actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }

  /**
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  void testNewWebDeliveryMethodNotificationTemplate9() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addPOJO("Pojo");
    additionalConfig.add(MissingNode.getInstance());

    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    other.setAdditionalConfig(additionalConfig);

    // Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate(
        other);

    // Assert
    JsonNode additionalConfig2 = actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    List<TemplatableValue> templatableValues = actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
    assertEquals(additionalConfig, additionalConfig2);
  }
}
