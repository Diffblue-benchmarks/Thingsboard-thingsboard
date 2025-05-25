package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey;
import org.thingsboard.server.common.data.device.profile.AlarmConditionKeyType;

class SnapshotUpdateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SnapshotUpdate#SnapshotUpdate(AlarmConditionKeyType, Set)}
   *   <li>{@link SnapshotUpdate#getKeys()}
   *   <li>{@link SnapshotUpdate#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SnapshotUpdate.<init>(AlarmConditionKeyType, Set)", "Set SnapshotUpdate.getKeys()",
      "AlarmConditionKeyType SnapshotUpdate.getType()"})
  void testGettersAndSetters() {
    // Arrange
    HashSet<AlarmConditionFilterKey> keys = new HashSet<>();

    // Act
    SnapshotUpdate actualSnapshotUpdate = new SnapshotUpdate(AlarmConditionKeyType.ATTRIBUTE, keys);
    Set<AlarmConditionFilterKey> actualKeys = actualSnapshotUpdate.getKeys();

    // Assert
    assertEquals(AlarmConditionKeyType.ATTRIBUTE, actualSnapshotUpdate.getType());
    assertTrue(actualKeys.isEmpty());
    assertSame(keys, actualKeys);
  }

  /**
   * Test {@link SnapshotUpdate#hasUpdate()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnapshotUpdate#hasUpdate()}
   */
  @Test
  @DisplayName("Test hasUpdate(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnapshotUpdate.hasUpdate()"})
  void testHasUpdate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new SnapshotUpdate(AlarmConditionKeyType.ATTRIBUTE, new HashSet<>())).hasUpdate());
  }

  /**
   * Test {@link SnapshotUpdate#hasUpdate()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SnapshotUpdate#hasUpdate()}
   */
  @Test
  @DisplayName("Test hasUpdate(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SnapshotUpdate.hasUpdate()"})
  void testHasUpdate_thenReturnTrue() {
    // Arrange
    HashSet<AlarmConditionFilterKey> keys = new HashSet<>();
    keys.add(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertTrue((new SnapshotUpdate(AlarmConditionKeyType.ATTRIBUTE, keys)).hasUpdate());
  }
}
