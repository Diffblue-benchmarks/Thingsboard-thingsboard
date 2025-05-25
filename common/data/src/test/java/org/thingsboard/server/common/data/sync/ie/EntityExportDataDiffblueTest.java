package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityRelation#EntityRelation()}.</li>
   *   <li>Then return Relations is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName("Test sort(); given ArrayList() add EntityRelation(); then return Relations is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenArrayListAddEntityRelation_thenReturnRelationsIsArrayList() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(relations);
    entityExportData.setAttributes(null);

    // Act and Assert
    assertSame(relations, entityExportData.sort().getRelations());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Relations is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Attributes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName("Test sort(); given EntityExportData (default constructor) Relations is ArrayList(); then return Attributes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenEntityExportDataRelationsIsArrayList_thenReturnAttributesIsNull() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());
    entityExportData.setAttributes(null);

    // Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualSortResult = entityExportData.sort();

    // Assert
    assertNull(actualSortResult.getAttributes());
    assertFalse(actualSortResult.hasAttributes());
    assertTrue(actualSortResult.getRelations().isEmpty());
    assertTrue(actualSortResult.hasRelations());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Relations is {@code null}.</li>
   *   <li>Then return Attributes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName("Test sort(); given EntityExportData (default constructor) Relations is 'null'; then return Attributes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenEntityExportDataRelationsIsNull_thenReturnAttributesEmpty() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(null);
    entityExportData.setAttributes(new HashMap<>());

    // Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualSortResult = entityExportData.sort();

    // Assert
    assertNull(actualSortResult.getRelations());
    assertFalse(actualSortResult.hasRelations());
    assertTrue(actualSortResult.getAttributes().isEmpty());
    assertTrue(actualSortResult.hasAttributes());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor).</li>
   *   <li>Then return {@link EntityExportData} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName("Test sort(); given EntityExportData (default constructor); then return EntityExportData (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenEntityExportData_thenReturnEntityExportData() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertSame(entityExportData, entityExportData.sort());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Attributes is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName("Test sort(); given HashMap() '42' is ArrayList(); then return Attributes is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenHashMap42IsArrayList_thenReturnAttributesIsHashMap() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.put("42", new ArrayList<>());
    attributes.put("foo", new ArrayList<>());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(null);
    entityExportData.setAttributes(attributes);

    // Act and Assert
    assertSame(attributes, entityExportData.sort().getAttributes());
  }

  /**
   * Test {@link EntityExportData#sort()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Attributes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#sort()}
   */
  @Test
  @DisplayName("Test sort(); given HashMap() 'foo' is ArrayList(); then return Attributes size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData EntityExportData.sort()"})
  void testSort_givenHashMapFooIsArrayList_thenReturnAttributesSizeIsOne() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.put("foo", new ArrayList<>());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(null);
    entityExportData.setAttributes(attributes);

    // Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualSortResult = entityExportData.sort();

    // Assert
    assertNull(actualSortResult.getRelations());
    Map<String, List<AttributeExportData>> attributes2 = actualSortResult.getAttributes();
    assertEquals(1, attributes2.size());
    assertFalse(actualSortResult.hasRelations());
    assertTrue(attributes2.get("foo").isEmpty());
    assertTrue(actualSortResult.hasAttributes());
    assertSame(attributes, attributes2);
  }

  /**
   * Test {@link EntityExportData#getExternalId()}.
   * <p>
   * Method under test: {@link EntityExportData#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId EntityExportData.getExternalId()"})
  void testGetExternalId() {
    // Arrange
    Customer customer = new Customer();
    CustomerId externalId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customer.setExternalId(externalId);
    customer.setId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setEntity(customer);

    // Act and Assert
    assertSame(externalId, entityExportData.getExternalId());
  }

  /**
   * Test {@link EntityExportData#getExternalId()}.
   * <ul>
   *   <li>Given {@link Customer#Customer()} ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId(); given Customer() ExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId EntityExportData.getExternalId()"})
  void testGetExternalId_givenCustomerExternalIdIsNull() {
    // Arrange
    Customer customer = new Customer();
    customer.setExternalId(null);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    customer.setId(customerId);

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setEntity(customer);

    // Act and Assert
    assertSame(customerId, entityExportData.getExternalId());
  }

  /**
   * Test {@link EntityExportData#hasAttributes()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Attributes is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#hasAttributes()}
   */
  @Test
  @DisplayName("Test hasAttributes(); given EntityExportData (default constructor) Attributes is HashMap(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.hasAttributes()"})
  void testHasAttributes_givenEntityExportDataAttributesIsHashMap_thenReturnTrue() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setAttributes(new HashMap<>());

    // Act and Assert
    assertTrue(entityExportData.hasAttributes());
  }

  /**
   * Test {@link EntityExportData#hasAttributes()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#hasAttributes()}
   */
  @Test
  @DisplayName("Test hasAttributes(); given EntityExportData (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.hasAttributes()"})
  void testHasAttributes_givenEntityExportData_thenReturnFalse() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertFalse(entityExportData.hasAttributes());
  }

  /**
   * Test {@link EntityExportData#hasRelations()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor) Relations is {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#hasRelations()}
   */
  @Test
  @DisplayName("Test hasRelations(); given EntityExportData (default constructor) Relations is ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.hasRelations()"})
  void testHasRelations_givenEntityExportDataRelationsIsArrayList_thenReturnTrue() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());

    // Act and Assert
    assertTrue(entityExportData.hasRelations());
  }

  /**
   * Test {@link EntityExportData#hasRelations()}.
   * <ul>
   *   <li>Given {@link EntityExportData} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#hasRelations()}
   */
  @Test
  @DisplayName("Test hasRelations(); given EntityExportData (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.hasRelations()"})
  void testHasRelations_givenEntityExportData_thenReturnFalse() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertFalse(entityExportData.hasRelations());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}, and {@link EntityExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportData#equals(Object)}
   *   <li>{@link EntityExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData2 = new EntityExportData<>();

    // Act and Assert
    assertEquals(entityExportData, entityExportData2);
    int expectedHashCodeResult = entityExportData.hashCode();
    assertEquals(expectedHashCodeResult, entityExportData2.hashCode());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}, and {@link EntityExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportData#equals(Object)}
   *   <li>{@link EntityExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setAttributes(new HashMap<>());
    entityExportData.setRelations(new ArrayList<>());
    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(null);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(entityExportData, deviceExportData);
    int notExpectedHashCodeResult = entityExportData.hashCode();
    assertNotEquals(notExpectedHashCodeResult, deviceExportData.hashCode());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}, and {@link EntityExportData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportData#equals(Object)}
   *   <li>{@link EntityExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertEquals(entityExportData, entityExportData);
    int expectedHashCodeResult = entityExportData.hashCode();
    assertEquals(expectedHashCodeResult, entityExportData.hashCode());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, 1);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, new DeviceExportData());
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(null);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(new ArrayList<>());
    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(null);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setRelations(relations);
    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(null);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    attributes.put("foo", new ArrayList<>());

    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();
    entityExportData.setAttributes(attributes);
    entityExportData.setRelations(new ArrayList<>());
    DeviceExportData deviceExportData = mock(DeviceExportData.class);
    when(deviceExportData.getAttributes()).thenReturn(new HashMap<>());
    when(deviceExportData.getRelations()).thenReturn(new ArrayList<>());
    when(deviceExportData.getEntityType()).thenReturn(null);
    when(deviceExportData.getEntity()).thenReturn(null);
    when(deviceExportData.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityExportData, deviceExportData);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, null);
  }

  /**
   * Test {@link EntityExportData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityExportData.equals(Object)", "int EntityExportData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityExportData = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityExportData, "Different type to EntityExportData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityExportData.<init>()", "Map EntityExportData.getAttributes()",
      "ExportableEntity EntityExportData.getEntity()", "EntityType EntityExportData.getEntityType()",
      "List EntityExportData.getRelations()", "boolean EntityExportData.hasCredentials()",
      "void EntityExportData.setAttributes(Map)", "void EntityExportData.setEntity(ExportableEntity)",
      "void EntityExportData.setEntityType(EntityType)", "void EntityExportData.setRelations(List)",
      "String EntityExportData.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityExportData<ExportableEntity<? extends EntityId>> actualEntityExportData = new EntityExportData<>();
    HashMap<String, List<AttributeExportData>> attributes = new HashMap<>();
    actualEntityExportData.setAttributes(attributes);
    Customer customer = new Customer();
    actualEntityExportData.setEntity(customer);
    actualEntityExportData.setEntityType(EntityType.TENANT);
    ArrayList<EntityRelation> relations = new ArrayList<>();
    actualEntityExportData.setRelations(relations);
    String actualToStringResult = actualEntityExportData.toString();
    Map<String, List<AttributeExportData>> actualAttributes = actualEntityExportData.getAttributes();
    ExportableEntity<? extends EntityId> actualEntity = actualEntityExportData.getEntity();
    EntityType actualEntityType = actualEntityExportData.getEntityType();
    List<EntityRelation> actualRelations = actualEntityExportData.getRelations();

    // Assert
    assertEquals("EntityExportData(entity=Customer [title=null, tenantId=null, additionalInfo=null, country=null,"
        + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
        + " id=null], entityType=TENANT, relations=[], attributes={})", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertFalse(actualEntityExportData.hasCredentials());
    assertTrue(actualRelations.isEmpty());
    assertTrue(actualAttributes.isEmpty());
    assertSame(relations, actualRelations);
    assertSame(attributes, actualAttributes);
    assertSame(customer, actualEntity);
  }
}
