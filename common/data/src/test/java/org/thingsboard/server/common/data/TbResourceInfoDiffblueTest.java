package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class TbResourceInfoDiffblueTest {
  /**
   * Test {@link TbResourceInfo#equals(Object)}, and {@link TbResourceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo2);
    int expectedHashCodeResult = tbResourceInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfo2.hashCode());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}, and {@link TbResourceInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo);
    int expectedHashCodeResult = tbResourceInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfo.hashCode());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertNotEquals(tbResource, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo(
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResource());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("Value");

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceKey("Resource Key");

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setPublic(true);

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setPublicResourceKey("Public Resource Key");

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setEtag("Etag");

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setFileName("foo.txt");

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setExternalId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setDescriptorValue("Value");

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setResourceType(ResourceType.LWM2M_MODEL);

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setResourceSubType(ResourceSubType.IMAGE);

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setResourceKey("Resource Key");

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setPublicResourceKey("Public Resource Key");

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setEtag("Etag");

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setFileName("foo.txt");

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();
    tbResourceInfo2.setExternalId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResourceInfo2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), null);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), "Different type to TbResourceInfo");
  }

  /**
   * Test {@link TbResourceInfo#getExternalId()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResourceId TbResourceInfo.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getExternalId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#TbResourceInfo(TbResourceId)}
   *   <li>{@link TbResourceInfo#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfo#setEtag(String)}
   *   <li>{@link TbResourceInfo#setExternalId(TbResourceId)}
   *   <li>{@link TbResourceInfo#setFileName(String)}
   *   <li>{@link TbResourceInfo#setPublic(boolean)}
   *   <li>{@link TbResourceInfo#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceSubType(ResourceSubType)}
   *   <li>{@link TbResourceInfo#setResourceType(ResourceType)}
   *   <li>{@link TbResourceInfo#setSearchText(String)}
   *   <li>{@link TbResourceInfo#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfo#setTitle(String)}
   *   <li>{@link TbResourceInfo#toString()}
   *   <li>{@link TbResourceInfo#getDescriptor()}
   *   <li>{@link TbResourceInfo#getEtag()}
   *   <li>{@link TbResourceInfo#getFileName()}
   *   <li>{@link TbResourceInfo#getName()}
   *   <li>{@link TbResourceInfo#getPublicResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceSubType()}
   *   <li>{@link TbResourceInfo#getResourceType()}
   *   <li>{@link TbResourceInfo#getSearchText()}
   *   <li>{@link TbResourceInfo#getTenantId()}
   *   <li>{@link TbResourceInfo#getTitle()}
   *   <li>{@link TbResourceInfo#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.<init>()", "void TbResourceInfo.<init>(TbResourceId)",
      "JsonNode TbResourceInfo.getDescriptor()", "String TbResourceInfo.getEtag()",
      "String TbResourceInfo.getFileName()", "String TbResourceInfo.getName()",
      "String TbResourceInfo.getPublicResourceKey()", "String TbResourceInfo.getResourceKey()",
      "ResourceSubType TbResourceInfo.getResourceSubType()", "ResourceType TbResourceInfo.getResourceType()",
      "String TbResourceInfo.getSearchText()", "TenantId TbResourceInfo.getTenantId()",
      "String TbResourceInfo.getTitle()", "boolean TbResourceInfo.isPublic()",
      "void TbResourceInfo.setDescriptor(JsonNode)", "void TbResourceInfo.setEtag(String)",
      "void TbResourceInfo.setExternalId(TbResourceId)", "void TbResourceInfo.setFileName(String)",
      "void TbResourceInfo.setPublic(boolean)", "void TbResourceInfo.setPublicResourceKey(String)",
      "void TbResourceInfo.setResourceKey(String)", "void TbResourceInfo.setResourceSubType(ResourceSubType)",
      "void TbResourceInfo.setResourceType(ResourceType)", "void TbResourceInfo.setSearchText(String)",
      "void TbResourceInfo.setTenantId(TenantId)", "void TbResourceInfo.setTitle(String)",
      "String TbResourceInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo(id);
    MissingNode descriptor = MissingNode.getInstance();
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualTbResourceInfo.setExternalId(externalId);
    actualTbResourceInfo.setFileName("foo.txt");
    actualTbResourceInfo.setPublic(true);
    actualTbResourceInfo.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfo.setResourceKey("Resource Key");
    actualTbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);
    actualTbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);
    actualTbResourceInfo.setSearchText("Search Text");
    actualTbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualTbResourceInfo.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfo.toString();
    JsonNode actualDescriptor = actualTbResourceInfo.getDescriptor();
    String actualEtag = actualTbResourceInfo.getEtag();
    String actualFileName = actualTbResourceInfo.getFileName();
    String actualName = actualTbResourceInfo.getName();
    String actualPublicResourceKey = actualTbResourceInfo.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfo.getResourceKey();
    ResourceSubType actualResourceSubType = actualTbResourceInfo.getResourceSubType();
    ResourceType actualResourceType = actualTbResourceInfo.getResourceType();
    String actualSearchText = actualTbResourceInfo.getSearchText();
    TenantId actualTenantId = actualTbResourceInfo.getTenantId();
    String actualTitle = actualTbResourceInfo.getTitle();
    boolean actualIsPublicResult = actualTbResourceInfo.isPublic();

    // Assert
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
        + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
        + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=, externalId=784f394c-42b6-435a-983c"
        + "-b7beff2784f9)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceInfo.getCreatedTime());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(id, actualTbResourceInfo.getId());
    assertSame(descriptor, actualDescriptor);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#TbResourceInfo()}
   *   <li>{@link TbResourceInfo#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfo#setEtag(String)}
   *   <li>{@link TbResourceInfo#setExternalId(TbResourceId)}
   *   <li>{@link TbResourceInfo#setFileName(String)}
   *   <li>{@link TbResourceInfo#setPublic(boolean)}
   *   <li>{@link TbResourceInfo#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceSubType(ResourceSubType)}
   *   <li>{@link TbResourceInfo#setResourceType(ResourceType)}
   *   <li>{@link TbResourceInfo#setSearchText(String)}
   *   <li>{@link TbResourceInfo#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfo#setTitle(String)}
   *   <li>{@link TbResourceInfo#toString()}
   *   <li>{@link TbResourceInfo#getDescriptor()}
   *   <li>{@link TbResourceInfo#getEtag()}
   *   <li>{@link TbResourceInfo#getFileName()}
   *   <li>{@link TbResourceInfo#getName()}
   *   <li>{@link TbResourceInfo#getPublicResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceSubType()}
   *   <li>{@link TbResourceInfo#getResourceType()}
   *   <li>{@link TbResourceInfo#getSearchText()}
   *   <li>{@link TbResourceInfo#getTenantId()}
   *   <li>{@link TbResourceInfo#getTitle()}
   *   <li>{@link TbResourceInfo#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.<init>()", "void TbResourceInfo.<init>(TbResourceId)",
      "JsonNode TbResourceInfo.getDescriptor()", "String TbResourceInfo.getEtag()",
      "String TbResourceInfo.getFileName()", "String TbResourceInfo.getName()",
      "String TbResourceInfo.getPublicResourceKey()", "String TbResourceInfo.getResourceKey()",
      "ResourceSubType TbResourceInfo.getResourceSubType()", "ResourceType TbResourceInfo.getResourceType()",
      "String TbResourceInfo.getSearchText()", "TenantId TbResourceInfo.getTenantId()",
      "String TbResourceInfo.getTitle()", "boolean TbResourceInfo.isPublic()",
      "void TbResourceInfo.setDescriptor(JsonNode)", "void TbResourceInfo.setEtag(String)",
      "void TbResourceInfo.setExternalId(TbResourceId)", "void TbResourceInfo.setFileName(String)",
      "void TbResourceInfo.setPublic(boolean)", "void TbResourceInfo.setPublicResourceKey(String)",
      "void TbResourceInfo.setResourceKey(String)", "void TbResourceInfo.setResourceSubType(ResourceSubType)",
      "void TbResourceInfo.setResourceType(ResourceType)", "void TbResourceInfo.setSearchText(String)",
      "void TbResourceInfo.setTenantId(TenantId)", "void TbResourceInfo.setTitle(String)",
      "String TbResourceInfo.toString()"})
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo();
    MissingNode descriptor = MissingNode.getInstance();
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualTbResourceInfo.setExternalId(externalId);
    actualTbResourceInfo.setFileName("foo.txt");
    actualTbResourceInfo.setPublic(true);
    actualTbResourceInfo.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfo.setResourceKey("Resource Key");
    actualTbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);
    actualTbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);
    actualTbResourceInfo.setSearchText("Search Text");
    actualTbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualTbResourceInfo.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfo.toString();
    JsonNode actualDescriptor = actualTbResourceInfo.getDescriptor();
    String actualEtag = actualTbResourceInfo.getEtag();
    String actualFileName = actualTbResourceInfo.getFileName();
    String actualName = actualTbResourceInfo.getName();
    String actualPublicResourceKey = actualTbResourceInfo.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfo.getResourceKey();
    ResourceSubType actualResourceSubType = actualTbResourceInfo.getResourceSubType();
    ResourceType actualResourceType = actualTbResourceInfo.getResourceType();
    String actualSearchText = actualTbResourceInfo.getSearchText();
    TenantId actualTenantId = actualTbResourceInfo.getTenantId();
    String actualTitle = actualTbResourceInfo.getTitle();
    boolean actualIsPublicResult = actualTbResourceInfo.isPublic();

    // Assert
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
        + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
        + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=, externalId=784f394c-42b6-435a-983c"
        + "-b7beff2784f9)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceInfo.getId());
    assertEquals(0L, actualTbResourceInfo.getCreatedTime());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(descriptor, actualDescriptor);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>Given Instance.</li>
   *   <li>Then return Descriptor is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); given Instance; then return Descriptor is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_givenInstance_thenReturnDescriptorIsInstance() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    MissingNode descriptor = MissingNode.getInstance();
    resourceInfo.setDescriptor(descriptor);

    // Act and Assert
    assertSame(descriptor, (new TbResourceInfo(resourceInfo)).getDescriptor());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>Given {@code Resource Info}.</li>
   *   <li>Then Descriptor return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); given 'Resource Info'; then Descriptor return TextNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_givenResourceInfo_thenDescriptorReturnTextNode() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue("Resource Info");

    // Act and Assert
    JsonNode descriptor = (new TbResourceInfo(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Resource Info\"", descriptor.toPrettyString());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); then Descriptor return ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_thenDescriptorReturnObjectNode() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = (new TbResourceInfo(resourceInfo)).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals("{\r\n  \"entityType\" : \"TB_RESOURCE\",\r\n  \"id\" : \"784f394c-42b6-435a-983c-b7beff2784f9\"\r\n}",
        descriptor.toPrettyString());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertFalse(descriptor.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(descriptor.isObject());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   * <ul>
   *   <li>When {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); when TbResourceInfo(); then return TbResourceInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_whenTbResourceInfo_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();

    // Act and Assert
    assertEquals(resourceInfo, new TbResourceInfo(resourceInfo));
  }

  /**
   * Test {@link TbResourceInfo#getId()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResourceId TbResourceInfo.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getId());
  }

  /**
   * Test {@link TbResourceInfo#getCreatedTime()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TbResourceInfo.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TbResourceInfo()).getCreatedTime());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResourceInfo.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} ResourceType is {@code IMAGE}.</li>
   *   <li>Then return {@code /api/images/tenant/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); given TbResourceInfo() ResourceType is 'IMAGE'; then return '/api/images/tenant/null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink_givenTbResourceInfoResourceTypeIsImage_thenReturnApiImagesTenantNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResourceInfo.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); given TbResourceInfo(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink_givenTbResourceInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   * <ul>
   *   <li>Then return {@code /api/images/system/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); then return '/api/images/system/null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink_thenReturnApiImagesSystemNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/system/null", tbResourceInfo.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Public is {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo() Public is 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getPublicLink()"})
  void testGetPublicLink_givenTbResourceInfoPublicIsFalse_thenReturnNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);
    tbResourceInfo.setPublic(false);

    // Act and Assert
    assertNull(tbResourceInfo.getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Public is {@code true}.</li>
   *   <li>Then return {@code /api/images/public/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo() Public is 'true'; then return '/api/images/public/null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getPublicLink()"})
  void testGetPublicLink_givenTbResourceInfoPublicIsTrue_thenReturnApiImagesPublicNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);
    tbResourceInfo.setPublic(true);

    // Act and Assert
    assertEquals("/api/images/public/null", tbResourceInfo.getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String TbResourceInfo.getPublicLink()"})
  void testGetPublicLink_givenTbResourceInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue(new POJONode(null));
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given BigDecimal(String) with '2.3'; then return BigDecimal(String) with '2.3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenBigDecimalWith23_thenReturnBigDecimalWith23() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    BigDecimal v = new BigDecimal("2.3");
    tbResourceInfo.setDescriptor(new DecimalNode(v));
    Class<Object> type = Object.class;

    // Act and Assert
    assertSame(v, tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is False.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given TbResourceInfo() Descriptor is False; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenTbResourceInfoDescriptorIsFalse_thenReturnFalse()
      throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(BooleanNode.getFalse());
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse((Boolean) tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is True.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given TbResourceInfo() Descriptor is True; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenTbResourceInfoDescriptorIsTrue_thenReturnTrue() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(BooleanNode.getTrue());
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue((Boolean) tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} DescriptorValue is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given TbResourceInfo() DescriptorValue is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenTbResourceInfoDescriptorValueIs42_thenReturn42() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("42");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("42", tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.</li>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; given TbResourceInfo(); when 'java.lang.Object'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenTbResourceInfo_whenJavaLangObject_thenReturnNull()
      throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return doubleValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnDoubleValueIsTen() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(DoubleNode.valueOf(10.0d));
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(10.0d, ((Double) tbResourceInfo.getDescriptor(type)).doubleValue());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnEmpty() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertTrue(((List<Object>) actualDescriptor).isEmpty());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return first Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFirstEmpty() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.addObject();

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(1, ((List<LinkedHashMap>) actualDescriptor).size());
    assertTrue(((List<LinkedHashMap>) actualDescriptor).get(0).isEmpty());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return first floatValue is {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return first floatValue is '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFirstFloatValueIs05() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.add(0.5f);

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(1, ((List<Float>) actualDescriptor).size());
    assertEquals(0.5f, ((List<Float>) actualDescriptor).get(0).floatValue());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return first is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFirstIs42() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.add("42");

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(1, ((List<String>) actualDescriptor).size());
    assertEquals("42", ((List<String>) actualDescriptor).get(0));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return first is {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return first is 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFirstIsPojo() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.addPOJO("Pojo");

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(1, ((List<String>) actualDescriptor).size());
    assertEquals("Pojo", ((List<String>) actualDescriptor).get(0));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return floatValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return floatValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFloatValueIsTen() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(FloatNode.valueOf(10.0f));
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals(10.0f, ((Float) tbResourceInfo.getDescriptor(type)).floatValue());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   * <ul>
   *   <li>Then return {@link BigInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return ONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnOne() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new BigIntegerNode(BigInteger.valueOf(1L)));
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertSame(((BigInteger) actualDescriptor).ONE, actualDescriptor);
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(DataConstants.DEFAULT_SECRET_KEY);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertTrue(descriptor.traverse() instanceof TreeTraversingParser);
    assertEquals("\"\"", descriptor.toPrettyString());
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor2() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} add {@code 0.5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' add '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAdd05() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.add(0.5f);

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor2 = tbResourceInfo.getDescriptor();
    assertTrue(descriptor2 instanceof TextNode);
    assertEquals(0, descriptor2.size());
    assertFalse(descriptor2.isArray());
    assertFalse(descriptor2.isContainerNode());
    assertFalse(descriptor2.iterator().hasNext());
    assertTrue(descriptor2.isEmpty());
    assertTrue(descriptor2.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAdd42() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.add("42");

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor2 = tbResourceInfo.getDescriptor();
    assertTrue(descriptor2 instanceof TextNode);
    assertEquals(0, descriptor2.size());
    assertFalse(descriptor2.isArray());
    assertFalse(descriptor2.isContainerNode());
    assertFalse(descriptor2.iterator().hasNext());
    assertTrue(descriptor2.isEmpty());
    assertTrue(descriptor2.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addObject.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.addObject();

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor2 = tbResourceInfo.getDescriptor();
    assertTrue(descriptor2 instanceof TextNode);
    assertEquals(0, descriptor2.size());
    assertFalse(descriptor2.isArray());
    assertFalse(descriptor2.isContainerNode());
    assertFalse(descriptor2.iterator().hasNext());
    assertTrue(descriptor2.isEmpty());
    assertTrue(descriptor2.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true} addPOJO {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo() throws JsonProcessingException {
    // Arrange
    ArrayNode descriptor = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    descriptor.addPOJO("Pojo");

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor2 = tbResourceInfo.getDescriptor();
    assertTrue(descriptor2 instanceof TextNode);
    assertEquals(0, descriptor2.size());
    assertFalse(descriptor2.isArray());
    assertFalse(descriptor2.isContainerNode());
    assertFalse(descriptor2.iterator().hasNext());
    assertTrue(descriptor2.isEmpty());
    assertTrue(descriptor2.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link UnaryOperator} {@link Function#apply(Object)} return {@code null}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given 'null'; when UnaryOperator apply(Object) return 'null'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenNull_whenUnaryOperatorApplyReturnNull_thenCallsApply() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert that nothing has changed
    verify(updater).apply(isNull());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given one; then TbResourceInfo() Descriptor toPrettyString is '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenOne_thenTbResourceInfoDescriptorToPrettyStringIs1() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(1);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("1", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor BigDecimal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor BigDecimal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorBigDecimal() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new DecimalNode(new BigDecimal("2.3")));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Binary.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Binary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorBinary()
      throws JsonProcessingException, UnsupportedEncodingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isContainerNode());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Boolean.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Boolean")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorBoolean() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(BooleanNode.getFalse());
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Double.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Double")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorDouble() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(DoubleNode.valueOf(10.0d));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Float.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorFloat() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(FloatNode.valueOf(10.0f));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Int.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Int")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorInt() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue(42);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Null.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorNull() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue(new POJONode(null));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isNull());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor Textual.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor Textual")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenTbResourceInfoDescriptorTextual() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("Value");
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert that nothing has changed
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(0, descriptor.size());
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isContainerNode());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor toPrettyString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenTbResourceInfoDescriptorToPrettyStringIs42() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(42);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("42", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor traverse {@link TreeTraversingParser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor traverse TreeTraversingParser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenTbResourceInfoDescriptorTraverseTreeTraversingParser() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertTrue(descriptor.traverse() instanceof TreeTraversingParser);
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(DataConstants.DEFAULT_SECRET_KEY);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"\"", descriptor.toPrettyString());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); then TbResourceInfo() Descriptor toPrettyString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_thenTbResourceInfoDescriptorToPrettyStringIs42() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(42);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("42", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is {@code "Value"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); then TbResourceInfo() Descriptor toPrettyString is '\"Value\"'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_thenTbResourceInfoDescriptorToPrettyStringIsValue() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue("Value");

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals("\"Value\"", descriptor.toPrettyString());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); when 'null'; then TbResourceInfo() Descriptor is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_whenNull_thenTbResourceInfoDescriptorIsNull() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(null);

    // Assert that nothing has changed
    assertNull(tbResourceInfo.getDescriptor());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor toPrettyString is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); when one; then TbResourceInfo() Descriptor toPrettyString is '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_whenOne_thenTbResourceInfoDescriptorToPrettyStringIs1() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(1);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals("1", descriptor.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }
}
