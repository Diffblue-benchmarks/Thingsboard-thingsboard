package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;

class EntityViewDiffblueTest {
  /**
   * Test {@link EntityView#getExternalId()}.
   * <p>
   * Method under test: {@link EntityView#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getExternalId());
  }

  /**
   * Test {@link EntityView#EntityView(EntityView)}.
   * <p>
   * Method under test: {@link EntityView#EntityView(EntityView)}
   */
  @Test
  @DisplayName("Test new EntityView(EntityView)")
  void testNewEntityView() throws IOException {
    // Arrange and Act
    EntityView actualEntityView = new EntityView(new EntityView());

    // Assert
    JsonNode additionalInfo = actualEntityView.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualEntityView.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualEntityView.getName());
    assertNull(actualEntityView.getType());
    assertNull(actualEntityView.getUuidId());
    assertNull(actualEntityView.getCustomerId());
    assertNull(actualEntityView.getEntityId());
    assertNull(actualEntityView.getExternalId());
    assertNull(actualEntityView.getId());
    assertNull(actualEntityView.getTenantId());
    assertNull(actualEntityView.getKeys());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualEntityView.getCreatedTime());
    assertEquals(0L, actualEntityView.getEndTimeMs());
    assertEquals(0L, actualEntityView.getStartTimeMs());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)}
   */
  @Test
  @DisplayName("Test new EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long); when 'null'; then return 'Name'")
  void testNewEntityView_whenNull_thenReturnName() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TelemetryEntityView keys = new TelemetryEntityView();

    // Act
    EntityView actualEntityView = new EntityView(TenantId.SYS_TENANT_ID, tenantId, customerId, "Name", "Type", keys, 1L,
        1L, null, 1L);

    // Assert
    assertEquals("Name", actualEntityView.getName());
    assertEquals("Type", actualEntityView.getType());
    assertNull(actualEntityView.getAdditionalInfo());
    assertNull(actualEntityView.getUuidId());
    assertNull(actualEntityView.getExternalId());
    assertNull(actualEntityView.getId());
    assertEquals(0L, actualEntityView.getCreatedTime());
    assertEquals(1L, actualEntityView.getVersion().longValue());
    assertEquals(1L, actualEntityView.getEndTimeMs());
    assertEquals(1L, actualEntityView.getStartTimeMs());
    assertSame(customerId, actualEntityView.getCustomerId());
    assertSame(keys, actualEntityView.getKeys());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntityView.getEntityId());
    assertSame(tenantId2, actualEntityView.getTenantId());
  }

  /**
   * Test {@link EntityView#getId()}.
   * <p>
   * Method under test: {@link EntityView#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getId());
  }

  /**
   * Test {@link EntityView#getCreatedTime()}.
   * <p>
   * Method under test: {@link EntityView#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EntityView()).getCreatedTime());
  }

  /**
   * Test {@link EntityView#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link EntityView#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getAdditionalInfo());
  }

  /**
   * Test {@link EntityView#equals(Object)}, and {@link EntityView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityView entityView2 = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView2);
    int expectedHashCodeResult = entityView.hashCode();
    assertEquals(expectedHashCodeResult, entityView2.hashCode());
  }

  /**
   * Test {@link EntityView#equals(Object)}, and {@link EntityView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView);
    int expectedHashCodeResult = entityView.hashCode();
    assertEquals(expectedHashCodeResult, entityView.hashCode());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityView());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertNotEquals(entityView, new EntityViewInfo());
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), mock(AdminSettings.class));
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityViewInfo entityViewInfo = mock(EntityViewInfo.class);
    when(entityViewInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityView, entityViewInfo);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), null);
  }

  /**
   * Test {@link EntityView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), "Different type to EntityView");
  }
}
