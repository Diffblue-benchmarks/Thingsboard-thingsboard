package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;

class VersionLoadRequestDiffblueTest {
  /**
   * Test {@link VersionLoadRequest#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link EntityTypeVersionLoadRequest} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when EntityTypeVersionLoadRequest (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadRequest.canEqual(Object)"})
  void testCanEqual_whenEntityTypeVersionLoadRequest_thenReturnTrue() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    // Act and Assert
    assertTrue(entityTypeVersionLoadRequest.canEqual(new EntityTypeVersionLoadRequest()));
  }

  /**
   * Test {@link VersionLoadRequest#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionLoadRequest.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityTypeVersionLoadRequest().canEqual("Other"));
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}, and {@link VersionLoadRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
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
   * Test {@link VersionLoadRequest#equals(Object)}, and {@link VersionLoadRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    VersionLoadConfig config = new VersionLoadConfig();
    config.setLoadAttributes(true);
    config.setLoadCredentials(true);
    config.setLoadRelations(true);

    SingleEntityVersionLoadRequest singleEntityVersionLoadRequest =
        new SingleEntityVersionLoadRequest();
    singleEntityVersionLoadRequest.setConfig(config);
    singleEntityVersionLoadRequest.setExternalEntityId(TenantId.SYS_TENANT_ID);
    singleEntityVersionLoadRequest.setVersionId("42");

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, singleEntityVersionLoadRequest);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 =
        mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn(null);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 =
        mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn("42");
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setVersionId("42");
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 =
        mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn(null);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();
    entityTypeVersionLoadRequest.setVersionId("42");
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest2 =
        mock(EntityTypeVersionLoadRequest.class);
    when(entityTypeVersionLoadRequest2.isRollbackOnError()).thenReturn(true);
    when(entityTypeVersionLoadRequest2.getVersionId()).thenReturn("42");
    when(entityTypeVersionLoadRequest2.getEntityTypes()).thenReturn(new HashMap<>());
    when(entityTypeVersionLoadRequest2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadRequest, entityTypeVersionLoadRequest2);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityTypeVersionLoadRequest(), null);
  }

  /**
   * Test {@link VersionLoadRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link VersionLoadRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean VersionLoadRequest.equals(Object)",
    "int VersionLoadRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityTypeVersionLoadRequest(), "Different type to VersionLoadRequest");
  }

  /**
   * Test {@link VersionLoadRequest#getVersionId()}.
   *
   * <p>Method under test: {@link VersionLoadRequest#getVersionId()}
   */
  @Test
  @DisplayName("Test getVersionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VersionLoadRequest.getVersionId()"})
  void testGetVersionId() {
    // Arrange, Act and Assert
    assertNull(new EntityTypeVersionLoadRequest().getVersionId());
  }

  /**
   * Test {@link VersionLoadRequest#setVersionId(String)}.
   *
   * <p>Method under test: {@link VersionLoadRequest#setVersionId(String)}
   */
  @Test
  @DisplayName("Test setVersionId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionLoadRequest.setVersionId(String)"})
  void testSetVersionId() {
    // Arrange
    EntityTypeVersionLoadRequest entityTypeVersionLoadRequest = new EntityTypeVersionLoadRequest();

    // Act
    entityTypeVersionLoadRequest.setVersionId("42");

    // Assert
    assertEquals("42", entityTypeVersionLoadRequest.getVersionId());
  }

  /**
   * Test {@link VersionLoadRequest#toString()}.
   *
   * <p>Method under test: {@link VersionLoadRequest#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VersionLoadRequest.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityTypeVersionLoadRequest(entityTypes=null, rollbackOnError=false)",
        new EntityTypeVersionLoadRequest().toString());
  }
}
