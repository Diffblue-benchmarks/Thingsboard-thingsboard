package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;

class TbEntityActorIdDiffblueTest {
  /**
   * Test {@link TbEntityActorId#equals(Object)}, and {@link TbEntityActorId#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbEntityActorId#equals(Object)}
   *   <li>{@link TbEntityActorId#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbEntityActorId tbEntityActorId = new TbEntityActorId(entityId);
    AlarmId entityId2 = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbEntityActorId tbEntityActorId2 = new TbEntityActorId(entityId2);

    // Act and Assert
    assertEquals(tbEntityActorId, tbEntityActorId2);
    assertEquals(tbEntityActorId.hashCode(), tbEntityActorId2.hashCode());
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(null), null);
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(null), 1);
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbEntityActorId.equals(Object)", "int TbEntityActorId.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbEntityActorId tbEntityActorId = new TbEntityActorId(entityId);

    // Act and Assert
    assertNotEquals(tbEntityActorId, new TbEntityActorId(null));
  }

  /**
   * Test {@link TbEntityActorId#getEntityType()}.
   *
   * <ul>
   *   <li>Then return {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link TbEntityActorId#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType(); then return 'ALARM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType TbEntityActorId.getEntityType()"})
  void testGetEntityType_thenReturnAlarm() {
    // Arrange
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(EntityType.ALARM, new TbEntityActorId(entityId).getEntityType());
  }
}
