package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeDetailsDiffblueTest {
  /**
   * Test {@link WidgetTypeDetails#equals(Object)}, and
   * {@link WidgetTypeDetails#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link WidgetTypeDetails#equals(Object)}, and
   * {@link WidgetTypeDetails#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link WidgetTypeDetails#equals(Object)}, and
   * {@link WidgetTypeDetails#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link WidgetTypeDetails#equals(Object)}, and
   * {@link WidgetTypeDetails#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setExternalId(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setExternalId(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails2);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}, and
   * {@link WidgetTypeDetails#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetails#equals(Object)}
   *   <li>{@link WidgetTypeDetails#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetTypeDetails, widgetTypeDetails);
    int expectedHashCodeResult = widgetTypeDetails.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetails.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeDetails(), 1);
    assertNotEquals(new WidgetTypeDetails(), mock(WidgetType.class));
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTags(new String[]{"Tags"});

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setExternalId(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetTypeDetails());
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setImage("Image");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, widgetTypeDetails2);
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(widgetTypeDetails, widgetTypeDetails2);
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    WidgetTypeDetails widgetTypeDetails2 = new WidgetTypeDetails();
    widgetTypeDetails2.setExternalId(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(widgetTypeDetails, widgetTypeDetails2);
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeDetails(), null);
  }

  /**
   * Test {@link WidgetTypeDetails#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetails#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeDetails(), "Different type to WidgetTypeDetails");
  }

  /**
   * Test {@link WidgetTypeDetails#getExternalId()}.
   * <p>
   * Method under test: {@link WidgetTypeDetails#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new WidgetTypeDetails()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeDetails actualWidgetTypeDetails = new WidgetTypeDetails();
    actualWidgetTypeDetails.setDescription("The characteristics of someone or something");
    WidgetTypeId externalId = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
        + " externalId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertEquals(0L, actualWidgetTypeDetails.getCreatedTime());
    assertFalse(actualWidgetTypeDetails.isDeprecated());
    assertFalse(actualWidgetTypeDetails.isScada());
    assertSame(externalId, actualWidgetTypeDetails.getExternalId());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    WidgetTypeDetails actualWidgetTypeDetails = new WidgetTypeDetails(id);
    actualWidgetTypeDetails.setDescription("The characteristics of someone or something");
    WidgetTypeId externalId = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
        + " externalId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertEquals(0L, actualWidgetTypeDetails.getCreatedTime());
    assertFalse(actualWidgetTypeDetails.isDeprecated());
    assertFalse(actualWidgetTypeDetails.isScada());
    assertSame(id, actualWidgetTypeDetails.getId());
    assertSame(externalId, actualWidgetTypeDetails.getExternalId());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Test {@link WidgetTypeDetails#WidgetTypeDetails(BaseWidgetType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Deprecated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetTypeDetails(BaseWidgetType); given 'true'; then return Deprecated")
  void testNewWidgetTypeDetails_givenTrue_thenReturnDeprecated() {
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
   * Test {@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeDetails)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()} Deprecated is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeDetails(WidgetTypeDetails); given 'true'; when WidgetTypeDetails() Deprecated is 'true'")
  void testNewWidgetTypeDetails_givenTrue_whenWidgetTypeDetailsDeprecatedIsTrue() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetTypeDetails, new WidgetTypeDetails(widgetTypeDetails));
  }

  /**
   * Test {@link WidgetTypeDetails#WidgetTypeDetails(BaseWidgetType)}.
   * <ul>
   *   <li>When {@link BaseWidgetType#BaseWidgetType()}.</li>
   *   <li>Then return not Deprecated.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetTypeDetails(BaseWidgetType); when BaseWidgetType(); then return not Deprecated")
  void testNewWidgetTypeDetails_whenBaseWidgetType_thenReturnNotDeprecated() {
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
   * Test {@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeDetails)}.
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDetails#WidgetTypeDetails(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeDetails(WidgetTypeDetails); when WidgetTypeDetails()")
  void testNewWidgetTypeDetails_whenWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetTypeDetails, new WidgetTypeDetails(widgetTypeDetails));
  }
}
