package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AlarmCommentInfoEntityDiffblueTest {
  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and {@link AlarmCommentInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmCommentInfoEntity.equals(Object)", "int AlarmCommentInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();
    AlarmCommentInfoEntity alarmCommentInfoEntity2 = new AlarmCommentInfoEntity();

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity2);
    int expectedHashCodeResult = alarmCommentInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}, and {@link AlarmCommentInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#equals(Object)}
   *   <li>{@link AlarmCommentInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmCommentInfoEntity.equals(Object)", "int AlarmCommentInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = new AlarmCommentInfoEntity();

    // Act and Assert
    assertEquals(alarmCommentInfoEntity, alarmCommentInfoEntity);
    int expectedHashCodeResult = alarmCommentInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfoEntity.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmCommentInfoEntity.equals(Object)", "int AlarmCommentInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfoEntity(), null);
  }

  /**
   * Test {@link AlarmCommentInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmCommentInfoEntity.equals(Object)", "int AlarmCommentInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfoEntity(), "Different type to AlarmCommentInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfoEntity#AlarmCommentInfoEntity()}
   *   <li>{@link AlarmCommentInfoEntity#setEmail(String)}
   *   <li>{@link AlarmCommentInfoEntity#setFirstName(String)}
   *   <li>{@link AlarmCommentInfoEntity#setLastName(String)}
   *   <li>{@link AlarmCommentInfoEntity#toString()}
   *   <li>{@link AlarmCommentInfoEntity#getEmail()}
   *   <li>{@link AlarmCommentInfoEntity#getFirstName()}
   *   <li>{@link AlarmCommentInfoEntity#getLastName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlarmCommentInfoEntity.<init>()", "String AlarmCommentInfoEntity.getEmail()",
      "String AlarmCommentInfoEntity.getFirstName()", "String AlarmCommentInfoEntity.getLastName()",
      "void AlarmCommentInfoEntity.setEmail(String)", "void AlarmCommentInfoEntity.setFirstName(String)",
      "void AlarmCommentInfoEntity.setLastName(String)", "String AlarmCommentInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentInfoEntity actualAlarmCommentInfoEntity = new AlarmCommentInfoEntity();
    actualAlarmCommentInfoEntity.setEmail("jane.doe@example.org");
    actualAlarmCommentInfoEntity.setFirstName("Jane");
    actualAlarmCommentInfoEntity.setLastName("Doe");
    String actualToStringResult = actualAlarmCommentInfoEntity.toString();
    String actualEmail = actualAlarmCommentInfoEntity.getEmail();
    String actualFirstName = actualAlarmCommentInfoEntity.getFirstName();

    // Assert
    assertEquals("AlarmCommentInfoEntity(firstName=Jane, lastName=Doe, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Doe", actualAlarmCommentInfoEntity.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertNull(actualAlarmCommentInfoEntity.getComment());
    assertNull(actualAlarmCommentInfoEntity.getId());
    assertNull(actualAlarmCommentInfoEntity.getUuid());
    assertNull(actualAlarmCommentInfoEntity.getAlarmId());
    assertNull(actualAlarmCommentInfoEntity.getUserId());
    assertNull(actualAlarmCommentInfoEntity.getType());
    assertEquals(0L, actualAlarmCommentInfoEntity.getCreatedTime());
  }
}
