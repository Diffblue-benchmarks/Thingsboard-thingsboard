package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class VersionLoadRequestDiffblueTest {
  /**
   * Test {@link VersionLoadRequest#canEqual(Object)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testCanEqual_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest2.setEntityTypes(entityTypes);
    entityTypeVersionLoadRequest2.setRollbackOnError(true);
    entityTypeVersionLoadRequest2.setVersionId("42");

    // Act and Assert
    assertTrue(entityTypeVersionLoadRequest.canEqual(entityTypeVersionLoadRequest2));
  }

  /**
   * Test {@link VersionLoadRequest#canEqual(Object)}.
   * <ul>
   *   <li>When {@link EntityTypeVersionLoadRequest} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when EntityTypeVersionLoadRequest (default constructor); then return 'true'")
  void testCanEqual_whenEntityTypeVersionLoadRequest_thenReturnTrue() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    // Act and Assert
    assertTrue(entityTypeVersionLoadRequest.canEqual(new EntityTypeVersionLoadRequest()));
  }

  /**
   * Test {@link VersionLoadRequest#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityTypeVersionLoadRequest()).canEqual("Other"));
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}, and
   * {@link VersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = new EntityTypeVersionLoadRequest();

    // Act and Assert
    assertEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
    int expectedHashCodeResult = entityTypeVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadRequest2.hashCode());
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}, and
   * {@link VersionLoadRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    // Act and Assert
    assertEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest);
    int expectedHashCodeResult = entityTypeVersionLoadRequest.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadRequest.hashCode());
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest = new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, singleEntityVersionLoadRequest);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn("42");
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setVersionId("42");
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn("42");
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setVersionId("1.0.2");
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 = mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn("42");
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityTypeVersionLoadRequest(), null);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityTypeVersionLoadRequest(), "Different type to VersionLoadRequest");
  }

  /**
   * Test {@link VersionLoadRequest#getVersionId()}.
   * <ul>
   *   <li>Given {@link EntityTypeVersionLoadRequest} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#getVersionId()}
   */
  @Test
  @DisplayName("Test getVersionId(); given EntityTypeVersionLoadRequest (default constructor)")
  void testGetVersionId_givenEntityTypeVersionLoadRequest() {
    // Arrange, Act and Assert
    assertNull((new EntityTypeVersionLoadRequest()).getVersionId());
  }

  /**
   * Test {@link VersionLoadRequest#getVersionId()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#getVersionId()}
   */
  @Test
  @DisplayName("Test getVersionId(); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testGetVersionId_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(entityTypes);

    // Act and Assert
    assertNull(entityTypeVersionLoadRequest.getVersionId());
  }

  /**
   * Test {@link VersionLoadRequest#setVersionId(String)}.
   * <ul>
   *   <li>Given {@link EntityTypeVersionLoadRequest} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#setVersionId(String)}
   */
  @Test
  @DisplayName("Test setVersionId(String); given EntityTypeVersionLoadRequest (default constructor)")
  void testSetVersionId_givenEntityTypeVersionLoadRequest() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    // Act
    entityTypeVersionLoadRequest.setVersionId("42");

    // Assert
    assertEquals("42", entityTypeVersionLoadRequest.getVersionId());
  }

  /**
   * Test {@link VersionLoadRequest#setVersionId(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionLoadRequest#setVersionId(String)}
   */
  @Test
  @DisplayName("Test setVersionId(String); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testSetVersionId_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(entityTypes);

    // Act
    entityTypeVersionLoadRequest.setVersionId("42");

    // Assert
    assertEquals("42", entityTypeVersionLoadRequest.getVersionId());
  }

  /**
   * Test {@link VersionLoadRequest#toString()}.
   * <p>
   * Method under test: {@link VersionLoadRequest#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityTypeVersionLoadRequest(entityTypes=null, rollbackOnError=false)",
        (new EntityTypeVersionLoadRequest()).toString());
  }

  /**
   * Test {@link VersionLoadRequest#toString()}.
   * <p>
   * Method under test: {@link VersionLoadRequest#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString2() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionLoadConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setEntityTypes(entityTypes);

    // Act and Assert
    assertEquals("EntityTypeVersionLoadRequest(entityTypes={}, rollbackOnError=false)",
        entityTypeVersionLoadRequest.toString());
  }
}
