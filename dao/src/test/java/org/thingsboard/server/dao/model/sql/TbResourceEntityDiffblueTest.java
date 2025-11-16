/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws UnsupportedEncodingException {
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
    assertEquals(tbResourceEntity.hashCode(), tbResourceEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData(null);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws UnsupportedEncodingException {
    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(DoubleNode.valueOf(10.0d));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13()
      throws UnsupportedEncodingException {
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
    tbResourceEntity.setPreview(null);
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27()
      throws UnsupportedEncodingException {
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbResourceEntity.equals(Object)", "int TbResourceEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws UnsupportedEncodingException {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Dr", actualTbResourceEntity.getTitle());
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Resource Sub Type", actualResourceSubType);
    assertEquals("Resource Type", actualResourceType);
    assertEquals("Search Text", actualSearchText);
    assertEquals(
        "TbResourceEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=Resource Type,"
            + " resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, fileName=foo.txt,"
            + " data=[65, 88, 65, 88, 65, 88, 65, 88], etag=Etag, descriptor={\"isPublic\":true}, preview=[65, 88, 65,"
            + " 88, 65, 88, 65, 88], isPublic=true, publicResourceKey=Public Resource Key, externalId=13814000-1dd2"
            + "-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertEquals(0L, actualTbResourceEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
    assertSame(descriptor, actualDescriptor);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualPreview);
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setTenantId(ModelConstants.SYSTEM_TENANT);
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity2() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setExternalId(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTbResourceEntity.getExternalId().toString());
    assertNull(actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getTenantId());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.
   *   <li>Then return ResourceSubType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity_givenLwm2mModel_thenReturnResourceSubTypeIsNull() {
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
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    UUID id = actualTbResourceEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getExternalId());
    assertNull(actualTbResourceEntity.getTenantId());
    assertSame(id, actualTbResourceEntity.getUuid());
  }

  /**
   * Test {@link TbResourceEntity#TbResourceEntity(TbResource)}.
   *
   * <ul>
   *   <li>Then return ResourceSubType is {@code IMAGE}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceEntity#TbResourceEntity(TbResource)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceEntity.<init>(TbResource)"})
  public void testNewTbResourceEntity_thenReturnResourceSubTypeIsImage() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceSubType(ResourceSubType.IMAGE);
    resource.setResourceType(ResourceType.LWM2M_MODEL);

    // Act
    TbResourceEntity actualTbResourceEntity = new TbResourceEntity(resource);

    // Assert
    assertEquals("IMAGE", actualTbResourceEntity.getResourceSubType());
    assertNull(actualTbResourceEntity.getId());
    assertNull(actualTbResourceEntity.getUuid());
    assertNull(actualTbResourceEntity.getExternalId());
    assertNull(actualTbResourceEntity.getTenantId());
  }
}
