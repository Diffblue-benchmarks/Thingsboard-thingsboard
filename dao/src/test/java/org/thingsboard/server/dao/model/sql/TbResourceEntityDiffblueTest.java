package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TbResourceEntityDiffblueTest {
  /**
   * Test {@link TbResourceEntity#equals(Object)}, and {@link TbResourceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceEntity#equals(Object)}
   *   <li>{@link TbResourceEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(tbResourceEntity, tbResourceEntity2);
    int expectedHashCodeResult = tbResourceEntity.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceEntity2.hashCode());
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}, and {@link TbResourceEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceEntity#equals(Object)}
   *   <li>{@link TbResourceEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(tbResourceEntity, tbResourceEntity);
    int expectedHashCodeResult = tbResourceEntity.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceEntity.hashCode());
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(3L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(DoubleNode.valueOf(10.0d));
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(null);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Dr");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag(null);
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(null);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("Dr");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName(null);
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(false);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(null);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Dr");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey(null);
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Dr");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey(null);
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Dr");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType(null);
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Dr");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType(null);
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Dr");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText(null);
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(null);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Mr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle(null);
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, null);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(tbResourceEntity, "Different type to TbResourceEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceEntity#TbResourceEntity()}
   *   <li>{@link TbResourceEntity#setData(byte[])}
   *   <li>{@link TbResourceEntity#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceEntity#setEtag(String)}
   *   <li>{@link TbResourceEntity#setExternalId(UUID)}
   *   <li>{@link TbResourceEntity#setFileName(String)}
   *   <li>{@link TbResourceEntity#setIsPublic(Boolean)}
   *   <li>{@link TbResourceEntity#setPreview(byte[])}
   *   <li>{@link TbResourceEntity#setPublicResourceKey(String)}
   *   <li>{@link TbResourceEntity#setResourceKey(String)}
   *   <li>{@link TbResourceEntity#setResourceSubType(String)}
   *   <li>{@link TbResourceEntity#setResourceType(String)}
   *   <li>{@link TbResourceEntity#setSearchText(String)}
   *   <li>{@link TbResourceEntity#setTenantId(UUID)}
   *   <li>{@link TbResourceEntity#setTitle(String)}
   *   <li>{@link TbResourceEntity#toString()}
   *   <li>{@link TbResourceEntity#getData()}
   *   <li>{@link TbResourceEntity#getDescriptor()}
   *   <li>{@link TbResourceEntity#getEtag()}
   *   <li>{@link TbResourceEntity#getExternalId()}
   *   <li>{@link TbResourceEntity#getFileName()}
   *   <li>{@link TbResourceEntity#getIsPublic()}
   *   <li>{@link TbResourceEntity#getPreview()}
   *   <li>{@link TbResourceEntity#getPublicResourceKey()}
   *   <li>{@link TbResourceEntity#getResourceKey()}
   *   <li>{@link TbResourceEntity#getResourceSubType()}
   *   <li>{@link TbResourceEntity#getResourceType()}
   *   <li>{@link TbResourceEntity#getSearchText()}
   *   <li>{@link TbResourceEntity#getTenantId()}
   *   <li>{@link TbResourceEntity#getTitle()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TbResourceEntity.<init>()",
    "byte[] TbResourceEntity.getData()",
    "JsonNode TbResourceEntity.getDescriptor()",
    "String TbResourceEntity.getEtag()",
    "UUID TbResourceEntity.getExternalId()",
    "String TbResourceEntity.getFileName()",
    "Boolean TbResourceEntity.getIsPublic()",
    "byte[] TbResourceEntity.getPreview()",
    "String TbResourceEntity.getPublicResourceKey()",
    "String TbResourceEntity.getResourceKey()",
    "String TbResourceEntity.getResourceSubType()",
    "String TbResourceEntity.getResourceType()",
    "String TbResourceEntity.getSearchText()",
    "UUID TbResourceEntity.getTenantId()",
    "String TbResourceEntity.getTitle()",
    "void TbResourceEntity.setData(byte[])",
    "void TbResourceEntity.setDescriptor(JsonNode)",
    "void TbResourceEntity.setEtag(String)",
    "void TbResourceEntity.setExternalId(UUID)",
    "void TbResourceEntity.setFileName(String)",
    "void TbResourceEntity.setIsPublic(Boolean)",
    "void TbResourceEntity.setPreview(byte[])",
    "void TbResourceEntity.setPublicResourceKey(String)",
    "void TbResourceEntity.setResourceKey(String)",
    "void TbResourceEntity.setResourceSubType(String)",
    "void TbResourceEntity.setResourceType(String)",
    "void TbResourceEntity.setSearchText(String)",
    "void TbResourceEntity.setTenantId(UUID)",
    "void TbResourceEntity.setTitle(String)",
    "String TbResourceEntity.toString()"
  })
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResourceEntity.setData(data);
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTbResourceEntity.setDescriptor(descriptor);
    actualTbResourceEntity.setEtag("Etag");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTbResourceEntity.setExternalId(externalId);
    actualTbResourceEntity.setFileName("foo.txt");
    actualTbResourceEntity.setIsPublic(true);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResourceEntity.setPreview(preview);
    actualTbResourceEntity.setPublicResourceKey("Public Resource Key");
    actualTbResourceEntity.setResourceKey("Resource Key");
    actualTbResourceEntity.setResourceSubType("Resource Sub Type");
    actualTbResourceEntity.setResourceType("Resource Type");
    actualTbResourceEntity.setSearchText("Search Text");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualTbResourceEntity.setTenantId(tenantId);
    actualTbResourceEntity.setTitle("Dr");
    String actualToStringResult = actualTbResourceEntity.toString();
    byte[] actualData = actualTbResourceEntity.getData();
    JsonNode actualDescriptor = actualTbResourceEntity.getDescriptor();
    String actualEtag = actualTbResourceEntity.getEtag();
    UUID actualExternalId = actualTbResourceEntity.getExternalId();
    String actualFileName = actualTbResourceEntity.getFileName();
    Boolean actualIsPublic = actualTbResourceEntity.getIsPublic();
    byte[] actualPreview = actualTbResourceEntity.getPreview();
    String actualPublicResourceKey = actualTbResourceEntity.getPublicResourceKey();
    String actualResourceKey = actualTbResourceEntity.getResourceKey();
    String actualResourceSubType = actualTbResourceEntity.getResourceSubType();
    String actualResourceType = actualTbResourceEntity.getResourceType();
    String actualSearchText = actualTbResourceEntity.getSearchText();
    UUID actualTenantId = actualTbResourceEntity.getTenantId();
    String actualTitle = actualTbResourceEntity.getTitle();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Resource Sub Type", actualResourceSubType);
    assertEquals("Resource Type", actualResourceType);
    assertEquals("Search Text", actualSearchText);
    assertEquals(
        "TbResourceEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, title=Dr, resourceType=Resource Type,"
            + " resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, fileName=foo.txt,"
            + " data=[65, 88, 65, 88, 65, 88, 65, 88], etag=Etag, descriptor={\"isPublic\":true}, preview=[65, 88, 65,"
            + " 88, 65, 88, 65, 88], isPublic=true, publicResourceKey=Public Resource Key, externalId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(descriptor, actualDescriptor);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPreview);
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    TbResource resource2 = new TbResource(resource);
    resource2.setId(null);
    resource2.setTenantId(ModelConstants.SYSTEM_TENANT);
    resource2.setResourceSubType(null);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource2);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTbResourceEntity.getTenantId().toString());
    assertNull(actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getExternalId());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity2() {
    // Arrange
    TbResource resource = new TbResource();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    resource.setExternalId(new TbResourceId(id));
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    TbResource resource2 = new TbResource(resource);
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    resource2.setId(new TbResourceId(id2));
    resource2.setTenantId(ModelConstants.SYSTEM_TENANT);
    resource2.setResourceSubType(null);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource2);

    // Assert
    UUID id3 = actualTbResourceEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    UUID externalId = actualTbResourceEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertSame(id2, id3);
    assertSame(id2, actualTbResourceEntity.getUuid());
    assertSame(id, externalId);
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <ul>
   *   <li>Given {@code IMAGE}.
   *   <li>Then return ResourceSubType is {@code IMAGE}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity_givenImage_thenReturnResourceSubTypeIsImage() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    TbResource resource2 = new TbResource(resource);
    resource2.setId(null);
    resource2.setTenantId(ModelConstants.SYSTEM_TENANT);
    resource2.setResourceSubType(ResourceSubType.IMAGE);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource2);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTbResourceEntity.getTenantId().toString());
    assertEquals("IMAGE", actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getExternalId());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity_givenLwm2mModel_thenReturnTenantIdIsNull() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    assertNull(actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getExternalId());
    assertNull(actualTbResourceEntity.getTenantId());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    TbResource resource2 = new TbResource(resource);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    resource2.setId(new TbResourceId(id));
    resource2.setTenantId(ModelConstants.SYSTEM_TENANT);
    resource2.setResourceSubType(null);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource2);

    // Assert
    UUID id2 = actualTbResourceEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualTbResourceEntity.getUuid());
  }
}
