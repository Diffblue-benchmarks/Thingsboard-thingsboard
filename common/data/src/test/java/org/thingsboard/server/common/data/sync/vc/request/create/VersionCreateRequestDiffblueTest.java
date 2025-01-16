package org.thingsboard.server.common.data.sync.vc.request.create;

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

class VersionCreateRequestDiffblueTest {
  /**
   * Test {@link VersionCreateRequest#canEqual(Object)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testCanEqual_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();
    complexVersionCreateRequest2.setBranch("janedoe/featurebranch");
    complexVersionCreateRequest2.setEntityTypes(entityTypes);
    complexVersionCreateRequest2.setSyncStrategy(SyncStrategy.MERGE);
    complexVersionCreateRequest2.setVersionName("1.0.2");

    // Act and Assert
    assertTrue(complexVersionCreateRequest.canEqual(complexVersionCreateRequest2));
  }

  /**
   * Test {@link VersionCreateRequest#canEqual(Object)}.
   * <ul>
   *   <li>When {@link ComplexVersionCreateRequest} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when ComplexVersionCreateRequest (default constructor); then return 'true'")
  void testCanEqual_whenComplexVersionCreateRequest_thenReturnTrue() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act and Assert
    assertTrue(complexVersionCreateRequest.canEqual(new ComplexVersionCreateRequest()));
  }

  /**
   * Test {@link VersionCreateRequest#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new ComplexVersionCreateRequest()).canEqual("Other"));
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}, and
   * {@link VersionCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    ComplexVersionCreateRequest complexVersionCreateRequest2 = new ComplexVersionCreateRequest();

    // Act and Assert
    assertEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
    int expectedHashCodeResult = complexVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, complexVersionCreateRequest2.hashCode());
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}, and
   * {@link VersionCreateRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act and Assert
    assertEquals(complexVersionCreateRequest, complexVersionCreateRequest);
    int expectedHashCodeResult = complexVersionCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, complexVersionCreateRequest.hashCode());
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    VersionCreateConfig config = new VersionCreateConfig();
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);

    SingleEntityVersionCreateRequest singleEntityVersionCreateRequest = new SingleEntityVersionCreateRequest();
    singleEntityVersionCreateRequest.setBranch("janedoe/featurebranch");
    singleEntityVersionCreateRequest.setConfig(config);
    singleEntityVersionCreateRequest.setEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionCreateRequest.setVersionName("1.0.2");

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, singleEntityVersionCreateRequest);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    ComplexVersionCreateRequest complexVersionCreateRequest2 = mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    ComplexVersionCreateRequest complexVersionCreateRequest2 = mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn(null);
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setVersionName("1.0.2");
    ComplexVersionCreateRequest complexVersionCreateRequest2 = mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setVersionName("Version Name");
    ComplexVersionCreateRequest complexVersionCreateRequest2 = mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn("1.0.2");
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");
    ComplexVersionCreateRequest complexVersionCreateRequest2 = mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn(null);
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setBranch("Branch");
    ComplexVersionCreateRequest complexVersionCreateRequest2 = mock(ComplexVersionCreateRequest.class);
    when(complexVersionCreateRequest2.getBranch()).thenReturn("janedoe/featurebranch");
    when(complexVersionCreateRequest2.getVersionName()).thenReturn(null);
    when(complexVersionCreateRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(complexVersionCreateRequest2.getSyncStrategy()).thenReturn(SyncStrategy.MERGE);
    when(complexVersionCreateRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(complexVersionCreateRequest, complexVersionCreateRequest2);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComplexVersionCreateRequest(), null);
  }

  /**
   * Test {@link VersionCreateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComplexVersionCreateRequest(), "Different type to VersionCreateRequest");
  }

  /**
   * Test {@link VersionCreateRequest#getBranch()}.
   * <ul>
   *   <li>Given {@link ComplexVersionCreateRequest} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#getBranch()}
   */
  @Test
  @DisplayName("Test getBranch(); given ComplexVersionCreateRequest (default constructor)")
  void testGetBranch_givenComplexVersionCreateRequest() {
    // Arrange, Act and Assert
    assertNull((new ComplexVersionCreateRequest()).getBranch());
  }

