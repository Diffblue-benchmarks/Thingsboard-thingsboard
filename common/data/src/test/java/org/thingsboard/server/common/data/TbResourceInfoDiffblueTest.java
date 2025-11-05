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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo2);
    assertEquals(tbResourceInfo.hashCode(), tbResourceInfo2.hashCode());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}, and {@link TbResourceInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertNotEquals(tbResource, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbResourceInfo tbResourceInfo = new TbResourceInfo(id);

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResource());
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setPublic(true);

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setPublic(true);

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(null);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setTenantId(TenantId.SYS_TENANT_ID);
    tbResource.setPublic(true);

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(null);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setTitle("Dr");
    tbResource.setPublic(true);

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(null);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setTitle("Mr");
    tbResource.setPublic(true);

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(null);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() throws UnsupportedEncodingException {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setTenantId(TenantId.SYS_TENANT_ID);
    tbResource.setPublic(true);

    TbResource tbResource2 = mock(TbResource.class);
    when(tbResource2.isPublic()).thenReturn(true);
    when(tbResource2.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(tbResource2.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(tbResource2.getEtag()).thenReturn("Etag");
    when(tbResource2.getFileName()).thenReturn("foo.txt");
    when(tbResource2.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(tbResource2.getResourceKey()).thenReturn("Resource Key");
    when(tbResource2.getSearchText()).thenReturn("Search Text");
    when(tbResource2.getTitle()).thenReturn("Dr");
    when(tbResource2.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(tbResource2.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(tbResource2.getExternalId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbResource2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(tbResource2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResource, tbResource2);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), null);
  }

  /**
   * Test {@link TbResourceInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceInfo.equals(Object)", "int TbResourceInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), "Different type to TbResourceInfo");
  }

  /**
   * Test {@link TbResourceInfo#getExternalId()}.
   *
   * <p>Method under test: {@link TbResourceInfo#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceId TbResourceInfo.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new TbResourceInfo().getExternalId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbResourceInfo.<init>()",
    "void TbResourceInfo.<init>(TbResourceId)",
    "JsonNode TbResourceInfo.getDescriptor()",
    "String TbResourceInfo.getEtag()",
    "String TbResourceInfo.getFileName()",
    "String TbResourceInfo.getName()",
    "String TbResourceInfo.getPublicResourceKey()",
    "String TbResourceInfo.getResourceKey()",
    "ResourceSubType TbResourceInfo.getResourceSubType()",
    "ResourceType TbResourceInfo.getResourceType()",
    "String TbResourceInfo.getSearchText()",
    "TenantId TbResourceInfo.getTenantId()",
    "String TbResourceInfo.getTitle()",
    "boolean TbResourceInfo.isPublic()",
    "void TbResourceInfo.setDescriptor(JsonNode)",
    "void TbResourceInfo.setEtag(String)",
    "void TbResourceInfo.setExternalId(TbResourceId)",
    "void TbResourceInfo.setFileName(String)",
    "void TbResourceInfo.setPublic(boolean)",
    "void TbResourceInfo.setPublicResourceKey(String)",
    "void TbResourceInfo.setResourceKey(String)",
    "void TbResourceInfo.setResourceSubType(ResourceSubType)",
    "void TbResourceInfo.setResourceType(ResourceType)",
    "void TbResourceInfo.setSearchText(String)",
    "void TbResourceInfo.setTenantId(TenantId)",
    "void TbResourceInfo.setTitle(String)",
    "String TbResourceInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo(id);
    DoubleNode descriptor = DoubleNode.valueOf(10.0d);
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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

    // Assert
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals(
        "TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
            + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
            + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=10.0, externalId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9)",
        actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualTbResourceInfo.isPublic());
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(id, actualTbResourceInfo.getId());
    assertSame(descriptor, actualDescriptor);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbResourceInfo.<init>()",
    "void TbResourceInfo.<init>(TbResourceId)",
    "JsonNode TbResourceInfo.getDescriptor()",
    "String TbResourceInfo.getEtag()",
    "String TbResourceInfo.getFileName()",
    "String TbResourceInfo.getName()",
    "String TbResourceInfo.getPublicResourceKey()",
    "String TbResourceInfo.getResourceKey()",
    "ResourceSubType TbResourceInfo.getResourceSubType()",
    "ResourceType TbResourceInfo.getResourceType()",
    "String TbResourceInfo.getSearchText()",
    "TenantId TbResourceInfo.getTenantId()",
    "String TbResourceInfo.getTitle()",
    "boolean TbResourceInfo.isPublic()",
    "void TbResourceInfo.setDescriptor(JsonNode)",
    "void TbResourceInfo.setEtag(String)",
    "void TbResourceInfo.setExternalId(TbResourceId)",
    "void TbResourceInfo.setFileName(String)",
    "void TbResourceInfo.setPublic(boolean)",
    "void TbResourceInfo.setPublicResourceKey(String)",
    "void TbResourceInfo.setResourceKey(String)",
    "void TbResourceInfo.setResourceSubType(ResourceSubType)",
    "void TbResourceInfo.setResourceType(ResourceType)",
    "void TbResourceInfo.setSearchText(String)",
    "void TbResourceInfo.setTenantId(TenantId)",
    "void TbResourceInfo.setTitle(String)",
    "String TbResourceInfo.toString()"
  })
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo();
    DoubleNode descriptor = DoubleNode.valueOf(10.0d);
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId =
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    assertEquals(
        "TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
            + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
            + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=10.0, externalId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9)",
        actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceInfo.getId());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(descriptor, actualDescriptor);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then return UuidId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName(
      "Test new TbResourceInfo(TbResourceInfo); given Instance; then return UuidId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_givenInstance_thenReturnUuidIdIsNull() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    MissingNode descriptor = MissingNode.getInstance();
    resourceInfo.setDescriptor(descriptor);

    // Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo(resourceInfo);

    // Assert
    assertNull(actualTbResourceInfo.getUuidId());
    assertNull(actualTbResourceInfo.getId());
    assertSame(descriptor, actualTbResourceInfo.getDescriptor());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   *
   * <ul>
   *   <li>Given {@code Resource Info}.
   *   <li>Then Descriptor return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName(
      "Test new TbResourceInfo(TbResourceInfo); given 'Resource Info'; then Descriptor return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_givenResourceInfo_thenDescriptorReturnTextNode() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource resourceInfo = new TbResource(id);
    resourceInfo.setDescriptorValue("Resource Info");

    // Act and Assert
    JsonNode descriptor = new TbResourceInfo(resourceInfo).getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   *
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName("Test new TbResourceInfo(TbResourceInfo); then Descriptor return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_thenDescriptorReturnObjectNode() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource resourceInfo = new TbResource(id);
    resourceInfo.setDescriptorValue(
        new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode descriptor = new TbResourceInfo(resourceInfo).getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertFalse(descriptor.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(descriptor.isContainerNode());
    assertTrue(descriptor.isObject());
  }

  /**
   * Test {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}.
   *
   * <ul>
   *   <li>When {@link TbResourceInfo#TbResourceInfo()}.
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  @DisplayName(
      "Test new TbResourceInfo(TbResourceInfo); when TbResourceInfo(); then return TbResourceInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.<init>(TbResourceInfo)"})
  void testNewTbResourceInfo_whenTbResourceInfo_thenReturnTbResourceInfo() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();

    // Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo(resourceInfo);

    // Assert
    assertEquals(resourceInfo, actualTbResourceInfo);
  }

  /**
   * Test {@link TbResourceInfo#getId()}.
   *
   * <p>Method under test: {@link TbResourceInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceId TbResourceInfo.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new TbResourceInfo().getId());
  }

  /**
   * Test {@link TbResourceInfo#getCreatedTime()}.
   *
   * <p>Method under test: {@link TbResourceInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbResourceInfo.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new TbResourceInfo().getCreatedTime());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   *
   * <p>Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResource.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   *
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); given TbResourceInfo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink_givenTbResourceInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TbResourceInfo().getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   *
   * <ul>
   *   <li>Given {@link TbResource#TbResource(TbResourceId)} with id is {@link
   *       TbResourceId#TbResourceId(UUID)} TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName(
      "Test getLink(); given TbResource(TbResourceId) with id is TbResourceId(UUID) TenantId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink_givenTbResourceWithIdIsTbResourceIdTenantIdIsNull() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setTenantId(null);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResource.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getLink()}.
   *
   * <ul>
   *   <li>Then return {@code /api/images/system/null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  @DisplayName("Test getLink(); then return '/api/images/system/null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getLink()"})
  void testGetLink_thenReturnApiImagesSystemNull() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals("/api/images/system/null", tbResource.getLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   *
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); given TbResourceInfo(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getPublicLink()"})
  void testGetPublicLink_givenTbResourceInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TbResourceInfo().getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   *
   * <ul>
   *   <li>Given {@link TbResource#TbResource(TbResourceId)} with id is {@link
   *       TbResourceId#TbResourceId(UUID)} Public is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName(
      "Test getPublicLink(); given TbResource(TbResourceId) with id is TbResourceId(UUID) Public is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getPublicLink()"})
  void testGetPublicLink_givenTbResourceWithIdIsTbResourceIdPublicIsFalse() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setPublic(false);

    // Act and Assert
    assertNull(tbResource.getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getPublicLink()}.
   *
   * <ul>
   *   <li>Then return {@code /api/images/public/null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  @DisplayName("Test getPublicLink(); then return '/api/images/public/null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbResourceInfo.getPublicLink()"})
  void testGetPublicLink_thenReturnApiImagesPublicNull() {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setResourceType(ResourceType.IMAGE);
    tbResource.setPublic(true);

    // Act and Assert
    assertEquals("/api/images/public/null", tbResource.getPublicLink());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass() throws JsonProcessingException {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setDescriptorValue(new POJONode(null));
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(tbResource.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName(
      "Test getDescriptor(Class) with 'Class'; given BigDecimal(String) with '2.3'; then return BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenBigDecimalWith23_thenReturnBigDecimalWith23()
      throws JsonProcessingException {
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
   *
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is False.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName(
      "Test getDescriptor(Class) with 'Class'; given TbResourceInfo() Descriptor is False; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()} Descriptor is True.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName(
      "Test getDescriptor(Class) with 'Class'; given TbResourceInfo() Descriptor is True; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_givenTbResourceInfoDescriptorIsTrue_thenReturnTrue()
      throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(BooleanNode.getTrue());
    Class<Object> type = Object.class;

    // Act and Assert
    assertTrue((Boolean) tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Given {@link TbResourceInfo#TbResourceInfo()}.
   *   <li>When {@code Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName(
      "Test getDescriptor(Class) with 'Class'; given TbResourceInfo(); when 'java.lang.Object'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then first return {@link Map}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then first return Map")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenFirstReturnMap() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.addObject();
    descriptor.add(DoubleNode.valueOf(10.0d));

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(2, ((List<Object>) actualDescriptor).size());
    Object getResult = ((List<Object>) actualDescriptor).get(0);
    assertTrue(getResult instanceof Map);
    assertEquals(10.0d, ((Double) ((List<Object>) actualDescriptor).get(1)).doubleValue());
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturn42() throws JsonProcessingException {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setDescriptorValue(new POJONode("42"));
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("42", tbResource.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnEmpty() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    tbResourceInfo.setDescriptor(new ArrayNode(nf));
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertTrue(((List<Object>) actualDescriptor).isEmpty());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return first is {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return first is DEFAULT_SECRET_KEY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFirstIsDefault_secret_key()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.add(DataConstants.DEFAULT_SECRET_KEY);
    descriptor.add(DoubleNode.valueOf(10.0d));

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(2, ((List<Object>) actualDescriptor).size());
    assertEquals(10.0d, ((Double) ((List<Object>) actualDescriptor).get(1)).doubleValue());
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, ((List<Object>) actualDescriptor).get(0));
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return first is {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return first is 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnFirstIsPojo() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.addPOJO("Pojo");
    descriptor.add(DoubleNode.valueOf(10.0d));

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(2, ((List<Object>) actualDescriptor).size());
    assertEquals("Pojo", ((List<Object>) actualDescriptor).get(0));
    assertEquals(10.0d, ((Double) ((List<Object>) actualDescriptor).get(1)).doubleValue());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnSizeIsOne() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.add(DoubleNode.valueOf(10.0d));

    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(descriptor);
    Class<Object> type = Object.class;

    // Act
    Object actualDescriptor = tbResourceInfo.getDescriptor(type);

    // Assert
    assertTrue(actualDescriptor instanceof List);
    assertEquals(1, ((List<Double>) actualDescriptor).size());
    assertEquals(10.0d, ((List<Double>) actualDescriptor).get(0).doubleValue());
  }

  /**
   * Test {@link TbResourceInfo#getDescriptor(Class)} with {@code Class}.
   *
   * <ul>
   *   <li>Then return valueOf forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  @DisplayName("Test getDescriptor(Class) with 'Class'; then return valueOf forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbResourceInfo.getDescriptor(Class)"})
  void testGetDescriptorWithClass_thenReturnValueOfFortyTwo() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    BigInteger v = BigInteger.valueOf(42L);
    tbResourceInfo.setDescriptor(new BigIntegerNode(v));
    Class<Object> type = Object.class;

    // Act and Assert
    assertSame(v, tbResourceInfo.getDescriptor(type));
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    tbResourceInfo.setDescriptor(new ArrayNode(nf));
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
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor2() throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.add(DataConstants.DEFAULT_SECRET_KEY);
    descriptor.add(DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.addObject();
    descriptor.add(DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addPOJO {@code Pojo}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addPOJO 'Pojo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddPOJOPojo()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.addPOJO("Pojo");
    descriptor.add(DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>Given {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName("Test updateDescriptor(Class, UnaryOperator); given DEFAULT_SECRET_KEY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenDefault_secret_key() throws JsonProcessingException {
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
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>When {@link UnaryOperator} {@link UnaryOperator#apply(Object)} return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); given forty-two; when UnaryOperator apply(Object) return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenFortyTwo_whenUnaryOperatorApplyReturnFortyTwo()
      throws JsonProcessingException {
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
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link UnaryOperator} {@link UnaryOperator#apply(Object)} return {@code null}.
   *   <li>Then calls {@link UnaryOperator#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); given 'null'; when UnaryOperator apply(Object) return 'null'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenNull_whenUnaryOperatorApplyReturnNull_thenCallsApply()
      throws JsonProcessingException {
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link UnaryOperator} {@link UnaryOperator#apply(Object)} return one.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); given one; when UnaryOperator apply(Object) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_givenOne_whenUnaryOperatorApplyReturnOne()
      throws JsonProcessingException {
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
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}.
   *
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor BigDecimal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor BigDecimal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorBigDecimal()
      throws JsonProcessingException {
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
   *
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Binary.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Binary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Boolean.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Boolean")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorBoolean()
      throws JsonProcessingException {
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
   *
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Double.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Double")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor Float.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then not {@link TbResourceInfo#TbResourceInfo()} Descriptor iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResourceInfo() Descriptor iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceInfoDescriptorIteratorHasNext()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode descriptor = new ArrayNode(nf);
    descriptor.add(DoubleNode.valueOf(10.0d));

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
   *
   * <ul>
   *   <li>Then not {@link TbResource#TbResource(TbResourceId)} with id is {@link
   *       TbResourceId#TbResourceId(UUID)} Descriptor Int.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResource(TbResourceId) with id is TbResourceId(UUID) Descriptor Int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceWithIdIsTbResourceIdDescriptorInt()
      throws JsonProcessingException {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setDescriptorValue(42);
    Class<Object> type = Object.class;

    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResource.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResource.getDescriptor();
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
   *
   * <ul>
   *   <li>Then not {@link TbResource#TbResource(TbResourceId)} with id is {@link
   *       TbResourceId#TbResourceId(UUID)} Descriptor Null.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then not TbResource(TbResourceId) with id is TbResourceId(UUID) Descriptor Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenNotTbResourceWithIdIsTbResourceIdDescriptorNull()
      throws JsonProcessingException {
    // Arrange
    TbResourceId id = new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResource tbResource = new TbResource(id);
    tbResource.setDescriptorValue(new POJONode(null));
    Class<Object> type = Object.class;

    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResource.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResource.getDescriptor();
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
   *
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor Textual.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor Textual")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor traverse {@link
   *       TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  @DisplayName(
      "Test updateDescriptor(Class, UnaryOperator); then TbResourceInfo() Descriptor traverse TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.updateDescriptor(Class, UnaryOperator)"})
  void testUpdateDescriptor_thenTbResourceInfoDescriptorTraverseTreeTraversingParser()
      throws JsonProcessingException {
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
   *
   * <ul>
   *   <li>When {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName("Test setDescriptorValue(Object); when DEFAULT_SECRET_KEY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_whenDefault_secret_key() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(DataConstants.DEFAULT_SECRET_KEY);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName(
      "Test setDescriptorValue(Object); when forty-two; then TbResourceInfo() Descriptor IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_whenFortyTwo_thenTbResourceInfoDescriptorIntNode() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(42);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName(
      "Test setDescriptorValue(Object); when 'null'; then TbResourceInfo() Descriptor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName(
      "Test setDescriptorValue(Object); when one; then TbResourceInfo() Descriptor IntNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_whenOne_thenTbResourceInfoDescriptorIntNode() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(1);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
  }

  /**
   * Test {@link TbResourceInfo#setDescriptorValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then {@link TbResourceInfo#TbResourceInfo()} Descriptor {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  @DisplayName(
      "Test setDescriptorValue(Object); when 'Value'; then TbResourceInfo() Descriptor TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfo.setDescriptorValue(Object)"})
  void testSetDescriptorValue_whenValue_thenTbResourceInfoDescriptorTextNode() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue("Value");

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isNumber());
    assertTrue(descriptor.isTextual());
  }
}
