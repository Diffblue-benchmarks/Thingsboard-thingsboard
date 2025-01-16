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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class TenantDiffblueTest {
  /**
   * Test {@link Tenant#equals(Object)}, and {@link Tenant#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#equals(Object)}
   *   <li>{@link Tenant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Tenant tenant = new Tenant();
    Tenant tenant2 = new Tenant();

    // Act and Assert
    assertEquals(tenant, tenant2);
    int expectedHashCodeResult = tenant.hashCode();
    assertEquals(expectedHashCodeResult, tenant2.hashCode());
  }

  /**
   * Test {@link Tenant#equals(Object)}, and {@link Tenant#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#equals(Object)}
   *   <li>{@link Tenant#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Tenant tenant = new Tenant();

    // Act and Assert
    assertEquals(tenant, tenant);
    int expectedHashCodeResult = tenant.hashCode();
    assertEquals(expectedHashCodeResult, tenant.hashCode());
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Tenant tenant = new Tenant(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tenant, new Tenant());
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Tenant tenant = new Tenant();

    // Act and Assert
    assertNotEquals(tenant, new TenantInfo());
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), mock(Customer.class));
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Tenant tenant = new Tenant();
    TenantInfo tenantInfo = mock(TenantInfo.class);
    when(tenantInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tenant, tenantInfo);
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), null);
  }

  /**
   * Test {@link Tenant#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), "Different type to Tenant");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#Tenant()}
   *   <li>{@link Tenant#setRegion(String)}
   *   <li>{@link Tenant#setTitle(String)}
   *   <li>{@link Tenant#setVersion(Long)}
   *   <li>{@link Tenant#toString()}
   *   <li>{@link Tenant#getName()}
   *   <li>{@link Tenant#getRegion()}
   *   <li>{@link Tenant#getTenantProfileId()}
   *   <li>{@link Tenant#getTitle()}
   *   <li>{@link Tenant#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    Tenant actualTenant = new Tenant();
    actualTenant.setRegion("us-east-2");
    actualTenant.setTitle("Dr");
    actualTenant.setVersion(1L);
    String actualToStringResult = actualTenant.toString();
    String actualName = actualTenant.getName();
    String actualRegion = actualTenant.getRegion();
    actualTenant.getTenantProfileId();
    String actualTitle = actualTenant.getTitle();
    Long actualVersion = actualTenant.getVersion();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals("Tenant [title=Dr, region=us-east-2, tenantProfileId=null, additionalInfo=null, country=null,"
        + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
        + " id=null]", actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertEquals(0L, actualTenant.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   *   <li>Then return Id is {@link TenantId#SYS_TENANT_ID}
   * {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#Tenant(TenantId)}
   *   <li>{@link Tenant#setRegion(String)}
   *   <li>{@link Tenant#setTitle(String)}
   *   <li>{@link Tenant#setVersion(Long)}
   *   <li>{@link Tenant#toString()}
   *   <li>{@link Tenant#getName()}
   *   <li>{@link Tenant#getRegion()}
   *   <li>{@link Tenant#getTenantProfileId()}
   *   <li>{@link Tenant#getTitle()}
   *   <li>{@link Tenant#getVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID; then return Id is SYS_TENANT_ID SYS_TENANT_ID")
  void testGettersAndSetters_whenSys_tenant_id_thenReturnIdIsSys_tenant_idSys_tenant_id() {
    // Arrange
    TenantId id = TenantId.SYS_TENANT_ID;

    // Act
    Tenant actualTenant = new Tenant(id);
    actualTenant.setRegion("us-east-2");
    actualTenant.setTitle("Dr");
    actualTenant.setVersion(1L);
    String actualToStringResult = actualTenant.toString();
    String actualName = actualTenant.getName();
    String actualRegion = actualTenant.getRegion();
    actualTenant.getTenantProfileId();
    String actualTitle = actualTenant.getTitle();
    Long actualVersion = actualTenant.getVersion();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "Tenant [title=Dr, region=us-east-2, tenantProfileId=null, additionalInfo=null, country=null, state=null,"
            + " city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0, id=13814000"
            + "-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertEquals(0L, actualTenant.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    TenantId expectedId = id.SYS_TENANT_ID;
    assertSame(expectedId, actualTenant.getId());
  }

  /**
   * Test {@link Tenant#Tenant(Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  @DisplayName("Test new Tenant(Tenant); when Tenant()")
  void testNewTenant_whenTenant() throws IOException {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant());

    // Assert
    JsonNode additionalInfo = actualTenant.getAdditionalInfo();
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
    assertNull(actualTenant.getVersion());
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
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
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
    assertEquals(0L, actualTenant.getCreatedTime());
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
   * Test {@link Tenant#Tenant(Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant(Tenant)} with tenant is
   * {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  @DisplayName("Test new Tenant(Tenant); when Tenant(Tenant) with tenant is Tenant()")
  void testNewTenant_whenTenantWithTenantIsTenant() throws IOException {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant(new Tenant()));

    // Assert
    JsonNode additionalInfo = actualTenant.getAdditionalInfo();
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
    assertNull(actualTenant.getVersion());
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
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
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
    assertEquals(0L, actualTenant.getCreatedTime());
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
   * Test {@link Tenant#Tenant(Tenant)}.
   * <ul>
   *   <li>When {@link Tenant#Tenant(Tenant)} with tenant is
   * {@link Tenant#Tenant(Tenant)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  @DisplayName("Test new Tenant(Tenant); when Tenant(Tenant) with tenant is Tenant(Tenant)")
  void testNewTenant_whenTenantWithTenantIsTenant2() throws IOException {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant(new Tenant(new Tenant())));

    // Assert
    JsonNode additionalInfo = actualTenant.getAdditionalInfo();
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
    assertNull(actualTenant.getVersion());
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
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
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
    assertEquals(0L, actualTenant.getCreatedTime());
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
   * Test {@link Tenant#getTenantId()}.
   * <p>
   * Method under test: {@link Tenant#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getTenantId());
  }

  /**
   * Test {@link Tenant#getId()}.
   * <p>
   * Method under test: {@link Tenant#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getId());
  }

  /**
   * Test {@link Tenant#getCreatedTime()}.
   * <p>
   * Method under test: {@link Tenant#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Tenant()).getCreatedTime());
  }

  /**
   * Test {@link Tenant#getCountry()}.
   * <p>
   * Method under test: {@link Tenant#getCountry()}
   */
  @Test
  @DisplayName("Test getCountry()")
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getCountry());
  }

  /**
   * Test {@link Tenant#getState()}.
   * <p>
   * Method under test: {@link Tenant#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getState());
  }

  /**
   * Test {@link Tenant#getCity()}.
   * <p>
   * Method under test: {@link Tenant#getCity()}
   */
  @Test
  @DisplayName("Test getCity()")
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getCity());
  }

  /**
   * Test {@link Tenant#getAddress()}.
   * <p>
   * Method under test: {@link Tenant#getAddress()}
   */
  @Test
  @DisplayName("Test getAddress()")
  void testGetAddress() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAddress());
  }

  /**
   * Test {@link Tenant#getAddress2()}.
   * <p>
   * Method under test: {@link Tenant#getAddress2()}
   */
  @Test
  @DisplayName("Test getAddress2()")
  void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAddress2());
  }

  /**
   * Test {@link Tenant#getZip()}.
   * <p>
   * Method under test: {@link Tenant#getZip()}
   */
  @Test
  @DisplayName("Test getZip()")
  void testGetZip() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getZip());
  }

  /**
   * Test {@link Tenant#getPhone()}.
   * <p>
   * Method under test: {@link Tenant#getPhone()}
   */
  @Test
  @DisplayName("Test getPhone()")
  void testGetPhone() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getPhone());
  }

  /**
   * Test {@link Tenant#getEmail()}.
   * <p>
   * Method under test: {@link Tenant#getEmail()}
   */
  @Test
  @DisplayName("Test getEmail()")
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getEmail());
  }

  /**
   * Test {@link Tenant#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Tenant#Tenant(Tenant)} with tenant is
   * {@link Tenant#Tenant()}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Tenant(Tenant) with tenant is Tenant(); then return instance")
  void testGetAdditionalInfo_givenTenantWithTenantIsTenant_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Tenant(new Tenant())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Tenant#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Tenant#Tenant(Tenant)} with tenant is
   * {@link Tenant#Tenant(Tenant)}.</li>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Tenant(Tenant) with tenant is Tenant(Tenant); then return instance")
  void testGetAdditionalInfo_givenTenantWithTenantIsTenant_thenReturnInstance2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Tenant(new Tenant(new Tenant()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link Tenant#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link Tenant#Tenant()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given Tenant(); then return 'null'")
  void testGetAdditionalInfo_givenTenant_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAdditionalInfo());
  }
}