  /**
   * Test {@link VersionCreateRequest#getBranch()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#getBranch()}
   */
  @Test
  @DisplayName("Test getBranch(); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testGetBranch_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setEntityTypes(entityTypes);

    // Act and Assert
    assertNull(complexVersionCreateRequest.getBranch());
  }

  /**
   * Test {@link VersionCreateRequest#getVersionName()}.
   * <ul>
   *   <li>Given {@link ComplexVersionCreateRequest} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#getVersionName()}
   */
  @Test
  @DisplayName("Test getVersionName(); given ComplexVersionCreateRequest (default constructor)")
  void testGetVersionName_givenComplexVersionCreateRequest() {
    // Arrange, Act and Assert
    assertNull((new ComplexVersionCreateRequest()).getVersionName());
  }

  /**
   * Test {@link VersionCreateRequest#getVersionName()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#getVersionName()}
   */
  @Test
  @DisplayName("Test getVersionName(); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testGetVersionName_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setEntityTypes(entityTypes);

    // Act and Assert
    assertNull(complexVersionCreateRequest.getVersionName());
  }

  /**
   * Test {@link VersionCreateRequest#setBranch(String)}.
   * <ul>
   *   <li>Given {@link ComplexVersionCreateRequest} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#setBranch(String)}
   */
  @Test
  @DisplayName("Test setBranch(String); given ComplexVersionCreateRequest (default constructor)")
  void testSetBranch_givenComplexVersionCreateRequest() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");

    // Assert
    assertEquals("janedoe/featurebranch", complexVersionCreateRequest.getBranch());
  }

  /**
   * Test {@link VersionCreateRequest#setBranch(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#setBranch(String)}
   */
  @Test
  @DisplayName("Test setBranch(String); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testSetBranch_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setEntityTypes(entityTypes);

    // Act
    complexVersionCreateRequest.setBranch("janedoe/featurebranch");

    // Assert
    assertEquals("janedoe/featurebranch", complexVersionCreateRequest.getBranch());
  }

  /**
   * Test {@link VersionCreateRequest#setVersionName(String)}.
   * <ul>
   *   <li>Given {@link ComplexVersionCreateRequest} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#setVersionName(String)}
   */
  @Test
  @DisplayName("Test setVersionName(String); given ComplexVersionCreateRequest (default constructor)")
  void testSetVersionName_givenComplexVersionCreateRequest() {
    // Arrange
    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();

    // Act
    complexVersionCreateRequest.setVersionName("1.0.2");

    // Assert
    assertEquals("1.0.2", complexVersionCreateRequest.getVersionName());
  }

  /**
   * Test {@link VersionCreateRequest#setVersionName(String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code TENANT} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#setVersionName(String)}
   */
  @Test
  @DisplayName("Test setVersionName(String); given HashMap() computeIfPresent 'TENANT' and BiFunction")
  void testSetVersionName_givenHashMapComputeIfPresentTenantAndBiFunction() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setEntityTypes(entityTypes);

    // Act
    complexVersionCreateRequest.setVersionName("1.0.2");

    // Assert
    assertEquals("1.0.2", complexVersionCreateRequest.getVersionName());
  }

  /**
   * Test {@link VersionCreateRequest#toString()}.
   * <p>
   * Method under test: {@link VersionCreateRequest#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("ComplexVersionCreateRequest(syncStrategy=null, entityTypes=null)",
        (new ComplexVersionCreateRequest()).toString());
  }

  /**
   * Test {@link VersionCreateRequest#toString()}.
   * <ul>
   *   <li>Then return {@code ComplexVersionCreateRequest(syncStrategy=null,
   * entityTypes={})}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionCreateRequest#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'ComplexVersionCreateRequest(syncStrategy=null, entityTypes={})'")
  void testToString_thenReturnComplexVersionCreateRequestSyncStrategyNullEntityTypes() {
    // Arrange
    HashMap<EntityType, EntityTypeVersionCreateConfig> entityTypes = new HashMap<>();
    entityTypes.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));

    ComplexVersionCreateRequest complexVersionCreateRequest = new ComplexVersionCreateRequest();
    complexVersionCreateRequest.setEntityTypes(entityTypes);

    // Act and Assert
    assertEquals("ComplexVersionCreateRequest(syncStrategy=null, entityTypes={})",
        complexVersionCreateRequest.toString());
  }
}
