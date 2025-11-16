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
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TbResourceInfoEntityDiffblueTest {
  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}, and {@link TbResourceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoEntity#equals(Object)}
   *   <li>{@link TbResourceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
    assertEquals(tbResourceInfoEntity.hashCode(), tbResourceInfoEntity2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}, and {@link TbResourceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoEntity#equals(Object)}
   *   <li>{@link TbResourceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    tbResourceInfoEntity2.setDescriptor(null);
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
    assertEquals(tbResourceInfoEntity.hashCode(), tbResourceInfoEntity2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}, and {@link TbResourceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoEntity#equals(Object)}
   *   <li>{@link TbResourceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    tbResourceInfoEntity2.setEtag(null);
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
    assertEquals(tbResourceInfoEntity.hashCode(), tbResourceInfoEntity2.hashCode());
  }

  /**
   * Test {@link TbResourceInfoEntity#equals(Object)}, and {@link TbResourceInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbResourceInfoEntity#equals(Object)}
   *   <li>{@link TbResourceInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfoEntity tbResourceInfoEntity = new TbResourceInfoEntity();
    tbResourceInfoEntity.setCreatedTime(1L);
    tbResourceInfoEntity.setDescriptor(DoubleNode.valueOf(10.0d));
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbResourceInfoEntity.equals(Object)",
    "int TbResourceInfoEntity.hashCode()"
  })
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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbResourceInfoEntity.<init>()",
    "JsonNode TbResourceInfoEntity.getDescriptor()",
    "String TbResourceInfoEntity.getEtag()",
    "UUID TbResourceInfoEntity.getExternalId()",
    "String TbResourceInfoEntity.getFileName()",
    "Boolean TbResourceInfoEntity.getIsPublic()",
    "String TbResourceInfoEntity.getPublicResourceKey()",
    "String TbResourceInfoEntity.getResourceKey()",
    "String TbResourceInfoEntity.getResourceSubType()",
    "String TbResourceInfoEntity.getResourceType()",
    "String TbResourceInfoEntity.getSearchText()",
    "UUID TbResourceInfoEntity.getTenantId()",
    "String TbResourceInfoEntity.getTitle()",
    "void TbResourceInfoEntity.setDescriptor(JsonNode)",
    "void TbResourceInfoEntity.setEtag(String)",
    "void TbResourceInfoEntity.setExternalId(UUID)",
    "void TbResourceInfoEntity.setFileName(String)",
    "void TbResourceInfoEntity.setIsPublic(Boolean)",
    "void TbResourceInfoEntity.setPublicResourceKey(String)",
    "void TbResourceInfoEntity.setResourceKey(String)",
    "void TbResourceInfoEntity.setResourceSubType(String)",
    "void TbResourceInfoEntity.setResourceType(String)",
    "void TbResourceInfoEntity.setSearchText(String)",
    "void TbResourceInfoEntity.setTenantId(UUID)",
    "void TbResourceInfoEntity.setTitle(String)",
    "String TbResourceInfoEntity.toString()"
  })
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Dr", actualTbResourceInfoEntity.getTitle());
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Resource Sub Type", actualResourceSubType);
    assertEquals("Resource Type", actualResourceType);
    assertEquals("Search Text", actualSearchText);
    assertEquals(
        "TbResourceInfoEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=Resource"
            + " Type, resourceSubType=Resource Sub Type, resourceKey=Resource Key, searchText=Search Text, etag=Etag,"
            + " fileName=foo.txt, descriptor={\"isPublic\":true}, isPublic=true, publicResourceKey=Public Resource Key,"
            + " externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertNull(actualTbResourceInfoEntity.getId());
    assertNull(actualTbResourceInfoEntity.getUuid());
    assertEquals(0L, actualTbResourceInfoEntity.getCreatedTime());
    assertTrue(actualIsPublic);
    assertSame(descriptor, actualDescriptor);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   *
   * <p>Method under test: {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfoEntity.<init>(TbResourceInfo)"})
  public void testNewTbResourceInfoEntity() {
    // Arrange
    TbResourceInfo resource = new TbResourceInfo();
    resource.setResourceType(ResourceType.LWM2M_MODEL);
    resource.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity(resource);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualTbResourceInfoEntity.getTenantId().toString());
    assertNull(actualTbResourceInfoEntity.getResourceSubType());
    assertNull(actualTbResourceInfoEntity.getId());
    assertNull(actualTbResourceInfoEntity.getUuid());
    assertNull(actualTbResourceInfoEntity.getExternalId());
  }

  /**
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   *
   * <p>Method under test: {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfoEntity.<init>(TbResourceInfo)"})
  public void testNewTbResourceInfoEntity2() {
    // Arrange
    TbResourceInfo resource = new TbResourceInfo();
    resource.setExternalId(new TbResourceId(ModelConstants.NULL_UUID));
    resource.setResourceType(ResourceType.LWM2M_MODEL);
    resource.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity(resource);

    // Assert
    UUID externalId = actualTbResourceInfoEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertNull(actualTbResourceInfoEntity.getResourceSubType());
    assertNull(actualTbResourceInfoEntity.getId());
    assertNull(actualTbResourceInfoEntity.getUuid());
    assertSame(externalId, actualTbResourceInfoEntity.getTenantId());
  }

  /**
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   *
   * <p>Method under test: {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfoEntity.<init>(TbResourceInfo)"})
  public void testNewTbResourceInfoEntity3() {
    // Arrange
    TbResourceInfo resource = new TbResourceInfo();
    resource.setId(new TbResourceId(ModelConstants.NULL_UUID));
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
   * Test {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}.
   *
   * <ul>
   *   <li>Then return ResourceSubType is {@code IMAGE}.
   * </ul>
   *
   * <p>Method under test: {@link TbResourceInfoEntity#TbResourceInfoEntity(TbResourceInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbResourceInfoEntity.<init>(TbResourceInfo)"})
  public void testNewTbResourceInfoEntity_thenReturnResourceSubTypeIsImage() {
    // Arrange
    TbResourceInfo resource = new TbResourceInfo();
    resource.setResourceSubType(ResourceSubType.IMAGE);
    resource.setResourceType(ResourceType.LWM2M_MODEL);
    resource.setTenantId(new TenantId(ModelConstants.NULL_UUID));

    // Act
    TbResourceInfoEntity actualTbResourceInfoEntity = new TbResourceInfoEntity(resource);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualTbResourceInfoEntity.getTenantId().toString());
    assertEquals("IMAGE", actualTbResourceInfoEntity.getResourceSubType());
    assertNull(actualTbResourceInfoEntity.getId());
    assertNull(actualTbResourceInfoEntity.getUuid());
    assertNull(actualTbResourceInfoEntity.getExternalId());
  }
}
