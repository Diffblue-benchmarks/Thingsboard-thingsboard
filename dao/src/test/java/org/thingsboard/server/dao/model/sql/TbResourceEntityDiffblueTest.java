package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TbResourceEntityDiffblueTest {
  /**
   * Test {@link TbResourceEntity#equals(Object)}, and
   * {@link TbResourceEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceEntity#equals(Object)}
   *   <li>{@link TbResourceEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tbResourceEntity, tbResourceEntity2);
    int expectedHashCodeResult = tbResourceEntity.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceEntity2.hashCode());
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}, and
   * {@link TbResourceEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceEntity#equals(Object)}
   *   <li>{@link TbResourceEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tbResourceEntity, tbResourceEntity);
    int expectedHashCodeResult = tbResourceEntity.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceEntity.hashCode());
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(3L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(MissingNode.getInstance());
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(null);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(mock(JsonNode.class));
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Dr");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag(null);
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(UUID.randomUUID());
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(null);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("Dr");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName(null);
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(false);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(null);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Dr");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey(null);
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Dr");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey(null);
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Dr");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType(null);
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Dr");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType(null);
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Dr");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText(null);
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(UUID.randomUUID());
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(null);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Mr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle(null);
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceEntity tbResourceEntity2 = new TbResourceEntity();
    tbResourceEntity2.setCreatedTime(1L);
    tbResourceEntity2.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity2.setEtag("Etag");
    tbResourceEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setFileName("foo.txt");
    tbResourceEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setIsPublic(true);
    tbResourceEntity2.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceEntity2.setResourceKey("Resource Key");
    tbResourceEntity2.setResourceSubType("Resource Sub Type");
    tbResourceEntity2.setResourceType("Resource Type");
    tbResourceEntity2.setSearchText("Search Text");
    tbResourceEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity2.setTitle("Dr");
    tbResourceEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, tbResourceEntity2);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, null);
  }

  /**
   * Test {@link TbResourceEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceEntity, "Different type to TbResourceEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResourceEntity.setData(data);
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTbResourceEntity.setDescriptor(descriptor);
    actualTbResourceEntity.setEtag("Etag");
    actualTbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    actualTbResourceEntity.setFileName("foo.txt");
    actualTbResourceEntity.setIsPublic(true);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResourceEntity.setPreview(preview);
    actualTbResourceEntity.setPublicResourceKey("Public Resource Key");
    actualTbResourceEntity.setResourceKey("Resource Key");
    actualTbResourceEntity.setResourceSubType("Resource Sub Type");
    actualTbResourceEntity.setResourceType("Resource Type");
    actualTbResourceEntity.setSearchText("Search Text");
    UUID tenantId = ModelConstants.NULL_UUID;
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

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Resource Sub Type", actualResourceSubType);
    assertEquals("Resource Type", actualResourceType);
    assertEquals("Search Text", actualSearchText);
    assertEquals("TbResourceEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=Resource Type,"
        + " resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, fileName=foo.txt,"
        + " data=[65, 88, 65, 88, 65, 88, 65, 88], etag=Etag, descriptor={\"isPublic\":true}, preview=[65, 88, 65,"
        + " 88, 65, 88, 65, 88], isPublic=true, publicResourceKey=Public Resource Key, externalId=13814000-1dd2"
        + "-11b2-8080-808080808080)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
    assertSame(descriptor, actualDescriptor);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   * <p>
   * Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  public void testNewTbResourceEntity() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setExternalId(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTbResourceEntity.getExternalId().toString());
    assertEquals("LWM2M_MODEL", actualTbResourceEntity.getResourceType());
    assertNull(actualTbResourceEntity.getData());
    assertNull(actualTbResourceEntity.getPreview());
    assertNull(actualTbResourceEntity.getDescriptor());
    assertNull(actualTbResourceEntity.getEtag());
    assertNull(actualTbResourceEntity.getFileName());
    assertNull(actualTbResourceEntity.getPublicResourceKey());
    assertNull(actualTbResourceEntity.getResourceKey());
    assertNull(actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getSearchText());
    assertNull(actualTbResourceEntity.getTitle());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getTenantId());
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertFalse(actualTbResourceEntity.getIsPublic());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   * <ul>
   *   <li>Given {@code IMAGE}.</li>
   *   <li>Then return ResourceSubType is {@code IMAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  public void testNewTbResourceEntity_givenImage_thenReturnResourceSubTypeIsImage() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceSubType(ResourceSubType.IMAGE);
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    assertEquals("IMAGE", actualTbResourceEntity.getResourceSubType());
    assertEquals("LWM2M_MODEL", actualTbResourceEntity.getResourceType());
    assertNull(actualTbResourceEntity.getData());
    assertNull(actualTbResourceEntity.getPreview());
    assertNull(actualTbResourceEntity.getDescriptor());
    assertNull(actualTbResourceEntity.getEtag());
    assertNull(actualTbResourceEntity.getFileName());
    assertNull(actualTbResourceEntity.getPublicResourceKey());
    assertNull(actualTbResourceEntity.getResourceKey());
    assertNull(actualTbResourceEntity.getSearchText());
    assertNull(actualTbResourceEntity.getTitle());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getExternalId());
    assertNull(actualTbResourceEntity.getTenantId());
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertFalse(actualTbResourceEntity.getIsPublic());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.</li>
   *   <li>Then return ResourceSubType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  public void testNewTbResourceEntity_givenLwm2mModel_thenReturnResourceSubTypeIsNull() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    assertEquals("LWM2M_MODEL", actualTbResourceEntity.getResourceType());
    assertNull(actualTbResourceEntity.getData());
    assertNull(actualTbResourceEntity.getPreview());
    assertNull(actualTbResourceEntity.getDescriptor());
    assertNull(actualTbResourceEntity.getEtag());
    assertNull(actualTbResourceEntity.getFileName());
    assertNull(actualTbResourceEntity.getPublicResourceKey());
    assertNull(actualTbResourceEntity.getResourceKey());
    assertNull(actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getSearchText());
    assertNull(actualTbResourceEntity.getTitle());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getExternalId());
    assertNull(actualTbResourceEntity.getTenantId());
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertFalse(actualTbResourceEntity.getIsPublic());
  }

  /**
   * Test {@link TbResourceEntity#toData()}.
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResourceInfo#isPublic()} return
   * {@code false}.</li>
   *   <li>Then return not Public.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#toData()}
   */
  @Test
  public void testToData_givenTbResourceIsPublicReturnFalse_thenReturnNotPublic() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(false);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(resource.getEtag()).thenReturn("Etag");
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(resource.getExternalId()).thenReturn(tbResourceId);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResource actualToDataResult = (new TbResourceEntity(resource)).toData();

    // Assert
    verify(resource).getData();
    verify(resource).getPreview();
    verify(resource).getCreatedTime();
    verify(resource).getDescriptor();
    verify(resource).getEtag();
    verify(resource).getExternalId();
    verify(resource).getFileName();
    verify(resource, atLeast(1)).getId();
    verify(resource).getPublicResourceKey();
    verify(resource).getResourceKey();
    verify(resource, atLeast(1)).getResourceSubType();
    verify(resource).getResourceType();
    verify(resource).getSearchText();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    assertEquals(ResourceSubType.IMAGE, actualToDataResult.getResourceSubType());
    assertFalse(actualToDataResult.isPublic());
    assertEquals(tbResourceId, actualToDataResult.getExternalId());
  }

  /**
   * Test {@link TbResourceEntity#toData()}.
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResourceInfo#isPublic()} return
   * {@code true}.</li>
   *   <li>Then return ResourceSubType is {@code IMAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#toData()}
   */
  @Test
  public void testToData_givenTbResourceIsPublicReturnTrue_thenReturnResourceSubTypeIsImage()
      throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(true);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(resource.getEtag()).thenReturn("Etag");
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(resource.getExternalId()).thenReturn(tbResourceId);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResource actualToDataResult = (new TbResourceEntity(resource)).toData();

    // Assert
    verify(resource).getData();
    verify(resource).getPreview();
    verify(resource).getCreatedTime();
    verify(resource).getDescriptor();
    verify(resource).getEtag();
    verify(resource).getExternalId();
    verify(resource).getFileName();
    verify(resource, atLeast(1)).getId();
    verify(resource).getPublicResourceKey();
    verify(resource).getResourceKey();
    verify(resource, atLeast(1)).getResourceSubType();
    verify(resource).getResourceType();
    verify(resource).getSearchText();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    assertEquals(ResourceSubType.IMAGE, actualToDataResult.getResourceSubType());
    assertTrue(actualToDataResult.isPublic());
    assertEquals(tbResourceId, actualToDataResult.getExternalId());
  }

  /**
   * Test {@link TbResourceEntity#toData()}.
   * <ul>
   *   <li>Then Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#toData()}
   */
  @Test
  public void testToData_thenDescriptorIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(true);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(resource.getEtag()).thenReturn("Etag");
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(resource.getExternalId()).thenReturn(new TbResourceId(null));
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(resource.getId()).thenReturn(tbResourceId);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResource actualToDataResult = (new TbResourceEntity(resource)).toData();

    // Assert
    verify(resource).getData();
    verify(resource).getPreview();
    verify(resource).getCreatedTime();
    verify(resource).getDescriptor();
    verify(resource).getEtag();
    verify(resource).getExternalId();
    verify(resource).getFileName();
    verify(resource, atLeast(1)).getId();
    verify(resource).getPublicResourceKey();
    verify(resource).getResourceKey();
    verify(resource, atLeast(1)).getResourceSubType();
    verify(resource).getResourceType();
    verify(resource).getSearchText();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    JsonNode descriptor = actualToDataResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualToDataResult.getUuidId().toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getSearchText());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals("Etag", actualToDataResult.getEtag());
    assertEquals("Public Resource Key", actualToDataResult.getPublicResourceKey());
    assertEquals("QVhBWEFYQVg=", actualToDataResult.getEncodedData());
    assertEquals("QVhBWEFYQVg=", actualToDataResult.getEncodedPreview());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Resource Key", actualToDataResult.getResourceKey());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("foo.txt", actualToDataResult.getFileName());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualToDataResult.getLink());
    assertNull(actualToDataResult.getPublicLink());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(ResourceSubType.IMAGE, actualToDataResult.getResourceSubType());
    assertEquals(ResourceType.LWM2M_MODEL, actualToDataResult.getResourceType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(actualToDataResult.isPublic());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(tbResourceId, actualToDataResult.getId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualToDataResult.getData());
    byte[] expectedPreview = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedPreview, actualToDataResult.getPreview());
  }

  /**
   * Test {@link TbResourceEntity#toData()}.
   * <ul>
   *   <li>Then return ResourceSubType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceEntity#toData()}
   */
  @Test
  public void testToData_thenReturnResourceSubTypeIsNull() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(true);
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getPreview()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(resource.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(resource.getEtag()).thenReturn("Etag");
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getResourceSubType()).thenReturn(null);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(resource.getExternalId()).thenReturn(tbResourceId);
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResource actualToDataResult = (new TbResourceEntity(resource)).toData();

    // Assert
    verify(resource).getData();
    verify(resource).getPreview();
    verify(resource).getCreatedTime();
    verify(resource).getDescriptor();
    verify(resource).getEtag();
    verify(resource).getExternalId();
    verify(resource).getFileName();
    verify(resource, atLeast(1)).getId();
    verify(resource).getPublicResourceKey();
    verify(resource).getResourceKey();
    verify(resource).getResourceSubType();
    verify(resource).getResourceType();
    verify(resource).getSearchText();
    verify(resource, atLeast(1)).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    assertNull(actualToDataResult.getResourceSubType());
    assertTrue(actualToDataResult.isPublic());
    assertEquals(tbResourceId, actualToDataResult.getExternalId());
  }
}
