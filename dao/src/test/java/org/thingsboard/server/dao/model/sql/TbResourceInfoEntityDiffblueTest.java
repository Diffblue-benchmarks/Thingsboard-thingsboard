package org.thingsboard.server.dao.model.sql;

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

public class TbResourceInfoEntityDiffblueTest {
  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}, and
   * {@link TbResourceInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoEntity#equals(Object)}
   *   <li>{@link TbResourceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
    int expectedHashCodeResult = tbResourceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfoEntity2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}, and
   * {@link TbResourceInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoEntity#equals(Object)}
   *   <li>{@link TbResourceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(tbResourceInfoEntity, tbResourceInfoEntity);
    int expectedHashCodeResult = tbResourceInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfoEntity.hashCode());
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(3L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(MissingNode.getInstance());
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(null);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(mock(JsonNode.class));
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Dr");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag(null);
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(UUID.randomUUID());
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(null);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("Dr");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName(null);
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(false);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(null);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Dr");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey(null);
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Dr");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey(null);
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Dr");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType(null);
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Dr");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType(null);
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Dr");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText(null);
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(UUID.randomUUID());
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(null);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Mr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle(null);
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    TbResourceInfoEntity tbResourceInfoEntity2 = new TbResourceInfoEntity();
    tbResourceInfoEntity2.setCreatedTime(1L);
    tbResourceInfoEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity2.setEtag("Etag");
    tbResourceInfoEntity2.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setFileName("foo.txt");
    tbResourceInfoEntity2.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setIsPublic(true);
    tbResourceInfoEntity2.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity2.setResourceKey("Resource Key");
    tbResourceInfoEntity2.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity2.setResourceType("Resource Type");
    tbResourceInfoEntity2.setSearchText("Search Text");
    tbResourceInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity2.setTitle("Dr");
    tbResourceInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, tbResourceInfoEntity2);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, null);
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceInfoEntity.setEtag("Etag");
    tbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setFileName("foo.txt");
    tbResourceInfoEntity.setId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setIsPublic(true);
    tbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    tbResourceInfoEntity.setResourceKey("Resource Key");
    tbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    tbResourceInfoEntity.setResourceType("Resource Type");
    tbResourceInfoEntity.setSearchText("Search Text");
    tbResourceInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceInfoEntity.setTitle("Dr");
    tbResourceInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tbResourceInfoEntity, "Different type to TbResourceInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfoEntity#TbResourceInfoEntity()}
   *   <li>{@link TbResourceInfoEntity#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfoEntity#setEtag(String)}
   *   <li>{@link TbResourceInfoEntity#setExternalId(UUID)}
   *   <li>{@link TbResourceInfoEntity#setFileName(String)}
   *   <li>{@link TbResourceInfoEntity#setIsPublic(Boolean)}
   *   <li>{@link TbResourceInfoEntity#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfoEntity#setResourceKey(String)}
   *   <li>{@link TbResourceInfoEntity#setResourceSubType(String)}
   *   <li>{@link TbResourceInfoEntity#setResourceType(String)}
   *   <li>{@link TbResourceInfoEntity#setSearchText(String)}
   *   <li>{@link TbResourceInfoEntity#setTenantId(UUID)}
   *   <li>{@link TbResourceInfoEntity#setTitle(String)}
   *   <li>{@link TbResourceInfoEntity#toString()}
   *   <li>{@link TbResourceInfoEntity#getDescriptor()}
   *   <li>{@link TbResourceInfoEntity#getEtag()}
   *   <li>{@link TbResourceInfoEntity#getExternalId()}
   *   <li>{@link TbResourceInfoEntity#getFileName()}
   *   <li>{@link TbResourceInfoEntity#getIsPublic()}
   *   <li>{@link TbResourceInfoEntity#getPublicResourceKey()}
   *   <li>{@link TbResourceInfoEntity#getResourceKey()}
   *   <li>{@link TbResourceInfoEntity#getResourceSubType()}
   *   <li>{@link TbResourceInfoEntity#getResourceType()}
   *   <li>{@link TbResourceInfoEntity#getSearchText()}
   *   <li>{@link TbResourceInfoEntity#getTenantId()}
   *   <li>{@link TbResourceInfoEntity#getTitle()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity();
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualTbResourceInfoEntity.setDescriptor(descriptor);
    actualTbResourceInfoEntity.setEtag("Etag");
    actualTbResourceInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    actualTbResourceInfoEntity.setFileName("foo.txt");
    actualTbResourceInfoEntity.setIsPublic(true);
    actualTbResourceInfoEntity.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfoEntity.setResourceKey("Resource Key");
    actualTbResourceInfoEntity.setResourceSubType("Resource Sub Type");
    actualTbResourceInfoEntity.setResourceType("Resource Type");
    actualTbResourceInfoEntity.setSearchText("Search Text");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualTbResourceInfoEntity.setTenantId(tenantId);
    actualTbResourceInfoEntity.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfoEntity.toString();
    JsonNode actualDescriptor = actualTbResourceInfoEntity.getDescriptor();
    String actualEtag = actualTbResourceInfoEntity.getEtag();
    UUID actualExternalId = actualTbResourceInfoEntity.getExternalId();
    String actualFileName = actualTbResourceInfoEntity.getFileName();
    Boolean actualIsPublic = actualTbResourceInfoEntity.getIsPublic();
    String actualPublicResourceKey = actualTbResourceInfoEntity.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfoEntity.getResourceKey();
    String actualResourceSubType = actualTbResourceInfoEntity.getResourceSubType();
    String actualResourceType = actualTbResourceInfoEntity.getResourceType();
    String actualSearchText = actualTbResourceInfoEntity.getSearchText();
    UUID actualTenantId = actualTbResourceInfoEntity.getTenantId();
    String actualTitle = actualTbResourceInfoEntity.getTitle();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Resource Sub Type", actualResourceSubType);
    assertEquals("Resource Type", actualResourceType);
    assertEquals("Search Text", actualSearchText);
    assertEquals("TbResourceInfoEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=Resource"
        + " Type, resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, etag=Etag,"
        + " fileName=foo.txt, descriptor={\"isPublic\":true}, isPublic=true, publicResourceKey=Public Resource Key,"
        + " externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceInfoEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(descriptor, actualDescriptor);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   * <p>
   * Method under test:
   * {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  public void testNewTbResourceInfoEntity() {
    // Arrange
    TbResource resource = new TbResource(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setExternalId(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceType(ResourceType.LWM2M_MODEL);
    resource.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity(resource);

    // Assert
    UUID externalId = actualTbResourceInfoEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertSame(externalId, actualTbResourceInfoEntity.getId());
    assertSame(externalId, actualTbResourceInfoEntity.getUuid());
    assertSame(externalId, actualTbResourceInfoEntity.getTenantId());
  }

  /**
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   * <ul>
   *   <li>Given {@code IMAGE}.</li>
   *   <li>Then return ResourceSubType is {@code IMAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  public void testNewTbResourceInfoEntity_givenImage_thenReturnResourceSubTypeIsImage() {
    // Arrange
    TbResource resource = new TbResource(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceSubType(ResourceSubType.IMAGE);
    resource.setResourceType(ResourceType.LWM2M_MODEL);
    resource.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity(resource);

    // Assert
    UUID id = actualTbResourceInfoEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("IMAGE", actualTbResourceInfoEntity.getResourceSubType());
    assertNull(actualTbResourceInfoEntity.getExternalId());
    assertSame(id, actualTbResourceInfoEntity.getUuid());
    assertSame(id, actualTbResourceInfoEntity.getTenantId());
  }

  /**
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.</li>
   *   <li>Then return ResourceSubType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  public void testNewTbResourceInfoEntity_givenLwm2mModel_thenReturnResourceSubTypeIsNull() {
    // Arrange
    TbResource resource = new TbResource(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceType(ResourceType.LWM2M_MODEL);
    resource.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity(resource);

    // Assert
    UUID id = actualTbResourceInfoEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualTbResourceInfoEntity.getResourceSubType());
    assertNull(actualTbResourceInfoEntity.getExternalId());
    assertSame(id, actualTbResourceInfoEntity.getUuid());
    assertSame(id, actualTbResourceInfoEntity.getTenantId());
  }

  /**
   * Test {@link TbResourceInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResourceInfo#isPublic()} return
   * {@code false}.</li>
   *   <li>Then return not Public.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#toData()}
   */
  @Test
  public void testToData_givenTbResourceIsPublicReturnFalse_thenReturnNotPublic() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(false);
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
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResourceInfo actualToDataResult = (new TbResourceInfoEntity(resource)).toData();

    // Assert
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
    verify(resource).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    assertEquals(ResourceSubType.IMAGE, actualToDataResult.getResourceSubType());
    assertFalse(actualToDataResult.isPublic());
    assertEquals(tbResourceId, actualToDataResult.getExternalId());
  }

  /**
   * Test {@link TbResourceInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link TbResource} {@link TbResourceInfo#isPublic()} return
   * {@code true}.</li>
   *   <li>Then return ResourceSubType is {@code IMAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#toData()}
   */
  @Test
  public void testToData_givenTbResourceIsPublicReturnTrue_thenReturnResourceSubTypeIsImage() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(true);
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
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResourceInfo actualToDataResult = (new TbResourceInfoEntity(resource)).toData();

    // Assert
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
    verify(resource).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    assertEquals(ResourceSubType.IMAGE, actualToDataResult.getResourceSubType());
    assertTrue(actualToDataResult.isPublic());
    assertEquals(tbResourceId, actualToDataResult.getExternalId());
  }

  /**
   * Test {@link TbResourceInfoEntity#toData()}.
   * <ul>
   *   <li>Then Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenDescriptorIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(true);
    when(resource.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(resource.getEtag()).thenReturn("Etag");
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getPublicResourceKey()).thenReturn("Public Resource Key");
    when(resource.getResourceKey()).thenReturn("Resource Key");
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getResourceSubType()).thenReturn(ResourceSubType.IMAGE);
    when(resource.getExternalId()).thenReturn(new TbResourceId(null));
    when(resource.getTitle()).thenReturn("Dr");
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getCreatedTime()).thenReturn(1L);
    TbResourceId tbResourceId = new TbResourceId(ModelConstants.NULL_UUID);
    when(resource.getId()).thenReturn(tbResourceId);
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResourceInfo actualToDataResult = (new TbResourceInfoEntity(resource)).toData();

    // Assert
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
    verify(resource).getTenantId();
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
  }

  /**
   * Test {@link TbResourceInfoEntity#toData()}.
   * <ul>
   *   <li>Then return ResourceSubType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbResourceInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnResourceSubTypeIsNull() {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.isPublic()).thenReturn(true);
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
    when(resource.getResourceType()).thenReturn(ResourceType.LWM2M_MODEL);
    when(resource.getCreatedTime()).thenReturn(1L);
    when(resource.getId()).thenReturn(new TbResourceId(ModelConstants.NULL_UUID));
    when(resource.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbResourceInfo actualToDataResult = (new TbResourceInfoEntity(resource)).toData();

    // Assert
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
    verify(resource).getTenantId();
    verify(resource).getTitle();
    verify(resource).isPublic();
    assertNull(actualToDataResult.getResourceSubType());
    assertTrue(actualToDataResult.isPublic());
    assertEquals(tbResourceId, actualToDataResult.getExternalId());
  }
}
