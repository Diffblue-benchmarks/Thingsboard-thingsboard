package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractEdgeEntityDiffblueTest {
  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and {@link AbstractEdgeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    assertEquals(edgeEntity.hashCode(), edgeEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and {@link AbstractEdgeEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(edgeEntity, assetEntity);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getVersion()).thenReturn(1L);
    when(edgeEntity2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(edgeEntity2.getCreatedTime()).thenReturn(1L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), null);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractEdgeEntity.equals(Object)",
    "int AbstractEdgeEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), "Different type to AbstractEdgeEntity");
  }
}
