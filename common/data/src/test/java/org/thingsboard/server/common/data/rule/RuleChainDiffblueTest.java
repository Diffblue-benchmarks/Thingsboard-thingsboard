package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleChainDiffblueTest {
  /**
   * Test {@link RuleChain#equals(Object)}, and {@link RuleChain#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#equals(Object)}
   *   <li>{@link RuleChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    RuleChain ruleChain2 = new RuleChain();

    // Act and Assert
    assertEquals(ruleChain, ruleChain2);
    int expectedHashCodeResult = ruleChain.hashCode();
    assertEquals(expectedHashCodeResult, ruleChain2.hashCode());
  }

  /**
   * Test {@link RuleChain#equals(Object)}, and {@link RuleChain#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#equals(Object)}
   *   <li>{@link RuleChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    // Act and Assert
    assertEquals(ruleChain, ruleChain);
    int expectedHashCodeResult = ruleChain.hashCode();
    assertEquals(expectedHashCodeResult, ruleChain.hashCode());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), mock(RuleNode.class));
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setName("Name");

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setType(RuleChainType.CORE);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setFirstRuleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setDebugMode(true);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setExternalId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(ruleChain, new RuleChain());
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setName("Name");

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setType(RuleChainType.CORE);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setFirstRuleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setExternalId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setVersion(1L);

    // Act and Assert
    assertNotEquals(ruleChain, ruleChain2);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), null);
  }

  /**
   * Test {@link RuleChain#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleChain(), "Different type to RuleChain");
  }

  /**
   * Test {@link RuleChain#getExternalId()}.
   * <p>
   * Method under test: {@link RuleChain#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new RuleChain()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#RuleChain()}
   *   <li>{@link RuleChain#setConfigurationBytes(byte[])}
   *   <li>{@link RuleChain#setDebugMode(boolean)}
   *   <li>{@link RuleChain#setExternalId(RuleChainId)}
   *   <li>{@link RuleChain#setFirstRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChain#setName(String)}
   *   <li>{@link RuleChain#setRoot(boolean)}
   *   <li>{@link RuleChain#setTenantId(TenantId)}
   *   <li>{@link RuleChain#setType(RuleChainType)}
   *   <li>{@link RuleChain#setVersion(Long)}
   *   <li>{@link RuleChain#toString()}
   *   <li>{@link RuleChain#getConfigurationBytes()}
   *   <li>{@link RuleChain#getFirstRuleNodeId()}
   *   <li>{@link RuleChain#getName()}
   *   <li>{@link RuleChain#getTenantId()}
   *   <li>{@link RuleChain#getType()}
   *   <li>{@link RuleChain#getVersion()}
   *   <li>{@link RuleChain#isDebugMode()}
   *   <li>{@link RuleChain#isRoot()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain();
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleChain.setConfigurationBytes(configurationBytes);
    actualRuleChain.setDebugMode(true);
    RuleChainId externalId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleChain.setExternalId(externalId);
    RuleNodeId firstRuleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleChain.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChain.setName("Name");
    actualRuleChain.setRoot(true);
    actualRuleChain.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChain.setType(RuleChainType.CORE);
    actualRuleChain.setVersion(1L);
    String actualToStringResult = actualRuleChain.toString();
    byte[] actualConfigurationBytes = actualRuleChain.getConfigurationBytes();
    RuleNodeId actualFirstRuleNodeId = actualRuleChain.getFirstRuleNodeId();
    String actualName = actualRuleChain.getName();
    TenantId actualTenantId = actualRuleChain.getTenantId();
    RuleChainType actualType = actualRuleChain.getType();
    Long actualVersion = actualRuleChain.getVersion();
    boolean actualIsDebugModeResult = actualRuleChain.isDebugMode();
    boolean actualIsRootResult = actualRuleChain.isRoot();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChain(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9, root=true, debugMode=true, configuration=null, externalId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9, version=1, configurationBytes=[65, 88, 65, 88, 65, 88, 65, 88])",
        actualToStringResult);
    assertEquals(0L, actualRuleChain.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualRuleChain.getExternalId());
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChain#RuleChain(RuleChainId)}
   *   <li>{@link RuleChain#setConfigurationBytes(byte[])}
   *   <li>{@link RuleChain#setDebugMode(boolean)}
   *   <li>{@link RuleChain#setExternalId(RuleChainId)}
   *   <li>{@link RuleChain#setFirstRuleNodeId(RuleNodeId)}
   *   <li>{@link RuleChain#setName(String)}
   *   <li>{@link RuleChain#setRoot(boolean)}
   *   <li>{@link RuleChain#setTenantId(TenantId)}
   *   <li>{@link RuleChain#setType(RuleChainType)}
   *   <li>{@link RuleChain#setVersion(Long)}
   *   <li>{@link RuleChain#toString()}
   *   <li>{@link RuleChain#getConfigurationBytes()}
   *   <li>{@link RuleChain#getFirstRuleNodeId()}
   *   <li>{@link RuleChain#getName()}
   *   <li>{@link RuleChain#getTenantId()}
   *   <li>{@link RuleChain#getType()}
   *   <li>{@link RuleChain#getVersion()}
   *   <li>{@link RuleChain#isDebugMode()}
   *   <li>{@link RuleChain#isRoot()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    RuleChainId id = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleChain actualRuleChain = new RuleChain(id);
    byte[] configurationBytes = "AXAXAXAX".getBytes("UTF-8");
    actualRuleChain.setConfigurationBytes(configurationBytes);
    actualRuleChain.setDebugMode(true);
    RuleChainId externalId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleChain.setExternalId(externalId);
    RuleNodeId firstRuleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualRuleChain.setFirstRuleNodeId(firstRuleNodeId);
    actualRuleChain.setName("Name");
    actualRuleChain.setRoot(true);
    actualRuleChain.setTenantId(TenantId.SYS_TENANT_ID);
    actualRuleChain.setType(RuleChainType.CORE);
    actualRuleChain.setVersion(1L);
    String actualToStringResult = actualRuleChain.toString();
    byte[] actualConfigurationBytes = actualRuleChain.getConfigurationBytes();
    RuleNodeId actualFirstRuleNodeId = actualRuleChain.getFirstRuleNodeId();
    String actualName = actualRuleChain.getName();
    TenantId actualTenantId = actualRuleChain.getTenantId();
    RuleChainType actualType = actualRuleChain.getType();
    Long actualVersion = actualRuleChain.getVersion();
    boolean actualIsDebugModeResult = actualRuleChain.isDebugMode();
    boolean actualIsRootResult = actualRuleChain.isRoot();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(
        "RuleChain(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, type=CORE, firstRuleNodeId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9, root=true, debugMode=true, configuration=null, externalId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9, version=1, configurationBytes=[65, 88, 65, 88, 65, 88, 65, 88])",
        actualToStringResult);
    assertEquals(0L, actualRuleChain.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertEquals(RuleChainType.CORE, actualType);
    assertTrue(actualIsDebugModeResult);
    assertTrue(actualIsRootResult);
    assertSame(externalId, actualRuleChain.getExternalId());
    assertSame(id, actualRuleChain.getId());
    assertSame(firstRuleNodeId, actualFirstRuleNodeId);
    assertSame(configurationBytes, actualConfigurationBytes);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); given 'A'")
  void testNewRuleChain_givenA() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3});

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   *   <li>Then Configuration return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); given empty array of byte; then Configuration return MissingNode")
  void testNewRuleChain_givenEmptyArrayOfByte_thenConfigurationReturnMissingNode() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{});

    // Act and Assert
    JsonNode configuration = (new RuleChain(ruleChain)).getConfiguration();
    assertTrue(configuration instanceof MissingNode);
    JsonParser traverseResult = configuration.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", configuration.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, configuration.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(JsonNodeType.MISSING, configuration.getNodeType());
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
    assertFalse(configuration.isArray());
    assertFalse(configuration.isBigDecimal());
    assertFalse(configuration.isBigInteger());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(configuration.isContainerNode());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isFloat());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(configuration.isInt());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(configuration.isLong());
    assertFalse(configuration.isNull());
    assertFalse(configuration.isNumber());
    assertFalse(configuration.isObject());
    assertFalse(configuration.isPojo());
    assertFalse(configuration.isShort());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertTrue(configuration.isEmpty());
    assertTrue(configuration.isMissingNode());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link RuleChain#RuleChain()} Root is {@code true}.</li>
   *   <li>Then return Root.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); given 'true'; when RuleChain() Root is 'true'; then return Root")
  void testNewRuleChain_givenTrue_whenRuleChainRootIsTrue_thenReturnRoot() throws IOException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act
    RuleChain actualRuleChain = new RuleChain(ruleChain);

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualRuleChain.isRoot());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is
   * {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return not Root.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); when RuleChain(RuleChain) with ruleChain is RuleChain(); then return not Root")
  void testNewRuleChain_whenRuleChainWithRuleChainIsRuleChain_thenReturnNotRoot() throws IOException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain(RuleChain)} with ruleChain is
   * {@link RuleChain#RuleChain(RuleChain)}.</li>
   *   <li>Then return not Root.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); when RuleChain(RuleChain) with ruleChain is RuleChain(RuleChain); then return not Root")
  void testNewRuleChain_whenRuleChainWithRuleChainIsRuleChain_thenReturnNotRoot2() throws IOException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain(new RuleChain(new RuleChain(new RuleChain())));

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#RuleChain(RuleChain)}.
   * <ul>
   *   <li>When {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return not Root.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#RuleChain(RuleChain)}
   */
  @Test
  @DisplayName("Test new RuleChain(RuleChain); when RuleChain(); then return not Root")
  void testNewRuleChain_whenRuleChain_thenReturnNotRoot() throws IOException {
    // Arrange and Act
    RuleChain actualRuleChain = new RuleChain(new RuleChain());

    // Assert
    JsonNode additionalInfo = actualRuleChain.getAdditionalInfo();
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
    assertNull(actualRuleChain.getVersion());
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
    assertNull(actualRuleChain.getName());
    assertNull(actualRuleChain.getUuidId());
    assertNull(actualRuleChain.getExternalId());
    assertNull(actualRuleChain.getId());
    assertNull(actualRuleChain.getFirstRuleNodeId());
    assertNull(actualRuleChain.getTenantId());
    assertNull(actualRuleChain.getType());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
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
    assertEquals(0L, actualRuleChain.getCreatedTime());
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
    assertFalse(actualRuleChain.isDebugMode());
    assertFalse(actualRuleChain.isDefault());
    assertFalse(actualRuleChain.isRoot());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(additionalInfo, actualRuleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualRuleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#getId()}.
   * <p>
   * Method under test: {@link RuleChain#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new RuleChain()).getId());
  }

  /**
   * Test {@link RuleChain#getCreatedTime()}.
   * <p>
   * Method under test: {@link RuleChain#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new RuleChain()).getCreatedTime());
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   * <p>
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration()")
  void testGetConfiguration() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain());

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleChain.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   * <p>
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration()")
  void testGetConfiguration2() {
    // Arrange
    RuleChain ruleChain = new RuleChain(new RuleChain(new RuleChain()));

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    NullNode nullNode = ((NullNode) actualConfiguration).instance;
    assertSame(nullNode, ruleChain.getAdditionalInfo());
    assertSame(nullNode, actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} ConfigurationBytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); given RuleChain() ConfigurationBytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetConfiguration_givenRuleChainConfigurationBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes("AXAXAXAX".getBytes("UTF-8"));

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    assertNull(ruleChain.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()}.</li>
   *   <li>Then {@link RuleChain#RuleChain()} AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); given RuleChain(); then RuleChain() AdditionalInfo is 'null'")
  void testGetConfiguration_givenRuleChain_thenRuleChainAdditionalInfoIsNull() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    assertNull(ruleChain.getAdditionalInfo());
    assertNull(actualConfiguration);
  }

  /**
   * Test {@link RuleChain#getConfiguration()}.
   * <ul>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#getConfiguration()}
   */
  @Test
  @DisplayName("Test getConfiguration(); then return MissingNode")
  void testGetConfiguration_thenReturnMissingNode() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setConfigurationBytes(new byte[]{});

    // Act
    JsonNode actualConfiguration = ruleChain.getConfiguration();

    // Assert
    assertTrue(actualConfiguration instanceof MissingNode);
    assertTrue(actualConfiguration.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualConfiguration.toPrettyString());
    assertEquals(JsonNodeType.MISSING, actualConfiguration.getNodeType());
    assertFalse(actualConfiguration.isNull());
    assertFalse(actualConfiguration.isValueNode());
    assertTrue(actualConfiguration.isMissingNode());
  }

  /**
   * Test {@link RuleChain#setConfiguration(JsonNode)}.
   * <p>
   * Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode)")
  void testSetConfiguration() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "[{}]".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#setConfiguration(JsonNode)}.
   * <ul>
   *   <li>Then array length is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode); then array length is seven")
  void testSetConfiguration_thenArrayLengthIsSeven() {
    // Arrange
    RuleChain ruleChain = new RuleChain();

    ArrayNode data = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    data.addObject();
    data.addObject();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    byte[] configurationBytes = ruleChain.getConfigurationBytes();
    assertEquals(7, configurationBytes.length);
    assertEquals(',', configurationBytes[3]);
    assertEquals(']', configurationBytes[6]);
    assertEquals('{', configurationBytes[4]);
    assertEquals('}', configurationBytes[5]);
  }

  /**
   * Test {@link RuleChain#setConfiguration(JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then {@link RuleChain#RuleChain()} Configuration is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#setConfiguration(JsonNode)}
   */
  @Test
  @DisplayName("Test setConfiguration(JsonNode); when Instance; then RuleChain() Configuration is Instance")
  void testSetConfiguration_whenInstance_thenRuleChainConfigurationIsInstance() throws UnsupportedEncodingException {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    MissingNode data = MissingNode.getInstance();

    // Act
    ruleChain.setConfiguration(data);

    // Assert
    assertSame(data, ruleChain.getConfiguration());
    byte[] expectedConfigurationBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, ruleChain.getConfigurationBytes());
  }

  /**
   * Test {@link RuleChain#isDefault()}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Root is {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given RuleChain() Root is 'true'; then return 'false'")
  void testIsDefault_givenRuleChainRootIsTrue_thenReturnFalse() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setRoot(true);

    // Act and Assert
    assertFalse(ruleChain.isDefault());
  }

  /**
   * Test {@link RuleChain#isDefault()}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Type is {@code CORE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given RuleChain() Type is 'CORE'; then return 'true'")
  void testIsDefault_givenRuleChainTypeIsCore_thenReturnTrue() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setType(RuleChainType.CORE);
    ruleChain.setRoot(true);

    // Act and Assert
    assertTrue(ruleChain.isDefault());
  }

  /**
   * Test {@link RuleChain#isDefault()}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChain#isDefault()}
   */
  @Test
  @DisplayName("Test isDefault(); given RuleChain(); then return 'false'")
  void testIsDefault_givenRuleChain_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new RuleChain()).isDefault());
  }
}
