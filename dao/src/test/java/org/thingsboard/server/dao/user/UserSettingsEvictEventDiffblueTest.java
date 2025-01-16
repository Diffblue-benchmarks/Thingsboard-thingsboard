package org.thingsboard.server.dao.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserSettingsEvictEventDiffblueTest {
  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}, and
   * {@link UserSettingsEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEvictEvent#equals(Object)}
   *   <li>{@link UserSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(new UserSettingsCompositeKey());
    UserSettingsEvictEvent userSettingsEvictEvent2 = new UserSettingsEvictEvent(new UserSettingsCompositeKey());

    // Act and Assert
    assertEquals(userSettingsEvictEvent, userSettingsEvictEvent2);
    int expectedHashCodeResult = userSettingsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEvictEvent2.hashCode());
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}, and
   * {@link UserSettingsEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsEvictEvent#equals(Object)}
   *   <li>{@link UserSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(new UserSettingsCompositeKey());

    // Act and Assert
    assertEquals(userSettingsEvictEvent, userSettingsEvictEvent);
    int expectedHashCodeResult = userSettingsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEvictEvent.hashCode());
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(null);

    // Act and Assert
    assertNotEquals(userSettingsEvictEvent, new UserSettingsEvictEvent(new UserSettingsCompositeKey()));
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(
        new UserSettingsCompositeKey(ModelConstants.NULL_UUID, "Type"));

    // Act and Assert
    assertNotEquals(userSettingsEvictEvent, new UserSettingsEvictEvent(new UserSettingsCompositeKey()));
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(mock(UserSettingsCompositeKey.class));

    // Act and Assert
    assertNotEquals(userSettingsEvictEvent, new UserSettingsEvictEvent(new UserSettingsCompositeKey()));
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsEvictEvent(new UserSettingsCompositeKey()), null);
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsEvictEvent(new UserSettingsCompositeKey()),
        "Different type to UserSettingsEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link UserSettingsEvictEvent#UserSettingsEvictEvent(UserSettingsCompositeKey)}
   *   <li>{@link UserSettingsEvictEvent#getKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    UserSettingsCompositeKey key = new UserSettingsCompositeKey();

    // Act and Assert
    assertSame(key, (new UserSettingsEvictEvent(key)).getKey());
  }
}
