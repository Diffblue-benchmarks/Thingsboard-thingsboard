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
package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntityRelation;

class EntityExportDataDiffblueTest {
  /**
   * Test {@link EntityExportData#sort()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityRelation#EntityRelation()}.
   *   <li>Then return Relations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName(
      "Test sort(); given ArrayList() add EntityRelation(); then return Relations is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenArrayListAddEntityRelation_thenReturnRelationsIsArrayList() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(relations);
    entityExportData.setAttributes(new HashMap<>());

    // Act and Assert
    assertSame(relations, entityExportData.sort().getRelations());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   *
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Relations is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return EntityType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName(
      "Test sort(); given EntityExportData (default constructor) Relations is ArrayList(); then return EntityType is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenEntityExportDataRelationsIsArrayList_thenReturnEntityTypeIsNull() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setAttributes(new HashMap<>());

    // Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualSortResult =
        entityExportData.sort();

    // Assert
    assertNull(actualSortResult.getEntityType());
    assertNull(actualSortResult.getEntity());
    assertFalse(actualSortResult.hasCredentials());
    assertTrue(actualSortResult.getAttributes().isEmpty());
    assertTrue(actualSortResult.hasAttributes());
    assertTrue(actualSortResult.hasRelations());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   *
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor).
   *   <li>Then return {@link EntityExportData} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName(
      "Test sort(); given EntityExportData (default constructor); then return EntityExportData (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenEntityExportData_thenReturnEntityExportData() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualSortResult =
        entityExportData.sort();

    // Assert
    assertSame(entityExportData, actualSortResult);
  }

  /**
   * Test {@link EntityExportData#sort()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link ArrayList#ArrayList()}.
   *   <li>Then return Attributes is {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName(
      "Test sort(); given HashMap() '42' is ArrayList(); then return Attributes is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenHashMap42IsArrayList_thenReturnAttributesIsHashMap() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.put("42", new ArrayList<>());
    attributes.put("Key", new ArrayList<>());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setAttributes(attributes);

    // Act and Assert
    assertSame(attributes, entityExportData.sort().getAttributes());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code Key} is {@link ArrayList#ArrayList()}.
   *   <li>Then return Attributes size is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName(
      "Test sort(); given HashMap() 'Key' is ArrayList(); then return Attributes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenHashMapKeyIsArrayList_thenReturnAttributesSizeIsOne() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.put("Key", new ArrayList<>());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setAttributes(attributes);

    // Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualSortResult =
        entityExportData.sort();

    // Assert
    Map<String, List<AttributeExportData>> attributes2 = actualSortResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertTrue(attributes2.get("Key").isEmpty());
    assertTrue(actualSortResult.getRelations().isEmpty());
    assertSame(attributes, attributes2);
  }

  /**
   * Test {@link EntityExportData#getExternalId()}.
   *
   * <p>Method under test: {@link EntityExportData#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityExportData.getExternalId()"})
  void testGetExternalId() {
    // Arrange
    Customer customer = new Customer(new CustomerId(EntityId.NULL_UUID));
    CustomerId externalId = new CustomerId(EntityId.NULL_UUID);
    customer.setExternalId(externalId);

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setEntity(customer);

    // Act and Assert
    assertSame(externalId, entityExportData.getExternalId());
  }

  /**
   * Test {@link EntityExportData#getExternalId()}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer(CustomerId)} with id is {@link
   *       CustomerId#CustomerId(UUID)} ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#getExternalId()}
   */
  @Test
  @DisplayName(
      "Test getExternalId(); given Customer(CustomerId) with id is CustomerId(UUID) ExternalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId EntityExportData.getExternalId()"})
  void testGetExternalId_givenCustomerWithIdIsCustomerIdExternalIdIsNull() {
    // Arrange
    CustomerId id = new CustomerId(EntityId.NULL_UUID);

    Customer customer = new Customer(id);
    customer.setExternalId(null);

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setEntity(customer);

    // Act and Assert
    assertSame(id, entityExportData.getExternalId());
  }

  /**
   * Test {@link EntityExportData#hasAttributes()}.
   *
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Attributes is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#hasAttributes()}
   */
  @Test
  @DisplayName(
      "Test hasAttributes(); given EntityExportData (default constructor) Attributes is HashMap(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.hasAttributes()"})
  void testHasAttributes_givenEntityExportDataAttributesIsHashMap_thenReturnTrue() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setAttributes(new HashMap<>());

    // Act and Assert
    assertTrue(entityExportData.hasAttributes());
  }

  /**
   * Test {@link EntityExportData#hasAttributes()}.
   *
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#hasAttributes()}
   */
  @Test
  @DisplayName(
      "Test hasAttributes(); given EntityExportData (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.hasAttributes()"})
  void testHasAttributes_givenEntityExportData_thenReturnFalse() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertFalse(entityExportData.hasAttributes());
  }

  /**
   * Test {@link EntityExportData#hasRelations()}.
   *
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Relations is {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#hasRelations()}
   */
  @Test
  @DisplayName(
      "Test hasRelations(); given EntityExportData (default constructor) Relations is ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.hasRelations()"})
  void testHasRelations_givenEntityExportDataRelationsIsArrayList_thenReturnTrue() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());

    // Act and Assert
    assertTrue(entityExportData.hasRelations());
  }

  /**
   * Test {@link EntityExportData#hasRelations()}.
   *
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#hasRelations()}
   */
  @Test
  @DisplayName(
      "Test hasRelations(); given EntityExportData (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.hasRelations()"})
  void testHasRelations_givenEntityExportData_thenReturnFalse() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertFalse(entityExportData.hasRelations());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}, and {@link EntityExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportData#equals(Object)}
   *   <li>{@link EntityExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData2 =
        new EntityExportData<>();

    // Act and Assert
    assertEquals(entityExportData, entityExportData2);
    assertEquals(entityExportData.hashCode(), entityExportData2.hashCode());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}, and {@link EntityExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportData#equals(Object)}
   *   <li>{@link EntityExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setAttributes(new HashMap<>());
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setEntityType(EntityType.TENANT);

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityExportData, deviceExportData);
    assertNotEquals(entityExportData.hashCode(), deviceExportData.hashCode());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}, and {@link EntityExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportData#equals(Object)}
   *   <li>{@link EntityExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertEquals(entityExportData, entityExportData);
    int expectedHashCodeResult = entityExportData.hashCode();
    assertEquals(expectedHashCodeResult, entityExportData.hashCode());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, 1);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, new DeviceExportData());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(new Device());
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setEntity(new Customer());

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(new Device());
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setEntityType(EntityType.TENANT);

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setEntityType(EntityType.CUSTOMER);

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setEntityType(EntityType.TENANT);

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setRelations(relations);
    entityExportData.setEntityType(EntityType.TENANT);

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.put("Key", new ArrayList<>());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();
    entityExportData.setAttributes(attributes);
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setEntityType(EntityType.TENANT);

    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, null);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData =
        new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, "Different type to EntityExportData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityExportData}
   *   <li>{@link EntityExportData#setAttributes(Map)}
   *   <li>{@link EntityExportData#setEntity(ExportableEntity)}
   *   <li>{@link EntityExportData#setEntityType(EntityType)}
   *   <li>{@link EntityExportData#setRelations(List)}
   *   <li>{@link EntityExportData#toString()}
   *   <li>{@link EntityExportData#getAttributes()}
   *   <li>{@link EntityExportData#getEntity()}
   *   <li>{@link EntityExportData#getEntityType()}
   *   <li>{@link EntityExportData#getRelations()}
   *   <li>{@link EntityExportData#hasCredentials()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityExportData.<init>()",
    "Map EntityExportData.getAttributes()",
    "ExportableEntity EntityExportData.getEntity()",
    "EntityType EntityExportData.getEntityType()",
    "List EntityExportData.getRelations()",
    "boolean EntityExportData.hasCredentials()",
    "void EntityExportData.setAttributes(Map)",
    "void EntityExportData.setEntity(ExportableEntity)",
    "void EntityExportData.setEntityType(EntityType)",
    "void EntityExportData.setRelations(List)",
    "String EntityExportData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualEntityExportData =
        new EntityExportData<>();
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    actualEntityExportData.setAttributes(attributes);
    Customer customer = new Customer();
    actualEntityExportData.setEntity(customer);
    actualEntityExportData.setEntityType(EntityType.TENANT);
    ArrayList<EntityRelation> relations = new ArrayList<>();
    actualEntityExportData.setRelations(relations);
    String actualToStringResult = actualEntityExportData.toString();
    Map<String, List<AttributeExportData>> actualAttributes =
        actualEntityExportData.getAttributes();
    ExportableEntity<? extends EntityId> actualEntity = actualEntityExportData.getEntity();
    EntityType actualEntityType = actualEntityExportData.getEntityType();
    List<EntityRelation> actualRelations = actualEntityExportData.getRelations();

    // Assert
    assertEquals(
        "EntityExportData(entity=Customer [title=null, tenantId=null, additionalInfo=null, country=null,"
            + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
            + " id=null], entityType=TENANT, relations=[], attributes={})",
        actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertFalse(actualEntityExportData.hasCredentials());
    assertTrue(actualRelations.isEmpty());
    assertTrue(actualAttributes.isEmpty());
    assertSame(relations, actualRelations);
    assertSame(attributes, actualAttributes);
    assertSame(customer, actualEntity);
  }
}
