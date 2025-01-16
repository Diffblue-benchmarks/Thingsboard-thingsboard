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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class WebDeliveryMethodNotificationTemplateDiffblueTest {
  /**
   * Test
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}
   */
  @Test
  @DisplayName("Test new WebDeliveryMethodNotificationTemplate()")
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
   * Test
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  void testNewWebDeliveryMethodNotificationTemplate2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    MissingNode additionalConfig = MissingNode.getInstance();
    other.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(additionalConfig, (new WebDeliveryMethodNotificationTemplate(other)).getAdditionalConfig());
  }

  /**
   * Test
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  void testNewWebDeliveryMethodNotificationTemplate3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    other.setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    JsonNode additionalConfig = (new WebDeliveryMethodNotificationTemplate(other)).getAdditionalConfig();
    assertTrue(additionalConfig instanceof ArrayNode);
    assertEquals("[ ]", additionalConfig.toPrettyString());
    assertEquals(0, additionalConfig.size());
    assertFalse(additionalConfig.elements().hasNext());
    assertTrue(additionalConfig.isEmpty());
  }

  /**
   * Test
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)")
  void testNewWebDeliveryMethodNotificationTemplate4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate other = new WebDeliveryMethodNotificationTemplate();
    BigIntegerNode additionalConfig = new BigIntegerNode(BigInteger.valueOf(1L));
    other.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(additionalConfig, (new WebDeliveryMethodNotificationTemplate(other)).getAdditionalConfig());
  }

  /**
   * Test
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}.
   * <ul>
   *   <li>Then return AdditionalConfig is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate)}
   */
  @Test
  @DisplayName("Test new WebDeliveryMethodNotificationTemplate(WebDeliveryMethodNotificationTemplate); then return AdditionalConfig is 'null'")
  void testNewWebDeliveryMethodNotificationTemplate_thenReturnAdditionalConfigIsNull() {
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
   * Test {@link WebDeliveryMethodNotificationTemplate#getBody()}.
   * <p>
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#getBody()}
   */
  @Test
  @DisplayName("Test getBody()")
  void testGetBody() {
    // Arrange, Act and Assert
    assertNull((new WebDeliveryMethodNotificationTemplate()).getBody());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonText()}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  @DisplayName("Test getButtonText()")
  void testGetButtonText() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonText());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonText()}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  @DisplayName("Test getButtonText()")
  void testGetButtonText2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    webDeliveryMethodNotificationTemplate
        .setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonText());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonText()}.
   * <ul>
   *   <li>Given
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonText()}
   */
  @Test
  @DisplayName("Test getButtonText(); given WebDeliveryMethodNotificationTemplate()")
  void testGetButtonText_givenWebDeliveryMethodNotificationTemplate() {
    // Arrange, Act and Assert
    assertNull((new WebDeliveryMethodNotificationTemplate()).getButtonText());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#setButtonText(String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   *   <li>Then calls {@link ArrayNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#setButtonText(String)}
   */
  @Test
  @DisplayName("Test setButtonText(String); given ArrayNode get(String) return Instance; then calls get(String)")
  void testSetButtonText_givenArrayNodeGetReturnInstance_thenCallsGet() {
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
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  @DisplayName("Test getButtonLink()")
  void testGetButtonLink() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonLink());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}.
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  @DisplayName("Test getButtonLink()")
  void testGetButtonLink2() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");
    webDeliveryMethodNotificationTemplate
        .setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertNull(webDeliveryMethodNotificationTemplate.getButtonLink());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}.
   * <ul>
   *   <li>Given
   * {@link WebDeliveryMethodNotificationTemplate#WebDeliveryMethodNotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#getButtonLink()}
   */
  @Test
  @DisplayName("Test getButtonLink(); given WebDeliveryMethodNotificationTemplate()")
  void testGetButtonLink_givenWebDeliveryMethodNotificationTemplate() {
    // Arrange, Act and Assert
    assertNull((new WebDeliveryMethodNotificationTemplate()).getButtonLink());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#setButtonLink(String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   *   <li>Then calls {@link ArrayNode#get(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#setButtonLink(String)}
   */
  @Test
  @DisplayName("Test setButtonLink(String); given ArrayNode get(String) return Instance; then calls get(String)")
  void testSetButtonLink_givenArrayNodeGetReturnInstance_thenCallsGet() {
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
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   * <p>
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy()")
  void testCopy() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate
        .setAdditionalConfig(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

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
   * <ul>
   *   <li>Then return AdditionalConfig is
   * {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return AdditionalConfig is BigIntegerNode(BigInteger) with v is valueOf one")
  void testCopy_thenReturnAdditionalConfigIsBigIntegerNodeWithVIsValueOfOne() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    BigIntegerNode additionalConfig = new BigIntegerNode(BigInteger.valueOf(1L));
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(additionalConfig, webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   * <ul>
   *   <li>Then return AdditionalConfig is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return AdditionalConfig is Instance")
  void testCopy_thenReturnAdditionalConfigIsInstance() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    MissingNode additionalConfig = MissingNode.getInstance();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertSame(additionalConfig, webDeliveryMethodNotificationTemplate.copy().getAdditionalConfig());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#copy()}.
   * <ul>
   *   <li>Then return AdditionalConfig is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebDeliveryMethodNotificationTemplate#copy()}
   */
  @Test
  @DisplayName("Test copy(); then return AdditionalConfig is 'null'")
  void testCopy_thenReturnAdditionalConfigIsNull() {
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
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}, and
   * {@link WebDeliveryMethodNotificationTemplate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   *   <li>{@link WebDeliveryMethodNotificationTemplate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate);
    int expectedHashCodeResult = webDeliveryMethodNotificationTemplate.hashCode();
    assertEquals(expectedHashCodeResult, webDeliveryMethodNotificationTemplate.hashCode());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(), mock(EmailDeliveryMethodNotificationTemplate.class));
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate.setEnabled(true);

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, new WebDeliveryMethodNotificationTemplate());
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate = new WebDeliveryMethodNotificationTemplate();

    WebDeliveryMethodNotificationTemplate webDeliveryMethodNotificationTemplate2 = new WebDeliveryMethodNotificationTemplate();
    webDeliveryMethodNotificationTemplate2.setAdditionalConfig(MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(webDeliveryMethodNotificationTemplate, webDeliveryMethodNotificationTemplate2);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(), null);
  }

  /**
   * Test {@link WebDeliveryMethodNotificationTemplate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WebDeliveryMethodNotificationTemplate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WebDeliveryMethodNotificationTemplate(),
        "Different type to WebDeliveryMethodNotificationTemplate");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
}
