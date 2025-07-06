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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class WebDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}.
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new WebDeliveryMethodNotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebDeliveryMethodNotificationTemplate.<init>()"})
  void testNewWebDeliveryMethodNotificationTemplate() {
    // Arrange and Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();

    // Assert
    assertNull(actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig());
    List<TemplatableValue> templatableValues =
        actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(
        NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WebDeliveryMethodNotificationTemplate.<init>(WebDeliveryMethodNotificationTemplate)"
  })
  void testNewWebDeliveryMethodNotificationTemplate2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    DoubleNode additionalConfig = DoubleNode.valueOf(10.0d);
    other.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(
        additionalConfig, new WebDeliveryMethodNotificationTemplate(other).getAdditionalConfig());
  }

  /**
   * Test {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WebDeliveryMethodNotificationTemplate.<init>(WebDeliveryMethodNotificationTemplate)"
  })
  void testNewWebDeliveryMethodNotificationTemplate3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    other.setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    JsonNode additionalConfig =
        new WebDeliveryMethodNotificationTemplate(other).getAdditionalConfig();
    assertTrue(additionalConfig instanceof ArrayNode);
    assertEquals("[ ]", additionalConfig.toPrettyString());
    assertEquals(0, additionalConfig.size());
    assertFalse(additionalConfig.elements().hasNext());
    assertTrue(additionalConfig.isEmpty());
  }

  /**
   * Test {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WebDeliveryMethodNotificationTemplate.<init>(WebDeliveryMethodNotificationTemplate)"
  })
  void testNewWebDeliveryMethodNotificationTemplate4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    MissingNode additionalConfig = MissingNode.getInstance();
    other.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(
        additionalConfig, new WebDeliveryMethodNotificationTemplate(other).getAdditionalConfig());
  }

  /**
   * Test {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WebDeliveryMethodNotificationTemplate.<init>(WebDeliveryMethodNotificationTemplate)"
  })
  void testNewWebDeliveryMethodNotificationTemplate5() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addArray();

    WebDeliveryMethodNotificationTemplate other =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    other.setAdditionalConfig(additionalConfig);

    // Act and Assert
    JsonNode additionalConfig2 =
        new WebDeliveryMethodNotificationTemplate(other).getAdditionalConfig();
    Iterator<JsonNode> elementsResult = additionalConfig2.elements();
    JsonNode nextResult = elementsResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    assertTrue(additionalConfig2 instanceof ArrayNode);
    assertEquals("[ [ ] ]", additionalConfig2.toPrettyString());
    assertEquals("[ ]", nextResult.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(JsonNodeType.ARRAY, nextResult.getNodeType());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.elements().hasNext());
    assertFalse(elementsResult.hasNext());
    assertTrue(nextResult.isArray());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WebDeliveryMethodNotificationTemplate.<init>(WebDeliveryMethodNotificationTemplate)"
  })
  void testNewWebDeliveryMethodNotificationTemplate6() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addObject();

    WebDeliveryMethodNotificationTemplate other =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    other.setAdditionalConfig(additionalConfig);

    // Act and Assert
    JsonNode additionalConfig2 =
        new WebDeliveryMethodNotificationTemplate(other).getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = additionalConfig2.elements();
    JsonNode nextResult = elementsResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertEquals("[ { } ]", additionalConfig2.toPrettyString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertFalse(nextResult.isArray());
    assertFalse(elementsResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isObject());
  }

  /**
   * Test {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   *
   * <ul>
   *   <li>Then return AdditionalConfig is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName(
      "Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate); then return AdditionalConfig is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WebDeliveryMethodNotificationTemplate.<init>(WebDeliveryMethodNotificationTemplate)"
  })
  void testNewWebDeliveryMethodNotificationTemplate_thenReturnAdditionalConfigIsNull() {
    // Arrange and Act
    WebDeliveryMethodNotificationTemplate actualWebDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());

    // Assert
    assertNull(actualWebDeliveryMethodNotificationTemplate.getAdditionalConfig());
    List<TemplatableValue> templatableValues =
        actualWebDeliveryMethodNotificationTemplate.getTemplatableValues();
    assertEquals(4, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertNull(templatableValues.get(2).get());
    assertNull(templatableValues.get(3).get());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getBody());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonLink());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getButtonText());
    assertNull(actualWebDeliveryMethodNotificationTemplate.getSubject());
    assertEquals(
        NotificationDeliveryMethod.WEB, actualWebDeliveryMethodNotificationTemplate.getMethod());
    assertFalse(actualWebDeliveryMethodNotificationTemplate.isEnabled());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getBody()}.
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  @DisplayName("Test getBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebDeliveryMethodNotificationTemplate.getBody()"})
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull(new WebDeliveryMethodNotificationTemplate().getBody());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonText()}.
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  @DisplayName("Test getButtonText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebDeliveryMethodNotificationTemplate.getButtonText()"})
  void testGetButtonText() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonText());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonText()}.
   *
   * <ul>
   *   <li>Given {@link
   *       WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  @DisplayName("Test getButtonText(); given WebDeliveryMethodNotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebDeliveryMethodNotificationTemplate.getButtonText()"})
  void testGetButtonText_givenWebDeliveryMethodNotificationTemplate() {
    // Arrange, Act and Assert
    assertNull(new WebDeliveryMethodNotificationTemplate().getButtonText());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#setButtonText(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return valueOf ten.
   *   <li>Then calls {@link ArrayNode#get(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#setButtonText(String)}
   */
  @Test
  @DisplayName(
      "Test setButtonText(String); given ArrayNode get(String) return valueOf ten; then calls get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebDeliveryMethodNotificationTemplate.setButtonText(String)"})
  void testSetButtonText_givenArrayNodeGetReturnValueOfTen_thenCallsGet() {
    // Arrange
    ArrayNode additionalConfig = mock(ArrayNode.class);
    when(additionalConfig.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    webDeliveryMethodNotificationTemplate.setButtonText("Button Text");

    // Assert
    verify(additionalConfig).get(eq("actionButtonConfig"));
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}.
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  @DisplayName("Test getButtonLink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebDeliveryMethodNotificationTemplate.getButtonLink()"})
  void testGetButtonLink() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonLink());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}.
   *
   * <ul>
   *   <li>Given {@link
   *       WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  @DisplayName("Test getButtonLink(); given WebDeliveryMethodNotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebDeliveryMethodNotificationTemplate.getButtonLink()"})
  void testGetButtonLink_givenWebDeliveryMethodNotificationTemplate() {
    // Arrange, Act and Assert
    assertNull(new WebDeliveryMethodNotificationTemplate().getButtonLink());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#setButtonLink(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return valueOf ten.
   *   <li>Then calls {@link ArrayNode#get(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#setButtonLink(String)}
   */
  @Test
  @DisplayName(
      "Test setButtonLink(String); given ArrayNode get(String) return valueOf ten; then calls get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebDeliveryMethodNotificationTemplate.setButtonLink(String)"})
  void testSetButtonLink_givenArrayNodeGetReturnValueOfTen_thenCallsGet() {
    // Arrange
    ArrayNode additionalConfig = mock(ArrayNode.class);
    when(additionalConfig.get(Mockito.<String>any())).thenReturn(DoubleNode.valueOf(10.0d));

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act
    webDeliveryMethodNotificationTemplate.setButtonLink("Button Link");

    // Assert
    verify(additionalConfig).get(eq("actionButtonConfig"));
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WebDeliveryMethodNotificationTemplate WebDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    JsonNode additionalConfig = webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig();
    assertTrue(additionalConfig instanceof ArrayNode);
    assertEquals("[ ]", additionalConfig.toPrettyString());
    assertEquals(0, additionalConfig.size());
    assertFalse(additionalConfig.elements().hasNext());
    assertTrue(additionalConfig.isEmpty());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   *
   * <ul>
   *   <li>Then AdditionalConfig elements next return {@link ArrayNode}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then AdditionalConfig elements next return ArrayNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WebDeliveryMethodNotificationTemplate WebDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy_thenAdditionalConfigElementsNextReturnArrayNode() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addArray();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act and Assert
    JsonNode additionalConfig2 = webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig();
    Iterator<JsonNode> elementsResult = additionalConfig2.elements();
    JsonNode nextResult = elementsResult.next();
    assertTrue(nextResult instanceof ArrayNode);
    assertTrue(additionalConfig2 instanceof ArrayNode);
    assertEquals("[ [ ] ]", additionalConfig2.toPrettyString());
    assertEquals("[ ]", nextResult.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(JsonNodeType.ARRAY, nextResult.getNodeType());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.elements().hasNext());
    assertFalse(elementsResult.hasNext());
    assertTrue(nextResult.isArray());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   *
   * <ul>
   *   <li>Then AdditionalConfig elements next return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then AdditionalConfig elements next return ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WebDeliveryMethodNotificationTemplate WebDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy_thenAdditionalConfigElementsNextReturnObjectNode() {
    // Arrange
    ArrayNode additionalConfig = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    additionalConfig.addObject();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act and Assert
    JsonNode additionalConfig2 = webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig();
    assertTrue(additionalConfig2 instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = additionalConfig2.elements();
    JsonNode nextResult = elementsResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertEquals("[ { } ]", additionalConfig2.toPrettyString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertFalse(nextResult.isArray());
    assertFalse(elementsResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isObject());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   *
   * <ul>
   *   <li>Then return AdditionalConfig is Instance.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return AdditionalConfig is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WebDeliveryMethodNotificationTemplate WebDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy_thenReturnAdditionalConfigIsInstance() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    MissingNode additionalConfig = MissingNode.getInstance();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(
        additionalConfig, webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   *
   * <ul>
   *   <li>Then return AdditionalConfig is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return AdditionalConfig is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WebDeliveryMethodNotificationTemplate WebDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy_thenReturnAdditionalConfigIsNull() {
    // Arrange and Act
    WebDeliveryMethodNotificationTemplate actualCopyResult =
        new WebDeliveryMethodNotificationTemplate().copy();

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
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   *
   * <ul>
   *   <li>Then return AdditionalConfig is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return AdditionalConfig is valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "WebDeliveryMethodNotificationTemplate WebDeliveryMethodNotificationTemplate.copy()"
  })
  void testCopy_thenReturnAdditionalConfigIsValueOfTen() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate(new WebDeliveryMethodNotificationTemplate());
    DoubleNode additionalConfig = DoubleNode.valueOf(10.0d);
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(
        additionalConfig, webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}, and {@link
   * WebDeliveryMethodNotificationTemplate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = webDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, webDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(
        webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(
        webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(
        webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(
        webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 =
        new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setAdditionalConfig(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WebDeliveryMethodNotificationTemplate.equals(Object)",
    "int WebDeliveryMethodNotificationTemplate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new WebDeliveryMethodNotificationTemplate(),
        "Different type to WebDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WebDeliveryMethodNotificationTemplate#setAdditionalConfig(JsonNode)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#setSubject(String)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#toString()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getAdditionalConfig()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getMethod()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getSubject()}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#getTemplatableValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "JsonNode WebDeliveryMethodNotificationTemplate.getAdditionalConfig()",
    "NotificationDeliveryMethod WebDeliveryMethodNotificationTemplate.getMethod()",
    "String WebDeliveryMethodNotificationTemplate.getSubject()",
    "List WebDeliveryMethodNotificationTemplate.getTemplatableValues()",
    "void WebDeliveryMethodNotificationTemplate.setAdditionalConfig(JsonNode)",
    "void WebDeliveryMethodNotificationTemplate.setSubject(String)",
    "String WebDeliveryMethodNotificationTemplate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate =
        new WebDeliveryMethodNotificationTemplate();
    DoubleNode additionalConfig = DoubleNode.valueOf(10.0d);

    // Act
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    webDeliveryMethodNotificationTemplate.toString();
    JsonNode actualAdditionalConfig = webDeliveryMethodNotificationTemplate.getAdditionalConfig();
    NotificationDeliveryMethod actualMethod = webDeliveryMethodNotificationTemplate.getMethod();
    String actualSubject = webDeliveryMethodNotificationTemplate.getSubject();
    List<TemplatableValue> actualTemplatableValues =
        webDeliveryMethodNotificationTemplate.getTemplatableValues();

    // Assert
    assertEquals(4, actualTemplatableValues.size());
    assertEquals("Hello from the Dreaming Spires", actualTemplatableValues.get(1).get());
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertNull(actualTemplatableValues.get(0).get());
    assertNull(actualTemplatableValues.get(2).get());
    assertNull(actualTemplatableValues.get(3).get());
    assertEquals(NotificationDeliveryMethod.WEB, actualMethod);
    assertSame(additionalConfig, actualAdditionalConfig);
  }
}
