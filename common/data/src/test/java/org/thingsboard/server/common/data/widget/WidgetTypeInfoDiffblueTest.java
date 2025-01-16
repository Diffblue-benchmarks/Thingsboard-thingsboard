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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeInfoDiffblueTest {
  /**
   * Test {@link WidgetTypeInfo#equals(Object)}, and
   * {@link WidgetTypeInfo#hashCode()}.
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
   * Test {@link WidgetTypeInfo#equals(Object)}, and
   * {@link WidgetTypeInfo#hashCode()}.
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
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

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
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

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
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

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
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setDescription("The characteristics of someone or something");
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
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo(widgetTypeDetails);

    WidgetTypeInfo widgetTypeInfo2 = new WidgetTypeInfo();
    widgetTypeInfo2.setDescription("The characteristics of someone or something");
    widgetTypeInfo2.setImage("Image");

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
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetTypeInfo(), "Different type to WidgetTypeInfo");
  }

  /**
   * Test getters and setters.
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
   * Test {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeDetails); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
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
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()} Descriptor is
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeDetails); given Instance; when WidgetTypeDetails() Descriptor is Instance")
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
   *   <li>When {@link WidgetTypeInfo#WidgetTypeInfo()} Deprecated is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfo#WidgetTypeInfo(WidgetTypeInfo)}
   */
  @Test
  @DisplayName("Test new WidgetTypeInfo(WidgetTypeInfo); given 'true'; when WidgetTypeInfo() Deprecated is 'true'")
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
  void testNewWidgetTypeInfo_whenWidgetTypeInfo() {
    // Arrange
    WidgetTypeInfo widgetTypeInfo = new WidgetTypeInfo();

    // Act and Assert
    assertEquals(widgetTypeInfo, new WidgetTypeInfo(widgetTypeInfo));
  }
}
